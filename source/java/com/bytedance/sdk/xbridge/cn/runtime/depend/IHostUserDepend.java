package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Activity;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IHostUserDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0004\u001a\u001b\u001c\u001dJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\b\u0010\u000b\u001a\u00020\fH&J.\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014H&J6\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J.\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014H&¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend;", "", "getAvatarURL", "", "getBoundPhone", "getNickname", "getSecUid", "getUniqueID", "getUserId", "getUserModelExt", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend$UserModelExt;", "hasLogin", "", "login", "", "activity", "Landroid/app/Activity;", "loginStatusCallback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend$ILoginStatusCallback;", "extraData", "", "params", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend$LoginParamsExt;", "logout", "logoutStatusCallback", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend$ILogoutStatusCallback;", "ILoginStatusCallback", "ILogoutStatusCallback", "LoginParamsExt", "UserModelExt", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public interface IHostUserDepend {

    /* compiled from: IHostUserDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend$ILoginStatusCallback;", "", "onFail", "", "onSuccess", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ILoginStatusCallback {
        void onFail();

        void onSuccess();
    }

    /* compiled from: IHostUserDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend$ILogoutStatusCallback;", "", "onFail", "", "onSuccess", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ILogoutStatusCallback {
        void onFail();

        void onSuccess();
    }

    String getAvatarURL();

    String getBoundPhone();

    String getNickname();

    String getSecUid();

    String getUniqueID();

    String getUserId();

    UserModelExt getUserModelExt();

    boolean hasLogin();

    void login(Activity activity, ILoginStatusCallback loginStatusCallback, Map<String, String> extraData);

    void login(Activity activity, ILoginStatusCallback loginStatusCallback, Map<String, String> extraData, LoginParamsExt params);

    void logout(Activity activity, ILogoutStatusCallback logoutStatusCallback, Map<String, String> extraData);

    /* compiled from: IHostUserDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend$UserModelExt;", "", "()V", "shortID", "", "getShortID", "()Ljava/lang/String;", "setShortID", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UserModelExt {
        private String shortID;

        public final String getShortID() {
            return this.shortID;
        }

        public final void setShortID(String str) {
            this.shortID = str;
        }
    }

    /* compiled from: IHostUserDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostUserDepend$LoginParamsExt;", "", "()V", "keepOpen", "", "getKeepOpen", "()Z", "setKeepOpen", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LoginParamsExt {
        private boolean keepOpen = true;

        public final boolean getKeepOpen() {
            return this.keepOpen;
        }

        public final void setKeepOpen(boolean z) {
            this.keepOpen = z;
        }
    }
}
