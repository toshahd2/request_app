package ru.tonru.request_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tonru.request_app.model.Request;
import ru.tonru.request_app.repository.RequestRepository;

import java.util.Optional;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public Request updateRequest(Request entity) {
        if (entity.getId() == null) {
            entity = requestRepository.save(entity);
            return entity;
        } else {
            Optional<Request> request = requestRepository.findById(entity.getId());
            if (request.isPresent()) {
                Request newEntity = request.get();
                newEntity.setStatus(entity.getStatus());
                newEntity.setComment(entity.getComment());
                newEntity = requestRepository.save(newEntity);
                return newEntity;
            } else {
                entity = requestRepository.save(entity);
                return entity;
            }
        }
    }
}
