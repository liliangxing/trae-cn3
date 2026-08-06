package com.bytedance.push.starter;

import android.app.Application;
import android.util.Log;
import com.bytedance.common.network.DefaultNetWorkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkClientUtils;
import com.ss.android.message.util.ToolUtils;

/* loaded from: classes4.dex */
public class PushHook {
    public static boolean allowInvokeHostOnCreate = true;
    public static boolean hasCreated;

    public static boolean allowInvokeHostOnCreate(Application application) {
        if (hasCreated) {
            return allowInvokeHostOnCreate;
        }
        allowInvokeHostOnCreate = !ToolUtils.isSmpProcess(application);
        hasCreated = true;
        Log.d("PushStarter", "onHookApplicationOnCreate");
        PushStarter.initPushOnApplication(application);
        if (!ToolUtils.isMainProcess(application)) {
            if (ToolUtils.isSmpProcess(application) || NetworkClientUtils.hasNotSetNetworkClient()) {
                Log.d("PushStarter", "hasNotSetNetworkClient, set DefaultNetWorkClient as NetworkClient");
                NetworkClient.setDefault(new DefaultNetWorkClient());
            } else {
                Log.d("PushStarter", "hasNotSetNetworkClient is false, need't set DefaultNetWorkClient as NetworkClient");
            }
        }
        return allowInvokeHostOnCreate;
    }

    @Deprecated
    public static boolean onHookApplicationOnCreate(Application application) {
        return allowInvokeHostOnCreate(application);
    }
}
