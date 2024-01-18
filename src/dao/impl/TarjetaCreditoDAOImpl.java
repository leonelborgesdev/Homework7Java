package dao.impl;

import dao.TarjetaCreditoDAO;
import domain.TarjetaCredito;
import config.ConexionBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        return null;
    }
}
