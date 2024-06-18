package Gestores;

import Entidades.Comprobante;
import Entidades.DetalleComprobante;
import Entidades.Producto;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GestorDetalleComprobante {
    public void create (DetalleComprobante detalleComprobante){
        EntityManager manager =  GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        //DetalleComprobante detalleComprobante=new DetalleComprobante(cantidad,precioU,comprobante,producto);
        manager.persist(detalleComprobante);
        manager.getTransaction().commit();
        manager.close();
    }

    public DetalleComprobante read (Integer id){
        EntityManager manager =  GestorGenerico.getEntityManager();
        DetalleComprobante detalleComprobante=manager.find(DetalleComprobante.class,id);
        manager.close();
        return detalleComprobante;
    }

    public void  update(DetalleComprobante detalleComprobante){
        EntityManager manager =  GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(detalleComprobante);
        manager.getTransaction().commit();
        manager.close();
    }

    public void delete (Integer id){
        EntityManager manager =  GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        DetalleComprobante detalleComprobante=manager.find(DetalleComprobante.class,id);
        if(detalleComprobante != null){
            manager.remove(detalleComprobante);
        }
        manager.getTransaction().commit();
        manager.close();
    }

    public List<DetalleComprobante> findAll(){
        EntityManager manager =  GestorGenerico.getEntityManager();
        List<DetalleComprobante> detalleComprobantes=manager.createQuery("SELECT d FROM DetalleComprobante d", DetalleComprobante.class).getResultList();
        manager.close();
        return detalleComprobantes;
    }


}
