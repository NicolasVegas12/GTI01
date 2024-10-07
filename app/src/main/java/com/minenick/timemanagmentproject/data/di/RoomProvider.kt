package com.minenick.timemanagmentproject.data.di

import android.content.Context
import androidx.room.Room
import com.minenick.timemanagmentproject.data.database.TimeManagementProjectDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomProvider {

    private const val DATABASE_NAME = "time_management_project_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): TimeManagementProjectDatabase {
        return Room.databaseBuilder(
            context,
            TimeManagementProjectDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}