package com.ss.android.message;

import android.content.Context;
import com.ss.android.pushmanager.IMessageContext;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public interface IPushLifeAdapter extends IPushLifeCycleListener {

    /* loaded from: classes7.dex */
    public interface IPushDepend {
        void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject);

        void onEventV3(String str, JSONObject jSONObject);
    }

    void handleAppLogUpdate(Context context, Map<String, String> map);

    void initOnApplication(Context context, IMessageContext iMessageContext);

    void onSetSettingsData(Context context, JSONObject jSONObject);

    void onStart();

    void setPushDepend(IPushDepend iPushDepend);
}
