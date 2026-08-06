package com.bytedance.reparo;

import android.app.Application;
import com.bytedance.reparo.core.parse.AbiHelper;
import com.bytedance.reparo.core.parse.AbiHelperImpl;

/* loaded from: classes4.dex */
public abstract class IReparoConfig {
    public boolean autoFailThenSyncMode() {
        return false;
    }

    public boolean autoFetchPatch() {
        return false;
    }

    public abstract boolean enable();

    public abstract String executePatchRequest(int i, String str, byte[] bArr, String str2) throws Exception;

    public abstract String getAppId();

    public abstract Application getApplication();

    public abstract String getChannel();

    public abstract String getDeviceId();

    public abstract String getUpdateVersionCode();

    public abstract boolean isMainProcess();

    public AbiHelper getAbiHelper(Application application) {
        return new AbiHelperImpl(application);
    }
}
