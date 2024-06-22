package TrucoPaulista;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private List<Carta> mao;
    private int pontos;
    private int dupla; // 1 para Dupla 1, 2 para Dupla 2

    public Jogador(String nome) {
        this.nome = nome;
        this.mao = new ArrayList<>();
        this.pontos = 0;
        this.dupla = 0; // Inicialmente nenhum
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public void adicionarCarta(Carta carta) {
        mao.add(carta);
    }

    public void removerCarta(Carta carta) {
        mao.remove(carta);
    }

    public void adicionarPontos(int pontos) {
        this.pontos += pontos;
    }

    public int getPontos() {
        return pontos;
    }

    public int getDupla() {
        return dupla;
    }

    public void setDupla(int dupla) {
        this.dupla = dupla;
    }

    @Override
    public String toString() {
        return nome;
    }
}