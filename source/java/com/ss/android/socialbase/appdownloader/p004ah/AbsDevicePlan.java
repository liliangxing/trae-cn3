package com.ss.android.socialbase.appdownloader.p004ah;

import android.content.Context;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsDevicePlan implements IAhDevicePlan {
    private static final String TAG = "AbsDevicePlan";
    protected final Context mContext;
    protected final String mJumpPath;
    protected final DownloadSetting mSetting;

    public AbsDevicePlan(Context context, DownloadSetting downloadSetting, String str) {
        this.mContext = context;
        this.mSetting = downloadSetting;
        this.mJumpPath = str;
    }

    @Override // com.ss.android.socialbase.appdownloader.p004ah.IAhDevicePlan
    public boolean isValid() {
        if (this.mContext == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            Logger.globalError(TAG, "isValid", "Check is valid failed: " + th.toString());
        }
        return getJumpIntent().resolveActivity(this.mContext.getPackageManager()) != null;
    }
}
