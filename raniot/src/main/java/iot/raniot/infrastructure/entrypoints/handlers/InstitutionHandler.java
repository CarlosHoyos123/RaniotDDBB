package iot.raniot.infrastructure.entrypoints.handlers;

import iot.raniot.domain.model.dto.InstitutionDTO;
import iot.raniot.domain.usecase.InstitutionUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class InstitutionHandler {

    private InstitutionUseCase institutionUseCase;

    public InstitutionHandler(InstitutionUseCase institutionUseCase) {
        this.institutionUseCase = institutionUseCase;
    }

    public Mono createInstitution(ServerRequest serverRequest){
        return serverRequest.bodyToMono(InstitutionDTO.class)
                .flatMap(InstitutionDTO -> institutionUseCase.saveInstitution(InstitutionDTO.toDomain()))
                .flatMap(savedNewInstitution -> ServerResponse.
                        status(HttpStatus.CREATED)
                        .bodyValue(("Se ha creado la institucion con exito"))
                .onErrorResume(exception -> ServerResponse
                        .unprocessableEntity()
                        .bodyValue("mala solicitud"))
                        );
    }
}
