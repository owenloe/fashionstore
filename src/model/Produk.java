package model;

public class Produk {
    private String idProduk;
    private String merkProduk;
    private String namaProduk;
    private String kategoriProduk;
    private Integer hargaProduk;
    private Integer stokProduk;
    private String warnaProduk;
    private String ukuranProduk;

    public Produk() {

    }
    public Produk(String idProduk,
    String merkProduk,
     String namaProduk,
     String kategoriProduk,
     Integer hargaProduk,
     Integer stokProduk,
     String warnaProduk,
     String ukuranProduk) {
        this.merkProduk = merkProduk;
        this.namaProduk = namaProduk;
        this.kategoriProduk = kategoriProduk;
        this.hargaProduk = hargaProduk;
        this.stokProduk = stokProduk;
        this.warnaProduk = warnaProduk;
        this.ukuranProduk = ukuranProduk;

     }

    public String getIdProduk() {
        return this.idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getMerkProduk() {
        return this.merkProduk;
    }

    public void setMerkProduk(String merkProduk) {
        this.merkProduk = merkProduk;
    }

    public String getNamaProduk() {
        return this.namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getKategoriProduk() {
        return this.kategoriProduk;
    }

    public void setKategoriProduk(String kategoriProduk) {
        this.kategoriProduk = kategoriProduk;
    }

    public Integer getHargaProduk() {
        return this.hargaProduk;
    }

    public void setHargaProduk(Integer hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public Integer getStokProduk() {
        return this.stokProduk;
    }

    public void setStokProduk(Integer stokProduk) {
        this.stokProduk = stokProduk;
    }

    public String getWarnaProduk() {
        return this.warnaProduk;
    }

    public void setWarnaProduk(String warnaProduk) {
        this.warnaProduk = warnaProduk;
    }

    public String getUkuranProduk() {
        return this.ukuranProduk;
    }

    public void setUkuranProduk(String ukuranProduk) {
        this.ukuranProduk = ukuranProduk;
    }
    public Object getProductName() {
        return null;
    }

}
