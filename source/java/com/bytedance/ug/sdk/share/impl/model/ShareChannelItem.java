package com.bytedance.ug.sdk.share.impl.model;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.PanelItemType;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.share.StrategyDispatcher;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareChannelItem extends BaseShareItem {
    private ShareChannelType mShareItemType;

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public String getIconUrl() {
        return null;
    }

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public int getTextId() {
        return 0;
    }

    public ShareChannelItem(ShareChannelType shareChannelType) {
        this.mShareItemType = shareChannelType;
    }

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public PanelItemType getItemType() {
        return this.mShareItemType;
    }

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public void onItemClick(Context context, View view, ShareContent shareContent) {
        if (shareContent == null) {
            return;
        }
        if (StrategyDispatcher.dispatchStrategy(context, shareContent)) {
            ShareEvent.sendShareSuccessEvent(shareContent, ShareUtils.isRealH5Share(shareContent));
            MonitorEvent.monitorPanelClick(1, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
        } else {
            MonitorEvent.monitorPanelClick(3, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
        }
    }

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public String getTextStr() {
        if (!TextUtils.isEmpty(this.mItemTextStr)) {
            return this.mItemTextStr;
        }
        String resourceIconText = ShareConfigManager.getInstance().getResourceIconText(this.mShareItemType);
        if (!TextUtils.isEmpty(resourceIconText)) {
            return resourceIconText;
        }
        if (ShareSdkManager.getInstance().getAppContext() != null) {
            if (this.mShareItemType == ShareChannelType.COPY_LINK) {
                return ShareSdkManager.getInstance().getAppContext().getString(C1010R.string.share_sdk_action_copy_url);
            }
            if (this.mShareItemType == ShareChannelType.SYSTEM) {
                return ShareSdkManager.getInstance().getAppContext().getString(C1010R.string.share_sdk_action_system_share);
            }
            if (this.mShareItemType == ShareChannelType.SMS) {
                return ShareSdkManager.getInstance().getAppContext().getString(C1010R.string.share_sdk_action_sms_share);
            }
            if (this.mShareItemType == ShareChannelType.EMAIL) {
                return ShareSdkManager.getInstance().getAppContext().getString(C1010R.string.share_sdk_action_email_share);
            }
        }
        return "";
    }

    @Override // com.bytedance.ug.sdk.share.api.panel.IPanelItem
    public int getIconId() {
        if (this.mItemIconId > 0) {
            return this.mItemIconId;
        }
        int resourceIcon = ShareConfigManager.getInstance().getResourceIcon(this.mShareItemType);
        if (resourceIcon > 0) {
            return resourceIcon;
        }
        if (this.mShareItemType == ShareChannelType.COPY_LINK) {
            return C1010R.drawable.share_sdk_share_icon_copylink;
        }
        if (this.mShareItemType == ShareChannelType.SYSTEM) {
            return C1010R.drawable.share_sdk_share_icon_system;
        }
        if (this.mShareItemType == ShareChannelType.SMS) {
            return C1010R.drawable.share_sdk_share_icon_sms;
        }
        return this.mShareItemType == ShareChannelType.EMAIL ? C1010R.drawable.share_sdk_share_icon_email : resourceIcon;
    }
}
