package com.bytedance.platform.settingsx.api.storage;

/* loaded from: classes4.dex */
public class HashBlockIndex implements IBlockIndex {
    private int blockCount;

    public HashBlockIndex(int i) {
        this.blockCount = i;
    }

    @Override // com.bytedance.platform.settingsx.api.storage.IBlockIndex
    public Integer getBlockIndexByKey(int i) {
        int i2 = this.blockCount;
        int i3 = i % i2;
        if (i3 < 0) {
            i3 += i2;
        }
        return Integer.valueOf(i3 + 1);
    }
}
