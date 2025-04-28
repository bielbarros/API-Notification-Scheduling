package com.gerenciador.magalums.repository;

import com.gerenciador.magalums.entiity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
