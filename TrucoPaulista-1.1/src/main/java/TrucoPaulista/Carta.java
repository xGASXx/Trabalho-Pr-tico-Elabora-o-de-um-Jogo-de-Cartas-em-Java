package TrucoPaulista;

import java.util.Arrays;

public class Carta {
    private String naipe;
    private String valor;
    private boolean manilha;

    private static final String[] valoresOrdenados = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "3"};

    public Carta(String naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
        this.manilha = false;
    }

    public String getNaipe() {
        return naipe;
    }

    public String getValor() {
        return valor;
    }

    public boolean isManilha() {
        return manilha;
    }

    public void setManilha(boolean manilha) {
        this.manilha = manilha;
    }

    @Override
    public String toString() {
        return valor + " de " + naipe + (manilha ? " (Manilha)" : "");
    }

    // Método para determinar se a carta atual vence outra carta
    public boolean vence(Carta outraCarta) {
        int valorAtualIndex = Arrays.asList(valoresOrdenados).indexOf(this.valor);
        int outraValorIndex = Arrays.asList(valoresOrdenados).indexOf(outraCarta.valor);

        if (valorAtualIndex > outraValorIndex) {
            return true;
        } else if (valorAtualIndex < outraValorIndex) {
            return false;
        } else {
            // Se os valores forem iguais, compara pelo naipe
            return comparaNaipe(outraCarta);
        }
    }

    private boolean comparaNaipe(Carta outraCarta) {
        String[] ordemNaipe = {"Paus", "Copas", "Espadas", "Ouros"};
        int indiceNaipeAtual = Arrays.asList(ordemNaipe).indexOf(this.naipe);
        int indiceOutraNaipe = Arrays.asList(ordemNaipe).indexOf(outraCarta.naipe);

        return indiceNaipeAtual > indiceOutraNaipe;
    }
}