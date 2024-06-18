package Gestores;

import Entidades.Cliente;
import jakarta.persistence.*;

import java.util.List;

public class GestorCliente {
    //Metodo para CREAR
    public void create(String nombre, String apellido, Integer dni, Integer edad){
        EntityManager manager =  GestorGenerico.getEntityManager();
        //inicialiazar operaciones de Crear actualizar eliminar
        manager.getTransaction().begin();
        Cliente cliente = new Cliente(nombre, apellido, dni, edad);
        //convertir objeto en fila
        manager.persist(cliente);
        //Enviar los datos
        manager.getTransaction().commit();
        manager.close();

    }

    //Metodo para LEER
    public List<Cliente> readAll(){
        EntityManager manager =  GestorGenerico.getEntityManager();
        //Crear consulta para traer la lista
        List<Cliente> lista = manager.createQuery("from Cliente", Cliente.class).getResultList();
        manager.close();
        return lista;
    }

    //Ver cliente por nombre
    public Cliente readByName(String nombre){
        EntityManager manager =  GestorGenerico.getEntityManager();
        Cliente cliente = manager.find(Cliente.class, nombre);
        manager.close();
        return cliente;
    }

    //Actualizar cliente
    public void update(Integer id, String nombre, String apellido, Integer dni, Integer edad){
        EntityManager manager =  GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = manager.find(Cliente.class, id);
        if(cliente != null){
            if(nombre != null){
                cliente.setNombre(nombre);
            }
            if(apellido != null){
                cliente.setApellido(apellido);
            }
            if(dni != null){
                cliente.setDni(dni);
            }
            if(edad != null){
                cliente.setEdad(edad);
            }
            manager.merge(cliente);
            manager.getTransaction().commit();
        }
        manager.close();
    }

    //Borrar por nombre
    public void delete(String nombre){
        EntityManager manager =  GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = manager.find(Cliente.class, nombre);
        if(cliente != null){
            manager.remove(cliente);
            manager.getTransaction().commit();
        }
        manager.close();

    }



}
