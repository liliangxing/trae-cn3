package com.bytedance.sdk.open.aweme.commonability;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.bytedance.sdk.open.aweme.common.model.BaseReq;
import com.bytedance.sdk.open.aweme.common.model.BaseResp;

/* loaded from: classes5.dex */
public class CommonAbility {
    public static final int COMMON_TYPE_JUMP_CONTACT = 2;
    public static final int COMMON_TYPE_JUMP_PRODUCTION = 3;
    public static final int COMMON_TYPE_JUMP_PROFILE = 1;

    /* loaded from: classes5.dex */
    public static class Request extends BaseReq {
        public int commonType;
        public String data;
        public String mState;

        public Request() {
        }

        public Request(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public boolean checkArgs() {
            if (this.commonType <= 0) {
                return false;
            }
            return super.checkArgs();
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.mState = bundle.getString(ParamKeyConstants.CommonAbilityParam.STATE);
            this.commonType = bundle.getInt(ParamKeyConstants.CommonAbilityParam.TYPE);
            this.data = bundle.getString(ParamKeyConstants.CommonAbilityParam.DATA);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public int getType() {
            return 9;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_bytedance_params_type_caller_package", this.callerPackage);
            bundle.putString(ParamKeyConstants.CommonAbilityParam.STATE, this.mState);
            bundle.putInt(ParamKeyConstants.CommonAbilityParam.TYPE, this.commonType);
            bundle.putString(ParamKeyConstants.CommonAbilityParam.DATA, this.data);
        }
    }

    /* loaded from: classes5.dex */
    public static class Response extends BaseResp {
        public int commonType;
        public String state;

        public Response() {
        }

        public Response(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.state = bundle.getString(ParamKeyConstants.CommonAbilityParam.STATE);
            this.commonType = bundle.getInt(ParamKeyConstants.CommonAbilityParam.TYPE);
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public int getType() {
            return 10;
        }

        @Override // com.bytedance.sdk.open.aweme.common.model.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(ParamKeyConstants.CommonAbilityParam.STATE, this.state);
            bundle.putInt(ParamKeyConstants.CommonAbilityParam.TYPE, this.commonType);
        }
    }

    public static int supportApi(int i) {
        if (i == 1 || i == 2) {
            return 1;
        }
        return i != 3 ? Integer.MAX_VALUE : 2;
    }
}
