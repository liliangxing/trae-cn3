package com.xiaomi;

import com.bytedance.push.settings.ILocalSettings;
import com.bytedance.push.settings.annotation.Settings;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;

@Settings(storageKey = PushMultiProcessSharedProvider.SP_CONFIG_NAME, supportMultiProcess = true)
/* loaded from: classes7.dex */
public interface MiPushSettings extends ILocalSettings {
    boolean hasUpgradeTo3616();

    void setUpgradeTo3616(boolean z);
}
