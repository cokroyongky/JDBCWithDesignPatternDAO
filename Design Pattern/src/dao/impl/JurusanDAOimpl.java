package dao.impl;

import dao.BaseDAO;
import entity.Jurusan;
import util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JurusanDAOimpl implements BaseDAO<Jurusan> {

    ResultSet resultSet = null;

    @Override
    public Jurusan save(final Jurusan jurusan) {
        String SQL = "INSERT INTO jurusan (kode_jurusan, nama_jurusan)" + "VALUE(?,?)";
        try {
            PreparedStatement preparedStatement = DBConnection.INSTANCE.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, jurusan.getKode_jurusan());
            preparedStatement.setString(2, jurusan.getNama_jurusan());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                jurusan.setId(resultSet.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no generated key obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jurusan;
    }

    @Override
    public Jurusan update(Jurusan jurusan) {
        String SQLs = "UPDATE jurusan SET kode_jurusan=?,nama_jurusan=?" + " WHERE id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.INSTANCE.getConnection().prepareStatement(SQLs, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, jurusan.getKode_jurusan());
            preparedStatement.setString(2, jurusan.getNama_jurusan());
            preparedStatement.setInt(3, jurusan.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                jurusan.setId(resultSet.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no generated key obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jurusan;
    }

    @Override
    public void delete(Jurusan jurusan) {
        String SQLs = "DELETE FROM jurusan WHERE id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.INSTANCE.getConnection().prepareStatement(SQLs, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, jurusan.getId());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            } else {
                System.out.println("Data Berhasil Dihapus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Jurusan findById(Integer id) {
        Jurusan jurusan = new Jurusan();
        String SQL = "SELECT * FROM jurusan where id=?";
        try {
            PreparedStatement preparedStatement = DBConnection.INSTANCE.getConnection().prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                jurusan.setId(resultSet.getInt(1));
                jurusan.setKode_jurusan(resultSet.getString(2));
                jurusan.setNama_jurusan(resultSet.getString(3));
            }
            return jurusan;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jurusan;
    }

    @Override
    public List<Jurusan> findBy(Jurusan jurusan) {
        List<Jurusan> result = new ArrayList<Jurusan>();
        String by = "";
        String SQL = "SELECT * FROM jurusan where ?=?";
        try {
            PreparedStatement preparedStatement = DBConnection.INSTANCE.getConnection().prepareStatement(SQL);
            if (jurusan.getNama_jurusan().equals(null)) {
                preparedStatement.setString(1, "nama_jurusan");
                preparedStatement.setString(2, jurusan.getNama_jurusan());
            }
            else {
                preparedStatement.setString(1, "kode_jurusan");
                preparedStatement.setString(2, jurusan.getNama_jurusan());
            }
            System.out.println(jurusan.getNama_jurusan());

            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                jurusan.setId(resultSet.getInt(1));
                jurusan.setKode_jurusan(resultSet.getString(2));
                jurusan.setNama_jurusan(resultSet.getString(3));
                result.add(jurusan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Jurusan> getAll() {
        List<Jurusan> result = new ArrayList<Jurusan>();
        String SQL = "SELECT * FROM jurusan";
        try {
            PreparedStatement preparedStatement = DBConnection.INSTANCE.getConnection().prepareStatement(SQL);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Jurusan jurusan = new Jurusan();
                jurusan.setId(resultSet.getInt(1));
                jurusan.setKode_jurusan(resultSet.getString(2));
                jurusan.setNama_jurusan(resultSet.getString(3));
                result.add(jurusan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
