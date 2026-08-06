package com.bytedance.bdinstall.service;

import com.bytedance.bdinstall.nu.Action;
import java.util.Map;

/* loaded from: classes3.dex */
public interface NUApi {
    String getCustomParam(String str, String str2);

    boolean isAutoMode();

    boolean isSupport();

    void mapCustomParams(Map<String, String> map);

    Action setNUMode(boolean z);
}
