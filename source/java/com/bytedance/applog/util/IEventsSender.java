package com.bytedance.applog.util;

import android.content.Context;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public interface IEventsSender {
    boolean isEnable();

    void loginEtWithScheme(String str, Context context);

    void putEvent(String str, JSONArray jSONArray);

    void setEnable(boolean z, Context context);

    void setEventVerifyInterval(long j);

    void setEventVerifyUrl(String str);

    void setSpecialKeys(List<String> list);
}
