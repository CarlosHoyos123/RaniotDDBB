package iot.raniot.domain.model.dto;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.Institution;

public class InstitutionDTO {

    private Long id;
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
    public static InstitutionDTO fromDomain(Institution institution){
        return new InstitutionDTO(institution.getId(), institution.getDirector(), institution.getCountry(),
                institution.getDepartment(),institution.getCity(), institution.getName(),
                institution.getAdress(),institution.getPhone(),
                institution.getMail(),institution.getId_institution(),institution.isState());
    }
    public Institution toDomain(){
        return new Institution(id, director,country,department,city,
                            name,adress,phone,mail,id_institution,state);
    }
    public InstitutionDTO(long id, Employee director, String country, String department, String city, String name, String adress, String phone, String mail, String id_institution, boolean state) {
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
