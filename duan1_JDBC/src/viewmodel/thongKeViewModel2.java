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
public class thongKeViewModel2 {

    private String idMonHoc;
    private BigDecimal tien;

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public BigDecimal getTien() {
        return tien;
    }

    public void setTien(BigDecimal tien) {
        this.tien = tien;
    }

    public thongKeViewModel2() {
    }

    public thongKeViewModel2(String idMonHoc, BigDecimal tien) {
        this.idMonHoc = idMonHoc;
        this.tien = tien;
    }

}
