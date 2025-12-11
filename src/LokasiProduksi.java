abstract class LokasiProduksi implements Identifiable {
    protected String kode;
    protected String nama;
    protected String kota;
    protected double luas; // Dalam meter persegi

    public LokasiProduksi(String kode, String nama, String kota, double luas) {
        this.kode = kode;
        this.nama = nama;
        this.kota = kota;
        this.luas = luas;
    }

    // Implementasi Identifiable
    @Override
    public String getID() { return kode; }
    @Override
    public String getNamaEntitas() { return nama; }

    // Getter dan Setter
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public String getKota() { return kota; }
    public double getLuas() { return luas; }

    public void setLuas(double luas) { this.luas = luas; }
    // Tambahkan semua Setter dan Getter
}
