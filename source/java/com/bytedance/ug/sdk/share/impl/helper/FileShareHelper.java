package com.bytedance.ug.sdk.share.impl.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.callback.OnDownloadListener;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.p008ui.IDownloadProgressDialog;
import com.bytedance.ug.sdk.share.impl.callback.FileShareCallback;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FileShareHelper {
    private FileShareHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Singleton {
        private static FileShareHelper sInstance = new FileShareHelper();

        private Singleton() {
        }
    }

    public static FileShareHelper getInstance() {
        return Singleton.sInstance;
    }

    public void shareFile(final ShareContent shareContent, final FileShareCallback fileShareCallback) {
        if (shareContent == null) {
            if (fileShareCallback != null) {
                fileShareCallback.onShareFailed();
                return;
            }
            return;
        }
        String fileUrl = shareContent.getFileUrl();
        if (TextUtils.isEmpty(fileUrl)) {
            if (fileShareCallback != null) {
                fileShareCallback.onShareFailed();
                return;
            }
            return;
        }
        if (ShareConfigManager.getInstance().getTopActivity() == null) {
            if (fileShareCallback != null) {
                fileShareCallback.onShareFailed();
                return;
            }
            return;
        }
        if (!HttpUtils.isUrl(fileUrl)) {
            continueShare(shareContent, fileShareCallback);
            return;
        }
        final Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (shareContent == null || TextUtils.isEmpty(shareContent.getFileUrl()) || topActivity == null) {
            if (fileShareCallback != null) {
                fileShareCallback.onShareFailed();
                return;
            }
            return;
        }
        IDownloadProgressDialog downloadProgressDialog = shareContent.getDownloadProgressDialog();
        if (downloadProgressDialog == null && (downloadProgressDialog = ShareConfigManager.getInstance().getDownloadProgressDialog(topActivity)) == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(downloadProgressDialog);
        final String cacheFilePathDir = FileUtils.getCacheFilePathDir();
        final String fileName = shareContent.getFileName();
        final String fileUrl2 = shareContent.getFileUrl();
        downloadProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.ug.sdk.share.impl.helper.FileShareHelper.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ShareConfigManager.getInstance().cancelDownload(shareContent, fileName, cacheFilePathDir, fileUrl2);
            }
        });
        ShareConfigManager.getInstance().execute(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.helper.FileShareHelper.2
            @Override // java.lang.Runnable
            public void run() {
                final long currentTimeMillis = System.currentTimeMillis();
                ShareConfigManager.getInstance().downloadFile(shareContent, fileName, cacheFilePathDir, fileUrl2, new OnDownloadListener() { // from class: com.bytedance.ug.sdk.share.impl.helper.FileShareHelper.2.1
                    @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                    public void onStart() {
                        if (shareContent != null && shareContent.getEventCallBack() != null) {
                            shareContent.getEventCallBack().onDownloadEvent(DownloadStatus.START, fileUrl2, shareContent);
                        }
                        if (weakReference == null || weakReference.get() == null) {
                            return;
                        }
                        ((IDownloadProgressDialog) weakReference.get()).show();
                    }

                    @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                    public void onProgress(int i) {
                        if (weakReference == null || weakReference.get() == null) {
                            return;
                        }
                        ((IDownloadProgressDialog) weakReference.get()).setProgress(i);
                    }

                    @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                    public void onSuccessed() {
                        if (shareContent != null && shareContent.getEventCallBack() != null) {
                            shareContent.getEventCallBack().onDownloadEvent(DownloadStatus.SUCCESS, fileUrl2, shareContent);
                        }
                        MonitorEvent.monitorShareFileDownload(0, fileUrl2, System.currentTimeMillis() - currentTimeMillis);
                        String str = cacheFilePathDir + File.separator + fileName;
                        if (shareContent != null) {
                            shareContent.setFileUrl(str);
                            FileShareHelper.this.continueShare(shareContent, fileShareCallback);
                        }
                        if (weakReference == null || weakReference.get() == null) {
                            return;
                        }
                        FileShareHelper.dismissDialog((IDownloadProgressDialog) weakReference.get());
                    }

                    @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                    public void onFailed(Throwable th) {
                        if (shareContent != null && shareContent.getEventCallBack() != null) {
                            shareContent.getEventCallBack().onDownloadEvent(DownloadStatus.FAILED, fileUrl2, shareContent);
                        }
                        MonitorEvent.monitorShareFileDownload(1, shareContent.getFileUrl(), System.currentTimeMillis() - currentTimeMillis);
                        if (weakReference != null && weakReference.get() != null) {
                            FileShareHelper.dismissDialog((IDownloadProgressDialog) weakReference.get());
                        }
                        if (fileShareCallback != null) {
                            fileShareCallback.onShareFailed();
                        }
                        ToastUtils.showToast(topActivity, shareContent, 3, C1010R.string.share_sdk_file_share_save_failed);
                    }

                    @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                    public void onCanceled() {
                        if (shareContent != null && shareContent.getEventCallBack() != null) {
                            shareContent.getEventCallBack().onDownloadEvent(DownloadStatus.CANCELED, fileUrl2, shareContent);
                        }
                        MonitorEvent.monitorShareFileDownload(2, fileUrl2, System.currentTimeMillis() - currentTimeMillis);
                        if (weakReference != null && weakReference.get() != null) {
                            FileShareHelper.dismissDialog((IDownloadProgressDialog) weakReference.get());
                        }
                        if (fileShareCallback != null) {
                            fileShareCallback.onShareFailed();
                        }
                        ToastUtils.showToast(topActivity, shareContent, 2, C1010R.string.share_sdk_file_share_save_failed);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueShare(ShareContent shareContent, FileShareCallback fileShareCallback) {
        if (shareContent == null) {
            if (fileShareCallback != null) {
                fileShareCallback.onShareFailed();
            }
        } else if (fileShareCallback != null) {
            if (!TextUtils.isEmpty(shareContent.getFileUrl())) {
                fileShareCallback.onShareSuccess(shareContent.getFileUrl());
            } else {
                fileShareCallback.onShareFailed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dismissDialog(IDownloadProgressDialog iDownloadProgressDialog) {
        try {
            iDownloadProgressDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
