package com.ss.alive.monitor.p002db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.push.helper.EnsureExceptionHelper;
import com.bytedance.push.utils.Logger;
import com.vivo.push.PushClient;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class MonitorLiveDBHelperDBHelper {
    static final String COL_ID = "_id";
    static final String DB_NAME = "alive_monitor.db";
    static final int DB_VERSION = 1;
    private static final String LOG_TAG = "MonitorLiveDBHelper";
    static final String TABLE_EVENT = "process_start_info";
    private static final String TAG = "MonitorLiveDBHelper";
    private static MonitorLiveDBHelperDBHelper mInstance;
    private SQLiteDatabase mDb;
    static final String COL_DATA = "data_json";
    static final String COL_END_TIME = "end_time";
    static final String[] EVENT_COLS = {"_id", COL_DATA, COL_END_TIME};
    private static final Object mLock = new Object();

    public static MonitorLiveDBHelperDBHelper getInstance(Context context) {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new MonitorLiveDBHelperDBHelper(context);
            }
        }
        return mInstance;
    }

    public static void closeDB() {
        synchronized (mLock) {
            MonitorLiveDBHelperDBHelper monitorLiveDBHelperDBHelper = mInstance;
            if (monitorLiveDBHelperDBHelper != null) {
                monitorLiveDBHelperDBHelper.closeDatabase();
            }
            mInstance = null;
        }
    }

    private MonitorLiveDBHelperDBHelper(Context context) {
        try {
            this.mDb = new OpenHelper(context).getWritableDatabase();
        } catch (Throwable th) {
            Logger.e("MonitorLiveDBHelper", "error when init com.bytedance.alliance.helper.DatabaseHelper.DatabaseHelper ", th);
            EnsureExceptionHelper.ensureNotReachHere(th, "error when init com.bytedance.alliance.helper.DatabaseHelper.DatabaseHelper");
        }
    }

    private synchronized void closeDatabase() {
        synchronized (this) {
            try {
                SQLiteDatabase sQLiteDatabase = this.mDb;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    this.mDb.close();
                    this.mDb = null;
                }
            } finally {
            }
        }
    }

    public synchronized long insertProcessStartDbInfo(ProcessStartDbInfo processStartDbInfo) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            Logger.d("MonitorLiveDBHelper", "insert = " + processStartDbInfo);
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_DATA, processStartDbInfo.dataJson);
            contentValues.put(COL_END_TIME, Long.valueOf(processStartDbInfo.endTime));
            return this.mDb.insert(TABLE_EVENT, null, contentValues);
        }
        Logger.d("MonitorLiveDBHelper", "db not establish and open");
        return -1L;
    }

    public synchronized ProcessStartDbInfo getLastProcessStartDbInfo() {
        Cursor cursor;
        try {
            cursor = this.mDb.query(TABLE_EVENT, EVENT_COLS, null, null, null, null, "_id DESC", PushClient.DEFAULT_REQUEST_ID);
            try {
                if (cursor.moveToNext()) {
                    ProcessStartDbInfo processStartDbInfo = new ProcessStartDbInfo();
                    processStartDbInfo.f31id = cursor.getLong(0);
                    processStartDbInfo.dataJson = cursor.getString(1);
                    processStartDbInfo.endTime = cursor.getLong(2);
                    return processStartDbInfo;
                }
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    safeCloseCursor(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    public synchronized boolean updateProcessStartDbInfo(ProcessStartDbInfo processStartDbInfo) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            Logger.d("MonitorLiveDBHelper", "db not establish and open");
            return false;
        }
        try {
            if (Logger.debug()) {
                Logger.d("MonitorLiveDBHelper", "updateProcessStartDbInfo processStartDbInfo = " + processStartDbInfo);
            }
            if (processStartDbInfo != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(COL_DATA, processStartDbInfo.dataJson);
                contentValues.put(COL_END_TIME, Long.valueOf(processStartDbInfo.endTime));
                return this.mDb.update(TABLE_EVENT, contentValues, "_id = ?", new String[]{String.valueOf(processStartDbInfo.f31id)}) > 0;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public synchronized boolean deleteProcessStartDbInfo(long j) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.mDb.delete(TABLE_EVENT, "_id = ?", new String[]{String.valueOf(j)}) > 0;
        }
        Logger.d("MonitorLiveDBHelper", "db not establish and open");
        return false;
    }

    public synchronized List<ProcessStartDbInfo> getProcessStartDbInfoList(long j, int i) {
        ArrayList arrayList;
        String str = "" + i;
        String[] strArr = {String.valueOf(j)};
        arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.mDb.query(TABLE_EVENT, EVENT_COLS, "_id > ? ", strArr, null, null, "_id ASC", str);
            while (cursor.moveToNext()) {
                ProcessStartDbInfo processStartDbInfo = new ProcessStartDbInfo();
                processStartDbInfo.f31id = cursor.getLong(0);
                processStartDbInfo.dataJson = cursor.getString(1);
                processStartDbInfo.endTime = cursor.getLong(2);
                arrayList.add(processStartDbInfo);
            }
        } finally {
            try {
                return arrayList;
            } finally {
            }
        }
        return arrayList;
    }

    protected static void safeCloseCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class OpenHelper extends SQLiteOpenHelper {
        static final String createTableEvent = "CREATE TABLE process_start_info ( _id INTEGER PRIMARY KEY AUTOINCREMENT, data_json TEXT, end_time INTEGER )";

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public OpenHelper(Context context) {
            super(context, MonitorLiveDBHelperDBHelper.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(createTableEvent);
            } catch (Throwable th) {
                Logger.e("MonitorLiveDBHelper", "create db exception " + th);
            }
        }
    }
}
