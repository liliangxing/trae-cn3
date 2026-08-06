package com.bytedance.ug.sdk.share.impl.share.api;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* loaded from: classes4.dex */
public interface IShare {
    boolean canShare(ShareContent shareContent);

    boolean doShare(ShareContent shareContent);

    String getPackageName();

    boolean isInstalled();
}
