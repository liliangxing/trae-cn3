package com.bytedance.applog.sampling;

import android.text.TextUtils;
import com.bytedance.applog.sampling.util.TeaHashSamplingUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class SamplingTeaHashDid extends AbsSamplingStrategy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SamplingTeaHashDid(int i, Set<String> set, Map<String, List<Set<String>>> map, Map<String, List<Map<String, Object>>> map2) {
        super(i, set, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.sampling.AbsSamplingStrategy
    public boolean isHitSamplingDrop(AbsSamplingUser absSamplingUser) {
        int checkSamplingRate = checkSamplingRate();
        if (checkSamplingRate < 0) {
            return true;
        }
        if (checkSamplingRate > 0 || absSamplingUser == null || TextUtils.isEmpty(absSamplingUser.getAppIdCallback()) || TextUtils.isEmpty(absSamplingUser.getDeviceIdCallback())) {
            return false;
        }
        return !TeaHashSamplingUtils.hitSampling(absSamplingUser.getAppIdCallback() + Constants.COLON_SEPARATOR + absSamplingUser.getDeviceIdCallback(), 10000L, this.mSamplingRate);
    }
}
