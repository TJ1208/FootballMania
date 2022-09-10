package com.fbmania.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbmania.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
