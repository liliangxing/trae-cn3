package com.bytedance.ug.sdk.share.impl.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.entity.PermissionType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareUtils {
    public static boolean checkAndroidNotBelowN() {
        return true;
    }

    public static boolean useThirdAppSwitch() {
        String str = Build.BRAND;
        String[] strArr = {"华为", "荣耀", CommonConstants.HW_AD_PLATFORM, "honor"};
        for (int i = 0; i < 4; i++) {
            if (strArr[i].equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static void jumpToTargetApp(Context context, ShareChannelType shareChannelType) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(ShareChannelType.getSharePackageName(shareChannelType));
        if (launchIntentForPackage != null) {
            ToolUtils.tryStartIntent(context, launchIntentForPackage);
        }
    }

    public static String getFileProviderUri(Context context, String str, String str2) {
        try {
            Uri fileProviderUri = getFileProviderUri(str2);
            if (fileProviderUri != null) {
                context.grantUriPermission(str, fileProviderUri, 1);
                return fileProviderUri.toString();
            }
        } catch (Throwable th) {
            Logger.m465e(th.toString());
        }
        return str2;
    }

    public static String getFileProviderUri(Context context, List<String> list, String str) {
        try {
            Uri fileProviderUri = getFileProviderUri(str);
            if (fileProviderUri != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    context.grantUriPermission(it.next(), fileProviderUri, 1);
                }
                return fileProviderUri.toString();
            }
        } catch (Throwable th) {
            Logger.m465e(th.toString());
        }
        return str;
    }

    public static Uri getFileProviderUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getFileProviderUri(ShareSdkManager.getInstance().getAppContext(), new File(str));
    }

    public static Uri getFileProviderUri(Context context, File file) {
        if (checkAndroidNotBelowN()) {
            try {
                try {
                    return FileProvider.getUriForFile(context, context.getPackageName() + ".ug.sdk.share.fileprovider", file);
                } catch (Throwable unused) {
                    return FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                }
            } catch (Throwable th) {
                Logger.m465e(th.toString());
                return null;
            }
        }
        return Uri.fromFile(file);
    }

    public static String getMaxLengthStr(String str, int i) {
        if (TextUtils.isEmpty(str) || i <= 0) {
            return "";
        }
        int length = str.getBytes().length;
        if (length <= i) {
            return str;
        }
        int length2 = str.length();
        while (length > i) {
            length2 /= 2;
            length = str.substring(0, length2).length();
        }
        int i2 = length2 * 2;
        while (length2 < i2 && str.substring(0, length2).getBytes().length <= i) {
            length2++;
        }
        return str.substring(0, length2 - 1);
    }

    public static void requestWritePermission(Context context, final ShareContent shareContent, final RequestPermissionsCallback requestPermissionsCallback) {
        Logger.m469i("ShareUtils", "requestWritePermission version = " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= 29 || ShareConfigManager.getInstance().hasPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            Logger.m469i("ShareUtils", "requestWritePermission permission onGranted");
            ShareEvent.sendPermissionRequest(shareContent, true);
            if (requestPermissionsCallback != null) {
                requestPermissionsCallback.onGranted();
                return;
            }
            return;
        }
        Logger.m469i("ShareUtils", "requestWritePermission request permission");
        ShareEvent.sendPermissionRequest(shareContent, false);
        Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (topActivity == null) {
            return;
        }
        ShareConfigManager.getInstance().requestPermissions(topActivity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, shareContent, new RequestPermissionsCallback() { // from class: com.bytedance.ug.sdk.share.impl.utils.ShareUtils.1
            @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
            public void onGranted() {
                if (ShareContent.this.getEventCallBack() != null) {
                    ShareContent.this.getEventCallBack().onPermissionEvent(PermissionType.GRANTED, ShareContent.this, "android.permission.WRITE_EXTERNAL_STORAGE");
                }
                ShareEvent.sendPermissionDialogClickEvent(ShareContent.this, true);
                RequestPermissionsCallback requestPermissionsCallback2 = requestPermissionsCallback;
                if (requestPermissionsCallback2 != null) {
                    requestPermissionsCallback2.onGranted();
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
            public void onDenied(String str) {
                if (ShareContent.this.getEventCallBack() != null) {
                    ShareContent.this.getEventCallBack().onPermissionEvent(PermissionType.DENIED, ShareContent.this, str);
                }
                ShareEvent.sendPermissionDialogClickEvent(ShareContent.this, false);
                RequestPermissionsCallback requestPermissionsCallback2 = requestPermissionsCallback;
                if (requestPermissionsCallback2 != null) {
                    requestPermissionsCallback2.onDenied(str);
                }
            }
        });
        ShareEvent.sendPermissionDialogShowEvent(shareContent);
        if (shareContent.getEventCallBack() != null) {
            shareContent.getEventCallBack().onPermissionEvent(PermissionType.SHOW, shareContent, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    public static String appendShareToken(ShareContent shareContent) {
        String generateShareToken = shareContent.getShareTokenGenerator().generateShareToken(shareContent);
        appendShareToken(shareContent, generateShareToken);
        return generateShareToken;
    }

    public static void appendShareToken(ShareContent shareContent, String str) {
        shareContent.setTargetUrl(HttpUtils.addUniqueParam(shareContent.getTargetUrl(), "share_token", str));
        shareContent.setCopyUrl(HttpUtils.addUniqueParam(shareContent.getCopyUrl(), "share_token", str));
        shareContent.setShareToken(str);
    }

    public static boolean isRealH5Share(ShareContent shareContent) {
        if (shareContent == null) {
            return false;
        }
        if (shareContent.getShareContentType() == ShareContentType.H5) {
            return true;
        }
        return (shareContent.getShareContentType() != ShareContentType.ALL || shareContent.getShareChanelType() == ShareChannelType.DOUYIN || shareContent.getShareChanelType() == ShareChannelType.LONG_IMAGE || shareContent.getShareChanelType() == ShareChannelType.IMAGE_SHARE || TextUtils.isEmpty(shareContent.getTargetUrl()) || TextUtils.isEmpty(shareContent.getTitle())) ? false : true;
    }
}
