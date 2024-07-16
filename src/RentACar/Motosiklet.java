package AracKiralama;

    public class Motosiklet extends Arac {
 
    private String motorsikletTipi;
 
    public Motosiklet(String marka, String model, int yil, double kiraOrani, String motorsikletTipi) {
        super(marka, model, yil, kiraOrani);
        this.motorsikletTipi = motorsikletTipi;
    }
 
    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("Motorsiklet Tipi: " + motorsikletTipi);
    }
}
