class PemilikPeternakanKomersil extends Person {
    // Komposisi
    private PeternakanKomersil[] daftarPeternakanKomersil;
    private int count;

    public PemilikPeternakanKomersil(String noKtp, String nama, String alamat, int maxPabrik) {
        super(noKtp, nama, alamat);
        this.daftarPeternakanKomersil = new PeternakanKomersil[maxPabrik];
        this.count = 0;
    }

    public void addPeternakanKomersil(PeternakanKomersil pk) {
        if (count < daftarPeternakanKomersil.length) {
            daftarPeternakanKomersil[count++] = pk;
        }
    }
    
    // Getter dan Setter
    public PeternakanKomersil[] getDaftarPeternakanKomersil() { return daftarPeternakanKomersil; }
    public int getCount() { return count; }
    // Tambahkan semua Setter dan Getter
}
