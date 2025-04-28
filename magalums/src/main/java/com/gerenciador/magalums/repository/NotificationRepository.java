package com.gerenciador.magalums.repository;

import com.gerenciador.magalums.entiity.Notification;
import com.gerenciador.magalums.entiity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByStatusInAndDateTimeBefore(List<Status> status, LocalDateTime dateTime);

}
