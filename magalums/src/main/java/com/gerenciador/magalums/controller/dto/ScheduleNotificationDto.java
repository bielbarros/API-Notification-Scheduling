package com.gerenciador.magalums.controller.dto;

import com.gerenciador.magalums.entiity.Channel;
import com.gerenciador.magalums.entiity.Notification;
import com.gerenciador.magalums.entiity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {


    public Notification toNotification() {
        return new Notification(
            dateTime,
            destination,
            message,
            channel.toChannel(),
            Status.Values.PENDING.toStatus()
        );
    }



}
