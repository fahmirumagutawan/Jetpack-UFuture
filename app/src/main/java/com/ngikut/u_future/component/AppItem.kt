package com.ngikut.u_future.component

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ngikut.u_future.R
import com.ngikut.u_future.model.dummy.DummyAiInfoJurusanRecommendation
import com.ngikut.u_future.model.dummy.DummyAiInfoKampusRecommendation
import com.ngikut.u_future.model.remote.response.base.SingleJurusanResponse
import com.ngikut.u_future.model.remote.response.base.SingleQuizResponse
import com.ngikut.u_future.ui.theme.AppColor
import com.ngikut.u_future.ui.theme.AppType
import kotlin.math.roundToInt

@Composable
fun InfoJurusanRecommendationByAI(
    item: SingleJurusanResponse,
    onClick: () -> Unit,
    recommendationItemWidth: Int
) {
    Box(
        modifier = Modifier
            .width(recommendationItemWidth.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(AppColor.grey50)
            .border(
                width = 2.dp,
                color = AppColor.grey100,
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
                    text = item.nama_jurusan,
                    style = AppType.subheading2
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(Int.MAX_VALUE.dp))
                        .background(AppColor.primary50)
                ) {
                    AppText(
                        modifier = Modifier.padding(8.dp),
                        text = item.jurusan,
                        style = AppType.body2,
                        color = AppColor.primary400
                    )
                }
                AppText(
                    text = item.tag_jurusan,
                    style = AppType.subheading3,
                    color = AppColor.grey600
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box {
                        CircularProgressIndicator(
                            progress = 1f,
                            color = AppColor.grey500,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 3.dp
                        )
                        CircularProgressIndicator(
                            progress = item.percentage,
                            color = AppColor.primary400,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 3.dp
                        )
                    }
                    AppText(
                        text = "${(item.percentage * 100).roundToInt()}% Match",
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
fun InfoKampusRecommendationByAI(
    item: DummyAiInfoKampusRecommendation,
    onClick: () -> Unit,
    recommendationItemWidth: Int
) {
    Box(
        modifier = Modifier
            .width(recommendationItemWidth.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(AppColor.grey50)
            .border(
                width = 2.dp,
                color = AppColor.grey100,
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

                AppText(
                    text = item.univ,
                    style = AppType.body2,
                    color = AppColor.primary400
                )

                if (item.isNegeri) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(Int.MAX_VALUE.dp))
                            .background(AppColor.primary50)
                    ) {
                        AppText(
                            modifier = Modifier.padding(4.dp),
                            text = "Negeri",
                            style = AppType.subheading3,
                            color = AppColor.primary400
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(Int.MAX_VALUE.dp))
                            .background(AppColor.primary50)
                    ) {
                        AppText(
                            modifier = Modifier.padding(4.dp),
                            text = "Swasta",
                            style = AppType.subheading3,
                            color = AppColor.primary400
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(32.dp)
                    .background(AppColor.primary50),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(24.dp),
                    painter = rememberAsyncImagePainter(model = R.drawable.dashboard_dummy_univindo_icon),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Composable
fun JurusanItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    item: SingleJurusanResponse
) {
    val itemWidth = remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(AppColor.grey50)
            .border(
                width = 2.dp,
                color = AppColor.grey100,
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
                    text = item.nama_jurusan,
                    style = AppType.subheading2
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(Int.MAX_VALUE.dp))
                        .background(AppColor.primary50)
                ) {
                    AppText(
                        modifier = Modifier.padding(8.dp),
                        text = item.jurusan,
                        style = AppType.body2,
                        color = AppColor.primary400
                    )
                }
                AppText(
                    text = item.tag_jurusan,
                    style = AppType.subheading3,
                    color = AppColor.grey600
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box {
                        CircularProgressIndicator(
                            progress = 1f,
                            color = AppColor.grey500,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 3.dp
                        )
                        CircularProgressIndicator(
                            progress = item.percentage,
                            color = AppColor.primary400,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 3.dp
                        )
                    }
                    AppText(
                        text = "${(item.percentage * 100).roundToInt()}% Match",
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
fun CompareJurusanItem(
    modifier: Modifier = Modifier,
    onPlusClicked: (item: SingleJurusanResponse) -> Unit,
    plusEnabled: Boolean,
    picked: Boolean,
    item: SingleJurusanResponse
) {
    val itemWidth = remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(AppColor.grey50)
            .border(
                width = 2.dp,
                color = AppColor.grey100,
                shape = RoundedCornerShape(16.dp)
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
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.widthIn(max = (itemWidth.value.value - 60).dp)
            ) {
                AppText(
                    text = item.nama_jurusan,
                    style = AppType.subheading2
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(Int.MAX_VALUE.dp))
                        .background(AppColor.primary50)
                ) {
                    AppText(
                        modifier = Modifier.padding(8.dp),
                        text = item.jurusan,
                        style = AppType.body2,
                        color = AppColor.primary400
                    )
                }
                AppText(
                    text = item.tag_jurusan,
                    style = AppType.subheading3,
                    color = AppColor.grey600
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box {
                        CircularProgressIndicator(
                            progress = 1f,
                            color = AppColor.grey500,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 3.dp
                        )
                        CircularProgressIndicator(
                            progress = item.percentage,
                            color = AppColor.primary400,
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 3.dp
                        )
                    }
                    AppText(
                        text = "${(item.percentage * 100).roundToInt()}% Match",
                        style = AppType.subheading3
                    )
                }
            }

            if (picked) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(32.dp)
                        .background(AppColor.grey50)
                        .border(width = 2.dp, color = AppColor.success500, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(24.dp),
                        imageVector = Icons.Default.Done,
                        contentDescription = "",
                        tint = AppColor.success500
                    )
                }
            } else {
                if (plusEnabled) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(32.dp)
                            .background(AppColor.primary400)
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = rememberRipple(
                                    color = AppColor.grey500,
                                    bounded = true
                                ),
                                onClick = {
                                    onPlusClicked(item)
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(24.dp),
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = AppColor.grey50
                        )
                    }
                } else {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(32.dp)
                            .background(AppColor.grey500),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(4.dp)
                                .size(24.dp),
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = AppColor.grey50
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PickedCompareItem(
    width: Dp,
    item: SingleJurusanResponse?,
    placeholder: String,
    onCloseClicked: (item: SingleJurusanResponse) -> Unit
) {
    Box(modifier = Modifier.width(width)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 150.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(AppColor.primary600),
            contentAlignment = Alignment.Center
        ) {
            AppText(
                text = placeholder,
                style = AppType.subheading2,
                color = AppColor.grey50,
                textAlign = TextAlign.Center
            )
        }

        item?.let {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(AppColor.primary50),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .heightIn(min = 150.dp)
                        .clip(RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.TopEnd
                ) {
                    AppIconButton(
                        imageVector = Icons.Default.Close,
                        onClick = {
                            onCloseClicked(item)
                        },
                        backgroundColor = AppColor.primary600,
                        tint = AppColor.grey50
                    )
                }
                AppText(
                    text = it.nama_jurusan,
                    style = AppType.subheading2,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun UbotBubble(
    modifier: Modifier = Modifier,
    isError: Boolean,
    message: String,
    chatType: UBotBubbleType
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp

    Box(modifier = modifier.fillMaxWidth()) {
        when (chatType) {
            UBotBubbleType.ME -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Box(
                        modifier = Modifier
                            .widthIn(max = (screenWidth/10 * 8).dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 16.dp,
                                    topEnd = 16.dp,
                                    bottomStart = 16.dp
                                )
                            )
                            .background(AppColor.primary400)
                    ) {
                        AppText(
                            modifier = Modifier.padding(16.dp),
                            text = message,
                            style = AppType.body1,
                            color = AppColor.grey50
                        )
                    }
                }
            }

            UBotBubbleType.UBOT -> {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopStart
                ) {
                    Row(
                        modifier = Modifier.widthIn(max = (screenWidth/10 * 8).dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(42.dp)
                                .shadow(elevation = 2.dp, shape = CircleShape)
                                .clip(CircleShape)
                                .background(AppColor.primary50),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                painter = rememberAsyncImagePainter(model = R.drawable.bottombar_ubot),
                                contentDescription = "",
                                tint = AppColor.primary400
                            )
                        }

                        Box(
                            modifier = Modifier
                                .widthIn(max = (screenWidth/10*8 - 60).dp)
                                .clip(
                                    RoundedCornerShape(
                                        topEnd = 16.dp,
                                        bottomEnd = 16.dp,
                                        bottomStart = 16.dp
                                    )
                                )
                                .background(AppColor.primary50)
                        ) {
                            AppText(
                                modifier = Modifier.padding(16.dp),
                                text = message,
                                style = AppType.body1
                            )
                        }
                    }
                }
            }
        }
    }
}

enum class UBotBubbleType {
    ME,
    UBOT
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalPagerApi::class)
@Composable
fun QuizQuestionItem(
    minHeigth: Dp,
    item: SingleQuizResponse,
    pickedAnswerId: String,
    onAnswerClick: (answerId: String, data: String) -> Unit,
    onOtherQuestionClick: () -> Unit
) {
    val padding = 20.dp

    Box(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .heightIn(min = minHeigth - (2 * padding.value).dp) //Because there is 20dp padding at top and bottom
            .clip(RoundedCornerShape(25.dp))
            .background(AppColor.grey50)
            .border(
                color = AppColor.grey200,
                width = 3.dp,
                shape = RoundedCornerShape(25.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            AppText(
                text = item.text,
                style = AppType.h3,
                textAlign = TextAlign.Center
            )

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                item.options?.forEach { option ->
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 12.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        AnimatedContent(
                            targetState = pickedAnswerId == option.id,
                            transitionSpec = {
                                fadeIn(animationSpec = tween(250)) with fadeOut(
                                    animationSpec = tween(
                                        250
                                    )
                                )
                            }
                        ) { isPicked ->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(if (isPicked) AppColor.primary100 else AppColor.grey100)
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = rememberRipple(
                                            bounded = true,
                                            color = AppColor.grey800
                                        ),
                                        onClick = {
                                            onAnswerClick(option.id, option.description)
                                        }
                                    )
                            ) {
                                AppText(
                                    modifier = Modifier.padding(16.dp),
                                    text = option.text,
                                    style = AppType.subheading1
                                )
                            }
                        }
                    }
                }
            }

            AppTextButton(
                onClick = onOtherQuestionClick
            ) {
                AppText(
                    text = "Berikan pertanyaan lain",
                    style = AppType.h5,
                    color = AppColor.grey500
                )
            }
        }
    }
}