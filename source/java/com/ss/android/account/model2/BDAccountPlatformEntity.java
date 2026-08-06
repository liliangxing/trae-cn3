package com.ss.android.account.model2;

import android.text.TextUtils;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.settings.AuthExpirationConfigManager;
import com.bytedance.sdk.account.utils.Utils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDAccountPlatformEntity implements Cloneable {
    public static String[] ALL_PLATFORM = {"mobile", "email", "google", "facebook", "twitter", "instagram", "line", "kakaotalk", "vk", "tiktok"};
    public static final String PLAT_NAME_EMAIL = "email";
    public static final String PLAT_NAME_FB = "facebook";
    public static final String PLAT_NAME_GOOGLE = "google";
    public static final String PLAT_NAME_INSTAGRAM = "instagram";
    public static final String PLAT_NAME_KAKAO = "kakaotalk";
    public static final String PLAT_NAME_LINE = "line";
    public static final String PLAT_NAME_MOBILE = "mobile";
    public static final String PLAT_NAME_TIKTOK = "tiktok";
    public static final String PLAT_NAME_TWITTER = "twitter";
    public static final String PLAT_NAME_VK = "vk";
    private static final int PREFIX_SUFFIX_LENGTH = 6;
    public String mAccessToken;
    public String mCreateTIme;
    public long mExpire;
    public long mExpireIn;
    public String mExtra;
    public long mModifyTime;
    public final String mName;
    public String mOpenId;
    public long mPlatformId;
    public String mScope;
    public String mSecPlatformUid;
    public long mUserId;
    public long refreshAt;
    public long refreshTime;
    public boolean mLogin = false;
    public String mNickname = "";
    public String mAvatar = null;
    public String mPlatformUid = "";

    public static BDAccountPlatformEntity create(String str) {
        return new BDAccountPlatformEntity(str);
    }

    public String getAccessTokenWithExpirationCheck() {
        if (checkAndExpire(this.mAccessToken)) {
            return null;
        }
        return this.mAccessToken;
    }

    public String getOpenIdWithExpirationCheck() {
        if (checkAndExpire(this.mOpenId)) {
            return null;
        }
        return this.mOpenId;
    }

    public String getScopeWithExpirationCheck() {
        if (checkAndExpire(this.mScope)) {
            return null;
        }
        return this.mScope;
    }

    private boolean checkAndExpire(String str) {
        if (TextUtils.isEmpty(str) || !AuthExpirationConfigManager.isEnable() || System.currentTimeMillis() <= this.mExpire) {
            return false;
        }
        BDAccountDelegateInner.instance().clearPlatformInfo(this.mName, (int) this.mPlatformId, false);
        return true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BDAccountPlatformEntity m4145clone() throws CloneNotSupportedException {
        return (BDAccountPlatformEntity) super.clone();
    }

    public BDAccountPlatformEntity(String str) {
        this.mName = str;
    }

    public void invalidate() {
        this.mLogin = false;
        this.mNickname = "";
        this.mAvatar = null;
        this.mPlatformUid = "";
        this.mSecPlatformUid = "";
        this.mExpire = 0L;
        this.mExpireIn = 0L;
        this.mUserId = 0L;
        this.mModifyTime = 0L;
        this.mPlatformId = 0L;
        this.mAccessToken = null;
        this.mOpenId = null;
        this.mScope = null;
        this.mExtra = null;
        this.mCreateTIme = "";
        this.refreshAt = 0L;
        this.refreshTime = 0L;
    }

    public String toString() {
        return "BDAccountPlatformEntity{mName='" + this.mName + "', mLogin=" + this.mLogin + ", mNickname='" + this.mNickname + "', mAvatar='" + this.mAvatar + "', mPlatformUid='" + this.mPlatformUid + "', mSecPlatformUid='" + this.mSecPlatformUid + "', mCreateTIme='" + this.mCreateTIme + "', mModifyTime=" + this.mModifyTime + ", mExpire=" + this.mExpire + "(" + Utils.getFormattedTime(this.mExpire) + "), mExpireIn=" + this.mExpireIn + ", mUserId=" + this.mUserId + ", mPlatformId=" + this.mPlatformId + ", mAccessToken='" + this.mAccessToken + "', mOpenId='" + this.mOpenId + "', mScope='" + this.mScope + "', mExtra='" + this.mExtra + "', refreshAt=" + this.refreshAt + "(" + Utils.getFormattedTime(this.refreshAt) + "), refreshTime=" + this.refreshTime + '}';
    }

    public String getLoggableString() {
        return "BDAccountPlatformEntity{mName='" + this.mName + "', mPlatformId=" + this.mPlatformId + ", mAccessToken='" + getMixValue(this.mAccessToken) + "', mOpenId='" + getMixValue(this.mOpenId) + "', mScope='" + this.mScope + "', mExpire=" + this.mExpire + "(" + Utils.getFormattedTime(this.mExpire) + "), refreshAt=" + this.refreshAt + "(" + Utils.getFormattedTime(this.refreshAt) + ")}";
    }

    public static String getMixValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.length() <= 12) {
            return "***";
        }
        return str.substring(0, 6) + "***" + str.substring(str.length() - 6);
    }
}
