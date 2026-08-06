package com.bytedance.android.service.manager.push.client.intelligence;

import android.util.Log;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IClientFeatureServiceImplOfMock implements IClientFeatureService {
    @Override // com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService
    public void getClientFeatureAsync(IFeatureCallBack iFeatureCallBack, String str) {
    }

    @Override // com.bytedance.android.service.manager.push.client.intelligence.IClientFeatureService
    public JSONObject getClientFeatureSync(String str) {
        Log.w("IClientFeatureService", "cur getClientFeatureSync method is empty impl in IClientFeatureServiceImplOfMockClass");
        return null;
    }
}
