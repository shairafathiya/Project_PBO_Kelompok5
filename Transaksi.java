import java.util.ArrayList;

public class Transaksi {
    private Customer customer;
    private ArrayList<Barang> barang;

    public Transaksi(Customer customer, ArrayList<Barang> barang) {
        this.customer = customer;
        this.barang = barang;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }

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

