package com.bytedance.falconx;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.io.File;

/* loaded from: classes3.dex */
public class CommercializationPreload implements IRequestIntercept {
    private String accessKey;
    private String channel;
    private File rootFile;

    public CommercializationPreload(File file, String str, String str2) {
        this.rootFile = file;
        this.accessKey = str;
        this.channel = str2;
    }

    @Override // com.bytedance.falconx.IRequestIntercept
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        TextUtils.isEmpty(str);
        return null;
    }
}
