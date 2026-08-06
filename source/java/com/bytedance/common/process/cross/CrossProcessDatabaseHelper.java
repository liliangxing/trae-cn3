package com.bytedance.common.process.cross;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.model.MethodCallRecord;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.push.helper.EnsureExceptionHelper;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.util.ToolUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrossProcessDatabaseHelper {
    public static final String COL_ID = "_id";
    static final String DB_NAME_SUFFIX = "cross_process_event.db";
    static final int DB_VERSION = 1;
    static final String TABLE_NAME = "method_call_record";
    private static final String TAG = "DatabaseHelper";
    private static CrossProcessDatabaseHelper sInstance = null;
    private static final String whereId = "_id = ?";
    private SQLiteDatabase mDb;
    private ProcessEnum mProcessEnum;
    public static final String COL_ORIGIN_PROCESS_NAME = "origin_process_name";
    public static final String COL_TARGET_PROCESS_NAME = "target_process_name";
    public static final String COL_METHOD_NAME = "method_name";
    public static final String COL_ARGS = "args";
    static final String[] METHOD_RECORD_COLS = {"_id", COL_ORIGIN_PROCESS_NAME, COL_TARGET_PROCESS_NAME, COL_METHOD_NAME, COL_ARGS};
    private static final Object mLock = new Object();

    public static CrossProcessDatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (mLock) {
                if (sInstance == null) {
                    sInstance = new CrossProcessDatabaseHelper(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private CrossProcessDatabaseHelper(Context context) {
        ProcessEnum curProcess = ToolUtils.getCurProcess(context);
        this.mProcessEnum = curProcess;
        if (curProcess == ProcessEnum.UNKNOWN) {
            return;
        }
        try {
            this.mDb = new OpenHelper(context, getDbName()).getWritableDatabase();
        } catch (Throwable th) {
            Logger.e(TAG, "error when open database:" + th.getMessage());
            EnsureExceptionHelper.ensureNotReachHere(th, "error when init com.bytedance.common.process.cross.CrossProcessDatabaseHelper.CrossProcessDatabaseHelper");
        }
    }

    public synchronized long insertMethodRecord(MethodCallRecord methodCallRecord) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Long.valueOf(ToolUtils.currentTimeMillis()));
            contentValues.put(COL_ORIGIN_PROCESS_NAME, methodCallRecord.getOriginProcessSuffix());
            contentValues.put(COL_TARGET_PROCESS_NAME, methodCallRecord.getTargetProcessSuffix());
            contentValues.put(COL_METHOD_NAME, methodCallRecord.getMethodName());
            contentValues.put(COL_ARGS, methodCallRecord.getArgs());
            return this.mDb.insert(TABLE_NAME, null, contentValues);
        }
        com.bytedance.common.utility.Logger.m205w(TAG, "db not establish and open");
        return -1L;
    }

    public synchronized boolean deleteRecord(String str) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                return this.mDb.delete(TABLE_NAME, whereId, new String[]{str}) > 0;
            } catch (Throwable unused) {
                return true;
            }
        }
        com.bytedance.common.utility.Logger.m205w(TAG, "db not establish and open");
        return false;
    }

    public synchronized List<MethodCallRecord> getNextBatchRecords(ProcessEnum processEnum, ProcessEnum processEnum2) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.mDb;
        Cursor cursor = null;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            com.bytedance.common.utility.Logger.m205w(TAG, "db not establish and open");
            return null;
        }
        try {
            cursor = this.mDb.query(TABLE_NAME, METHOD_RECORD_COLS, "origin_process_name=? AND target_process_name=?", new String[]{processEnum.processSuffix, processEnum2.processSuffix}, null, null, null, "10");
            while (cursor.moveToNext()) {
                arrayList.add(new MethodCallRecord(cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(0)));
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
            } catch (Exception unused) {
            }
        }
    }

    private String getDbName() {
        return this.mProcessEnum.processSuffix.substring(1) + "_cross_process_event.db";
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class OpenHelper extends SQLiteOpenHelper {
        static final String createTableEvent = "CREATE TABLE method_call_record ( _id TEXT PRIMARY KEY, origin_process_name TEXT, target_process_name TEXT, method_name TEXT, args TEXT )";

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public OpenHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(createTableEvent);
            } catch (Throwable th) {
                com.bytedance.common.utility.Logger.m193e(CrossProcessDatabaseHelper.TAG, "create db exception " + th);
            }
        }
    }
}
