package com.bytedance.pia.core.api.services;

import android.view.View;
import com.bytedance.pia.core.api.PiaCoreApi;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;

/* loaded from: classes4.dex */
public interface IPiaBridgeService {
    void call(View view, String str, Object obj, IConsumer<Object> iConsumer, IConsumer<PiaMethod.Error> iConsumer2);

    static IPiaBridgeService inst() {
        return (IPiaBridgeService) PiaCoreApi.get(IPiaBridgeService.class);
    }
}
