package model;

public class Settlement {
    public String orderID;
    private String status;
    private String metode;

    public Settlement() {

    }

    public Settlement(String orderID,String status, String metode) {
        this.orderID = orderID;
        this.status = status;
        this.metode = metode;
    }

    public String getOrderID() {
        return this.orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMetode() {
        return this.metode;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

}
