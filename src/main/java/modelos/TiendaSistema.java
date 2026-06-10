/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TiendaSistema {

    private static List<Producto> productos = new ArrayList<>();
    private static Random random = new Random();

    private static String nombreMes;
    private static double factorDemandaMes;

    public void AñadirProducto(Producto p) {
        productos.add(p);
    }

    public static void iniciarMes(String mes) {

        nombreMes = mes;

        // Demanda del mes entre 0.5 y 1.8
        factorDemandaMes = 0.5 + (random.nextDouble() * 1.3);

        System.out.println("\n====================================");
        System.out.println("INICIANDO MES: " + nombreMes);
        System.out.println("Factor de demanda: "
                + String.format("%.2f", factorDemandaMes));
        System.out.println("====================================");
    }

    public static void simularDia(int dia) {

        System.out.println("\n====================================");
        System.out.println("MES: " + nombreMes + " | DIA: " + dia);
        System.out.println("====================================");

        Iterator<Producto> it = productos.iterator();

        while (it.hasNext()) {

            Producto prod = it.next();

            // Variacion pequeña diaria
            double variacion = 0.8 + (random.nextDouble() * 0.4);

            int cantidadVendida =
                    (int) (random.nextInt(7)
                    * factorDemandaMes
                    * variacion);

            // No vender mas de lo disponible
            if (cantidadVendida > prod.getStock()) {
                cantidadVendida = prod.getStock();
            }

            prod.setStock(
                    prod.getStock() - cantidadVendida);

            System.out.println(
                    "[VENTA] "
                    + prod.getNombre()
                    + ": "
                    + cantidadVendida
                    + " unidades."
            );

            // Control de demanda
            if (cantidadVendida <= 1) {

                prod.setDiasBajaDemanda(
                        prod.getDiasBajaDemanda() + 1
                );

            } else {

                prod.setDiasBajaDemanda(0);
            }

            // Producto vencido
            if (prod.estaVencido()) {

                System.out.println(
                        "[RETIRADO] "
                        + prod.getNombre()
                        + " vencido."
                );

                it.remove();
                continue;
            }

            // Producto sin demanda por mucho tiempo
            if (prod.getDiasBajaDemanda() >= 10) {

                System.out.println(
                        "[RETIRADO] "
                        + prod.getNombre()
                        + " por baja demanda."
                );

                it.remove();
                continue;
            }

            // Reabastecimiento inteligente
            if (prod.getStock() <= prod.getStockMinimo()) {

                System.out.println(
                        "[ALERTA] "
                        + prod.getNombre()
                        + " alcanzo stock minimo."
                );

                // No pedir si lleva varios días
                // con poca demanda
                if (prod.getDiasBajaDemanda() >= 5) {

                    System.out.println(
                            "[PEDIDO CANCELADO] "
                            + prod.getNombre()
                            + " tiene baja demanda."
                    );

                } else {

                    int cantidadAPedir =
                            prod.getStockMaximo()
                            - prod.getStock();

                    if (cantidadAPedir > 0) {

                        prod.setStock(
                                prod.getStock()
                                + cantidadAPedir
                        );

                        System.out.println(
                                "[REABASTECIMIENTO] "
                                + prod.getNombre()
                                + " recibio "
                                + cantidadAPedir
                                + " unidades."
                        );

                    } else {

                        System.out.println(
                                "[SIN PEDIDO] "
                                + prod.getNombre()
                                + " ya esta cerca del stock maximo."
                        );
                    }
                }
            }
        }
    }

    public void mostrarInventario() {

        System.out.println(
                "\n------------ INVENTARIO ------------");

        System.out.printf(
                "%-15s %-10s %-10s %-10s%n",
                "Producto",
                "Stock",
                "Min",
                "Max"
        );

        for (Producto p : productos) {

            System.out.printf(
                    "%-15s %-10d %-10d %-10d%n",
                    p.getNombre(),
                    p.getStock(),
                    p.getStockMinimo(),
                    p.getStockMaximo()
            );
        }

        System.out.println("------------------------------------");
    }
}