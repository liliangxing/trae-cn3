package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy;

/* loaded from: classes2.dex */
public class DefaultDispatchStrategy extends DispatchStrategy {
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

    public DefaultDispatchStrategy() {
        super(DispatchStrategy.DispatchStrategyType.UNKNOWN_DISPATCH_STRATEGY);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String getTargetUrl(Uri uri) {
        return uri.toString();
    }
}
