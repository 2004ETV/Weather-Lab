package com.weather.compose.forecast.presentation.components

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.weather.compose.forecast.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ForecastSearchLocationTextField(
    city: String,
    isError: Boolean,
    onCityChanged: (String) -> Unit,
    onSearch: () -> Unit,
    onLoad: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier,
        value = city,
        onValueChange = { onCityChanged(it) },
        maxLines = 1,
        singleLine = true,
        isError = isError,
        colors = TextFieldDefaults.textFieldColors(
            errorIndicatorColor = Color.Red,
            focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
            containerColor = MaterialTheme.colorScheme.background,
            errorContainerColor = MaterialTheme.colorScheme.background
        ),
        placeholder = {
            Text(
                style = MaterialTheme.typography.bodyMedium,
                text = stringResource(R.string.input_your_city),
                color = MaterialTheme.colorScheme.primary.copy(0.4F)
            )
        },
        trailingIcon = {
            IconButton(onClick = { onSearch() }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = stringResource(R.string.text_field_search_icon),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        leadingIcon = {
            IconButton(onClick = { onLoad() }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = stringResource(R.string.share_button),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardActions = KeyboardActions(onSearch = { onSearch() }),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
    )
}