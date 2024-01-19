import domain.TarjetaCredito;
import domain.TarjetaDebito;
import service.TarjetaService;

import java.util.List;

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

        List<TarjetaDebito> tarjetaDebito= tarjetaService.getAllTarjetasDebito();
        if (!tarjetaDebito.isEmpty()){
            System.out.println("\nTarjetas de Debito encontradas:");
            for (TarjetaDebito tarjeta : tarjetaDebito){
                System.out.println("Numero: "+tarjeta.getNumero());
                System.out.println("Titular: "+tarjeta.getTitular());
            }
        }else{
            System.out.println("\nNo se encontraron Tarjetas de debito");
        }
    }
}