/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author acer
 */
public class LichSuNapTien {

    private String id;
    private BigDecimal tenNap;
    private Date ngayNap;
    private String idVI;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTenNap() {
        return tenNap;
    }

    public void setTenNap(BigDecimal tenNap) {
        this.tenNap = tenNap;
    }

    public Date getNgayNap() {
        return ngayNap;
    }

    public void setNgayNap(Date ngayNap) {
        this.ngayNap = ngayNap;
    }

    public String getIdVI() {
        return idVI;
    }

    public void setIdVI(String idVI) {
        this.idVI = idVI;
    }

    public LichSuNapTien() {
    }

    public LichSuNapTien(String id, BigDecimal tenNap, Date ngayNap, String idVI) {
        this.id = id;
        this.tenNap = tenNap;
        this.ngayNap = ngayNap;
        this.idVI = idVI;
    }

}
