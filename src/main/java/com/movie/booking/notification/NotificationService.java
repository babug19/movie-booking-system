package com.movie.booking.notification;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {


    private final List<NotificationChannel> channels;

    public NotificationService(List<NotificationChannel> channels) {
        this.channels = channels;
    }

    public void notifyUser(String userId, String message) {
        for (NotificationChannel channel : channels) {
            channel.update(userId, message);
        }
    }
}
