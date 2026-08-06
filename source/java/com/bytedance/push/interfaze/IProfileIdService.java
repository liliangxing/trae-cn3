package com.bytedance.push.interfaze;

import com.bytedance.push.third.IPushAdapter;

/* loaded from: classes4.dex */
public interface IProfileIdService {
    String onAccountSwitch(IPushAdapter iPushAdapter);

    String onLogIn(IPushAdapter iPushAdapter);

    void onLogOut(IPushAdapter iPushAdapter);

    void onPushAdapterRegister(IPushAdapter iPushAdapter);

    void onPushAdapterUnregister(IPushAdapter iPushAdapter);
}
