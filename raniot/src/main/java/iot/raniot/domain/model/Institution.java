package iot.raniot.domain.model;

public class Institution {
    private long id;
    private Employee director ;
    private String country;
    private String department;
    private String city;
    private String name;
    private String adress;
    private String phone;
    private String mail;
    private String id_institution;
    private boolean state;

    public long getId() {
        return id;
    }

    public Employee getDirector() {
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

    public String getId_institution() {
        return id_institution;
    }

    public boolean isState() {
        return state;
    }

    public Institution(long id, Employee director, String country, String department, String city, String name, String adress, String phone, String mail, String id_institution, boolean state) {
        this.id = id;
        this.director = director;
        this.country = country;
        this.department = department;
        this.city = city;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.mail = mail;
        this.id_institution = id_institution;
        this.state = state;
    }
}
