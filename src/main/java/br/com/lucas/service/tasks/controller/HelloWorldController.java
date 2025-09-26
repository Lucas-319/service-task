package br.com.lucas.service.tasks.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${server.port:padrão 8080}")
    private String serverPort;

    @GetMapping("/server-port")
    public String getMessage() {
        return "Rodando na porta: " + this.serverPort;
    }
}
