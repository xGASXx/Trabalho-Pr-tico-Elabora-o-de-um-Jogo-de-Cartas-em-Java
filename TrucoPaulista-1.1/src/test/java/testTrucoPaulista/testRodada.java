package testTrucoPaulista;

import TrucoPaulista.Jogador;
import TrucoPaulista.Mesa;
import TrucoPaulista.Rodada;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testRodada {

    private Mesa mesa;
    private List<Jogador> jogadores;

    @BeforeEach
    void setUp() {
        jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Jogador 1"));
        jogadores.add(new Jogador("Jogador 2"));
        jogadores.add(new Jogador("Jogador 3"));
        jogadores.add(new Jogador("Jogador 4"));

        // Definindo as duplas
        jogadores.get(0).setDupla(1);
        jogadores.get(1).setDupla(2);
        jogadores.get(2).setDupla(1);
        jogadores.get(3).setDupla(2);

        mesa = new Mesa(jogadores);
    }

    @Test
    void testRodadaNormal() {
        Rodada rodada = RodadaFactory.criarRodada("normal", mesa);
        rodada.jogar();

        assertEquals(1, rodada.getPontos());
        // Adicione mais verificações específicas para RodadaNormal, se necessário
    }

    @Test
    void testRodadaTruco() {
        Rodada rodada = RodadaFactory.criarRodada("truco", mesa);
        rodada.jogar();

        assertEquals(3, rodada.getPontos());
        // Adicione mais verificações específicas para RodadaTruco, se necessário
    }

    @Test
    void testRodadaSeis() {
        Rodada rodada = RodadaFactory.criarRodada("seis", mesa);
        rodada.jogar();

        assertEquals(6, rodada.getPontos());
        // Adicione mais verificações específicas para RodadaSeis, se necessário
    }

    @Test
    void testRodadaNove() {
        Rodada rodada = RodadaFactory.criarRodada("nove", mesa);
        rodada.jogar();

        assertEquals(9, rodada.getPontos());
        // Adicione mais verificações específicas para RodadaNove, se necessário
    }

    @Test
    void testRodadaDoze() {
        Rodada rodada = RodadaFactory.criarRodada("doze", mesa);
        rodada.jogar();

        assertEquals(12, rodada.getPontos());
        // Adicione mais verificações específicas para RodadaDoze, se necessário
    }
}
