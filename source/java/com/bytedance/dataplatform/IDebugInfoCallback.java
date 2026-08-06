package com.bytedance.dataplatform;

import android.util.Pair;
import java.util.List;

/* loaded from: classes3.dex */
public interface IDebugInfoCallback {
    void debugCallback(String key, Object value, String from, String vid, List<Pair<String, Float>> clientVidlist);
}
