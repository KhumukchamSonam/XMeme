package com.crio.starter.repository;

import java.util.List;
import com.crio.starter.data.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MemeRepository extends MongoRepository<Meme, String>{
    List<Meme> findTop100ByOrderByCreatedDateDesc();
    Optional<Meme> findByNameAndUrlAndCaption(String name, String url, String caption);
}
