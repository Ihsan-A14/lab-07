package com.example.lab_7

import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest2 {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_derivers_add_deriver_and_return_home() {
        // navigate to driver screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify driver screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter driver
        composeTestRule
            .onNodeWithTag("DriverInput")
            .performTextInput("Verstappen")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverInput")
            .performClick()

        // verify driver appears
        composeTestRule
            .onNodeWithText("Verstappen")
            .assertExists()

        // clear driver
        composeTestRule
            .onNodeWithTag("clearButton")
            .performClick()

        // verify driver is not there anymore
        composeTestRule
            .onNodeWithText("Verstappen")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
