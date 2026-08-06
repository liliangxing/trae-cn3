package com.bytedance.crash;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class CrashCallbackEx {
    public abstract void onCrash(int i, String str, CrashType crashType, long j, long j2, String str2, String str3, JSONObject jSONObject, List<String> list);
}
