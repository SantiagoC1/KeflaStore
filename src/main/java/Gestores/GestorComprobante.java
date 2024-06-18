package Gestores;

import Entidades.Cliente;
import Entidades.Comprobante;
import Entidades.DetalleComprobante;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class GestorComprobante {
    public void create (Comprobante comprobante){
        EntityManager manager =  GestorGenerico.getEntityManager();
        //inicialiazar operaciones de Crear actualizar eliminar
        manager.getTransaction().begin();
        //Comprobante comprobante = new Comprobante(fecha,estado,cliente);
        manager.persist(comprobante);
        manager.getTransaction().commit();
        manager.close();
    }
    public Comprobante read (Integer id){
        EntityManager manager =  GestorGenerico.getEntityManager();
        Comprobante comprobante=manager.find(Comprobante.class,id);
        manager.close();
        return comprobante;

    }
    //update de un comprobante por otro comprobante ingresado por parameto
    public void update(Comprobante comprobante){
        EntityManager manager =  GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        manager.merge(comprobante);
        manager.getTransaction().commit();
        manager.close();
    }

    public void delete (Integer id){
        EntityManager manager =  GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Comprobante comprobante = manager.find(Comprobante.class,id);
        if ( comprobante != null){
            manager.remove(comprobante);
        }
        manager.getTransaction().commit();
        manager.close();
    }

    public List<Comprobante> findAll(){
        EntityManager manager =  GestorGenerico.getEntityManager();
        List<Comprobante> comprobantes = manager.createQuery("SELECT c FROM Comprobante c", Comprobante.class).getResultList();
        manager.close();
        return comprobantes;
    }


    
}
