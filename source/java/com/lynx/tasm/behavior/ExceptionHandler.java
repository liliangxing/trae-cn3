package com.lynx.tasm.behavior;

import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface ExceptionHandler {
    void handleException(Exception exc);

    @Deprecated
    void handleException(Exception exc, int i);

    @Deprecated
    void handleException(Exception exc, int i, JSONObject jSONObject);

    void handleException(Exception exc, JSONObject jSONObject);
}
