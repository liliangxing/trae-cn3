package com.ss.android.common.applog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.util.TLog;
import com.vivo.push.PushClient;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DBHelper {
    static final String COL_APP_VERSION = "app_version";
    static final String COL_CATEGORY = "category";
    static final String COL_DISABLE_PERSONALIZATION = "disable_personalization";
    static final String COL_DURATION = "duration";
    static final String COL_EVENT_DATE = "event_date";
    static final String COL_EVENT_FAIL_CNT = "event_fail_cnt";
    static final String COL_EVENT_NAME = "event_name";
    static final String COL_EXT_JSON = "ext_json";
    static final String COL_EXT_VALUE = "ext_value";
    static final String COL_FAIL_REASON = "event_fail_reason";
    static final String COL_ID = "_id";
    static final String COL_LABEL = "label";
    static final String COL_LOG_TYPE = "log_type";
    static final String COL_NAME = "name";
    static final String COL_RETRY_COUNT = "retry_count";
    static final String COL_SESSION_ID = "session_id";
    static final String COL_TAG = "tag";
    static final String COL_TIMESTAMP = "timestamp";
    static final String COL_UID = "uid";
    static final String COL_USER_ID = "user_id";
    static final String COL_USER_IS_AUTH = "user_is_auth";
    static final String COL_USER_IS_LOGIN = "user_is_login";
    static final String COL_USER_TYPE = "user_type";
    static final String COL_VALUE = "value";
    static final String COL_VERSION_CODE = "version_code";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
    static volatile String DB_NAME = "ss_app_log.db";
    static final int DB_VERSION = 14;
    private static final String LOG_TAG = "AppLog";
    public static int MAX_EVENT_PER_REQUEST = 200;
    static final int MAX_LOG_PER_REQUEST = 100;
    static final int MAX_PAGES = 500;
    static final String TABLE_EVENT = "event";
    static final String TABLE_PAGE = "page";
    private static DBHelper mInstance = null;
    private static final String whereId = "_id = ?";
    private static final String whereSession = "session_id = ?";
    private final Context mContext;
    private SQLiteDatabase mDb;
    final Set<Long> mSendTimelyLaunchSet = new HashSet();
    final Set<Long> mSendTimelySuccessLaunchSet = new HashSet();
    static final String TABLE_SESSION = "session";
    static final String TABLE_MISC_LOG = "misc_log";
    static final String TABLE_SUCC_RATE = "succ_rate";
    static final String TABLE_QUEUE = "queue";
    private static final String[] ALL_TABLE = {"event", "page", TABLE_SESSION, TABLE_MISC_LOG, TABLE_SUCC_RATE, TABLE_QUEUE};
    static final String[] PAGE_COLS = {"_id", "name", "duration", "session_id"};
    static final String COL_IS_CRASH = "is_crash";
    static final String COL_RETRY_TIME = "retry_time";
    static final String[] QUEUE_COLS = {"_id", "value", COL_IS_CRASH, "timestamp", "retry_count", COL_RETRY_TIME, "log_type"};
    static final String COL_NON_PAGE = "non_page";
    static final String COL_PAUSETIME = "pausetime";
    static final String COL_LAUNCH_SENT = "launch_sent";
    static final String COL_EVENT_INDEX = "event_index";
    static final String[] SESSION_COLS = {"_id", "value", "timestamp", "duration", COL_NON_PAGE, "app_version", "version_code", COL_PAUSETIME, COL_LAUNCH_SENT, COL_EVENT_INDEX};
    static final String COL_EVENT_ID = "_event_id";
    static final String[] EVENT_COLS = {"_id", "category", "tag", "label", "value", "ext_value", "ext_json", "user_id", "timestamp", "session_id", COL_EVENT_INDEX, "user_type", "user_is_login", "user_is_auth", "uid", "disable_personalization", COL_EVENT_ID};
    static final String[] MISC_LOG_COLS = {"_id", "log_type", "value", "session_id", COL_EVENT_ID};
    static final String[] MON_LOG_COLS = {"_id", "log_type", "value"};
    private static final Object mLock = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setDBName(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        DB_NAME = str;
    }

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
        }
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

    protected static synchronized void safeCloseCursorAndEndTX(Cursor cursor, SQLiteDatabase sQLiteDatabase) {
        synchronized (DBHelper.class) {
            safeCloseCursor(cursor);
            if (sQLiteDatabase != null) {
                try {
                    if (sQLiteDatabase.inTransaction()) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Throwable th) {
                    TLog.m76e("safeCloseCursorAndEndTX failed: " + th.getMessage(), th);
                    if (th instanceof SQLiteFullException) {
                        try {
                            sQLiteDatabase.execSQL("VACUUM");
                        } catch (Throwable th2) {
                            TLog.m76e("VACUUM failed:" + th.getMessage(), th2);
                        }
                    }
                }
            }
        }
    }

    private DBHelper(Context context) {
        this.mDb = new OpenHelper(context).getWritableDatabase();
        this.mContext = context;
    }

    private synchronized void closeDatabase() {
        try {
            SQLiteDatabase sQLiteDatabase = this.mDb;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                this.mDb.close();
                this.mDb = null;
            }
        } finally {
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
            contentValues.put("user_id", Long.valueOf(logEvent.user_id));
            contentValues.put("timestamp", Long.valueOf(logEvent.timestamp));
            contentValues.put("session_id", Long.valueOf(logEvent.session_id));
            contentValues.put(COL_EVENT_INDEX, Long.valueOf(logEvent.teaEventIndex));
            contentValues.put("user_type", Integer.valueOf(logEvent.user_type));
            contentValues.put("user_is_login", Integer.valueOf(logEvent.user_is_login));
            contentValues.put("user_is_auth", Integer.valueOf(logEvent.user_is_auth));
            contentValues.put("uid", Long.valueOf(logEvent.uid));
            if (logEvent.disable_personalization != null) {
                contentValues.put("disable_personalization", String.valueOf(logEvent.disable_personalization));
            }
            contentValues.put(COL_EVENT_ID, Long.valueOf(logEvent.f36id));
            return this.mDb.insert("event", null, contentValues);
        }
        TLog.m81w("AppLog db not establish and open");
        return -1L;
    }

    public synchronized boolean deleteEvent(long j) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            return this.mDb.delete("event", whereId, new String[]{String.valueOf(j)}) > 0;
        }
        TLog.m81w("AppLog db not establish and open");
        return false;
    }

    public synchronized long insertPage(LogPage logPage, long j) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            TLog.m81w("AppLog db not establish and open");
            return -1L;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_PAUSETIME, Long.valueOf(j));
            this.mDb.update(TABLE_SESSION, contentValues, whereId, new String[]{String.valueOf(logPage.session_id)});
        } catch (Exception e) {
            TLog.m82w("AppLog update session pausetime exception: ", e);
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("name", logPage.name);
            contentValues2.put("duration", Integer.valueOf(logPage.duration));
            contentValues2.put("session_id", Long.valueOf(logPage.session_id));
            return this.mDb.insert("page", null, contentValues2);
        } catch (Exception e2) {
            TLog.m82w("AppLog insert page exception: ", e2);
            return 0L;
        }
    }

    public synchronized long insertSession(LogSession logSession) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            boolean z = logSession.non_page;
            ContentValues contentValues = new ContentValues();
            contentValues.put("value", logSession.value);
            contentValues.put("timestamp", Long.valueOf(logSession.timestamp));
            contentValues.put("duration", Integer.valueOf(logSession.duration));
            contentValues.put(COL_NON_PAGE, Integer.valueOf(z ? 1 : 0));
            contentValues.put("app_version", logSession.app_version);
            contentValues.put("version_code", Integer.valueOf(logSession.version_code));
            contentValues.put(COL_EVENT_INDEX, Long.valueOf(logSession.eventIndex));
            return this.mDb.insert(TABLE_SESSION, null, contentValues);
        }
        TLog.m81w("AppLog db not establish and open");
        return -1L;
    }

    public long insertLog(String str) {
        return insertLog(str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long insertLog(String str, int i) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("value", str);
        contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry_count", (Integer) 0);
        contentValues.put(COL_RETRY_TIME, (Long) 0L);
        contentValues.put("log_type", Integer.valueOf(i));
        return this.mDb.insert(TABLE_QUEUE, null, contentValues);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void updateLogData(long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("value", str);
        this.mDb.update(TABLE_QUEUE, contentValues, whereId, new String[]{String.valueOf(j)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized long insertMiscLog(long j, String str, String str2, long j2) {
        ContentValues contentValues;
        contentValues = new ContentValues();
        contentValues.put("log_type", str);
        contentValues.put("value", str2);
        contentValues.put("session_id", Long.valueOf(j));
        contentValues.put(COL_EVENT_ID, Long.valueOf(j2));
        return this.mDb.insert(TABLE_MISC_LOG, null, contentValues);
    }

    public synchronized boolean onLogSent(long j, boolean z) {
        boolean z2;
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            TLog.m81w("AppLog db not establish and open");
            return false;
        }
        if (j <= 0) {
            return false;
        }
        boolean z3 = true;
        String[] strArr = {String.valueOf(j)};
        if (z) {
            z2 = false;
        } else {
            Cursor cursor = null;
            try {
                try {
                    cursor = this.mDb.query(TABLE_QUEUE, new String[]{"timestamp", "retry_count", COL_RETRY_TIME}, whereId, strArr, null, null, null);
                    if (!cursor.moveToNext()) {
                        return false;
                    }
                    long j2 = cursor.getLong(0);
                    int i = cursor.getInt(1);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - j2 < AppLog.sLogExpireTime && i < AppLog.sLogRetryMaxCount) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("retry_count", Integer.valueOf(i + 1));
                        contentValues.put(COL_RETRY_TIME, Long.valueOf(currentTimeMillis));
                        this.mDb.update(TABLE_QUEUE, contentValues, whereId, strArr);
                        return false;
                    }
                    z2 = true;
                } catch (Exception e) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    TLog.m82w("AppLog onLogSent excepiton: ", e);
                    safeCloseCursor(cursor);
                    z2 = false;
                    z3 = false;
                }
            } finally {
                safeCloseCursor(cursor);
            }
        }
        if (z2 && Logger.debug()) {
            LogDebugUtil.trackLogDiscard(this.mContext, j);
        }
        return z3 ? deleteLog(j) : false;
    }

    private boolean deleteLog(long j) {
        TLog.m73d("delete app_log: " + j);
        String[] strArr = {String.valueOf(j)};
        try {
            int delete = this.mDb.delete(TABLE_QUEUE, whereId, strArr);
            if (delete <= 0) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
            }
            return delete > 0;
        } catch (Throwable th) {
            TLog.m76e("delete app_log: " + j + " failed", th);
            if (th instanceof SQLiteFullException) {
                try {
                    this.mDb.execSQL("VACUUM");
                    TLog.m73d("try delete app_log: " + j + " again after vacuum");
                    return this.mDb.delete(TABLE_QUEUE, whereId, strArr) > 0;
                } catch (Throwable th2) {
                    TLog.m76e("VACUUM failed:" + th.getMessage(), th2);
                    return false;
                }
            }
            return false;
        }
    }

    public synchronized void cleanExpireLog() {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            String str = "timestamp <= ? OR retry_count > " + AppLog.sLogRetryMaxCount;
            String[] strArr = {String.valueOf(System.currentTimeMillis() - AppLog.sLogExpireTime)};
            Cursor cursor = null;
            try {
                cursor = this.mDb.query(TABLE_QUEUE, new String[]{"value"}, str, strArr, null, null, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    try {
                        monitorPackJsonCleanUp(new JSONObject(cursor.getString(0)));
                    } catch (Throwable unused) {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                    }
                }
            } finally {
                try {
                    this.mDb.delete(TABLE_QUEUE, str, strArr);
                    return;
                } finally {
                }
            }
            try {
                this.mDb.delete(TABLE_QUEUE, str, strArr);
            } catch (Exception e) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                TLog.m82w("AppLog delete expire log error:", e);
            }
            return;
        }
        TLog.m81w("AppLog db not establish and open");
    }

    public synchronized boolean existsLogByQuery(long j) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase == null) {
            return false;
        }
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query(TABLE_QUEUE, new String[]{"_id"}, whereId, new String[]{String.valueOf(j)}, null, null, null, PushClient.DEFAULT_REQUEST_ID);
            return cursor.getCount() > 0;
        } catch (Throwable th) {
            try {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                TLog.m82w("AppLog existsLogByQuery exception ", th);
                return false;
            } finally {
                safeCloseCursor(cursor);
            }
        }
    }

    public synchronized LogItem getLog(long j) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase = this.mDb;
        Cursor cursor2 = null;
        LogItem logItem = null;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            TLog.m81w("AppLog db not establish and open");
            return null;
        }
        try {
            cursor = this.mDb.query(TABLE_QUEUE, QUEUE_COLS, "_id > ?", new String[]{String.valueOf(j)}, null, null, "_id ASC", PushClient.DEFAULT_REQUEST_ID);
            try {
                try {
                    if (cursor.moveToNext()) {
                        LogItem logItem2 = new LogItem();
                        logItem2.f37id = cursor.getInt(0);
                        logItem2.value = cursor.getString(1);
                        logItem2.timestamp = cursor.getLong(3);
                        logItem2.retry_count = cursor.getInt(4);
                        logItem2.retry_time = cursor.getLong(5);
                        logItem2.type = cursor.getInt(6);
                        logItem = logItem2;
                    }
                    safeCloseCursor(cursor);
                    return logItem;
                } catch (Exception e) {
                    e = e;
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    TLog.m82w("AppLog getLog exception ", e);
                    safeCloseCursor(cursor);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                safeCloseCursor(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            safeCloseCursor(cursor2);
            throw th;
        }
    }

    public synchronized LogSession getSession(long j) {
        String str;
        String[] strArr;
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase = this.mDb;
        Cursor cursor2 = null;
        LogSession logSession = null;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            TLog.m81w("AppLog db not establish and open");
            return null;
        }
        boolean z = true;
        if (j > 0) {
            try {
                str = "_id < ?";
                strArr = new String[]{String.valueOf(j)};
            } catch (Exception e) {
                e = e;
                cursor = null;
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                TLog.m82w("AppLog getLastSession exception ", e);
                safeCloseCursor(cursor);
                return null;
            } catch (Throwable th) {
                th = th;
                safeCloseCursor(cursor2);
                throw th;
            }
        } else {
            str = null;
            strArr = null;
        }
        cursor = this.mDb.query(TABLE_SESSION, SESSION_COLS, str, strArr, null, null, "_id DESC", PushClient.DEFAULT_REQUEST_ID);
        try {
            try {
                if (cursor.moveToNext()) {
                    LogSession logSession2 = new LogSession();
                    logSession2.f39id = cursor.getInt(0);
                    logSession2.value = cursor.getString(1);
                    logSession2.timestamp = cursor.getLong(2);
                    logSession2.non_page = cursor.getInt(4) > 0;
                    logSession2.app_version = cursor.getString(5);
                    logSession2.version_code = cursor.getInt(6);
                    logSession2.pausetime = cursor.getInt(7);
                    if (cursor.getInt(8) <= 0) {
                        z = false;
                    }
                    logSession2.launch_sent = z;
                    logSession2.eventIndex = cursor.getLong(9);
                    logSession2.active = false;
                    logSession = logSession2;
                }
                safeCloseCursor(cursor);
                return logSession;
            } catch (Exception e2) {
                e = e2;
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                TLog.m82w("AppLog getLastSession exception ", e);
                safeCloseCursor(cursor);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor2 = cursor;
            safeCloseCursor(cursor2);
            throw th;
        }
    }

    public synchronized void setSessionLaunchSent(long j) {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            TLog.m81w("AppLog db not establish and open");
            return;
        }
        try {
            String[] strArr = {String.valueOf(j)};
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_LAUNCH_SENT, (Integer) 1);
            this.mDb.update(TABLE_SESSION, contentValues, "_id=?", strArr);
        } catch (Exception e) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
            TLog.m82w("AppLog setSessionLaunchSent exception: ", e);
        }
    }

    public synchronized long countPackById(long j) {
        try {
        } catch (Throwable th) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
            TLog.m76e("count pack by id " + j + " failed", th);
            return 0L;
        }
        return DatabaseUtils.queryNumEntries(this.mDb, TABLE_QUEUE, whereId, new String[]{String.valueOf(j)});
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    public synchronized long batchSession(com.ss.android.common.applog.LogSession r53, com.ss.android.common.applog.LogSession r54, org.json.JSONObject r55, boolean r56, long[] r57, java.lang.String[] r58, java.util.List<com.ss.android.common.applog.AppLog.ILogSessionHook> r59, boolean r60, org.json.JSONObject r61, boolean r62) {
        /*
            Method dump skipped, instructions count: 2763
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.common.applog.DBHelper.batchSession(com.ss.android.common.applog.LogSession, com.ss.android.common.applog.LogSession, org.json.JSONObject, boolean, long[], java.lang.String[], java.util.List, boolean, org.json.JSONObject, boolean):long");
    }

    private void notifySessionBatchEvent(List<AppLog.ILogSessionHook> list, long j, String str, JSONObject jSONObject) {
        if (list == null) {
            return;
        }
        synchronized (list) {
            Iterator<AppLog.ILogSessionHook> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onLogSessionBatchEvent(j, str, jSONObject);
                } catch (Exception e) {
                    TLog.m82w("AppLog onLogSessionBatchEvent exception: ", e);
                }
            }
        }
    }

    private void notifySessionTerminate(List<AppLog.ILogSessionHook> list, long j, String str, JSONObject jSONObject) {
        if (list == null) {
            return;
        }
        synchronized (list) {
            Iterator<AppLog.ILogSessionHook> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onLogSessionTerminate(j, str, jSONObject);
                } catch (Exception e) {
                    TLog.m82w("AppLog onLogSessionTerminate exception: ", e);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0194 A[Catch: all -> 0x0172, TryCatch #3 {all -> 0x0172, blocks: (B:3:0x002a, B:6:0x004f, B:39:0x0179, B:41:0x0194, B:43:0x019a, B:53:0x01a1), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a7 A[EDGE_INSN: B:55:0x01a7->B:50:0x01a7 BREAK  A[LOOP:0: B:2:0x002a->B:47:0x01ae], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray packMiscLog(boolean z, long j, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        String[] strArr;
        String str2;
        int i;
        String[] strArr2;
        JSONArray jSONArray;
        String[] strArr3;
        String str3;
        int i2;
        Cursor query;
        long j2;
        boolean z2;
        long j3;
        int i3 = 0;
        boolean z3 = true;
        String[] strArr4 = {"0", String.valueOf(j)};
        String str4 = "_id<= ? ";
        String[] strArr5 = {"0"};
        JSONArray jSONArray2 = null;
        Cursor cursor = null;
        long j4 = 0;
        while (true) {
            try {
                try {
                    strArr4[i3] = String.valueOf(j4);
                    jSONArray = new JSONArray();
                    strArr3 = strArr5;
                    str3 = str4;
                    i2 = i3;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    query = this.mDb.query(TABLE_MISC_LOG, MISC_LOG_COLS, "_id > ? AND session_id=?", strArr4, null, null, "_id ASC", "100");
                    try {
                        try {
                            query.getCount();
                            j2 = 0;
                            while (query.moveToNext()) {
                                try {
                                    long j5 = query.getLong(i2);
                                    if (j5 > 0) {
                                        if (j5 > j2) {
                                            j2 = j5;
                                        }
                                        String string = query.getString(1);
                                        String string2 = query.getString(2);
                                        if (query.isNull(3)) {
                                            strArr2 = strArr4;
                                            j3 = 0;
                                        } else {
                                            try {
                                                strArr2 = strArr4;
                                                j3 = query.getLong(3);
                                            } catch (Exception e) {
                                                e = e;
                                                cursor = query;
                                                i = i2;
                                                strArr2 = strArr4;
                                                strArr = strArr3;
                                                str2 = str3;
                                                TLog.m76e("pack misc log", e);
                                                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                                                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                                                if (!(e instanceof SQLiteBlobTooBigException)) {
                                                }
                                                if (AppLog.getAbortPackMiscIfException()) {
                                                }
                                                safeCloseCursor(cursor);
                                                strArr4 = strArr2;
                                                i3 = i;
                                                str4 = str2;
                                                z3 = true;
                                                strArr5 = strArr;
                                            }
                                        }
                                        try {
                                            if (!StringUtils.isEmpty(string2) && !StringUtils.isEmpty(string)) {
                                                try {
                                                    JSONObject jSONObject3 = new JSONObject(string2);
                                                    jSONObject3.put("log_id", j5);
                                                    if (!StringUtils.isEmpty(string)) {
                                                        jSONObject3.put("log_type", string);
                                                    }
                                                    jSONObject3.put(AppLog.KEY_EVENT_ID, j3);
                                                    jSONArray.put(jSONObject3);
                                                } catch (Exception unused) {
                                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                                                }
                                            }
                                            strArr4 = strArr2;
                                            i2 = 0;
                                        } catch (Exception e2) {
                                            e = e2;
                                            cursor = query;
                                            strArr = strArr3;
                                            str2 = str3;
                                            i = 0;
                                            TLog.m76e("pack misc log", e);
                                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                                            if (!(e instanceof SQLiteBlobTooBigException)) {
                                            }
                                            if (AppLog.getAbortPackMiscIfException()) {
                                            }
                                            safeCloseCursor(cursor);
                                            strArr4 = strArr2;
                                            i3 = i;
                                            str4 = str2;
                                            z3 = true;
                                            strArr5 = strArr;
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    strArr2 = strArr4;
                                    cursor = query;
                                    i = i2;
                                    strArr = strArr3;
                                    str2 = str3;
                                    TLog.m76e("pack misc log", e);
                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                                    if (!(e instanceof SQLiteBlobTooBigException) && AppLog.getExtendCursorWindowIfOverflow()) {
                                        if (tryIncreaseCursorWindowSize()) {
                                            safeCloseCursor(cursor);
                                            return jSONArray2;
                                        }
                                        safeCloseCursor(cursor);
                                        strArr4 = strArr2;
                                        i3 = i;
                                        str4 = str2;
                                        z3 = true;
                                        strArr5 = strArr;
                                    } else {
                                        if (AppLog.getAbortPackMiscIfException()) {
                                            safeCloseCursor(cursor);
                                            return jSONArray2;
                                        }
                                        safeCloseCursor(cursor);
                                        strArr4 = strArr2;
                                        i3 = i;
                                        str4 = str2;
                                        z3 = true;
                                        strArr5 = strArr;
                                    }
                                }
                            }
                            strArr2 = strArr4;
                            if (j4 == 0) {
                                jSONArray2 = jSONArray;
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            i = i2;
                            strArr2 = strArr4;
                            strArr = strArr3;
                            str2 = str3;
                            cursor = query;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = query;
                        safeCloseCursor(cursor);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Exception e6) {
                e = e6;
                strArr = strArr5;
                str2 = str4;
                i = i3;
                strArr2 = strArr4;
            }
            if (j4 < j2) {
                try {
                    strArr = strArr3;
                    i = 0;
                    try {
                        strArr[0] = String.valueOf(j2);
                        str2 = str3;
                    } catch (Exception e7) {
                        e = e7;
                        str2 = str3;
                    }
                } catch (Exception e8) {
                    e = e8;
                    strArr = strArr3;
                    str2 = str3;
                    i = 0;
                }
                try {
                    this.mDb.delete(TABLE_MISC_LOG, str2, strArr);
                    if (z2 && jSONArray.length() > 0) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("magic_tag", "ss_app_log");
                        if (jSONObject2 != null) {
                            jSONObject4.put("time_sync", jSONObject2);
                        }
                        jSONObject4.put("log_data", jSONArray);
                        if (jSONObject != null) {
                            jSONObject4.put("header", jSONObject);
                        }
                        jSONObject4.put("_gen_time", System.currentTimeMillis());
                        if (insertLog(jSONObject4.toString()) < 0) {
                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                        }
                    }
                    safeCloseCursor(query);
                    cursor = query;
                    j4 = j2;
                } catch (Exception e9) {
                    e = e9;
                    cursor = query;
                    j4 = j2;
                    TLog.m76e("pack misc log", e);
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                    if (!(e instanceof SQLiteBlobTooBigException)) {
                    }
                    if (AppLog.getAbortPackMiscIfException()) {
                    }
                    safeCloseCursor(cursor);
                    strArr4 = strArr2;
                    i3 = i;
                    str4 = str2;
                    z3 = true;
                    strArr5 = strArr;
                }
                strArr4 = strArr2;
                i3 = i;
                str4 = str2;
                z3 = true;
                strArr5 = strArr;
            } else {
                safeCloseCursor(query);
                break;
            }
        }
        return jSONArray2;
    }

    private boolean tryIncreaseCursorWindowSize() {
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(null);
            if (i <= 0 || i > 8388608) {
                return i > 8388608;
            }
            declaredField.setInt(null, i * 2);
            return false;
        } catch (Throwable th) {
            TLog.m76e("tryIncreaseCursorWindowSize", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void clearAllEvents() {
        SQLiteDatabase sQLiteDatabase = this.mDb;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            for (String str : ALL_TABLE) {
                try {
                    this.mDb.delete(str, null, null);
                } catch (Throwable th) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    TLog.m82w("AppLogdelete table failed, " + str, th);
                }
            }
            return;
        }
        TLog.m81w("AppLogdb not establish and open");
    }

    public void recordPiledUpEventCount() {
        int i;
        int i2;
        Cursor cursor = null;
        try {
            Cursor rawQuery = this.mDb.rawQuery("select count(1) from event", null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst() && (i = rawQuery.getInt(0)) > 0) {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PILED_UP_EVENT_COUNT, i);
                    }
                } catch (Throwable unused) {
                    cursor = rawQuery;
                    try {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
                    } finally {
                        safeCloseCursor(cursor);
                    }
                }
            }
            safeCloseCursor(rawQuery);
            Cursor rawQuery2 = this.mDb.rawQuery("select count(1) from misc_log", null);
            if (rawQuery2 != null && rawQuery2.moveToFirst() && (i2 = rawQuery2.getInt(0)) > 0) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PILED_UP_EVENT_COUNT, i2);
            }
            safeCloseCursor(rawQuery2);
            cursor = this.mDb.query(TABLE_QUEUE, new String[]{"value"}, null, null, null, null, null);
            while (cursor != null) {
                if (!cursor.moveToNext()) {
                    break;
                }
                String string = cursor.getString(0);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        monitorPackJsonPiledUp(new JSONObject(string));
                    } catch (Throwable unused2) {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                    }
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public static void monitorPackJsonCleanUp(JSONObject jSONObject) {
        if (jSONObject == null || !AppLogNewMonitor.getNewMonitor().isEnabled()) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("event_v3");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("event");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("log_data");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("launch");
        JSONArray optJSONArray5 = jSONObject.optJSONArray("terminate");
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CLEAN_UP_LAUNCH_COUNT, optJSONArray4.length());
        }
        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CLEAN_UP_TERMINATE_COUNT, optJSONArray5.length());
        }
        int length = optJSONArray != null ? 0 + optJSONArray.length() : 0;
        if (optJSONArray2 != null) {
            length += optJSONArray2.length();
        }
        if (optJSONArray3 != null) {
            length += optJSONArray3.length();
        }
        if (length > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CLEAN_UP_EVENT_COUNT, length);
        }
    }

    public static void monitorPackJsonPiledUp(JSONObject jSONObject) {
        if (jSONObject == null || !AppLogNewMonitor.getNewMonitor().isEnabled()) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("event_v3");
        JSONArray optJSONArray2 = jSONObject.optJSONArray("event");
        JSONArray optJSONArray3 = jSONObject.optJSONArray("log_data");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("launch");
        JSONArray optJSONArray5 = jSONObject.optJSONArray("terminate");
        if (optJSONArray4 != null && optJSONArray4.length() > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PILED_UP_EVENT_COUNT, optJSONArray4.length());
        }
        if (optJSONArray5 != null && optJSONArray5.length() > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PILED_UP_EVENT_COUNT, optJSONArray5.length());
        }
        int length = optJSONArray != null ? 0 + optJSONArray.length() : 0;
        if (optJSONArray2 != null) {
            length += optJSONArray2.length();
        }
        if (optJSONArray3 != null) {
            length += optJSONArray3.length();
        }
        if (length > 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.PILED_UP_EVENT_COUNT, length);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class OpenHelper extends SQLiteOpenHelper {
        static final String createTableEvent = "CREATE TABLE IF NOT EXISTS event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT, user_id INTEGER, timestamp INTEGER, session_id INTEGER, event_index INTEGER NOT NULL DEFAULT 0, user_type INTEGER NOT NULL DEFAULT 0, user_is_login INTEGER NOT NULL DEFAULT 0, user_is_auth INTEGER NOT NULL DEFAULT 0, uid INTEGER NOT NULL DEFAULT 0, disable_personalization VARCHAR, _event_id INTEGER NOT NULL DEFAULT 0 )";
        static final String createTableMiscLog = "CREATE TABLE IF NOT EXISTS misc_log ( _id INTEGER PRIMARY KEY AUTOINCREMENT, log_type VARCHAR, value TEXT, session_id INTEGER, _event_id INTEGER NOT NULL DEFAULT 0 )";
        static final String createTablePage = "CREATE TABLE IF NOT EXISTS page ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, duration INTEGER, session_id INTEGER )";
        static final String createTableQueue = "CREATE TABLE IF NOT EXISTS queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value TEXT, is_crash INTEGER NOT NULL DEFAULT 0, log_type INTEGER NOT NULL DEFAULT 0, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )";
        static final String createTableSession = "CREATE TABLE IF NOT EXISTS session ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value VARCHAR NOT NULL, timestamp INTEGER, duration INTEGER, non_page INTEGER, app_version VARCHAR, version_code INTEGER, pausetime INTEGER,launch_sent INTEGER NOT NULL DEFAULT 0, event_index INTEGER NOT NULL DEFAULT 0  )";
        static final String createTableSuccRate = "CREATE TABLE IF NOT EXISTS succ_rate ( _id INTEGER PRIMARY KEY AUTOINCREMENT, event_name VARCHAR, event_fail_reason INTEGER, event_fail_cnt INTEGER NOT NULL DEFAULT 0, event_date INTEGER )";

        public OpenHelper(Context context) {
            super(context, DBHelper.DB_NAME, (SQLiteDatabase.CursorFactory) null, 14);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sQLiteDatabase.execSQL(createTableSession);
                sQLiteDatabase.execSQL(createTableEvent);
                sQLiteDatabase.execSQL(createTablePage);
                sQLiteDatabase.execSQL(createTableQueue);
                sQLiteDatabase.execSQL(createTableMiscLog);
                sQLiteDatabase.execSQL(createTableSuccRate);
            } catch (Exception e) {
                TLog.m76e("AppLogcreate db exception ", e);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i < 2) {
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN user_id INTEGER");
            }
            if (i < 3) {
                sQLiteDatabase.execSQL("ALTER TABLE session ADD COLUMN launch_sent INTEGER NOT NULL DEFAULT 0");
            }
            if (i < 4) {
                sQLiteDatabase.execSQL("ALTER TABLE queue ADD COLUMN is_crash INTEGER NOT NULL DEFAULT 0");
            }
            if (i < 5) {
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN ext_json TEXT");
            }
            if (i < 6) {
                sQLiteDatabase.execSQL("ALTER TABLE queue ADD COLUMN log_type INTEGER NOT NULL DEFAULT 0");
            }
            if (i < 7) {
                sQLiteDatabase.execSQL(createTableMiscLog);
            }
            if (i < 8) {
                sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN event_index INTEGER NOT NULL DEFAULT 0");
            }
            if (i < 9) {
                sQLiteDatabase.execSQL("ALTER TABLE session ADD COLUMN event_index INTEGER NOT NULL DEFAULT 0");
            }
            if (i < 10) {
                sQLiteDatabase.execSQL(createTableSuccRate);
            }
            if (i < 12) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN user_type INTEGER NOT NULL DEFAULT 0");
                    sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN user_is_login INTEGER NOT NULL DEFAULT 0");
                    sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN user_is_auth INTEGER NOT NULL DEFAULT 0");
                } catch (Throwable th) {
                    TLog.m76e("alter table add column failed", th);
                }
            }
            if (i < 12) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN uid INTEGER NOT NULL DEFAULT 0");
                } catch (Throwable th2) {
                    TLog.m76e("alter table add column failed", th2);
                }
            }
            if (i < 13) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN disable_personalization VARCHAR");
                } catch (Throwable th3) {
                    TLog.m76e("alter table add column failed", th3);
                }
            }
            if (i < 14) {
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE event ADD COLUMN _event_id INTEGER NOT NULL DEFAULT 0");
                } catch (Throwable th4) {
                    TLog.m76e("alter table add column failed", th4);
                }
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE misc_log ADD COLUMN _event_id INTEGER NOT NULL DEFAULT 0");
                } catch (Throwable th5) {
                    TLog.m76e("alter table add column failed", th5);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            for (String str : DBHelper.ALL_TABLE) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                } catch (Throwable th) {
                    TLog.m76e("drop table failed, " + str, th);
                }
            }
            onCreate(sQLiteDatabase);
        }
    }
}
