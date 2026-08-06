package com.bytedance.crash;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface IUserCrashInfoCallback {
    Map<? extends String, ? extends String> getCrashInfo(CrashType crashType, JSONObject jSONObject);
}
