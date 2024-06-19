package Entidades;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Comprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime fecha;

    @Column
    private String estado;

    //se declaran las relaciones entre tablas
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "comprobante",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DetalleComprobante> detalles = new ArrayList<>();

    //Declaracion de constructores
    public Comprobante() {}

    public Comprobante(LocalDateTime fecha, String estado, Cliente cliente) {
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
    }
    //declaracion getters y setters
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleComprobante> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleComprobante> detalles) {
        this.detalles = detalles;
    }

    public Integer getId() {
        return id;
    }


    //declaracion metodos equals hashcode y toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comprobante that = (Comprobante) o;
        return Objects.equals(id, that.id) && Objects.equals(fecha, that.fecha) && Objects.equals(estado, that.estado) && Objects.equals(cliente, that.cliente) && Objects.equals(detalles, that.detalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, estado, cliente, detalles);
    }

    @Override
    public String toString() {
        return "Comprobante{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", clienteId=" + (cliente != null ? cliente.getId() : null) +
                ", detalles=" + detalles.stream().map(DetalleComprobante::getId).collect(Collectors.toList()) +
                '}';
    }
}
