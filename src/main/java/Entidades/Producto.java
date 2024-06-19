package Entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String nombre;
    private double precio;
    private Integer stock;

    //se declaran las relaciones entre tablas
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Carrito> carts = new ArrayList<>();

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DetalleComprobante> detalleComprobante= new ArrayList<>();

    //Declaracion de constructores
    public Producto() {}

    public Producto(String nombre, double precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    //declaracion getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public List<Carrito> getCarts() {
        return carts;
    }

    public void setCarts(List<Carrito> carts) {
        this.carts = carts;
    }

    //declaracion metodos equals hashcode y toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id) && Objects.equals
                (nombre, producto.nombre) && Objects.equals(precio, producto.precio) && Objects.equals(stock, producto.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, precio, stock);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", carts=" + carts.stream().map(Carrito::getId).collect(Collectors.toList()) +
                ", detalleComprobante=" + detalleComprobante.stream().map(DetalleComprobante::getId).collect(Collectors.toList()) +
                '}';
    }
}
