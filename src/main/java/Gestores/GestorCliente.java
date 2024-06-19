package Gestores;

import Entidades.Cliente;
import jakarta.persistence.*;

import java.util.List;

public class GestorCliente {
    //Metodo para CREAR
    public void create(Cliente cliente){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
            //inicialiazar operaciones de Crear actualizar eliminar
            manager.getTransaction().begin();
            //Cliente cliente = new Cliente(nombre, apellido, dni, edad);
            //convertir objeto en fila
            manager.persist(cliente);
            //Enviar los datos
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }

    //Metodo para LEER
    public List<Cliente> readAll(){
        EntityManager manager =  GestorGenerico.getEntityManager();
        List<Cliente> lista =null;
        try {
            //Crear consulta para traer la lista
            lista = manager.createQuery("from Cliente", Cliente.class).getResultList();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
            return lista;
        }
    }

    //Ver cliente por nombre
    public Cliente readByName(String nombre){
        EntityManager manager =  GestorGenerico.getEntityManager();
        Cliente cliente =null;
        try {
            cliente = manager.find(Cliente.class, nombre);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
            return cliente;
        }
    }

    //Actualizar cliente
    public void update(Integer id, String nombre, String apellido, Integer dni, Integer edad){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
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
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }

    //Borrar por nombre
    public void delete(String nombre){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
            manager.getTransaction().begin();
            Cliente cliente = manager.find(Cliente.class, nombre);
            if(cliente != null){
                manager.remove(cliente);
                manager.getTransaction().commit();
            }
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }

}
