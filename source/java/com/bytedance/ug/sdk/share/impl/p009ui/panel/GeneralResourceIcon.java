package com.bytedance.ug.sdk.share.impl.p009ui.panel;

import com.bytedance.share_ui.R;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.manager.DependManager;
import com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GeneralResourceIcon {
    public static int getResourceIcon(ShareChannelType shareChannelType) {
        IShareChannelDepend channel = DependManager.getChannel(shareChannelType);
        if (channel != null) {
            return channel.getChannelIcon();
        }
        int i = C11071.$SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[shareChannelType.ordinal()];
        if (i == 1) {
            return R.drawable.share_sdk_share_icon_copylink;
        }
        if (i == 2) {
            return R.drawable.share_sdk_share_icon_system;
        }
        if (i == 3) {
            return R.drawable.share_sdk_share_icon_sms;
        }
        if (i != 4) {
            return 0;
        }
        return R.drawable.share_sdk_share_icon_email;
    }

    /* renamed from: com.bytedance.ug.sdk.share.impl.ui.panel.GeneralResourceIcon$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static /* synthetic */ class C11071 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType;

        static {
            int[] iArr = new int[ShareChannelType.values().length];
            $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType = iArr;
            try {
                iArr[ShareChannelType.COPY_LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[ShareChannelType.SYSTEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[ShareChannelType.SMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[ShareChannelType.EMAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String getResourceIconText(ShareChannelType shareChannelType) {
        IShareChannelDepend channel = DependManager.getChannel(shareChannelType);
        if (channel != null) {
            return channel.getChannelName();
        }
        int i = C11071.$SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[shareChannelType.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "Email" : "短信" : "系统分享" : "复制链接";
    }
}
