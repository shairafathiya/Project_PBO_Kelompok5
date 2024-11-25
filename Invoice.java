import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Invoice {
    private Transaksi transaksi;
    private Pembayaran pembayaran;

    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }

    @Override
    public String toString() {
         try (BufferedWriter catat  = new BufferedWriter(new FileWriter("Invoice.txt"))) {
           catat.write("Invoice:\n" +transaksi + "Metode Pembayaran: " + pembayaran);

        } catch (IOException ex) {
        }
           

        return "Invoice:\n" + transaksi + "Metode Pembayaran: " + pembayaran;
    }
}

