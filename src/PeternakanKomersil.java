class PeternakanKomersil extends LokasiProduksi implements Komersil {
    private TernakBahanPangan[] daftarTernak;
    private int jumlahKaryawan;
    private int countTernak;

    public PeternakanKomersil(String kode, String nama, String kota, double luas, int maxTernak) {
        super(kode, nama, kota, luas);
        this.daftarTernak = new TernakBahanPangan[maxTernak];
        this.countTernak = 0;
        this.jumlahKaryawan = 0;
    }

    public void addTernak(TernakBahanPangan t) {
        if (countTernak < daftarTernak.length) {
            daftarTernak[countTernak++] = t;
        }
    }
    
    // Implementasi Komersil
    @Override
    public int getJumlahKaryawan() { return jumlahKaryawan; }

    // Getter dan Setter
    public TernakBahanPangan[] getDaftarTernak() { return daftarTernak; }
    public int getCountTernak() { return countTernak; }
    public void setJumlahKaryawan(int jumlahKaryawan) { this.jumlahKaryawan = jumlahKaryawan; }
    // Tambahkan semua Setter dan Getter

    /**
     * INNER CLASS: Digunakan untuk perhitungan statistik.
     */
    public class StatistikProduksi {
        public double hitungTotalBerat() {
            double total = 0;
            for (int i = 0; i < countTernak; i++) {
                total += daftarTernak[i].getBeratKonsumsi();
            }
            return total;
        }
        
        public double getRataRataLamaPelihara() {
            if (countTernak == 0) return 0;
            int totalLama = 0;
            for (int i = 0; i < countTernak; i++) {
                totalLama += daftarTernak[i].getLamaPemeliharaan();
            }
            return (double) totalLama / countTernak;
        }
    }
}
