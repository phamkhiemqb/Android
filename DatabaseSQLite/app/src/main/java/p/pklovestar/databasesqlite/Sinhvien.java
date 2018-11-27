package p.pklovestar.databasesqlite;

public class Sinhvien {
    int id;
    String name,address, sex;

    public Sinhvien(){}

    public Sinhvien(int id, String name, String address, String sex) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.sex = sex;

    }

    public Sinhvien(String name, String address, String sex) {
        this.name = name;
        this.address = address;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
