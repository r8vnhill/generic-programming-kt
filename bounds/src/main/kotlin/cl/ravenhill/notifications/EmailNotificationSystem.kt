package cl.ravenhill.notifications

typealias EmailNotificationHandler =
        NotificationHandler<in EmailNotification>

class EmailNotificationSystem {
    private val _handlers = mutableListOf<EmailNotificationHandler>()
    val handlers: List<EmailNotificationHandler> = _handlers

    fun registerHandler(handler: EmailNotificationHandler) {
        _handlers += handler
    }
}
