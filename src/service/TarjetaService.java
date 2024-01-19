package service;

import dao.TarjetaCreditoDAO;
import dao.TarjetaDebitoDAO;
import dao.impl.TarjetaCreditoDAOImpl;
import dao.impl.TarjetaDebitoDAOImpl;
import domain.TarjetaCredito;

import java.util.List;

public class TarjetaService {
    private final TarjetaCreditoDAO tarjetaCreditoDAO;
    private final TarjetaDebitoDAO tarjetaDebitoDAO;

    public TarjetaService() {
        this.tarjetaCreditoDAO = new TarjetaCreditoDAOImpl();
        this.tarjetaDebitoDAO = new TarjetaDebitoDAOImpl();
    }
    public TarjetaCredito getTarjetaCreditoById(int id){
        return tarjetaCreditoDAO.getTarjetaCreditoById(id);
    }
    public List<TarjetaCredito> getAllTarjetasCredito(){
        return tarjetaCreditoDAO.getAllTarjetasCredito();
    }
}
