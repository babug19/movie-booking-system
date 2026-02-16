package com.movie.booking.notification;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements NotificationChannel {


    @Override
    public void update(String userId, String message) {
        System.out.println("Email sent to " + userId);

    }
}
