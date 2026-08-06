package com.bytedance.sync.v4.intf;

import com.ss.android.ug.bus.IUgBusService;
import java.util.Set;

/* loaded from: classes5.dex */
public interface IDataPatchService extends IUgBusService {
    void notifyPatch(Set<Long> set);
}
