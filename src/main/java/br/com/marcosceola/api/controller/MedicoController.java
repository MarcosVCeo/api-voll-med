package br.com.marcosceola.api.controller;

import br.com.marcosceola.api.dto.MedicoForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void cadastrar(@RequestBody MedicoForm medicoForm) {
        System.out.println(medicoForm);
    }
}
