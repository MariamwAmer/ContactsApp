package com.example.contactsapp



class Contact{

    fun addContacts(): List<ContactsData> {
        val contacts = mutableListOf<ContactsData>()

        contacts.add(ContactsData(R.string.auntie, R.string.auntie_num, R.drawable.auntie))
        contacts.add(ContactsData(R.string.brother, R.string.brother_num, R.drawable.brother))
        contacts.add(ContactsData(R.string.daughter, R.string.daughter_num, R.drawable.daughter))
        contacts.add(ContactsData(R.string.friend1, R.string.friend1_num, R.drawable.friend_1))
        contacts.add(ContactsData(R.string.friend2, R.string.friend2_num, R.drawable.friend_2))
        contacts.add(ContactsData(R.string.grandfather, R.string.grandfather_num, R.drawable.grandfather))
        contacts.add(ContactsData(R.string.granny, R.string.granny_num, R.drawable.granny))
        contacts.add(ContactsData(R.string.neighbour, R.string.neighbour_num, R.drawable.neigbour))
        contacts.add(ContactsData(R.string.sister, R.string.sister_num, R.drawable.sister))
        contacts.add(ContactsData(R.string.son, R.string.son_num, R.drawable.son))
        contacts.add(ContactsData(R.string.uncle, R.string.uncle_num, R.drawable.uncle))

        return contacts


    }


}