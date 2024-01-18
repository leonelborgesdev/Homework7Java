package dao.impl;

import dao.TarjetaCreditoDAO;
import domain.TarjetaCredito;
import config.ConexionBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarjetaCreditoDAOImpl implements TarjetaCreditoDAO {
    @Override
    public TarjetaCredito getTarjetaCreditoById(int id) {
        try (Connection connection = ConexionBd.getConnection()) { // <-- Configura la conexión a la base de datos H2 (jdbcUrl, user, password)
            String sql = "SELECT numero, titular FROM TarjetasCredito WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String titular = resultSet.getString("titular");
                return new TarjetaCredito(numero, titular);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<TarjetaCredito> getAllTarjetasCredito() {
        // Realiza la consulta SQL para obtener todas las tarjetas de crédito
        // Crea una lista de objetos TarjetaCredito y la devuelve
        List<TarjetaCredito> tarjetas = new ArrayList<>();

        try (Connection connection = ConexionBd.getConnection()) {
            String sql = "SELECT numero, titular FROM TarjetasCredito";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String titular = resultSet.getString("titular");
                tarjetas.add(new TarjetaCredito(numero, titular));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarjetas;
    }
}
