package com.bytedance.security.android.aopcheck;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SQLiteDatabaseWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/security/android/aopcheck/SQLiteDatabaseWrapper;", "", "()V", "openDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "path", "", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", RouterConstants.QUERY_KEY_FLAGS, "", "errorHandler", "Landroid/database/DatabaseErrorHandler;", "openOrCreateDatabase", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class SQLiteDatabaseWrapper {
    public static final SQLiteDatabaseWrapper INSTANCE = new SQLiteDatabaseWrapper();

    private SQLiteDatabaseWrapper() {
    }

    @JvmStatic
    public static final SQLiteDatabase openOrCreateDatabase(String path, SQLiteDatabase.CursorFactory factory) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(path, factory);
        Intrinsics.checkExpressionValueIsNotNull(openOrCreateDatabase, "SQLiteDatabase.openOrCreateDatabase(path, factory)");
        return openOrCreateDatabase;
    }

    @JvmStatic
    public static final SQLiteDatabase openOrCreateDatabase(String path, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(path, factory, errorHandler);
        Intrinsics.checkExpressionValueIsNotNull(openOrCreateDatabase, "SQLiteDatabase.openOrCre…h, factory, errorHandler)");
        return openOrCreateDatabase;
    }

    @JvmStatic
    public static final SQLiteDatabase openDatabase(String path, SQLiteDatabase.CursorFactory factory, int flags) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(path, factory, flags);
        Intrinsics.checkExpressionValueIsNotNull(openDatabase, "SQLiteDatabase.openDatabase(path, factory, flags)");
        return openDatabase;
    }

    @JvmStatic
    public static final SQLiteDatabase openDatabase(String path, SQLiteDatabase.CursorFactory factory, int flags, DatabaseErrorHandler errorHandler) {
        Intrinsics.checkParameterIsNotNull(path, "path");
        SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(path, factory, flags, errorHandler);
        Intrinsics.checkExpressionValueIsNotNull(openDatabase, "SQLiteDatabase.openDatab…ory, flags, errorHandler)");
        return openDatabase;
    }
}
