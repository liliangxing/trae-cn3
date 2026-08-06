package com.ss.android.deviceregister;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.core.RegisterServiceController;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EgdiManager {
    public static final int DEFAULT_INTERVAL = 10000;

    /* renamed from: sp */
    private final SharedPreferences f43sp;
    private int retryCount = 0;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private String mEgdi = "";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface EgdiCallback {
        void onEgdiFailed();
    }

    static /* synthetic */ int access$008(EgdiManager egdiManager) {
        int i = egdiManager.retryCount;
        egdiManager.retryCount = i + 1;
        return i;
    }

    public EgdiManager(Context context) {
        this.f43sp = context.getSharedPreferences(AppLogConstants.getSPName(), 0);
    }

    public void handleEgid(final RegisterServiceController registerServiceController) {
        if (this.retryCount >= 3) {
            TLog.m77i("[egdi] retry count has been limited. retryCount = " + this.retryCount);
        } else {
            this.handler.postDelayed(new Runnable() { // from class: com.ss.android.deviceregister.EgdiManager.1
                @Override // java.lang.Runnable
                public void run() {
                    TLog.m77i("[egdi] do register to get edgi.");
                    registerServiceController.tryUpdateDeviceId();
                    EgdiManager.access$008(EgdiManager.this);
                }
            }, DeviceRegisterManager.getEgdiRetryInterval());
        }
    }

    public String getEgdi() {
        if (!TextUtils.isEmpty(this.mEgdi)) {
            return this.mEgdi;
        }
        TLog.m77i("[egdi] get egdi from sp.");
        String string = this.f43sp.getString(AppLogConstants.KLINK_EGDI, "");
        this.mEgdi = string;
        return string;
    }
}
