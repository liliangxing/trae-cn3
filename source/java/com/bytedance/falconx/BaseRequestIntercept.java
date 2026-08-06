package com.bytedance.falconx;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.falconx.utils.MimeUtils;
import com.bytedance.falconx.utils.WebResourceUtils;
import java.io.InputStream;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class BaseRequestIntercept implements IRequestIntercept {
    private static final String TAG = "BaseRequestIntercept";

    protected String getEncode() {
        return "";
    }

    protected abstract InputStream getLocalInputStream(String str);

    protected abstract List<String> getRegex();

    @Override // com.bytedance.falconx.IRequestIntercept
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getResponse(str);
    }

    private WebResourceResponse getResponse(String str) {
        WebResourceResponse response = matchUrl(str) ? WebResourceUtils.getResponse(MimeUtils.getMimeType(str), getEncode(), getLocalInputStream(str)) : null;
        Log.e(TAG, "getResponse response = " + response);
        return response;
    }

    protected boolean matchUrl(String str) {
        List<String> regex = getRegex();
        if (regex == null || regex.isEmpty()) {
            return false;
        }
        for (String str2 : regex) {
            Log.e(TAG, "regexStr = " + str2);
            if (!TextUtils.isEmpty(str2)) {
                return Pattern.compile(str2).matcher(str).find();
            }
        }
        return false;
    }
}
