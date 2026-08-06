package com.ss.android.deviceregister;

import android.content.Context;
import com.ss.android.common.AppContext;

/* loaded from: classes7.dex */
public interface DeviceRegisterContext extends AppContext {
    @Override // com.ss.android.common.AppContext
    int getAid();

    @Override // com.ss.android.common.AppContext
    String getAppName();

    @Override // com.ss.android.common.AppContext
    Context getContext();

    @Override // com.ss.android.common.AppContext
    int getManifestVersionCode();

    @Override // com.ss.android.common.AppContext
    String getTweakedChannel();

    @Override // com.ss.android.common.AppContext
    int getUpdateVersionCode();

    @Override // com.ss.android.common.AppContext
    String getVersion();

    @Override // com.ss.android.common.AppContext
    int getVersionCode();
}
