package com.bytedance.ug.sdk.share.impl.helper;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoGuideDialog;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.video.VideoGuideDialogProxy;
import com.bytedance.ug.sdk.share.impl.utils.SharePrefHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoGuideShareHelper {
    public boolean shareVideo(ShareContent shareContent) {
        if (shareContent == null) {
            return false;
        }
        return showGuideDialog(shareContent);
    }

    private boolean showGuideDialog(ShareContent shareContent) {
        Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (topActivity == null) {
            return false;
        }
        int pref = SharePrefHelper.getInstance().getPref(SharePrefHelper.SP_SHOW_SHARE_VIDEO_SHARE_DIALOG, 0);
        if (pref >= ShareConfigManager.getInstance().getShowSaveVideoShareDialogTimes()) {
            return new VideoShareActionHelper().directShareVideo(shareContent);
        }
        SharePrefHelper.getInstance().setPref(SharePrefHelper.SP_SHOW_SHARE_VIDEO_SHARE_DIALOG, pref + 1);
        IVideoGuideDialog videoGuideDialog = shareContent.getVideoGuideDialog();
        if (videoGuideDialog == null && (videoGuideDialog = ShareConfigManager.getInstance().getVideoGuideDialog(topActivity)) == null) {
            return false;
        }
        new VideoGuideDialogProxy(topActivity, shareContent, videoGuideDialog).show();
        return true;
    }
}
