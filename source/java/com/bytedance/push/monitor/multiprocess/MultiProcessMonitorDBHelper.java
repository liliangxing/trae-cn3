package com.bytedance.push.monitor.multiprocess;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.push.helper.BDFileLockHelper;
import com.bytedance.push.utils.Logger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MultiProcessMonitorDBHelper {
    static final String COL_EXTRA = "extra";
    static final String COL_METRIC = "metric";
    static final String DB_NAME = "ss_push_monitor.db";
    static final int DB_VERSION = 1;
    private static final String LOG_TAG = "MultiProcessMonitorDBHelper";
    static final String TABLE_EVENT = "event";
    private static volatile MultiProcessMonitorDBHelper mInstance = null;
    private static final String whereId = "_id = ?";
    private final String MONITOR_LOCK_FILE_NAME = "push_monitor_db.lock";
    private Context mContext;
    private SQLiteDatabase mDb;
    private OpenHelper mOpenHelper;
    static final String COL_ID = "_id";
    static final String COL_SERVICE_NAME = "service_name";
    static final String COL_CATEGORY = "category";
    static final String[] EVENT_COLS = {COL_ID, COL_SERVICE_NAME, COL_CATEGORY, "metric", "extra"};
    private static final Object mLock = new Object();

    public static MultiProcessMonitorDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (mLock) {
                if (mInstance == null) {
                    mInstance = new MultiProcessMonitorDBHelper(context.getApplicationContext());
                }
            }
        }
        return mInstance;
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

    private MultiProcessMonitorDBHelper(Context context) {
        this.mContext = context;
        this.mOpenHelper = new OpenHelper(context);
    }

    private synchronized SQLiteDatabase openDb() {
        if (this.mDb == null) {
            synchronized (this) {
                if (this.mDb == null) {
                    Logger.m268d(LOG_TAG, "lock file for open db");
                    BDFileLockHelper.getInstance("push_monitor_db.lock").lock(this.mContext);
                    try {
                        this.mDb = this.mOpenHelper.getWritableDatabase();
                        Logger.m268d(LOG_TAG, "success lock file and open db");
                    } catch (Throwable th) {
                        Logger.m272e(LOG_TAG, "error when open db", th);
                    }
                }
            }
        }
        return this.mDb;
    }

    public synchronized void closeDB() {
        synchronized (this) {
            try {
                SQLiteDatabase sQLiteDatabase = this.mDb;
                if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                    Logger.m268d(LOG_TAG, "close db and  unlock file");
                    this.mDb.close();
                    this.mDb = null;
                    BDFileLockHelper.getInstance("push_monitor_db.lock").unLock();
                    Logger.m268d(LOG_TAG, "success close db and unlock file");
                }
            } finally {
            }
        }
    }

    public synchronized long insertEvent(MonitorEvent monitorEvent) {
        try {
            SQLiteDatabase openDb = openDb();
            if (openDb != null && openDb.isOpen() && monitorEvent != null) {
                return openDb.insert("event", null, monitorEvent.toContentValues());
            }
            Logger.m278w(LOG_TAG, "[insertEvent] db not establish and open");
            return -1L;
        } catch (Throwable th) {
            try {
                Logger.m272e(LOG_TAG, "[insertEvent] error when insert monitor event to db ", th);
                return -1L;
            } finally {
                closeDB();
            }
        }
    }

    public synchronized boolean deleteEvent(long j) {
        try {
            SQLiteDatabase openDb = openDb();
            if (openDb != null && openDb.isOpen()) {
                return openDb.delete("event", whereId, new String[]{String.valueOf(j)}) > 0;
            }
            Logger.m278w(LOG_TAG, "[deleteEvent] db not establish and open");
            return false;
        } catch (Throwable th) {
            try {
                Logger.m272e(LOG_TAG, "[deleteEvent] error when delete monitor event ", th);
                return false;
            } finally {
                closeDB();
            }
        }
    }

    public synchronized List<MonitorEvent> getEvents(int i) {
        SQLiteDatabase openDb;
        ArrayList arrayList = new ArrayList();
        try {
            openDb = openDb();
        } finally {
            try {
                return arrayList;
            } finally {
            }
        }
        if (openDb != null && openDb.isOpen()) {
            String str = "" + i;
            Cursor cursor = null;
            try {
                cursor = openDb.query("event", EVENT_COLS, null, null, null, null, "_id ASC", str);
                while (cursor.moveToNext()) {
                    arrayList.add(new MonitorEvent(cursor));
                }
            } finally {
                try {
                } finally {
                }
            }
            return arrayList;
        }
        Logger.m278w(LOG_TAG, "[deleteEvent] db not establish and open");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class OpenHelper extends SQLiteOpenHelper {
        static final String createTableEvent = "CREATE TABLE event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, service_name VARCHAR, category VARCHAR, metric VARCHAR, extra VARCHAR )";

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public OpenHelper(Context context) {
            super(context, MultiProcessMonitorDBHelper.DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(createTableEvent);
            } catch (Exception e) {
                Logger.m271e(MultiProcessMonitorDBHelper.LOG_TAG, "create db exception " + e);
            }
        }
    }
}
