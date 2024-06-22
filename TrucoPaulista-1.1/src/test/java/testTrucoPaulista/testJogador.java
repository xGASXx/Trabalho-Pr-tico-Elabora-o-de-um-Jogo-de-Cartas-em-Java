package testTrucoPaulista;

import TrucoPaulista.Carta;
import TrucoPaulista.Jogador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {

    private Jogador jogador;
    private Carta carta1;
    private Carta carta2;

    @BeforeEach
    void setUp() {
        jogador = new Jogador("Jogador Teste");
        carta1 = new Carta("Ouros", "4");
        carta2 = new Carta("Espadas", "7");
    }

    @Test
    void testAdicionarCarta() {
        jogador.adicionarCarta(carta1);
        List<Carta> mao = jogador.getMao();
        assertEquals(1, mao.size());
        assertEquals(carta1, mao.get(0));
    }

    @Test
    void testRemoverCarta() {
        jogador.adicionarCarta(carta1);
        jogador.adicionarCarta(carta2);
        jogador.removerCarta(carta1);
        List<Carta> mao = jogador.getMao();
        assertEquals(1, mao.size());
        assertEquals(carta2, mao.get(0));
    }

    @Test
    void testAdicionarPontos() {
        jogador.adicionarPontos(5);
        assertEquals(5, jogador.getPontos());
        jogador.adicionarPontos(3);
        assertEquals(8, jogador.getPontos());
    }

    @Test
    void testSetDupla() {
        jogador.setDupla(1);
        assertEquals(1, jogador.getDupla());
        jogador.setDupla(2);
        assertEquals(2, jogador.getDupla());
    }

    @Test
    void testGetNome() {
        assertEquals("Jogador Teste", jogador.getNome());
    }
}
