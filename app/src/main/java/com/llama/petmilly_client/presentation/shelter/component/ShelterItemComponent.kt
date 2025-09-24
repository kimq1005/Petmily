package com.llama.petmilly_client.presentation.shelter.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Background_FDFCE1
import com.llama.petmilly_client.ui.theme.Black_20_Transfer
import com.llama.petmilly_client.ui.theme.Black_30_Transfer
import com.llama.petmilly_client.ui.theme.Black_60_Transfer
import com.llama.petmilly_client.utils.CommonObject.convertTimetoHour
import com.llama.petmilly_client.utils.notosans_bold
import com.llama.petmilly_client.utils.notosans_regular

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ShelterItemComponent(
    modifier: Modifier = Modifier,
    image: String = "",
    title: String,
    description: String,
    vaccination: String,
    isComplete: Boolean,
    isReceipt: Boolean,
    time: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .height(90.dp)
            .border(width = 1.dp, color = Color(0xFFEfEfEf), shape = RoundedCornerShape(7.dp))
            .clickable {
                onClick()
            }
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .width(80.dp)
                    .height(80.dp)
                    .align(Alignment.CenterStart)
                    .padding(start = 15.dp, top = 10.dp),
                painter = if (image.isNotEmpty())
                    rememberAsyncImagePainter(model = image)
                else
                    painterResource(id = R.drawable.img_testcat_2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            val text = when {
                !isReceipt -> "심사중"
                isComplete -> "petmily ❤️"
                else -> null
            }

            text?.let {
                ShelterLabelComponent(
                    text = it,
                    isComplete = isComplete,
                    modifier = modifier.offset(y = 15.dp, x = 5.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (!isComplete) title else "(완료) $title",
                color = if (!isComplete) Color.Black else Black_30_Transfer,
                fontSize = 15.sp,
                fontFamily = notosans_bold,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Spacer(modifier = Modifier.height(3.dp))

            Text(
                text = description,
                fontSize = 12.sp,
                color = if (!isComplete) Black_60_Transfer else Black_20_Transfer,
                modifier = Modifier
                    .background(color = Background_FDFCE1),
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )

            Text(
                text = vaccination,
                fontSize = 12.sp,
                color = if (!isComplete) Black_60_Transfer else Black_20_Transfer,
                fontFamily = notosans_regular,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = convertTimetoHour(time),
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 8.dp, top = 6.dp),
                fontSize = 8.sp,
                fontFamily = notosans_regular,
                color = Black_30_Transfer,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false
                    )
                )

            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun PreviewShelterItemComponent() {
    ShelterItemComponent(
        image = "periculis",
        title = "nisl",
        description = "deterruisset",
        vaccination = "suas",
        isComplete = false,
        isReceipt = false,
        time = "curae",
        onClick = {}
    )
}

