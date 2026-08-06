package com.bytedance.webx.core.webview.module;

import android.webkit.WebView;
import com.bytedance.webx.base.util.TTWebUtilsInternal;
import com.bytedance.webx.base.util.TTWebViewExtensionUtilsInternal;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TTWebModule {
    private final TTWebViewExtensionUtilsInternal mTTWebViewExtension;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class Global {
        public static void preresolveHosts(String[] strArr) throws InvocationTargetException {
            TTWebUtilsInternal.INSTANCE.preresolveHosts(strArr);
        }

        public static void preconnectUrl(String str, int i) throws InvocationTargetException {
            TTWebUtilsInternal.INSTANCE.preconnectUrl(str, i);
        }

        public static void preloadUrl(String str, long j, String str2, String str3, boolean z) throws InvocationTargetException {
            TTWebUtilsInternal.INSTANCE.preloadUrl(str, j, str2, str3, z);
        }
    }

    public TTWebModule(WebView webView) throws InvocationTargetException {
        this.mTTWebViewExtension = new TTWebViewExtensionUtilsInternal(webView);
    }

    public void preresolveHosts(String[] strArr) throws InvocationTargetException {
        this.mTTWebViewExtension.preresolveHosts(strArr);
    }

    public void preconnectUrl(String str, int i) throws InvocationTargetException {
        this.mTTWebViewExtension.preconnectUrl(str, i);
    }
}
