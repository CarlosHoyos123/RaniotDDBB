package iot.raniot.Mockito;

import iot.raniot.models.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Data {
    public static Reprocess newReprocessingData(){
        return new Reprocess(1, LocalDate.of(2023,05,05), LocalTime.of(10,43,12),
                            newTagEnd(), newTagEmp() ,
                            "1", "2", "3", "4", "5", "6", "7",
                            true, 8, 9, "No", newDevice());
    }

    public  static Tag_endoscope newTagEnd(){
        return new Tag_endoscope("qwertyuo", "modeloMock", newInstitution(), newMaintainer(), newDevice());
    }
    public static Maintainer newMaintainer(){
        return new Maintainer("id", "name", "city", "adress", "phone");
    }
    public static Institution newInstitution(){
        return  new Institution(0, newEmployee(), "paisMock", "depatmentMock", "regionMock", "nameMock", "adressMock", "phoneMock", "mail", "nit", "estateMock");
    }
    public static  Tags_employe newTagEmp(){
        return new Tags_employe("qwertyuo3", newDevice(), newEmployee());
    }
    public static  Iotdevice newDevice(){
        return  new Iotdevice("serie", newModel(), newInstitution(), LocalDate.of(2023,03,03), "installBy");
    }
    public  static Employee newEmployee(){
        return new Employee(0, 1, "name", "adress", "phone", "mail", "age", "sex", LocalDate.of(2023,02,02), LocalDate.of(2023,01,01), true, newJob());
    }
    public static Model newModel(){
        return new Model(0, 1, 2);
    }
    public static Job newJob(){
        return new Job(0, "name", "description");
    }
    public static List<Employee> employeesList(){
        return Arrays.asList(newEmployee(), newEmployee());
    }
    public static List<Reprocess> reprocessList(){
        return Arrays.asList(newReprocessingData(), newReprocessingData());
    }

}
