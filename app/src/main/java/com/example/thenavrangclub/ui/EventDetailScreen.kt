package com.example.thenavrangclub.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thenavrangclub.R
import com.example.thenavrangclub.ui.EventDetails

@Composable
fun EventDetailScreen(eventTitle: String) {
    val eventDetails = getEventDetails(eventTitle)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = eventDetails.imageRes),
            contentDescription = eventDetails.eventName,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = eventDetails.eventName,
            color = Color.White
        )
        Text(
            text = eventDetails.eventDescription,
            color = Color.White
        )
    }
}

private fun getEventDetails(eventName: String): EventDetails {
    return EventDetails(
        imageRes = R.drawable.my_first_design_4,
        eventName = eventName,
        eventDescription = "Description for $eventName"
    )
}
