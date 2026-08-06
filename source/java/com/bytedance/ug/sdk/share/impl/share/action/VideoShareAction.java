package com.bytedance.ug.sdk.share.impl.share.action;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.impl.helper.VideoGuideShareHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoShareAction {
    private static volatile VideoShareAction sVideoShareHelper;

    private VideoShareAction() {
    }

    public static VideoShareAction getInstance() {
        if (sVideoShareHelper == null) {
            synchronized (VideoShareAction.class) {
                if (sVideoShareHelper == null) {
                    sVideoShareHelper = new VideoShareAction();
                }
            }
        }
        return sVideoShareHelper;
    }

    public boolean shareTo(ShareContent shareContent) {
        if (shareContent == null) {
            return false;
        }
        return new VideoGuideShareHelper().shareVideo(shareContent);
    }
}
