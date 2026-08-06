package com.bytedance.ug.sdk.share.impl.share;

import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.text.TextUtils;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback;
import com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback;
import com.bytedance.ug.sdk.share.impl.helper.ImageShareHelper;
import com.bytedance.ug.sdk.share.impl.helper.VideoShareHelper;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToolUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SmsShare extends AbstractShare {
    public SmsShare(Context context) {
        super(context);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean doShare(ShareContent shareContent) {
        this.mShareContent = shareContent;
        if (this.mContext == null && shareContent == null) {
            return false;
        }
        int i = C10983.f162x723cd226[shareContent.getShareContentType().ordinal()];
        if (i == 1) {
            return shareText(shareContent);
        }
        if (i == 2) {
            return shareImage(shareContent, true);
        }
        if (i == 3) {
            return shareImage(shareContent, false);
        }
        if (i != 4) {
            return shareImage(shareContent, true) || shareText(shareContent) || shareImage(shareContent, false) || shareVideo(shareContent);
        }
        return shareVideo(shareContent);
    }

    /* renamed from: com.bytedance.ug.sdk.share.impl.share.SmsShare$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static /* synthetic */ class C10983 {

        /* renamed from: $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareContentType */
        static final /* synthetic */ int[] f162x723cd226;

        static {
            int[] iArr = new int[ShareContentType.values().length];
            f162x723cd226 = iArr;
            try {
                iArr[ShareContentType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f162x723cd226[ShareContentType.TEXT_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f162x723cd226[ShareContentType.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f162x723cd226[ShareContentType.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private boolean shareText(ShareContent shareContent) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(SccDelegate.MIMETYPE_TEXT_PLAIN);
        intent.putExtra("android.intent.extra.TEXT", dealWithShareText(shareContent.getTitle(), shareContent.getTargetUrl()));
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(this.mContext);
        if (defaultSmsPackage != null) {
            intent.setPackage(defaultSmsPackage);
        }
        ShareResult.sendShareStatus(10000, shareContent);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }

    private boolean shareImage(final ShareContent shareContent, boolean z) {
        if (TextUtils.isEmpty(shareContent.getImageUrl())) {
            return false;
        }
        final Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(this.mContext);
        if (defaultSmsPackage != null) {
            intent.setPackage(defaultSmsPackage);
        }
        if (z) {
            intent.putExtra("android.intent.extra.TEXT", dealWithShareText(shareContent.getTitle(), shareContent.getTargetUrl()));
        }
        if (!HttpUtils.isUrl(shareContent.getImageUrl())) {
            intent.putExtra("android.intent.extra.STREAM", ShareUtils.getFileProviderUri(shareContent.getImageUrl()));
            ShareResult.sendShareStatus(10000, shareContent);
            return ToolUtils.tryStartIntent(this.mContext, intent);
        }
        new ImageShareHelper().shareImage(shareContent, new ImageShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.SmsShare.1
            @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
            public void onShareFailed() {
            }

            @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
            public void onShareSuccess(String str) {
                intent.putExtra("android.intent.extra.STREAM", ShareUtils.getFileProviderUri(str));
                ShareResult.sendShareStatus(10000, shareContent);
                ToolUtils.tryStartIntent(SmsShare.this.mContext, intent);
            }
        }, false);
        return true;
    }

    private boolean shareVideo(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getVideoUrl())) {
            return false;
        }
        final Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(this.mContext);
        if (defaultSmsPackage != null) {
            intent.setPackage(defaultSmsPackage);
        }
        new VideoShareHelper().shareVideo(shareContent, new VideoShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.SmsShare.2
            @Override // com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback
            public void onShareFailed() {
            }

            @Override // com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback
            public void onShareSuccess(String str) {
                intent.putExtra("android.intent.extra.STREAM", ShareUtils.getFileProviderUri(str));
                ShareResult.sendShareStatus(10000, shareContent);
                ToolUtils.tryStartIntent(SmsShare.this.mContext, intent);
            }
        });
        return true;
    }

    private String dealWithShareText(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return String.format(this.mContext.getString(C1010R.string.share_sdk_system_share_fmt_new2), str, str2);
    }
}
