package iot.raniot.services.impl;

import iot.raniot.models.Employee;
import iot.raniot.models.Reprocess;
import iot.raniot.repositories.ReprocessRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import static iot.raniot.Mockito.Data.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReprocessingServicesTest {

    @MockBean
    ReprocessRepository reprocessRepository;

    @Autowired
    ReprocessingServices service;

    @Test
    void newCleaningTest() {
        //Given
        when(reprocessRepository.save(any(Reprocess.class))).thenReturn(newReprocessingData());
        //when
        Reprocess resp = service.newCleaning(newReprocessingData());
        //Then
        assertNotNull(resp);
        assertEquals(1, resp.getId());
    }

    @Test
    void searchAllTest() {
        //Given
        when(reprocessRepository.findAll()).thenReturn(reprocessList());
        //when
        List<Reprocess> resp = service.searchAll();
        //Then
        assertNotNull(resp);
        assertEquals(2, resp.size());
    }
}