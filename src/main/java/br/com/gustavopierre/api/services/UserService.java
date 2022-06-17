package br.com.gustavopierre.api.services;

import br.com.gustavopierre.api.domain.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
}
