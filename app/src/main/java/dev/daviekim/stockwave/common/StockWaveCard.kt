package dev.daviekim.stockwave.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun StockWaveCard(
    symbol: String = "AAPL",
    name: String = "Apple Inc.",
    date: String = "19 Jun 2022",
    close: Double = 151.28,
    open: Double = 148.07,
    high: Double = 157.50,
    low: Double = 147.82
) {

    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color(241, 245, 249),
        modifier = Modifier
            .padding(10.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp, 10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(218, 220, 223)
                ){
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = "  $symbol  ",
                        color = Color(32, 43, 61),
                        style = TextStyle(
                            fontSize = 16.sp,
                        )
                    )
                }
                Text(
                    text = date,
                    style = TextStyle(
                        fontSize = 16.sp,
                    )
                )
            }

            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                ) {
                Text(
                    text = name,
                    color = Color(32, 43, 61),
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = Color(11, 184, 126)
                ){
                    Text(
                        modifier = Modifier
                            .padding(4.dp),
                        text = "  $$close  ",
                        color = Color(241, 245, 249),
                        style = TextStyle(
                            fontSize = 18.sp,
                        )
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
                ) {
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Open ",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                    Text(
                        text = " $$open",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "High ",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                    Text(
                        text = " $$high",
                        color = Color(11, 184, 126),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }
                Row(
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "Low ",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                    Text(
                        text = " $$low",
                        color = Color(239, 107, 108),
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }
            }

        }
    }

}