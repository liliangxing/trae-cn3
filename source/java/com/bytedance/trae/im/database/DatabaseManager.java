package com.bytedance.trae.im.database;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatabaseManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/im/database/DatabaseManager;", "", "<init>", "()V", "currentUserId", "", "dbHelper", "Lcom/bytedance/trae/im/database/DatabaseOpenHelper;", "getDatabase", "context", "Landroid/content/Context;", "userId", "onUserLogout", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DatabaseManager {
    public static final DatabaseManager INSTANCE = new DatabaseManager();
    private static volatile String currentUserId;
    private static volatile DatabaseOpenHelper dbHelper;

    private DatabaseManager() {
    }

    public final synchronized DatabaseOpenHelper getDatabase(Context context, String userId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userId, "userId");
        DatabaseOpenHelper databaseOpenHelper = dbHelper;
        if (Intrinsics.areEqual(userId, currentUserId) && databaseOpenHelper != null) {
            return databaseOpenHelper;
        }
        DatabaseOpenHelper databaseOpenHelper2 = dbHelper;
        if (databaseOpenHelper2 != null) {
            databaseOpenHelper2.close();
        }
        currentUserId = userId;
        String str = "im_" + userId + DBDefinition.DATABASE_SUBPROCESS_SUFFIX_NAME;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        DatabaseOpenHelper databaseOpenHelper3 = new DatabaseOpenHelper(applicationContext, str, 0, 4, null);
        dbHelper = databaseOpenHelper3;
        return databaseOpenHelper3;
    }

    public final synchronized void onUserLogout() {
        DatabaseOpenHelper databaseOpenHelper = dbHelper;
        if (databaseOpenHelper != null) {
            databaseOpenHelper.close();
        }
        dbHelper = null;
        currentUserId = null;
    }
}
