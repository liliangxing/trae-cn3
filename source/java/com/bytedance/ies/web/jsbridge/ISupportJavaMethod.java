package com.bytedance.ies.web.jsbridge;

import java.util.Map;

/* loaded from: classes4.dex */
public interface ISupportJavaMethod extends IJavaMethod {
    public static final String BRIDGE_TYPE = "bridge_type";

    Map<String, Object> getMetaInfo();
}
