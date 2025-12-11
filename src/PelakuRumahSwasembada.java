class PelakuRumahSwasembada extends Person {
    private RumahSwasembadaPangan rumahDimiliki; // Asosiasi 1:1

    public PelakuRumahSwasembada(String noKtp, String nama, String alamat) {
        super(noKtp, nama, alamat);
    }
    
    // Setter dan Getter
    public RumahSwasembadaPangan getRumahDimiliki() { return rumahDimiliki; }
    public void setRumahDimiliki(RumahSwasembadaPangan rumahDimiliki) { this.rumahDimiliki = rumahDimiliki; }
}
