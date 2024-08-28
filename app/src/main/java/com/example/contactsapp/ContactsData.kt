package com.example.contactsapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ContactsData(
    @StringRes val name: Int,
    @StringRes val phone: Int,
    @DrawableRes val image: Int,
)
