package com.gos.service;

import com.gos.model.ServiceOrder;
import com.gos.repository.ServiceOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOrderService {

    private final ServiceOrderRepository repository;

    public List<ServiceOrder> getAll() {
        return repository.findAll();
    }

    public ServiceOrder getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public ServiceOrder create(ServiceOrder serviceOrder) {
        return repository.save(serviceOrder);
    }

    public ServiceOrder update(Long id, ServiceOrder serviceOrder) {
        serviceOrder.setId(id);
        return repository.save(serviceOrder);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}