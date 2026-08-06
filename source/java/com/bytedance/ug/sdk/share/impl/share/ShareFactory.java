package com.bytedance.ug.sdk.share.impl.share;

import android.content.Context;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.manager.DependManager;
import com.bytedance.ug.sdk.share.impl.share.api.IShare;
import com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend;
import com.bytedance.ug.sdk.share.impl.share.api.IShareHandler;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ShareFactory {
    public static IShare getShare(Context context, ShareChannelType shareChannelType) {
        if (context == null || shareChannelType == null) {
            return null;
        }
        int i = C10951.$SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[shareChannelType.ordinal()];
        if (i == 1) {
            return new CopyLinkShare(context);
        }
        if (i == 2) {
            return new SystemShare(context);
        }
        if (i == 3) {
            return new SmsShare(context);
        }
        if (i == 4) {
            return new EmailShare(context);
        }
        IShareChannelDepend channel = DependManager.getChannel(shareChannelType);
        if (channel != null) {
            return channel.getChannel(context);
        }
        return null;
    }

    public static IShareHandler getShareResultOnActivityResult(ShareChannelType shareChannelType) {
        if (shareChannelType == null) {
            return null;
        }
        switch (shareChannelType) {
            case FACEBOOK:
            case QQ:
            case WEIBO:
            case WEIBO_SG:
            case QZONE:
            case MESSENGER:
                IShareChannelDepend channel = DependManager.getChannel(shareChannelType);
                if (channel != null) {
                    return channel.getChannelHandler();
                }
                return null;
            default:
                return null;
        }
    }
}
