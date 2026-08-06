package com.bytedance.push.settings;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface ISettings {
    void registerValChanged(Context context, String str, String str2, IDataChangedListener iDataChangedListener);

    void unregisterValChanged(IDataChangedListener iDataChangedListener);

    void updateSettings(Context context, JSONObject jSONObject);
}
