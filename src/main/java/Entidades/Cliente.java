package Entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cliente {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Integer dni;
    @Column
    private Integer edad;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Carrito> carts = new ArrayList<>();

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Comprobante> comprobantes= new ArrayList<>();




    public Cliente() {}

    public Cliente(String nombre, String apellido, Integer dni, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(dni, cliente.dni) && Objects.equals(edad, cliente.edad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni, edad);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", edad=" + edad +
                ", carrito=" + carts +
                '}';
    }
}
