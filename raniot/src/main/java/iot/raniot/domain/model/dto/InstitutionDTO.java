package iot.raniot.domain.model.dto;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.Institution;

public class InstitutionDTO {

    private Long id;
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
    public static InstitutionDTO fromDomain(Institution institution){
        return new InstitutionDTO(institution.getId(), institution.getDirector(), institution.getCountry(),
                institution.getDepartment(),institution.getCity(), institution.getName(),
                institution.getAdress(),institution.getPhone(),
                institution.getMail(),institution.getNit(),institution.isState());
    }
    public Institution toDomain(){
        return new Institution(id, director,country,department,city,
                            name,adress,phone,mail,nit,state);
    }
    public InstitutionDTO(long id, int director, String country, String department, String city, String name, String adress, String phone, String mail, String nit, boolean state) {
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
}
