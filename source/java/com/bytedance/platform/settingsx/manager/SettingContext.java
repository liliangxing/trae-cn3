package com.bytedance.platform.settingsx.manager;

import com.bytedance.platform.settingsx.storage.Storage;

/* loaded from: classes4.dex */
public class SettingContext {
    public final boolean isReflect;
    public final Storage storage;

    public SettingContext(Storage storage, boolean z) {
        this.storage = storage;
        this.isReflect = z;
    }
}
