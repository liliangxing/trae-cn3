package com.ss.android.account;

import androidx.autofill.HintConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.account.user.IBDAccountEntityFactory;
import com.caverock.androidsvg.SVGParser;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BDAccountUserEntity extends AbsAccountUserEntity {
    public String area;
    public String birthday;
    public int canFoundByPhone;
    public int canSyncShare;
    public JSONObject expendAttrs;
    public int gender;
    public boolean hasPassword;
    public String industry;
    public int isBlocked;
    public int isBlocking;
    public boolean isGenerated;
    public boolean isRecommendAllowed;
    public boolean isToutiao;
    public int mAppId;
    public String mBgImgUrl;
    public int mDisplayOcrEntrance;
    public int mFollowersCount;
    public int mFollowingCount;
    public long mMediaId;
    public int mVisitorsCount;
    public String pgcAvatarUrl;
    public long pgcMediaId;
    public String pgcName;
    public String recommendHintMessage;
    public String screenName;
    public int shareShowIcon;
    public int userPrivacyExtend;
    public String user_auth_info;
    public String user_decoration;
    public boolean user_verified;
    public String verifiedContent;

    public BDAccountUserEntity() {
        this.mDisplayOcrEntrance = 0;
    }

    public BDAccountUserEntity(JSONObject jSONObject) {
        super(jSONObject);
        this.mDisplayOcrEntrance = 0;
    }

    public BDAccountUserEntity(JSONObject jSONObject, JSONObject jSONObject2) {
        super(jSONObject, jSONObject2);
        this.mDisplayOcrEntrance = 0;
    }

    @Override // com.ss.android.account.AbsAccountUserEntity, com.bytedance.sdk.account.user.IBDAccountUserEntity
    public void extract() throws Exception {
        super.extract();
        innerParseUserInfo(this, getUserData());
    }

    public static void innerParseUserInfo(BDAccountUserEntity bDAccountUserEntity, JSONObject jSONObject) throws Exception {
        bDAccountUserEntity.canFoundByPhone = jSONObject.optInt("can_be_found_by_phone");
        bDAccountUserEntity.canSyncShare = jSONObject.optInt("share_to_repost", -1);
        bDAccountUserEntity.shareShowIcon = jSONObject.optInt("user_privacy_extend") & 1;
        bDAccountUserEntity.userPrivacyExtend = jSONObject.optInt("user_privacy_extend");
        bDAccountUserEntity.gender = jSONObject.optInt(HintConstants.AUTOFILL_HINT_GENDER);
        bDAccountUserEntity.screenName = jSONObject.optString(DBData.FIELD_SCREEN_NAME);
        bDAccountUserEntity.verifiedContent = jSONObject.optString("verified_content");
        bDAccountUserEntity.isGenerated = jSONObject.optBoolean("is_generated");
        bDAccountUserEntity.user_verified = jSONObject.optBoolean("user_verified");
        bDAccountUserEntity.isRecommendAllowed = jSONObject.optInt("is_recommend_allowed") != 0;
        bDAccountUserEntity.recommendHintMessage = jSONObject.optString("recommend_hint_message");
        bDAccountUserEntity.user_decoration = jSONObject.optString("user_decoration");
        bDAccountUserEntity.user_auth_info = jSONObject.optString("user_auth_info");
        bDAccountUserEntity.birthday = jSONObject.optString("birthday");
        bDAccountUserEntity.area = jSONObject.optString("area");
        bDAccountUserEntity.industry = jSONObject.optString("industry");
        bDAccountUserEntity.isBlocked = jSONObject.optInt("is_blocked");
        bDAccountUserEntity.isBlocking = jSONObject.optInt("is_blocking");
        bDAccountUserEntity.isToutiao = jSONObject.optBoolean("is_toutiao");
        bDAccountUserEntity.hasPassword = jSONObject.optInt("has_password") != 0;
        JSONObject optJSONObject = jSONObject.optJSONObject(SVGParser.XML_STYLESHEET_ATTR_MEDIA);
        if (optJSONObject != null) {
            bDAccountUserEntity.pgcAvatarUrl = optJSONObject.optString("avatar_url");
            bDAccountUserEntity.pgcMediaId = optJSONObject.optLong("id");
            bDAccountUserEntity.pgcName = optJSONObject.optString("name");
            bDAccountUserEntity.mDisplayOcrEntrance = optJSONObject.optInt("display_app_ocr_entrance", 0);
        }
        bDAccountUserEntity.mFollowingCount = jSONObject.optInt("followings_count");
        bDAccountUserEntity.mFollowersCount = jSONObject.optInt("followers_count");
        bDAccountUserEntity.mVisitorsCount = jSONObject.optInt("visit_count_recent");
        bDAccountUserEntity.mMediaId = jSONObject.optLong("media_id");
        bDAccountUserEntity.mBgImgUrl = jSONObject.optString("bg_img_url");
        bDAccountUserEntity.mAppId = jSONObject.optInt("app_id");
        bDAccountUserEntity.expendAttrs = jSONObject.optJSONObject("expend_attrs");
    }

    /* loaded from: classes7.dex */
    public static class UserInfoFactory implements IBDAccountEntityFactory<BDAccountUserEntity> {
        @Override // com.bytedance.sdk.account.user.IBDAccountEntityFactory
        public BDAccountUserEntity parseUserInfo(JSONObject jSONObject) throws Exception {
            BDAccountUserEntity bDAccountUserEntity = new BDAccountUserEntity(jSONObject);
            bDAccountUserEntity.extract();
            return bDAccountUserEntity;
        }

        @Override // com.bytedance.sdk.account.user.IBDAccountEntityFactory
        public BDAccountUserEntity parseUserInfo(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
            BDAccountUserEntity bDAccountUserEntity = new BDAccountUserEntity(jSONObject, jSONObject2);
            bDAccountUserEntity.extract();
            return bDAccountUserEntity;
        }
    }
}
