package com.bytedance.apm.maps;

import java.util.Map;

/* loaded from: classes3.dex */
public class ApmMapsInfoApi {
    private static MapInfoCallback mmapInfoCallBack;

    /* loaded from: classes3.dex */
    public interface MapInfoCallback {
        void addInfo(Map<Object, Object> map);
    }

    public static void addMapInfo(Map<Object, Object> map) {
        MapInfoCallback mapInfoCallback = mmapInfoCallBack;
        if (mapInfoCallback != null) {
            try {
                mapInfoCallback.addInfo(map);
            } catch (Throwable unused) {
            }
        }
    }

    public static void SetCallback(MapInfoCallback mapInfoCallback) {
        if (mapInfoCallback != null) {
            mmapInfoCallBack = mapInfoCallback;
        }
    }
}
