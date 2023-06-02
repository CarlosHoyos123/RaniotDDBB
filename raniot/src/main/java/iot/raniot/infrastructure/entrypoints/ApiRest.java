package iot.raniot.infrastructure.entrypoints;

import iot.raniot.infrastructure.entrypoints.handlers.EmployeeHandler;
import iot.raniot.infrastructure.entrypoints.handlers.InstitutionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class ApiRest {


    @Value("{PATH_BASE}")
    private String pathBase;

    @Bean
    public RouterFunction<ServerResponse> userFunctionalEndPoints (EmployeeHandler handler) {
        String param = "{/id}";
        return RouterFunctions
                .route(POST(pathBase).and(accept(MediaType.APPLICATION_JSON)), handler::createEmployee);
                //.andRoute(GET(pathBase).and(accept(MediaType.APPLICATION_JSON)), handler::queryUsers)
                //.andRoute(GET(pathBase.concat("/{id}")).and(accept(MediaType.APPLICATION_JSON)), handler::queryUserById)
    }
    @Bean
    public RouterFunction<ServerResponse> isntitutionFunctionalEndPoints (InstitutionHandler handler) {
        String param = "{/id}";
        return RouterFunctions
                .route(POST(pathBase.concat("/ins")).and(accept(MediaType.APPLICATION_JSON)), handler::createInstitution);
        //.andRoute(GET(pathBase).and(accept(MediaType.APPLICATION_JSON)), handler::queryUsers)
        //.andRoute(GET(pathBase.concat("/{id}")).and(accept(MediaType.APPLICATION_JSON)), handler::queryUserById)
    }
}
