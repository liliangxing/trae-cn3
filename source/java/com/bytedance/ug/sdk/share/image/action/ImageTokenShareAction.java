package com.bytedance.ug.sdk.share.image.action;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.callback.GetImageCallback;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.p008ui.IImageTokenDialog;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.image.manager.ImageTokenDialogProxy;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.utils.LoadingUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageTokenShareAction {
    private static volatile ImageTokenShareAction tokenShareHelper;

    private ImageTokenShareAction() {
    }

    public static ImageTokenShareAction getInstance() {
        if (tokenShareHelper == null) {
            synchronized (ImageTokenShareAction.class) {
                if (tokenShareHelper == null) {
                    tokenShareHelper = new ImageTokenShareAction();
                }
            }
        }
        return tokenShareHelper;
    }

    public boolean shareTo(Context context, ShareChannelType shareChannelType, ShareContent shareContent) {
        if (shareContent == null || shareChannelType == null) {
            return false;
        }
        return showImageTokenShareDialog(shareContent);
    }

    private boolean showImageTokenShareDialog(final ShareContent shareContent) {
        Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (topActivity == null) {
            return false;
        }
        if (!TextUtils.isEmpty(shareContent.getHiddenImageUrl())) {
            String hiddenImageUrl = shareContent.getHiddenImageUrl();
            LoadingUtils.showProgressDialog(shareContent);
            final WeakReference weakReference = new WeakReference(topActivity);
            ShareConfigManager.getInstance().getImageBitmap(hiddenImageUrl, new GetImageCallback() { // from class: com.bytedance.ug.sdk.share.image.action.ImageTokenShareAction.1
                @Override // com.bytedance.ug.sdk.share.api.callback.GetImageCallback
                public void onSuccess(final Bitmap bitmap) {
                    LoadingUtils.dismissProgressDialog();
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.image.action.ImageTokenShareAction.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity activity;
                            Bitmap bitmap2 = bitmap;
                            if (bitmap2 == null || bitmap2.isRecycled() || (activity = (Activity) weakReference.get()) == null || shareContent == null) {
                                return;
                            }
                            shareContent.setImage(bitmap);
                            ImageTokenShareAction.this.showDialog(activity, shareContent);
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
        if (shareContent.getImage() != null) {
            return showDialog(topActivity, shareContent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean showDialog(Activity activity, ShareContent shareContent) {
        if (activity == null || shareContent == null || shareContent.getImage() == null) {
            return false;
        }
        IImageTokenDialog imageTokenDialog = shareContent.getImageTokenDialog();
        if (imageTokenDialog == null && (imageTokenDialog = ShareConfigManager.getInstance().getImageTokenDialog(activity)) == null) {
            return false;
        }
        new ImageTokenDialogProxy(activity, shareContent, imageTokenDialog).show();
        return true;
    }
}
