package com.llama.petmilly_client.presentation.shelterWrite

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llama.petmilly_client.R
import com.llama.petmilly_client.presentation.common.compnent.BottomBtnComponent
import com.llama.petmilly_client.presentation.shelterWrite.component.ShelterWriteSubTitleComponent
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWriteGenderTypeItem
import com.llama.petmilly_client.presentation.shelterWrite.item.ShelterWriteProfilePhotoItem
import com.llama.petmilly_client.presentation.shelterWrite.model.GenderType
import com.llama.petmilly_client.ui.theme.TextField_BackgroudColor
import com.llama.petmilly_client.utils.notosans_bold
import okhttp3.MultipartBody

@Composable
fun ShelterWriteProfileSuccessScreen(
    viewModel: ShelterWriteViewModel,
    onNavigate: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    ShelterWriteProfileScreen(
        petName = state.petName,
        petPhotoUri = state.petPhotoUri,
        selectedGenderType = state.gender,
        onPetName = viewModel::setPetName,
        onSelectedGender = viewModel::setPetGender,
        onUploadFile = viewModel::setUploadFile,
        onDeleteFile = viewModel::setDeleteFile,
        onUploadUri = viewModel::setUploadUri,
        onDeleteUri = viewModel::setDeleteUri,
        onNavigate = onNavigate
    )
}

@SuppressLint("Recycle")
@Composable
private fun ShelterWriteProfileScreen(
    petName: String,
    petPhotoUri: List<Uri>,
    selectedGenderType: GenderType?,
    onPetName: (String) -> Unit,
    onSelectedGender: (GenderType) -> Unit,
    onUploadFile: (MultipartBody.Part) -> Unit,
    onUploadUri: (Uri) -> Unit,
    onDeleteFile: (MultipartBody.Part) -> Unit,
    onDeleteUri: (Uri) -> Unit,
    onNavigate: () -> Unit,
) { petName.isNotEmpty() && selectedGenderType != null

    val isCheck by remember(petName, selectedGenderType) {
        derivedStateOf {
            petName.isNotEmpty() && selectedGenderType != null
        }
    }
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        ShelterWriteSubTitleComponent(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(R.string.shelter_write_pet_profile_title)
        )

        Text(
            text = stringResource(R.string.name),
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier
                .padding(start = 30.dp, top = 28.dp),
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        TextField(
            value = petName,
            onValueChange = onPetName,
            modifier = Modifier
                .padding(top = 6.dp)
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(55.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = TextField_BackgroudColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedLabelColor = Color.White,
                cursorColor = Color.Black,),
            placeholder = { Text(text = stringResource(R.string.shelter_write_pet_profile_textField_hint)) }
        )

        Text(
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    top = 28.dp
                ),
            text = stringResource(R.string.gender),
            color = Color.Black,
            fontSize = 13.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        ShelterWriteGenderTypeItem(
            isSelectedGender = selectedGenderType,
            onSelectedGender = onSelectedGender
        )

        Text(
            modifier = Modifier
                .padding(start = 30.dp, top = 35.dp),
            text = stringResource(R.string.shelter_write_pet_profile_photo_subtitle),
            color = Color.Black,
            fontSize = 13.sp,
            fontFamily = notosans_bold,
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )
            )
        )

        ShelterWriteProfilePhotoItem(
            modifier = Modifier
                .padding(top = 8.dp),
            imageUriData = petPhotoUri,
            onUploadUri = onUploadUri,
            onUploadFile = onUploadFile,
            onDeletedImage = onDeleteUri,
            onDeleteFile = onDeleteFile
        )

        Spacer(modifier = Modifier.weight(1f))

        BottomBtnComponent(
            modifier = Modifier
                .padding(20.dp),
            title = stringResource(R.string.next),
            isCheck = isCheck,
            page = "1/8",
            onClick = {
               if (isCheck) onNavigate()
            }
        )
    }
}

@Preview
@Composable
private fun PreviewShelterWriteProfileScreen() {
    ShelterWriteProfileScreen(
        petName = "금순이",
        petPhotoUri = emptyList(),
        selectedGenderType = GenderType.MALE,
        onPetName = {},
        onSelectedGender = {},
        onUploadFile = {},
        onUploadUri = {},
        onDeleteFile = {},
        onDeleteUri = {},
        onNavigate = {}
    )
}

data class ImageTestUriData(
    val uri: Uri,
)