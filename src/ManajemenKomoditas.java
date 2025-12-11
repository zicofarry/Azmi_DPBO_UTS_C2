/**
 * Interface untuk mendefinisikan kontrak kemampuan mengelola berbagai jenis komoditas.
 * Diimplementasikan oleh RumahSwasembadaPangan.
 */
interface ManajemenKomoditas {
    void addIkan(Ikan i);
    void addTernak(TernakBahanPangan t);
    void addSayur(SayurRempah s);
}
