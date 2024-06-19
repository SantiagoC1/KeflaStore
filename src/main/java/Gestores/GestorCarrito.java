package Gestores;

import Entidades.Carrito;
import Entidades.Cliente;
import Entidades.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GestorCarrito {

    public  void  addToCart(double precio, Integer cantidad, Cliente cliente, Producto producto){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
            manager.getTransaction().begin();
            Carrito carrito =new Carrito(precio,cantidad,cliente,producto);
            manager.persist(carrito);
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }

    public List<Carrito> readByClient(Cliente cliente){
        EntityManager manager= GestorGenerico.getEntityManager();
        List<Carrito> carritos=null;
        try {
            carritos=manager.createQuery("SELECT id FROM Carrito id WHERE id.cliente= :cliente",
                    Carrito.class).setParameter("cliente",cliente).getResultList();

        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
            return carritos;
        }
    }
}
