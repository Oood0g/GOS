package com.gos.service;

import com.gos.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ReportService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public byte[] generateServiceOrderReport(Long osId) throws IOException {
        // Implementação do relatório
        return new byte[0];
    }
}