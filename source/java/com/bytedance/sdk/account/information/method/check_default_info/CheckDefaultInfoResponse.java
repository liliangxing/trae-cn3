package com.bytedance.sdk.account.information.method.check_default_info;

import com.bytedance.sdk.account.api.call.BaseApiResponse;

/* loaded from: classes5.dex */
public class CheckDefaultInfoResponse extends BaseApiResponse {
    public boolean isAvatarValid;
    public boolean isDescriptionValid;
    public boolean isNameValid;
    public boolean isShow;
    public String mAvatarUrl;
    public String mName;
    public String mSave;
    public String mTips;
    public String mTitle;

    public CheckDefaultInfoResponse(boolean z, int i) {
        super(z, i);
    }

    public boolean isNameValid() {
        return this.isNameValid;
    }

    public boolean isAvatarValid() {
        return this.isAvatarValid;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public String getName() {
        return this.mName;
    }

    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getTips() {
        return this.mTips;
    }

    public String getSave() {
        return this.mSave;
    }

    public boolean isDescriptionValid() {
        return this.isDescriptionValid;
    }

    @Override // com.bytedance.sdk.account.api.call.BaseApiResponse
    public String toString() {
        return "CheckDefaultInfoResponse{isNameValid=" + this.isNameValid + ", isAvatarValid=" + this.isAvatarValid + ", isDescriptionValid=" + this.isDescriptionValid + ", isShow=" + this.isShow + ", mName='" + this.mName + "', mAvatarUrl='" + this.mAvatarUrl + "', mTitle='" + this.mTitle + "', mTips='" + this.mTips + "', mSave='" + this.mSave + "'}";
    }
}
