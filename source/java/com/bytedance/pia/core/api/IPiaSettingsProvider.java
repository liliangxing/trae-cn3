package com.bytedance.pia.core.api;

import com.bytedance.pia.core.setting.PIAConfig;
import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public interface IPiaSettingsProvider {
    PIAConfig getPIAConfig();

    <T> T getValue(String str, Type type, T t);
}
