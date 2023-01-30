package com.example.springh1.repository;


import com.example.springh1.pojo.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}
