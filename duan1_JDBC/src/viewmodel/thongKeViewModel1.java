/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.math.BigDecimal;

/**
 *
 * @author acer
 */
public class thongKeViewModel1 {

    private String idHocVien;
    private BigDecimal tien;

    public thongKeViewModel1() {
    }

    public thongKeViewModel1(String idHocVien, BigDecimal tien) {
        this.idHocVien = idHocVien;
        this.tien = tien;
    }

    public String getIdHocVien() {
        return idHocVien;
    }

    public void setIdHocVien(String idHocVien) {
        this.idHocVien = idHocVien;
    }

    public BigDecimal getTien() {
        return tien;
    }

    public void setTien(BigDecimal tien) {
        this.tien = tien;
    }

}
