package jr.brian.nbaclone

import androidx.annotation.DrawableRes

data class NbaHomePagerInfo(
    @DrawableRes val iconInt: Int,
    @DrawableRes val team1Icon: Int = R.drawable.ic_baseline_sports_basketball_24,
    @DrawableRes val team2Icon: Int = R.drawable.ic_baseline_sports_basketball_24,
    val team1Name: String,
    val team1Record: String,
    val team1Score: String,
    val team2Name: String,
    val team2Record: String,
    val team2Score: String,
    val period: String,
    val timeLeft: String
)

fun pagerData() = listOf(
    NbaHomePagerInfo(
        iconInt = R.drawable.ic_baseline_1k_plus_24,
        team1Name = "Lakers",
        team1Record = "25 - 35",
        team1Score = "76",
        team2Name = "Rockets",
        team2Record = "35 - 25",
        team2Score = "66",
        period = "Q3",
        timeLeft = "11:34"
    ),
    NbaHomePagerInfo(
        iconInt = R.drawable.ic_baseline_2k_plus_24,
        team1Name = "Timberwolves",
        team1Record = "30 - 31",
        team1Score = "54",
        team2Name = "Jazz",
        team2Record = "50 - 10",
        team2Score = "88",
        period = "Q3",
        timeLeft = "1:14"
    ),
    NbaHomePagerInfo(
        iconInt = R.drawable.ic_baseline_3k_plus_24,
        team1Name = "Bucks",
        team1Record = "55 - 5",
        team1Score = "7",
        team2Name = "Warriors",
        team2Record = "10 - 50",
        team2Score = "16",
        period = "Q1",
        timeLeft = "5:11"
    ),
    NbaHomePagerInfo(
        iconInt = R.drawable.ic_baseline_4k_plus_24,
        team1Name = "Clippers",
        team1Record = "1 - 58",
        team1Score = "2",
        team2Name = "Heat",
        team2Record = "40 - 20",
        team2Score = "31",
        period = "Q2",
        timeLeft = "8:56"
    ),
    NbaHomePagerInfo(
        iconInt = R.drawable.ic_baseline_5k_plus_24,
        team1Name = "Suns",
        team1Record = "0 - 60",
        team1Score = "99",
        team2Name = "Mavericks",
        team2Record = "55 - 5",
        team2Score = "108",
        period = "Q4",
        timeLeft = "0:34"
    )
)