package com.ngikut.u_future.screen.info_kampus

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.ngikut.u_future.R
import com.ngikut.u_future.component.*
import com.ngikut.u_future.model.dummy.DummyAiInfoKampusRecommendation
import com.ngikut.u_future.model.dummy.DummyUnivInfoKampus
import com.ngikut.u_future.ui.theme.AppColor
import com.ngikut.u_future.ui.theme.AppType
import com.ngikut.u_future.viewmodel.info_kampus.InfoKampusViewmodel

@Composable
fun InfoKampusScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<InfoKampusViewmodel>()
    val localFocus = LocalFocusManager.current
    val recommendationItemWidth = LocalConfiguration.current.screenWidthDp * 7 / 10
    val univItemWidth = LocalConfiguration.current.screenWidthDp / 6
    val univItemMinHeight = univItemWidth * 3 / 4
    val listOfDummyRecom = listOf(
        DummyAiInfoKampusRecommendation(
            prodiName = "Teknik Informatika",
            univ = "Universitas Indonesia",
            isNegeri = true
        ),
        DummyAiInfoKampusRecommendation(
            prodiName = "Teknik Komputer",
            univ = "Universitas Indonesia",
            isNegeri = true
        ),
        DummyAiInfoKampusRecommendation(
            prodiName = "Teknik Mesin",
            univ = "Universitas Indonesia",
            isNegeri = true
        ),
        DummyAiInfoKampusRecommendation(
            prodiName = "Teknik Perikanan",
            univ = "Universitas Indonesia",
            isNegeri = true
        ),
    )
    val listOfDummyUnivNegeri = listOf(
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_ui,
            text = "UI"
        ),
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_ub,
            text = "UB"
        ),
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_ugm,
            text = "UGM"
        ),
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_itb,
            text = "ITB"
        ),
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_undip,
            text = "UNDIP"
        ),
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_its,
            text = "ITS"
        )
    )
    val listOfDummyUnivSwasta = listOf(
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_binus,
            text = "BINUS"
        ),
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_binus,
            text = "BINUS"
        ),
        DummyUnivInfoKampus(
            icon = R.drawable.logo_kampus_binus,
            text = "BINUS"
        ),
    )

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.grey50),
        columns = GridCells.Fixed(3)
    ) {
        item(
            span = { GridItemSpan(3) }
        ) {
            Box(modifier = Modifier.background(AppColor.primary400)) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(AppColor.grey50),
                    contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        AppText(
                            text = "Info Kampus",
                            style = AppType.h3
                        )
                        AppText(
                            text = "Eksplorasi 50+ perguruan tinggi terbaik yang ada di Indonesia dan luar negeri.",
                            style = AppType.body2,
                            color = AppColor.grey500
                        )
                        AppTextInputNormal(
                            modifier = Modifier.fillMaxWidth(),
                            placeHolder = "Kata Kunci",
                            value = viewModel.searchValueState.value,
                            onValueChange = {
                                viewModel.searchValueState.value = it
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "",
                                    tint = AppColor.grey500
                                )
                            },
                            trailingIcon = {
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(3.dp))
                                        .background(AppColor.primary50)
                                        .clickable(
                                            interactionSource = MutableInteractionSource(),
                                            indication = rememberRipple(
                                                color = AppColor.grey800,
                                                bounded = true
                                            ),
                                            onClick = {
                                                localFocus.clearFocus(true)
                                                if (viewModel
                                                        .searchValueState
                                                        .value
                                                        .trim()
                                                        .isNotEmpty()
                                                ) {
                                                    /*TODO Navigate to search detail screen*/
                                                }
                                            }
                                        )
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(6.dp),
                                        imageVector = Icons.Default.ArrowForward,
                                        contentDescription = "",
                                        tint = AppColor.primary400
                                    )
                                }
                            })
                    }
                }
            }
        }

        item(
            span = {
                GridItemSpan(3)
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColor.primary400)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topEnd = 25.dp, topStart = 25.dp))
                        .background(AppColor.primary600)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(AppColor.primary50)
                        ) {
                            Icon(
                                modifier = Modifier.padding(8.dp),
                                painter = rememberAsyncImagePainter(model = R.drawable.bottombar_ubot),
                                contentDescription = "",
                                tint = AppColor.primary400
                            )
                        }

                        AppText(
                            text = "Berikut adalah rekomendasi untukmu!",
                            style = AppType.subheading2,
                            color = AppColor.grey50
                        )
                    }
                }
            }
        }

        item(
            span = { GridItemSpan(3) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppColor.primary600)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .background(AppColor.grey50)
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            AppText(text = "Rekomendasi oleh AI", style = AppType.h3)
                            AppTextButton(onClick = { /*TODO*/ }) {
                                AppText(
                                    text = "Lihat semua",
                                    style = AppType.body2,
                                    color = AppColor.grey600
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.horizontalScroll(state = rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Spacer(modifier = Modifier)
                            listOfDummyRecom.forEach {
                                InfoKampusRecommendationByAI(
                                    item = it,
                                    recommendationItemWidth = recommendationItemWidth,
                                    onClick = {/*TODO*/ })
                            }
                            Spacer(modifier = Modifier)
                        }
                    }
                }
            }
        }

        item(
            span = { GridItemSpan(3) }
        ) {
            AppText(
                modifier = Modifier.padding(
                    top = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
                text = "Perguruan Tinggi Negeri",
                style = AppType.h3
            )
        }

        items(listOfDummyUnivNegeri) { item ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .width(univItemWidth.dp)
                    .heightIn(min = univItemMinHeight.dp)
                    .padding(12.dp)
                    .border(
                        color = AppColor.grey100,
                        width = 2.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = rememberRipple(color = AppColor.grey800, bounded = true),
                        onClick = {/*TODO*/ }
                    )
            ) {
                Column(
                    modifier = Modifier
//                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .background(AppColor.grey50)
                        .padding(12.dp)
                        .fillMaxWidth()
                        .heightIn(min = univItemMinHeight.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        painter = rememberAsyncImagePainter(model = item.icon),
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(AppColor.grey500),
                        contentDescription = "",
                        tint = Color.Unspecified
                    )

                    AppText(
                        text = item.text,
                        style = AppType.subheading3,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        item(
            span = { GridItemSpan(3) }
        ) {
            AppText(
                modifier = Modifier.padding(
                    top  = 20.dp,
                    start = 20.dp,
                    end = 20.dp
                ),
                text = "Perguruan Tinggi Swasta",
                style = AppType.h3
            )
        }

        items(listOfDummyUnivSwasta) { item ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .width(univItemWidth.dp)
                    .heightIn(min = univItemMinHeight.dp)
                    .padding(12.dp)
                    .border(
                        color = AppColor.grey100,
                        width = 2.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = rememberRipple(color = AppColor.grey800, bounded = true),
                        onClick = {/*TODO*/ }
                    )
            ) {
                Column(
                    modifier = Modifier
//                        .shadow(elevation = 4.dp, shape = RoundedCornerShape(16.dp))
                        .clip(RoundedCornerShape(16.dp))
                        .background(AppColor.grey50)
                        .padding(12.dp)
                        .fillMaxWidth()
                        .heightIn(min = univItemMinHeight.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        painter = rememberAsyncImagePainter(model = item.icon),
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(AppColor.grey500),
                        contentDescription = "",
                        tint = Color.Unspecified
                    )

                    AppText(
                        text = item.text,
                        style = AppType.subheading3,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}