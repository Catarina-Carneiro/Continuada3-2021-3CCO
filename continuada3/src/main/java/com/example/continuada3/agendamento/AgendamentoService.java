package com.example.continuada3.agendamento;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Scheduled(fixedRate = 3000)
    public void agendar(){
        System.out.println("teste");
    }
}
