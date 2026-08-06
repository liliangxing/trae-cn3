package com.bytedance.ug.sdk.share.channel.wechat.wxshare;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.StrictMode;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction;
import com.bytedance.ug.sdk.share.impl.share.action.SystemShareOptimizeAction;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ComponentNameShareImpl implements IWxShare {
    private static final String SHARE_TEMP_IMAGE_FILE_NAME = "wx_share_temp.jpg";
    private static String SHARE_TEMP_IMAGE_PATH;
    private Context mContext;

    @Override // com.bytedance.ug.sdk.share.channel.wechat.wxshare.IWxShare
    public boolean doShare(Context context, IWXAPI iwxapi, final ShareContent shareContent, SendMessageToWX.Req req) {
        if (shareContent == null || context == null) {
            return false;
        }
        this.mContext = context;
        String cacheFilePathDir = FileUtils.getCacheFilePathDir();
        SHARE_TEMP_IMAGE_PATH = cacheFilePathDir;
        if (TextUtils.isEmpty(cacheFilePathDir)) {
            return false;
        }
        boolean z = (req.message == null || req.message.thumbData == null || req.message.thumbData.length <= 0) ? false : true;
        final boolean z2 = req.scene == 1;
        if ((z2 && z) || (!z2 && z && !isTextShare(shareContent))) {
            final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(req.message.thumbData, 0, req.message.thumbData.length);
            ShareUtils.requestWritePermission(this.mContext, shareContent, new RequestPermissionsCallback() { // from class: com.bytedance.ug.sdk.share.channel.wechat.wxshare.ComponentNameShareImpl.1
                @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
                public void onGranted() {
                    if (FileUtils.saveInputStream(byteArrayInputStream, ComponentNameShareImpl.SHARE_TEMP_IMAGE_PATH, ComponentNameShareImpl.SHARE_TEMP_IMAGE_FILE_NAME)) {
                        ComponentNameShareImpl.this.tryGetUriAndShare(new File(ComponentNameShareImpl.SHARE_TEMP_IMAGE_PATH, ComponentNameShareImpl.SHARE_TEMP_IMAGE_FILE_NAME), z2, shareContent);
                    }
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
                public void onDenied(String str) {
                    if (ComponentNameShareImpl.this.disableDeathOnFileUriExposure() && FileUtils.saveInputStream(byteArrayInputStream, ComponentNameShareImpl.SHARE_TEMP_IMAGE_PATH, ComponentNameShareImpl.SHARE_TEMP_IMAGE_FILE_NAME)) {
                        ComponentNameShareImpl.this.tryReflectAndShare(new File(ComponentNameShareImpl.SHARE_TEMP_IMAGE_PATH, ComponentNameShareImpl.SHARE_TEMP_IMAGE_FILE_NAME), z2, shareContent);
                    }
                }
            });
            return true;
        }
        return startShare(z2, shareContent, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryGetUriAndShare(File file, boolean z, ShareContent shareContent) {
        Uri fileProviderUri = ShareUtils.getFileProviderUri(this.mContext, file);
        if (fileProviderUri != null) {
            startShare(z, shareContent, fileProviderUri);
        } else {
            tryReflectAndShare(file, z, shareContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReflectAndShare(File file, boolean z, ShareContent shareContent) {
        if (disableDeathOnFileUriExposure()) {
            startShare(z, shareContent, Uri.fromFile(file));
        }
    }

    private boolean startShare(boolean z, ShareContent shareContent, Uri uri) {
        ArrayList<Uri> arrayList = new ArrayList<>();
        if (uri != null) {
            arrayList.add(uri);
        }
        ShareChannelType shareChannelType = z ? ShareChannelType.WX_TIMELINE : ShareChannelType.WX;
        if (z && shareContent.getShareStrategy() == ShareStrategy.SHARE_WITH_COMPONET_OPTIMIZE && isNeedSystemShareOptimize(this.mContext)) {
            return SystemShareOptimizeAction.getInstance().shareTo(shareChannelType, shareContent, arrayList);
        }
        return SystemShareAction.shareTo(this.mContext, shareChannelType, shareContent, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean disableDeathOnFileUriExposure() {
        try {
            StrictMode.class.getMethod("disableDeathOnFileUriExposure", new Class[0]).invoke(null, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean isTextShare(ShareContent shareContent) {
        return (shareContent == null || (TextUtils.isEmpty(shareContent.getTargetUrl()) && TextUtils.isEmpty(shareContent.getTitle()))) ? false : true;
    }

    private boolean isNeedSystemShareOptimize(Context context) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.tencent.mm", 0)) != null) {
                if (packageInfo.versionCode >= 1320) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
