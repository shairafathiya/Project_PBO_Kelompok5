import java.util.ArrayList;

public class Keranjang {
    private ArrayList<Barang> barang;

    public Keranjang() {
        barang = new ArrayList<>();
    }

    public void addBarang(Barang barang) {
        this.barang.add(barang);
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }

    public void clear() {
        barang.clear();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Barang b : barang) {
            builder.append(b).append("\n");
        }
        return builder.toString();
    }
}
