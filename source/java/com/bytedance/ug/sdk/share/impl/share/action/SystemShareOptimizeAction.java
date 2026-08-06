package com.bytedance.ug.sdk.share.impl.share.action;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.TokenShareInfo;
import com.bytedance.ug.sdk.share.api.p008ui.ISystemOptShareTokenDialog;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.p009ui.sysopt.SystemOptShareTokenDialogProxy;
import com.bytedance.ug.sdk.share.impl.utils.UiThreadHelper;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SystemShareOptimizeAction {
    private static volatile SystemShareOptimizeAction systemShareOptimizeAction;
    private ShareChannelType mChannelType;
    private TokenShareInfo mTokenShareInfo;

    private SystemShareOptimizeAction() {
    }

    public static SystemShareOptimizeAction getInstance() {
        if (systemShareOptimizeAction == null) {
            synchronized (SystemShareOptimizeAction.class) {
                if (systemShareOptimizeAction == null) {
                    systemShareOptimizeAction = new SystemShareOptimizeAction();
                }
            }
        }
        return systemShareOptimizeAction;
    }

    public boolean shareTo(ShareChannelType shareChannelType, final ShareContent shareContent, final ArrayList<Uri> arrayList) {
        if (shareContent == null || shareContent.getTokenShareInfo() == null || shareChannelType == null) {
            return false;
        }
        this.mChannelType = shareChannelType;
        this.mTokenShareInfo = shareContent.getTokenShareInfo();
        UiThreadHelper.getInstance().execute(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.share.action.SystemShareOptimizeAction.1
            @Override // java.lang.Runnable
            public void run() {
                SystemShareOptimizeAction.this.createTokenInfoBean(shareContent, arrayList);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTokenInfoBean(ShareContent shareContent, ArrayList<Uri> arrayList) {
        if (ShareConfigManager.getInstance().getTopActivity() == null) {
            return;
        }
        showTokenShareDialog(shareContent, arrayList);
    }

    private void showTokenShareDialog(ShareContent shareContent, ArrayList<Uri> arrayList) {
        Activity topActivity;
        ISystemOptShareTokenDialog systemOptShareTokenDialog;
        if (this.mTokenShareInfo == null || this.mChannelType == null || (topActivity = ShareConfigManager.getInstance().getTopActivity()) == null || (systemOptShareTokenDialog = ShareConfigManager.getInstance().getSystemOptShareTokenDialog(topActivity)) == null) {
            return;
        }
        new SystemOptShareTokenDialogProxy(topActivity, shareContent, arrayList, systemOptShareTokenDialog).show();
    }
}
