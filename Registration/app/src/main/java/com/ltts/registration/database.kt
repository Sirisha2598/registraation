package com.ltts.registration

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DB {

    private val dbN = "userdb"
    private val dbTab = "userinfo"
    private val colId = "Id"
    private val colName = "Name"
    private val colpassword = "password"
    private val colemail = "email"
    private val colphone ="Phonenumber"
    private val dbVersion = 1

    private val CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS " +
            dbTab + " (" + colId + " " + "INTEGER PRIMARY KEY," + colName + " TEXT, " +
            colpassword + " TEXT, " + colemail + " TEXT,"+colphone + " TEXT,);"
    private var db: SQLiteDatabase? = null

    constructor(context: Context) {
        var dbHelper = DatabaseHelper(context)
        db = dbHelper.writableDatabase
    }

    fun addusers(): Cursor {
        return db!!.rawQuery("select * from " + dbTab, null)
    }

    fun insert(values: ContentValues): Long {
        val ID = db!!.insert(dbTab, "", values)
        return ID
    }

    fun update(values: ContentValues, selection: String, selectionArgs: Array<String>): Int {
        val count = db!!.update(dbTab, values, selection, selectionArgs)
        return count
    }

    fun delete(selection: String, selectionArgs: Array<String>): Int {
        val count = db!!.delete(dbTab, selection, selectionArgs)
        return count
    }

    inner class DatabaseHelper : SQLiteOpenHelper {

        var context: Context? = null

        constructor(context: Context) : super(context, dbN, null, dbVersion) {
            this.context = context
        }

        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL(CREATE_TABLE_SQL)
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db!!.execSQL("Drop table IF EXISTS " + dbTab)
        }


    }
}


