package com.bytedance.ug.sdk.share.impl.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.callback.OnDownloadListener;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.p008ui.IDownloadProgressDialog;
import com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.IDUtils;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoShareHelper {
    public void shareVideo(ShareContent shareContent, VideoShareCallback videoShareCallback) {
        if (shareContent == null) {
            if (videoShareCallback != null) {
                videoShareCallback.onShareFailed();
                return;
            }
            return;
        }
        String videoUrl = shareContent.getVideoUrl();
        if (TextUtils.isEmpty(videoUrl)) {
            if (videoShareCallback != null) {
                videoShareCallback.onShareFailed();
                return;
            }
            return;
        }
        Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (topActivity == null) {
            if (videoShareCallback != null) {
                videoShareCallback.onShareFailed();
            }
        } else if (!HttpUtils.isUrl(videoUrl)) {
            continueShare(topActivity, shareContent, videoShareCallback);
        } else {
            saveVideo(shareContent, videoShareCallback);
        }
    }

    private void saveVideo(final ShareContent shareContent, final VideoShareCallback videoShareCallback) {
        final Activity topActivity = ShareConfigManager.getInstance().getTopActivity();
        if (shareContent == null || TextUtils.isEmpty(shareContent.getVideoUrl()) || topActivity == null) {
            if (videoShareCallback != null) {
                videoShareCallback.onShareFailed();
                return;
            }
            return;
        }
        final String videoUrl = shareContent.getVideoUrl();
        IDownloadProgressDialog downloadProgressDialog = shareContent.getDownloadProgressDialog();
        if (downloadProgressDialog == null && (downloadProgressDialog = ShareConfigManager.getInstance().getDownloadProgressDialog(topActivity)) == null) {
            return;
        }
        IDownloadProgressDialog iDownloadProgressDialog = downloadProgressDialog;
        final WeakReference weakReference = new WeakReference(iDownloadProgressDialog);
        final String cacheFilePathDir = FileUtils.getCacheFilePathDir();
        final String videoName = !TextUtils.isEmpty(shareContent.getVideoName()) ? shareContent.getVideoName() : String.format(Locale.getDefault(), "%d.mp4", Integer.valueOf(IDUtils.generate(videoUrl, cacheFilePathDir)));
        iDownloadProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.ug.sdk.share.impl.helper.VideoShareHelper.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ShareConfigManager.getInstance().cancelDownload(shareContent, videoName, cacheFilePathDir, videoUrl);
            }
        });
        ShareConfigManager.getInstance().execute(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.helper.VideoShareHelper.2
            @Override // java.lang.Runnable
            public void run() {
                final long currentTimeMillis = System.currentTimeMillis();
                ShareConfigManager.getInstance().downloadFile(shareContent, videoName, cacheFilePathDir, videoUrl, new OnDownloadListener() { // from class: com.bytedance.ug.sdk.share.impl.helper.VideoShareHelper.2.1
                    @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                    public void onStart() {
                        if (shareContent != null && shareContent.getEventCallBack() != null) {
                            shareContent.getEventCallBack().onDownloadEvent(DownloadStatus.START, videoUrl, shareContent);
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
                            shareContent.getEventCallBack().onDownloadEvent(DownloadStatus.SUCCESS, videoUrl, shareContent);
                        }
                        MonitorEvent.monitorShareVideoDownload(0, videoUrl, System.currentTimeMillis() - currentTimeMillis);
                        String str = cacheFilePathDir + File.separator + videoName;
                        if (shareContent != null) {
                            shareContent.setVideoUrl(str);
                            VideoShareHelper.this.continueShare(topActivity, shareContent, videoShareCallback);
                        }
                        if (weakReference == null || weakReference.get() == null) {
                            return;
                        }
                        VideoShareHelper.dismissDialog((IDownloadProgressDialog) weakReference.get());
                    }

                    @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                    public void onFailed(Throwable th) {
                        if (shareContent != null && shareContent.getEventCallBack() != null) {
                            shareContent.getEventCallBack().onDownloadEvent(DownloadStatus.FAILED, videoUrl, shareContent);
                        }
                        MonitorEvent.monitorShareVideoDownload(1, videoUrl, System.currentTimeMillis() - currentTimeMillis);
                        if (weakReference != null && weakReference.get() != null) {
                            VideoShareHelper.dismissDialog((IDownloadProgressDialog) weakReference.get());
                        }
                        if (videoShareCallback != null) {
                            videoShareCallback.onShareFailed();
                        }
                        ToastUtils.showToast(topActivity, shareContent, 5, C1010R.string.share_sdk_video_share_save_failed);
                    }

                    @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                    public void onCanceled() {
                        if (shareContent != null && shareContent.getEventCallBack() != null) {
                            shareContent.getEventCallBack().onDownloadEvent(DownloadStatus.CANCELED, videoUrl, shareContent);
                        }
                        MonitorEvent.monitorShareVideoDownload(2, videoUrl, System.currentTimeMillis() - currentTimeMillis);
                        if (weakReference != null && weakReference.get() != null) {
                            VideoShareHelper.dismissDialog((IDownloadProgressDialog) weakReference.get());
                        }
                        if (videoShareCallback != null) {
                            videoShareCallback.onShareFailed();
                        }
                        ToastUtils.showToast(topActivity, shareContent, 6, C1010R.string.share_sdk_video_share_save_failed);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueShare(Activity activity, ShareContent shareContent, VideoShareCallback videoShareCallback) {
        if (shareContent == null) {
            return;
        }
        if (videoShareCallback != null) {
            if (!TextUtils.isEmpty(shareContent.getVideoUrl())) {
                videoShareCallback.onShareSuccess(shareContent.getVideoUrl());
                return;
            } else {
                videoShareCallback.onShareFailed();
                return;
            }
        }
        ShareUtils.jumpToTargetApp(activity, shareContent.getShareChanelType());
        ShareResult.sendShareStatus(10000, shareContent);
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
