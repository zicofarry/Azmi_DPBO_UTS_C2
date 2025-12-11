class TernakBahanPangan extends Komoditas {
    private double beratKonsumsi;
    private int lamaPemeliharaan; // Dalam bulan

    public TernakBahanPangan(String kode, String nama, double beratKonsumsi, int lamaPemeliharaan) {
        super(kode, nama);
        this.beratKonsumsi = beratKonsumsi;
        this.lamaPemeliharaan = lamaPemeliharaan;
    }

    // Getter dan Setter
    public double getBeratKonsumsi() { return beratKonsumsi; }
    public int getLamaPemeliharaan() { return lamaPemeliharaan; }
    
    public void setBeratKonsumsi(double beratKonsumsi) { this.beratKonsumsi = beratKonsumsi; }
    // Tambahkan semua Setter dan Getter
}
