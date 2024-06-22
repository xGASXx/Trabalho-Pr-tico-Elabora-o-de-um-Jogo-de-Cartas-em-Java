package testTrucoPaulista;

import TrucoPaulista.Baralho;
import TrucoPaulista.Carta;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaralhoTest {

    private Baralho baralho;

    @BeforeEach
    void setUp() {
        baralho = new Baralho();
    }

    @Test
    void testEmbaralhar() {
        // Para testar o embaralhamento, verificamos se a ordem das cartas mudou
        Baralho outroBaralho = new Baralho();
        outroBaralho.embaralhar();
        
        // Comparar os dois baralhos para ver se são diferentes
        boolean diferente = false;
        for (int i = 0; i < 40; i++) {
            if (!baralho.distribuirCarta().equals(outroBaralho.distribuirCarta())) {
                diferente = true;
                break;
            }
        }
        assertTrue(diferente, "Os baralhos deveriam estar embaralhados de forma diferente");
    }

    @Test
    void testDistribuirCarta() {
        Carta carta = baralho.distribuirCarta();
        assertNotNull(carta, "A carta distribuída não deveria ser nula");
        assertEquals(39, baralho.cartas.size() - baralho.indiceAtual, "Deveria restar 39 cartas no baralho");
    }

    @Test
    void testTemCartas() {
        assertTrue(baralho.temCartas(), "O baralho deve ter cartas no início");

        // Distribuir todas as cartas
        for (int i = 0; i < 40; i++) {
            baralho.distribuirCarta();
        }
        
        assertFalse(baralho.temCartas(), "O baralho não deve ter cartas após distribuir todas");
    }

    @Test
    void testVirarCarta() {
        Carta primeiraCarta = baralho.virarCarta();
        assertNotNull(primeiraCarta, "A carta virada não deveria ser nula");
        assertEquals(primeiraCarta, baralho.cartas.get(baralho.indiceAtual), "A carta virada deve ser igual à primeira carta do baralho");
    }
}
