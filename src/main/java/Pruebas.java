import Gestores.GestorCliente;
import Gestores.GestorProducto;

public class Pruebas {
    public static void main(String[] args) {
        GestorProducto gestorProducto = new GestorProducto();
        GestorCliente gestorCliente = new GestorCliente();
        gestorProducto.create("buzo",200,10);
        gestorProducto.create("pantalon",450,60);
        gestorCliente.create("Santiago","Caceres",440324,22);
        gestorCliente.create("Nico","Fernandez",443355,32);



    }

}
