package com.minori.svideo.storage.repositories;

import com.minori.svideo.common.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<User, Long> {
}
