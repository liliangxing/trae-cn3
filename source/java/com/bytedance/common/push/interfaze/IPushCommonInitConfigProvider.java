package com.bytedance.common.push.interfaze;

import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.process.cross.IMethodObserver;
import com.ss.android.ug.bus.IUgBusService;
import java.util.List;

/* loaded from: classes3.dex */
public interface IPushCommonInitConfigProvider extends IUgBusService {
    PushCommonConfiguration getConfiguration();

    List<IMethodObserver> getMethodObservers();
}
