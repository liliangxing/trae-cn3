package com.bytedance.ug.sdk.share.channel.longimage.impl;

import android.content.Context;
import com.bytedance.share_image_token.R;
import com.bytedance.ug.sdk.share.impl.share.api.IShare;
import com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend;
import com.bytedance.ug.sdk.share.impl.share.api.IShareHandler;

/* loaded from: classes4.dex */
public class LongImageShareDependImpl implements IShareChannelDepend {
    private Context mContext;

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public IShareHandler getChannelHandler() {
        return null;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public String getPackageName() {
        return null;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public boolean needFiltered() {
        return false;
    }

    public LongImageShareDependImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public IShare getChannel(Context context) {
        return new LongImageShare(context);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public int getChannelIcon() {
        return R.drawable.share_sdk_share_icon_long_image;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShareChannelDepend
    public String getChannelName() {
        return this.mContext.getString(R.string.share_sdk_action_longimage_share);
    }
}
