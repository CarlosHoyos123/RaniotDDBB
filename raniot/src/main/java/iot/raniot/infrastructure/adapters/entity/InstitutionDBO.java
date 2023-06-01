package iot.raniot.infrastructure.adapters.entity;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.Institution;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "institucion")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionDBO {
    @Id
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

    public static Institution toDomain(InstitutionDBO institutionDBO){
        return new Institution(institutionDBO.getId(), institutionDBO.getDirector(),
                institutionDBO.getCountry(), institutionDBO.getDepartment(),
                institutionDBO.getCity(), institutionDBO.getName(),
                institutionDBO.getAdress(), institutionDBO.getPhone(),
                institutionDBO.getMail(), institutionDBO.getId_institution(),
                institutionDBO.isState()
        );
    }

    public static InstitutionDBO fromDomain(Institution institution){
        return InstitutionDBO.builder()
                .id(institution.getId())
                .director(institution.getDirector())
                .country(institution.getCountry())
                .department(institution.getDepartment())
                .city(institution.getCity())
                .name(institution.getName())
                .adress(institution.getAdress())
                .phone(institution.getPhone())
                .mail(institution.getMail())
                .id_institution(institution.getId_institution())
                .state(institution.isState())
                .build();
    }

}
