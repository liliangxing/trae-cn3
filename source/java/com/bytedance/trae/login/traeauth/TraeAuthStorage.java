package com.bytedance.trae.login.traeauth;

import com.bytedance.keva.Keva;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.trae.keva.KevaRepos;
import com.bytedance.trae.login.user.UserInfo;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthStorage.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u0010\u001f\u001a\u00020\u0005J\u001d\u0010 \u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\"J\u0006\u0010&\u001a\u00020'J\u0006\u0010(\u001a\u00020\u001dJ\u001d\u0010)\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010#J\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\"J\u000e\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\"J\u0006\u0010.\u001a\u00020\"J\u000e\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001bJ\b\u00101\u001a\u0004\u0018\u00010\u001bJ\u0006\u00102\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u00104\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005J\u0006\u00106\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u00020\u0005J\u0006\u00109\u001a\u00020\u0005J\u0006\u0010:\u001a\u00020\u001dJ\u0006\u0010;\u001a\u00020'J\u0016\u0010<\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010>\u001a\u00020\"J\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020\"J\u0006\u0010A\u001a\u00020\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;", "", "<init>", "()V", "TAG", "", "KEY_CLOUDIDE_SESSION", "KEY_REFRESH_TOKEN", "KEY_REFRESH_EXPIRE_AT", "KEY_JWT_TOKEN", "KEY_JWT_EXPIRE_AT", "KEY_USER_INFO", "KEY_LAST_EXCHANGE_SUCCESS_AT", "KEY_USER_REGION", "KEY_UPLOAD_REGION", "KEY_LOGIN_PLATFORM", "KEY_LOGIN_BINDING_REQUIRED", "KEY_LOGIN_DEVICE_CALLED", "KEY_INTRANET_SSO_SEEN", "KEY_BYTECLOUD_OAUTH_STATE", "KEY_BYTECLOUD_OAUTH_STATE_TIMESTAMP", "KEY_APP_UPGRADE", "repo", "Lcom/bytedance/keva/Keva;", "gson", "Lcom/google/gson/Gson;", "cachedUserInfo", "Lcom/bytedance/trae/login/user/UserInfo;", "saveCloudideSession", "", "value", "getCloudideSession", "saveRefreshToken", "expireAt", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "getRefreshToken", "getRefreshExpireAt", "isFirstAppUpgrade", "", "clearFirstAppUpgrade", "saveJwtToken", "getJwtToken", "getJwtExpireAt", "saveLastExchangeSuccessAt", "timestampSeconds", "getLastExchangeSuccessAt", "saveUserInfo", "userInfo", "getUserInfo", "clear", "saveUserRegion", "getUserRegion", "saveUploadRegion", "getUploadRegion", "saveLoginPlatform", "platform", "getLoginPlatform", "markIntranetSsoSeen", "hasIntranetSsoSeen", "saveBytecloudOAuthState", "state", ReportConst.KEY_TIMESTAMP, "getBytecloudOAuthState", "getBytecloudOAuthStateTimestamp", "clearBytecloudOAuthState", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TraeAuthStorage {
    private static final String KEY_APP_UPGRADE = "trae_app_upgrade";
    private static final String KEY_BYTECLOUD_OAUTH_STATE = "trae_bytecloud_oauth_state";
    private static final String KEY_BYTECLOUD_OAUTH_STATE_TIMESTAMP = "trae_bytecloud_oauth_state_timestamp";
    private static final String KEY_CLOUDIDE_SESSION = "trae_cloudide_session";
    private static final String KEY_INTRANET_SSO_SEEN = "trae_intranet_sso_seen";
    private static final String KEY_JWT_EXPIRE_AT = "trae_jwt_expire_at";
    private static final String KEY_JWT_TOKEN = "trae_jwt_token";
    private static final String KEY_LAST_EXCHANGE_SUCCESS_AT = "trae_last_exchange_success_at";
    private static final String KEY_LOGIN_BINDING_REQUIRED = "trae_login_binding_required";
    private static final String KEY_LOGIN_DEVICE_CALLED = "trae_login_device_called";
    private static final String KEY_LOGIN_PLATFORM = "trae_login_platform";
    private static final String KEY_REFRESH_EXPIRE_AT = "trae_refresh_expire_at";
    private static final String KEY_REFRESH_TOKEN = "trae_refresh_token";
    private static final String KEY_UPLOAD_REGION = "trae_upload_region";
    private static final String KEY_USER_INFO = "trae_user_info";
    private static final String KEY_USER_REGION = "trae_user_region";
    private static final String TAG = "TraeAuthStorage";
    private static UserInfo cachedUserInfo;
    public static final TraeAuthStorage INSTANCE = new TraeAuthStorage();
    private static final Keva repo = KevaRepos.INSTANCE.getDefaultRepo();
    private static final Gson gson = new Gson();

    private TraeAuthStorage() {
    }

    public final void saveCloudideSession(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        repo.storeString(KEY_CLOUDIDE_SESSION, value);
        clearFirstAppUpgrade();
    }

    public final String getCloudideSession() {
        String string = repo.getString(KEY_CLOUDIDE_SESSION, "");
        return string == null ? "" : string;
    }

    public final void saveRefreshToken(String value, Long expireAt) {
        Intrinsics.checkNotNullParameter(value, "value");
        Keva keva = repo;
        keva.storeString(KEY_REFRESH_TOKEN, value);
        if (expireAt != null) {
            keva.storeLong(KEY_REFRESH_EXPIRE_AT, expireAt.longValue());
        }
    }

    public final String getRefreshToken() {
        String string = repo.getString(KEY_REFRESH_TOKEN, "");
        return string == null ? "" : string;
    }

    public final long getRefreshExpireAt() {
        return repo.getLong(KEY_REFRESH_EXPIRE_AT, 0L);
    }

    public final boolean isFirstAppUpgrade() {
        return repo.getBoolean(KEY_APP_UPGRADE, true);
    }

    public final void clearFirstAppUpgrade() {
        repo.storeBoolean(KEY_APP_UPGRADE, false);
    }

    public final void saveJwtToken(String value, Long expireAt) {
        Intrinsics.checkNotNullParameter(value, "value");
        Keva keva = repo;
        keva.storeString(KEY_JWT_TOKEN, value);
        if (expireAt != null) {
            keva.storeLong(KEY_JWT_EXPIRE_AT, expireAt.longValue());
        }
    }

    public final String getJwtToken() {
        String string = repo.getString(KEY_JWT_TOKEN, "");
        return string == null ? "" : string;
    }

    public final long getJwtExpireAt() {
        return repo.getLong(KEY_JWT_EXPIRE_AT, 0L);
    }

    public final void saveLastExchangeSuccessAt(long timestampSeconds) {
        repo.storeLong(KEY_LAST_EXCHANGE_SUCCESS_AT, timestampSeconds);
    }

    public final long getLastExchangeSuccessAt() {
        return repo.getLong(KEY_LAST_EXCHANGE_SUCCESS_AT, 0L);
    }

    public final void saveUserInfo(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        cachedUserInfo = userInfo;
        FLogger.INSTANCE.mo428i(TAG, "saveUserInfo: " + userInfo);
        repo.storeString(KEY_USER_INFO, gson.toJson(userInfo));
    }

    public final UserInfo getUserInfo() {
        Object obj;
        UserInfo userInfo = cachedUserInfo;
        if (userInfo != null) {
            return userInfo;
        }
        String string = repo.getString(KEY_USER_INFO, null);
        if (string == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            TraeAuthStorage traeAuthStorage = this;
            UserInfo userInfo2 = (UserInfo) gson.fromJson(string, UserInfo.class);
            if (userInfo2 != null) {
                cachedUserInfo = userInfo2;
            } else {
                userInfo2 = null;
            }
            obj = Result.constructor-impl(userInfo2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (UserInfo) (Result.isFailure-impl(obj) ? null : obj);
    }

    public final void clear() {
        cachedUserInfo = null;
        Keva keva = repo;
        keva.storeString(KEY_CLOUDIDE_SESSION, "");
        keva.storeString(KEY_REFRESH_TOKEN, "");
        keva.storeLong(KEY_REFRESH_EXPIRE_AT, 0L);
        keva.storeString(KEY_JWT_TOKEN, "");
        keva.storeLong(KEY_JWT_EXPIRE_AT, 0L);
        keva.storeLong(KEY_LAST_EXCHANGE_SUCCESS_AT, 0L);
        keva.storeString(KEY_USER_INFO, "{}");
        keva.storeString(KEY_USER_REGION, "");
        keva.storeString(KEY_UPLOAD_REGION, "");
        keva.storeString(KEY_LOGIN_PLATFORM, "");
        clearBytecloudOAuthState();
    }

    public final void saveUserRegion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        repo.storeString(KEY_USER_REGION, value);
    }

    public final String getUserRegion() {
        String string = repo.getString(KEY_USER_REGION, "");
        return string == null ? "" : string;
    }

    public final void saveUploadRegion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        repo.storeString(KEY_UPLOAD_REGION, value);
    }

    public final String getUploadRegion() {
        String string = repo.getString(KEY_UPLOAD_REGION, "");
        return string == null ? "" : string;
    }

    public final void saveLoginPlatform(String platform) {
        Intrinsics.checkNotNullParameter(platform, "platform");
        repo.storeString(KEY_LOGIN_PLATFORM, platform);
    }

    public final String getLoginPlatform() {
        String string = repo.getString(KEY_LOGIN_PLATFORM, "");
        return string == null ? "" : string;
    }

    public final void markIntranetSsoSeen() {
        repo.storeBoolean(KEY_INTRANET_SSO_SEEN, true);
    }

    public final boolean hasIntranetSsoSeen() {
        return repo.getBoolean(KEY_INTRANET_SSO_SEEN, false);
    }

    public final void saveBytecloudOAuthState(String state, long timestamp) {
        Intrinsics.checkNotNullParameter(state, "state");
        Keva keva = repo;
        keva.storeString(KEY_BYTECLOUD_OAUTH_STATE, state);
        keva.storeLong(KEY_BYTECLOUD_OAUTH_STATE_TIMESTAMP, timestamp);
    }

    public final String getBytecloudOAuthState() {
        String string = repo.getString(KEY_BYTECLOUD_OAUTH_STATE, "");
        return string == null ? "" : string;
    }

    public final long getBytecloudOAuthStateTimestamp() {
        return repo.getLong(KEY_BYTECLOUD_OAUTH_STATE_TIMESTAMP, 0L);
    }

    public final void clearBytecloudOAuthState() {
        Keva keva = repo;
        keva.storeString(KEY_BYTECLOUD_OAUTH_STATE, "");
        keva.storeLong(KEY_BYTECLOUD_OAUTH_STATE_TIMESTAMP, 0L);
    }
}
