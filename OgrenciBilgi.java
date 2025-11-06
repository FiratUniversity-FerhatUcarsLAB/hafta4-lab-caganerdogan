/*
 * Ad Soyad: [Çağan Ahmet Erdoğan]
 * Ogrenci No: [250541059]
 * Tarih: [06/11/2025]
 * Aciklama: Gorev 1 - Ogrenci Bilgi Sistemi
 * 
 * Bu program kullanicidan ogrenci bilgilerini alir ve duzenli bir formatta ekrana yazdirir.
 */

import java.util.Scanner;

public class OgrenciBilgi {

    public static void main(String[] args) {
        // Scanner sınıfını kullanarak kullanıcıdan girdi almak için nesne oluşturuluyor
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan bilgileri alma
        System.out.println("=== ÖĞRENCİ BİLGİ GİRİŞİ ===");
        
        System.out.print("Öğrencinin Adını girin (String): ");
        String ad = scanner.nextLine();
        
        System.out.print("Öğrencinin Soyadını girin (String): ");
        String soyad = scanner.nextLine();
        
        System.out.print("Öğrenci Numarasını girin (int): ");
        int ogrenciNo = scanner.nextInt();
        
        System.out.print("Yaşını girin (int): ");
        int yas = scanner.nextInt();
        
        System.out.print("GPA (Not Ortalaması, 0.00-4.00 arası) girin (double): ");
        double gpa = scanner.nextDouble();

        // Scanner nesnesini kapat
        scanner.close();

        // Durum belirleme (örnek bir mantık)
        String durum;
        if (gpa >= 3.00) {
            durum = "Basarili Ogrenci";
        } else if (gpa >= 2.00) {
            durum = "Normal Ogrenci";
        } else {
            durum = "Dikkat Edilmeli";
        }

        // Çıktı formatı oluşturma (printf kullanarak)
        System.out.println("\n=== ÖĞRENCİ BİLGİ SİSTEMİ ===");
        
        // Ad Soyad için
        System.out.printf("Ad Soyad: %s %s%n", ad, soyad);
        
        // Öğrenci No ve Yaş için
        System.out.printf("Ogrenci No: %d%n", ogrenciNo);
        System.out.printf("Yas: %d%n", yas);
        
        // GPA için (2 ondalık basamakla gösterim)
        System.out.printf("GPA: %.2f%n", gpa);
        
        // Durum için
        System.out.printf("Durum: %s%n", durum);
    }
}
