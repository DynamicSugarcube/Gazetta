/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseArticle::class], version = 3)
abstract class ArticlesDatabase : RoomDatabase() {

    abstract val dao: ArticlesDao

    companion object {

        private lateinit var INSTANCE: ArticlesDatabase

        fun getDatabaseInstance(context: Context): ArticlesDatabase {
            synchronized(ArticlesDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ArticlesDatabase::class.java,
                        DATABASE_NAME
                    ).fallbackToDestructiveMigration().build()
                }
            }

            return INSTANCE
        }
    }
}