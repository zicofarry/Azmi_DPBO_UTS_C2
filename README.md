## Janji

Saya **Muhammad ‘Azmi Salam** dengan **NIM 2406010** mengerjakan soal **UTS** dalam mata kuliah **Desain Pemrograman Berorientasi Objek (DPBO)** untuk keberkahan-Nya maka saya **tidak melakukan kecurangan** seperti yang telah dispesifikasikan.  Aamiin.

## Diagram

Mahzab desain yang saya gunakan untuk membuat diagramnya adalah:
1. Inheritance (Extends): Panah kosong, garis padat
2. Composition: Belah ketupat penuh, garis padat
3. Aggregation: Belah ketupat kosong, garis padat
4. Association: Garis padat tanpa kepala
5. Interface (Implements): Panah Kosong, garis putus-putus

<img width="383" height="351" alt="Image" src="https://github.com/user-attachments/assets/8144f60d-111a-4d21-bec4-8815168dcd54" />

<img width="418" height="364" alt="Image" src="https://github.com/user-attachments/assets/32d0d130-df58-4d73-8c61-7ceeaf649cd8" />

![Diagram Paguyuban Cilok](Dokumentasi/diagram.drawio.png)


## [cite_start]Penjelasan dan Alasan [cite: 87]

### [cite_start]1. Fondasi Hierarki (Kelas Abstrak & Interface) [cite: 88]

[cite_start]Sistem ini dibangun di atas tiga *abstract class* dan tiga *interface* yang berfungsi sebagai kontrak dan kerangka dasar. [cite: 89]

  * **a. [cite_start]Interface Identifiable:** Ini adalah kontrak fundamental yang diterapkan oleh semua entitas utama dalam sistem (`Person`, `Lokasi Produksi`, dan `Komoditas`). [cite: 90] [cite_start]Tujuannya adalah memastikan bahwa setiap objek memiliki cara standar untuk mendapatkan identitas unik (`getID()`) dan nama utama (`getNamaEntitas()`), memfasilitasi penggunaan Polimorfisme pada array data pencarian. [cite: 91]
  * **b. [cite_start]Abstract Class Person:** Kelas ini adalah *superclass* utama untuk semua individu, menyimpan atribut dasar seperti `noKtp`, `nama`, dan `alamat`. [cite: 92] [cite_start]Adanya kelas abstrak ini menjamin konsistensi data identitas melalui *Inheritance* untuk semua peran manusia. [cite: 93]
  * **c. [cite_start]Abstract Class Lokasi Produksi:** Kelas ini berfungsi sebagai *superclass* untuk semua tempat fisik di mana kegiatan produksi (pertanian, perikanan, peternakan) dilakukan. [cite: 94] [cite_start]Atribut yang diwariskan oleh semua lokasi meliputi `kode`, `nama`, `kota`, dan `luas`. [cite: 95]
  * **d. [cite_start]Abstract Class Komoditas:** Kelas ini adalah *superclass* untuk semua hasil produksi biologis yang dikelola, mencakup ternak, ikan, dan sayuran. [cite: 96] Kelas ini menyimpan atribut dasar `kode` dan `nama`. [cite_start]Kelas ini sengaja dibuat umum untuk mengakomodasi entitas non-pangan (seperti ikan hias) tanpa memerlukan hierarki tambahan. [cite: 97]
  * **e. [cite_start]Interface Komersil:** Kontrak ini mendefinisikan perilaku bisnis/operasional komersial, yang spesifiknya adalah memiliki dan melaporkan `getJumlahKaryawan()`. [cite: 98] [cite_start]Interface ini hanya diterapkan oleh `PerikananKomersil` dan `PeternakanKomersil`. [cite: 99]
  * **f. [cite_start]Interface Manajemen Komoditas:** Kontrak ini mendefinisikan kemampuan untuk mengelola tiga jenis komoditas berbeda (`addIkan`, `addTernak`, `addSayur`). [cite: 100] [cite_start]Interface ini diterapkan oleh `RumahSwasembadaPangan` untuk menunjukkan sifatnya sebagai unit produksi yang serba ada. [cite: 101]

### [cite_start]2. Kelas Peran Manusia dan Relasinya [cite: 102]

[cite_start]Semua kelas peran manusia mewarisi dari `Person`. [cite: 103]

  * **a. [cite_start]Kelas Pelaku RumahSwasembada:** Kelas ini mewakili individu yang mengelola lokasi Swasembada Pangan. [cite: 104] [cite_start]Ia memiliki **Asosiasi** (hubungan lemah) dengan objek `RumahSwasembadaPangan` yang mereka kelola. [cite: 105]
  * **b. [cite_start]Kelas Pemilik Perikanan Komersil dan Pemilik Peternakan Komersil:** Kedua kelas ini mewakili pemilik bisnis komersil. [cite: 106] [cite_start]Mereka memiliki relasi **Komposisi** (Kepemilikan Kuat) ke objek lokasi komersil masing-masing (`daftarPerikananKomersil`/`daftarPeternakanKomersil`). [cite: 107] [cite_start]Relasi ini menyiratkan bahwa lokasi komersil tidak dapat ada dalam sistem tanpa adanya pemilik yang mencatatnya. [cite: 108]

