// Kelas Barang merepresentasikan barang dengan atribut ID, nama, dan harga.
public class Barang {
    private String id;
    private String nama;
    private double harga;

    // Konstruktor untuk inisialisasi objek Barang dengan ID, nama, dan harga
    public Barang(String id, String nama, double harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }

    // Getter untuk mendapatkan ID barang
    public String getId() {
        return id;
    }

    // Getter untuk mendapatkan nama barang
    public String getNama() {
        return nama;
    }

    // Getter untuk mendapatkan harga barang
    public double getHarga() {
        return harga;
    }

    // Setter untuk mengubah harga barang
    public void setHarga(double harga) {
        this.harga = harga;
    }

     // Override method toString untuk menampilkan informasi barang dalam format yang mudah dibaca
    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Harga: Rp " + harga;
    }
}
