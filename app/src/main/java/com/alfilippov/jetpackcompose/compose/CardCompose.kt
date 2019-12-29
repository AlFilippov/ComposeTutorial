package com.alfilippov.jetpackcompose.compose

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.material.surface.Card
import androidx.ui.res.imageResource
import com.alfilippov.jetpackcompose.R
import com.alfilippov.jetpackcompose.data.MainDataModel

@Composable
fun drawCard(
    model: MainDataModel,
    onInfoClick: (() -> Unit)? = null,
    onShareClick: (() -> Unit)? = null
) {
    val background = +imageResource(R.drawable.ic_background)
    Card(shape = RoundedCornerShape(8.dp), elevation = 8.dp) {
        MaterialTheme {
            Column(
                crossAxisSize = LayoutSize.Expand,
                modifier = Spacing(10.dp)
            ) {
                Container(expanded = true, height = 140.dp) {
                    Clip(shape = RoundedCornerShape(20.dp)) {
                        DrawImage(background)
                    }

                }
                WidthSpacer(10.dp)
                HeightSpacer(10.dp)

                Text(
                    model.sports,
                    style = +themeTextStyle { h6 }
                )

                HeightSpacer(5.dp)
                Divider(color = +themeColor { primary })


                Row(
                    crossAxisAlignment = CrossAxisAlignment.Start,
                    mainAxisAlignment = MainAxisAlignment.Start,
                    mainAxisSize = LayoutSize.Expand

                ) {
                    Text(
                        model.sports,
                        style = +themeTextStyle { h4 }
                    )
                    WidthSpacer(50.dp)
                    Padding(top = 5.dp) {
                        Row(
                            crossAxisAlignment = CrossAxisAlignment.End,
                            mainAxisAlignment = MainAxisAlignment.End,
                            mainAxisSize = LayoutSize.Wrap
                        ) {
                            Button(

                                onClick = onInfoClick
                            ) {
                                Text("info")
                            }
                            WidthSpacer(10.dp)
                            Button(
                                onClick = onShareClick,
                                style = TextButtonStyle()
                            ) {
                                Text("more")
                            }
                        }
                    }
                }


            }

        }
    }
}