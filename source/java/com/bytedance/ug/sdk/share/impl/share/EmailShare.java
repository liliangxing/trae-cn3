package com.bytedance.ug.sdk.share.impl.share;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
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
public class EmailShare extends AbstractShare {
    public EmailShare(Context context) {
        super(context);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean doShare(ShareContent shareContent) {
        this.mShareContent = shareContent;
        if (this.mContext == null && shareContent == null) {
            return false;
        }
        int i = C10944.f161x723cd226[shareContent.getShareContentType().ordinal()];
        if (i == 1) {
            return shareText(shareContent);
        }
        if (i == 2) {
            return shareTextAndImage(shareContent);
        }
        if (i == 3) {
            return shareImage(shareContent);
        }
        if (i != 4) {
            return shareTextAndImage(shareContent) || shareText(shareContent) || shareImage(shareContent) || shareVideo(shareContent);
        }
        return shareVideo(shareContent);
    }

    /* renamed from: com.bytedance.ug.sdk.share.impl.share.EmailShare$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static /* synthetic */ class C10944 {

        /* renamed from: $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareContentType */
        static final /* synthetic */ int[] f161x723cd226;

        static {
            int[] iArr = new int[ShareContentType.values().length];
            f161x723cd226 = iArr;
            try {
                iArr[ShareContentType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f161x723cd226[ShareContentType.TEXT_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f161x723cd226[ShareContentType.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f161x723cd226[ShareContentType.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private boolean shareTextAndImage(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getImageUrl())) {
            return false;
        }
        if (!HttpUtils.isUrl(shareContent.getImageUrl())) {
            return startEmail(shareContent, shareContent.getImageUrl(), true);
        }
        new ImageShareHelper().shareImage(shareContent, new ImageShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.EmailShare.1
            @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
            public void onShareFailed() {
            }

            @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
            public void onShareSuccess(String str) {
                EmailShare.this.startEmail(shareContent, str, true);
            }
        }, false);
        return true;
    }

    private boolean shareText(ShareContent shareContent) {
        return startEmail(shareContent, null, true);
    }

    private boolean shareImage(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getImageUrl())) {
            return false;
        }
        if (!HttpUtils.isUrl(shareContent.getImageUrl())) {
            return startEmail(shareContent, shareContent.getImageUrl(), false);
        }
        new ImageShareHelper().shareImage(shareContent, new ImageShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.EmailShare.2
            @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
            public void onShareFailed() {
            }

            @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
            public void onShareSuccess(String str) {
                EmailShare.this.startEmail(shareContent, str, false);
            }
        }, false);
        return true;
    }

    private boolean shareVideo(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getVideoUrl())) {
            return false;
        }
        new VideoShareHelper().shareVideo(shareContent, new VideoShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.EmailShare.3
            @Override // com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback
            public void onShareFailed() {
            }

            @Override // com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback
            public void onShareSuccess(String str) {
                EmailShare.this.startEmail(shareContent, str, true);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startEmail(ShareContent shareContent, String str, boolean z) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc882");
        if (z) {
            intent.putExtra("android.intent.extra.SUBJECT", shareContent.getTitle());
            intent.putExtra("android.intent.extra.TEXT", shareContent.getText());
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("android.intent.extra.STREAM", ShareUtils.getFileProviderUri(str));
        }
        ShareResult.sendShareStatus(10000, shareContent);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }
}
