package Entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private Integer precio;
    @Column
    private Integer stock;

    @OneToMany(mappedBy = "producto",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Carrito> carts = new ArrayList<>();

    @OneToMany(mappedBy = "producto",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<DetalleComprobante> detalleComprobante= new ArrayList<>();

    public Producto() {}

    public Producto(String nombre, Integer precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
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
                ", carts=" + carts +
                '}';
    }
}
