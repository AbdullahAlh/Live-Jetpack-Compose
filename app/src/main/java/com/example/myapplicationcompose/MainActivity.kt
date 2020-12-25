package com.example.myapplicationcompose

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationcompose.ui.MyApplicationComposeTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    BookList(bookItems = booksList()) {
                        openBookDetail(it)
                    }
                }
            }
        }
    }

    private fun openBookDetail(book: Book) {
        val bookIntent = Intent(this, DetailsActivity::class.java)
            .apply { putExtra(BOOK_KEY, book) }
        startActivity(bookIntent)

    }

    companion object {
        val BOOK_KEY: String = "BOOK_INTENT_KEY"

        fun booksList(): List<Book> {
            return listOf(
                Book("Book 1", "Jessie", R.drawable.book_1),
                Book("Book 2", "Juliana", R.drawable.book_2),
                Book("Book 3", "Emily", R.drawable.book_3),
                Book("Book 1", "Jessie", R.drawable.book_1),
                Book("Book 2", "Juliana", R.drawable.book_2),
                Book("Book 3", "Emily", R.drawable.book_3),
                Book("Book 1", "Jessie", R.drawable.book_1),
                Book("Book 2", "Juliana", R.drawable.book_2),
                Book("Book 3", "Emily", R.drawable.book_3),
                Book("Book 1", "Jessie", R.drawable.book_1),
                Book("Book 2", "Juliana", R.drawable.book_2),
                Book("Book 3", "Emily", R.drawable.book_3),
                Book("Book 1", "Jessie", R.drawable.book_1),
                Book("Book 2", "Juliana", R.drawable.book_2),
                Book("Book 3", "Emily", R.drawable.book_3),
            )
        }
    }
}

@Composable
fun BookList(
    bookItems: List<Book>,
    onSelected: (Book) -> Unit
) {
    LazyColumn(Modifier.fillMaxSize()) {
        items(bookItems) {
            BookItem(it, onSelected)
        }
    }
}

@Composable
fun BookItem(
    book: Book,
    openDetails: (Book) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable(onClick = { openDetails(book) })
    ) {

        val modifier: Modifier = Modifier
            .width(100.dp)
            .padding(4.dp)
            .aspectRatio(1.0f, false)

        Image(
            imageResource(id = book.image),
            modifier = modifier
        )

        Column(modifier = Modifier.padding(4.dp)) {
            Text(book.name)
            Text(book.author)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationComposeTheme {
        BookList(bookItems = MainActivity.booksList()) {

        }

    }
}