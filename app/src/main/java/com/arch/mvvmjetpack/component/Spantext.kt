package com.arch.mvvmjetpack.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val boldRegex = Regex("(?<!\\*)\\*\\*(?!\\*).*?(?<!\\*)\\*\\*(?!\\*)")
val italicRegex = Regex("(?<!\\!)\\!\\!(?!\\!).*?(?<!\\!)\\!\\!(?!\\!)")


@Composable
fun SpanText(text: String, modifier: Modifier = Modifier, spanedcolor: Color, textColor: Color) {

    var boldResults: MatchResult? = boldRegex.find(text)
    var italicResults: MatchResult? = italicRegex.find(text)

    val boldIndexes = mutableListOf<Pair<Int, Int>>()
    val italicIndexes = mutableListOf<Pair<Int, Int>>()

    val keywords = mutableListOf<String>()
    val italickeywords = mutableListOf<String>()

    var finalText = text

    while (boldResults != null) {
        keywords.add(boldResults.value)
        boldResults = boldResults.next()
    }


    keywords.forEach { keyword ->
        val indexOf = finalText.indexOf(keyword)
        val newKeyWord = keyword.removeSurrounding("**")
        finalText = finalText.replace(keyword, newKeyWord)
        boldIndexes.add(Pair(indexOf, indexOf + newKeyWord.length))
    }

    //italic logic

    while (italicResults != null) {
        italickeywords.add(italicResults.value)
        italicResults = italicResults.next()
    }


    italickeywords.forEach { keyword ->
        val indexOf = finalText.indexOf(keyword)
        val newKeyWord = keyword.removeSurrounding("!!")
        finalText = finalText.replace(keyword, newKeyWord)
        italicIndexes.add(Pair(indexOf, indexOf + newKeyWord.length))
    }

    val annotatedString = buildAnnotatedString {
        append(finalText)

        // Add bold style to keywords that has to be bold
        boldIndexes.forEach {
            addStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.Bold,
                    color = spanedcolor,
                    fontSize = 18.sp

                ),
                start = it.first,
                end = it.second
            )

            italicIndexes.forEach {ty->
                addStyle(
                    style = SpanStyle(
                        color = spanedcolor,
                        fontSize = 18.sp,
                        fontStyle = FontStyle.Italic
                    ),
                    start = ty.first,
                    end = ty.second
                )
            }
        }
    }

    Text(
        modifier = modifier,
        fontSize = 16.sp,
        text = annotatedString,
        color = textColor,
        lineHeight = 35.sp
    )
}