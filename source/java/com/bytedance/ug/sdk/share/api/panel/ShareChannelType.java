package com.bytedance.ug.sdk.share.api.panel;

import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareConstant;
import com.bytedance.ug.sdk.share.impl.manager.DependManager;
import com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend;

/* loaded from: classes4.dex */
public enum ShareChannelType implements PanelItemType {
    WX_TIMELINE(ShareConstant.WECHAT_MOMENT, "朋友圈", "com.tencent.mm"),
    WX("wechat", "微信", "com.tencent.mm"),
    QQ(ShareConstant.QQ, "QQ", "com.tencent.mobileqq"),
    QZONE(ShareConstant.QQ_ZONE, "QQ空间", "com.tencent.mobileqq"),
    WEIBO(ShareConstant.WB),
    WEIBO_SG(ShareConstant.WB_SG),
    FEILIAO(ShareConstant.FL),
    DUOSHAN(ShareConstant.DS),
    DINGDING(ShareConstant.DD),
    DOUYIN("douyin"),
    DOUYIN_IM(ShareConstant.DY_IM),
    DOUYIN_STORY(ShareConstant.DY_STORY),
    TOUTIAO("toutiao"),
    FEISHU(ShareConstant.FEISHU),
    ZHIFUBAO(ShareConstant.ZHIFUBAO),
    SYSTEM(ShareConstant.SYSTEM),
    COPY_LINK(ShareConstant.COPY_LINK),
    SMS("sms"),
    EMAIL("email"),
    IMAGE_SHARE(ShareConstant.IMAGE_SHARE),
    LONG_IMAGE(ShareConstant.LONG_IMAGE),
    VIDEO_SAVE(ShareConstant.VIDEO_SAVE),
    FACEBOOK("facebook"),
    FACEBOOK_STORY(ShareConstant.FACEBOOK_STORY),
    FACEBOOK_LITE(ShareConstant.FACEBOOK_LITE),
    MESSENGER(ShareConstant.MESSENGER),
    MESSENGER_LITE(ShareConstant.MESSENGER_LITE),
    LINE("line"),
    WHATSAPP(ShareConstant.WHATSAPP),
    WHATSAPP_STATUS(ShareConstant.WHATSAPP_STATUS),
    INSTAGRAM("instagram"),
    INSTAGRAM_STORY(ShareConstant.INSTAGRAM_STORY),
    TIKTOK("tiktok"),
    TWITTER("twitter"),
    KAKAO(ShareConstant.KAKAO),
    KAKAO_STORY(ShareConstant.KAKAO_STORY),
    SNAPCHAT(ShareConstant.SNAPCHAT),
    BAND(ShareConstant.BAND),
    IMGUR(ShareConstant.IMGUR),
    NAVERBLOG(ShareConstant.NAVERBLOG),
    NAVERCAFE(ShareConstant.NAVERCAFE),
    VIBER(ShareConstant.VIBER),
    VK("vk"),
    TELEGRAM(ShareConstant.TELEGRAM),
    ZALO(ShareConstant.ZALO),
    REDDIT(ShareConstant.REDDIT);

    private final String mChannelName;
    private final String mKey;
    private final String mPackageName;

    ShareChannelType(String str) {
        this.mKey = str;
        this.mChannelName = "";
        this.mPackageName = "";
    }

    ShareChannelType(String str, String str2, String str3) {
        this.mKey = str;
        this.mChannelName = str2;
        this.mPackageName = str3;
    }

    public static ShareChannelType getShareItemType(String str) {
        for (ShareChannelType shareChannelType : values()) {
            if (shareChannelType.mKey.equals(str)) {
                return shareChannelType;
            }
        }
        return null;
    }

    public static String getShareItemTypeName(ShareChannelType shareChannelType) {
        return shareChannelType == null ? "" : shareChannelType.mKey;
    }

    public static String getShareChannelName(ShareChannelType shareChannelType) {
        if (shareChannelType != null && !TextUtils.isEmpty(shareChannelType.mChannelName)) {
            return shareChannelType.mChannelName;
        }
        IShareChannelDepend channel = DependManager.getChannel(shareChannelType);
        return (channel == null || channel.getChannelName() == null) ? "" : channel.getChannelName();
    }

    public static String getSharePackageName(ShareChannelType shareChannelType) {
        if (shareChannelType != null && !TextUtils.isEmpty(shareChannelType.mPackageName)) {
            return shareChannelType.mPackageName;
        }
        IShareChannelDepend channel = DependManager.getChannel(shareChannelType);
        return (channel == null || channel.getPackageName() == null) ? "" : channel.getPackageName();
    }
}
