package br.com.gustavopierre.api.services;

import br.com.gustavopierre.api.domain.User;

public interface UserService {
    User findById(Integer id);
}
