package com.bytedance.applog.sampling;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* loaded from: classes3.dex */
public class SamplingRandom extends AbsSamplingStrategy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SamplingRandom(int i, Set<String> set, Map<String, List<Set<String>>> map, Map<String, List<Map<String, Object>>> map2) {
        super(i, set, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.applog.sampling.AbsSamplingStrategy
    public boolean isHitSamplingDrop(AbsSamplingUser absSamplingUser) {
        int checkSamplingRate = checkSamplingRate();
        if (checkSamplingRate < 0) {
            return true;
        }
        return checkSamplingRate <= 0 && new Random().nextInt(10000) >= this.mSamplingRate;
    }
}
