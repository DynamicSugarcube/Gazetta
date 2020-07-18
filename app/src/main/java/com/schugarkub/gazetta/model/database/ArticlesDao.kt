/*
 * Copyright (c) 2020. Schugarkub
 */

package com.schugarkub.gazetta.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticles(articles: List<DatabaseArticle>)

    @Query("SELECT * FROM $DATABASE_NAME ORDER BY date DESC")
    fun getArticles(): List<DatabaseArticle>

    @Query("DELETE FROM $DATABASE_NAME")
    fun clear()
}