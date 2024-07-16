package AracKiralama;

import java.util.Scanner;

public class AracKiralama {

    private Arac[] kullanilabilirAraclar;
    private Arac[] kiralanmisAraclar;
    private int kullanilabilirSayisi;
    private int kiralanmisSayisi;

    public AracKiralama() {
        kullanilabilirAraclar = new Arac[100];
        kiralanmisAraclar = new Arac[100];
        kullanilabilirSayisi = 0;
        kiralanmisSayisi = 0;
    }

    public void aracEkle(Arac arac) {
        kullanilabilirAraclar[kullanilabilirSayisi++] = arac;
    }

    public Arac[] getKullanilabilirAraclar() {
        return kullanilabilirAraclar;
    }

    public Arac[] getKiralanmisAraclar() {
        return kiralanmisAraclar;
    }

    public void aracKiralama(Arac arac) {
        if (!arac.isKiralandi()) {
            arac.setKiralandi(true);
            kiralanmisAraclar[kiralanmisSayisi++] = arac;
            for (int j = 0; j < kullanilabilirSayisi; j++) {
                if (kullanilabilirAraclar[j].equals(arac)) {
                    for (int k = j; k < kullanilabilirSayisi - 1; k++) {
                        kullanilabilirAraclar[k] = kullanilabilirAraclar[k + 1];
                    }
                    kullanilabilirSayisi--;
                    break;
                }
            }
        }
    }

    public void aracIade(Arac arac) {
        if (arac.isKiralandi()) {
            arac.setKiralandi(false);
            kullanilabilirAraclar[kullanilabilirSayisi++] = arac;
            for (int j = 0; j < kiralanmisSayisi; j++) {
                if (kiralanmisAraclar[j].equals(arac)) {
                    for (int k = j; k < kiralanmisSayisi - 1; k++) {
                        kiralanmisAraclar[k] = kiralanmisAraclar[k + 1];
                    }
                    kiralanmisSayisi--;
                    break;
                }
            }
        }
    }

    public void kiralamaBilgisiGoster() {
        System.out.println("Kullanılabilir araçlar: ");
        for (int i = 0; i < kullanilabilirSayisi; i++) {
            kullanilabilirAraclar[i].bilgiGoster();
            System.out.println();
        }

        System.out.println("Kiralanan araçlar: ");
        for (int i = 0; i < kiralanmisSayisi; i++) {
            kiralanmisAraclar[i].bilgiGoster();
            System.out.println();
        }
    }

    public double kiraMaliyetiniHesapla(Arac arac, int kiraSuresi) {
        double kiraOrani = arac.getKiraOrani();
        return kiraOrani * kiraSuresi;
    }

    public Otomobil[] getKullanilabilirOtomobiller() {
        Otomobil[] kullanilabilirOtomobiller = new Otomobil[kullanilabilirSayisi];
        int otomobilIndex = 0;

        for (int i = 0; i < kullanilabilirSayisi; i++) {
            if (kullanilabilirAraclar[i] instanceof Otomobil) {
                kullanilabilirOtomobiller[otomobilIndex++] = (Otomobil) kullanilabilirAraclar[i];
            }
        }

        return kullanilabilirOtomobiller;
    }

   public Arac getArac(String marka, String model) {
    for (int i = 0; i < kullanilabilirSayisi; i++) {
        Arac mevcutArac = kullanilabilirAraclar[i];
        if (mevcutArac.getMarka().equals(marka) && mevcutArac.getModel().equals(model)) {
            return mevcutArac;
        }
    }
    return null; // Eşleşen araç bulunamadı
}


   
}
