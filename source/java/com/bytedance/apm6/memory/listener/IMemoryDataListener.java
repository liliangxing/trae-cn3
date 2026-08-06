package com.bytedance.apm6.memory.listener;

import com.bytedance.apm6.memory.bean.MemoryCollectInfo;

/* loaded from: classes3.dex */
public interface IMemoryDataListener {
    void onMemoryCallback(MemoryCollectInfo memoryCollectInfo);
}
