package com.bytedance.ug.sdk.share.api.depend;

import android.app.Activity;
import android.content.Context;
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
import com.bytedance.ug.sdk.share.impl.p009ui.panel.ISharePanel;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IShareUIConfig {
    IDownloadProgressDialog getDownloadProgressDialog(Activity activity);

    IImageTokenDialog getImageTokenDialog(Activity activity);

    IRecognizeTokenDialog getRecognizeTokenDialog(Activity activity, TokenInfoBean tokenInfoBean);

    int getShareIconResource(ShareChannelType shareChannelType);

    String getShareIconText(ShareChannelType shareChannelType);

    ISharePanel getSharePanel(Activity activity);

    ISharePanel getSharePanelWithPreview(Activity activity);

    IShareProgressView getShareProgressView(Activity activity);

    IShareTokenDialog getShareTokenDialog(Activity activity);

    ISystemOptShareTokenDialog getSystemOptShareTokenDialog(Activity activity);

    IVideoGuideDialog getVideoGuideDialog(Activity activity);

    IVideoShareDialog getVideoShareDialog(Activity activity);

    boolean showToast(Context context, ShareContent shareContent, int i, int i2);

    boolean showToastWithIcon(Context context, ShareContent shareContent, int i, int i2, int i3);
}
