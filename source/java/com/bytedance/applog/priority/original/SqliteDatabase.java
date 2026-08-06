package com.bytedance.applog.priority.original;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.priority.original.Model;
import com.bytedance.applog.server.Api;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SqliteDatabase.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u0018\u001a\u00020\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001eH\u0016JP\u0010\u001f\u001a*\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\"0!j\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\"`#\u0012\u0004\u0012\u00020$0 2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020&H\u0016J\u001a\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0005H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006-"}, d2 = {"Lcom/bytedance/applog/priority/original/SqliteDatabase;", "Lcom/bytedance/applog/priority/original/DatabaseInterface;", "context", "Landroid/content/Context;", "appId", "", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "(Landroid/content/Context;Ljava/lang/String;Lcom/bytedance/applog/priority/original/Model$PriorityName;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "helper", "Lcom/bytedance/applog/priority/original/SqliteDbHelper;", "getHelper", "()Lcom/bytedance/applog/priority/original/SqliteDbHelper;", "getPriorityName", "()Lcom/bytedance/applog/priority/original/Model$PriorityName;", "clear", "", "count", "", "groupId", "deleteAll", "keys", "", "Lcom/bytedance/applog/priority/original/Model$EventKey;", "destroy", "getAllGroupIds", "", "getBySizeAndCount", "Lkotlin/Pair;", "Ljava/util/HashMap;", "Lorg/json/JSONObject;", "Lkotlin/collections/HashMap;", "", "maxSize", "", "maxCount", "eventTtl", "insert", Api.KEY_ENCRYPT_RESP_KEY, "value", "isEmpty", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SqliteDatabase implements DatabaseInterface {
    private final String appId;
    private final Context context;
    private final SqliteDbHelper helper;
    private final Model.PriorityName priorityName;

    @Override // com.bytedance.applog.priority.original.DatabaseInterface
    public void destroy() {
    }

    public SqliteDatabase(Context context, String str, Model.PriorityName priorityName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(priorityName, "priorityName");
        this.context = context;
        this.appId = str;
        this.priorityName = priorityName;
        this.helper = new SqliteDbHelper(context, "applog_priority_db_" + priorityName.name() + '@' + str, null, 1);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Model.PriorityName getPriorityName() {
        return this.priorityName;
    }

    public final SqliteDbHelper getHelper() {
        return this.helper;
    }

    @Override // com.bytedance.applog.priority.original.DatabaseInterface
    public Model.EventKey insert(Model.EventKey key, String value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        ContentValues contentValues = new ContentValues();
        contentValues.put("group_id", Integer.valueOf(key.getGroupId()));
        contentValues.put("event_type", Integer.valueOf(key.getEventType().getType()));
        contentValues.put("event_stained", Integer.valueOf(key.getEventStained() ? 1 : 0));
        contentValues.put(SqliteDatabaseKt.colMonitorId, key.getMonitorId());
        contentValues.put("timestamp", Long.valueOf(key.getTs() / 1000));
        contentValues.put("event_name", key.getEventName());
        contentValues.put(SqliteDatabaseKt.colEventJson, value);
        long insert = this.helper.getWritableDatabase().insert("event", null, contentValues);
        if (insert < 0) {
            LoggerImpl.global().error("SqliteDatabase: insert event: {} to db failed!", key);
            return null;
        }
        key.setDbId(insert);
        return key;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.applog.priority.original.DatabaseInterface
    public Pair<HashMap<Model.EventKey, JSONObject>, Boolean> getBySizeAndCount(int groupId, long maxSize, int maxCount, long eventTtl) {
        int i;
        boolean z;
        Cursor rawQuery;
        Throwable th;
        int i2;
        JSONObject jSONObject;
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        long currentTimeMillis = (System.currentTimeMillis() - eventTtl) / 1000;
        int i3 = 0;
        try {
            try {
                int i4 = 1;
                rawQuery = this.helper.getWritableDatabase().rawQuery("select id, timestamp, group_id, event_type, event_stained, monitor_id, event_name, event_json from event where group_id = ?", new String[]{String.valueOf(groupId)});
                try {
                    Cursor cursor = rawQuery;
                    long j = 0;
                    int i5 = 0;
                    while (true) {
                        if (!cursor.moveToNext()) {
                            i2 = 0;
                            break;
                        }
                        if (j >= maxSize) {
                            i2 = i4;
                            break;
                        }
                        int i6 = i5 + 1;
                        if (i5 >= maxCount) {
                            i2 = i4;
                            break;
                        }
                        long j2 = cursor.getLong(i3);
                        long j3 = cursor.getLong(i4 == true ? 1 : 0);
                        if (j3 < currentTimeMillis) {
                            try {
                                hashSet.add(Long.valueOf(j2));
                                i5 = i6;
                            } catch (Throwable th2) {
                                th = th2;
                                i = i3;
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    CloseableKt.closeFinally(rawQuery, th);
                                    throw th3;
                                }
                            }
                        } else {
                            int i7 = cursor.getInt(2);
                            Model.EventType eventType = Model.EventType.INSTANCE.getEventType(cursor.getInt(3));
                            boolean z2 = cursor.getInt(4) == i4 ? i4 == true ? 1 : 0 : i3;
                            String string = cursor.getString(5);
                            String string2 = cursor.getString(6);
                            String string3 = cursor.getString(7);
                            HashSet hashSet2 = hashSet;
                            Intrinsics.checkNotNullExpressionValue(string, "monitorId");
                            Intrinsics.checkNotNullExpressionValue(string2, "eventName");
                            Model.EventKey eventKey = new Model.EventKey(j2, i7, j3, eventType, z2, string, string2);
                            try {
                                jSONObject = new JSONObject(string3);
                            } catch (Throwable unused) {
                                jSONObject = new JSONObject();
                            }
                            hashMap.put(eventKey, jSONObject);
                            Intrinsics.checkNotNullExpressionValue(string3, "eventJson");
                            j += CommonKt.getUtf8StringSize(string3);
                            i5 = i6;
                            hashSet = hashSet2;
                            i3 = 0;
                            i4 = 1;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    i = 0;
                }
            } catch (Throwable th5) {
                th = th5;
                LoggerImpl.global().error("SqliteDatabase: clear failed", th, new Object[0]);
                z = i;
                return new Pair<>(hashMap, Boolean.valueOf(z));
            }
        } catch (Throwable th6) {
            th = th6;
            i = 0;
            LoggerImpl.global().error("SqliteDatabase: clear failed", th, new Object[0]);
            z = i;
            return new Pair<>(hashMap, Boolean.valueOf(z));
        }
        try {
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(rawQuery, (Throwable) null);
            z = i2;
            return new Pair<>(hashMap, Boolean.valueOf(z));
        } catch (Throwable th7) {
            th = th7;
            i = i2;
            throw th;
        }
    }

    @Override // com.bytedance.applog.priority.original.DatabaseInterface
    public void deleteAll(Iterable<Model.EventKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            SQLiteStatement compileStatement = writableDatabase.compileStatement("delete from event where id = ?");
            try {
                for (Model.EventKey eventKey : keys) {
                    if (eventKey.getDbId() >= 0) {
                        compileStatement.clearBindings();
                        compileStatement.bindLong(1, eventKey.getDbId());
                        compileStatement.executeUpdateDelete();
                    }
                }
                writableDatabase.setTransactionSuccessful();
                compileStatement.close();
            } catch (Throwable th) {
                compileStatement.close();
                throw th;
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.bytedance.applog.priority.original.DatabaseInterface
    public void clear() {
        try {
            this.helper.getWritableDatabase().execSQL("delete from event where id >= 0");
        } catch (Throwable th) {
            LoggerImpl.global().error("SqliteDatabase: clear failed", th, new Object[0]);
        }
    }

    @Override // com.bytedance.applog.priority.original.DatabaseInterface
    public int count(int groupId) {
        Cursor rawQuery;
        Cursor cursor;
        try {
            rawQuery = this.helper.getWritableDatabase().rawQuery("select count(1) from event where group_id = ?", new String[]{String.valueOf(groupId)});
            try {
                cursor = rawQuery;
            } finally {
            }
        } catch (Throwable th) {
            LoggerImpl.global().error("SqliteDatabase: clear failed", th, new Object[0]);
        }
        if (cursor.moveToFirst()) {
            int i = cursor.getInt(0);
            CloseableKt.closeFinally(rawQuery, (Throwable) null);
            return i;
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(rawQuery, (Throwable) null);
        return 0;
    }

    @Override // com.bytedance.applog.priority.original.DatabaseInterface
    public boolean isEmpty(int groupId) {
        return count(groupId) == 0;
    }

    @Override // com.bytedance.applog.priority.original.DatabaseInterface
    public Set<Integer> getAllGroupIds() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            Cursor rawQuery = this.helper.getWritableDatabase().rawQuery("select distinct(group_id) from event", null);
            try {
                Cursor cursor = rawQuery;
                while (cursor.moveToNext()) {
                    linkedHashSet.add(Integer.valueOf(cursor.getInt(0)));
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(rawQuery, (Throwable) null);
            } finally {
            }
        } catch (Throwable th) {
            LoggerImpl.global().error("SqliteDatabase: get all group ids failed", th, new Object[0]);
        }
        return linkedHashSet;
    }
}
