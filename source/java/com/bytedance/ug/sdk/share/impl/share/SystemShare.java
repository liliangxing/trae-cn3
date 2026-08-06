package com.bytedance.ug.sdk.share.impl.share;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class SystemShare extends AbstractShare {
    public SystemShare(Context context) {
        super(context);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean doShare(ShareContent shareContent) {
        this.mShareContent = shareContent;
        return SystemShareAction.shareTo(this.mContext, ShareChannelType.SYSTEM, shareContent);
    }
}
