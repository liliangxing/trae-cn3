package com.bytedance.push.interfaze;

import android.content.Context;
import com.bytedance.push.PushBody;

/* loaded from: classes4.dex */
public interface IVerifyFailedListener {
    void onVerifyFailed(Context context, PushBody pushBody, int i);
}
