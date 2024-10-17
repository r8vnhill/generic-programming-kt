package cl.ravenhill.generics

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class BoxTest : FreeSpec({
    "Given a Box" - {
        "when creating it with an integer" - {
            "should store the integer value" {
                checkAll(Arb.int()) { i ->
                    Box(i).value shouldBe i
                }
            }
        }

        "when creating it with a string" - {
            "should store the string value" {
                checkAll(Arb.string()) { s ->
                    Box(s).value shouldBe s
                }
            }
        }

        "when creating it with a boolean" - {
            "should store the boolean value" {
                Box(true).value shouldBe true
                Box(false).value shouldBe false
            }
        }
    }
})
