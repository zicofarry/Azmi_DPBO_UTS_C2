import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    // Daftar global untuk menyimpan semua lokasi dan orang (untuk searching)
    private static ArrayList<LokasiProduksi> listLokasi = new ArrayList<>();
    private static ArrayList<Person> listPerson = new ArrayList<>();
    
    // Method untuk menampilkan detail Lokasi Produksi (sama seperti sebelumnya)
    private static void displayDetailLokasi(LokasiProduksi lokasi) {
        String pemilikNama = "Tidak diketahui";
        String jenis = "Unknown";
        
        // 1. Tentukan Jenis Lokasi & Cari Pemilik
        if (lokasi instanceof PerikananKomersil) {
            jenis = "Perikanan Komersil";
            // Mencari pemilik Komersil yang memiliki lokasi ini (Komposisi)
            for (Person p : listPerson) {
                if (p instanceof PemilikPerikananKomersil) {
                    PemilikPerikananKomersil ppk = (PemilikPerikananKomersil) p;
                    for (int i = 0; i < ppk.getCount(); i++) {
                        if (ppk.getDaftarPerikananKomersil()[i].getKode().equals(lokasi.getKode())) {
                            pemilikNama = ppk.getNama();
                            break;
                        }
                    }
                }
            }
        } else if (lokasi instanceof PeternakanKomersil) {
            jenis = "Peternakan Komersil";
            for (Person p : listPerson) {
                if (p instanceof PemilikPeternakanKomersil) {
                    PemilikPeternakanKomersil ppk = (PemilikPeternakanKomersil) p;
                    for (int i = 0; i < ppk.getCount(); i++) {
                        if (ppk.getDaftarPeternakanKomersil()[i].getKode().equals(lokasi.getKode())) {
                            pemilikNama = ppk.getNama();
                            break;
                        }
                    }
                }
            }
        } else if (lokasi instanceof RumahSwasembadaPangan) {
            jenis = "Rumah Swasembada Pangan";
             // Mencari Pelaku Swasembada (Asosiasi)
            for (Person p : listPerson) {
                if (p instanceof PelakuRumahSwasembada) {
                    PelakuRumahSwasembada prs = (PelakuRumahSwasembada) p;
                    if (prs.getRumahDimiliki() != null && prs.getRumahDimiliki().getKode().equals(lokasi.getKode())) {
                        pemilikNama = prs.getNama();
                        break;
                    }
                }
            }
        }

        // 2. Tampilkan Detail
        System.out.println("=================================================");
        System.out.println("INFORMASI DETAIL LOKASI: " + lokasi.getNamaEntitas());
        System.out.println("=================================================");
        System.out.println("Jenis Lokasi   : " + jenis);
        System.out.println("Kode Lokasi    : " + lokasi.getKode());
        System.out.println("Pemilik/Pelaku : " + pemilikNama);
        System.out.println("Kota, Luas     : " + lokasi.getKota() + ", " + lokasi.getLuas() + " m²");
        
        // 3. Tampilkan Detail Komersil (Interface Komersil)
        if (lokasi instanceof Komersil) {
            Komersil komersil = (Komersil) lokasi;
            System.out.println("Jumlah Karyawan: " + komersil.getJumlahKaryawan());
        }

        // 4. Tampilkan Daftar Komoditas (Agregasi)
        System.out.println("\n--- Daftar Komoditas yang Dikelola ---");
        
        if (lokasi instanceof PerikananKomersil) {
            PerikananKomersil pk = (PerikananKomersil) lokasi;
            System.out.println("Jumlah Ikan: " + pk.getCountIkan());
            for (int i = 0; i < pk.getCountIkan(); i++) {
                Ikan ikan = pk.getDaftarIkan()[i];
                System.out.println("  - " + ikan.getNamaEntitas() + " (" + ikan.getJenis() + "), Berat: " + ikan.getBeratKonsumsi() + " kg, Lama Pelihara: " + ikan.getLamaPemeliharaan() + " bln");
            }
        } else if (lokasi instanceof PeternakanKomersil) {
            PeternakanKomersil ptk = (PeternakanKomersil) lokasi;
            System.out.println("Jumlah Ternak: " + ptk.getCountTernak());
            for (int i = 0; i < ptk.getCountTernak(); i++) {
                TernakBahanPangan ternak = ptk.getDaftarTernak()[i];
                System.out.println("  - " + ternak.getNamaEntitas() + ", Berat: " + ternak.getBeratKonsumsi() + " kg, Lama Pelihara: " + ternak.getLamaPemeliharaan() + " bln");
            }
            
            // Show Off Inner Class
            PeternakanKomersil.StatistikProduksi stats = ptk.new StatistikProduksi();
            System.out.println("\n  >> Statistik Produksi (Inner Class) <<");
            System.out.println("  Total Berat Ternak: " + String.format("%.2f", stats.hitungTotalBerat()) + " kg");
            System.out.println("  Rata-rata Lama Pelihara: " + String.format("%.1f", stats.getRataRataLamaPelihara()) + " bulan");

        } else if (lokasi instanceof RumahSwasembadaPangan) {
            RumahSwasembadaPangan rsp = (RumahSwasembadaPangan) lokasi;
            System.out.println("Ikan (" + rsp.getCountIkan() + "), Ternak (" + rsp.getCountTernak() + "), Sayur (" + rsp.getCountSayur() + ")");
            System.out.print("  Ikan: ");
            for (int i = 0; i < rsp.getCountIkan(); i++) System.out.print(rsp.getDaftarIkan()[i].getNamaEntitas() + "; ");
            System.out.print("\n  Sayur: ");
            for (int i = 0; i < rsp.getCountSayur(); i++) System.out.print(rsp.getDaftarSayurRempah()[i].getNamaEntitas() + "; ");
            System.out.println("\n");
        }
    }

    private static void searchingFeature(Scanner scanner) {
        System.out.print("Masukkan Nama Lokasi Produksi yang dicari: ");
        String namaCari = scanner.nextLine().trim();

        LokasiProduksi lokasiDitemukan = null;
        for (LokasiProduksi l : listLokasi) {
            if (l.getNamaEntitas().equalsIgnoreCase(namaCari)) {
                lokasiDitemukan = l;
                break;
            }
        }

        if (lokasiDitemukan != null) {
            displayDetailLokasi(lokasiDitemukan);
        } else {
            System.out.println("Lokasi produksi dengan nama '" + namaCari + "' tidak ditemukan.");
        }
    }
    
    private static void commandLoop(Scanner scanner) {
        String command = "";
        
        while (!command.equalsIgnoreCase("exit")) { // Loop berjalan selama perintah bukan "exit"
            System.out.println("\n--- PILIHAN PERINTAH ---");
            System.out.println("Ketik 'all' (Tampilkan Semua Detail), 'cari' (Cari Lokasi), atau 'exit' (Keluar):");
            System.out.print(">>> ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "all":
                    System.out.println("\n[OUTPUT SEMUA DATA LENGKAP]");
                    for (LokasiProduksi l : listLokasi) {
                        displayDetailLokasi(l);
                    }
                    break;
                case "cari":
                    System.out.println("\n[MODE PENCARIAN]");
                    searchingFeature(scanner);
                    break;
                case "exit":
                    System.out.println("\nProgram dihentikan. Terima kasih!");
                    break;
                default:
                    System.out.println("Perintah tidak dikenali. Silakan coba lagi.");
                    break;
            }
        }
    }
    
    public static void main(String[] args) {
        
        // =================================================================
        // 1. HARDCODE DATA (INISIALISASI)
        // =================================================================

        // Komoditas
        Ikan nila = new Ikan("K101", "Nila Merah", "Konsumsi", 0.3, 3);
        Ikan koi = new Ikan("K102", "Ikan Koi", "Hias", 0.5, 12);
        TernakBahanPangan sapi = new TernakBahanPangan("K201", "Sapi Bali", 400.0, 36);
        TernakBahanPangan ayam = new TernakBahanPangan("K202", "Ayam Broiler", 2.5, 2);
        SayurRempah sawi = new SayurRempah("K301", "Sawi Hijau", "Sayur");
        SayurRempah jahe = new SayurRempah("K302", "Jahe Merah", "Rempah");
        
        // Lokasi Produksi
        PerikananKomersil tambakBandung = new PerikananKomersil("L001", "Tambak Makmur", "Bandung", 5000.0, 10);
        PeternakanKomersil peternakanGarut = new PeternakanKomersil("L002", "Peternakan Sejahtera", "Garut", 8000.0, 15);
        RumahSwasembadaPangan rumahIbuSiti = new RumahSwasembadaPangan("L003", "Swasembada Mandiri", "Cimahi", 150.0, 5);

        // Tambahkan Komoditas ke Lokasi (Agregasi)
        tambakBandung.addIkan(nila);
        tambakBandung.addIkan(nila);
        tambakBandung.setJumlahKaryawan(15);
        
        peternakanGarut.addTernak(sapi);
        peternakanGarut.addTernak(ayam);
        peternakanGarut.addTernak(ayam);
        peternakanGarut.setJumlahKaryawan(20);
        
        rumahIbuSiti.addIkan(koi);
        rumahIbuSiti.addTernak(ayam);
        rumahIbuSiti.addSayur(sawi);
        rumahIbuSiti.addSayur(jahe);

        listLokasi.add(tambakBandung);
        listLokasi.add(peternakanGarut);
        listLokasi.add(rumahIbuSiti);
        
        // Person (Pemilik & Pelaku)
        PemilikPerikananKomersil pemilikAli = new PemilikPerikananKomersil("P001", "Ali Mahendra", "Jakarta Selatan", 5);
        PemilikPeternakanKomersil pemilikBudi = new PemilikPeternakanKomersil("P002", "Budi Santoso", "Bandung", 5);
        PelakuRumahSwasembada pelakuSiti = new PelakuRumahSwasembada("P003", "Siti Aisyah", "Cimahi");
        
        // Hubungkan Person ke Lokasi (Komposisi & Asosiasi)
        pemilikAli.addPerikananKomersil(tambakBandung);
        pemilikBudi.addPeternakanKomersil(peternakanGarut);
        pelakuSiti.setRumahDimiliki(rumahIbuSiti);
        
        listPerson.add(pemilikAli);
        listPerson.add(pemilikBudi);
        listPerson.add(pelakuSiti);


        // =================================================================
        // 2. AWAL PROGRAM & COMMAND LOOP
        // =================================================================
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SISTEM PENCATATAN KETAHANAN PANGAN ===");
        System.out.println("Total Lokasi Produksi: " + listLokasi.size());
        System.out.println("----------------------------------------------");
        
        // Mulai loop perintah
        commandLoop(scanner);
        
        scanner.close();
    }
}