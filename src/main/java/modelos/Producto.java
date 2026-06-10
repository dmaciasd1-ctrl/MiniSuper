/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
import java.time.LocalDate;
/**
 *
 * @author User
 */
public class Producto {
    private String nombre;
    private int stock;
    private int stockMinimo;
    private int cantidadReorden;
    private LocalDate fechaVencimiento;
    private int stockMaximo;
    private int diasBajaDemanda;
    private int ventasAcumuladasMes;
    
  public Producto(String nombre,int stock,int stockMinimo,int stockMaximo,int cantidadReorden,LocalDate fechaVencimiento) {
    this.nombre = nombre;
    this.stock = stock;
    this.stockMinimo = stockMinimo;
    this.stockMaximo = stockMaximo;
    this.cantidadReorden = cantidadReorden;
    this.fechaVencimiento = fechaVencimiento;
    this.diasBajaDemanda = 0;
    this.ventasAcumuladasMes = 0;
}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getCantidadReorden() {
        return cantidadReorden;
    }

    public void setCantidadReorden(int cantidadReorden) {
        this.cantidadReorden = cantidadReorden;
    }
    
    public boolean estaVencido() {
    return LocalDate.now().isAfter(fechaVencimiento);
}

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public int getDiasBajaDemanda() {
        return diasBajaDemanda;
    }

    public int getVentasAcumuladasMes() {
        return ventasAcumuladasMes;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public void setDiasBajaDemanda(int diasBajaDemanda) {
        this.diasBajaDemanda = diasBajaDemanda;
    }

    public void setVentasAcumuladasMes(int ventasAcumuladasMes) {
        this.ventasAcumuladasMes = ventasAcumuladasMes;
    }
    
    
}
