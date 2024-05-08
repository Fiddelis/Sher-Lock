package br.com.inatel.sherlock.services;

import br.com.inatel.sherlock.models.Locker;
import br.com.inatel.sherlock.repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LockerService {
    @Autowired
    private LockerRepository lockerRepository;

    public Optional<Locker> getById(int id) {
        return lockerRepository.findById(id);
    }

    public Locker save(Locker locker) {
        return lockerRepository.save(locker);
    }
}