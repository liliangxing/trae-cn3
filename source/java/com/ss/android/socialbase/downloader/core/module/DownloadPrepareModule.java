package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadPrepareModule extends AbsDownloadModule {
    private static final String TAG = "DownloadPrepareModule";

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain iDownloadModuleChain) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
        }
        if (checkTaskFinishByUser()) {
            return;
        }
        iDownloadModuleChain.onDownloadStart();
        try {
            try {
                try {
                    this.mStatusHandler.handlePrepare();
                    iDownloadModuleChain.proceed();
                    onDownloadTaskEnd(null);
                } catch (BaseException e) {
                    e.printStackTrace();
                    onDownloadTaskEnd(e);
                }
            } finally {
            }
        } catch (Throwable th) {
            onDownloadTaskEnd(null);
        }
    }

    private void onDownloadTaskEnd(BaseException baseException) {
        if (Logger.debugScene(this.mDownloadInfo)) {
            Logger.taskDebug(TAG, this.mDownloadInfo, "onDownloadTaskEnd", "RunStatus: " + this.mCommonParams.mRunStatus);
        }
        try {
            this.mCommonParams.mDownloadTask.getTimingInfo().beforeOnEndCallbackTime = System.currentTimeMillis();
            DownloadComponentManager.updateCurrentDownloadThreadInfo(this.mCommonParams.mDownloadTask, false);
            doTaskStatusHandle(baseException);
        } catch (BaseException e) {
            this.mStatusHandler.onError(e);
        } catch (Throwable th) {
            this.mStatusHandler.onError(new BaseException(1046, th));
        }
        this.mCommonParams.mIsAlive = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.downloader.core.module.DownloadPrepareModule$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C05601 {

        /* renamed from: $SwitchMap$com$ss$android$socialbase$downloader$constants$RunStatus */
        static final /* synthetic */ int[] f72xc42683c9;

        static {
            int[] iArr = new int[RunStatus.values().length];
            f72xc42683c9 = iArr;
            try {
                iArr[RunStatus.RUN_STATUS_CANCELED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f72xc42683c9[RunStatus.RUN_STATUS_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f72xc42683c9[RunStatus.RUN_STATUS_INTERCEPT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f72xc42683c9[RunStatus.RUN_STATUS_WAITING_ASYNC_HANDLER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f72xc42683c9[RunStatus.RUN_STATUS_END_RIGHT_NOW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f72xc42683c9[RunStatus.RUN_STATUS_END_FOR_FILE_EXIST.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f72xc42683c9[RunStatus.RUN_STATUS_COMPLETED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void doTaskStatusHandle(BaseException baseException) throws BaseException {
        switch (C05601.f72xc42683c9[this.mCommonParams.mRunStatus.ordinal()]) {
            case 1:
                this.mStatusHandler.onCancel();
                return;
            case 2:
                this.mStatusHandler.onPause();
                return;
            case 3:
                this.mStatusHandler.onIntercept();
                return;
            case 4:
                return;
            case 5:
                this.mStatusHandler.onCompleteForFileExist();
                return;
            case 6:
                this.mStatusHandler.onCompleteForFileExist(this.mCommonParams.mExistTargetFilePath, this.mCommonParams.mExistTargetFileName);
                return;
            case 7:
                this.mStatusHandler.onSaveTempFileSuccess();
                RetryScheduler.getInstance().scheduleRetryWhenHasTaskSucceed();
                return;
            default:
                if (baseException == null) {
                    baseException = new BaseException(1092, "Unknown runStatus:" + this.mCommonParams.mRunStatus);
                }
                this.mStatusHandler.onError(baseException);
                return;
        }
    }
}
