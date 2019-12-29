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
    onInfoClick: ((MainDataModel) -> Unit)? = null,
    onMoreInfoClick: ((MainDataModel) -> Unit)? = null
) {
    Card(shape = RoundedCornerShape(8.dp), elevation = 8.dp) {
            if (model.image > 0) {
                val image = +imageResource(model.image)
                Column(
                    crossAxisSize = LayoutSize.Expand,
                    modifier = Spacing(10.dp)
                ) {
                    Container(expanded = true, height = 140.dp) {
                        Clip(shape = RoundedCornerShape(20.dp)) {
                            DrawImage(image)
                        }

                    }
                    WidthSpacer(10.dp)
                    HeightSpacer(10.dp)

                    Text(
                        model.sports,
                        style = +themeTextStyle { h4 }
                    )
                    HeightSpacer(5.dp)
                    Divider(color = +themeColor { primary })
                    Row(
                        crossAxisAlignment = CrossAxisAlignment.Start,
                        mainAxisAlignment = MainAxisAlignment.Start,
                        mainAxisSize = LayoutSize.Expand

                    ) {
                        Text(
                            model.desription,
                            style = +themeTextStyle { h6 }
                        )
                        WidthSpacer(90.dp)
                        Padding(top = 5.dp) {
                            Row(
                                crossAxisAlignment = CrossAxisAlignment.End,
                                mainAxisAlignment = MainAxisAlignment.End,
                                mainAxisSize = LayoutSize.Wrap
                            ) {
                                Button(

                                    onClick = {
                                        onInfoClick?.invoke(model)
                                    }
                                ) {
                                    Text("info")
                                }
                                WidthSpacer(10.dp)
                                Button(
                                    onClick = {
                                        onMoreInfoClick?.invoke(model)
                                    },
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