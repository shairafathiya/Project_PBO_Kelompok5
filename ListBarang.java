import java.util.ArrayList;

public class ListBarang {
    // Atribut daftar barang dan counter untuk ID barang
    private ArrayList<Barang> barangList;
    private int idCounter = 1;

    // Konstruktor untuk inisialisasi daftar barang
    public ListBarang() {
        barangList = new ArrayList<>();
    }

    // Menambahkan barang ke dalam daftar
    public void addBarang(Barang barang) {
        barangList.add(barang);
    }

     // Menghapus barang dari daftar berdasarkan ID
    public boolean removeBarang(String id) {
        return barangList.removeIf(barang -> barang.getId().equals(id));
    }

    // Mengubah harga barang berdasarkan ID
    public boolean editHarga(String id, double hargaBaru) {
        for (Barang barang : barangList) {
            if (barang.getId().equals(id)) {
                barang.setHarga(hargaBaru);
                return true;
            }
        }
        return false;
    }

     // Mendapatkan barang berdasarkan ID
    public Barang getBarang(String id) {
        for (Barang barang : barangList) {
            if (barang.getId().equals(id)) {
                return barang;
            }
        }
        return null;
    }

     // Menghasilkan ID baru untuk barang
    public String generateId() {
        return String.valueOf(idCounter++);
    }

    // Override metode toString untuk menampilkan daftar barang
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Barang barang : barangList) {
            builder.append(barang).append("\n");
        }
        return builder.toString();
    }
    
    // Mendapatkan daftar barang sebagai iterable
    Iterable<Barang> getBarangList() {
    return  barangList;
    }
}
