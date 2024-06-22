package TrucoPaulista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho {
    public List<Carta> cartas;
    public int indiceAtual;

    public Baralho() {
        cartas = new ArrayList<>();
        String[] naipes = {"Ouros", "Espadas", "Copas", "Paus"};
        String[] valores = {"4", "5", "6", "7", "Q", "J", "K", "A", "2", "1"};
        for (String valor : valores) {
            for (String naipe : naipes) {
                cartas.add(new Carta(naipe, valor));
            }
        }
        embaralhar();
    }

    public void embaralhar() {
        Collections.shuffle(cartas);
        indiceAtual = 0;
    }

    public Carta distribuirCarta() {
        if (indiceAtual < cartas.size()) {
            return cartas.get(indiceAtual++);
        }
        return null;
    }

    public boolean temCartas() {
        return indiceAtual < cartas.size();
    }

    public Carta virarCarta() {
        return cartas.get(indiceAtual);
    }
}