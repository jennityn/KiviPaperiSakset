import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KPSTest {

    @Test
    public void testNimi() {
        Pelaaja pelaaja = new Pelaaja("Matti");
        assertEquals("Matti", pelaaja.getNimi());
    }

    @Test
    public void testValinta() {
        Pelaaja pelaaja = new Pelaaja("Matti");
        String[] vaihtoehdot = {"KIVI", "PAPERI", "SAKSET"};
        boolean found = false;
        for (int i = 0; i < 100; i++) {
            String valinta = pelaaja.teeValinta();
            for (String vaihtoehto : vaihtoehdot) {
                if (vaihtoehto.equals(valinta)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                fail("Virheellinen valinta: " + valinta);
            }
        }
    }

    @Test
    public void testVoitot() {
        Pelaaja pelaaja = new Pelaaja("Matti");
        assertEquals(0, pelaaja.getVoitot());
        pelaaja.lisaaVoitto();
        assertEquals(1, pelaaja.getVoitot());
    }

    @Test
    public void testPelaa() {
        Peli peli = new Peli("Pelaaja 1", "Pelaaja 2");
        peli.pelaa();
        assertTrue(peli.getPelatutPelit() > 0);
    }

    @Test
    public void testTasapelit() {
        Peli peli = new Peli("Pelaaja 1", "Pelaaja 2");
        peli.pelaa();
        assertTrue(peli.getTasapelit() >= 0);
    }

    @Test
    public void testVoittaja() {
        Peli peli = new Peli("Pelaaja 1", "Pelaaja 2");
        peli.pelaa();
        assertTrue(peli.getPelaaja1().getVoitot() == 3 || peli.getPelaaja2().getVoitot() == 3);
    }
}
