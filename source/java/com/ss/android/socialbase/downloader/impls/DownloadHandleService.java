package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.logger.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadHandleService extends Service {
    private static final String TAG = "DownloadHandleService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        handleIntent(intent);
        return 2;
    }

    private void handleIntent(Intent intent) {
        int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra("extra_download_id", 0)) == 0) {
            return;
        }
        if (action.equals(DownloadConstants.ACTION_RETRY)) {
            if (Logger.debug()) {
                Logger.taskError(TAG, intExtra, "handleIntent", "Retry delay disable");
            }
        } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY)) {
            DownloadProcessDispatcher.getInstance().recordTaskProcessIndependent(intExtra);
        } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY)) {
            DownloadComponentManager.setDownloadInMultiProcess();
        }
    }
}
