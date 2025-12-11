abstract class Person implements Identifiable {
    protected String noKtp;
    protected String nama;
    protected String alamat;

    public Person(String noKtp, String nama, String alamat) {
        this.noKtp = noKtp;
        this.nama = nama;
        this.alamat = alamat;
    }

    // Implementasi Identifiable
    @Override
    public String getID() { return noKtp; }
    @Override
    public String getNamaEntitas() { return nama; }

    // Getter dan Setter
    public String getNoKtp() { return noKtp; }
    public String getNama() { return nama; }
    public String getAlamat() { return alamat; }

    public void setAlamat(String alamat) { this.alamat = alamat; }
    // Setter lainnya
}
