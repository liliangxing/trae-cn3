package com.bytedance.ug.sdk.share.impl.share.action;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.p008ui.IShareTokenDialog;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.sharetoken.ShareTokenDialogProxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TokenShareAction {
    private static final String TAG = "TAG_SHARE_TokenShareAction";
    private static volatile TokenShareAction tokenShareHelper;

    private TokenShareAction() {
    }

    public static TokenShareAction getInstance() {
        if (tokenShareHelper == null) {
            synchronized (TokenShareAction.class) {
                if (tokenShareHelper == null) {
                    tokenShareHelper = new TokenShareAction();
                }
            }
        }
        return tokenShareHelper;
    }

    public boolean shareTo(Context context, ShareChannelType shareChannelType, ShareContent shareContent) {
        if (shareContent == null || shareContent.getTokenShareInfo() == null || shareChannelType == null) {
            return false;
        }
        return showTokenShareDialog(shareContent);
    }

    private boolean showTokenShareDialog(ShareContent shareContent) {
        Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (topActivity == null) {
            return false;
        }
        IShareTokenDialog shareTokenDialog = shareContent.getShareTokenDialog();
        if (shareTokenDialog == null && (shareTokenDialog = ShareConfigManager.getInstance().getShareTokenDialog(topActivity)) == null) {
            return false;
        }
        new ShareTokenDialogProxy(topActivity, shareContent, shareTokenDialog).show();
        return true;
    }
}
