package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.Quaternionf;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IPanoramicVideo;

/* loaded from: classes7.dex */
public class NativePanoramicVideo implements IPanoramicVideo {
    private static final String TAG = "NativePanoramicVideo}";
    private long mNaiveInstance;

    public static native int nativeUpdateQuaternionf(long instance, float x, float y, float z, float w);

    public NativePanoramicVideo(long instance) {
        this.mNaiveInstance = instance;
    }

    public void release() {
        this.mNaiveInstance = 0L;
    }

    @Override // com.ss.bytertc.engine.video.IPanoramicVideo
    public int updateQuaternionf(Quaternionf desc) {
        long j = this.mNaiveInstance;
        if (j == 0) {
            LogUtil.e(TAG, "native Panoramic is invalid, updateQuaternionf failed.");
            return -1;
        }
        return nativeUpdateQuaternionf(j, desc.x, desc.y, desc.z, desc.w);
    }
}
