/**
 * Created by iwona on 27.04.16.
 */
public class uczniowie {
    String imie;
    String nazwisko;
    int numer;
    String oceny;

    public uczniowie(String imie, String nazwisko, int numer) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numer = numer;
    }

    public String getImie()
    {
        return imie;
    }
    public String getNazwisko()
    {
        return nazwisko;
    }
    public int getNumer()
    {
        return numer;
    }

    public String getOceny()
    {
        return oceny;
    }

    public boolean ustawOcene(int ocena)
    {
        if(ocena<1||ocena>6)
        {
            return false;
        }
        else if(this.oceny.equals(""))
        {
            this.oceny=String.valueOf(ocena);
        }
        else this.oceny=this.oceny+", "+String.valueOf(ocena);
        return true;
    }


    @Override
    public String toString()
    {
        return "Uczen: [" +
                numer + " | " +
                imie + " " +
                nazwisko + " | " +
                oceny + "] /n";

    }
}
