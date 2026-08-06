package com.bytedance.sync.interfaze;

import android.content.Context;
import com.ss.android.ug.bus.IUgBusService;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface ICommonService extends IUgBusService {
    boolean isNetWorkAvailable(Context context);

    void onNonMainEvent(String str, JSONObject jSONObject);
}
