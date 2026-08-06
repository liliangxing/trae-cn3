package com.bytedance.ug.sdk.share.impl.share;

import android.content.Context;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction;
import com.bytedance.ug.sdk.share.impl.share.action.TokenShareAction;
import com.bytedance.ug.sdk.share.impl.share.action.VideoShareAction;
import com.bytedance.ug.sdk.share.impl.share.api.IShare;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToolUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class StrategyDispatcher {
    public static boolean dispatchStrategy(Context context, ShareContent shareContent) {
        if (shareContent == null || !checkInstall(context, shareContent)) {
            return false;
        }
        List<ShareStrategy> shareStrategyList = shareContent.getShareStrategyList();
        if (shareStrategyList != null && shareStrategyList.size() > 0) {
            Iterator<ShareStrategy> it = shareStrategyList.iterator();
            while (it.hasNext()) {
                if (share(context, it.next(), shareContent)) {
                    return true;
                }
            }
            return false;
        }
        return share(context, shareContent.getShareStrategy(), shareContent);
    }

    private static boolean share(Context context, ShareStrategy shareStrategy, ShareContent shareContent) {
        ShareChannelType shareChanelType = shareContent.getShareChanelType();
        ShareSdkManager.getInstance().setCurrentShareChannelType(shareChanelType);
        if (isWechatChannel(shareChanelType) || isQQChannel(shareChanelType)) {
            if (shareStrategy == ShareStrategy.SHARE_WITH_COMPONENT) {
                if (shareChanelType == ShareChannelType.WX_TIMELINE) {
                    shareChanelType = ShareChannelType.WX;
                }
                boolean shareTo = SystemShareAction.shareTo(context, shareChanelType, shareContent);
                if (!shareTo) {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_UNKNOWN, shareContent);
                }
                return shareTo;
            }
            if (shareStrategy == ShareStrategy.SHARE_WITH_TOKEN) {
                boolean shareTo2 = TokenShareAction.getInstance().shareTo(context, shareChanelType, shareContent);
                if (!shareTo2) {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_UNKNOWN, shareContent);
                }
                return shareTo2;
            }
            if (shareStrategy == ShareStrategy.SHARE_WITH_IMAGE_TOKEN) {
                boolean showImageTokenDialog = ShareConfigManager.getInstance().showImageTokenDialog(context, shareContent);
                if (!showImageTokenDialog) {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_UNKNOWN, shareContent);
                }
                return showImageTokenDialog;
            }
            if (shareStrategy == ShareStrategy.SHARE_WITH_VIDEO) {
                boolean shareTo3 = VideoShareAction.getInstance().shareTo(shareContent);
                if (!shareTo3) {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_UNKNOWN, shareContent);
                }
                return shareTo3;
            }
            if (shareStrategy == ShareStrategy.SHARE_WITH_COMPONET_OPTIMIZE) {
                shareContent.setImageUrl(shareContent.getQrcodeImageUrl());
            }
        }
        IShare share = ShareFactory.getShare(context, shareChanelType);
        if (share != null) {
            return share.doShare(shareContent);
        }
        return false;
    }

    private static boolean checkInstall(Context context, ShareContent shareContent) {
        ShareChannelType shareChanelType = shareContent.getShareChanelType();
        if ((!isWechatChannel(shareChanelType) && !isQQChannel(shareChanelType)) || ToolUtils.isInstalledApp(ShareChannelType.getSharePackageName(shareChanelType))) {
            return true;
        }
        ShareResult.sendShareStatus(ShareResult.ERROR_SDK_APP_NOT_INSTALL, shareContent);
        ToastUtils.showToastWithIcon(context, shareContent, isWechatChannel(shareChanelType) ? 104 : 105, C1010R.drawable.share_sdk_close_popup_textpage, isWechatChannel(shareChanelType) ? C1010R.string.share_sdk_wechat_not_install_tips : C1010R.string.share_sdk_qq_not_install_tips);
        return false;
    }

    private static boolean isWechatChannel(ShareChannelType shareChannelType) {
        return shareChannelType == ShareChannelType.WX || shareChannelType == ShareChannelType.WX_TIMELINE;
    }

    private static boolean isQQChannel(ShareChannelType shareChannelType) {
        return shareChannelType == ShareChannelType.QQ || shareChannelType == ShareChannelType.QZONE;
    }
}
