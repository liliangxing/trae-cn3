package com.bytedance.sdk.account.bus;

import android.os.Bundle;
import kotlin.Metadata;

/* compiled from: IAccountSdkInfoService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/account/bus/IAccountSdkInfoService;", "Lcom/bytedance/sdk/account/bus/IAccountSdkService;", "getInfo", "Landroid/os/Bundle;", "getVersionCode", "", "getVersionName", "", "isLargeThanTargetVersion", "", "targetVersion", "Companion", "account-sdk-bus_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public interface IAccountSdkInfoService extends IAccountSdkService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String NAME = "account_sdk_info";
    public static final String VERSION_CODE = "version_code";
    public static final String VERSION_NAME = "version_name";

    Bundle getInfo();

    int getVersionCode();

    String getVersionName();

    boolean isLargeThanTargetVersion(String targetVersion);

    /* compiled from: IAccountSdkInfoService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/sdk/account/bus/IAccountSdkInfoService$Companion;", "", "()V", "NAME", "", "VERSION_CODE", "VERSION_NAME", "account-sdk-bus_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String NAME = "account_sdk_info";
        public static final String VERSION_CODE = "version_code";
        public static final String VERSION_NAME = "version_name";

        private Companion() {
        }
    }
}
