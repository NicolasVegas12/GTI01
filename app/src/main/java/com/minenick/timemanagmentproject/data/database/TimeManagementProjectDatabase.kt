package com.minenick.timemanagmentproject.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.minenick.timemanagmentproject.data.database.entity.EntityTry

@Database(
    entities = [EntityTry::class],
    version = 1
)
abstract class TimeManagementProjectDatabase: RoomDatabase() {
}