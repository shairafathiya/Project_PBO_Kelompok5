public abstract class Pembayaran {
    protected String id;

    public Pembayaran(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - ID: " + id;
    }
}

class QRIS extends Pembayaran {
    public QRIS() {
        super("QRIS001");
    }
}

class Bank extends Pembayaran {
    public Bank() {
        super("BANK001");
    }
}

class COD extends Pembayaran {
    public COD() {
        super("COD001");
    }
}

