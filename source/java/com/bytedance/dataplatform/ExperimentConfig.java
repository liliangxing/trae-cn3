package com.bytedance.dataplatform;

/* loaded from: classes3.dex */
public abstract class ExperimentConfig<T> {
    public T getDefault() {
        return null;
    }

    public boolean isBind2User() {
        return false;
    }

    public boolean isEnable() {
        return true;
    }

    public boolean isSticky() {
        return false;
    }
}
