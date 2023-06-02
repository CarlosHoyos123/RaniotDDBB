package iot.raniot.domain.model;

public class Institution {
    private long id;
    private int director ;
    private String country;
    private String department;
    private String city;
    private String name;
    private String adress;
    private String phone;
    private String mail;
    private String nit;
    private boolean state;

    public long getId() {
        return id;
    }

    public int getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public String getDepartment() {
        return department;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getNit() {
        return nit;
    }

    public boolean isState() {
        return state;
    }

    public Institution(long id, int director, String country, String department, String city, String name, String adress, String phone, String mail, String nit, boolean state) {
        this.id = id;
        this.director = director;
        this.country = country;
        this.department = department;
        this.city = city;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.mail = mail;
        this.nit = nit;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", director=" + director +
                ", country='" + country + '\'' +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", nit='" + nit + '\'' +
                ", state=" + state +
                '}';
    }
}
