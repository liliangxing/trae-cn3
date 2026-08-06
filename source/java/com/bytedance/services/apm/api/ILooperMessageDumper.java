package com.bytedance.services.apm.api;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface ILooperMessageDumper {
    JSONObject dumpDispatchingMessage();

    JSONArray dumpHistoryMessages();

    JSONObject dumpMessages();

    JSONArray dumpPendingMessages();
}
