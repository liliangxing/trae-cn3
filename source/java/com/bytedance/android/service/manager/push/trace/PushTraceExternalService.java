package com.bytedance.android.service.manager.push.trace;

import com.bytedance.android.push.service.manager.annotation.ExternalService;

@ExternalService
/* loaded from: classes3.dex */
public interface PushTraceExternalService {
    ITraceScene getTraceScene(PushTraceSceneType pushTraceSceneType);
}
