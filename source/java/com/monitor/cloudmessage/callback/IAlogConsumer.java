package com.monitor.cloudmessage.callback;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface IAlogConsumer extends IConsumerResultCallback {
    List<String> handleAlogData(long j, long j2, JSONObject jSONObject);
}
