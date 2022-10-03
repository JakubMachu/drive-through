public class BankovniUcet {
    private int cisloUctu;
    private String typUctu;
    private String majitelUctu;
    private long aktualniZustatek;

    public BankovniUcet(int cisloUctu, String typUctu, String majitelUctu, long aktualniZustatek) {
        this.cisloUctu = cisloUctu;
        this.typUctu = typUctu;
        this.majitelUctu = majitelUctu;
        this.aktualniZustatek = aktualniZustatek;
    }

    public int getCisloUctu() {
        return cisloUctu;
    }

    public String getTypUctu() {
        return typUctu;
    }

    public String getMajitelUctu() {
        return majitelUctu;
    }

    public long getAktualniZustatek() {
        return aktualniZustatek;
    }

    public void setCisloUctu(int cisloUctu) {
        this.cisloUctu = cisloUctu;
    }

    public void setTypUctu(String typUctu) {
        this.typUctu = typUctu;
    }

    public void setMajitelUctu(String majitelUctu) {
        this.majitelUctu = majitelUctu;
    }

    public void setAktualniZustatek(long aktualniZustatek) {
        this.aktualniZustatek = aktualniZustatek;
    }
}
