package com.bytedance.ug.sdk.share.keep.impl;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.depend.IShareImageTokenConfig;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.image.action.ImageTokenShareAction;
import com.bytedance.ug.sdk.share.image.manager.ImageCheckerManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageTokenConfigImpl implements IShareImageTokenConfig {
    @Override // com.bytedance.ug.sdk.share.api.depend.IShareImageTokenConfig
    public boolean showImageTokenDialog(Context context, ShareContent shareContent) {
        return ImageTokenShareAction.getInstance().shareTo(context, shareContent.getShareChanelType(), shareContent);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareImageTokenConfig
    public void checkImageToken() {
        ImageCheckerManager.inst().checkMediaToken();
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareImageTokenConfig
    public void checkSelectedMediaToken(String str) {
        ImageCheckerManager.inst().checkSelectedMedia(str);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareImageTokenConfig
    public void handleAppBackground() {
        ImageCheckerManager.inst().handleAppBackground();
    }
}
