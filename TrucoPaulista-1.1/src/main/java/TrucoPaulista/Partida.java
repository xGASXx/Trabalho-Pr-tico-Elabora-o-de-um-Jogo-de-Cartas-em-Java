package TrucoPaulista;

import java.util.List;

public class Partida {
    private Mesa mesa;
    private List<Jogador> jogadores;

    public Partida(List<Jogador> jogadores) {
        this.jogadores = jogadores;
        this.mesa = new Mesa(jogadores);
    }

    public void iniciar() {
        while (mesa.getPontosDuplas()[0] < 12 && mesa.getPontosDuplas()[1] < 12) {
            mesa.iniciarRodada();
            Carta cartaVirada = mesa.virarCarta();
            System.out.println("Carta virada: " + cartaVirada);

            // Aqui utilizamos a RodadaFactory para criar a rodada de acordo com o tipo desejado
            Rodada rodada = RodadaFactory.criarRodada("normal", mesa);
            rodada.jogar();

            // Mostrar o estado após cada rodada
            mesa.mostrarEstado();
        }

        System.out.println("Dupla vencedora: " + (mesa.getPontosDuplas()[0] >= 12 ? "Dupla 1" : "Dupla 2"));
    }

    public static void main(String[] args) {
        List<Jogador> jogadores = List.of(
            new Jogador("Jogador 1"),
            new Jogador("Jogador 2"),
            new Jogador("Jogador 3"),
            new Jogador("Jogador 4")
        );

        // Definindo as duplas
        jogadores.get(0).setDupla(1);
        jogadores.get(1).setDupla(2);
        jogadores.get(2).setDupla(1);
        jogadores.get(3).setDupla(2);

        Partida partida = new Partida(jogadores);
        partida.iniciar();
    }
}
