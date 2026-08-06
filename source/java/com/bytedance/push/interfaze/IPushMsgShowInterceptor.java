package com.bytedance.push.interfaze;

import android.content.Context;
import com.bytedance.push.PushBody;

/* loaded from: classes4.dex */
public interface IPushMsgShowInterceptor {
    boolean onReceivePassThoughMsg(Context context, int i, PushBody pushBody);

    boolean onReceiveRevokeMsg(Context context, int i, PushBody pushBody);
}
