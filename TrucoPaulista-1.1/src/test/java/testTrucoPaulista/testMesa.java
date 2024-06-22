package testTrucoPaulista;

import TrucoPaulista.Carta;
import TrucoPaulista.Jogador;
import TrucoPaulista.Mesa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class testMesa {

    private Mesa mesa;
    private List<Jogador> jogadores;

    @BeforeEach
    public void setUp() {
        jogadores = new ArrayList<>();
        jogadores.add(new Jogador("Jogador 1"));
        jogadores.add(new Jogador("Jogador 2"));
        jogadores.add(new Jogador("Jogador 3"));
        jogadores.add(new Jogador("Jogador 4"));
        mesa = new Mesa(jogadores);
    }

    @Test
    public void testIniciarRodada() {
        mesa.iniciarRodada();
        for (Jogador jogador : jogadores) {
            assertEquals(3, jogador.getMao().size());
        }
    }

    @Test
    public void testVirarCarta() {
        mesa.iniciarRodada();
        Carta cartaVirada = mesa.virarCarta();
        assertNotNull(cartaVirada);
    }

    @Test
    public void testAtualizarPontos() {
        mesa.atualizarPontos(1, 3);
        assertEquals(3, mesa.getPontosDuplas()[0]);
    }

    
    
}   