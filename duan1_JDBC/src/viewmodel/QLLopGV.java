/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author HánH
 */
public class QLLopGV {

    private String idLop;
    private String idMonHoc;
    private String idHocVien;
    private String tenMon;
    private String maLop;
    private String tenLop;
    private int slHocVien;
    private int slToiDa;

    public String getIdLop() {
        return idLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public String getIdHocVien() {
        return idHocVien;
    }

    public void setIdHocVien(String idHocVien) {
        this.idHocVien = idHocVien;
    }

    public QLLopGV(String idLop, String idMonHoc, String idHocVien, String tenMon, String maLop, int slHocVien, int slToiDa) {
        this.idLop = idLop;
        this.idMonHoc = idMonHoc;
        this.idHocVien = idHocVien;
        this.tenMon = tenMon;
        this.maLop = maLop;
        this.slHocVien = slHocVien;
        this.slToiDa = slToiDa;
    }

    public QLLopGV() {
    }

    public QLLopGV(String tenMon, String maLop, int slHocVien, int slToiDa) {
        this.tenMon = tenMon;
        this.maLop = maLop;
        this.slHocVien = slHocVien;
        this.slToiDa = slToiDa;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public int getSlHocVien() {
        return slHocVien;
    }

    public void setSlHocVien(int slHocVien) {
        this.slHocVien = slHocVien;
    }

    public int getSlToiDa() {
        return slToiDa;
    }

    public void setSlToiDa(int slToiDa) {
        this.slToiDa = slToiDa;
    }

    @Override
    public String toString() {
        return "QLLopGV{" + "idLop=" + idLop + ", idMonHoc=" + idMonHoc + ", idHocVien=" + idHocVien + ", tenMon=" + tenMon + ", maLop=" + maLop + ", tenLop=" + tenLop + ", slHocVien=" + slHocVien + '}';
    }

}
