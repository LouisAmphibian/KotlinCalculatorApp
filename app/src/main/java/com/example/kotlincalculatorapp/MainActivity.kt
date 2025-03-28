package com.example.kotlincalculatorapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Validation flags
    private var canAddOperation = false
    private var canAddDecimal = true

    // Declare TextView variables
    private lateinit var workingsTV: TextView
    private lateinit var resultsTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize TextViews
        workingsTV = findViewById(R.id.workingsTV) // make sure this ID matches your XML
        resultsTV = findViewById(R.id.resultsTV)


    }

    fun numberAction(view: View) {
        if (view is Button) {
            // Check if the clicked view is a Button
            if (view.text == ".") {
                // Check if a decimal point can be added (only one decimal allowed)
                if (canAddDecimal) {
                    workingsTV.append(view.text) // Append the decimal point to the workings TextView
                }
                canAddDecimal = false // Set canAddDecimal to false to prevent adding another decimal point
            } else {
                workingsTV.append(view.text) // If the button text is not a decimal, append the number to the workings TextView
            }
            canAddOperation = true
        }
    }

    fun operationAction(view: View) {
        if (view is Button && canAddOperation) {
            workingsTV.append(view.text)
            canAddOperation = false
            canAddDecimal = true
        }
    }

    // Function to clear all inputs and results
    fun allClearAction(view: View) {
        // Set the text of workingsTV (the input display) to an empty string
        workingsTV.text = ""
        // Set the text of resultsTV (the results display) to an empty string
        resultsTV.text = ""
    }

    // Function to handle backspace action
    fun backSpaceAction(view: View) {
        // Get the current length of the text in workingsTV
        val length = workingsTV.text.length // Use text.length instead of length()

        // Check if there is any text to remove
        if (length > 0) {
            // Remove the last character from the text in workingsTV
            workingsTV.text = workingsTV.text.subSequence(0, length - 1)
        }
    }

    // Function to calculate and display the result of the expression
    fun equalsAction(view: View) {
        // Call the calculateResults function to compute the result
        // and set the result in resultsTV (the results display)
        resultsTV.text = calculateResults()
    }

    // Placeholder for the calculateResults function
    private fun calculateResults(): String {
        // Implement your calculation logic here
        return "0" // Return a default value for now
    }
}