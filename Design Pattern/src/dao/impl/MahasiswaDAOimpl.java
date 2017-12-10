package dao.impl;

import dao.BaseDAO;
import entity.Mahasiswa;
import util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDAOimpl implements BaseDAO<Mahasiswa>{

    ResultSet resultSet = null;
    @Override
    public Mahasiswa save(final Mahasiswa mahasiswa) {
        String SQL = "INSERT INTO mahasiswa (nim, nama)"+"VALUE(?,?)";
        try {
            PreparedStatement preparedStatement = DBConnection.INSTANCE.getConnection().prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,mahasiswa.getNim());
            preparedStatement.setString(2,mahasiswa.getNama());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                mahasiswa.setId(resultSet.getInt(1));
            } else {
                throw new SQLException("Creating user failed, no generated key obtained.");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mahasiswa;
    }

    @Override
    public Mahasiswa update(Mahasiswa mahasiswa) {
        return mahasiswa;
    }

    @Override
    public void delete(Mahasiswa mahasiswa) {

    }

    @Override
    public Mahasiswa findById(Integer id) {
        return new Mahasiswa();
    }

    @Override
    public List<Mahasiswa> findBy(Mahasiswa mahasiswa) {
        return new ArrayList<Mahasiswa>();
    }

    @Override
    public List<Mahasiswa> getAll() {
        return null;
    }
}
