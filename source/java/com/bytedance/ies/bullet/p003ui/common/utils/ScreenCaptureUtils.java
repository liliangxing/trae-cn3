package com.bytedance.ies.bullet.p003ui.common.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ScreenCaptureUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0012\u001a\u00020\u0013J\u0019\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0015H\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0013J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/ScreenCaptureUtils;", "", "()V", "externalObserver", "Landroid/database/ContentObserver;", "hasRegister", "Ljava/util/concurrent/atomic/AtomicBoolean;", "internalObserver", "isAppInBackground", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ies/bullet/ui/common/utils/OnScreenCaptureListener;", "addScreenCaptureListener", "", "appContext", "Landroid/content/Context;", "listener", "getIsAppInBackground", "", "getListeners", "", "getListeners$anniex_release", "initObserver", "registerScreenCaptureObserver", "removeScreenCaptureListener", "setIsAppInBackground", "unRegisterScreenCaptureObserver", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ScreenCaptureUtils {
    private static ContentObserver externalObserver;
    private static ContentObserver internalObserver;
    public static final ScreenCaptureUtils INSTANCE = new ScreenCaptureUtils();
    private static AtomicBoolean hasRegister = new AtomicBoolean(false);
    private static final CopyOnWriteArrayList<WeakReference<OnScreenCaptureListener>> listeners = new CopyOnWriteArrayList<>();
    private static AtomicBoolean isAppInBackground = new AtomicBoolean(true);

    private ScreenCaptureUtils() {
    }

    public final boolean getIsAppInBackground() {
        return isAppInBackground.get();
    }

    public final void setIsAppInBackground(boolean isAppInBackground2) {
        isAppInBackground.set(isAppInBackground2);
    }

    private final void initObserver(Context appContext) {
        if (internalObserver == null) {
            Uri uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(uri, "INTERNAL_CONTENT_URI");
            internalObserver = new InternalScreenCaptureObserver(uri, appContext);
        }
        if (externalObserver == null) {
            Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(uri2, "EXTERNAL_CONTENT_URI");
            externalObserver = new ScreenCaptureObserver(uri2, appContext, null, 4, null);
        }
    }

    private final void registerScreenCaptureObserver(Context appContext) {
        Object obj;
        if (hasRegister.get()) {
            return;
        }
        initObserver(appContext);
        boolean z = Build.VERSION.SDK_INT > 28;
        try {
            Result.Companion companion = Result.Companion;
            ContentResolver contentResolver = appContext.getContentResolver();
            Uri uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
            ContentObserver contentObserver = internalObserver;
            ContentObserver contentObserver2 = null;
            if (contentObserver == null) {
                Intrinsics.throwUninitializedPropertyAccessException("internalObserver");
                contentObserver = null;
            }
            contentResolver.registerContentObserver(uri, z, contentObserver);
            ContentResolver contentResolver2 = appContext.getContentResolver();
            Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            ContentObserver contentObserver3 = externalObserver;
            if (contentObserver3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("externalObserver");
            } else {
                contentObserver2 = contentObserver3;
            }
            contentResolver2.registerContentObserver(uri2, z, contentObserver2);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        hasRegister.set(true);
    }

    private final void unRegisterScreenCaptureObserver(Context appContext) {
        if (hasRegister.get()) {
            try {
                Result.Companion companion = Result.Companion;
                ContentResolver contentResolver = appContext.getContentResolver();
                ContentObserver contentObserver = internalObserver;
                ContentObserver contentObserver2 = null;
                if (contentObserver == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("internalObserver");
                    contentObserver = null;
                }
                contentResolver.unregisterContentObserver(contentObserver);
                ContentResolver contentResolver2 = appContext.getContentResolver();
                ContentObserver contentObserver3 = externalObserver;
                if (contentObserver3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("externalObserver");
                } else {
                    contentObserver2 = contentObserver3;
                }
                contentResolver2.unregisterContentObserver(contentObserver2);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
            hasRegister.set(false);
        }
    }

    public final void addScreenCaptureListener(Context appContext, OnScreenCaptureListener listener) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (listener == null) {
            return;
        }
        registerScreenCaptureObserver(appContext);
        Iterator<WeakReference<OnScreenCaptureListener>> it = listeners.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().get(), listener)) {
                return;
            }
        }
        listeners.add(new WeakReference<>(listener));
    }

    public final void removeScreenCaptureListener(Context appContext, OnScreenCaptureListener listener) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (listener == null) {
            return;
        }
        Iterator<WeakReference<OnScreenCaptureListener>> it = listeners.iterator();
        while (it.hasNext()) {
            WeakReference<OnScreenCaptureListener> next = it.next();
            if (Intrinsics.areEqual(next.get(), listener) || next.get() == null) {
                listeners.remove(next);
            }
        }
        if (listeners.size() == 0) {
            unRegisterScreenCaptureObserver(appContext);
        }
    }

    public final List<WeakReference<OnScreenCaptureListener>> getListeners$anniex_release() {
        return listeners;
    }
}
