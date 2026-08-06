package com.bytedance.ug.sdk.share.channel.longimage.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.panel.IPanelItem;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.image.utils.ImageSaveUtils;
import com.bytedance.ug.sdk.share.impl.helper.ImageShareHelper;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.SharePanelProxy;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SharePanelWithPreviewProxy extends SharePanelProxy {
    public SharePanelWithPreviewProxy(PanelContent panelContent, ISharePanel iSharePanel) {
        super(panelContent, iSharePanel);
    }

    @Override // com.bytedance.ug.sdk.share.impl.p009ui.panel.SharePanelProxy
    protected void onItemClick(IPanelItem iPanelItem, View view, ShareContent shareContent) {
        Activity activity = this.mContextRef.get();
        if (activity == null) {
            return;
        }
        if (shareContent.getShareChanelType() == ShareChannelType.IMAGE_SHARE) {
            iPanelItem.onItemClick(activity, view, shareContent);
            return;
        }
        if (shareContent.getImage() == null) {
            return;
        }
        ImageSaveUtils.writeHiddenWatermark(shareContent);
        String saveImagePath = new ImageShareHelper().getSaveImagePath(shareContent.getImage());
        if (TextUtils.isEmpty(saveImagePath)) {
            return;
        }
        shareContent.setImageUrl(saveImagePath);
        shareContent.setShareContentType(ShareContentType.IMAGE);
        shareContent.setSystemShareType(ShareContentType.IMAGE);
        iPanelItem.onItemClick(activity, view, shareContent);
    }
}
