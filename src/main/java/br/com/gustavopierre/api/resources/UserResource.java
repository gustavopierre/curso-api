package br.com.gustavopierre.api.resources;

import br.com.gustavopierre.api.domain.User;
import br.com.gustavopierre.api.domain.dto.UserDTO;
import br.com.gustavopierre.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x->mapper.map(x, UserDTO.class)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDTO);
        /*return ResponseEntity.ok().body(service.findAll()
                .stream().map(x->mapper.map(x, UserDTO.class)).collect(Collectors.toList()));

         */
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO obj){
        User newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO obj){
        obj.setId(id);
        User newObj = service.update(obj);
        return ResponseEntity.ok().body(mapper.map(newObj, UserDTO.class));
    }
}
