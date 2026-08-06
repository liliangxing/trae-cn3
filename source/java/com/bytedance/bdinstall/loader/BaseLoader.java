package com.bytedance.bdinstall.loader;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class BaseLoader {
    private static final String UTF_8 = "UTF-8";
    boolean mOptional;
    boolean mReady;
    boolean mShouldUpdate;
    boolean syncFromSub;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean doLoad(JSONObject jSONObject) throws JSONException, SecurityException;

    public void remove(JSONObject jSONObject) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLoader(boolean z, boolean z2) {
        this.mOptional = z;
        this.mShouldUpdate = z2;
        this.syncFromSub = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseLoader(boolean z, boolean z2, boolean z3) {
        this.mOptional = z;
        this.mShouldUpdate = z2;
        this.syncFromSub = z3;
    }
}
