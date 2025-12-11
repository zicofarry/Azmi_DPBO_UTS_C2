class RumahSwasembadaPangan extends LokasiProduksi implements ManajemenKomoditas {
    private Ikan[] daftarIkan;
    private TernakBahanPangan[] daftarTernak;
    private SayurRempah[] daftarSayurRempah;
    private int countIkan, countTernak, countSayur;

    public RumahSwasembadaPangan(String kode, String nama, String kota, double luas, int maxSlot) {
        super(kode, nama, kota, luas);
        this.daftarIkan = new Ikan[maxSlot];
        this.daftarTernak = new TernakBahanPangan[maxSlot];
        this.daftarSayurRempah = new SayurRempah[maxSlot];
    }

    // Implementasi ManajemenKomoditas
    @Override
    public void addIkan(Ikan i) {
        if (countIkan < daftarIkan.length) daftarIkan[countIkan++] = i;
    }

    @Override
    public void addTernak(TernakBahanPangan t) {
        if (countTernak < daftarTernak.length) daftarTernak[countTernak++] = t;
    }

    @Override
    public void addSayur(SayurRempah s) {
        if (countSayur < daftarSayurRempah.length) daftarSayurRempah[countSayur++] = s;
    }
    
    // Getter dan Setter
    public Ikan[] getDaftarIkan() { return daftarIkan; }
    public int getCountIkan() { return countIkan; }
    public TernakBahanPangan[] getDaftarTernak() { return daftarTernak; }
    public int getCountTernak() { return countTernak; }
    public SayurRempah[] getDaftarSayurRempah() { return daftarSayurRempah; }
    public int getCountSayur() { return countSayur; }
    // Tambahkan semua Setter dan Getter
}
