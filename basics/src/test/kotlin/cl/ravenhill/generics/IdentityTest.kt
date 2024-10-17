package cl.ravenhill.generics

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll

class IdentityTest : FreeSpec({
    "Given an identity function" - {
        "when calling it with a string" - {
            "should return the same string" {
                checkAll(Arb.string()) { s ->
                    identity(s) shouldBe s
                }
            }
        }

        "when calling it with an integer" - {
            "should return the same integer" {
                checkAll(Arb.int()) { i ->
                    identity(i) shouldBe i
                }
            }
        }

        "when calling it with a boolean" - {
            "should return the same boolean" {
                identity(true) shouldBe true
                identity(false) shouldBe false
            }
        }
    }
})
