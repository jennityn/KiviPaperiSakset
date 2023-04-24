import java.util.Random;

/**
 * Pelaaja-luokka kuvaa yhtä pelin pelaajaa. Pelaajalla on nimi, valinta (kivi, papaeri tai sakset) ja voittojen määrä.
 */
public class Pelaaja {

    private String nimi;
    private String valinta;
    private int voitot;

    /**
     * Konstruktori, joka luo uuden pelaajan sille annetulla nimellä, tekee pelajan ensimmäisen valinnan ja asettaa
     * voittojen määrän nollaksi
     *
     * @param nimi pelaajan nimi
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.valinta = teeValinta();
        this.voitot = 0;
    }

    /**
     * Arpoo pelaajan valinnaksi kivi, paperi tai sakset.
     * @return String valittu vaihtoehto merkkijonona
     */
    public String teeValinta() {
        Random random = new Random();
        int valintaInt = random.nextInt(3);
        String[] vaihtoehdot = {"KIVI", "PAPERI", "SAKSET"};
        return vaihtoehdot[valintaInt];
    }

    /**
     * Kasvattaa voittojen määrää yhdellä
     */
    public void lisaaVoitto(){
        voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen määrän
     * @return voittojen määrä
     */
    public int getVoitot(){
       return voitot;
    }

    /**
     * Palauttaa pelaajan nimen
     * @return pelaajan nimi
     */

    public String getNimi() {
        return nimi;
    }

    /**
     * Palauttaa pelaajalle arvotun valinnan
     * @return pelaajan valinta
     */
    public String getValinta() {
        return valinta;
    }
}
