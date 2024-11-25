import java.util.ArrayList;

public class ListBarang {
    private ArrayList<Barang> barangList;
    private int idCounter = 1;

    public ListBarang() {
        barangList = new ArrayList<>();
    }

    public void addBarang(Barang barang) {
        barangList.add(barang);
    }

    public boolean removeBarang(String id) {
        return barangList.removeIf(barang -> barang.getId().equals(id));
    }

    public boolean editHarga(String id, double hargaBaru) {
        for (Barang barang : barangList) {
            if (barang.getId().equals(id)) {
                barang.setHarga(hargaBaru);
                return true;
            }
        }
        return false;
    }

    public Barang getBarang(String id) {
        for (Barang barang : barangList) {
            if (barang.getId().equals(id)) {
                return barang;
            }
        }
        return null;
    }

    public String generateId() {
        return String.valueOf(idCounter++);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Barang barang : barangList) {
            builder.append(barang).append("\n");
        }
        return builder.toString();
    }
}
