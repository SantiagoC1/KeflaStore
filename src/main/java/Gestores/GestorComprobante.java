package Gestores;

import Entidades.Cliente;
import Entidades.Comprobante;
import Entidades.DetalleComprobante;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class GestorComprobante {

    //Metodo para crear
    public void create (Comprobante comprobante){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
            //inicialiazar operaciones de Crear actualizar eliminar
            manager.getTransaction().begin();
            //Comprobante comprobante = new Comprobante(fecha,estado,cliente);
            manager.persist(comprobante);
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }

    //metodo para leer
    public Comprobante read (Integer id){
        EntityManager manager =  GestorGenerico.getEntityManager();
        Comprobante comprobante=null;
        try {
            comprobante=manager.find(Comprobante.class,id);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
            return comprobante;
        }
    }

    //update de un comprobante por otro comprobante ingresado por parameto
    public void update(Comprobante comprobante){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(comprobante);
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }

    //Metodo para eliminar un comprobante por id
    public void delete (Integer id){
        EntityManager manager =  GestorGenerico.getEntityManager();
        try {
            manager.getTransaction().begin();
            Comprobante comprobante = manager.find(Comprobante.class,id);
            if ( comprobante != null){
                manager.remove(comprobante);
            }
            manager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
        }
    }

    //Metodo para devolver todos los comprobantes
    public List<Comprobante> findAll(){
        EntityManager manager =  GestorGenerico.getEntityManager();
        List<Comprobante> comprobantes =null;
        try {
            comprobantes = manager.createQuery("SELECT c FROM Comprobante c", Comprobante.class).getResultList();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            manager.close();
            return comprobantes;
        }
    }


    
}
