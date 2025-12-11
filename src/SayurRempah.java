class SayurRempah extends Komoditas {
    private String jenis; // Sayur atau Rempah

    public SayurRempah(String kode, String nama, String jenis) {
        super(kode, nama);
        this.jenis = jenis;
    }

    // Getter dan Setter
    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }
    // Tambahkan semua Setter dan Getter
}
