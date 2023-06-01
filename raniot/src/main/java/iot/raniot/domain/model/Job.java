package iot.raniot.domain.model;

public class Job {
    private Long id;
    private String name;
    private String description;

    public Job(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
