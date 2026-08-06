package com.bytedance.apm.battery.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.util.log.Logger;

/* loaded from: classes3.dex */
public class DBHelper extends SQLiteOpenHelper {
    public static final String BATTERY_COL_ACCUMULATION = "accumulation";
    public static final String BATTERY_COL_MAIN_PROCESS = "main_process";
    public static final String BATTERY_COL_PROCESS_NAME = "process";
    public static final String BATTERY_COL_SCENE = "scene";
    public static final String BATTERY_COL_SOURCE = "source";
    public static final String BATTERY_COL_STATUS = "status";
    public static final String COL_DELETE = "delete_flag";
    public static final String COL_EXTRA1 = "extra1";
    public static final String COL_EXTRA2 = "extra2";
    public static final String COL_EXTRA3 = "extra3";
    public static final String COL_EXTRA4 = "extra4";
    public static final String COL_FRONT = "front";
    public static final String COL_ID = "_id";
    public static final String COL_SID = "sid";
    public static final String COL_TIME = "timestamp";
    public static final String COL_TYPE = "type";
    public static final String COL_VERSION_ID = "version_id";
    public static final String DB_NAME = "apm_monitor_t1.db";
    public static final int DB_VERSION = 2;
    private static final String SQL_CREATE_BATTERY_TABLE = "CREATE TABLE t_battery ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, front Integer, timestamp Integer, type TEXT, status Integer, scene TEXT, accumulation Integer, source TEXT, delete_flag Integer DEFAULT 0, process TEXT, main_process Integer, sid TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )";
    private static final String TAG = "DBHelper";
    public static final String T_BATTERY = "t_battery";

    public DBHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(SQL_CREATE_BATTERY_TABLE);
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (ApmContext.isDebugMode()) {
            Logger.d("DBHelper", "Updating table from " + i + " to " + i2);
        }
        if (i < 2) {
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS local_monitor_log");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_apiall");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS local_monitor_version");
            } catch (Exception unused) {
            }
        }
    }
}
