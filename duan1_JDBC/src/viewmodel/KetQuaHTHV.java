/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author Dell
 */
public class KetQuaHTHV {
    private int hocKy;
    private String tenLop;
    private String tenMon;
    private float diemGK;
    private float diemTK;
    private String danhGia;
    private int trangThai;
    

    public KetQuaHTHV() {
    }

    public KetQuaHTHV(int hocKy, String tenLop, String tenMon, float diemGK, float diemTK, String danhGia, int trangThai) {
        this.hocKy = hocKy;
        this.tenLop = tenLop;
        this.tenMon = tenMon;
        this.diemGK = diemGK;
        this.diemTK = diemTK;
        this.danhGia = danhGia;
        this.trangThai = trangThai;
    }

   

  
 

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

  
    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public float getDiemGK() {
        return diemGK;
    }

    public void setDiemGK(float diemGK) {
        this.diemGK = diemGK;
    }

    public float getDiemTK() {
        return diemTK;
    }

    public void setDiemTK(float diemTK) {
        this.diemTK = diemTK;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String trangThai(int trangThai){
        if(trangThai==0){
            return "Đạt";
        }else if(trangThai == 1){
            return "Đang Học";
            
        }else{
            return "Học Lại";
        }
    }
    public Object[] torowDaTa(){
        return new Object[]{tenLop,tenMon,diemGK,diemTK,danhGia,trangThai(trangThai)};
    }

    @Override
    public String toString() {
        return "KetQuaHTHV{" + "hocKy=" + hocKy + ", tenLop=" + tenLop + ", tenMon=" + tenMon + ", diemGK=" + diemGK + ", diemTK=" + diemTK + ", danhGia=" + danhGia + ", trangThai=" + trangThai + '}';
    }

  
    
}
