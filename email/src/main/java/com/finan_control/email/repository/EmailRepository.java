package com.finan_control.email.repository;

import com.finan_control.email.model.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<UUID, EmailModel> {

}
