
/*
 * Ad Soyad: [Çağan Ahmet Erdoğan]
 * Ogrenci No: [250541059]
 * Tarih: [06/11/2025]
 * Aciklama: Gorev 2 - Geometrik Hesaplayıcı
 * 
 * Daire yarıçapını alıp,daire ve küre hesaplamaları yapan program.
 */

import java.util.Scanner;

public class GeometrikHesaplayici {

    public static void main(String[] args) {
        // Özel Gereksinim 1: Pi değerini sabit (final) olarak tanımlama
        final double PI = 3.14159; 

        // Scanner sınıfını kullanarak kullanıcıdan girdi almak için nesne oluşturuluyor
        Scanner scanner = new Scanner(System.in);

        // Başlık
        System.out.println("=== GEOMETRİK HESAPLAYICI ===");

        // Kullanıcıdan yarıçapı alma (Özel Gereksinim 2: Yarıçap double tipinde olmalı)
        System.out.print("Dairenin yaricapini girin (cm): ");
        double r = scanner.nextDouble();

        // Scanner nesnesini kapat
        scanner.close();

        // --- Hesaplamalar ---

        // 1. Dairenin alanı: π * r²
        double daireAlani = PI * Math.pow(r, 2);

        // 2. Dairenin çevresi: 2 * π * r
        double daireCevresi = 2 * PI * r;

        // 3. Dairenin çapı: 2 * r
        double daireCapi = 2 * r;

        // 4. Kürenin hacmi: (4/3) * π * r³
        // İpucu: Math.pow(r, 3) kullanıldı
        double kureHacmi = (4.0 / 3.0) * PI * Math.pow(r, 3);

        // 5. Kürenin yüzey alanı: 4 * π * r²
        double kureYuzeyAlani = 4 * PI * Math.pow(r, 2);


        // --- SONUÇLARI GÖSTERME (Düzenli Çıktı ve 2 Ondalık Basamak) ---

        System.out.println("\nSONUÇLAR:");
        System.out.println("-------------");

        // printf() ile sütunları hizalama ve tüm sonuçları 2 ondalık basamakla gösterme
        // %-20s: 20 karakter sola hizalı string
        // %8.2f: 8 karakter genişliğinde, 2 ondalık basamaklı, sağa hizalı double (hizalama için önemlidir)
        
        System.out.printf("%-20s : %8.2f cm²%n", "Daire Alani", daireAlani);
        System.out.printf("%-20s : %8.2f cm%n", "Daire Cevresi", daireCevresi);
        System.out.printf("%-20s : %8.2f cm%n", "Daire Capi", daireCapi);
        System.out.printf("%-20s : %8.2f cm³%n", "Kure Hacmi", kureHacmi);
        System.out.printf("%-20s : %8.2f cm²%n", "Kure Yuzey Alani", kureYuzeyAlani);
    }
}
