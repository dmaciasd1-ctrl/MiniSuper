/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minisuper;

import java.time.LocalDate;
import java.time.YearMonth;
import modelos.Producto;
import modelos.TiendaSistema;
import static modelos.TiendaSistema.simularDia;

/**
 *
 * @author User
 */
public class MiniSuper {

    public static void main(String[] args) {
        TiendaSistema minisuper = new TiendaSistema();
        
        Producto p1 = new Producto("Leche", 20, 5 ,40, 10,LocalDate.of(2026,06,15));
        Producto p2 = new Producto ("papas" , 15 , 3 ,15, 5,LocalDate.of(2026,07,20));
        Producto p3 = new Producto ("gaseosa", 30 , 10,20, 10,LocalDate.of(2026,6,20));
        //hola mundo
        minisuper.AñadirProducto(p1);
        minisuper.AñadirProducto(p2);
        minisuper.AñadirProducto(p3);
        
        int anioActual = 2026;
        int mesActual = 1;
        
        String[] meses = {
        "","Enero", "Febrero", "Marzo", "Abril",
        "Mayo", "Junio", "Julio", "Agosto",
        "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        int indiceMes = 0;
     
        while(true){
            
            YearMonth yearMonth = YearMonth.of(anioActual, mesActual);
            int diasDelMes = yearMonth.lengthOfMonth();
            TiendaSistema.iniciarMes(meses[mesActual]);
            

            for(int dia = 27; dia <= diasDelMes; dia++){

                TiendaSistema.simularDia(dia);
                minisuper.mostrarInventario();
                
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            mesActual++;
            if (mesActual > 12) {
                mesActual = 1;
                anioActual++;
            }
        }
    }  
}
