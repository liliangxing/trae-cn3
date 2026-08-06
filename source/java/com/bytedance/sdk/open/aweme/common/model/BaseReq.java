package com.bytedance.sdk.open.aweme.common.model;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.a;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;

/* loaded from: classes5.dex */
public abstract class BaseReq {
    public String callerLocalEntry;
    public String callerPackage;
    public String callerVersion;
    public Bundle extras;
    public long sdkLaunchTime;

    public boolean checkArgs() {
        return true;
    }

    public void fromBundle(Bundle bundle) {
        this.callerPackage = bundle.getString("_bytedance_params_type_caller_package");
        this.callerVersion = bundle.getString("__bytedance_base_caller_version");
        this.extras = bundle.getBundle("_bytedance_params_extra");
        this.callerLocalEntry = bundle.getString("_bytedance_params_from_entry");
        this.sdkLaunchTime = bundle.getLong(ParamKeyConstants.BaseParams.SDK_LAUNCH_TIME);
    }

    public String getCallerLocalEntry() {
        return this.callerLocalEntry;
    }

    public String getCallerPackage() {
        return this.callerPackage;
    }

    public String getCallerVersion() {
        return this.callerVersion;
    }

    public abstract int getType();

    public void toBundle(Bundle bundle) {
        bundle.putInt("_bytedance_params_type", getType());
        bundle.putBundle("_bytedance_params_extra", this.extras);
        bundle.putString("_bytedance_params_from_entry", this.callerLocalEntry);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_COMMON_NAME, a.e);
        bundle.putString(ParamKeyConstants.BaseParams.CALLER_BASE_OPEN_SDK_COMMON_VERSION, "5.21.1-rc.0");
        bundle.putLong(ParamKeyConstants.BaseParams.SDK_LAUNCH_TIME, System.currentTimeMillis());
    }
}
