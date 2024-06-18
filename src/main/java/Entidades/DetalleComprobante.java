package Entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class DetalleComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer cantidad;

    @Column
    private Double precioU;

    @Column
    private Double subTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comprobante_id")
    private Comprobante comprobante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Producto producto;

    public DetalleComprobante() {}

    public DetalleComprobante(Integer cantidad, Double precioU, Comprobante comprobante, Producto producto) {
        this.cantidad = cantidad;
        this.precioU = precioU;
        this.subTotal = cantidad*precioU;
        this.comprobante = comprobante;
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioU() {
        return precioU;
    }

    public void setPrecioU(Double precioU) {
        this.precioU = precioU;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Comprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(Comprobante comprobante) {
        this.comprobante = comprobante;
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
        DetalleComprobante that = (DetalleComprobante) o;
        return Objects.equals(id, that.id) && Objects.equals(cantidad, that.cantidad) && Objects.equals(precioU, that.precioU) && Objects.equals(subTotal, that.subTotal) && Objects.equals(comprobante, that.comprobante) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, precioU, subTotal, comprobante, producto);
    }

    @Override
    public String toString() {
        return "DetalleComprobante{" +
                "id=" + id +
                ", cantidad=" + cantidad +
                ", precioU=" + precioU +
                ", subTotal=" + subTotal +
                ", comprobante=" + comprobante +
                ", producto=" + producto +
                '}';
    }
}
