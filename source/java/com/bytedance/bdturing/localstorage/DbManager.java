package com.bytedance.bdturing.localstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.bdturing.LogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DbManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006%"}, d2 = {"Lcom/bytedance/bdturing/localstorage/DbManager;", "", "()V", "KEY_SEAL_EVENT", "", "KEY_SETTINGS", "KEY_TURING_EVENT", "TAG", "instance", "getInstance$annotations", "getInstance", "()Lcom/bytedance/bdturing/localstorage/DbManager;", "mOpenHelper", "Lcom/bytedance/bdturing/localstorage/DbHelper;", "value", "settingsStr", "getSettingsStr", "()Ljava/lang/String;", "setSettingsStr", "(Ljava/lang/String;)V", "closeDB", "", "delete", "", "id", "getDb", "Landroid/database/sqlite/SQLiteDatabase;", "init", "context", "Landroid/content/Context;", "insert", "", "key", "content", "insertOrUpdate", "query", "queryAndDelete", "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DbManager {
    public static final DbManager INSTANCE = new DbManager();
    public static final String KEY_SEAL_EVENT = "seal_event";
    public static final String KEY_SETTINGS = "settings";
    public static final String KEY_TURING_EVENT = "turing_event";
    private static final String TAG = "DbManager";
    private static DbHelper mOpenHelper;

    @JvmStatic
    public static /* synthetic */ void getInstance$annotations() {
    }

    private DbManager() {
    }

    public static final DbManager getInstance() {
        return INSTANCE;
    }

    public final void setSettingsStr(String str) {
        if (str != null) {
            insertOrUpdate("settings", str);
        }
    }

    public final String getSettingsStr() {
        return query("settings");
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (this) {
            mOpenHelper = new DbHelper(context);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final long insert(String key, String content) {
        long longValue;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(content, "content");
        synchronized (this) {
            LogUtil.i(TAG, "insert: " + key);
            LogUtil.d(TAG, "content: " + content);
            SQLiteDatabase db = INSTANCE.getDb();
            Long l = null;
            if (db != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DbHelper.COL_KEY, key);
                    contentValues.put(DbHelper.COL_TIME_STAMP, Long.valueOf(System.currentTimeMillis()));
                    contentValues.put("content", content);
                    Unit unit = Unit.INSTANCE;
                    l = Long.valueOf(db.insert(DbHelper.TABLE_H5_STORAGE, null, contentValues));
                } catch (Exception unused) {
                    LogUtil.e(TAG, "insert fail!");
                }
            }
            longValue = l != null ? l.longValue() : -1L;
        }
        return longValue;
    }

    public final void closeDB() {
        synchronized (this) {
            try {
                DbHelper dbHelper = mOpenHelper;
                if (dbHelper != null) {
                    dbHelper.close();
                }
                mOpenHelper = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final SQLiteDatabase getDb() {
        try {
            DbHelper dbHelper = mOpenHelper;
            if (dbHelper != null) {
                return dbHelper.getWritableDatabase();
            }
            return null;
        } catch (Exception e) {
            LogUtil.printException(e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x008b A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0005, B:25:0x0052, B:16:0x006b, B:19:0x0075, B:10:0x008b, B:23:0x0081), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long insertOrUpdate(String key, String content) {
        Long valueOf;
        long longValue;
        synchronized (this) {
            LogUtil.i(TAG, "insertOrUpdate: " + key);
            LogUtil.d(TAG, "content: " + content);
            ContentValues contentValues = new ContentValues();
            contentValues.put(DbHelper.COL_KEY, key);
            contentValues.put(DbHelper.COL_TIME_STAMP, Long.valueOf(System.currentTimeMillis()));
            contentValues.put("content", content);
            SQLiteDatabase db = INSTANCE.getDb();
            Long l = null;
            if (db != null) {
                try {
                    valueOf = Long.valueOf(db.update(DbHelper.TABLE_H5_STORAGE, contentValues, "primary_key=?", new String[]{key}));
                } catch (Exception unused) {
                    LogUtil.e(TAG, "insertOrUpdate fail!");
                    valueOf = l;
                    if (valueOf != null) {
                    }
                    return longValue;
                }
            } else {
                valueOf = null;
            }
            if (valueOf != null) {
                try {
                } catch (Exception unused2) {
                    l = valueOf;
                    LogUtil.e(TAG, "insertOrUpdate fail!");
                    valueOf = l;
                    if (valueOf != null) {
                    }
                    return longValue;
                }
                if (valueOf.longValue() == 0) {
                    if (db != null) {
                        l = Long.valueOf(db.insert(DbHelper.TABLE_H5_STORAGE, null, contentValues));
                    }
                    valueOf = l;
                }
            }
            longValue = valueOf != null ? valueOf.longValue() : 0L;
        }
        return longValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r13 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
    
        if (r13 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0042 A[Catch: all -> 0x003b, Exception -> 0x004d, TRY_LEAVE, TryCatch #6 {Exception -> 0x004d, all -> 0x003b, blocks: (B:32:0x0034, B:10:0x0042), top: B:31:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String query(String key) {
        Cursor cursor;
        String str;
        synchronized (this) {
            LogUtil.d(TAG, "query");
            SQLiteDatabase db = INSTANCE.getDb();
            boolean z = true;
            Cursor cursor2 = null;
            str = null;
            str = null;
            if (db != null) {
                try {
                    cursor = db.query(DbHelper.TABLE_H5_STORAGE, new String[]{"content"}, "primary_key=?", new String[]{key}, null, null, null, "1");
                } catch (Exception unused) {
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            } else {
                cursor = null;
            }
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        str = z ? cursor.getString(0) : null;
                    }
                } catch (Exception unused3) {
                } catch (Throwable th2) {
                    cursor2 = cursor;
                    th = th2;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
            z = false;
            if (z) {
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004e A[Catch: all -> 0x0043, Exception -> 0x0047, TRY_LEAVE, TryCatch #8 {Exception -> 0x0047, all -> 0x0043, blocks: (B:38:0x003b, B:11:0x004e), top: B:37:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String queryAndDelete(String key) {
        String str;
        Cursor query;
        Object[] objArr;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this) {
            LogUtil.d(TAG, "queryAndDelete");
            DbManager dbManager = INSTANCE;
            SQLiteDatabase db = dbManager.getDb();
            Cursor cursor = null;
            r10 = null;
            String str2 = null;
            Cursor cursor2 = null;
            if (db != null) {
                try {
                    query = db.query(DbHelper.TABLE_H5_STORAGE, new String[]{"id", "content"}, "primary_key=?", new String[]{key}, null, null, null, "1");
                } catch (Exception unused) {
                    str = null;
                    if (cursor2 != null) {
                    }
                    return str;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } else {
                query = null;
            }
            if (query != null) {
                try {
                } catch (Exception unused2) {
                    String str3 = str2;
                    cursor2 = query;
                    str = str3;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
                if (query.moveToFirst()) {
                    objArr = true;
                    if (objArr != false) {
                        str2 = query.getString(1);
                        dbManager.delete(query.getInt(0));
                    }
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Throwable unused5) {
                        }
                    }
                    str = str2;
                }
            }
            objArr = false;
            if (objArr != false) {
            }
            if (query != null) {
            }
            str = str2;
        }
        return str;
    }

    private final int delete(int id) {
        int intValue;
        synchronized (this) {
            LogUtil.i(TAG, "delete: " + id);
            SQLiteDatabase db = INSTANCE.getDb();
            Integer num = null;
            if (db != null) {
                try {
                    num = Integer.valueOf(db.delete(DbHelper.TABLE_H5_STORAGE, "id=?", new String[]{String.valueOf(id)}));
                } catch (Exception unused) {
                    LogUtil.e(TAG, "delete fail!");
                }
            }
            intValue = num != null ? num.intValue() : 0;
        }
        return intValue;
    }
}
