package com.example.contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsAppTheme {
                scaffold()

            }
        }
    }

    @Composable
    fun ContactsList(contacts : List<ContactsData> ,modifier: Modifier = Modifier) {


        LazyVerticalGrid(columns = GridCells.Fixed(3)
            ) {
            items(contacts) {
                ContactListItem(contact = it)

            }

        }
    }

    @Composable
    fun ContactListItem(contact : ContactsData) {
        val context = LocalContext.current
        Card (modifier = Modifier.clickable {
            val phoneNumber = contact.phone
            val num = getString(phoneNumber)
            val uri = Uri.parse("tel:$num")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            context.startActivity(intent)

        },
            shape = RectangleShape){

            Image(painter = painterResource(id = contact.image), contentDescription = "Image of ${contact.name}")
            Text(text = stringResource(contact.name),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 20.sp)
            SelectionContainer {

                Text(
                    text = stringResource(contact.phone),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                )
            }
            
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun scaffold() {
        val context = LocalContext.current
        Scaffold (topBar = {
                TopAppBar(
                    title = { Text(text = "Contacts App", fontSize = 25.sp) },
                    modifier = Modifier,
                    actions = {
                        IconButton(onClick = {
                            val phoneNumber = "+2012345678910"
                            val uri = Uri.parse("tel:$phoneNumber")
                            val intent = Intent(Intent.ACTION_DIAL, uri)
                            context.startActivity(intent)
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_home_24),
                                contentDescription = "Call Home",
                            )

                        }
                    })
            }, bottomBar = {
                BottomAppBar(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_menu_24),
                                contentDescription = "Call Home",
                            )

                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_check_box_outline_blank_24),
                                contentDescription = "Call Home",
                            )

                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                                contentDescription = "Call Home",
                            )

                        }
                    }


                }
            }, modifier = Modifier.fillMaxSize()
        ) {
            innerPadding ->
            Column(modifier = Modifier
                .fillMaxHeight() // TopAppBar height
                .padding(innerPadding)){
                ContactsList(Contact().addContacts(), modifier = Modifier.fillMaxSize())
            }

        }


    }

    @Preview(showSystemUi = true)
    @Composable
    private fun ContactsListPreview() {
        scaffold()
    }
}
