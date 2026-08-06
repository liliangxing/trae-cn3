package com.bytedance.apm6.memory;

import com.bytedance.apm6.memory.listener.IMemoryDataListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApmMemoryManager {
    private static volatile ApmMemoryManager singleton;

    private ApmMemoryManager() {
    }

    public static ApmMemoryManager getInstance() {
        if (singleton == null) {
            synchronized (ApmMemoryManager.class) {
                if (singleton == null) {
                    singleton = new ApmMemoryManager();
                }
            }
        }
        return singleton;
    }

    public void addMemoryDataListener(IMemoryDataListener iMemoryDataListener) {
        MemoryCollector.getInstance().addMemoryCallBackListener(iMemoryDataListener);
    }

    public void removeMemoryDataListener(IMemoryDataListener iMemoryDataListener) {
        MemoryCollector.getInstance().removeMemoryCallBackListener(iMemoryDataListener);
    }
}
