package com.ss.android.message.log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.helper.EnsureExceptionHelper;
import com.bytedance.push.utils.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DBHelper {
    static final String COL_CATEGORY = "category";
    static final String COL_EXT_JSON = "ext_json";
    static final String COL_EXT_VALUE = "ext_value";
    static final String COL_ID = "_id";
    static final String COL_LABEL = "label";
    static final String COL_TAG = "tag";
    static final String COL_VALUE = "value";
    static final String DB_NAME = "ss_push_log.db";
    static final int DB_VERSION = 1;
    private static final String LOG_TAG = "PushLog";
    static final String TABLE_EVENT = "event";
    private static DBHelper mInstance = null;
    private static final String whereId = "_id = ?";
    private SQLiteDatabase mDb;
    static final String[] EVENT_COLS = {"_id", "category", "tag", "label", "value", "ext_value", "ext_json"};
    private static final Object mLock = new Object();

    public static DBHelper getInstance(Context context) {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new DBHelper(context.getApplicationContext());
            }
        }
        return mInstance;
    }

    public static void closeDB() {
        synchronized (mLock) {
            DBHelper dBHelper = mInstance;
            if (dBHelper != null) {
                dBHelper.closeDatabase();
            }
            mInstance = null;
        }
    }

    protected static void safeCloseCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    protected static void safeCloseCursorAndEndTX(Cursor cursor, SQLiteDatabase sQLiteDatabase) {
        safeCloseCursor(cursor);
        if (sQLiteDatabase != null) {
            try {
                if (sQLiteDatabase.inTransaction()) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception unused) {
            }
        }
    }

    private DBHelper(Context context) {
        try {
            this.mDb = new OpenHelper(context).getWritableDatabase();
        } catch (Throwable th) {
            Logger.e("error when init DatabaseHelper:" + th.getLocalizedMessage());
            EnsureExceptionHelper.ensureNotReachHere(th, "error when init com.ss.android.message.log.DBHelper.DBHelper");
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

    public synchronized long insertEvent(LogEvent logEvent) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("category", logEvent.category);
            contentValues.put("tag", logEvent.tag);
            if (!StringUtils.isEmpty(logEvent.label)) {
                contentValues.put("label", logEvent.label);
            }
            contentValues.put("value", Long.valueOf(logEvent.value));
            contentValues.put("ext_value", Long.valueOf(logEvent.ext_value));
            if (!StringUtils.isEmpty(logEvent.ext_json)) {
                contentValues.put("ext_json", logEvent.ext_json);
            }
            return this.mDb.insert("event", null, contentValues);
        }
        Logger.d(LOG_TAG, "db not establish and open");
        return -1L;
    }

    public synchronized boolean deleteEvent(long j) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.mDb.delete("event", whereId, new String[]{String.valueOf(j)}) > 0;
        }
        Logger.d(LOG_TAG, "db not establish and open");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00fd A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ff A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized JSONArray getEvents(long j, int i) {
        JSONArray jSONArray;
        Cursor cursor;
        int i2;
        int i3;
        String string;
        JSONArray jSONArray2;
        long j2;
        String str = "" + i;
        int i4 = 1;
        int i5 = 0;
        String[] strArr = {String.valueOf(j)};
        JSONArray jSONArray3 = new JSONArray();
        try {
            cursor = this.mDb.query("event", EVENT_COLS, "_id > ? ", strArr, null, null, "_id ASC", str);
            i3 = 0;
            long j3 = 0;
            while (cursor.moveToNext()) {
                try {
                    long j4 = cursor.getLong(i5);
                    String string2 = cursor.getString(i4);
                    String string3 = cursor.getString(2);
                    if (cursor.isNull(3)) {
                        string = null;
                    } else {
                        try {
                            string = cursor.getString(3);
                        } catch (Throwable th) {
                            th = th;
                            i2 = i3;
                            jSONArray = jSONArray3;
                            try {
                                th.printStackTrace();
                                safeCloseCursor(cursor);
                                i3 = i2;
                                if (i3 > 0) {
                                }
                            } finally {
                                safeCloseCursor(cursor);
                            }
                        }
                    }
                    if (cursor.isNull(4)) {
                        jSONArray2 = jSONArray3;
                        j2 = 0;
                    } else {
                        jSONArray2 = jSONArray3;
                        j2 = cursor.getLong(4);
                    }
                    try {
                        long j5 = !cursor.isNull(5) ? cursor.getLong(5) : 0L;
                        String string4 = !cursor.isNull(6) ? cursor.getString(6) : null;
                        if (j3 < j4) {
                            j3 = j4;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("_id", j4);
                        if (!StringUtils.isEmpty(string4)) {
                            jSONObject.put("ext_json", string4);
                        }
                        jSONObject.put("category", string2);
                        jSONObject.put("tag", string3);
                        if (!StringUtils.isEmpty(string)) {
                            jSONObject.put("label", string);
                        }
                        if (j2 != 0) {
                            jSONObject.put("value", j2);
                        }
                        long j6 = j5;
                        if (j6 != 0) {
                            jSONObject.put("ext_value", j6);
                        }
                        jSONArray = jSONArray2;
                        try {
                            jSONArray.put(jSONObject);
                            i3++;
                            jSONArray3 = jSONArray;
                            i4 = 1;
                            i5 = 0;
                        } catch (Throwable th2) {
                            th = th2;
                            i2 = i3;
                            th.printStackTrace();
                            safeCloseCursor(cursor);
                            i3 = i2;
                            if (i3 > 0) {
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        jSONArray = jSONArray2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    jSONArray = jSONArray3;
                }
            }
            jSONArray = jSONArray3;
        } catch (Throwable th5) {
            th = th5;
            jSONArray = jSONArray3;
            cursor = null;
            i2 = 0;
        }
        if (i3 > 0) {
            return jSONArray;
        }
        return null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class OpenHelper extends SQLiteOpenHelper {
        static final String createTableEvent = "CREATE TABLE event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT )";

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public OpenHelper(Context context) {
            super(context, DBHelper.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(createTableEvent);
            } catch (Exception e) {
                Logger.e(DBHelper.LOG_TAG, "create db exception " + e);
            }
        }
    }
}
