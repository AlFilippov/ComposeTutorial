package com.alfilippov.jetpackcompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import kotlinx.coroutines.NonCancellable.children

class ColumnGuide : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            getColums("Alex", "Filippov")
        }
    }

    @Composable
    fun getColums(name: String, surname: String) {
        val background = +imageResource(R.drawable.ic_background)
        MaterialTheme {
            Column(
                crossAxisSize = LayoutSize.Expand,
                modifier = Spacing(20.dp)
            ) {
                Container(expanded = true, height = 180.dp) {
                    Clip(shape = RoundedCornerShape(20.dp)) {
                        DrawImage(background)
                    }

                }
                WidthSpacer(20.dp)
                HeightSpacer(50.dp)

                Text(
                    name,
                    style = +themeTextStyle { h6 }
                )

                HeightSpacer(5.dp)
                Divider(color = +themeColor { primary })
                Text(
                    surname,
                    style = +themeTextStyle { h4 }
                )
            }
        }
    }
}
