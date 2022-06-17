package br.com.gustavopierre.api.services.impl;

import br.com.gustavopierre.api.domain.User;
import br.com.gustavopierre.api.repositories.UserRepository;
import br.com.gustavopierre.api.services.UserService;
import br.com.gustavopierre.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id){
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException("Object was not found"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }
}
