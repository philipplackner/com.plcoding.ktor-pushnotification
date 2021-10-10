package com.plcoding.plugins

import com.plcoding.data.remote.OneSignalService
import com.plcoding.data.remote.dto.Notification
import com.plcoding.data.remote.dto.NotificationMessage
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting(service: OneSignalService) {
    routing {
        get("/sendNotification") {
            val title = call.parameters["title"] ?: "Test"
            val description = call.parameters["description"] ?: "Test"

            val successful = service.sendNotification(
                Notification(
                    includedSegments = listOf("All"),
                    headings = NotificationMessage(en = title),
                    contents = NotificationMessage(en = description),
                    appId = OneSignalService.ONESIGNAL_APP_ID
                )
            )

            if(successful) {
                call.respond(HttpStatusCode.OK)
            } else {
                call.respond(HttpStatusCode.InternalServerError)
            }
        }
    }
}
