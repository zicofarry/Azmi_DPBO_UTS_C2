abstract class Komoditas implements Identifiable {
    protected String kode;
    protected String nama;

    public Komoditas(String kode, String nama) {
        this.kode = kode;
        this.nama = nama;
    }
    
    // Implementasi Identifiable
    @Override
    public String getID() { return kode; }
    @Override
    public String getNamaEntitas() { return nama; }

    // Getter dan Setter
    public String getKode() { return kode; }
    public String getNama() { return nama; }

    public void setNama(String nama) { this.nama = nama; }
    // Setter lainnya
}
