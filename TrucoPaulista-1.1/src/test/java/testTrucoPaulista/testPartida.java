package testTrucoPaulista;

import TrucoPaulista.Jogador;
import TrucoPaulista.Partida;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class testPartida {
    
    private List<Jogador> jogadores;
    private Partida partida;

    @BeforeEach
    public void setUp() {
        jogadores = Arrays.asList(
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

        partida = new Partida(jogadores);
    }

    @Test
    public void testIniciarPartida() {
        partida.iniciar();

        // Verifica se algum jogador possui 12 pontos ou mais
        for (Jogador jogador : jogadores) {
            if (jogador.getPontos() >= 12) {
                assertTrue(jogador.getDupla() == 1 || jogador.getDupla() == 2, "Deveria ter uma dupla vencedora");
                return; // Se encontrou um jogador com 12 pontos, o teste passa
            }
        }

        fail("Deveria ter uma dupla vencedora com 12 pontos ou mais");
    }

    // Adicione mais testes conforme necessário
}