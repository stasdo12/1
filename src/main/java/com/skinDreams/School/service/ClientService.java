package com.skinDreams.School.service;

import com.skinDreams.School.entity.Client;
import com.skinDreams.School.repo.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class ClientService {



    private final ClientRepository clientRepository;


    @Autowired
    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
    }


    @Transactional
    public void saveClient(Client client){
        log.info("Client was saving");
        clientRepository.save(client);

    }
}
