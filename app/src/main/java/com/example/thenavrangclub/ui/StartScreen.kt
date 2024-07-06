package com.example.thenavrangclub.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flash.ui.NavViewModel
import com.example.thenavrangclub.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun StartScreen(
    navViewModel: NavViewModel,
    onCategoryClicked: (String) -> Unit) {
    val navUiState by navViewModel.uiState.collectAsState()
    val scope = rememberCoroutineScope()
    var isMenuVisible by remember { mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopBar(onMenuClick = {
                scope.launch {
                    isMenuVisible = !isMenuVisible
                }
            })
        },
        bottomBar = { BottomNavigationBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Divider(color = Color.White, thickness = 1.dp)
                BannerSection()
                ExploreEventsSection()
                AboutSection()
            }
            SlideInMenu(isMenuVisible = isMenuVisible, onMenuItemClick = {
                scope.launch {
                    isMenuVisible = false
                    // Handle menu item clicks here
                }
            })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(onMenuClick: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
            }
        },
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.club_logo_3),
                    contentDescription = "Logo",
                    modifier = Modifier.size(150.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { /* Handle cart click */ }) {
                Icon(
                    Icons.Default.ShoppingCart,
                    contentDescription = "Cart",
                    tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        )
    )
}

@Composable
fun BannerSection() {
    val images = listOf(
        R.drawable.banner,
        R.drawable.blog_6,
        R.drawable.banner4
    )
    val currentIndex = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = currentIndex.value) {
        delay(5000) // Change image every 5 seconds
        currentIndex.value = (currentIndex.value + 1) % images.size
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Image(
            painter = painterResource(id = images[currentIndex.value]),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ExploreEventsSection(


) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Explore the Events",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(top = 8.dp)
        ) {
            items(7) { index ->
                EventCard(
                    imageRes = when (index) {
                        0 -> R.drawable.event1
                        1 -> R.drawable.event2
                        2 -> R.drawable.event5
                        3 -> R.drawable.event4
                        4 -> R.drawable.event4
                        // Add other event drawable resources here
                        else -> R.drawable.event1 // Default drawable
                    },
                    eventName = when (index) {
                        0 -> "Show Your Talent"
                        1 -> "Treasure Hunt- theme Money Heist"
                        2 -> "Tune In - Singing Competition"
                        3 -> "Danzeal- Dance Competition"
                        4 -> "Stand Up Samvaad-Open Mic Competition"
                        // Add other event names here
                        else -> "Event $index"
                    },
                    onClick = {

                    }
                )
            }
        }
    }
}

@Composable
fun EventCard(imageRes: Int, eventName: String, onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .clickable(onClick = onClick)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = eventName,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
@Composable
fun AboutSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Center horizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.navlogoapp), // Replace with your image resource
            contentDescription = null,
            modifier = Modifier
                .size(250.dp) // Set desired size
                .padding(bottom = 8.dp) // Add padding below the image
        )
        Text(
            text = "About NAVRANG",
            color = Color.Yellow,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp) // Add padding below the title
        )

        Text(
            text = "Make Your Mark: Navrang is not just a club; it's a canvas for you to paint your unique cultural story at PSIT. " +
                    "Be Part of Something Bigger: By joining Navrang, you contribute to a legacy of creativity and leave a lasting impact on campus culture. " +
                    "Fun and Friendships: Expect not just events but a community of like-minded individuals who share a passion for culture, laughter, and collective growth.",
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Center // Center the text horizontally
        )
    }
}


@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White,
        modifier = Modifier.height(80.dp)
    ) {
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "Home"
                )
            },

            selected = false,
            onClick = { /* Handle home click */ }
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.events),
                    contentDescription = "Events"
                )
            },

            selected = false,
            onClick = { /* Handle events click */ }
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile"
                )
            },

            selected = false,
            onClick = { /* Handle profile click */ }
        )
    }
}
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SlideInMenu(isMenuVisible: Boolean, onMenuItemClick: (String) -> Unit) {
    AnimatedVisibility(
        visible = isMenuVisible,
        enter = slideInHorizontally(initialOffsetX = { -it })
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFC107))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Menu",
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable { onMenuItemClick("Close") },
                    tint = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                MenuItem(icon = Icons.Default.Home, title = "Home") { onMenuItemClick("Home") }
                MenuItem(icon = Icons.Default.DateRange, title = "Events") { onMenuItemClick("Events") }
                MenuItem(icon = Icons.Default.Person, title = "Profile") { onMenuItemClick("Profile") }
                MenuItem(icon = Icons.Default.CheckCircle, title = "Your Tickets") { onMenuItemClick("Your Tickets") }
                MenuItem(icon = Icons.Default.ShoppingCart, title = "Your Carts") { onMenuItemClick("Your Carts") }
                MenuItem(icon = Icons.Default.LocationOn, title = "Team") { onMenuItemClick("Team") }
                MenuItem(icon = Icons.Default.Build, title = "Sponsors") { onMenuItemClick("Sponsors") }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "The Navrang Club\nInspiring Generations",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "CONTACT US",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}
@Composable
fun MenuItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = title,
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}