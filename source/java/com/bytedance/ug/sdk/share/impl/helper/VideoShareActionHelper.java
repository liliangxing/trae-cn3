package com.bytedance.ug.sdk.share.impl.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.MediaScannerConnection;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.ug.sdk.share.C1010R;
import com.bytedance.ug.sdk.share.api.callback.OnDownloadListener;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.entity.DownloadStatus;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.p008ui.IDownloadProgressDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoShareDialog;
import com.bytedance.ug.sdk.share.impl.cache.ShareCacheManager;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.p009ui.video.VideoShareDialogProxy;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.IDUtils;
import com.bytedance.ug.sdk.share.impl.utils.SharePrefHelper;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoShareActionHelper {
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public boolean directShareVideo(final ShareContent shareContent) {
        final Activity topActivity;
        if (shareContent == null) {
            return false;
        }
        String videoUrl = shareContent.getVideoUrl();
        if (TextUtils.isEmpty(videoUrl) || (topActivity = ShareConfigManager.getInstance().getTopActivity()) == null) {
            return false;
        }
        if (!HttpUtils.isUrl(videoUrl) || (shareContent.getVideoDialogCallback() != null && shareContent.getVideoDialogCallback().skipDownloadVideo())) {
            continueShare(topActivity, shareContent);
            return true;
        }
        ShareUtils.requestWritePermission(topActivity, shareContent, new RequestPermissionsCallback() { // from class: com.bytedance.ug.sdk.share.impl.helper.VideoShareActionHelper.1
            @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
            public void onGranted() {
                VideoShareActionHelper.this.saveVideo(topActivity, shareContent);
            }

            @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
            public void onDenied(String str) {
                ToastUtils.showToast(topActivity, shareContent, 7, C1010R.string.share_sdk_video_share_save_failed);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveVideo(Activity activity, final ShareContent shareContent) {
        if (activity == null || shareContent == null || TextUtils.isEmpty(shareContent.getVideoUrl())) {
            return;
        }
        final String videoUrl = shareContent.getVideoUrl();
        IDownloadProgressDialog downloadProgressDialog = shareContent.getDownloadProgressDialog();
        if (downloadProgressDialog == null && (downloadProgressDialog = ShareConfigManager.getInstance().getDownloadProgressDialog(activity)) == null) {
            return;
        }
        IDownloadProgressDialog iDownloadProgressDialog = downloadProgressDialog;
        WeakReference weakReference = new WeakReference(iDownloadProgressDialog);
        final String albumDirPath = FileUtils.getAlbumDirPath();
        if (TextUtils.isEmpty(albumDirPath)) {
            return;
        }
        final String videoName = !TextUtils.isEmpty(shareContent.getVideoName()) ? shareContent.getVideoName() : String.format(Locale.getDefault(), "%d.mp4", Integer.valueOf(IDUtils.generate(videoUrl, albumDirPath)));
        String str = albumDirPath + File.separator + videoName;
        if (new File(str).exists()) {
            FileUtils.syncMediaToAlbum(activity, str, false);
            ShareCacheManager.getInstance().updateSaveAlbumMediaCache(videoName, false);
            shareContent.setVideoUrl(str);
            continueShare(activity, shareContent);
            return;
        }
        iDownloadProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.ug.sdk.share.impl.helper.VideoShareActionHelper.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ShareConfigManager.getInstance().cancelDownload(shareContent, videoName, albumDirPath, videoUrl);
                VideoShareActionHelper.this.mHandler.removeCallbacksAndMessages(null);
            }
        });
        ShareConfigManager.getInstance().execute(new RunnableC10513(shareContent, videoName, albumDirPath, videoUrl, weakReference, activity, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.ug.sdk.share.impl.helper.VideoShareActionHelper$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class RunnableC10513 implements Runnable {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String val$fileDir;
        final /* synthetic */ String val$fileName;
        final /* synthetic */ ShareContent val$shareModel;
        final /* synthetic */ String val$videoDownloadUrl;
        final /* synthetic */ String val$videoPath;
        final /* synthetic */ WeakReference val$weakDialog;

        RunnableC10513(ShareContent shareContent, String str, String str2, String str3, WeakReference weakReference, Activity activity, String str4) {
            this.val$shareModel = shareContent;
            this.val$fileName = str;
            this.val$fileDir = str2;
            this.val$videoDownloadUrl = str3;
            this.val$weakDialog = weakReference;
            this.val$activity = activity;
            this.val$videoPath = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            final long currentTimeMillis = System.currentTimeMillis();
            ShareConfigManager.getInstance().downloadFile(this.val$shareModel, this.val$fileName, this.val$fileDir, this.val$videoDownloadUrl, new OnDownloadListener() { // from class: com.bytedance.ug.sdk.share.impl.helper.VideoShareActionHelper.3.1
                @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                public void onStart() {
                    if (RunnableC10513.this.val$shareModel != null && RunnableC10513.this.val$shareModel.getEventCallBack() != null) {
                        RunnableC10513.this.val$shareModel.getEventCallBack().onDownloadEvent(DownloadStatus.START, RunnableC10513.this.val$videoDownloadUrl, RunnableC10513.this.val$shareModel);
                    }
                    if (RunnableC10513.this.val$weakDialog == null || RunnableC10513.this.val$weakDialog.get() == null) {
                        return;
                    }
                    ((IDownloadProgressDialog) RunnableC10513.this.val$weakDialog.get()).show();
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                public void onProgress(int i) {
                    if (RunnableC10513.this.val$weakDialog == null || RunnableC10513.this.val$weakDialog.get() == null) {
                        return;
                    }
                    ((IDownloadProgressDialog) RunnableC10513.this.val$weakDialog.get()).setProgress(i);
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                public void onSuccessed() {
                    if (RunnableC10513.this.val$weakDialog != null && RunnableC10513.this.val$weakDialog.get() != null) {
                        ((IDownloadProgressDialog) RunnableC10513.this.val$weakDialog.get()).setProgress(100);
                    }
                    if (RunnableC10513.this.val$shareModel != null && RunnableC10513.this.val$shareModel.getEventCallBack() != null) {
                        RunnableC10513.this.val$shareModel.getEventCallBack().onDownloadEvent(DownloadStatus.SUCCESS, RunnableC10513.this.val$videoDownloadUrl, RunnableC10513.this.val$shareModel);
                    }
                    MonitorEvent.monitorShareVideoDownload(0, RunnableC10513.this.val$videoDownloadUrl, System.currentTimeMillis() - currentTimeMillis);
                    FileUtils.syncMediaToAlbum(RunnableC10513.this.val$activity, RunnableC10513.this.val$videoPath, false);
                    ShareCacheManager.getInstance().updateSaveAlbumMediaCache(RunnableC10513.this.val$fileName, false);
                    VideoShareActionHelper.this.mHandler.postDelayed(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.helper.VideoShareActionHelper.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RunnableC10513.this.val$weakDialog != null && RunnableC10513.this.val$weakDialog.get() != null) {
                                VideoShareActionHelper.dismissDialog((IDownloadProgressDialog) RunnableC10513.this.val$weakDialog.get());
                            }
                            if (RunnableC10513.this.val$shareModel != null) {
                                RunnableC10513.this.val$shareModel.setVideoUrl(RunnableC10513.this.val$videoPath);
                                VideoShareActionHelper.this.continueShare(RunnableC10513.this.val$activity, RunnableC10513.this.val$shareModel);
                            }
                        }
                    }, ShareConfigManager.getInstance().getDownloadSuccessShareDelay());
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                public void onFailed(Throwable th) {
                    if (RunnableC10513.this.val$shareModel != null && RunnableC10513.this.val$shareModel.getEventCallBack() != null) {
                        RunnableC10513.this.val$shareModel.getEventCallBack().onDownloadEvent(DownloadStatus.FAILED, RunnableC10513.this.val$videoDownloadUrl, RunnableC10513.this.val$shareModel);
                    }
                    MonitorEvent.monitorShareVideoDownload(1, RunnableC10513.this.val$videoDownloadUrl, System.currentTimeMillis() - currentTimeMillis);
                    if (RunnableC10513.this.val$weakDialog != null && RunnableC10513.this.val$weakDialog.get() != null) {
                        VideoShareActionHelper.dismissDialog((IDownloadProgressDialog) RunnableC10513.this.val$weakDialog.get());
                    }
                    ToastUtils.showToast(RunnableC10513.this.val$activity, RunnableC10513.this.val$shareModel, 5, C1010R.string.share_sdk_video_share_save_failed);
                }

                @Override // com.bytedance.ug.sdk.share.api.callback.OnDownloadListener
                public void onCanceled() {
                    if (RunnableC10513.this.val$shareModel != null && RunnableC10513.this.val$shareModel.getEventCallBack() != null) {
                        RunnableC10513.this.val$shareModel.getEventCallBack().onDownloadEvent(DownloadStatus.CANCELED, RunnableC10513.this.val$videoDownloadUrl, RunnableC10513.this.val$shareModel);
                    }
                    MonitorEvent.monitorShareVideoDownload(2, RunnableC10513.this.val$videoDownloadUrl, System.currentTimeMillis() - currentTimeMillis);
                    if (RunnableC10513.this.val$weakDialog != null && RunnableC10513.this.val$weakDialog.get() != null) {
                        VideoShareActionHelper.dismissDialog((IDownloadProgressDialog) RunnableC10513.this.val$weakDialog.get());
                    }
                    ToastUtils.showToast(RunnableC10513.this.val$activity, RunnableC10513.this.val$shareModel, 6, C1010R.string.share_sdk_video_share_save_failed);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueShare(Activity activity, ShareContent shareContent) {
        if (shareContent == null) {
            return;
        }
        MediaScannerConnection.scanFile(activity, new String[]{shareContent.getVideoUrl()}, new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp4")}, null);
        if (shareContent.getVideoDialogCallback() != null && shareContent.getVideoDialogCallback().skipVideoShareDialog()) {
            ShareUtils.jumpToTargetApp(activity, shareContent.getShareChanelType());
            ShareResult.sendShareStatus(10000, shareContent);
        } else {
            if (ShareConfigManager.getInstance().getShowSaveVideoContinueShareDialogTimes() == -1) {
                showTokenDialog(activity, shareContent);
                return;
            }
            int pref = SharePrefHelper.getInstance().getPref(SharePrefHelper.SP_SHOW_SHARE_VIDEO_CONTINEU_SHARE_DIALOG, 0);
            if (pref >= ShareConfigManager.getInstance().getShowSaveVideoContinueShareDialogTimes()) {
                ShareUtils.jumpToTargetApp(activity, shareContent.getShareChanelType());
                ShareResult.sendShareStatus(10000, shareContent);
            } else {
                SharePrefHelper.getInstance().setPref(SharePrefHelper.SP_SHOW_SHARE_VIDEO_CONTINEU_SHARE_DIALOG, pref + 1);
                showTokenDialog(activity, shareContent);
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

    private void showTokenDialog(Activity activity, ShareContent shareContent) {
        IVideoShareDialog videoShareDialog = shareContent.getVideoShareDialog();
        if (videoShareDialog == null && (videoShareDialog = ShareConfigManager.getInstance().getVideoShareDialog(activity)) == null) {
            return;
        }
        new VideoShareDialogProxy(activity, shareContent, videoShareDialog).show();
    }
}
