package com.bytedance.sync;

import com.ss.android.ug.bus.IUgBusService;
import java.util.Map;

/* loaded from: classes5.dex */
public interface ICommonParamProvider extends IUgBusService {
    Map<String, String> getCommonParams();
}
