package dao.impl;

import entity.Mahasiswa;
import org.junit.Test;


public class MahasiswaDAOImplTest {

    private MahasiswaDAOimpl mahasiswaDAOimpl = new MahasiswaDAOimpl();

    @Test
    public void save() throws Exception{
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNim("001");
        mahasiswa.setNama("Cokro Yongky Pranowo");
        Mahasiswa mahasiswa1  = mahasiswaDAOimpl.save(mahasiswa);
        System.out.println(mahasiswa1);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }
}