package com.bytedance.android.monitorV2.jsb;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.entity.NativeCommon;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class WebHandler implements Icache {
    private Map<WebView, NativeCommon> cache = Collections.synchronizedMap(new WeakHashMap());

    @Override // com.bytedance.android.monitorV2.jsb.Icache
    public boolean isMatch(View view) {
        return view instanceof WebView;
    }

    @Override // com.bytedance.android.monitorV2.jsb.Icache
    public NativeCommon getNativeCommon(View view, String str) {
        if (view == null || !(view instanceof WebView)) {
            return null;
        }
        WebView webView = (WebView) view;
        NativeCommon nativeCommon = this.cache.get(webView);
        if (nativeCommon != null && !TextUtils.isEmpty(nativeCommon.url) && nativeCommon.url.equals(str)) {
            return nativeCommon;
        }
        NativeCommon nativeCommon2 = new NativeCommon();
        nativeCommon2.containerType = "web";
        nativeCommon2.url = str;
        this.cache.put(webView, nativeCommon2);
        return nativeCommon2;
    }

    @Override // com.bytedance.android.monitorV2.jsb.Icache
    public String getUrl(View view) {
        if (view == null || !(view instanceof WebView)) {
            return null;
        }
        return ((WebView) view).getUrl();
    }
}
