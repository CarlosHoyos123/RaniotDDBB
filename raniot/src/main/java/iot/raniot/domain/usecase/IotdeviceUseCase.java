package iot.raniot.domain.usecase;

import iot.raniot.domain.model.IotDevice;
import iot.raniot.domain.model.gateways.IotDeviceRepositoryGateway;
import reactor.core.publisher.Mono;

import java.util.List;


public class IotdeviceUseCase {

    private final IotDeviceRepositoryGateway iotDeviceRepositoryGateway;

    public IotdeviceUseCase(IotDeviceRepositoryGateway iotDeviceRepositoryGateway) {
        this.iotDeviceRepositoryGateway = iotDeviceRepositoryGateway;
    }

    public Mono saveIotDevice(IotDevice iotDevice){
        return iotDeviceRepositoryGateway.save(iotDevice);
    }

    public List<IotDevice> findAll(){
        return (List<IotDevice>) iotDeviceRepositoryGateway.findAll();
    }
}
