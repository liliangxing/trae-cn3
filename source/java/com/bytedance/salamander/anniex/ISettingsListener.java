package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: AnniexMonitorSettingsISettingsListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/salamander/anniex/ISettingsListener;", "", "onSettingsReady", "", "settings", "Lorg/json/JSONObject;", "Lcom/bytedance/salamander/anniex/AnnieXJSONObject;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISettingsListener {
    void onSettingsReady(JSONObject settings);
}
