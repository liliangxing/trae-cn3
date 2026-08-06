package com.bytedance.apm6.monitor;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface Monitorable {
    String getLogType();

    boolean isValid();

    JSONObject toJsonObject();
}
