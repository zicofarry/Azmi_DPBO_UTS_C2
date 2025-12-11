class Ikan extends Komoditas {
    private String jenis; // Ikan konsumsi atau ikan hias
    private double beratKonsumsi; // Diisi jika ikan konsumsi
    private int lamaPemeliharaan; // Dalam bulan atau waktu yang relevan

    public Ikan(String kode, String nama, String jenis, double beratKonsumsi, int lamaPemeliharaan) {
        super(kode, nama); 
        this.jenis = jenis;
        this.beratKonsumsi = beratKonsumsi;
        this.lamaPemeliharaan = lamaPemeliharaan;
    }

    // Getter dan Setter
    public String getJenis() { return jenis; }
    public double getBeratKonsumsi() { return beratKonsumsi; }
    public int getLamaPemeliharaan() { return lamaPemeliharaan; }
    
    public void setJenis(String jenis) { this.jenis = jenis; }
    // Tambahkan semua Setter dan Getter
}
