package com.bytedance.reparo.core.load;

import com.bytedance.reparo.core.PatchConfiguration;
import com.bytedance.reparo.core.exception.PatchLoadException;
import com.bytedance.reparo.core.patch.BasePatch;
import com.bytedance.reparo.core.patch.DurationMetric;

/* loaded from: classes4.dex */
public abstract class BaseLoader<T extends BasePatch> {
    protected PatchConfiguration configuration;

    public abstract void load(T t, AsyncLoadResult asyncLoadResult, DurationMetric durationMetric) throws PatchLoadException;

    public abstract void offline();

    public BaseLoader(PatchConfiguration patchConfiguration) {
        this.configuration = patchConfiguration;
    }
}
