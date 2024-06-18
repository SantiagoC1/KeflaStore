package Entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer precio;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id",nullable = false)
    private Producto producto;

    public Carrito() {}

    public Carrito(Integer precio, Integer cantidad, Cliente cliente, Producto producto) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.producto = producto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return Objects.equals(id, carrito.id) && Objects.equals(precio, carrito.precio) && Objects.equals(cantidad, carrito.cantidad) && Objects.equals(cliente, carrito.cliente) && Objects.equals(producto, carrito.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, precio, cantidad, cliente, producto);
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", cliente=" + cliente +
                ", producto=" + producto +
                '}';
    }
}
