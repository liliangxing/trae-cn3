package com.bytedance.applog.sampling;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class SamplingModDid extends AbsSamplingStrategy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SamplingModDid(int i, Set<String> set, Map<String, List<Set<String>>> map, Map<String, List<Map<String, Object>>> map2) {
        super(i, set, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.sampling.AbsSamplingStrategy
    public boolean isHitSamplingDrop(AbsSamplingUser absSamplingUser) {
        int checkSamplingRate = checkSamplingRate();
        if (checkSamplingRate < 0) {
            return true;
        }
        if (checkSamplingRate <= 0 && absSamplingUser != null && !TextUtils.isEmpty(absSamplingUser.getDeviceIdCallback())) {
            try {
                return Long.parseLong(absSamplingUser.getDeviceIdCallback()) % 10000 >= ((long) this.mSamplingRate);
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }
}
