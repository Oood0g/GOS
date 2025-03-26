package com.gos.service;

import com.gos.model.Machine;
import com.gos.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineService {
    
    private final MachineRepository repository;

    public List<Machine> findAll() {
        return repository.findAll();
    }

    public Machine create(Machine machine) {
        return repository.save(machine);
    }

    public Machine update(Long id, Machine machine) {
        machine.setId(id);
        return repository.save(machine);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}