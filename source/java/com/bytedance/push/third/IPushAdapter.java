package com.bytedance.push.third;

import android.content.Context;
import com.bytedance.push.Keep;

/* loaded from: classes4.dex */
public interface IPushAdapter extends Keep {
    boolean checkThirdPushConfig(String str, Context context) throws Exception;

    boolean isPushAvailable(Context context, int i);

    void registerPush(Context context, int i);

    boolean requestRemoveVoipNotification(Context context, int i);

    void setAlias(Context context, String str, int i);

    void trackPush(Context context, int i, Object obj);

    void unregisterPush(Context context, int i);
}
