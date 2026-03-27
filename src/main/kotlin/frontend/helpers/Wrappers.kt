package org.example.frontend.helpers

import com.codeborne.selenide.Selectors
import org.openqa.selenium.By

class Wrappers {

    companion object {
        fun byDataTestGroup(target: String): By {
            return Selectors.by("data-test-group", target)
        }
        fun byDataTestId(target: String) = Selectors.by("data-test-id", target)!!

        fun byDataInspector(target: String) = Selectors.by("data-v-inspector", target)!!
    }
}