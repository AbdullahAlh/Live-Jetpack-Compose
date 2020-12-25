package com.example.myapplicationcompose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationcompose.ui.MyApplicationComposeTheme

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val book = intent.getSerializableExtra(MainActivity.BOOK_KEY) as Book
        setContent {
            MyApplicationComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    BookDetail(book = book)

                }
            }
        }
    }
}

@Composable
fun BookDetail(
    book: Book
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
    ) {

        val modifier: Modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .aspectRatio(1.0f, false)

        Image(
            imageResource(id = book.image),
            modifier = modifier
        )

        Text(book.name)
        Text(book.author)

    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MyApplicationComposeTheme {
//        BookDetail(Book("Book", "Abdullah", image = R.drawable.book_1))
//
//    }
//}