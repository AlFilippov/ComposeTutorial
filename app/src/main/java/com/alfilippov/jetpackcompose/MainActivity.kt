package com.alfilippov.jetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import com.alfilippov.jetpackcompose.compose.drawCard
import com.alfilippov.jetpackcompose.viewmodel.MainViewModel
import kotlinx.coroutines.NonCancellable.children

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel: MainViewModel =
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.fetchData()
        setContent {
            drawCardView(mainViewModel)
        }

    }

    @Composable
    private fun drawCardView(mainViewModel: MainViewModel) {
        MaterialTheme {
            VerticalScroller {
                Column(
                    crossAxisSize = LayoutSize.Expand,
                    crossAxisAlignment = CrossAxisAlignment.Stretch,
                    mainAxisSize = LayoutSize.Expand,
                    mainAxisAlignment = MainAxisAlignment.Start
                ) {
                    HeightSpacer(10.dp)
                    mainViewModel.getData().forEach { model ->
                        Padding(10.dp) {
                            drawCard(model, onInfoClick = { model ->
                                Toast.makeText(
                                    applicationContext,
                                    "${model.sports} sports",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }, onMoreInfoClick = { model ->
                                Toast.makeText(
                                    applicationContext,
                                    "${model.desription} sports",
                                    Toast.LENGTH_SHORT
                                ).show()
                            })
                        }

                    }
                    Padding(15.dp) {
                        Button(onClick = {
                            mainViewModel.fetchMoreData()
                            Toast.makeText(applicationContext, "loadMore", Toast.LENGTH_SHORT)
                                .show()
                        }) {
                            Text("LoadMore")
                        }
                    }
                }


            }

        }
    }


}
