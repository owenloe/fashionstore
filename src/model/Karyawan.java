package model;

public class Karyawan {
    private String idKaryawan;
    private String namaKaryawan;
    private String nomorTeleponKaryawan;
    private String jabatan;
    private String departemen;
    private String gaji;

    public Karyawan() {
    }

    public Karyawan(String idKaryawan, String namaKaryawan, String nomorTeleponKaryawan, String jabatan, String departemen, String gaji) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.nomorTeleponKaryawan = nomorTeleponKaryawan;
        this.jabatan = jabatan;
        this.departemen = departemen;
        this.gaji = gaji;
    }

    public String getIdKaryawan() {
        return this.idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return this.namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
    }

    public String getNomorTeleponKaryawan() {
        return this.nomorTeleponKaryawan;
    }

    public void setNomorTeleponKaryawan(String nomorTeleponKaryawan) {
        this.nomorTeleponKaryawan = nomorTeleponKaryawan;
    }

    public String getJabatan() {
        return this.jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getDepartemen() {
        return this.departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getGaji() {
        return this.gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

}
