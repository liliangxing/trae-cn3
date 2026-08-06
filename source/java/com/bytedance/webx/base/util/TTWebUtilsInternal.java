package com.bytedance.webx.base.util;

import com.bytedance.webx.base.logger.WLog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTWebUtilsInternal.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ.\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0016J\u0019\u0010\u0017\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019¢\u0006\u0002\u0010\u001aR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/webx/base/util/TTWebUtilsInternal;", "", "()V", "PreconnectUrlMethod", "Ljava/lang/reflect/Method;", "PreloadUrlMethod", "PreresolveHostsMethod", "TAG", "", "TTWebSdkClazz", "Ljava/lang/Class;", "preconnectUrl", "", "url", "num_sockets", "", "preloadUrl", RemoteMessageConst.TTL, "", "cache_key", "custom_ua", "to_memorycache", "", "preresolveHosts", "hostnames", "", "([Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class TTWebUtilsInternal {
    public static final TTWebUtilsInternal INSTANCE = new TTWebUtilsInternal();
    private static Method PreconnectUrlMethod = null;
    private static Method PreloadUrlMethod = null;
    private static Method PreresolveHostsMethod = null;
    public static final String TAG = "TTWeb";
    private static final Class<?> TTWebSdkClazz;

    private TTWebUtilsInternal() {
    }

    public final void preresolveHosts(String[] hostnames) {
        Object obj;
        Intrinsics.checkNotNullParameter(hostnames, "hostnames");
        try {
            Result.Companion companion = Result.Companion;
            synchronized (this) {
                if (PreresolveHostsMethod == null) {
                    Class<?> cls = TTWebSdkClazz;
                    PreresolveHostsMethod = cls != null ? cls.getMethod("preresolveHosts", String[].class) : null;
                }
                Unit unit = Unit.INSTANCE;
            }
            Method method = PreresolveHostsMethod;
            Intrinsics.checkNotNull(method);
            obj = Result.constructor-impl(method.invoke(null, hostnames));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            throw new InvocationTargetException(th2);
        }
    }

    public final void preconnectUrl(String url, int num_sockets) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Result.Companion companion = Result.Companion;
            synchronized (this) {
                if (PreconnectUrlMethod == null) {
                    Class<?> cls = TTWebSdkClazz;
                    PreconnectUrlMethod = cls != null ? cls.getMethod("preconnectUrl", String.class, Integer.TYPE) : null;
                }
                Unit unit = Unit.INSTANCE;
            }
            Method method = PreconnectUrlMethod;
            Intrinsics.checkNotNull(method);
            obj = Result.constructor-impl(method.invoke(null, url, Integer.valueOf(num_sockets)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            throw new InvocationTargetException(th2);
        }
    }

    public final void preloadUrl(String url, long ttl, String cache_key, String custom_ua, boolean to_memorycache) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cache_key, "cache_key");
        Intrinsics.checkNotNullParameter(custom_ua, "custom_ua");
        try {
            Result.Companion companion = Result.Companion;
            synchronized (this) {
                if (PreloadUrlMethod == null) {
                    Class<?> cls = TTWebSdkClazz;
                    PreloadUrlMethod = cls != null ? cls.getMethod("preloadUrl", String.class, Long.TYPE, String.class, String.class, Boolean.TYPE) : null;
                }
                Unit unit = Unit.INSTANCE;
            }
            Method method = PreloadUrlMethod;
            Intrinsics.checkNotNull(method);
            obj = Result.constructor-impl(method.invoke(null, url, Long.valueOf(ttl), cache_key, custom_ua, Boolean.valueOf(to_memorycache)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            throw new InvocationTargetException(th2);
        }
    }

    static {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Class.forName("com.bytedance.lynx.webview.TTWebSdk"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            WLog.m44e(TAG, "Get TTWebSdk class failed:", th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        TTWebSdkClazz = (Class) obj;
    }
}
