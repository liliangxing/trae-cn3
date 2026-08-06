package com.bytedance.security.android.aopcheck;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentProviderWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J9\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0007J.\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\"\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J,\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J,\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J,\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0007J6\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007JC\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\b\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010$JU\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010&J_\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010'J,\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007JC\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nH\u0007¢\u0006\u0002\u0010)¨\u0006*"}, d2 = {"Lcom/bytedance/security/android/aopcheck/ContentProviderWrapper;", "", "()V", "bulkInsert", "", "cp", "Landroid/content/ContentProvider;", "uri", "Landroid/net/Uri;", "values", "", "Landroid/content/ContentValues;", "(Landroid/content/ContentProvider;Landroid/net/Uri;[Landroid/content/ContentValues;)I", "delete", "extras", "Landroid/os/Bundle;", "selection", "", "selectionArgs", "(Landroid/content/ContentProvider;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "insert", "openAssetFile", "Landroid/content/res/AssetFileDescriptor;", "mode", IAllianceService.LAUNCH_FROM_SIGNAL, "Landroid/os/CancellationSignal;", "openFile", "Landroid/os/ParcelFileDescriptor;", "openTypedAssetFile", "mimeTypeFilter", "opts", "query", "Landroid/database/Cursor;", "projection", "queryArgs", "cancellationSignal", "(Landroid/content/ContentProvider;Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "sortOrder", "(Landroid/content/ContentProvider;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "(Landroid/content/ContentProvider;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "update", "(Landroid/content/ContentProvider;Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class ContentProviderWrapper {
    public static final ContentProviderWrapper INSTANCE = new ContentProviderWrapper();

    private ContentProviderWrapper() {
    }

    @JvmStatic
    public static final Cursor query(ContentProvider cp, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(projection, "projection");
        return cp.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @JvmStatic
    public static final Cursor query(ContentProvider cp, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(projection, "projection");
        return cp.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
    }

    @JvmStatic
    public static final Cursor query(ContentProvider cp, Uri uri, String[] projection, Bundle queryArgs, CancellationSignal cancellationSignal) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(projection, "projection");
        return cp.query(uri, projection, queryArgs, cancellationSignal);
    }

    @JvmStatic
    public static final Uri insert(ContentProvider cp, Uri uri, ContentValues values) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        return cp.insert(uri, values);
    }

    @JvmStatic
    public static final Uri insert(ContentProvider cp, Uri uri, ContentValues values, Bundle extras) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        return cp.insert(uri, values, extras);
    }

    @JvmStatic
    public static final int bulkInsert(ContentProvider cp, Uri uri, ContentValues[] values) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        if (values == null) {
            Intrinsics.throwNpe();
        }
        return cp.bulkInsert(uri, values);
    }

    @JvmStatic
    public static final int delete(ContentProvider cp, Uri uri, String selection, String[] selectionArgs) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        return cp.delete(uri, selection, selectionArgs);
    }

    @JvmStatic
    public static final int delete(ContentProvider cp, Uri uri, Bundle extras) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        return cp.delete(uri, extras);
    }

    @JvmStatic
    public static final int update(ContentProvider cp, Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        return cp.update(uri, values, selection, selectionArgs);
    }

    @JvmStatic
    public static final int update(ContentProvider cp, Uri uri, ContentValues values, Bundle extras) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        return cp.update(uri, values, extras);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFile(ContentProvider cp, Uri uri, String mode) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        return cp.openFile(uri, mode);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFile(ContentProvider cp, Uri uri, String mode, CancellationSignal signal) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        return cp.openFile(uri, mode, signal);
    }

    @JvmStatic
    public static final AssetFileDescriptor openAssetFile(ContentProvider cp, Uri uri, String mode) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        return cp.openAssetFile(uri, mode);
    }

    @JvmStatic
    public static final AssetFileDescriptor openAssetFile(ContentProvider cp, Uri uri, String mode, CancellationSignal signal) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        return cp.openAssetFile(uri, mode, signal);
    }

    @JvmStatic
    public static final AssetFileDescriptor openTypedAssetFile(ContentProvider cp, Uri uri, String mimeTypeFilter, Bundle opts) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mimeTypeFilter, "mimeTypeFilter");
        return cp.openTypedAssetFile(uri, mimeTypeFilter, opts);
    }

    @JvmStatic
    public static final AssetFileDescriptor openTypedAssetFile(ContentProvider cp, Uri uri, String mimeTypeFilter, Bundle opts, CancellationSignal signal) {
        Intrinsics.checkParameterIsNotNull(cp, "cp");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mimeTypeFilter, "mimeTypeFilter");
        return cp.openTypedAssetFile(uri, mimeTypeFilter, opts, signal);
    }
}
