package iot.raniot.infrastructure.adapters.entity;

import iot.raniot.domain.model.Job;
import iot.raniot.domain.model.dto.JobDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "tbljobs")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobDBO {
    @Id
    private Long id;
    private String name;
    private String description;

    public static Job toDomain(JobDBO jobDBO){
        return new Job(jobDBO.getId(), jobDBO.getName(), jobDBO.getDescription());
    }

    public static JobDBO fromDomain(Job job){
        return JobDBO.builder()
                .id(job.getId())
                .name(job.getName())
                .description(job.getDescription())
                .build();
    }

}
