package com.bytedance.android.service.manager.push.client.intelligence;

import com.bytedance.push.settings.client.intelligence.LocalPushClientIntelligenceSettingsModel;

/* loaded from: classes3.dex */
public interface IClientIntelligenceService {
    boolean curIsHighCtr();

    LocalPushClientIntelligenceSettingsModel getLocalPushClientIntelligenceSettings();
}
