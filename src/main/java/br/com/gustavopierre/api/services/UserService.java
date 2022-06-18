package br.com.gustavopierre.api.services;

import br.com.gustavopierre.api.domain.User;
import br.com.gustavopierre.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);
}
