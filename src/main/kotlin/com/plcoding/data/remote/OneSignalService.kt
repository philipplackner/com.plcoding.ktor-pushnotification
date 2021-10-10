package com.plcoding.data.remote

import com.plcoding.data.remote.dto.Notification

interface OneSignalService {

    suspend fun sendNotification(notification: Notification): Boolean

    companion object {
        const val ONESIGNAL_APP_ID = "cb36d618-3937-4e76-a615-22ec5bec1643"

        const val NOTIFICATIONS = "https://onesignal.com/api/v1/notifications"
    }
}