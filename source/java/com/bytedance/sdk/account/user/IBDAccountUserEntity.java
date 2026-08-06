package com.bytedance.sdk.account.user;

import android.text.TextUtils;
import com.bytedance.bdinstall.Api;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.bytedance.sdk.account.save.SaveConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.ss.android.account.model2.BDAccountPlatformEntity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IBDAccountUserEntity {
    public String businessUserInfo;
    public int businessUserInfoDemotion;
    public int countryCode;
    public String email;
    public boolean hasPassword;
    public boolean isKidsMode;
    public boolean isNewUser;
    public boolean isVisitorAccount;
    public String mobile;
    public int odinUserType;
    protected JSONObject rawData;
    protected JSONObject rawJson;
    protected JSONObject rawUserJson;
    protected String secUid;
    public String secUserId;
    public String sessionKey;
    public long userId;
    public final Map<String, BDAccountPlatformEntity> bindMap = new HashMap();
    public final Map<String, Map<String, BDAccountPlatformEntity>> thirdPlatform = new HashMap();

    public IBDAccountUserEntity() {
    }

    public IBDAccountUserEntity(JSONObject jSONObject) {
        this.rawJson = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        this.rawData = optJSONObject;
        this.rawUserJson = optJSONObject;
    }

    public IBDAccountUserEntity(JSONObject jSONObject, JSONObject jSONObject2) {
        this.rawJson = jSONObject;
        this.rawData = jSONObject.optJSONObject("data");
        this.rawUserJson = jSONObject2;
    }

    public void updateRawJson(JSONObject jSONObject) {
        this.rawJson = jSONObject;
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        this.rawData = optJSONObject;
        this.rawUserJson = optJSONObject;
    }

    public JSONObject getRawJson() {
        return this.rawJson;
    }

    public JSONObject getRawData() {
        return this.rawData;
    }

    public JSONObject getUserData() {
        return this.rawUserJson;
    }

    public void extract() throws Exception {
        extract(this, this.rawJson, this.rawUserJson);
    }

    public static void extract(IBDAccountUserEntity iBDAccountUserEntity, JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        iBDAccountUserEntity.userId = jSONObject2.optLong("user_id", 0L);
        iBDAccountUserEntity.odinUserType = jSONObject2.optInt("odin_user_type", 0);
        iBDAccountUserEntity.secUid = jSONObject2.optString(AccountConstants.AccountShareCols.SEC_USER_ID, "");
        iBDAccountUserEntity.sessionKey = jSONObject2.optString("session_key", "");
        iBDAccountUserEntity.isNewUser = jSONObject2.optInt(Api.KEY_NEW_USER) != 0;
        iBDAccountUserEntity.mobile = jSONObject2.optString("mobile", "");
        iBDAccountUserEntity.hasPassword = jSONObject2.optInt("has_password") != 0;
        iBDAccountUserEntity.secUserId = jSONObject2.optString(AccountConstants.AccountShareCols.SEC_USER_ID, "");
        iBDAccountUserEntity.isVisitorAccount = jSONObject2.optBoolean("is_visitor_account", false);
        iBDAccountUserEntity.email = jSONObject2.optString("email", "");
        BDAccountPlatformEntity create = BDAccountPlatformEntity.create("mobile");
        BDAccountPlatformEntity create2 = BDAccountPlatformEntity.create("email");
        create2.mNickname = iBDAccountUserEntity.email;
        if (!TextUtils.isEmpty(iBDAccountUserEntity.email)) {
            iBDAccountUserEntity.getBindMap().put(create2.mName, create2);
        }
        create.mNickname = iBDAccountUserEntity.mobile;
        if (!TextUtils.isEmpty(iBDAccountUserEntity.mobile)) {
            iBDAccountUserEntity.getBindMap().put(create.mName, create);
        }
        extractPlatformInfo(iBDAccountUserEntity, jSONObject2);
        iBDAccountUserEntity.countryCode = jSONObject2.optInt(SaveConstants.ExtKey.COUNTRY_CODE, -1);
        iBDAccountUserEntity.isKidsMode = jSONObject2.optInt("is_kids_mode") == 1;
        iBDAccountUserEntity.businessUserInfo = jSONObject2.optString("lite_user_info_string", "");
        iBDAccountUserEntity.businessUserInfoDemotion = jSONObject2.optInt("lite_user_info_demotion", 0);
    }

    public static void extractPlatformInfo(IBDAccountUserEntity iBDAccountUserEntity, JSONObject jSONObject) throws Exception {
        Map<String, BDAccountPlatformEntity> map;
        BDAccountPlatformEntity bDAccountPlatformEntity;
        JSONArray optJSONArray = jSONObject.optJSONArray("connects");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            System.currentTimeMillis();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                String string = jSONObject2.getString("platform");
                if (string != null && string.length() != 0) {
                    BDAccountPlatformEntity create = BDAccountPlatformEntity.create(string);
                    create.mUserId = jSONObject.optLong("user_id", 0L);
                    if (jSONObject2.has(DBData.FIELD_SCREEN_NAME)) {
                        create.mNickname = jSONObject2.optString(DBData.FIELD_SCREEN_NAME);
                    } else if (jSONObject2.has(DBData.FIELD_PLATFORM_SCREEN_NAME)) {
                        create.mNickname = jSONObject2.optString(DBData.FIELD_PLATFORM_SCREEN_NAME);
                    }
                    create.mAvatar = jSONObject2.optString("profile_image_url");
                    create.mPlatformUid = jSONObject2.optString("platform_uid");
                    create.mSecPlatformUid = jSONObject2.optString("sec_platform_uid");
                    create.mModifyTime = jSONObject2.optLong("modify_time");
                    create.mCreateTIme = jSONObject2.optString("create_time");
                    create.mPlatformId = jSONObject2.optInt("platform_app_id", 0);
                    create.mLogin = true;
                    create.mExtra = jSONObject2.optString("extra");
                    IBDAccountUserEntity userInfo = BDAccountDelegateInner.instance().getUserInfo();
                    if (userInfo != null && userInfo.userId == iBDAccountUserEntity.userId && (map = userInfo.thirdPlatform.get(string)) != null && (bDAccountPlatformEntity = map.get(String.valueOf(create.mPlatformId))) != null) {
                        create.mAccessToken = bDAccountPlatformEntity.mAccessToken;
                        create.mOpenId = bDAccountPlatformEntity.mOpenId;
                        create.mScope = bDAccountPlatformEntity.mScope;
                        create.mExpireIn = bDAccountPlatformEntity.mExpireIn;
                        create.mExpire = bDAccountPlatformEntity.mExpire;
                        create.refreshTime = bDAccountPlatformEntity.refreshTime;
                        create.refreshAt = bDAccountPlatformEntity.refreshAt;
                    }
                    Map<String, BDAccountPlatformEntity> map2 = iBDAccountUserEntity.thirdPlatform.get(string);
                    if (map2 == null) {
                        map2 = new HashMap<>();
                        iBDAccountUserEntity.thirdPlatform.put(string, map2);
                    }
                    BDAccountPlatformEntity bDAccountPlatformEntity2 = map2.get(String.valueOf(create.mPlatformId));
                    if (bDAccountPlatformEntity2 == null || bDAccountPlatformEntity2.mModifyTime <= 0 || bDAccountPlatformEntity2.mModifyTime <= create.mModifyTime) {
                        iBDAccountUserEntity.getBindMap().put(string, create.m9411clone());
                        map2.put(String.valueOf(create.mPlatformId), create);
                    }
                }
            }
        }
    }

    public long getUserId() {
        return this.userId;
    }

    public int getOdinUserType() {
        return this.odinUserType;
    }

    public String getSecUserId() {
        return this.secUserId;
    }

    public boolean isVisitorAccount() {
        return this.isVisitorAccount;
    }

    public Map<String, BDAccountPlatformEntity> getBindMap() {
        return this.bindMap;
    }

    public Map<String, Map<String, BDAccountPlatformEntity>> getThirdPlatform() {
        return this.thirdPlatform;
    }

    public int getCountryCode() {
        return this.countryCode;
    }

    public boolean isNewUser() {
        return this.isNewUser;
    }

    public String getSessionKey() {
        return this.sessionKey;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public String getSecUid() {
        return this.secUid;
    }
}
