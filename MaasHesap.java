/*
 * Ad Soyad: [Çağan Ahmet Erdogan]
 * Ogrenci No: [250541059]
 * Tarih: [06/11/2025]
 * Aciklama: Gorev 3 - Maaş Hesap Sistemi
 * 
 *  Çalışan bilgilerini alıp detaylı maaş bordrosu oluşturan program.
 */

 import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MaasHesap {

    public static void main(String[] args) {
        
        // Özel Gereksinim 1: Tüm kesinti oranlarını sabit (final) olarak tanımlama (Ondalık formatta)
        final double SGK_ORAN = 0.14;       // %14
        final double GELIR_VERGISI_ORAN = 0.15; // %15
        final double DAMGA_VERGISI_ORAN = 0.00759; // %0.759 (0.759 / 100)
        final double MESAİ_KATSAYISI = 1.5;
        final int AYDA_ORT_CALISMA_SAATI = 160;
        final int IS_GUNU_SAYISI = 22;

        Scanner scanner = new Scanner(System.in);
        String adSoyad = "";
        double brutMaas = 0.0;
        int haftalikSaat = 0;
        int mesaiSaati = 0;

        // Başlık
        System.out.println("=== MAAŞ HESAPLAMA SİSTEMİ ===");

        // --- 1. Kullanıcıdan Bilgileri Alma ---
        try {
            System.out.print("Çalışanın adı ve soyadı (String): ");
            adSoyad = scanner.nextLine();

            System.out.print("Aylık brüt maaş (double, TL cinsinden): ");
            brutMaas = scanner.nextDouble();

            System.out.print("Haftalık çalışma saati (int): ");
            haftalikSaat = scanner.nextInt();

            System.out.print("Mesai saati sayısı (int, normal çalışma saati dışında): ");
            mesaiSaati = scanner.nextInt();
            
        } catch (InputMismatchException e) {
            System.err.println("\n--- HATA ---\nLütfen brüt maaş, haftalık saat ve mesai saati için sayısal değerler giriniz.");
            // Programı sonlandır
            return; 
        } finally {
            scanner.close();
        }

        // --- 2. Hesaplamalar ---
        
        // 1. TOPLAM GELİR
        // Mesai ücreti = (Brüt Maaş / 160) × Mesai Saati × 1.5
        double saatlikBrutUcret = brutMaas / AYDA_ORT_CALISMA_SAATI;
        double mesaiUcreti = saatlikBrutUcret * mesaiSaati * MESAİ_KATSAYISI;
        // Toplam Gelir = Brüt maaş + Mesai ücreti
        double toplamGelir = brutMaas + mesaiUcreti;

        // 2. KESİNTİLER
        // SGK Kesintisi: Toplam Gelirin %14'ü
        double sgkKesintisi = toplamGelir * SGK_ORAN;
        // Gelir Vergisi: Toplam Gelirin %15'i
        double gelirVergisi = toplamGelir * GELIR_VERGISI_ORAN;
        // Damga Vergisi: Toplam Gelirin %0.759'u
        double damgaVergisi = toplamGelir * DAMGA_VERGISI_ORAN;
        // Toplam Kesinti: Tüm kesintilerin toplamı
        double toplamKesinti = sgkKesintisi + gelirVergisi + damgaVergisi;

        // 3. NET MAAŞ
        // Net Maaş = Toplam Gelir - Toplam Kesinti
        double netMaas = toplamGelir - toplamKesinti;

        // 4. İSTATİSTİKLER
        // Kesinti oranı (yüzde olarak)
        double kesintiOraniYuzde = (toplamKesinti / toplamGelir) * 100;
        // Saatlik net kazanç (Aylık Net Maaş / (Haftalık Saat * 4))
        double saatlikNetKazanc = netMaas / (haftalikSaat * 4);
        // Günlük net kazanç (22 iş günü varsayımıyla)
        double gunlukNetKazanc = netMaas / IS_GUNU_SAYISI;

        // --- 3. Çıktı Formatlama (Profesyonel Bordro) ---
        
        LocalDate tarih = LocalDate.now(); // Sistem tarihini alma

        // Ana başlık
        System.out.printf("\nÇalışan adı soyadı: %s%n", adSoyad);
        System.out.printf("Brut maas (TL): %.0f%n", brutMaas); // Örnekte tam sayı gösterilmiş
        System.out.printf("Haftalık calisma saati: %d%n", haftalikSaat);
        System.out.printf("Mesai saati sayısı: %d%n", mesaiSaati);

        System.out.println("\n==================================");
        System.out.println("          MAAŞ BORDROSU           ");
        System.out.println("==================================");

        // Bordro Bilgileri
        System.out.printf("Calisan: %s%n", adSoyad);
        System.out.printf("Tarih:   [%s]%n", tarih);
        System.out.println("----------------------------------");

        // GELİRLER
        System.out.println("GELİRLER:");
        // %-25s: sola hizalı 25 karakter
        // %10.2f: 10 karakter genişliğinde, 2 ondalık basamaklı (Para değeri)
        System.out.printf("%-25s : %10.2f TL%n", "Brut Maas", brutMaas);
        System.out.printf("%-25s : %10.2f TL%n", String.format("Mesai Ucreti (%d saat)", mesaiSaati), mesaiUcreti);
        System.out.println("----------------------------------");
        System.out.printf("%-25s : %10.2f TL%n", "TOPLAM GELIR", toplamGelir);
        System.out.println("==================================");

        // KESİNTİLER
        System.out.println("KESİNTİLER:");
        // Yüzde değerleri 1 ondalık basamakla gösterilir (%.1f)
        // Kesinti adları, yüzdelik oranları ve tutarları birlikte formatlanır.
        System.out.printf("%-25s : %10.2f TL%n", String.format("SGK Kesintisi (%.1f%%)", SGK_ORAN * 100), sgkKesintisi);
        System.out.printf("%-25s : %10.2f TL%n", String.format("Gelir Vergisi (%.1f%%)", GELIR_VERGISI_ORAN * 100), gelirVergisi);
        System.out.printf("%-25s : %10.2f TL%n", String.format("Damga Vergisi (%.1f%%)", DAMGA_VERGISI_ORAN * 100), damgaVergisi);
        System.out.println("----------------------------------");
        System.out.printf("%-25s : %10.2f TL%n", "TOPLAM KESINTI", toplamKesinti);
        System.out.println("==================================");

        // NET MAAŞ
        System.out.println("NET MAAS");
        System.out.printf("%-25s : %10.2f TL%n", "", netMaas);
        System.out.println("==================================");

        // İSTATİSTİKLER
        System.out.println("İSTATİSTİKLER:");
        // Yüzde değerleri 1 ondalık basamakla gösterilir (%.1f)
        System.out.printf("%-25s : %8.1f %% %n", "Kesinti Orani", kesintiOraniYuzde);
        // Para değerleri 2 ondalık basamakla gösterilir (%.2f)
        System.out.printf("%-25s : %8.2f TL/saat%n", "Saatlik Net Kazanc", saatlikNetKazanc);
        System.out.printf("%-25s : %8.2f TL/gun%n", "Gunluk Net Kazanc", gunlukNetKazanc);
        System.out.println("==================================");
    }
}
