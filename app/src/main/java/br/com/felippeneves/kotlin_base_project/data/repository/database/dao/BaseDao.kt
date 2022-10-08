package br.com.felippeneves.kotlin_base_project.data.repository.database.dao

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

interface BaseDao<T> {

    @Insert
    fun insert(vararg rows: T): LongArray?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(vararg rows: T): LongArray?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(rows: List<T>?): List<Long?>?

    @Insert
    fun insert(rows: List<T>?): List<Long?>?

    @Delete
    fun delete(vararg rows: T): Int

    @Update
    fun update(vararg rows: T): Int

    @RawQuery
    fun selectRaw(query: SupportSQLiteQuery): List<T>?

    @RawQuery
    fun selectObjectRaw(query: SupportSQLiteQuery): T

    @RawQuery
    fun countRaw(query: SupportSQLiteQuery): Long
}