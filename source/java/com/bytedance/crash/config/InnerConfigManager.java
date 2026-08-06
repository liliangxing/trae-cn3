package com.bytedance.crash.config;

import com.bytedance.crash.monitor.EventMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InnerConfigManager extends ConfigManager implements IConfigListener {
    private static final int MAX_RETRY_COUNT = 30;
    private static final int RETRY_INTERVAL = 2000;
    private volatile boolean isReady;
    private final Runnable mFetchConfigRunnable;
    private IConfigManager mIConfigManager;
    private volatile int mTryCount;

    public void onReady() {
    }

    public InnerConfigManager(EventMonitor eventMonitor) {
        super(eventMonitor);
        this.isReady = false;
        this.mFetchConfigRunnable = new Runnable() { // from class: com.bytedance.crash.config.InnerConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                InnerConfigManager.this.tryGetConfigFromApm();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.crash.config.ConfigManager
    public void initConfig() {
        if (!App.isMainProcess()) {
            super.initConfig();
            return;
        }
        try {
            IConfigManager iConfigManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
            this.mIConfigManager = iConfigManager;
            if (iConfigManager != null) {
                iConfigManager.registerConfigListener(this);
            }
            DefaultWorkThread.postDelayed(this.mFetchConfigRunnable, 2000L);
        } catch (Throwable th) {
            super.initConfig();
            NpthLog.m232e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryGetConfigFromApm() {
        NpthLog.m233i("tryGetConfigFromApm isReady:" + this.isReady);
        if (this.isReady) {
            return;
        }
        NpthLog.m233i("tryGetConfigFromApm mTryCount:" + this.mTryCount);
        if (this.mTryCount >= 30) {
            DefaultWorkThread.removeCallbacks(this.mFetchConfigRunnable);
            super.initConfig();
        } else {
            if (this.mIConfigManager == null) {
                IConfigManager iConfigManager = (IConfigManager) ServiceManager.getService(IConfigManager.class);
                this.mIConfigManager = iConfigManager;
                if (iConfigManager != null) {
                    iConfigManager.registerConfigListener(this);
                }
            }
            DefaultWorkThread.removeCallbacks(this.mFetchConfigRunnable);
            DefaultWorkThread.postDelayed(this.mFetchConfigRunnable, 2000L);
        }
        this.mTryCount++;
    }

    public void onRefresh(final JSONObject jSONObject, boolean z) {
        this.isReady = true;
        DefaultWorkThread.removeCallbacks(this);
        DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.config.InnerConfigManager.2
            @Override // java.lang.Runnable
            public void run() {
                InnerConfigManager.this.saveConfig(jSONObject);
            }
        });
    }
}
