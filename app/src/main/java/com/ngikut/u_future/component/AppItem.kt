package com.ngikut.u_future.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.ngikut.u_future.screen.info_jurusan.DummyAiInfoJurusanRecomendation
import com.ngikut.u_future.ui.theme.AppColor
import com.ngikut.u_future.ui.theme.AppType
import kotlin.math.roundToInt

@Composable
fun InfoJurusanRecommendationByAI(
    item: DummyAiInfoJurusanRecomendation,
    onClick: () -> Unit,
    recommendationItemWidth: Int
) {
    Box(
        modifier = Modifier
            .width(recommendationItemWidth.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(AppColor.grey50)
            .border(
                width = 1.dp,
                color = AppColor.grey600,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(
                    bounded = true,
                    color = AppColor.grey800
                ),
                onClick = onClick
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.widthIn(max = (recommendationItemWidth - 60).dp)
            ) {
                AppText(
                    text = item.prodiName,
                    style = AppType.subheading2
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(Int.MAX_VALUE.dp))
                        .background(AppColor.primary50)
                ) {
                    AppText(
                        modifier = Modifier.padding(8.dp),
                        text = item.arah,
                        style = AppType.body2,
                        color = AppColor.primary400
                    )
                }
                AppText(
                    text = item.tag,
                    style = AppType.subheading3,
                    color = AppColor.grey600
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CircularProgressIndicator(
                        progress = (item.percent / 100).toFloat(),
                        color = AppColor.primary400,
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 3.dp
                    )
                    AppText(
                        text = "${item.percent.roundToInt()}% Match",
                        style = AppType.subheading3
                    )
                }
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32.dp)
                    .background(AppColor.primary50)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = rememberRipple(
                            bounded = true,
                            color = AppColor.grey800
                        ),
                        onClick = {/*TODO*/ }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    tint = AppColor.grey500
                )
            }
        }
    }
}

@Composable
fun JurusanItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    item: DummyAiInfoJurusanRecomendation
) {
    val itemWidth = remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(AppColor.grey50)
            .border(
                width = 1.dp,
                color = AppColor.grey600,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = rememberRipple(
                    bounded = true,
                    color = AppColor.grey800
                ),
                onClick = onClick
            )
            .onSizeChanged {
                density.run {
                    itemWidth.value = it.width.toDp()
                }
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.widthIn(max = (itemWidth.value.value - 60).dp)
            ) {
                AppText(
                    text = item.prodiName,
                    style = AppType.subheading2
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(Int.MAX_VALUE.dp))
                        .background(AppColor.primary50)
                ) {
                    AppText(
                        modifier = Modifier.padding(8.dp),
                        text = item.arah,
                        style = AppType.body2,
                        color = AppColor.primary400
                    )
                }
                AppText(
                    text = item.tag,
                    style = AppType.subheading3,
                    color = AppColor.grey600
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CircularProgressIndicator(
                        progress = (item.percent / 100).toFloat(),
                        color = AppColor.primary400,
                        modifier = Modifier.size(24.dp),
                        strokeWidth = 3.dp
                    )
                    AppText(
                        text = "${item.percent.roundToInt()}% Match",
                        style = AppType.subheading3
                    )
                }
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32.dp)
                    .background(AppColor.primary50)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = rememberRipple(
                            bounded = true,
                            color = AppColor.grey800
                        ),
                        onClick = {/*TODO*/ }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    tint = AppColor.grey500
                )
            }
        }
    }
}