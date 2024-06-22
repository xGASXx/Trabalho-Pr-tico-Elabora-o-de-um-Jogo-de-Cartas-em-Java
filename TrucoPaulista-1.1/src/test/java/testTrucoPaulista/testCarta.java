package testTrucoPaulista;

import TrucoPaulista.Carta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testCarta {

    @Test
    public void testConstructor() {
        Carta carta = new Carta("Espadas", "A");
        assertEquals("Espadas", carta.getNaipe());
        assertEquals("A", carta.getValor());
        assertFalse(carta.isManilha());
    }

    @Test
    public void testGettersAndSetters() {
        Carta carta = new Carta("Copas", "7");
        assertEquals("Copas", carta.getNaipe());
        assertEquals("7", carta.getValor());
        assertFalse(carta.isManilha());

        carta.setManilha(true);
        assertTrue(carta.isManilha());
    }

    @Test
    public void testToString() {
        Carta carta = new Carta("Ouros", "Q");
        assertEquals("Q de Ouros", carta.toString());

        carta.setManilha(true);
        assertEquals("Q de Ouros (Manilha)", carta.toString());
    }

    @Test
    public void testVence() {
        Carta carta1 = new Carta("Paus", "A");
        Carta carta2 = new Carta("Espadas", "K");

        assertTrue(carta1.vence(carta2));
        assertFalse(carta2.vence(carta1));

        // Testando empate de valor, desempatando pelo naipe
        Carta carta3 = new Carta("Ouros", "A");
        assertFalse(carta1.vence(carta3));
        assertTrue(carta3.vence(carta1));
    }

    @Test
    public void testEmpate() {
        Carta carta1 = new Carta("Copas", "7");
        Carta carta2 = new Carta("Espadas", "7");

        assertTrue(carta2.vence(carta1)); // Espadas vence Copas
        assertFalse(carta1.vence(carta2)); // Copas não vence Espadas
    }
}
