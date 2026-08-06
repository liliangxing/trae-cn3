package com.bytedance.security.android.aopcheck;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentResolverWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J,\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J,\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0007J\"\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J,\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/security/android/aopcheck/ContentResolverWrapper;", "", "()V", "openAssetFile", "Landroid/content/res/AssetFileDescriptor;", "resolver", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "mode", "", "cancellationSignal", "Landroid/os/CancellationSignal;", "openAssetFileDescriptor", "openFile", "Landroid/os/ParcelFileDescriptor;", IAllianceService.LAUNCH_FROM_SIGNAL, "openFileDescriptor", "openInputStream", "Ljava/io/InputStream;", "openOutputStream", "Ljava/io/OutputStream;", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class ContentResolverWrapper {
    public static final ContentResolverWrapper INSTANCE = new ContentResolverWrapper();

    private ContentResolverWrapper() {
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFileDescriptor(ContentResolver resolver, Uri uri, String mode) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openFileDescriptor(uri, mode);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFileDescriptor(ContentResolver resolver, Uri uri, String mode, CancellationSignal cancellationSignal) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openFileDescriptor(uri, mode, cancellationSignal);
    }

    @JvmStatic
    public static final AssetFileDescriptor openAssetFile(ContentResolver resolver, Uri uri, String mode, CancellationSignal cancellationSignal) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openAssetFile(uri, mode, cancellationSignal);
    }

    @JvmStatic
    public static final AssetFileDescriptor openAssetFileDescriptor(ContentResolver resolver, Uri uri, String mode) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openAssetFileDescriptor(uri, mode);
    }

    @JvmStatic
    public static final AssetFileDescriptor openAssetFileDescriptor(ContentResolver resolver, Uri uri, String mode, CancellationSignal cancellationSignal) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openAssetFileDescriptor(uri, mode, cancellationSignal);
    }

    @JvmStatic
    public static final InputStream openInputStream(ContentResolver resolver, Uri uri) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openInputStream(uri);
    }

    @JvmStatic
    public static final OutputStream openOutputStream(ContentResolver resolver, Uri uri) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openOutputStream(uri);
    }

    @JvmStatic
    public static final OutputStream openOutputStream(ContentResolver resolver, Uri uri, String mode) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openOutputStream(uri, mode);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFile(ContentResolver resolver, Uri uri, String mode, CancellationSignal signal) {
        Intrinsics.checkParameterIsNotNull(resolver, "resolver");
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (PathTraversalChecker.check(uri) && PathTraversalChecker.INSTANCE.getEnableIntercept() && PathTraversalChecker.INSTANCE.getEnableContentResolverIntercept()) {
            return null;
        }
        return resolver.openFile(uri, mode, signal);
    }
}
