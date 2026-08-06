package com.bytedance.applog.sampling;

import android.text.TextUtils;
import com.bytedance.applog.sampling.util.TeaHashSamplingUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class SamplingTeaHashUtUid extends AbsSamplingStrategy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SamplingTeaHashUtUid(int i, Set<String> set, Map<String, List<Set<String>>> map, Map<String, List<Map<String, Object>>> map2) {
        super(i, set, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.sampling.AbsSamplingStrategy
    public boolean isHitSamplingDrop(AbsSamplingUser absSamplingUser) {
        int checkSamplingRate = checkSamplingRate();
        if (checkSamplingRate < 0) {
            return true;
        }
        if (checkSamplingRate > 0 || absSamplingUser == null) {
            return false;
        }
        if (TextUtils.isEmpty(absSamplingUser.getAppIdCallback())) {
            return false;
        }
        if (TextUtils.isEmpty(absSamplingUser.getUserIdCallback())) {
            return false;
        }
        if (TextUtils.isEmpty(absSamplingUser.getUserTypeCallback())) {
            return false;
        }
        return !TeaHashSamplingUtils.hitSampling(r0 + Constants.COLON_SEPARATOR + r7 + "_" + r3, 10000L, this.mSamplingRate);
    }
}
