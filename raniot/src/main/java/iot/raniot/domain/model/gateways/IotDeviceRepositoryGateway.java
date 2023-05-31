package iot.raniot.domain.model.gateways;

import iot.raniot.domain.model.IotDevice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IotDeviceRepositoryGateway {

    Mono save(IotDevice iotDevice);

    Flux <IotDevice> findAll();
}
