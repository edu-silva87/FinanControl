package com.finan_control.user.producer;

import com.finan_control.user.dtos.EmailDto;
import com.finan_control.user.model.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel){
        EmailDto emailDto = new EmailDto();

        emailDto.setUserID(userModel.getId());
        emailDto.setEmail(userModel.getEmail());
        emailDto.setSubject("Cadastro realizado com sucessso");
        emailDto.setText(userModel.getName() + " , seja bem vindo(a)! \n Agradecemos o seu cadastro, aproveite agora todos os recursos de nossa plataforma");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);

    }
}
