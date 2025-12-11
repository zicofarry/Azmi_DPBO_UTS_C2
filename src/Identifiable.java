/**
 * Interface untuk mendefinisikan kontrak identitas dasar (ID dan Nama)
 * yang harus dimiliki oleh entitas utama (Orang, Lokasi, Komoditas).
 */
interface Identifiable {
    String getID();
    String getNamaEntitas();
}
