package com.bytedance.sync.p005v4.intf;

import com.ss.android.ug.bus.IUgBusService;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IDataPatchService extends IUgBusService {
    void notifyPatch(Set<Long> set);
}
