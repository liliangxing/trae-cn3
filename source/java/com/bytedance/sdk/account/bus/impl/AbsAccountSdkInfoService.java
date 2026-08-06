package com.bytedance.sdk.account.bus.impl;

import android.os.Bundle;
import com.bytedance.sdk.account.bus.IAccountSdkInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsAccountSdkInfoService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/account/bus/impl/AbsAccountSdkInfoService;", "Lcom/bytedance/sdk/account/bus/IAccountSdkInfoService;", "()V", "getInfo", "Landroid/os/Bundle;", "getVersionCode", "", "getVersionName", "", "isLargeThanTargetVersion", "", "targetVersion", "account-sdk-bus_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public class AbsAccountSdkInfoService implements IAccountSdkInfoService {
    @Override // com.bytedance.sdk.account.bus.IAccountSdkInfoService
    public int getVersionCode() {
        return 0;
    }

    @Override // com.bytedance.sdk.account.bus.IAccountSdkInfoService
    public String getVersionName() {
        return "";
    }

    @Override // com.bytedance.sdk.account.bus.IAccountSdkInfoService
    public boolean isLargeThanTargetVersion(String targetVersion) {
        Intrinsics.checkParameterIsNotNull(targetVersion, "targetVersion");
        return false;
    }

    @Override // com.bytedance.sdk.account.bus.IAccountSdkInfoService
    public Bundle getInfo() {
        return new Bundle();
    }
}
