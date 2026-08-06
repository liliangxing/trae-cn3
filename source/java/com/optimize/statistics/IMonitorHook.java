package com.optimize.statistics;

import android.util.Pair;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IMonitorHook {
    Pair<Boolean, Map<String, Object>> onMonitorCompleted(ImageRequest imageRequest, Object obj, String str, JSONObject jSONObject, boolean z);
}
