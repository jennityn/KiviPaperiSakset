import java.util.Scanner;

/**
 * Luokka, joka mallintaa kivi-paperi-sakset-peliä kahden pelaajan välillä. Ensimmäisenä kolme voittoa saanut
 * pelaaja voittaa pelin. Pelillä on kaksi pelaajaa, pelattujen pelien määrä ja tasapelien määrä.
 */
public class Peli {
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private int pelatutPelit;
    private int tasapelit;

    /**
     * Konstruktori, joka luo uuden pelin, asettaa pelaajille parametreinä saadut nimet ja asettaa pelattujen pelien
     * ja tasapelien määrät alkuarvoihinsa.
     *
     * @param nimi1 ensimmäisen pelaajan nimi
     * @param nimi2 toisen pelaajan nimi
     */
    public Peli(String nimi1, String nimi2) {
        this.pelaaja1 = new Pelaaja(nimi1);
        this.pelaaja2 = new Pelaaja(nimi2);
        this.pelatutPelit = 0;
        this.tasapelit = 0;
    }

    /**
     * Palauttaa pelaajan 1 tiedot
     * @return pelaaja 1
     */
    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    /**
     * Palauttaa pelaajan 2 tiedot
     * @return pelaaja 2
     */
    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }

    /**
     * Palauttaa peliä pelatut pelit yhden pelikerran ajalta
     * @return pelatut pelit
     */
    public int getPelatutPelit() {
        return pelatutPelit;
    }

    /**
     * Palauttaa pelin aikana syntyneiden tasapelien määrän
     * @return tasapelien määrä
     */
    public int getTasapelit() {
        return tasapelit;
    }

    /**
     * Metodi, joka sisältää pelin perustoiminnallisuuden.
     * Pelaajille valitaan yksi kolmesta vaihtoehdosta (kivi, paperi, sakset) ja tulostetaan konsoliin valinnoista
     * aiheutuneet tulokset. Ensimmäinen pelaaja, jonka voittojen määrä ylittää 3 voittoa, voittaa pelin.
     */

    public void pelaa() {

        String nimi1 = pelaaja1.getNimi();
        String nimi2 = pelaaja2.getNimi();

        while (pelaaja1.getVoitot() < 3 && pelaaja2.getVoitot() < 3) {

            String valinta1 = pelaaja1.teeValinta();
            String valinta2 = pelaaja2.teeValinta();


            System.out.println("Erä: " + pelatutPelit+1 + " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
            System.out.println(nimi1 + " valitsi: " + valinta1 + " ja " + nimi2 + " valitsi: " + valinta2);

            if (valinta1.equals(valinta2)) {
                System.out.println("Tasapeli!");
                tasapelit++;
            } else if ((valinta1.equals("KIVI") && valinta2.equals("PAPERI")) || (valinta1.equals("PAPERI")
                    && valinta2.equals("SAKSET")) || (valinta1.equals("SAKSET") && valinta2.equals("KIVI"))) {
                pelaaja2.lisaaVoitto();
                System.out.println(nimi2 + " voitti! Tilanne: " + nimi1 + "  " + pelaaja1.getVoitot() + " - " +
                        nimi2 + "  " + pelaaja2.getVoitot());
            } else {
                pelaaja1.lisaaVoitto();
                System.out.println(nimi1 + " voitti! Tilanne: " + nimi1 + "  " + pelaaja1.getVoitot() + " - " +
                        nimi2 + "  " + pelaaja2.getVoitot());
            }
            pelatutPelit++;
        }
        if (pelaaja1.getVoitot() == 3) {
            System.out.println(nimi1 + " voitti kolmella voitolla - PELI PÄÄTTYY");
        } else {
            System.out.println(nimi2 + " voitti kolmella voitolla - PELI PÄÄTTYY");
        }
    }

    /**
     * Pääohjelma, jossa pelin pelaajien nimet kysytään ja peli aloitetaan ja lopetetaan
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Anna pelaajan 1 nimi:");
        String nimi1 = scanner.nextLine();
        System.out.println("Anna pelaajan 2 nimi:");
        String nimi2 = scanner.nextLine();

        Peli peli = new Peli(nimi1, nimi2);
        peli.pelaa();
    }
}
