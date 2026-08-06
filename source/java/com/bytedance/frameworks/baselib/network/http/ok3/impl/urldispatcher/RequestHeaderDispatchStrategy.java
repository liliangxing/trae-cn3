package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy;
import com.bytedance.retrofit2.client.Header;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RequestHeaderDispatchStrategy extends DispatchStrategy {
    private static final String TAG = "RequestHeaderDispatchStrategy";
    private Map<String, String> mAddHeaderMap;

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean needRequestResultFeedback() {
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void notifyRequestResult(String str, boolean z, int i) {
    }

    public RequestHeaderDispatchStrategy(JSONObject jSONObject) {
        super(DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY);
        this.mAddHeaderMap = new HashMap();
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject.optString(next);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                this.mAddHeaderMap.put(next, optString);
            }
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String getTargetUrl(Uri uri) {
        return uri.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void dispatchRequestHeaders(URLRequest uRLRequest) {
        if (uRLRequest.getHeaders() != null) {
            for (Map.Entry<String, String> entry : this.mAddHeaderMap.entrySet()) {
                uRLRequest.getHeaders().add(new Header(entry.getKey(), entry.getValue()));
            }
        }
    }
}
