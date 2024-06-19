import Entidades.*;
import Gestores.GestorCliente;
import Gestores.GestorComprobante;
import Gestores.GestorDetalleComprobante;
import Gestores.GestorProducto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Main {
    public static void main(String[] args) {
//       EntityManagerFactory emf = Persistence.createEntityManagerFactory("commercePU");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        Cliente cliente = new Cliente("Santiago","Caceres",334345,22);
//        Producto producto=new Producto("Buzo",3500,20);
//        Carrito carrito=new Carrito(3500,2,cliente,producto);
//        em.persist(cliente);
//        em.persist(producto);
//        em.persist(carrito);
//
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
        GestorCliente gestorCliente = new GestorCliente();
        GestorProducto gestorProducto=new GestorProducto();
        GestorComprobante gestorComprobante=new GestorComprobante();
        GestorDetalleComprobante gestorDetalleComprobante=new GestorDetalleComprobante();


        try {
            //crear entidades
            Cliente cliente=new Cliente("Juan","Perez",434565,22);
            gestorCliente.create(cliente);

            Producto producto =new Producto("pantalon",200,10);
            gestorProducto.create(producto);



            Comprobante comprobante=new Comprobante(LocalDateTime.now(),"En camino",cliente);
            System.out.println(comprobante.getFecha());
            gestorComprobante.create(comprobante);

            DetalleComprobante detalleComprobante=new DetalleComprobante(2,200.0,comprobante,producto);
            gestorDetalleComprobante.create(detalleComprobante);

            comprobante.getDetalles().add(detalleComprobante);
            gestorComprobante.update(comprobante);


            gestorCliente.update(cliente.getId(),"Pedro","kiricocho",333333,90);

//            gestorDetalleComprobante.delete(detalleComprobante.getId());
//            gestorComprobante.delete(comprobante.getId());
//            gestorProducto.delete(producto.getId());
//            gestorCliente.delete("Pedro");



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
