import AracKiralama.AracKiralama;
import AracKiralama.Arac;
import AracKiralama.Otomobil;
import AracKiralama.Motosiklet;
import AracKiralama.Kamyon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AracKiralama aracKiralama = new AracKiralama();

        Otomobil araba1 = new Otomobil("Toyota", "Supra", 2020, 100, 4, "Sedan");
        Motosiklet motorsiklet1 = new Motosiklet("Honda", "CXR", 2000, 50, "Sport");
        Kamyon kamyon1 = new Kamyon("Ford", "F150", 2001, 200, 8000, true, "Nakliye");

        aracKiralama.aracEkle(araba1);
        aracKiralama.aracEkle(motorsiklet1);
        aracKiralama.aracEkle(kamyon1);

        boolean exit = false;

        while (!exit) {
            printMenu();
            int secim = getUserChoice(scanner);

            switch (secim) {
                case 1: {
                    kiralamaIslemi(scanner, aracKiralama);
                    break;
                }
                case 2: {
                    aracIadeIslemi(scanner, aracKiralama);
                    break;
                }
                case 3: {
                    aracKiralama.kiralamaBilgisiGoster();
                    break;
                }
                case 4: {
                    aracEkleIslemi(scanner, aracKiralama);
                    break;
                }
                case 5: {
                    exit = true;
                    System.out.println("Araç Kiralama Sistemini kullandığınız için teşekkür ederiz. Hoşça kal!");
                    break;
                }
                default:
                    System.out.println("Geçersiz seçenek. Lütfen geçerli bir seçenek girin...");
                   printMenu();
            }
        }

        
        scanner.close();
    }
    

    private static void printMenu() {
        System.out.println();
        System.out.println("===== Araç Kiralama Sistemi =====");
        System.out.println("1. Araç Kirala");
        System.out.println("2. Araç İade Et");
        System.out.println("3. Kiralama Bilgilerini Göster");
        System.out.println("4. Araç Ekle");
        System.out.println("5. Çıkış");
        System.out.println();
        System.out.print("Seçiminizi girin: ");
        
    }

    private static int getUserChoice(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Geçersiz giriş. Lütfen geçerli bir sayı girin.");
            scanner.next(); 
            printMenu();
        }
        return scanner.nextInt();
    }

   private static void kiralamaIslemi(Scanner scanner, AracKiralama aracKiralama) {
    System.out.print("Araç markasını girin: ");
    String marka = scanner.next();
    System.out.print("Araç modelini girin: ");
    String model = scanner.next();

    Arac secilenArac = aracKiralama.getArac(marka, model);
    int kiralamaSuresi;
    if (secilenArac != null) {
        aracKiralama.aracKiralama(secilenArac);
        System.out.print("Kiralama süresini gün cinsinden girin: ");
        kiralamaSuresi = getUserChoice(scanner);
        if(kiralamaSuresi>0)
        {
            try {
                double kiraMaliyeti = aracKiralama.kiraMaliyetiniHesapla(secilenArac, kiralamaSuresi);
                System.out.println("Başarıyla kiralandı.");
                System.out.println("Toplam kira Maliyeti: " + kiraMaliyeti);
            } catch (IllegalArgumentException e) {
                System.out.println("Hata: " + e.getMessage());
            }
        }
        else{
            System.out.println("Hatalı Gün Tuşlaması Yaptınız.");
        }
    } else {
        System.out.println("Kiralık araç bulunamadı.");
    }
}

private static void aracIadeIslemi(Scanner scanner, AracKiralama aracKiralama) {
    System.out.print("Araç markasını girin: ");
    String marka = scanner.next();
    System.out.print("Araç modelini girin: ");
    String model = scanner.next();

    Arac[] secilenArac = aracKiralama.getKiralanmisAraclar();

    if (secilenArac != null && secilenArac.length > 0) {
        // Aracın marka ve modeline göre ilgili aracı bul
        Arac iadeEdilecekArac = null;
        for (Arac arac : secilenArac) {
            if (arac.getMarka().equalsIgnoreCase(marka) && arac.getModel().equalsIgnoreCase(model)) {
                iadeEdilecekArac = arac;
                break;
            }
        }

        if (iadeEdilecekArac != null) {
            try {
                aracKiralama.aracIade(iadeEdilecekArac);
                System.out.println("Araç başarıyla iade edildi.");
            } catch (IllegalArgumentException e) {
                System.out.println("Hata: " + e.getMessage());
            }
        } else {
            System.out.println("Geçersiz iade. Araç kiralanmamış veya bulunamadı.");
        }
    } else {
        System.out.println("Geçersiz iade. Kiralanan araç bulunamadı.");
    }
}





 private static void aracEkleIslemi(Scanner scanner, AracKiralama aracKiralama) {
    try {
        System.out.print("Eklemek İstediğiniz Araç Markası:");
        String marka = scanner.next();
        System.out.print("Eklemek İstediğiniz Araç Modeli:");
        String model = scanner.next();
        System.out.print("Eklemek İstediğiniz Araç Yılı:");
        int yil = scanner.nextInt();
        System.out.print("Eklemek İstediğiniz Araç Kirası:");
        double kiraorani = scanner.nextDouble();

        if (yil < 0 || kiraorani < 0) {
            throw new IllegalArgumentException("Yıl ve kira oranı negatif olamaz.");
        }

        Arac aracekle = new Arac(marka, model, yil, kiraorani) {};
        aracKiralama.aracEkle(aracekle);
        System.out.println("Araç başarıyla eklendi.");
    } catch (IllegalArgumentException e) {
        System.out.println("Hata: " + e.getMessage());
    }
}

}
