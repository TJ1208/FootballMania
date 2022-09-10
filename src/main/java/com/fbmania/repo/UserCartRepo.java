package com.fbmania.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbmania.model.UserCart;
import com.fbmania.model.UserCartId;

public interface UserCartRepo extends JpaRepository<UserCart, UserCartId> {

}
