package cl.ravenhill.notifications

open class Notification(val message: String)
class EmailNotification(message: String, val recipient: String) : Notification(message)