package com.example.thenavrangclub.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.thenavrangclub.R


@Composable
fun OfferScreen(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .background(color = Color(23,105,201,255) )
    ) {
        Image(painter = painterResource(id = R.drawable.my_first_design_4),
            contentDescription = "Offer",
            modifier = Modifier.padding(20.dp)
                .size(300.dp))
    }
}