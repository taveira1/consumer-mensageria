package com.api.consumermensageria.consumers;

import com.api.consumermensageria.dtos.Cliente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClienteConsumer {

        @RabbitListener(queues = "${spring.rabbitmq.queue}") // Listener com o nome da fila
        public void listen(@Payload Cliente cliente){ //Usando o message converter para transformar a mensagem (json) em objeto

                //System.out.println("Mensagem recebida: " + cliente.getNome() + ", " + cliente.getProfissao());
                //System.out.println(mensagem);

                var mapper = new ObjectMapper();
                try {
                        System.out.println("Mensagem recebida: " + mapper.writeValueAsString(cliente));
                } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                }


        }


}
