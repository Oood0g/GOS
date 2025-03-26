package com.gos.service;

import com.gos.model.Labor;
import com.gos.repository.LaborRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LaborService {

    private final LaborRepository repository;

    public List<Labor> getAll() {
        return repository.findAll();
    }

    public Labor getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public Labor create(Labor labor) {
        return repository.save(labor);
    }

    public Labor update(Long id, Labor labor) {
        labor.setId(id);
        return repository.save(labor);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}