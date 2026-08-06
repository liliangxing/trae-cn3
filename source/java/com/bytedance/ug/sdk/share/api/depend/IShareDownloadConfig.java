package com.bytedance.ug.sdk.share.api.depend;

import com.bytedance.ug.sdk.share.api.callback.OnDownloadListener;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IShareDownloadConfig {
    void onCancelDownload(ShareContent shareContent, String str, String str2, String str3);

    void onDownloadFile(ShareContent shareContent, String str, String str2, String str3, OnDownloadListener onDownloadListener);
}
