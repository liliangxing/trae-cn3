package com.bytedance.push.interfaze;

import com.bytedance.push.PushNotificationMessage;
import com.bytedance.push.client.intelligence.ClientIntelligenceShowResult;
import com.bytedance.push.settings.client.intelligence.ClientIntelligenceSettingsModel;

/* loaded from: classes4.dex */
public interface IClientIntelligenceService extends com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService {
    boolean curIsLowCtr();

    boolean enableClientIntelligencePushShow();

    ClientIntelligenceSettingsModel getClientIntelligenceSettings();

    void onPushStart();

    ClientIntelligenceShowResult showPushWithClientIntelligenceStrategy(PushNotificationMessage pushNotificationMessage, boolean z);
}
