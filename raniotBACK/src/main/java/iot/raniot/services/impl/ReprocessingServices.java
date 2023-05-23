package iot.raniot.services.impl;

import iot.raniot.models.Reprocess;
import iot.raniot.repositories.ReprocessRepository;
import iot.raniot.service.ReprocessingService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReprocessingServices implements ReprocessingService {

    ReprocessRepository reprocessRepository;

    public ReprocessingServices(ReprocessRepository reprocessRepository) {
        this.reprocessRepository = reprocessRepository;
    }

    @Override
    public Reprocess newCleaning(Reprocess newCleaning) {
        return reprocessRepository.save(newCleaning);
    }

    public List<Reprocess> searchAll(){
        return (List<Reprocess>) reprocessRepository.findAll();
    }
}
