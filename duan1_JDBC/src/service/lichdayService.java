/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.LichDay;

/**
 *
 * @author HánH
 */
public interface lichdayService {
    List<LichDay> getAll(String ma);
}
