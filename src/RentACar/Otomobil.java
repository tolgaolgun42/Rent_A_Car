package AracKiralama;

    public class Otomobil extends Arac {
 
    private int kapiSayisi;
    private String yakitTipi;
 
    public Otomobil(String marka, String model, int yil, double kiraOrani, int kapiSayisi, String yakitTipi) {
        super(marka, model, yil, kiraOrani);
        this.kapiSayisi = kapiSayisi;
        this.yakitTipi = yakitTipi;
    }
 
    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("Kapı Sayısı: " + kapiSayisi);
        System.out.println("Yakıt Tipi: " + yakitTipi);
    }
}
