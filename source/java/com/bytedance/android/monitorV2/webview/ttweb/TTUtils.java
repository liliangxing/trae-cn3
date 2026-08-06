package com.bytedance.android.monitorV2.webview.ttweb;

import android.webkit.WebView;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.ReflectUtils;
import com.bytedance.common.process.cross.CrossProcessDatabaseHelper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TTUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\b\u001a\u0004\b\t\u0010\u0006R\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R!\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0010R!\u0010\u0015\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/ttweb/TTUtils;", "", "()V", "getPerformanceMetricsMethod", "Ljava/lang/reflect/Method;", "getGetPerformanceMetricsMethod", "()Ljava/lang/reflect/Method;", "getPerformanceMetricsMethod$delegate", "Lkotlin/Lazy;", "isHookSuccessMethod", "isHookSuccessMethod$delegate", "isTTWebViewMethod", "isTTWebViewMethod$delegate", "ttWebSdkClazz", "Ljava/lang/Class;", "getTtWebSdkClazz", "()Ljava/lang/Class;", "ttWebSdkClazz$delegate", "ttWebViewExtensionClazz", "getTtWebViewExtensionClazz", "ttWebViewExtensionClazz$delegate", "ttWebViewExtensionConstructor", "Ljava/lang/reflect/Constructor;", "getTtWebViewExtensionConstructor", "()Ljava/lang/reflect/Constructor;", "ttWebViewExtensionConstructor$delegate", "getTTWebHookState", "", "webView", "Landroid/webkit/WebView;", "getTTWebViewMetrics", "Lorg/json/JSONObject;", CrossProcessDatabaseHelper.COL_ARGS, "Lcom/bytedance/android/monitorV2/webview/ttweb/TTUtils$MetricsArgs;", "isTTWebView", "MetricsArgs", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TTUtils {
    public static final TTUtils INSTANCE = new TTUtils();

    /* renamed from: ttWebSdkClazz$delegate, reason: from kotlin metadata */
    private static final Lazy ttWebSdkClazz = LazyKt.lazy(new Function0<Class<?>>() { // from class: com.bytedance.android.monitorV2.webview.ttweb.TTUtils$ttWebSdkClazz$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Class<?> m392invoke() {
            try {
                Result.Companion companion = Result.Companion;
                return Class.forName("com.bytedance.lynx.webview.TTWebSdk");
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return null;
            }
        }
    });

    /* renamed from: ttWebViewExtensionClazz$delegate, reason: from kotlin metadata */
    private static final Lazy ttWebViewExtensionClazz = LazyKt.lazy(new Function0<Class<?>>() { // from class: com.bytedance.android.monitorV2.webview.ttweb.TTUtils$ttWebViewExtensionClazz$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Class<?> m393invoke() {
            try {
                Result.Companion companion = Result.Companion;
                return Class.forName("com.bytedance.lynx.webview.extension.TTWebViewExtension");
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return null;
            }
        }
    });

    /* renamed from: isTTWebViewMethod$delegate, reason: from kotlin metadata */
    private static final Lazy isTTWebViewMethod = LazyKt.lazy(new Function0<Method>() { // from class: com.bytedance.android.monitorV2.webview.ttweb.TTUtils$isTTWebViewMethod$2
        public final Method invoke() {
            Class ttWebSdkClazz2;
            try {
                Result.Companion companion = Result.Companion;
                ttWebSdkClazz2 = TTUtils.INSTANCE.getTtWebSdkClazz();
                if (ttWebSdkClazz2 != null) {
                    return ttWebSdkClazz2.getDeclaredMethod("isTTWebView", WebView.class);
                }
                return null;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return null;
            }
        }
    });

    /* renamed from: isHookSuccessMethod$delegate, reason: from kotlin metadata */
    private static final Lazy isHookSuccessMethod = LazyKt.lazy(new Function0<Method>() { // from class: com.bytedance.android.monitorV2.webview.ttweb.TTUtils$isHookSuccessMethod$2
        public final Method invoke() {
            Class ttWebSdkClazz2;
            try {
                Result.Companion companion = Result.Companion;
                ttWebSdkClazz2 = TTUtils.INSTANCE.getTtWebSdkClazz();
                return ReflectUtils.getMethod(ttWebSdkClazz2, "isWebViewSupportInterceptor", new Class[]{WebView.class});
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return null;
            }
        }
    });

    /* renamed from: ttWebViewExtensionConstructor$delegate, reason: from kotlin metadata */
    private static final Lazy ttWebViewExtensionConstructor = LazyKt.lazy(new Function0<Constructor<? extends Object>>() { // from class: com.bytedance.android.monitorV2.webview.ttweb.TTUtils$ttWebViewExtensionConstructor$2
        public final Constructor<? extends Object> invoke() {
            Class ttWebViewExtensionClazz2;
            try {
                Result.Companion companion = Result.Companion;
                ttWebViewExtensionClazz2 = TTUtils.INSTANCE.getTtWebViewExtensionClazz();
                if (ttWebViewExtensionClazz2 != null) {
                    return ttWebViewExtensionClazz2.getConstructor(WebView.class);
                }
                return null;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return null;
            }
        }
    });

    /* renamed from: getPerformanceMetricsMethod$delegate, reason: from kotlin metadata */
    private static final Lazy getPerformanceMetricsMethod = LazyKt.lazy(new Function0<Method>() { // from class: com.bytedance.android.monitorV2.webview.ttweb.TTUtils$getPerformanceMetricsMethod$2
        public final Method invoke() {
            Class ttWebViewExtensionClazz2;
            try {
                Result.Companion companion = Result.Companion;
                ttWebViewExtensionClazz2 = TTUtils.INSTANCE.getTtWebViewExtensionClazz();
                if (ttWebViewExtensionClazz2 != null) {
                    return ttWebViewExtensionClazz2.getDeclaredMethod("getPerformanceMetrics", String.class);
                }
                return null;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return null;
            }
        }
    });

    private TTUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getTtWebSdkClazz() {
        return (Class) ttWebSdkClazz.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> getTtWebViewExtensionClazz() {
        return (Class) ttWebViewExtensionClazz.getValue();
    }

    private final Method isTTWebViewMethod() {
        return (Method) isTTWebViewMethod.getValue();
    }

    private final Method isHookSuccessMethod() {
        return (Method) isHookSuccessMethod.getValue();
    }

    private final Constructor<?> getTtWebViewExtensionConstructor() {
        return (Constructor) ttWebViewExtensionConstructor.getValue();
    }

    private final Method getGetPerformanceMetricsMethod() {
        return (Method) getPerformanceMetricsMethod.getValue();
    }

    public final boolean isTTWebView(WebView webView) {
        try {
            Method isTTWebViewMethod2 = isTTWebViewMethod();
            if (isTTWebViewMethod2 == null) {
                return false;
            }
            Object invoke = isTTWebViewMethod2.invoke(null, webView);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e) {
            ExceptionUtil.handleException(e);
            return false;
        }
    }

    public final boolean getTTWebHookState(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        try {
            Method isHookSuccessMethod2 = isHookSuccessMethod();
            if (isHookSuccessMethod2 == null) {
                return false;
            }
            isHookSuccessMethod2.setAccessible(true);
            Object invoke = isHookSuccessMethod2.invoke(null, webView);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) invoke).booleanValue();
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return false;
        }
    }

    public static /* synthetic */ JSONObject getTTWebViewMetrics$default(TTUtils tTUtils, WebView webView, MetricsArgs metricsArgs, int i, Object obj) {
        if ((i & 2) != 0) {
            metricsArgs = MetricsArgs.Metrics;
        }
        return tTUtils.getTTWebViewMetrics(webView, metricsArgs);
    }

    public final JSONObject getTTWebViewMetrics(WebView webView, MetricsArgs args) {
        Method getPerformanceMetricsMethod2;
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(args, CrossProcessDatabaseHelper.COL_ARGS);
        try {
            JSONObject jSONObject = new JSONObject();
            Constructor<?> ttWebViewExtensionConstructor2 = getTtWebViewExtensionConstructor();
            if (ttWebViewExtensionConstructor2 == null || (getPerformanceMetricsMethod2 = INSTANCE.getGetPerformanceMetricsMethod()) == null) {
                return jSONObject;
            }
            Object invoke = getPerformanceMetricsMethod2.invoke(ttWebViewExtensionConstructor2.newInstance(webView), args.getArgs());
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
            return new JSONObject((String) invoke);
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return new JSONObject();
        }
    }

    /* compiled from: TTUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/ttweb/TTUtils$MetricsArgs;", "", CrossProcessDatabaseHelper.COL_ARGS, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getArgs", "()Ljava/lang/String;", "Metrics", "Errors", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum MetricsArgs {
        Metrics("{\"loading\":{}}"),
        Errors("{\"webview_error\":{}}");

        private final String args;

        MetricsArgs(String str) {
            this.args = str;
        }

        public final String getArgs() {
            return this.args;
        }
    }
}
