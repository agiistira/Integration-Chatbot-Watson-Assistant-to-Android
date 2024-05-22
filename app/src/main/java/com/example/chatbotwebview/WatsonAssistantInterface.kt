package com.example.chatbotwebview

// WatsonAssistantInterface.kt
import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class WatsonAssistantInterface(private val context: Context) {

    @JavascriptInterface
    fun sendMessage(message: String) {
        // Handle sending message to Watson Assistant
        // For simplicity, just display a toast message with the user's message
        Toast.makeText(context, "User message: $message", Toast.LENGTH_SHORT).show()
    }

    // Method to receive response from Watson Assistant
    fun receiveMessage(response: String) {
        // Handle receiving message from Watson Assistant
        // For simplicity, just display a toast message with the response
        Toast.makeText(context, "Watson Assistant response: $response", Toast.LENGTH_SHORT).show()
    }
}
