package com.movie.booking.notification;

import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements NotificationChannel {
    @Override
    public void update(String userId,String message) {
        System.out.println(message +":"+getClass());

    }
}
