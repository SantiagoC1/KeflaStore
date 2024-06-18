package Gestores;

import Entidades.Cliente;
import Entidades.Producto;
import jakarta.persistence.*;

import java.util.List;

public class GestorProducto {
    //Metodo para CREAR
    public void create(Producto producto){
        EntityManager manager =  GestorGenerico.getEntityManager();
        //inicialiazar operaciones de Crear actualizar eliminar
        manager.getTransaction().begin();
        //Producto producto = new Producto(nombre, precio, stock);
        //convertir objeto en fila
        manager.persist(producto);
        //Enviar los datos
        manager.getTransaction().commit();
        manager.close();

    }

    //Metodo para LEER
    public List<Producto> readAll(){
        EntityManager manager =  GestorGenerico.getEntityManager();
        //Crear consulta para traer la lista
        List<Producto> lista = manager.createQuery("from Producto", Producto.class).getResultList();
        manager.close();
        return lista;
    }


    //Buscar por nombre
    public Producto findByNombre(String nombre){
        EntityManager manager =  GestorGenerico.getEntityManager();
        return manager.find(Producto.class, nombre);
    }
    //Buscar por precio
    public Producto findByPrecio(Integer precio){
        EntityManager manager =  GestorGenerico.getEntityManager();
        return manager.find(Producto.class, precio);
    }

    //actualizar producto
    public void update(Integer id,String nombre, Integer precio, Integer stock){
        EntityManager manager =  GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Producto producto = manager.find(Producto.class, id);
        if(producto != null){
            if(nombre != null){
                producto.setNombre(nombre);
            }
            if(precio != null){
                producto.setPrecio(precio);
            }
            if(stock != null){
                producto.setStock(stock);
            }
            manager.merge(producto);
            manager.getTransaction().commit();
        }
        manager.close();
    }

    //Agregar al carrito
//    public void addToCart(Cliente cliente, Producto producto){
//        EntityManager manager =  GestorGenerico.getEntityManager();
//        manager.getTransaction().begin();
//        cliente.getCarrito().add(producto);
//        manager.persist(producto);
//        manager.getTransaction().commit();
//        manager.close();
//
//    }
    //Quitar del carrito
//    public void removeFromCart(Cliente cliente, Producto producto){
//        EntityManager manager =  GestorGenerico.getEntityManager();
//        manager.getTransaction().begin();
//        cliente.getCarrito().remove(producto);
//        manager.merge(producto);
//        manager.getTransaction().commit();
//        manager.close();
//    }


    //Borrar por id
    public void delete(Integer id){
        EntityManager manager =  GestorGenerico.getEntityManager();
        Producto producto = manager.find(Producto.class, id);
        if(producto != null){
            manager.remove(producto);
            manager.getTransaction().commit();
        }
        manager.close();
    }




}
