package com.example.springh1.service.impl;

import com.example.springh1.pojo.Provider;
import com.example.springh1.pojo.dto.ProviderDTO;
import com.example.springh1.repository.ProviderRepository;
import com.example.springh1.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository){
        this.providerRepository = providerRepository;
    }

    @Override
    @Transactional
    public Integer insertNewProvider(Provider provider) {

        providerRepository.save(provider);

        return provider.getId();
    }

    @Override
    public Provider getProviderById(Integer id) {
        Optional<Provider> res = providerRepository.findById(id);

        return res.orElse(null);
    }

    @Override
    public List<ProviderDTO> getAllProvider() {

        return providerRepository.findAll().stream()
                .map(ProviderDTO::new)
                .collect(Collectors.toList());
    }


}

