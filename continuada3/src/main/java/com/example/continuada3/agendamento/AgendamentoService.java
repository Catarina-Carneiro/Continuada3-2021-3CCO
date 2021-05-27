package com.example.continuada3.agendamento;

import com.example.continuada3.dominio.Cartorio;
import com.example.continuada3.obj.FilaObj;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    public FilaObj<Integer> filaAgendamento = new FilaObj<Integer>(3);

    @Scheduled(fixedRate = 60000)
    public void agendar(FilaObj<Integer> filaAgendamento){
        System.out.println("VERIFICANDO");
    }

//    @Scheduled(fixedRate = 60000)
//    public void agendar(){ System.out.println("VERIFICANDO");}


}
