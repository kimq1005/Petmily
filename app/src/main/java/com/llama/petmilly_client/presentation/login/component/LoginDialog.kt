package com.llama.petmilly_client.presentation.login.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.llama.petmilly_client.R
import com.llama.petmilly_client.ui.theme.Button_Clicked
import com.llama.petmilly_client.ui.theme.Button_NoneClicked

@Composable
fun CustomDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .fillMaxHeight(0.20f)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = stringResource(id = R.string.kakao_login_dialog_text),
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 10.dp)
                ) {
                    Button(
                        onClick = { onDismiss() },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 20.dp, end = 5.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Button_NoneClicked)


                    ) {
                        Text(
                            text = "취소",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Button(
                        onClick = { onConfirm() },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 5.dp, end = 20.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Button_Clicked)

                    ) {
                        Text(
                            text = "열기",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun CustomDialogPreview() {
    CustomDialog(
        onDismiss = {},
        onConfirm = {}
    )
}
