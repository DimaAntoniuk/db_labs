package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.iot.model.Owner;
import ua.lviv.iot.repository.OwnerRepository;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    public Owner getById(Integer id) {
        return ownerRepository.findById(id).get();
    }

    @Transactional
    public void create(Owner output) {
        ownerRepository.save(output);
    }

    @Transactional
    public void update(Integer id, Owner output) {
        if(ownerRepository.findById(id).isPresent()) {
            Owner oldOwner = ownerRepository.findById(id).get();
            oldOwner.setFirstName(output.getFirstName());
            oldOwner.setLastName(output.getLastName());
        }
    }

    @Transactional
    public void delete(Integer id) {
        if(ownerRepository.findById(id).isPresent()) {
            ownerRepository.deleteById(id);
        }
    }
}
