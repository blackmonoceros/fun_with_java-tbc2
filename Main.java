import java.util.ArrayList;
import java.util.List;

class Produkt {
    private int id;
    private String nazwa;
    private double cena;
    private int iloscNaStanie;

    public Produkt(int id, String nazwa, double cena, int iloscNaStanie) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
        this.iloscNaStanie = iloscNaStanie;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public int getIloscNaStanie() {
        return iloscNaStanie;
    }
}

class Zamowienie {
    private List<Produkt> produkty;
    private List<Integer> ilosci;
    private double lacznaKwota;

    public Zamowienie() {
        produkty = new ArrayList<>();
        ilosci = new ArrayList<>();
        lacznaKwota = 0.0;
    }

    public void dodajProdukt(Produkt produkt, int ilosc) {
        produkty.add(produkt);
        ilosci.add(ilosc);
        lacznaKwota += produkt.getCena() * ilosc;
    }

    public double obliczLacznaKwote() {
        return lacznaKwota;
    }

    public void wyswietlSzczegoly() {
        System.out.println("Szczegóły zamówienia:");
        for (int i = 0; i < produkty.size(); i++) {
            Produkt produkt = produkty.get(i);
            int ilosc = ilosci.get(i);
            System.out.println("Produkt: " + produkt.getNazwa());
            System.out.println("Ilość: " + ilosc);
            System.out.println("Cena: " + produkt.getCena());
            System.out.println("Kwota: " + produkt.getCena() * ilosc);
            System.out.println("--------------------");
        }
        System.out.println("Łączna kwota zamówienia: " + lacznaKwota);
    }
}

public class Main {
    public static void main(String[] args) {
        Produkt produkt1 = new Produkt(1, "Rower", 4999.99, 5);
        Produkt produkt2 = new Produkt(2, "Rowerek", 1399.99, 10);

        Zamowienie zamowienie = new Zamowienie();
        zamowienie.dodajProdukt(produkt1, 3);
        zamowienie.dodajProdukt(produkt2, 2);

        zamowienie.wyswietlSzczegoly();
    }
}
