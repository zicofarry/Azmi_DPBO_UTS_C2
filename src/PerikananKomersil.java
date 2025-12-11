class PerikananKomersil extends LokasiProduksi implements Komersil {
    private Ikan[] daftarIkan;
    private int jumlahKaryawan;
    private int countIkan;

    public PerikananKomersil(String kode, String nama, String kota, double luas, int maxIkan) {
        super(kode, nama, kota, luas);
        this.daftarIkan = new Ikan[maxIkan];
        this.countIkan = 0;
        this.jumlahKaryawan = 0;
    }

    public void addIkan(Ikan i) {
        if (countIkan < daftarIkan.length) {
            daftarIkan[countIkan++] = i;
        }
    }

    // Implementasi Komersil
    @Override
    public int getJumlahKaryawan() { return jumlahKaryawan; }

    // Getter dan Setter
    public Ikan[] getDaftarIkan() { return daftarIkan; }
    public int getCountIkan() { return countIkan; }
    public void setJumlahKaryawan(int jumlahKaryawan) { this.jumlahKaryawan = jumlahKaryawan; }
    // Tambahkan semua Setter dan Getter
}
