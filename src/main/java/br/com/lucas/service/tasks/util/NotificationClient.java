package br.com.lucas.service.tasks.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-notification")
public interface NotificationClient {

    @PostMapping("/notifications")
    void sendNotification(@RequestBody NotificationRequest request);

}
