package com.bytedance.common.support.service;

import java.util.Map;

/* loaded from: classes3.dex */
public interface IPushCommonParamService {
    Map<String, String> getHttpCommonParams();

    Map<String, String> getHttpCommonParams(Map<String, String> map);

    void setProcessStartReason(String str, String str2);
}
