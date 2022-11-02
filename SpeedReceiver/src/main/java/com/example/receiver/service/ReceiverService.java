package com.example.receiver.service;
import com.example.receiver.entity.RootEntity;
import com.example.receiver.repository.SaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceiverService {
    private final SaveRepository saveRepository;
    public void save(RootEntity rootEntity){
        saveRepository.save(rootEntity);
    }

}
