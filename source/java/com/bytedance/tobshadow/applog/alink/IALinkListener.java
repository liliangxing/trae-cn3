package com.bytedance.tobshadow.applog.alink;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH'J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH'J\u0018\u0010\n\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/tobshadow/applog/alink/IALinkListener;", "", "onALinkData", "", "routingInfo", "Lorg/json/JSONObject;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onAttributionData", "onAttributionFailedCallback", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface IALinkListener {
    void onALinkData(JSONObject routingInfo, Exception exception);

    void onAttributionData(JSONObject routingInfo, Exception exception);

    void onAttributionFailedCallback(Exception exception);
}
