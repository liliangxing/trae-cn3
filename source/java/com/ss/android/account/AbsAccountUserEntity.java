package com.ss.android.account;

import androidx.autofill.HintConstants;
import com.bytedance.sdk.account.user.IBDAccountEntityFactory;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class AbsAccountUserEntity extends IBDAccountUserEntity {
    public String avatarUrl;
    public String description;
    public String userName;

    public String getDescription() {
        return this.description;
    }

    public AbsAccountUserEntity() {
    }

    public AbsAccountUserEntity(JSONObject jSONObject) {
        super(jSONObject);
    }

    public AbsAccountUserEntity(JSONObject jSONObject, JSONObject jSONObject2) {
        super(jSONObject, jSONObject2);
    }

    @Override // com.bytedance.sdk.account.user.IBDAccountUserEntity
    public void extract() throws Exception {
        super.extract();
        extract(this, getUserData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void extract(AbsAccountUserEntity absAccountUserEntity, JSONObject jSONObject) throws Exception {
        if (jSONObject.has("name")) {
            absAccountUserEntity.userName = jSONObject.optString("name");
        } else if (jSONObject.has(HintConstants.AUTOFILL_HINT_USERNAME)) {
            absAccountUserEntity.userName = jSONObject.optString(HintConstants.AUTOFILL_HINT_USERNAME);
        }
        absAccountUserEntity.avatarUrl = jSONObject.optString("avatar_url");
        absAccountUserEntity.description = jSONObject.optString("description");
    }

    public String getUserName() {
        return this.userName;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* loaded from: classes7.dex */
    public static class AbsUserInfoFactory implements IBDAccountEntityFactory {
        @Override // com.bytedance.sdk.account.user.IBDAccountEntityFactory
        public IBDAccountUserEntity parseUserInfo(JSONObject jSONObject) throws Exception {
            AbsAccountUserEntity absAccountUserEntity = new AbsAccountUserEntity(jSONObject);
            AbsAccountUserEntity.extract(absAccountUserEntity, jSONObject);
            return absAccountUserEntity;
        }

        @Override // com.bytedance.sdk.account.user.IBDAccountEntityFactory
        public IBDAccountUserEntity parseUserInfo(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
            AbsAccountUserEntity absAccountUserEntity = new AbsAccountUserEntity(jSONObject, jSONObject2);
            AbsAccountUserEntity.extract(absAccountUserEntity, jSONObject);
            return absAccountUserEntity;
        }
    }
}
