package com.llama.petmilly_client.presentation.shelterWrite.item

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.shelterWrite.ImageTestUriData
import com.llama.petmilly_client.utils.PicktureUriItems
import com.llama.petmilly_client.utils.SpacerWidth
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.IOException

@Composable
fun ShelterWriteProfilePhotoItem(
    modifier: Modifier = Modifier,
    imageUriData: List<ImageTestUriData>,
    onUploadUri: (Uri) -> Unit,
    onUploadFile: (MultipartBody.Part) -> Unit,
    onDeletedImage: (Uri) -> Unit,
    onDeleteFile: (MultipartBody.Part) -> Unit,
) {
    val context = LocalContext.current

    val bitmapState = remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri ->
        try {
            val inputStream = context.contentResolver.openInputStream(uri!!)
            val requestBody = RequestBody.create("image/*".toMediaTypeOrNull(), inputStream!!.readBytes())
            val multipleBody = MultipartBody.Part.createFormData("files", "image", requestBody)

            bitmapState.value = BitmapFactory.decodeStream(inputStream)
            onUploadUri(uri)
            onUploadFile(multipleBody)

        } catch (e: IOException) {
            Log.d("TAG", "Uri Call Error: $e")
        }
    }

    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_test_dog4),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 20.dp)
                .height(47.dp)
                .width(47.dp)
                .clickable {
                    launcher.launch("image/*")
                }
        )

        SpacerWidth(dp = 10.dp)

        LazyRow {
            items(
                items = imageUriData,
                key = { it }
            ) { items ->
                PicktureUriItems(
                    items.uri,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                    ondelete = {
                        val inputStream = context.contentResolver.openInputStream(items.uri)
                        val requestBody = RequestBody.create(
                            "image/*".toMediaTypeOrNull(),
                            inputStream!!.readBytes()
                        )
                        val multipleBody =
                            MultipartBody.Part.createFormData("files", "image", requestBody)

                        onDeletedImage(items.uri)
                        onDeleteFile(multipleBody)
                    }
                )
                SpacerWidth(dp = 10.dp)
            }
        }
    }
}