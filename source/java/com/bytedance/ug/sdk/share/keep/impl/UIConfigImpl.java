package com.bytedance.ug.sdk.share.keep.impl;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ug.sdk.share.api.depend.IShareUIConfig;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.api.p008ui.IDownloadProgressDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IImageTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IRecognizeTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IShareProgressView;
import com.bytedance.ug.sdk.share.api.p008ui.IShareTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.ISystemOptShareTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoGuideDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoShareDialog;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.GeneralResourceIcon;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.GeneralSharePanel;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;
import com.bytedance.ug.sdk.share.impl.p009ui.panel.SharePanelWithPreview;
import com.bytedance.ug.sdk.share.impl.p009ui.toast.ToastUtils;
import com.bytedance.ug.sdk.share.impl.p009ui.token.TokenDialogManager;
import com.bytedance.ug.sdk.share.impl.p009ui.token.share.ImageTokenShareDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.token.share.SystemOptTokenShareDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.token.share.TokenShareDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.token.share.VideoShareDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.token.share.VideoShareGuideDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.view.DownloadProgressDialog;
import com.bytedance.ug.sdk.share.impl.p009ui.view.ShareProgressDialog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UIConfigImpl implements IShareUIConfig {
    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public int getShareIconResource(ShareChannelType shareChannelType) {
        return GeneralResourceIcon.getResourceIcon(shareChannelType);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public String getShareIconText(ShareChannelType shareChannelType) {
        return GeneralResourceIcon.getResourceIconText(shareChannelType);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public ISharePanel getSharePanel(Activity activity) {
        return new GeneralSharePanel(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public ISharePanel getSharePanelWithPreview(Activity activity) {
        return new SharePanelWithPreview(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public IRecognizeTokenDialog getRecognizeTokenDialog(Activity activity, TokenInfoBean tokenInfoBean) {
        return TokenDialogManager.getInstance().getRecognizeTokenDialog(activity, tokenInfoBean);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public IShareTokenDialog getShareTokenDialog(Activity activity) {
        return new TokenShareDialog(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public IImageTokenDialog getImageTokenDialog(Activity activity) {
        return new ImageTokenShareDialog(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public ISystemOptShareTokenDialog getSystemOptShareTokenDialog(Activity activity) {
        return new SystemOptTokenShareDialog(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public IVideoGuideDialog getVideoGuideDialog(Activity activity) {
        return new VideoShareGuideDialog(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public IVideoShareDialog getVideoShareDialog(Activity activity) {
        return new VideoShareDialog(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public IShareProgressView getShareProgressView(Activity activity) {
        return new ShareProgressDialog(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public IDownloadProgressDialog getDownloadProgressDialog(Activity activity) {
        return new DownloadProgressDialog(activity);
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public boolean showToast(Context context, ShareContent shareContent, int i, int i2) {
        ToastUtils.showToast(context, i2);
        return true;
    }

    @Override // com.bytedance.ug.sdk.share.api.depend.IShareUIConfig
    public boolean showToastWithIcon(Context context, ShareContent shareContent, int i, int i2, int i3) {
        return ToastUtils.showToastWithIcon(context, i2, i3);
    }
}
