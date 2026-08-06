package com.bytedance.ug.sdk.share.impl.constant;

import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class ShareChannelConstants {
    public static final String CONFIG_BASE_PATH = "com.bytedance.ug.sdk.share.keep.impl.";
    public static HashMap<ShareChannelType, String> sShareConfig;

    static {
        HashMap<ShareChannelType, String> hashMap = new HashMap<>();
        sShareConfig = hashMap;
        hashMap.put(ShareChannelType.WX, "com.bytedance.ug.sdk.share.keep.impl.WXShareImpl");
        sShareConfig.put(ShareChannelType.WX_TIMELINE, "com.bytedance.ug.sdk.share.keep.impl.WXTimelineShareImpl");
        sShareConfig.put(ShareChannelType.QQ, "com.bytedance.ug.sdk.share.keep.impl.QQShareImpl");
        sShareConfig.put(ShareChannelType.QZONE, "com.bytedance.ug.sdk.share.keep.impl.QZoneShareImpl");
        sShareConfig.put(ShareChannelType.DINGDING, "com.bytedance.ug.sdk.share.keep.impl.DDShareImpl");
        sShareConfig.put(ShareChannelType.DOUYIN, "com.bytedance.ug.sdk.share.keep.impl.DYShareImpl");
        sShareConfig.put(ShareChannelType.DOUYIN_IM, "com.bytedance.ug.sdk.share.keep.impl.DYIMShareImpl");
        sShareConfig.put(ShareChannelType.DOUYIN_STORY, "com.bytedance.ug.sdk.share.keep.impl.DYStoryShareImpl");
        sShareConfig.put(ShareChannelType.WEIBO, "com.bytedance.ug.sdk.share.keep.impl.WBShareImpl");
        sShareConfig.put(ShareChannelType.WEIBO_SG, "com.bytedance.ug.sdk.share.keep.impl.WBSGShareImpl");
        sShareConfig.put(ShareChannelType.FEILIAO, "com.bytedance.ug.sdk.share.keep.impl.FLShareImpl");
        sShareConfig.put(ShareChannelType.DUOSHAN, "com.bytedance.ug.sdk.share.keep.impl.DSShareImpl");
        sShareConfig.put(ShareChannelType.TOUTIAO, "com.bytedance.ug.sdk.share.keep.impl.TTShareImpl");
        sShareConfig.put(ShareChannelType.FEISHU, "com.bytedance.ug.sdk.share.keep.impl.FSShareImpl");
        sShareConfig.put(ShareChannelType.ZHIFUBAO, "com.bytedance.ug.sdk.share.keep.impl.ZFBShareImpl");
        sShareConfig.put(ShareChannelType.FACEBOOK, "com.bytedance.ug.sdk.share.keep.impl.FacebookShareImpl");
        sShareConfig.put(ShareChannelType.FACEBOOK_STORY, "com.bytedance.ug.sdk.share.keep.impl.FacebookStoryShareImpl");
        sShareConfig.put(ShareChannelType.LINE, "com.bytedance.ug.sdk.share.keep.impl.LineShareImpl");
        sShareConfig.put(ShareChannelType.WHATSAPP, "com.bytedance.ug.sdk.share.keep.impl.WhatsAppShareImpl");
        sShareConfig.put(ShareChannelType.WHATSAPP_STATUS, "com.bytedance.ug.sdk.share.keep.impl.WhatsAppStatusShareImpl");
        sShareConfig.put(ShareChannelType.INSTAGRAM, "com.bytedance.ug.sdk.share.keep.impl.InstagramShareImpl");
        sShareConfig.put(ShareChannelType.INSTAGRAM_STORY, "com.bytedance.ug.sdk.share.keep.impl.InstagramStoryShareImpl");
        sShareConfig.put(ShareChannelType.TIKTOK, "com.bytedance.ug.sdk.share.keep.impl.TiktokShareImpl");
        sShareConfig.put(ShareChannelType.TWITTER, "com.bytedance.ug.sdk.share.keep.impl.TwitterShareImpl");
        sShareConfig.put(ShareChannelType.KAKAO, "com.bytedance.ug.sdk.share.keep.impl.KakaoShareImpl");
        sShareConfig.put(ShareChannelType.KAKAO_STORY, "com.bytedance.ug.sdk.share.keep.impl.KakaoStoryShareImpl");
        sShareConfig.put(ShareChannelType.SNAPCHAT, "com.bytedance.ug.sdk.share.keep.impl.SnapChatShareImpl");
        sShareConfig.put(ShareChannelType.MESSENGER, "com.bytedance.ug.sdk.share.keep.impl.MessengerShareImpl");
        sShareConfig.put(ShareChannelType.VK, "com.bytedance.ug.sdk.share.keep.impl.VKShareImpl");
        sShareConfig.put(ShareChannelType.TELEGRAM, "com.bytedance.ug.sdk.share.keep.impl.TelegramShareImpl");
        sShareConfig.put(ShareChannelType.IMAGE_SHARE, "com.bytedance.ug.sdk.share.keep.impl.ImageShareImpl");
        sShareConfig.put(ShareChannelType.LONG_IMAGE, "com.bytedance.ug.sdk.share.keep.impl.LongImageShareImpl");
        sShareConfig.put(ShareChannelType.VIDEO_SAVE, "com.bytedance.ug.sdk.share.keep.impl.VideoSaveImpl");
    }
}
