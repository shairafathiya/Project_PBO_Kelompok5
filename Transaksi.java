import java.util.ArrayList;

public class Transaksi {
    // Atribut customer dan daftar barang yang dibeli
    private Customer customer;
    private ArrayList<Barang> barang;

    // Konstruktor Transaksi dengan parameter customer dan daftar barang
    public Transaksi(Customer customer, ArrayList<Barang> barang) {
        this.customer = customer;
        this.barang = barang;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Getter untuk daftar barang
    public ArrayList<Barang> getBarang() {
        return barang;
    }

    // Override metode toString untuk memberikan informasi transaksi
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Transaksi oleh: ").append(customer.getUsername()).append("\n");
        for (Barang b : barang) {
            builder.append(b).append("\n");
        }
        return builder.toString();
    }
}

