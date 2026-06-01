/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minisuper;

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
        
        Producto p1 = new Producto("Leche", 20, 5 , 10);
        Producto p2 = new Producto ("papas" , 15 , 3 , 5);
        Producto p3 = new Producto ("gaseosa", 30 , 10, 10);
        
        minisuper.AñadirProducto(p1);
        minisuper.AñadirProducto(p2);
        minisuper.AñadirProducto(p3);
        
        for(int dia = 1 ; dia <= 5; dia++){
            simularDia(dia);
            minisuper.mostrarInventario();
            // Pausa de 2 segundos entre días para simular el paso del tiempo en consola
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Error en la linea de tiempo de la simulación.");
            }
            
            System.out.println("\nSimulacion finalizada con exito.");
            
        }
    }

    
}
