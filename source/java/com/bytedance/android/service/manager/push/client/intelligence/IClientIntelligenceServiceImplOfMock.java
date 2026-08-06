package com.bytedance.android.service.manager.push.client.intelligence;

import android.util.Log;
import com.bytedance.push.settings.client.intelligence.LocalPushClientIntelligenceSettingsModel;

/* loaded from: classes3.dex */
public class IClientIntelligenceServiceImplOfMock implements IClientIntelligenceService {
    @Override // com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService
    public LocalPushClientIntelligenceSettingsModel getLocalPushClientIntelligenceSettings() {
        Log.w("IClientIntelligenceService", "cur getLocalPushClientIntelligenceSettings method is empty impl in IClientIntelligenceServiceImplOfMockClass");
        return null;
    }

    @Override // com.bytedance.android.service.manager.push.client.intelligence.IClientIntelligenceService
    public boolean curIsHighCtr() {
        Log.w("IClientIntelligenceService", "cur curIsHighCtr method is empty impl in IClientIntelligenceServiceImplOfMockClass");
        return false;
    }
}
