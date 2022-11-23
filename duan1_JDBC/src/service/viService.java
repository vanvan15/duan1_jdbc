/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import model.Vi;

/**
 *
 * @author HánH
 */
public interface viService {
    
    Vi getOne(String id);
    
    String getIDHocVien(String ma);
    
    String updateV(String id, Vi v);
    
}
