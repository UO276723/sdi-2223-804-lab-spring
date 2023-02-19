package com.uniovi.sdi2223804spring.repositories;

import com.uniovi.sdi2223804spring.entities.*;
import org.springframework.data.repository.CrudRepository;
public interface UsersRepository extends CrudRepository<User, Long>{
    User findByDni(String dni);
}
