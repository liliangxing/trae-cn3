package com.bytedance.webx.base.util;

import android.webkit.WebView;
import com.bytedance.webx.base.logger.WLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTWebViewExtensionUtilsInternal.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0019\u0010\r\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/webx/base/util/TTWebViewExtensionUtilsInternal;", "", "webView", "Landroid/webkit/WebView;", "(Landroid/webkit/WebView;)V", "sInstance", "kotlin.jvm.PlatformType", "preconnectUrl", "", "url", "", "num_sockets", "", "preresolveHosts", "hostnames", "", "([Ljava/lang/String;)V", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class TTWebViewExtensionUtilsInternal {
    private static final Constructor<? extends Object> Constructor;
    private static Method PreconnectUrlMethod = null;
    private static Method PreresolveHostsMethod = null;
    private static final String TAG = "TTWebViewExtension";
    private static final Class<?> TTWebViewExtensionClazz;
    private final Object sInstance;

    public TTWebViewExtensionUtilsInternal(WebView webView) {
        Object obj;
        Intrinsics.checkNotNullParameter(webView, "webView");
        try {
            Result.Companion companion = Result.Companion;
            Constructor<? extends Object> constructor = Constructor;
            Intrinsics.checkNotNull(constructor);
            obj = Result.constructor-impl(constructor.newInstance(webView));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            throw new InvocationTargetException(th2);
        }
        this.sInstance = obj;
    }

    public final void preresolveHosts(String[] hostnames) {
        Object obj;
        Intrinsics.checkNotNullParameter(hostnames, "hostnames");
        try {
            Result.Companion companion = Result.Companion;
            synchronized (this) {
                if (PreresolveHostsMethod == null) {
                    Class<?> cls = TTWebViewExtensionClazz;
                    PreresolveHostsMethod = cls != null ? cls.getMethod("preresolveHosts", String[].class) : null;
                }
                Unit unit = Unit.INSTANCE;
            }
            Method method = PreresolveHostsMethod;
            Intrinsics.checkNotNull(method);
            obj = Result.constructor-impl(method.invoke(this.sInstance, hostnames));
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
                    Class<?> cls = TTWebViewExtensionClazz;
                    PreconnectUrlMethod = cls != null ? cls.getMethod("preconnectUrl", String.class, Integer.TYPE) : null;
                }
                Unit unit = Unit.INSTANCE;
            }
            Method method = PreconnectUrlMethod;
            Intrinsics.checkNotNull(method);
            obj = Result.constructor-impl(method.invoke(this.sInstance, url, Integer.valueOf(num_sockets)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            throw new InvocationTargetException(th2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Object obj;
        DefaultConstructorMarker defaultConstructorMarker;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Class.forName("com.bytedance.lynx.webview.extension.TTWebViewExtension"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            WLog.m44e(TAG, "Get TTWebViewExtension class failed:", th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Class<?> cls = (Class) obj;
        TTWebViewExtensionClazz = cls;
        try {
            Result.Companion companion3 = Result.Companion;
            defaultConstructorMarker = Result.constructor-impl(cls != null ? cls.getConstructor(WebView.class) : null);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            defaultConstructorMarker = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        Throwable th4 = Result.exceptionOrNull-impl(defaultConstructorMarker);
        if (th4 != null) {
            WLog.m44e(TAG, "Get TTWebViewExtension Constructor failed:", th4);
        }
        Constructor = (Constructor) (Result.isFailure-impl(defaultConstructorMarker) ? null : defaultConstructorMarker);
    }
}
