package Gestores;

import Entidades.Comprobante;
import Entidades.DetalleComprobante;
import Entidades.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GestorDetalleComprobante {
    //Metodo para crear
    public void create (DetalleComprobante detalleComprobante){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(detalleComprobante);
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }


    //Metodo para eliminar por id
    public void delete (Integer id){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
            manager.getTransaction().begin();
            DetalleComprobante detalleComprobante=manager.find(DetalleComprobante.class,id);
            if(detalleComprobante != null){
                manager.remove(detalleComprobante);
            }
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }



}
