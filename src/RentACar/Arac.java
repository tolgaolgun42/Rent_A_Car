package AracKiralama;

public abstract class Arac {
    private String marka;
    private String model;
    private int yil;
    private double kiraOrani;
    private boolean kiralandi; 

    public Arac(String marka, String model, int yil, double kiraOrani) {
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.kiraOrani = kiraOrani;
        this.kiralandi = false; 
    }

    public void bilgiGoster() {
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
        System.out.println("Yıl: " + yil);
        System.out.println("Kira Oranı: " + kiraOrani);
        System.out.println("Durumu: " + (kiralandi ? "Kiralandı" : "Kiralık"));
    }

    public double getKiraOrani() {
        return kiraOrani;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getYil() {
        return yil;
    }

    public boolean isKiralandi() {
        return kiralandi;
    }

    public void setKiralandi(boolean kiralandi) {
        this.kiralandi = kiralandi;
    }
}
