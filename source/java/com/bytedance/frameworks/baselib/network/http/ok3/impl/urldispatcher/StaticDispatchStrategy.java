package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class StaticDispatchStrategy extends DispatchStrategy {
    private static final String TAG = "StaticDispatchStrategy";
    private Map<String, String> mHostMap;

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void dispatchRequestHeaders(URLRequest uRLRequest) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean needRequestResultFeedback() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void notifyRequestResult(String str, boolean z, int i) {
    }

    public StaticDispatchStrategy(JSONObject jSONObject) {
        super(DispatchStrategy.DispatchStrategyType.STATIC_DISPATCH_STRATEGY);
        this.mHostMap = new HashMap();
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                this.mHostMap.put(next, optString);
            }
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String getTargetUrl(Uri uri) {
        String host = uri.getHost();
        String uri2 = uri.toString();
        String str = this.mHostMap.get(host);
        if (TextUtils.isEmpty(str)) {
            return uri2;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "replace host " + str + " for " + host);
        }
        return uri2.replaceFirst(host, str);
    }
}
