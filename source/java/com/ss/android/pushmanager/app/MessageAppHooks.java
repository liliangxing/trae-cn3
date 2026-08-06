package com.ss.android.pushmanager.app;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.pushmanager.IMessageContext;
import com.ss.android.ug.bus.IUgBusService;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class MessageAppHooks {

    /* loaded from: classes7.dex */
    public interface InitHook extends IUgBusService {
        void tryInit(Context context);
    }

    /* loaded from: classes7.dex */
    public interface PushHook extends IUgBusService {
        Map<String, String> getHttpCommonParams();

        String getMessageAction();

        IMessageContext getMessageContext();

        String getMessageKeyData();

        boolean isSswoActivityisFinish();

        boolean needControlFlares();

        void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject);

        void onEventV3(String str, Bundle bundle);

        void onEventV3(String str, JSONObject jSONObject);
    }

    public static InitHook getInitHook() {
        return (InitHook) UgBusFramework.getService(InitHook.class);
    }

    public static PushHook getPushHook() {
        return (PushHook) UgBusFramework.getService(PushHook.class);
    }
}
