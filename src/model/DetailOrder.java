package model;

import java.util.List;

public class DetailOrder {
    private String orderID;
    private String idProduk;
    private Integer quantity;
    private Integer hargaSatuan;
    private Integer hargaTotal;

    public DetailOrder() {

    }
    
    public DetailOrder(String orderID,String idProduk, Integer quantity, Integer hargaSatuan, Integer hargaTotal) {
        this.orderID = orderID;
        this.idProduk = idProduk;
        this.quantity = quantity;
        this.hargaSatuan = hargaSatuan;
        this.hargaTotal = hargaTotal;
    }

    public String getOrderID() {
        return this.orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getIdProduk() {
        return this.idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getHargaSatuan() {
        return this.hargaSatuan;
    }

    public void setHargaSatuan(Integer hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    public Integer getHargaTotal() {
        return this.hargaTotal;
    }

    public void setHargaTotal(Integer hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

}

