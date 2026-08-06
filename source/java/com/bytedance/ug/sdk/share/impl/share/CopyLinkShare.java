package com.bytedance.ug.sdk.share.impl.share;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.impl.utils.ClipboardCompat;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.SharePrefHelper;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class CopyLinkShare extends AbstractShare {
    private static final String TAG = "CopyLinkShare";

    public CopyLinkShare(Context context) {
        super(context);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean doShare(ShareContent shareContent) {
        this.mShareContent = shareContent;
        if (this.mContext == null && shareContent == null) {
            return false;
        }
        String targetUrl = TextUtils.isEmpty(shareContent.getCopyUrl()) ? shareContent.getTargetUrl() : shareContent.getCopyUrl();
        Logger.m463d(TAG, "copy url" + targetUrl);
        if (!TextUtils.isEmpty(targetUrl)) {
            ClipboardCompat.setText(this.mContext, "", targetUrl);
            SharePrefHelper.getInstance().setPref(SharePrefHelper.SP_USER_COPY_CONTENT, targetUrl);
            ToastUtils.showToast(this.mContext.getApplicationContext(), shareContent, 0, C1010R.string.share_sdk_clip_sucess);
            ShareResult.sendShareStatus(10000, shareContent);
            Logger.m463d(TAG, "copy url success" + targetUrl);
        } else {
            ToastUtils.showToast(this.mContext.getApplicationContext(), shareContent, 1, C1010R.string.share_sdk_clip_failed);
            ShareResult.sendShareStatus(ShareResult.SHARE_FAILED, shareContent);
            Logger.m463d(TAG, "copy url failed" + targetUrl);
        }
        return true;
    }
}
