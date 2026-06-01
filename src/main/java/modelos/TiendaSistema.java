/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author User
 */
public class TiendaSistema {
    private static List<Producto> productos = new ArrayList<>();

    public TiendaSistema() {
        
    }
    
    private static Random random = new Random();
    
    public static void simularDia(int dia) {
        System.out.println("\n=========================================");
        System.out.println("       SIMULANDO DIA " + dia);
        System.out.println("=========================================");

        for (Producto prod : productos) {
            // Clientes compran una cantidad aleatoria entre 0 y 6 unidades
            int cantidadVendida = random.nextInt(7); 

            // Control de flujo: No vender más de lo que existe
            if (cantidadVendida > prod.getStock()) {
                cantidadVendida = prod.getStock();
            }

            // Salida del sistema: El stock disminuye por la demanda del entorno
            prod.setStock(prod.getStock()-cantidadVendida);
            if (cantidadVendida > 0) {
                System.out.println("[VENTA] Se vendieron " + cantidadVendida + " unidades de " + prod.getNombre() + ".");
            }

            // --- SUBSISTEMA DE RETROALIMENTACIÓN (Mecanismo Homeostático) ---
            // Evaluación en tiempo real: ¿El stock tocó o bajó del mínimo crítico?
            if (prod.getStock() <= prod.getStockMinimo()) {
                System.out.println("[ALERTA CRITICA] " + prod.getNombre() + " cayo a nivel critico (" + prod.getStock()+ " unidades).");
                System.out.println("  Activando bucle de control: Generando orden de compra automatica...");
                
                // Acción correctiva para devolver la estabilidad al sistema
                prod.setStock(prod.getStock()+prod.getCantidadReorden());
                System.out.println("   [REABASTECIMIENTO] Proveedor entrego " + prod.getCantidadReorden() + " unidades. Nuevo stock: " + prod.getStock());
            }
        }
    }
    
    public void AñadirProducto(Producto e){
        productos.add(e);
    }
    
    public void mostrarInventario() {
        System.out.println("\n--- ESTADO ACTUAL DEL INVENTARIO ---");
        System.out.printf("%-15s | %-12s | %-12s\n", "Producto", "Stock Actual", "Stock Minimo");
        System.out.println("-------------------------------------------------");
        for (Producto prod : productos) {
            System.out.printf("%-15s | %-12d | %-12d\n", prod.getNombre(), prod.getStock(), prod.getStockMinimo());
        }
        System.out.println("-------------------------------------------------");
    }
}
