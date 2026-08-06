package com.bytedance.sdk.account.common.model;

import android.os.Bundle;
import com.bytedance.sdk.account.common.constants.BDOpenConstants;

/* loaded from: classes5.dex */
public class SendAuth {

    /* loaded from: classes5.dex */
    public static class Request extends BaseReq {
        public String clientKey;
        public String clientSecret;
        public String nextUrl;
        public String optionalScope0;
        public String optionalScope1;
        public String redirectUri;
        public String scope;
        public String state;
        public String authFrom = "opensdk";
        public int wapRequestedOrientation = -1;

        @Override // com.bytedance.sdk.account.common.model.BaseReq
        public int getType() {
            return 1;
        }

        public String getClientKey() {
            return this.clientKey;
        }

        public Request() {
        }

        public Request(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.account.common.model.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.state = bundle.getString("_bytedance_params_state");
            this.clientKey = bundle.getString("_bytedance_params_client_key");
            this.clientSecret = bundle.getString(BDOpenConstants.Params.CLIENT_SECRET);
            this.redirectUri = bundle.getString("_bytedance_params_redirect_uri");
            this.nextUrl = bundle.getString(BDOpenConstants.Params.NEXT_URL);
            this.scope = bundle.getString("_bytedance_params_scope");
            this.optionalScope0 = bundle.getString("_bytedance_params_optional_scope0");
            this.optionalScope1 = bundle.getString("_bytedance_params_optional_scope1");
            this.wapRequestedOrientation = bundle.getInt("wap_requested_orientation", -1);
            this.authFrom = bundle.getString(BDOpenConstants.Params.WAP_TO_NATIVE_FROM_TAG, "opensdk");
        }

        @Override // com.bytedance.sdk.account.common.model.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_bytedance_params_state", this.state);
            bundle.putString("_bytedance_params_client_key", this.clientKey);
            bundle.putString(BDOpenConstants.Params.CLIENT_SECRET, this.clientSecret);
            bundle.putString("_bytedance_params_redirect_uri", this.redirectUri);
            bundle.putString(BDOpenConstants.Params.NEXT_URL, this.nextUrl);
            bundle.putString("_bytedance_params_scope", this.scope);
            bundle.putString("_bytedance_params_optional_scope0", this.optionalScope0);
            bundle.putString("_bytedance_params_optional_scope1", this.optionalScope1);
            bundle.putInt("wap_requested_orientation", this.wapRequestedOrientation);
            bundle.putString(BDOpenConstants.Params.WAP_TO_NATIVE_FROM_TAG, this.authFrom);
        }
    }

    /* loaded from: classes5.dex */
    public static class Response extends BaseResp {
        public String authCode;
        public String grantedPermissions;
        public String state;

        @Override // com.bytedance.sdk.account.common.model.BaseResp
        public int getType() {
            return 2;
        }

        public Response() {
        }

        public Response(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.account.common.model.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.authCode = bundle.getString("_bytedance_params_authcode");
            this.state = bundle.getString("_bytedance_params_state");
            this.grantedPermissions = bundle.getString("_bytedance_params_granted_permission");
        }

        @Override // com.bytedance.sdk.account.common.model.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_bytedance_params_authcode", this.authCode);
            bundle.putString("_bytedance_params_state", this.state);
            bundle.putString("_bytedance_params_granted_permission", this.grantedPermissions);
        }
    }
}
