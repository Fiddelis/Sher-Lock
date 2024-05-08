package br.com.inatel.sherlock.services;

import br.com.inatel.sherlock.models.Drawer;
import br.com.inatel.sherlock.repository.DrawerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrawerService {

    @Autowired
    private DrawerRepository drawerRepository;

    public Optional<Drawer> getById(int id) {
        return drawerRepository.findById(id);
    }

    public Drawer save(Drawer drawer) {
        return drawerRepository.save(drawer);
    }

    public Drawer removeObject(int id) {
        Optional<Drawer> drawerOptional = drawerRepository.findById(id);

        if(drawerOptional.isPresent()) {
            Drawer drawer = drawerOptional.get();
            drawer.setAvailable(true);

            return drawerRepository.save(drawer);
        }

        return null;
    }

    public Drawer deliverObject(int id) {
        Optional<Drawer> drawerOptional = drawerRepository.findById(id);

        if(drawerOptional.isPresent()) {
            Drawer drawer = drawerOptional.get();
            drawer.setAvailable(false);

            return drawerRepository.save(drawer);
        }

        return null;
    }
}
