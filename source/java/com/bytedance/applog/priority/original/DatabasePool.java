package com.bytedance.applog.priority.original;

import android.content.Context;
import com.bytedance.applog.priority.original.Model;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Database.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/bytedance/applog/priority/original/DatabasePool;", "", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getDb", "Lcom/bytedance/applog/priority/original/DatabaseInterface;", "priorityName", "Lcom/bytedance/applog/priority/original/Model$PriorityName;", "Companion", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DatabasePool {
    private static final ConcurrentHashMap<Model.PriorityName, DatabaseInterface> DB_POOL = new ConcurrentHashMap<>(6);
    private final String appId;
    private final Context context;

    public DatabasePool(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "appId");
        this.context = context;
        this.appId = str;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DatabaseInterface getDb(Model.PriorityName priorityName) {
        DatabaseInterface putIfAbsent;
        Intrinsics.checkNotNullParameter(priorityName, "priorityName");
        ConcurrentHashMap<Model.PriorityName, DatabaseInterface> concurrentHashMap = DB_POOL;
        SqliteDatabase sqliteDatabase = concurrentHashMap.get(priorityName);
        if (sqliteDatabase == null && (putIfAbsent = concurrentHashMap.putIfAbsent(priorityName, (sqliteDatabase = new SqliteDatabase(this.context, this.appId, priorityName)))) != null) {
            sqliteDatabase = putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(sqliteDatabase, "DB_POOL.getOrPut(priorit…, priorityName)\n        }");
        return sqliteDatabase;
    }
}
