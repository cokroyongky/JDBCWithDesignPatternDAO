package entity;

public class Mahasiswa extends BaseEntity implements EntityAware{
    private String nim;
    private String nama;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Mahasiswa{"+
                "id=" +getId()+
                ", nim='" + nim+'\''+
                ", nama='" + nama+'\''+
                '}';
    }
}
