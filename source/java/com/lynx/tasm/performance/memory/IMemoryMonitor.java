package com.lynx.tasm.performance.memory;

import java.util.Map;

/* loaded from: classes7.dex */
public interface IMemoryMonitor {
    void allocateMemory(IMemoryRecordBuilder iMemoryRecordBuilder);

    void deallocateMemory(IMemoryRecordBuilder iMemoryRecordBuilder);

    void updateMemoryUsage(IMemoryRecordBuilder iMemoryRecordBuilder);

    void updateMemoryUsage(Map<String, MemoryRecord> map);
}
