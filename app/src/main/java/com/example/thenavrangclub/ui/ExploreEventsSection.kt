package com.example.thenavrangclub.ui

import androidx.compose.foundation.clickable



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class EventDetails(
    val imageRes: Int,
    val eventName: String,
    val eventDescription: String
) {
    override fun toString(): String {
        return eventName // Use eventName as a unique identifier
    }
}
//
//@Composable
//fun ExploreEventsSection(eventList: List<EventDetails> ,
//                         onEventClicked: (String) -> Unit) {
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text(
//            text = "Explore the Events",
//            color = Color.White
//        )
//        LazyRow(modifier = Modifier.padding(top = 8.dp)) {
//            items(eventList) { event ->
//                EventCard(event = event, onEventClicked = onEventClicked)
//            }
//        }
//    }
//}

@Composable
fun EventCard(event: EventDetails, onEventClicked: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onEventClicked(event.eventName) }
    ) {
        // Your event card UI here
        Text(
            text = event.eventName,
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
