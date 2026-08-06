package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class NativeMemoryChunkPool extends MemoryChunkPool {
    public NativeMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.memory.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    /* renamed from: alloc */
    public MemoryChunk alloc2(int i) {
        return new NativeMemoryChunk(i);
    }
}
