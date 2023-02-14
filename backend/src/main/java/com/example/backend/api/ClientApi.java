package com.example.backend.api;

import com.example.backend.entities.Client;
import com.example.backend.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "client")
public class ClientApi {

    @Autowired
    private ClientServiceImpl clientService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Client> save(@RequestBody Client clientRequestDTO) {

        this.clientService.save(clientRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientRequestDTO);

    }

    @GetMapping
    @PreAuthorize("hasAnyRole('OPERATOR')")
    public ResponseEntity<List<Client>> findAll() {
        List<Client> listClient = this.clientService.findAll();
        return ResponseEntity.ok(listClient);
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('OPERATOR')")
    public ResponseEntity<Client> findById(@PathVariable(name = "id") Integer id) throws Exception {

        Client client = this.clientService.findById(id);

        return ResponseEntity.ok().body(client);


    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('OPERATOR')")
    public ResponseEntity<Client> update(@PathVariable(name = "id") Integer id, @RequestBody Client client) {
        Client clientResponse = this.clientService.updateClient(id, client);
        return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id") Integer id) {
        this.clientService.deleteById(id);
        return ResponseEntity.ok("deleted");
    }

}
