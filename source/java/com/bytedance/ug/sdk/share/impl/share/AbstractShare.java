package com.bytedance.ug.sdk.share.impl.share;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.impl.share.api.IShare;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbstractShare implements IShare {
    protected Context mContext;
    protected ShareContent mShareContent;

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean canShare(ShareContent shareContent) {
        return true;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public String getPackageName() {
        return null;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean isInstalled() {
        return true;
    }

    public AbstractShare(Context context) {
        this.mContext = context;
    }
}