### [cite_start]3. Kelas Spesialisasi Lokasi Produksi [cite: 109]

[cite_start]Semua kelas lokasi mewarisi dari `Lokasi Produksi`. [cite: 110]

  * **a. [cite_start]Kelas Perikanan Komersil:** Kelas ini mengimplementasikan `Komersil` dan memiliki atribut `jumlahKaryawan` serta `daftarIkan`. [cite: 111] [cite_start]Hubungan dengan `Ikan` adalah **Asosiasi** (garis padat tanpa kepala), mengakui bahwa ikan yang dicatat masih bisa eksis di luar lokasi komersil tersebut. [cite: 112]
  * **b. [cite_start]Kelas Peternakan Komersil:** Kelas ini juga mengimplementasikan `Komersil` dan memiliki `jumlahKaryawan` dan `daftarTernak`. [cite: 113]
  * **c. [cite_start]Inner Class Statistik Produksi:** Kelas ini ditempatkan di dalam `PeternakanKomersil` (atau `PerikananKomersil` sesuai implementasi) untuk meningkatkan **Enkapsulasi**. [cite: 114] [cite_start]*Inner Class* ini bertugas menghitung statistik internal (misalnya, total berat ternak atau rata-rata lama pemeliharaan) dengan akses langsung ke array data *private* milik *Outer Class*. [cite: 115]
  * **d. [cite_start]Kelas RumahSwasembada Pangan:** Kelas ini mewarisi `Lokasi Produksi` dan mengimplementasikan `ManajemenKomoditas`. [cite: 116] [cite_start]Ia memiliki tiga array berbeda untuk komoditas: `daftarIkan`, `daftarTernak`, dan `daftarSayurRempah`, yang mencerminkan sifatnya sebagai unit produksi multisektor. [cite: 117]

### [cite_start]4. Kelas Spesialisasi Komoditas [cite: 118]

[cite_start]Semua kelas komoditas mewarisi dari `Komoditas`. [cite: 119]

  * **a. [cite_start]Kelas Ikan:** Mewarisi dari `Komoditas` dan memiliki atribut `jenis` (konsumsi/hias), `beratKonsumsi`, dan `lamaPemeliharaan`. [cite: 120]
  * **b. [cite_start]Kelas Ternak Bahan Pangan:** Mewarisi dari `Komoditas` dengan atribut `beratKonsumsi` dan `lamaPemeliharaan`, difokuskan pada hasil ternak untuk pangan. [cite: 121]
  * **c. [cite_start]Kelas Sayur Rempah:** Mewarisi dari `Komoditas` dengan atribut `jenis` (sayur/rempah). [cite: 122]

### [cite_start]5. Fitur Utama Main [cite: 123]

Kelas `Main` melakukan inisialisasi semua data *hardcode* dan menjalankan *command loop* interaktif. [cite_start]Fitur utamanya adalah: [cite: 124]

  * **a. [cite_start]Perintah `all`:** Menampilkan detail lengkap (termasuk semua data yang terhubung melalui Komposisi dan Agregasi) dari semua lokasi produksi. [cite: 125]
  * **b. [cite_start]Perintah `cari`:** Memungkinkan pengguna mencari detail spesifik dari suatu lokasi produksi berdasarkan nama lokasi. [cite: 126] [cite_start]Output pencarian menampilkan seluruh data yang terhubung, termasuk pemilik, jumlah karyawan, dan daftar komoditas di dalamnya. [cite: 127]
  * **c. [cite_start]Perintah `exit`:** Mengakhiri program. [cite: 128]



Hasil Program
1. Tampilkan Semua Lokasi Produksi
   ![foto1](Dokumentasi/Screenshot%202025-10-21%20133206.png)
   ![foto2](Dokumentasi/Screenshot%202025-10-21%20132227.png)

2. Tampilkan berdasarkan Pencarian (Tambak Makmur)
   ![foto3](Dokumentasi/Screenshot%202025-10-21%20132619.png)

3. Tampilkan berdasarkan Pencarian (Peternakan Sejahtera)
   ![foto4](Dokumentasi/Screenshot%202025-10-21%20132754.png)

4. Tampilkan Berdasarkan Pencarian (Swasembada Mandiri)
   ![foto5](Dokumentasi/Screenshot%202025-10-21%20132844.png)



