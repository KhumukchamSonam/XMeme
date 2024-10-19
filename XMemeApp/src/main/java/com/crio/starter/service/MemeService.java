package com.crio.starter.service;

import com.crio.starter.repository.MemeRepository;
import com.crio.starter.data.Meme;
import com.crio.starter.exception.MemeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MemeService {
    @Autowired
    private MemeRepository memeRepository;

    //create memes and save
    public Meme createMeme(Meme obj){
        obj.setCreatedDate(LocalDateTime.now());
        Meme meme=memeRepository.save(obj);
        return meme;
    }

    //show 100 latest memes
    public List<Meme> latestMemes(){
        return memeRepository.findTop100ByOrderByCreatedDateDesc();
    }

    //get meme with id
    public Meme findMemeWithId(String id){
        Optional<Meme> memeOpt=memeRepository.findById(id);
        if(memeOpt.isPresent()){
            return memeOpt.get();
        }else{
            throw new MemeNotFoundException("No meme with id ="+id+" found");
        }
    }

}
