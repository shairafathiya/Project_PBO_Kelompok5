import java.util.ArrayList;

// Kelas ini merepresentasikan keranjang belanja yang dapat menyimpan daftar barang.
public class Keranjang {
    private ArrayList<Barang> barang;

     // Konstruktor untuk menginisialisasi objek Keranjang dan membuat daftar barang kosong.
    public Keranjang() {
        barang = new ArrayList<>();
    }

    // Metode untuk menambahkan barang ke dalam keranjang.
    public void addBarang(Barang barang) {
        this.barang.add(barang);
    }

     // Metode untuk mendapatkan daftar barang yang ada dalam keranjang.
    public ArrayList<Barang> getBarang() {
        return barang;
    }

    // Metode untuk menghapus semua barang dalam keranjang.
    public void clear() {
        barang.clear();
    }

    // Metode toString() untuk mengembalikan representasi string dari semua barang dalam keranjang.
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Barang b : barang) {
            builder.append(b).append("\n");
        }
        return builder.toString();
    }
}
