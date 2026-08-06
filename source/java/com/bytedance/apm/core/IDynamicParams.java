package com.bytedance.apm.core;

import java.util.Map;

/* loaded from: classes3.dex */
public interface IDynamicParams {
    Map<String, String> getCommonParams();

    String getSessionId();

    long getUid();
}
