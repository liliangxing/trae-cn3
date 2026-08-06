package com.bytedance.push.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.memory.dump.DumpFileController;
import com.bytedance.push.PushNotificationMessage;
import com.bytedance.push.utils.Logger;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MultiProcessPushMessageDatabaseHelper {
    public static final String COL_FROM = "sender";
    public static final String COL_PUSH_BODY = "push_body";
    static final String DB_NAME = "push_message.db";
    static final int DB_VERSION = 1;

    /* renamed from: NO */
    public static final int f87NO = 0;
    static final String TABLE_NAME = "message";
    private static final String TAG = "MultiProcessPushMessageDatabaseHelper";
    public static final int YES = 1;
    private static final String deleteEarliest = "delete from message where message_id in(select message_id from message where has_been_shown=0 limit 1)";
    private static MultiProcessPushMessageDatabaseHelper sInstance = null;
    private static final String whereArriveTimeEarlierAndHasBeenShown = "arrive_time <= ? and has_been_shown=1";
    private static final String whereMsgId = "message_id = ?";
    private static final String whereNotHasBeenShown = "has_been_shown = 0";
    private final String PUSH_LOCK_FILE_NAME = "push_message_db.lock";
    private Context mContext;
    private SQLiteDatabase mDb;
    private OpenHelper mOpenHelper;
    public static final String COL_MESSAGE_ID = "message_id";
    public static final String COL_ARRIVE_TIME = "arrive_time";
    public static final String COL_CLIENT_INTELLIGENCE_EXPIRE_TIME = "client_intelligence_expire_time";
    public static final String COL_HANDLE_BY_SDK = "handle_by_sdk";
    public static final String HAS_BEEN_SHOWN = "has_been_shown";
    static final String[] MESSAGE_COLS = {COL_MESSAGE_ID, COL_ARRIVE_TIME, COL_CLIENT_INTELLIGENCE_EXPIRE_TIME, "sender", COL_HANDLE_BY_SDK, HAS_BEEN_SHOWN, "push_body"};

    public static MultiProcessPushMessageDatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (MultiProcessPushMessageDatabaseHelper.class) {
                if (sInstance == null) {
                    sInstance = new MultiProcessPushMessageDatabaseHelper(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }

    private MultiProcessPushMessageDatabaseHelper(Context context) {
        try {
            this.mContext = context;
            this.mOpenHelper = new OpenHelper(context, DB_NAME);
        } catch (Throwable th) {
            Logger.m270e("error when init DatabaseHelper:" + th.getLocalizedMessage());
            EnsureExceptionHelper.ensureNotReachHere(th, "error when init com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper.MultiProcessPushMessageDatabaseHelper");
        }
    }

    private SQLiteDatabase openDb() {
        if (this.mDb == null) {
            synchronized (this) {
                if (this.mDb == null) {
                    Logger.m268d(TAG, "lock file for open db");
                    BDFileLockHelper.getInstance("push_message_db.lock").lock(this.mContext);
                    try {
                        this.mDb = this.mOpenHelper.getWritableDatabase();
                        Logger.m268d(TAG, "success lock file and open db");
                    } catch (Throwable th) {
                        Logger.m272e(TAG, "error when open db", th);
                    }
                }
            }
        }
        return this.mDb;
    }

    private void closeDB() {
        try {
            SQLiteDatabase sQLiteDatabase = this.mDb;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                return;
            }
            Logger.m268d(TAG, "close db and  unlock file");
            this.mDb.close();
            this.mDb = null;
            BDFileLockHelper.getInstance("push_message_db.lock").unLock();
            Logger.m268d(TAG, "success close db and unlock file");
        } catch (Throwable th) {
            Logger.m271e(TAG, "error when close db: " + th);
        }
    }

    protected void safeCloseCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized long addMessageToDb(PushNotificationMessage pushNotificationMessage) {
        Logger.m268d(TAG, "[addMessageToDb]");
        if (!PushSetting.getInstance().allowCacheMessageToDb()) {
            Logger.m268d(TAG, "[addMessageToDb] do nothing because allowCacheMessageToDb is false");
            return -1L;
        }
        SQLiteDatabase openDb = openDb();
        Logger.m268d(TAG, "[addMessageToDb] success open db");
        if (openDb != null) {
            try {
                if (openDb.isOpen() && pushNotificationMessage != null) {
                    ContentValues contentValues = pushNotificationMessage.toContentValues();
                    Cursor rawQuery = openDb.rawQuery("select count(*) from message", null);
                    rawQuery.moveToFirst();
                    long j = rawQuery.getLong(0);
                    safeCloseCursor(rawQuery);
                    Logger.m268d(TAG, "[addMessageToDb] curMessageCount is " + j);
                    if (j >= PushSetting.getInstance().getPushOnLineSettings().getUnDuplicateMessageSettings().maxCacheMessage) {
                        Logger.m268d(TAG, "[addMessageToDb] curMessageCount > maxCacheMessage, delete the earliest message");
                        openDb.execSQL(deleteEarliest);
                    }
                    Logger.m268d(TAG, "[addMessageToDb] insert cur message to db");
                    return openDb.insert("message", null, contentValues);
                }
            } finally {
                Logger.m268d(TAG, "[addMessageToDb] finish message insert, close db");
                closeDB();
            }
        }
        Logger.m278w(TAG, "[addMessageToDb] db not establish and open");
        return -1L;
    }

    public synchronized boolean deleteExpiredMsg(long j) {
        if (!PushSetting.getInstance().allowCacheMessageToDb()) {
            Logger.m268d(TAG, "[deleteExpiredMsg] do nothing because allowCacheMessageToDb is false");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - (DumpFileController.HOUR * j);
        Logger.m268d(TAG, "[deleteExpiredMsg] lastTimeStamp is " + currentTimeMillis + " maxCacheTimeInHour is " + j);
        SQLiteDatabase openDb = openDb();
        Logger.m268d(TAG, "[deleteExpiredMsg] success open db");
        if (openDb != null) {
            try {
                if (openDb.isOpen()) {
                    return openDb.delete("message", whereArriveTimeEarlierAndHasBeenShown, new String[]{String.valueOf(currentTimeMillis)}) > 0;
                }
            } catch (Throwable th) {
                try {
                    Logger.m272e(TAG, "[deleteExpiredMsg] error ", th);
                    return false;
                } finally {
                    Logger.m268d(TAG, "[deleteExpiredMsg] finish message delete, close db");
                    closeDB();
                }
            }
        }
        Logger.m278w(TAG, "db not establish and open");
        return false;
    }

    public synchronized boolean curMessageHasExists(long j) {
        boolean z = false;
        if (!PushSetting.getInstance().allowCacheMessageToDb()) {
            Logger.m268d(TAG, "[curMessageHasExists] do nothing because allowCacheMessageToDb is false");
            return false;
        }
        Logger.m268d(TAG, "[curMessageHasExists] messageId is " + j);
        SQLiteDatabase openDb = openDb();
        Logger.m268d(TAG, "[curMessageHasExists] success open db");
        if (openDb != null) {
            try {
                if (openDb.isOpen()) {
                    Cursor cursor = null;
                    try {
                        cursor = openDb.query("message", MESSAGE_COLS, whereMsgId, new String[]{String.valueOf(j)}, null, null, null, null);
                        if (cursor.getCount() >= 1) {
                            z = true;
                        }
                    } finally {
                        try {
                            return z;
                        } finally {
                        }
                    }
                    return z;
                }
            } finally {
                Logger.m268d(TAG, "[curMessageHasExists] finish query, close db");
                closeDB();
            }
        }
        Logger.m278w(TAG, "db not establish and open");
        return false;
    }

    public synchronized long markMessageAsShown(long j) {
        String str;
        String str2;
        if (!PushSetting.getInstance().allowCacheMessageToDb()) {
            Logger.m268d(TAG, "[markMessageAsShown] do nothing because allowCacheMessageToDb is false");
            return 0L;
        }
        Logger.m268d(TAG, "[markMessageAsShown] messageId is " + j);
        SQLiteDatabase openDb = openDb();
        if (openDb != null) {
            try {
                if (openDb.isOpen()) {
                    new ContentValues().put(HAS_BEEN_SHOWN, (Integer) 1);
                    String[] strArr = {String.valueOf(j)};
                    try {
                        return openDb.update("message", r3, whereMsgId, strArr);
                    } catch (IllegalStateException unused) {
                        SQLiteDatabase openDb2 = openDb();
                        if (openDb2 != null && openDb2.isOpen()) {
                            return openDb2.update("message", r3, whereMsgId, strArr);
                        }
                        closeDB();
                        str = TAG;
                        str2 = "[markMessageAsShown] finish update,close db";
                        Logger.m268d(str, str2);
                        return -1L;
                    }
                }
            } catch (Throwable th) {
                try {
                    Logger.m272e(TAG, "[markMessageAsShown] error to update ", th);
                    closeDB();
                    str = TAG;
                    str2 = "[markMessageAsShown] finish update,close db";
                    Logger.m268d(str, str2);
                    return -1L;
                } finally {
                    closeDB();
                    Logger.m268d(TAG, "[markMessageAsShown] finish update,close db");
                }
            }
        }
        Logger.m278w(TAG, "db not establish and open");
        return -1L;
    }

    public synchronized List<PushNotificationMessage> getAllMessageNotShown() {
        Logger.m268d(TAG, "[getAllMessageNotShown]");
        if (!PushSetting.getInstance().allowCacheMessageToDb()) {
            Logger.m268d(TAG, "[getAllMessageNotShown] do nothing because allowCacheMessageToDb is false");
            return new ArrayList();
        }
        SQLiteDatabase openDb = openDb();
        if (openDb != null) {
            try {
                if (openDb.isOpen()) {
                    ArrayList arrayList = new ArrayList();
                    Cursor cursor = null;
                    try {
                        cursor = openDb.query("message", MESSAGE_COLS, whereNotHasBeenShown, null, null, null, "arrive_time ASC", null);
                        while (cursor.moveToNext()) {
                            PushNotificationMessage pushNotificationMessage = new PushNotificationMessage(cursor);
                            if (pushNotificationMessage.getPushBody() != null) {
                                arrayList.add(pushNotificationMessage);
                            }
                        }
                    } finally {
                        try {
                            Logger.m268d(TAG, "[getAllMessageNotShown] finish query,dbPushBodyArrayList size is " + arrayList.size());
                            return arrayList;
                        } finally {
                        }
                    }
                    Logger.m268d(TAG, "[getAllMessageNotShown] finish query,dbPushBodyArrayList size is " + arrayList.size());
                    return arrayList;
                }
            } finally {
                closeDB();
                Logger.m268d(TAG, "[getAllMessageNotShown] finish query,close db");
            }
        }
        Logger.m278w(TAG, "[addMessageToDb] db not establish and open");
        return new ArrayList();
    }

    public PushNotificationMessage getPushNotificationMessage(long j) {
        PushNotificationMessage pushNotificationMessage;
        Logger.m268d(TAG, "[getPushNotificationMessage]");
        Cursor cursor = null;
        PushNotificationMessage pushNotificationMessage2 = null;
        if (!PushSetting.getInstance().allowCacheMessageToDb()) {
            Logger.m268d(TAG, "[getPushNotificationMessage] do nothing because allowCacheMessageToDb is false");
            return null;
        }
        SQLiteDatabase openDb = openDb();
        if (openDb != null) {
            try {
                if (openDb.isOpen()) {
                    try {
                        try {
                            Cursor query = openDb.query("message", MESSAGE_COLS, whereMsgId, new String[]{String.valueOf(j)}, null, null, null, null);
                            try {
                                if (query.moveToNext()) {
                                    pushNotificationMessage = new PushNotificationMessage(query);
                                    try {
                                        if (pushNotificationMessage.getPushBody() == null) {
                                            safeCloseCursor(query);
                                            closeDB();
                                            Logger.m268d(TAG, "[getPushNotificationMessage] finish query,close db");
                                            return null;
                                        }
                                        pushNotificationMessage2 = pushNotificationMessage;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = query;
                                        try {
                                            th.printStackTrace();
                                            safeCloseCursor(cursor);
                                            pushNotificationMessage2 = pushNotificationMessage;
                                            closeDB();
                                            Logger.m268d(TAG, "[getPushNotificationMessage] finish query,close db");
                                            return pushNotificationMessage2;
                                        } catch (Throwable th2) {
                                            safeCloseCursor(cursor);
                                            throw th2;
                                        }
                                    }
                                }
                                safeCloseCursor(query);
                            } catch (Throwable th3) {
                                th = th3;
                                pushNotificationMessage = null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            pushNotificationMessage = null;
                        }
                        closeDB();
                        Logger.m268d(TAG, "[getPushNotificationMessage] finish query,close db");
                        return pushNotificationMessage2;
                    } finally {
                        Logger.m268d(TAG, "[getPushNotificationMessage] finish query, close db");
                        closeDB();
                    }
                }
            } catch (Throwable th5) {
                closeDB();
                Logger.m268d(TAG, "[getPushNotificationMessage] finish query,close db");
                throw th5;
            }
        }
        Logger.m278w(TAG, "[getPushNotificationMessage] db not establish and open");
        closeDB();
        Logger.m268d(TAG, "[getPushNotificationMessage] finish query,close db");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class OpenHelper extends SQLiteOpenHelper {
        static final String createTableEvent = "CREATE TABLE message ( message_id BIGINT PRIMARY KEY, arrive_time BIGINT, client_intelligence_expire_time BIGINT, sender INT,handle_by_sdk INT,has_been_shown INT,push_body TEXT )";

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
                Logger.m271e(MultiProcessPushMessageDatabaseHelper.TAG, "create db exception " + th);
            }
        }
    }
}
