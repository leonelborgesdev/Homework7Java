import domain.TarjetaCredito;
import service.TarjetaService;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        TarjetaService tarjetaService=new TarjetaService();

        int idTarjetaCredito= 1;
        TarjetaCredito tarjetaCredito=tarjetaService.getTarjetaCreditoById(idTarjetaCredito);

        if (tarjetaCredito != null){
            System.out.println("Tarjeta de Credito encontrada:");
            System.out.println("Numero: "+tarjetaCredito.getNumero());
            System.out.println("Titular: "+tarjetaCredito.getTitular());
        }else{
            System.out.println("Tarjeta de Credito no encontrada.");
        }
    }
}