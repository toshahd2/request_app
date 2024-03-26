package ru.tonru.request_app.repository;

import org.springframework.stereotype.Repository;
import ru.tonru.request_app.model.Request;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {

    List<Request> findByStatus(String status);
}