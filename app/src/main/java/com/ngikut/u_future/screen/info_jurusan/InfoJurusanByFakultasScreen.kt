package com.ngikut.u_future.screen.info_jurusan

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ngikut.u_future.component.AppTopBar
import com.ngikut.u_future.component.JurusanItem
import com.ngikut.u_future.viewmodel.info_jurusan.InfoJurusanByFakultasViewmodel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InfoJurusanByFakultasScreen(
    navController: NavController,
    fakultasName: String /*TODO should be fakultas_id, not only name. Now is for dummy purpose*/
) {
    val viewModel = hiltViewModel<InfoJurusanByFakultasViewmodel>()
    val listOfDummyJurusan = listOf(
        DummyAiInfoJurusanRecomendation(
            prodiName = "Teknik Informatika",
            arah = "Saintek",
            tag = "Komputer, Jaringan",
            percent = 75.0
        ),
        DummyAiInfoJurusanRecomendation(
            prodiName = "Teknologi Informasi",
            arah = "Saintek",
            tag = "Komputer, Jaringan",
            percent = 39.0
        ),
        DummyAiInfoJurusanRecomendation(
            prodiName = "Sistem Informasi",
            arah = "Saintek",
            tag = "Komputer, Jaringan",
            percent = 66.0
        ), DummyAiInfoJurusanRecomendation(
            prodiName = "Pendidikan Teknologi Informasi",
            arah = "Saintek",
            tag = "Komputer, Jaringan",
            percent = 72.0
        ), DummyAiInfoJurusanRecomendation(
            prodiName = "Teknik Komputer",
            arah = "Saintek",
            tag = "Komputer, Jaringan",
            percent = 74.0
        )
    )

    Scaffold(
        topBar = {
            AppTopBar(onBackClicked = { navController.popBackStack() }, title = fakultasName)
        }
    ) {
        LazyColumn {
            items(listOfDummyJurusan) {
                JurusanItem(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                    item = it,
                    onClick = {/*TODO*/ }
                )
            }
        }
    }
}