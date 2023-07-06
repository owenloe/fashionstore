package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderID;
    private String tanggalPesanan;
    private Integer hargaTotal;
    private String karyawan;
    private String customerName;
    private String customerPhoneNumber;
    private List<DetailOrder> detailOrderList;
    

    public Order() {
        detailOrderList = new ArrayList<>();
    }

    public Order(String orderID, String customerName, String customerPhoneNumber, String tanggalPesanan, Integer hargaTotal, String karyawan) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.tanggalPesanan = tanggalPesanan;
        this.hargaTotal = hargaTotal;
        this.karyawan = karyawan;
        detailOrderList = new ArrayList<>();
    }

   // public String getDetailOrderList(){
        //return 
   // }

    //public String setDetailOrderList(){
     //   this.
    //}

    public List<DetailOrder> getDetailOrderList() {
        return detailOrderList;
    }

    public void setDetailOrderList(List<DetailOrder> detailOrderList) {
        this.detailOrderList = detailOrderList;
    }
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getTanggalPesanan() {
        return tanggalPesanan;
    }

    public void setTanggalPesanan(String tanggalPesanan) {
        this.tanggalPesanan = tanggalPesanan;
    }

    public Integer getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(Integer hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public String getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(String karyawan) {
        this.karyawan = karyawan;
    }

     public void addDetailOrder(DetailOrder detailOrder) {
        detailOrderList.add(detailOrder);
    }
    
    public void removeDetailOrder(DetailOrder detailOrder) {
        detailOrderList.remove(detailOrder);
    }

    @Override
    public String toString() {
        return "{" +
                " orderID='" + orderID + "'" +
                ", customerName='" + customerName + "'" +
                ", customerPhoneNumber='" + customerPhoneNumber + "'" +
                ", tanggalPesanan='" + tanggalPesanan + "'" +
                ", hargaTotal='" + hargaTotal + "'" +
                ", karyawan='" + karyawan + "'" +
                ", detailOrderList='" + detailOrderList + "'" +
                "}";
    }

}
