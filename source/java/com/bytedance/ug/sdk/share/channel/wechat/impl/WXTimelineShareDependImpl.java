package com.bytedance.ug.sdk.share.channel.wechat.impl;

import android.content.Context;
import com.bytedance.share_wechat.R;
import com.bytedance.ug.sdk.share.impl.share.api.IShare;
import com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend;
import com.bytedance.ug.sdk.share.impl.share.api.IShareHandler;
import com.bytedance.ug.sdk.share.impl.utils.ToolUtils;

/* loaded from: classes4.dex */
public class WXTimelineShareDependImpl implements IShareChannelDepend {
    public static final String PACKAGE_NAME = "com.tencent.mm";
    private Context mContext;

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public IShareHandler getChannelHandler() {
        return null;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public String getPackageName() {
        return "com.tencent.mm";
    }

    public WXTimelineShareDependImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public IShare getChannel(Context context) {
        return new WXShare(context);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public int getChannelIcon() {
        return R.drawable.share_sdk_share_icon_circle_friends;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public String getChannelName() {
        return this.mContext.getString(R.string.share_sdk_action_weixin_timeline);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public boolean needFiltered() {
        return !ToolUtils.isInstalledApp("com.tencent.mm");
    }
}
