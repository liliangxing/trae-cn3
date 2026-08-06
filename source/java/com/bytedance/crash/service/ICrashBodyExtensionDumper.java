package com.bytedance.crash.service;

import com.bytedance.crash.CrashType;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface ICrashBodyExtensionDumper {
    void dump(File file);

    JSONObject load(CrashType crashType);

    void load(JSONObject jSONObject, JSONObject jSONObject2, File file);
}
