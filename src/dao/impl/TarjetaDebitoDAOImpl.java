package dao.impl;

import dao.TarjetaDebitoDAO;
import domain.TarjetaDebito;
import config.ConexionBd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarjetaDebitoDAOImpl implements TarjetaDebitoDAO {
    @Override
    public TarjetaDebito getTarjetaDebitoById(int id) {
        // Realiza la consulta SQL para obtener una tarjeta de débito por ID
        // Crea un objeto TarjetaDebito y lo devuelve
        try (Connection connection = ConexionBd.getConnection()) { // <--Configura la conexión a la base de datos H2 (jdbcUrl, user, password)
            String sql = "SELECT numero, titular FROM TarjetasDebito WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String titular = resultSet.getString("titular");
                return new TarjetaDebito(numero, titular);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<TarjetaDebito> getAllTarjetasDebito() {
        List<TarjetaDebito> tarjetas = new ArrayList<>();

        try (Connection connection = ConexionBd.getConnection()) {
            String sql = "SELECT numero, titular FROM TarjetasDebito";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String numero = resultSet.getString("numero");
                String titular = resultSet.getString("titular");
                tarjetas.add(new TarjetaDebito(numero, titular));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tarjetas;
    }
}
