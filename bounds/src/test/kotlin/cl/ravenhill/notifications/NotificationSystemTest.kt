package cl.ravenhill.notifications

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class NotificationSystemTest : FreeSpec({
    "A notification system" - {
        "when registering a handler" - {
            "should contain the handler" {
                val system = EmailNotificationSystem()
                val generalHandler = NotificationHandler<Notification>()
                system.run {
                    handlers.shouldBeEmpty()
                    registerHandler(generalHandler)
                    handlers shouldHaveSize 1
                    handlers.last() shouldBe generalHandler
                }
            }
        }
    }
})
