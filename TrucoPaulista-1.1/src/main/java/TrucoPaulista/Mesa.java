package TrucoPaulista;

import java.util.Arrays;
import java.util.List;

public class Mesa {
    private List<Jogador> jogadores;
    private Baralho baralho;
    private int[] pontosDuplas;
    private int rodadaAtual;

    public Mesa(List<Jogador> jogadores) {
        this.jogadores = jogadores;
        this.baralho = new Baralho();
        this.pontosDuplas = new int[2];
        this.rodadaAtual = 0;
    }

    public void iniciarRodada() {
        baralho.embaralhar();
        for (Jogador jogador : jogadores) {
            jogador.getMao().clear();
            for (int i = 0; i < 3; i++) {
                jogador.adicionarCarta(baralho.distribuirCarta());
            }
        }
    }

    public Carta virarCarta() {
        Carta cartaVirada = baralho.virarCarta();
        definirManilha(cartaVirada.getValor());
        return cartaVirada;
    }

    private void definirManilha(String valorVirado) {
        String[] valoresOrdenados = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "1"};
        int indexVirado = Arrays.asList(valoresOrdenados).indexOf(valorVirado);
        int indexManilha = (indexVirado + 1) % valoresOrdenados.length;
        String valorManilha = valoresOrdenados[indexManilha];

        for (Jogador jogador : jogadores) {
            for (Carta carta : jogador.getMao()) {
                if (carta.getValor().equals(valorManilha)) {
                    carta.setManilha(true);
                }
            }
        }
    }

    public void atualizarPontos(int dupla, int pontos) {
        pontosDuplas[dupla - 1] += pontos;
    }

    public int[] getPontosDuplas() {
        return pontosDuplas;
    }

    public void mostrarEstado() {
        for (Jogador jogador : jogadores) {
            System.out.println(jogador.getNome() + ": " + jogador.getMao());
        }

        Jogador vencedorTurno = determinarVencedorTurno();
        int duplaVencedora = vencedorTurno.getDupla();
        System.out.println("Dupla vencedora do Rodada: Dupla " + duplaVencedora);

        System.out.println("Pontos totais: Dupla 1 - " + pontosDuplas[0] + ", Dupla 2 - " + pontosDuplas[1]);
        System.out.println("--------------------------------------------");
    }

    Jogador determinarVencedorTurno() {
        Jogador jogadorVencedor = null;
        Carta melhorCarta = null;

        for (Jogador jogador : jogadores) {
            Carta cartaJogada = jogador.getMao().get(0); // Considera a primeira carta como a jogada
            if (melhorCarta == null || cartaJogada.vence(melhorCarta)) {
                melhorCarta = cartaJogada;
                jogadorVencedor = jogador;
            }
        }

        return jogadorVencedor;
    }
}