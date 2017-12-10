package entity;

public class Jurusan extends BaseEntity implements EntityAware{
    private String kode_jurusan;
    private String nama_jurusan;

    public String getKode_jurusan() {
        return kode_jurusan;
    }

    public void setKode_jurusan(String kode_jurusan) {
        this.kode_jurusan = kode_jurusan;
    }

    public String getNama_jurusan() {
        return nama_jurusan;
    }

    public void setNama_jurusan(String nama_jurusan) {
        this.nama_jurusan = nama_jurusan;
    }

    @Override
    public String toString() {
        return "Jurusan{" +
                "id_jurusan='" + getId() + '\'' +
                "kode_jurusan='" + kode_jurusan + '\'' +
                ", nama_jurusan='" + nama_jurusan + '\'' +
                '}';
    }
}
