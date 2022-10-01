package com.example.jmpjava;

public class Modal {
    private String namaUser;
    private String alamatUser;
    private String nomorUser;
    private String lokasiUser;
    private int id;

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getAlamatUser() {
        return alamatUser;
    }

    public void setAlamatUser(String alamatUser) {
        this.alamatUser = alamatUser;
    }

    public String getNomorUser() {
        return nomorUser;
    }

    public void setNomorUser(String nomorUser) {
        this.nomorUser = nomorUser;
    }

    public String getLokasiUser() {
        return lokasiUser;
    }

    public void setLokasiUser(String lokasiUser) {
        this.lokasiUser = lokasiUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modal(String namaUser, String alamatUser, String nomorUser, String lokasiUser) {
        this.namaUser = namaUser;
        this.alamatUser = alamatUser;
        this.nomorUser = nomorUser;
        this.lokasiUser = lokasiUser;
        this.id = id;
    }
}
