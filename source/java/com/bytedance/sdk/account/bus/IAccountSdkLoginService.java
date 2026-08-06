package com.bytedance.sdk.account.bus;

import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;

/* compiled from: IAccountSdkLoginService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \b2\u00020\u0001:\u0002\b\tJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/sdk/account/bus/IAccountSdkLoginService;", "Lcom/bytedance/sdk/account/bus/IAccountSdkService;", "login", "", "scene", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/sdk/account/bus/IAccountSdkLoginService$LoginCallback;", "Companion", "LoginCallback", "account-sdk-bus_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public interface IAccountSdkLoginService extends IAccountSdkService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String NAME = "account_sdk_login";

    /* compiled from: IAccountSdkLoginService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/sdk/account/bus/IAccountSdkLoginService$LoginCallback;", "", JsCallParser.VALUE_CALLBACK, "", "loginSuccess", "", "account-sdk-bus_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public interface LoginCallback {
        void callback(boolean loginSuccess);
    }

    void login(String scene, LoginCallback callback);

    /* compiled from: IAccountSdkLoginService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/account/bus/IAccountSdkLoginService$Companion;", "", "()V", "NAME", "", "account-sdk-bus_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String NAME = "account_sdk_login";

        private Companion() {
        }
    }
}
