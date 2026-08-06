package com.bytedance.applog.monitor.v3;

import android.content.Context;
import android.os.HandlerThread;
import android.util.Pair;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public interface IV3Monitor<T> {
    void appendMapToJSONArray(Map<String, T> map, JSONArray jSONArray);

    Pair<Map<String, T>, Long> getMapBySize(long j);

    void init(Context context, HandlerThread handlerThread, String str);

    void initWithDisabled();

    void removeByMap(Map<String, T> map);
}
