package iot.raniot.infrastructure.entrypoints.handlers;

import iot.raniot.domain.model.Employee;
import iot.raniot.domain.model.dto.EmployeeDTO;
import iot.raniot.domain.usecase.EmployeeUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {

    private final EmployeeUseCase employeeUseCase;

    public EmployeeHandler(EmployeeUseCase employeeUseCase) {
        this.employeeUseCase = employeeUseCase;
    }

    public Mono<ServerResponse> createEmployee(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(EmployeeDTO.class)
                .flatMap(EmployeeDTO -> employeeUseCase.saveEmployee(EmployeeDTO.toDomain()))
                //.flatMap(employeeUseCase::saveEmployee)
                .flatMap(savedNewEmployee -> ServerResponse.
                        status(HttpStatus.CREATED)
                        .bodyValue(savedNewEmployee))
                .onErrorResume(exception -> ServerResponse.
                        unprocessableEntity()
                        .bodyValue("Error en la creacion del empleado"));
    }
}
