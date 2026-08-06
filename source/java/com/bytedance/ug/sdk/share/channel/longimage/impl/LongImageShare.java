package com.bytedance.ug.sdk.share.channel.longimage.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareExtra;
import com.bytedance.ug.sdk.share.api.panel.PanelContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.channel.longimage.model.ImagePanelExtra;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.share.AbstractShare;
import com.bytedance.ug.sdk.share.impl.utils.LoadingUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LongImageShare extends AbstractShare {
    public LongImageShare(Context context) {
        super(context);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean doShare(final ShareContent shareContent) {
        Activity topActivity;
        this.mShareContent = shareContent;
        if (shareContent == null || (topActivity = ShareConfigManager.getInstance().getTopActivity()) == null) {
            return false;
        }
        if (shareContent.getImage() != null) {
            showDialog(topActivity, shareContent);
            return true;
        }
        if (TextUtils.isEmpty(shareContent.getHiddenImageUrl())) {
            return false;
        }
        LoadingUtils.showProgressDialog(shareContent);
        final WeakReference weakReference = new WeakReference(topActivity);
        ShareConfigManager.getInstance().getImageBitmap(shareContent.getHiddenImageUrl(), new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.channel.longimage.impl.LongImageShare.1
            @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
            public void onSuccess(final Bitmap bitmap) {
                LoadingUtils.dismissProgressDialog();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.channel.longimage.impl.LongImageShare.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Activity activity;
                        Bitmap bitmap2 = bitmap;
                        if (bitmap2 == null || bitmap2.isRecycled() || (activity = (Activity) weakReference.get()) == null || shareContent == null) {
                            return;
                        }
                        shareContent.setImage(bitmap);
                        LongImageShare.this.showDialog(activity, shareContent);
                    }
                });
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
            public void onFailed() {
                LoadingUtils.dismissProgressDialog();
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(Activity activity, ShareContent shareContent) {
        long currentTimeMillis = System.currentTimeMillis();
        ShareExtra extraParams = shareContent.getExtraParams();
        if (extraParams == null || extraParams.getImagePanelExtra() == null || !(extraParams.getImagePanelExtra() instanceof ImagePanelExtra)) {
            MonitorEvent.monitorPanelShow(1, System.currentTimeMillis() - currentTimeMillis, shareContent.getPanelId(), "shareExtra error");
            return;
        }
        PanelContent secondaryPanel = ((ImagePanelExtra) extraParams.getImagePanelExtra()).getSecondaryPanel();
        if (secondaryPanel == null) {
            MonitorEvent.monitorPanelShow(1, System.currentTimeMillis() - currentTimeMillis, shareContent.getPanelId(), "secondaryPanel == null");
            return;
        }
        shareContent.setFromChannel(ShareChannelType.LONG_IMAGE);
        PanelContent.PanelContentBuilder panelContentBuilder = new PanelContent.PanelContentBuilder(activity);
        panelContentBuilder.withShareContent(shareContent);
        if (!TextUtils.isEmpty(secondaryPanel.getCancelText())) {
            panelContentBuilder.withCancelBtnText(secondaryPanel.getCancelText());
        }
        if (!TextUtils.isEmpty(secondaryPanel.getPanelId())) {
            panelContentBuilder.withPanelId(secondaryPanel.getPanelId());
        } else {
            panelContentBuilder.withPanelId(shareContent.getPanelId());
        }
        if (!TextUtils.isEmpty(secondaryPanel.getResourceId())) {
            panelContentBuilder.withResourceId(secondaryPanel.getResourceId());
        } else {
            panelContentBuilder.withResourceId(shareContent.getResourceId());
        }
        if (secondaryPanel.getRequestData() != null) {
            panelContentBuilder.withRequestData(secondaryPanel.getRequestData());
        }
        if (secondaryPanel.getOnPanelActionCallback() != null) {
            panelContentBuilder.withPanelActionCallback(secondaryPanel.getOnPanelActionCallback());
        }
        if (secondaryPanel.getPanelItemsCallback() != null) {
            panelContentBuilder.withPanelItemsCallback(secondaryPanel.getPanelItemsCallback());
        }
        if (secondaryPanel.getPanel() != null) {
            panelContentBuilder.withPanel(secondaryPanel.getPanel());
        }
        PanelContent build = panelContentBuilder.build();
        ISharePanel panel = build.getPanel();
        if (panel != null) {
            build.getShareContent().setFrom("undefined");
        } else {
            panel = ShareConfigManager.getInstance().getSharePanelWithPreview(build.getActivity(), build.getShareContent());
            if (panel == null) {
                MonitorEvent.monitorPanelShow(1, System.currentTimeMillis() - currentTimeMillis, shareContent.getPanelId(), "long image panel == null");
                return;
            }
        }
        boolean show = new SharePanelWithPreviewProxy(build, panel).show();
        MonitorEvent.monitorPanelShow(!show ? 1 : 0, System.currentTimeMillis() - currentTimeMillis, shareContent.getPanelId(), show ? "success" : "long image activity is not active");
    }
}
