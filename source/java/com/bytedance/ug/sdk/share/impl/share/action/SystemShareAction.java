package com.bytedance.ug.sdk.share.impl.share.action;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareExtra;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.entity.SystemExtra;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.callback.FileShareCallback;
import com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback;
import com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback;
import com.bytedance.ug.sdk.share.impl.helper.FileShareHelper;
import com.bytedance.ug.sdk.share.impl.helper.ImageShareHelper;
import com.bytedance.ug.sdk.share.impl.helper.VideoShareHelper;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToolUtils;
import java.net.URLConnection;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SystemShareAction {
    private static final String TAG = "SystemShareAction";

    /* renamed from: com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    static /* synthetic */ class C11035 {

        /* renamed from: $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareContentType */
        static final /* synthetic */ int[] f163x723cd226;

        static {
            int[] iArr = new int[ShareContentType.values().length];
            f163x723cd226 = iArr;
            try {
                iArr[ShareContentType.TEXT_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f163x723cd226[ShareContentType.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f163x723cd226[ShareContentType.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f163x723cd226[ShareContentType.FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f163x723cd226[ShareContentType.TEXT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static boolean shareTo(Context context, ShareChannelType shareChannelType, ShareContent shareContent) {
        if (context == null || shareContent == null) {
            return false;
        }
        int i = C11035.f163x723cd226[shareContent.getSystemShareType().ordinal()];
        if (i == 1 || i == 2) {
            return shareImage(context, shareChannelType, shareContent);
        }
        if (i == 3) {
            return shareVideo(context, shareChannelType, shareContent);
        }
        if (i == 4) {
            return shareFile(context, shareChannelType, shareContent);
        }
        return shareTo(context, shareChannelType, shareContent, null);
    }

    private static boolean shareImage(final Context context, final ShareChannelType shareChannelType, final ShareContent shareContent) {
        final ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(shareContent.getImageUrl())) {
            if (!HttpUtils.isUrl(shareContent.getImageUrl())) {
                Uri uriFromPath = FileUtils.getUriFromPath(context, shareContent.getImageUrl(), false);
                if (uriFromPath != null) {
                    arrayList.add(uriFromPath);
                }
            } else {
                new ImageShareHelper().shareImage(shareContent, new ImageShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction.1
                    @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
                    public void onShareSuccess(String str) {
                        Uri uriFromPath2 = FileUtils.getUriFromPath(context, str, false);
                        if (uriFromPath2 != null) {
                            arrayList.add(uriFromPath2);
                        }
                        SystemShareAction.shareTo(context, shareChannelType, shareContent, arrayList);
                    }

                    @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
                    public void onShareFailed() {
                        ShareResult.sendShareStatus(ShareResult.ERROR_SDK_IMAGE_FETCH_FAILED, shareContent);
                    }
                }, false);
                return true;
            }
        }
        return shareTo(context, shareChannelType, shareContent, arrayList);
    }

    private static boolean shareVideo(final Context context, final ShareChannelType shareChannelType, final ShareContent shareContent) {
        if (!TextUtils.isEmpty(shareContent.getVideoUrl())) {
            new VideoShareHelper().shareVideo(shareContent, new VideoShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction.2
                @Override // com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback
                public void onShareSuccess(String str) {
                    ShareResult.sendShareStatus(10000, ShareContent.this);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("video/*");
                    intent.putExtra("android.intent.extra.STREAM", FileUtils.getUriFromPath(context, str, true));
                    ShareExtra extraParams = ShareContent.this.getExtraParams();
                    String chooserStr = (extraParams == null || !(extraParams.getSystemExtra() instanceof SystemExtra)) ? "" : ((SystemExtra) extraParams.getSystemExtra()).getChooserStr();
                    if (TextUtils.isEmpty(chooserStr)) {
                        chooserStr = context.getString(C1010R.string.share_sdk_action_system_share);
                    }
                    SystemShareAction.shareBySystem(context, intent, shareChannelType, chooserStr);
                }

                @Override // com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback
                public void onShareFailed() {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_VIDEO_FETCH_FAILED, ShareContent.this);
                }
            });
            return true;
        }
        return shareTo(context, shareChannelType, shareContent, null);
    }

    private static boolean shareFile(final Context context, final ShareChannelType shareChannelType, final ShareContent shareContent) {
        if (!TextUtils.isEmpty(shareContent.getFileUrl()) && !TextUtils.isEmpty(shareContent.getFileName())) {
            FileShareHelper.getInstance().shareFile(shareContent, new FileShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction.3
                @Override // com.bytedance.ug.sdk.share.impl.callback.FileShareCallback
                public void onShareSuccess(String str) {
                    ShareResult.sendShareStatus(10000, ShareContent.this);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.setType("*/*");
                    intent.putExtra("android.intent.extra.STREAM", ShareUtils.getFileProviderUri(str));
                    ShareExtra extraParams = ShareContent.this.getExtraParams();
                    String chooserStr = (extraParams == null || !(extraParams.getSystemExtra() instanceof SystemExtra)) ? "" : ((SystemExtra) extraParams.getSystemExtra()).getChooserStr();
                    if (TextUtils.isEmpty(chooserStr)) {
                        chooserStr = context.getString(C1010R.string.share_sdk_action_system_share);
                    }
                    SystemShareAction.shareBySystem(context, intent, shareChannelType, chooserStr);
                }

                @Override // com.bytedance.ug.sdk.share.impl.callback.FileShareCallback
                public void onShareFailed() {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_FILE_FETCH_FAILED, ShareContent.this);
                }
            });
            return true;
        }
        return shareTo(context, shareChannelType, shareContent, null);
    }

    public static boolean shareTo(final Context context, final ShareChannelType shareChannelType, final ShareContent shareContent, final ArrayList<Uri> arrayList) {
        if (shareContent == null) {
            return false;
        }
        new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String str2;
                String str3;
                Intent intent = new Intent();
                ArrayList arrayList2 = arrayList;
                if (arrayList2 == null || arrayList2.size() <= 0) {
                    intent.setAction("android.intent.action.SEND");
                    intent.setType(SccDelegate.MIMETYPE_TEXT_PLAIN);
                } else {
                    String str4 = "image/*";
                    if (arrayList.size() == 1) {
                        intent.setAction("android.intent.action.SEND");
                        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(((Uri) arrayList.get(0)).toString());
                        if (contentTypeFor != null && contentTypeFor.length() > 0) {
                            str4 = contentTypeFor;
                        }
                        intent.setType(str4);
                        intent.putExtra("android.intent.extra.STREAM", (Parcelable) arrayList.get(0));
                    } else {
                        intent.setAction("android.intent.action.SEND_MULTIPLE");
                        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                        intent.setType("image/*");
                    }
                }
                ShareExtra extraParams = shareContent.getExtraParams();
                if (extraParams == null || !(extraParams.getSystemExtra() instanceof SystemExtra)) {
                    str = "";
                    str2 = "";
                    str3 = str2;
                } else {
                    SystemExtra systemExtra = (SystemExtra) extraParams.getSystemExtra();
                    str = systemExtra.getChooserStr();
                    str3 = systemExtra.getSubject();
                    str2 = systemExtra.getText();
                }
                if (TextUtils.isEmpty(str)) {
                    str = context.getString(C1010R.string.share_sdk_action_system_share);
                }
                if (!TextUtils.isEmpty(str3)) {
                    intent.putExtra("android.intent.extra.SUBJECT", str3);
                } else if (!TextUtils.isEmpty(shareContent.getTitle())) {
                    intent.putExtra("android.intent.extra.SUBJECT", shareContent.getTitle());
                }
                if (TextUtils.isEmpty(str2)) {
                    String dealWithShareText = SystemShareAction.dealWithShareText(context, shareContent.getTitle(), shareContent.getTargetUrl());
                    intent.putExtra("android.intent.extra.TEXT", dealWithShareText);
                    intent.putExtra("Kdescription", dealWithShareText);
                } else {
                    intent.putExtra("android.intent.extra.TEXT", str2);
                    intent.putExtra("Kdescription", str2);
                }
                ShareResult.sendShareStatus(10000, shareContent);
                SystemShareAction.shareBySystem(context, intent, shareChannelType, str);
            }
        }.run();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shareBySystem(Context context, Intent intent, ShareChannelType shareChannelType, String str) {
        if (intent == null) {
            return;
        }
        if (shareChannelType == ShareChannelType.QQ) {
            intent.setClassName(ShareChannelType.getSharePackageName(shareChannelType), "com.tencent.mobileqq.activity.JumpActivity");
            intent.addFlags(268435456);
        } else if (shareChannelType == ShareChannelType.WX) {
            intent.setClassName(ShareChannelType.getSharePackageName(shareChannelType), "com.tencent.mm.ui.tools.ShareImgUI");
            if (!ShareUtils.useThirdAppSwitch()) {
                intent = Intent.createChooser(intent, str);
            }
        } else if (shareChannelType == ShareChannelType.WX_TIMELINE) {
            intent.setClassName(ShareChannelType.getSharePackageName(shareChannelType), "com.tencent.mm.ui.tools.ShareToTimeLineUI");
            if (!ShareUtils.useThirdAppSwitch()) {
                intent = Intent.createChooser(intent, str);
            }
        } else if (shareChannelType == ShareChannelType.QZONE) {
            intent.setClassName("com.qzone", "com.qzonex.module.operation.ui.QZonePublishMoodActivity");
        } else if (shareChannelType == ShareChannelType.WEIBO) {
            intent.setClassName(ShareChannelType.getSharePackageName(shareChannelType), "com.sina.weibo.composerinde.ComposerDispatchActivity");
        } else {
            intent = Intent.createChooser(intent, str);
        }
        ToolUtils.tryStartIntent(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String dealWithShareText(Context context, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str.length() >= 70) {
            str = str.substring(0, 70) + "...";
        }
        return String.format(context.getString(C1010R.string.share_sdk_system_share_fmt_new2), str, str2);
    }
}
