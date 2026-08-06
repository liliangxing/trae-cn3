package com.bytedance.push.interfaze;

import android.content.Context;
import com.bytedance.push.Keep;

/* loaded from: classes4.dex */
public interface ISenderService extends Keep {
    boolean isAllowPushService(int i);

    boolean isSenderChanged(Context context);

    boolean registerAllSender(Context context);

    void registerSenderInPushServiceProcess();

    void setAlias(Context context, String str, int i);

    void startNonMainProcess(Context context);

    void tryStartPushProcess(Context context);

    void tryUpdateSender(boolean z);

    void unRegisterAllThirdPush(Context context);
}
