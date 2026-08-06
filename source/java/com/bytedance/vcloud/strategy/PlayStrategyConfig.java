package com.bytedance.vcloud.strategy;

import android.util.Log;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class PlayStrategyConfig implements IPlayStrategyRef {
    private static final String TAG = "VCStrategy.Config";
    private long mManagerHandle;
    private String mTraceId;

    private native void _configFloatOptionToStrategy(long j, String str, int i, float f);

    private native void _configIntOptionToStrategy(long j, String str, int i, int i2);

    private native void _configStringOptionToStrategy(long j, String str, int i, String str2, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlayStrategyConfig(String str, long j) {
        this.mTraceId = str;
        this.mManagerHandle = j;
    }

    @Override // com.bytedance.vcloud.strategy.IPlayStrategyRef
    public void configFloatOptionToStrategy(int i, float f) {
        try {
            long j = this.mManagerHandle;
            if (j > 0) {
                _configFloatOptionToStrategy(j, this.mTraceId, i, f);
            }
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    @Override // com.bytedance.vcloud.strategy.IPlayStrategyRef
    public void configJsonOptionToStrategy(int i, JSONObject jSONObject) {
        try {
            long j = this.mManagerHandle;
            if (j > 0) {
                _configStringOptionToStrategy(j, this.mTraceId, i, jSONObject.toString(), true);
            }
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    @Override // com.bytedance.vcloud.strategy.IPlayStrategyRef
    public void configIntOptionToStrategy(int i, int i2) {
        try {
            long j = this.mManagerHandle;
            if (j > 0) {
                _configIntOptionToStrategy(j, this.mTraceId, i, i2);
            }
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    @Override // com.bytedance.vcloud.strategy.IPlayStrategyRef
    public void configStringOptionToStrategy(int i, String str) {
        try {
            long j = this.mManagerHandle;
            if (j > 0) {
                _configStringOptionToStrategy(j, this.mTraceId, i, str, false);
            }
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }
}
