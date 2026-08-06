package com.bytedance.sdk.account.information.method.upload_avatar;

import com.bytedance.sdk.account.information.method.UploadPicResponse;

/* loaded from: classes5.dex */
public class UploadAvatarResponse extends UploadPicResponse {
    public UploadAvatarResponse(boolean z, int i) {
        super(z, i);
    }

    public String getWebUri() {
        return this.webUri;
    }
}
