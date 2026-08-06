package com.bytedance.trae.login.api;

import com.bytedance.sdk.account.save.database.DBData;
import com.lynx.tasm.LynxError;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IAccountCallback.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J-\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000fJy\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001aH&¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/login/api/IAccountCallback;", "", "onDeviceOverLimit", "", "token", "", "extras", "", "Ljava/lang/Object;", "onSuccess", "platform", "Lcom/bytedance/trae/login/api/LoginPlatform;", "businessScene", "isNewUserLogin", "", "(Lcom/bytedance/trae/login/api/LoginPlatform;Ljava/lang/String;Ljava/lang/Boolean;)V", "onFailed", "errorCode", "", "errorMessage", LynxError.LYNX_THROWABLE, "", "profileKey", "originErrorCode", "originErrorMessage", DBData.FIELD_EXT, "", "(Lcom/bytedance/trae/login/api/LoginPlatform;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;)V", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IAccountCallback {
    void onDeviceOverLimit(String token, Map<String, ? extends Object> extras);

    void onFailed(LoginPlatform platform, int errorCode, String errorMessage, String businessScene, Throwable throwable, String profileKey, Integer originErrorCode, String originErrorMessage, Map<String, Object> ext);

    void onSuccess(LoginPlatform platform, String businessScene, Boolean isNewUserLogin);

    /* compiled from: IAccountCallback.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void onSuccess$default(IAccountCallback iAccountCallback, LoginPlatform loginPlatform, String str, Boolean bool, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onSuccess");
            }
            if ((i & 4) != 0) {
                bool = false;
            }
            iAccountCallback.onSuccess(loginPlatform, str, bool);
        }

        public static /* synthetic */ void onFailed$default(IAccountCallback iAccountCallback, LoginPlatform loginPlatform, int i, String str, String str2, Throwable th, String str3, Integer num, String str4, Map map, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailed");
            }
            iAccountCallback.onFailed(loginPlatform, i, str, str2, th, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : str4, (i2 & 256) != 0 ? null : map);
        }
    }
}
