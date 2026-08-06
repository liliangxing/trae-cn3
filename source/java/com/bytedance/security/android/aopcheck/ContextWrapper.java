package com.bytedance.security.android.aopcheck;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContextWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J4\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007¨\u0006 "}, d2 = {"Lcom/bytedance/security/android/aopcheck/ContextWrapper;", "", "()V", "deleteDatabase", "", "context", "Landroid/content/Context;", "name", "", "deleteFile", "deleteSharedPreferences", "getDatabasePath", "Ljava/io/File;", "getDir", "mode", "", "getFileStreamPath", "getSharedPreferences", "Landroid/content/SharedPreferences;", "moveDatabaseFrom", "sourceContext", "moveSharedPreferencesFrom", "openFileInput", "Ljava/io/FileInputStream;", "openFileOutput", "Ljava/io/FileOutputStream;", "openOrCreateDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "errorHandler", "Landroid/database/DatabaseErrorHandler;", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class ContextWrapper {
    public static final ContextWrapper INSTANCE = new ContextWrapper();

    private ContextWrapper() {
    }

    @JvmStatic
    public static final FileInputStream openFileInput(Context context, String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        FileInputStream openFileInput = context.openFileInput(name);
        Intrinsics.checkExpressionValueIsNotNull(openFileInput, "context.openFileInput(name)");
        return openFileInput;
    }

    @JvmStatic
    public static final FileOutputStream openFileOutput(Context context, String name, int mode) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        FileOutputStream openFileOutput = context.openFileOutput(name, mode);
        Intrinsics.checkExpressionValueIsNotNull(openFileOutput, "context.openFileOutput(name, mode)");
        return openFileOutput;
    }

    @JvmStatic
    public static final boolean deleteSharedPreferences(Context context, String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return context.deleteSharedPreferences(name);
    }

    @JvmStatic
    public static final boolean moveSharedPreferencesFrom(Context context, Context sourceContext, String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(sourceContext, "sourceContext");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return context.moveSharedPreferencesFrom(sourceContext, name);
    }

    @JvmStatic
    public static final boolean deleteFile(Context context, String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return context.deleteFile(name);
    }

    @JvmStatic
    public static final File getFileStreamPath(Context context, String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        File fileStreamPath = context.getFileStreamPath(name);
        Intrinsics.checkExpressionValueIsNotNull(fileStreamPath, "context.getFileStreamPath(name)");
        return fileStreamPath;
    }

    @JvmStatic
    public static final SQLiteDatabase openOrCreateDatabase(Context context, String name, int mode, SQLiteDatabase.CursorFactory factory) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase(name, mode, factory);
        Intrinsics.checkExpressionValueIsNotNull(openOrCreateDatabase, "context.openOrCreateDatabase(name, mode, factory)");
        return openOrCreateDatabase;
    }

    @JvmStatic
    public static final SQLiteDatabase openOrCreateDatabase(Context context, String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase(name, mode, factory, errorHandler);
        Intrinsics.checkExpressionValueIsNotNull(openOrCreateDatabase, "context.openOrCreateData…e, factory, errorHandler)");
        return openOrCreateDatabase;
    }

    @JvmStatic
    public static final boolean moveDatabaseFrom(Context context, Context sourceContext, String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(sourceContext, "sourceContext");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return context.moveDatabaseFrom(sourceContext, name);
    }

    @JvmStatic
    public static final boolean deleteDatabase(Context context, String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        return context.deleteDatabase(name);
    }

    @JvmStatic
    public static final File getDatabasePath(Context context, String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        File databasePath = context.getDatabasePath(name);
        Intrinsics.checkExpressionValueIsNotNull(databasePath, "context.getDatabasePath(name)");
        return databasePath;
    }

    @JvmStatic
    public static final File getDir(Context context, String name, int mode) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        File dir = context.getDir(name, mode);
        Intrinsics.checkExpressionValueIsNotNull(dir, "context.getDir(name, mode)");
        return dir;
    }

    @JvmStatic
    public static final SharedPreferences getSharedPreferences(Context context, String name, int mode) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, mode);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPreferences(name, mode)");
        return sharedPreferences;
    }
}
