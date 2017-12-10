package dao.impl;

import entity.Jurusan;
import entity.Mahasiswa;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JurusanDAOimplTest {

    private JurusanDAOimpl jurusanDAOimpl = new JurusanDAOimpl();

    @Test
    public void save() throws Exception{
        Jurusan jurusan = new Jurusan();
        jurusan.setKode_jurusan("TI");
        jurusan.setNama_jurusan("Teknik Informatika");
        Jurusan jurusan1  = jurusanDAOimpl.save(jurusan);
        System.out.println(jurusan1);
    }

    @Test
    public void update() {
        Jurusan jurusan = new Jurusan();
        jurusan.setId(3);
        jurusan.setKode_jurusan("SI");
        jurusan.setNama_jurusan("Sistem Informasi");
        Jurusan jurusan1  = jurusanDAOimpl.update(jurusan);
        System.out.println(jurusan1);
    }

    @Test
    public void delete() {
        Jurusan jurusan = new Jurusan();
        jurusan.setId(4);
        jurusanDAOimpl.delete(jurusan);
    }

    @Test
    public void findById() {
        Jurusan jurusan= jurusanDAOimpl.findById(5);
        System.out.println(jurusan);
    }

    @Test
    public void findBy() {
        Jurusan jurusan = new Jurusan();
        jurusan.setNama_jurusan("Teknik Informatika");
        List<Jurusan> hasil= jurusanDAOimpl.findBy(jurusan);
        System.out.println(hasil);
    }

    @Test
    public void getAll() {
        List<Jurusan> jurusan = jurusanDAOimpl.getAll();
        System.out.println(jurusan);
    }


}