class PemilikPerikananKomersil extends Person {
    // Komposisi: Pemilik memegang list pabrik komersil yang dimilikinya
    private PerikananKomersil[] daftarPerikananKomersil; 
    private int count;

    public PemilikPerikananKomersil(String noKtp, String nama, String alamat, int maxPabrik) {
        super(noKtp, nama, alamat);
        this.daftarPerikananKomersil = new PerikananKomersil[maxPabrik];
        this.count = 0;
    }

    public void addPerikananKomersil(PerikananKomersil pk) {
        if (count < daftarPerikananKomersil.length) {
            daftarPerikananKomersil[count++] = pk;
        }
    }
    
    // Getter dan Setter
    public PerikananKomersil[] getDaftarPerikananKomersil() { return daftarPerikananKomersil; }
    public int getCount() { return count; }
    // Tambahkan semua Setter dan Getter
}
