package com.bytedance.sdk.open.aweme.authorize.model;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;
import com.google.gson.Gson;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class Authorization {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Request extends BaseReq {
        public String authTicket;
        public String clientKey;
        public String commentId;
        public String maskPhoneNumber;
        public String optionalScope0;
        public String optionalScope1;
        public String redirectUri;
        public String scope;
        public String state;
        public String thirdAuthScene;
        public VerifyObject verifyObject;
        public boolean isSupportLite = true;
        public boolean isThridAuthDialog = false;
        public boolean isSkipUIInThirdAuth = false;
        public boolean isOtherAccountAuth = false;

        public Request() {
        }

        public Request(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.state = bundle.getString("_bytedance_params_state");
            this.clientKey = bundle.getString("_bytedance_params_client_key");
            this.redirectUri = bundle.getString("_bytedance_params_redirect_uri");
            this.scope = bundle.getString("_bytedance_params_scope");
            this.optionalScope0 = bundle.getString("_bytedance_params_optional_scope0");
            this.optionalScope1 = bundle.getString("_bytedance_params_optional_scope1");
            this.authTicket = bundle.getString(ParamKeyConstants.AuthParams.AUTH_THIRD_APP_TICKET);
            this.maskPhoneNumber = bundle.getString(ParamKeyConstants.AuthParams.AUTH_MASK_PHONE);
            this.commentId = bundle.getString(ParamKeyConstants.AuthParams.AUTH_COMMENT_ID);
            String string = bundle.getString(ParamKeyConstants.AuthParams.VERIFY_SCOPE);
            if (string != null) {
                this.verifyObject = (VerifyObject) new Gson().fromJson(string, VerifyObject.class);
            }
            this.isSkipUIInThirdAuth = bundle.getBoolean(ParamKeyConstants.AuthParams.IS_SKIP_UI_IN_THIRD_AUTH);
            this.thirdAuthScene = bundle.getString(ParamKeyConstants.AuthParams.THIRD_AUTH_SCENE);
            this.isOtherAccountAuth = bundle.getBoolean("is_other_account_auth");
        }

        public String getClientKey() {
            return this.clientKey;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_bytedance_params_state", this.state);
            bundle.putString("_bytedance_params_client_key", this.clientKey);
            bundle.putString("_bytedance_params_redirect_uri", this.redirectUri);
            bundle.putString("_bytedance_params_scope", this.scope);
            bundle.putString("_bytedance_params_optional_scope0", this.optionalScope0);
            bundle.putString("_bytedance_params_optional_scope1", this.optionalScope1);
            bundle.putString(ParamKeyConstants.AuthParams.AUTH_THIRD_APP_TICKET, this.authTicket);
            bundle.putString(ParamKeyConstants.AuthParams.AUTH_MASK_PHONE, this.maskPhoneNumber);
            bundle.putString(ParamKeyConstants.AuthParams.AUTH_COMMENT_ID, this.commentId);
            if (this.verifyObject != null) {
                bundle.putString(ParamKeyConstants.AuthParams.VERIFY_SCOPE, new Gson().toJson(this.verifyObject));
            }
            bundle.putBoolean(ParamKeyConstants.AuthParams.IS_SKIP_UI_IN_THIRD_AUTH, this.isSkipUIInThirdAuth);
            bundle.putString(ParamKeyConstants.AuthParams.THIRD_AUTH_SCENE, this.thirdAuthScene);
            bundle.putBoolean("is_other_account_auth", this.isOtherAccountAuth);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Response extends BaseResp {
        public String authCode;
        public String grantedPermissions;
        public String state;

        public Response() {
        }

        public Response(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.authCode = bundle.getString("_bytedance_params_authcode");
            this.state = bundle.getString("_bytedance_params_state");
            this.grantedPermissions = bundle.getString("_bytedance_params_granted_permission");
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 2;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_bytedance_params_authcode", this.authCode);
            bundle.putString("_bytedance_params_state", this.state);
            bundle.putString("_bytedance_params_granted_permission", this.grantedPermissions);
        }
    }
}
