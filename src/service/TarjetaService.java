package service;

import dao.TarjetaCreditoDAO;
import dao.TarjetaDebitoDAO;
import dao.impl.TarjetaCreditoDAOImpl;
import dao.impl.TarjetaDebitoDAOImpl;

public class TarjetaService {
    private final TarjetaCreditoDAO tarjetaCreditoDAO;
    private final TarjetaDebitoDAO tarjetaDebitoDAO;

    public TarjetaService() {
        this.tarjetaCreditoDAO = new TarjetaCreditoDAOImpl();
        this.tarjetaDebitoDAO = new TarjetaDebitoDAOImpl();
    }
}
