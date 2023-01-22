package jr.brian.nbaclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import jr.brian.nbaclone.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NBACloneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        HeaderRow()
                        Divider(color = DarkGrey)
                        StoryRow()
                        NbaScoresViewPager()
                    }
                }
            }
        }
    }
}

@Composable
fun HeaderRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(Modifier.width(5.dp))
        Icon(
            painterResource(id = R.drawable.ic_baseline_directions_walk_24),
            contentDescription = "Jerry",
            modifier = Modifier.size(30.dp)
        )
        Text(text = "NBA", style = TextStyle(fontSize = 36.sp))

        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_person_pin_24),
            contentDescription = "Ball",
            modifier = Modifier.size(30.dp)
        )
        Spacer(Modifier.width(5.dp))
    }
}

@Composable
fun StoryRow() {
    LazyRow() {
        items(7) {
            StoryCircle(isLive = it % 2 != 0)
        }
    }
}

@Composable
fun StoryCircle(isLive: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
                .border(3.dp, CherryRed, CircleShape)
                .clickable {

                }
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_sports_basketball_24),
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(bottom = 5.dp),
                )
                Divider(color = DarkGrey)
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_sports_basketball_24),
                    contentDescription = "",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }
        }
        Spacer(Modifier.height(10.dp))
        if (isLive) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .width(50.dp)
                    .clip(CutCornerShape(size = 1.dp))
                    .background(CherryRed)
            ) {
                Text(text = "LIVE", style = TextStyle(color = TextWhite))
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NbaScoresViewPager() {
    val items = pagerData()
    val pagerState = rememberPagerState()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        HorizontalPager(
            count = items.size,
            state = pagerState,
        ) { currentPageIndex ->
            ViewPagerCard(currentPageIndex = currentPageIndex, items = items)
        }
        Spacer(modifier = Modifier.height(15.dp))
        HorizontalPagerIndicator(
            inactiveColor = TextWhite,
            activeColor = BlueViolet3,
            indicatorWidth = 9.dp,
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ViewPagerCard(currentPageIndex: Int, items: List<NbaHomePagerInfo>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp)
            .padding(15.dp)
            .clickable { },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(items[currentPageIndex].iconInt),
                contentDescription = "",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
            Divider(color = DarkGrey)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                id = items[currentPageIndex].team1Icon
                            ),
                            contentDescription = ""
                        )
                        Text(items[currentPageIndex].team1Name)
                        Text(items[currentPageIndex].team1Record)
                    }
                    Text(
                        items[currentPageIndex].team1Score,
                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    )
                }

                Spacer(Modifier.weight(.3f))

                Row {
                    Text(
                        "${items[currentPageIndex].period} " +
                                items[currentPageIndex].timeLeft
                    )
                }

                Spacer(Modifier.weight(.3f))

                Row {
                    Text(
                        items[currentPageIndex].team2Score,
                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                id = items[currentPageIndex].team2Icon
                            ),
                            contentDescription = ""
                        )
                        Text(items[currentPageIndex].team2Name)
                        Text(items[currentPageIndex].team2Record)
                    }
                }
            }
            Divider(color = DarkGrey)
            Text("League Pass", modifier = Modifier.padding(5.dp))
        }
    }
}