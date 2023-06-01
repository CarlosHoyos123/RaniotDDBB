package iot.raniot.domain.model.dto;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.Job;

public class JobDTO {

    private Long id;
    private String name;
    private String description;

    public JobDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Job toDomain(){
        return new Job(id, name, description);
    }
    public static JobDTO fromDomain(Job job){
        return new JobDTO(job.getId(),job.getName(), job.getDescription());
    }
}
