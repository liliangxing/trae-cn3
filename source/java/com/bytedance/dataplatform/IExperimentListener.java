package com.bytedance.dataplatform;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IExperimentListener {
    void onLibraExperimentChanged(JSONObject experimentCache);
}
