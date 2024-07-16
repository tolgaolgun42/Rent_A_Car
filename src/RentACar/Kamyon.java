package AracKiralama;

    public class Kamyon extends Arac {
 
    private int yukKapasitesi;
    private boolean dortCeker;
    private String yukTipi;
 
    public Kamyon(String marka, String model, int yil, double kiraOrani, int yukKapasitesi, boolean dortCeker, String yukTipi) {
        super(marka, model, yil, kiraOrani);
        this.yukKapasitesi = yukKapasitesi;
        this.dortCeker = dortCeker;
        this.yukTipi = yukTipi;
    }
 
    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("Yük Kapasitesi: " + yukKapasitesi);
        System.out.println("Dört Çeker: " + dortCeker);
        System.out.println("Yük Tipi: " + yukTipi);
    }
}
