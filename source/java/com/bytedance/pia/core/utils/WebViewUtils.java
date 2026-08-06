package com.bytedance.pia.core.utils;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.pia.core.api.utils.IConsumer;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: WebViewUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J*\u0010\n\u001a\u00020\u0004*\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000eH\u0007J\u000e\u0010\u000f\u001a\u00020\u0010*\u0004\u0018\u00010\u000bH\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/core/utils/WebViewUtils;", "", "()V", "encodeJavaScriptString", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "javaString", "", "evaluateJavaScript", "Landroid/webkit/WebView;", "script", "callback", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "getChromeVersion", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class WebViewUtils {
    public static final WebViewUtils INSTANCE = new WebViewUtils();

    @JvmStatic
    public static final void evaluateJavaScript(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(str, "script");
        evaluateJavaScript$default(webView, str, null, 2, null);
    }

    private WebViewUtils() {
    }

    @JvmStatic
    public static final int getChromeVersion(WebView webView) {
        Object obj;
        WebSettings settings;
        ThreadUtil.checkMainThread();
        String userAgentString = (webView == null || (settings = webView.getSettings()) == null) ? null : settings.getUserAgentString();
        if (userAgentString == null) {
            return -1;
        }
        try {
            Result.Companion companion = Result.Companion;
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            String lowerCase = userAgentString.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            obj = Result.constructor-impl(Integer.valueOf(Integer.parseInt(StringsKt.substringBefore$default(StringsKt.substringAfter$default(lowerCase, "chrome/", (String) null, 2, (Object) null), LibrarianImpl.Constants.DOT, (String) null, 2, (Object) null))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = -1;
        }
        return ((Number) obj).intValue();
    }

    @JvmStatic
    public static final void encodeJavaScriptString(StringBuilder builder, String javaString) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (javaString == null) {
            return;
        }
        builder.append("(\"");
        String str = javaString;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\r') {
                builder.append("\\r");
            } else if (charAt == '\"') {
                builder.append("\\\"");
            } else if (charAt == '\'') {
                builder.append("\\'");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case '\b':
                        builder.append("\\b");
                        break;
                    case '\t':
                        builder.append("\\t");
                        break;
                    case '\n':
                        builder.append("\\n");
                        break;
                    default:
                        builder.append(charAt);
                        break;
                }
            } else {
                builder.append("\\\\");
            }
        }
        builder.append("\")");
    }

    public static /* synthetic */ void evaluateJavaScript$default(WebView webView, String str, IConsumer iConsumer, int i, Object obj) {
        if ((i & 2) != 0) {
            iConsumer = null;
        }
        evaluateJavaScript(webView, str, iConsumer);
    }

    @JvmStatic
    public static final void evaluateJavaScript(WebView webView, String str, final IConsumer<String> iConsumer) {
        Intrinsics.checkNotNullParameter(str, "script");
        if (webView != null) {
            webView.evaluateJavascript(str, new ValueCallback() { // from class: com.bytedance.pia.core.utils.WebViewUtils$evaluateJavaScript$1
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(String str2) {
                    IConsumer<String> iConsumer2 = iConsumer;
                    if (iConsumer2 != null) {
                        iConsumer2.accept(str2);
                    }
                }
            });
        }
    }
}
