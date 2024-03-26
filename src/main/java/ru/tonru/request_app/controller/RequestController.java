package ru.tonru.request_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tonru.request_app.model.Request;
import ru.tonru.request_app.repository.RequestRepository;
import ru.tonru.request_app.service.RequestService;

import java.util.Map;

@Controller
public class RequestController {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestService requestService;

    @GetMapping("/request")
    public String request() {
        return "request";
    }
    @PostMapping("/request")
    public String add(@RequestParam String company, @RequestParam String contact,
                      @RequestParam String task, @RequestParam(value = "status",
            defaultValue = "новая") String status, @RequestParam(value = "comment",
            defaultValue = " ") String comment) {
        Request request = new Request(company, contact, task, status, comment);
        requestRepository.save(request);
        return "request";
    }

    @GetMapping("/checkpoint")
    public String checkpoint(@RequestParam(value = "status",
            defaultValue = "согласовано")String status, Map<String, Object> model) {
        Iterable<Request> requests;
        requests = requestRepository.findByStatus(status);
        model.put("requests", requests);
        return "checkpoint";
    }

    @GetMapping("/administration")
    public String administration(@RequestParam(value = "status",
            defaultValue = "новая")String status, Map<String, Object> model) {
        Iterable<Request> requests;
        requests = requestRepository.findByStatus(status);
        model.put("requests", requests);
        return "administration";
    }
    @PostMapping("/administration")
    public String update(@RequestParam Long id, @ModelAttribute("request") Request request) {
        request.setId(id);
        requestService.updateRequest(request);
        return "administration";
    }
}
