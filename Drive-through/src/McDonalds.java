public class McDonalds {
    private String nazevProduktu;
    private int cenaProduktu;
    private int pozice;

    public McDonalds(String nazevProduktu, int cenaProduktu, int pozice) {
        this.nazevProduktu = nazevProduktu;
        this.cenaProduktu = cenaProduktu;
        this.pozice = pozice;
    }

    @Override
    public String toString() {
        return nazevProduktu;
    }

    public String getNazevProduktu() {
        return nazevProduktu;
    }

    public int getCenaProduktu() {
        return cenaProduktu;
    }

    public int getPozice() {
        return pozice;
    }

    public void setNazevProduktu(String nazevProduktu) {
        this.nazevProduktu = nazevProduktu;
    }

    public void setCenaProduktu(int cenaKoruny) {
        this.cenaProduktu = cenaKoruny;
    }

    public void setPozice(int pozice) {
        this.pozice = pozice;
    }


}
