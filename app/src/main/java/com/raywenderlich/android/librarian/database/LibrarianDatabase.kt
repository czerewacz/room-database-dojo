package com.raywenderlich.android.librarian.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raywenderlich.android.librarian.model.Book

const val DATABASE_VERSION = 1

@Database (
    entities = [Book::class],
    version = DATABASE_VERSION
)

abstract class LibrarianDatabase:RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "Librarian"

        fun buildDatabase(context: Context): LibrarianDatabase {
            return Room.databaseBuilder(
                    context,
                    LibrarianDatabase::class.java,
                    DATABASE_NAME
            )
                    .allowMainThreadQueries()
                    .build()
        }
    }
}