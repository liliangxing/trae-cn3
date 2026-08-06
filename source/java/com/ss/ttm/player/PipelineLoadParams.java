package com.ss.ttm.player;

import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class PipelineLoadParams {
    public static final int BlockStartDecoder = 2;
    public static final int BlockStartFormater = 1;
    public static final int BlockStartOutlet = 3;
    private final Bundle mBundle = new Bundle();

    public PipelineLoadParams enableBlocker(int key) {
        this.mBundle.putInt(String.valueOf(key), 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toJsonString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(String.valueOf(1), this.mBundle.getInt(String.valueOf(1), 0));
            jSONObject.put(String.valueOf(2), this.mBundle.getInt(String.valueOf(2), 0));
            jSONObject.put(String.valueOf(3), this.mBundle.getInt(String.valueOf(3), 0));
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
