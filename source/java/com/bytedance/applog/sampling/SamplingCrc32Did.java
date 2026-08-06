package com.bytedance.applog.sampling;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.CRC32;

/* loaded from: classes3.dex */
public class SamplingCrc32Did extends AbsSamplingStrategy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SamplingCrc32Did(int i, Set<String> set, Map<String, List<Set<String>>> map, Map<String, List<Map<String, Object>>> map2) {
        super(i, set, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.sampling.AbsSamplingStrategy
    public boolean isHitSamplingDrop(AbsSamplingUser absSamplingUser) {
        int checkSamplingRate = checkSamplingRate();
        if (checkSamplingRate < 0) {
            return true;
        }
        if (checkSamplingRate > 0 || absSamplingUser == null || TextUtils.isEmpty(absSamplingUser.getDeviceIdCallback())) {
            return false;
        }
        CRC32 crc32 = new CRC32();
        crc32.update(absSamplingUser.getDeviceIdCallback().getBytes());
        return crc32.getValue() % 10000 >= ((long) this.mSamplingRate);
    }
}
