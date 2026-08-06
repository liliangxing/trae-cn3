package com.bytedance.push.interfaze;

import com.bytedance.push.PushNotificationMessage;

/* loaded from: classes4.dex */
public interface IMessageSpreadOutService {
    boolean allowSpreadOutMessage();

    void handleMessageNotBeenShown();

    boolean spreadOut(PushNotificationMessage pushNotificationMessage);
}
