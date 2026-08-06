package com.bytedance.apm.data;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface ITypeData {
    String getSubTypeLabel();

    String getTypeLabel();

    boolean isSampled(JSONObject jSONObject);

    boolean isSaveImmediately();

    boolean isUploadImmediately();

    JSONObject packLog();

    boolean supportFetch();
}
