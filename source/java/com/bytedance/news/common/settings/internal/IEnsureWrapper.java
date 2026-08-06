package com.bytedance.news.common.settings.internal;

import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.IEnsure;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class IEnsureWrapper implements IEnsure {
    private static volatile IEnsureWrapper INSTANCE;
    private Executor mExecutor;

    private IEnsureWrapper() {
        SettingsConfigProvider settingsConfigProvider = (SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class);
        if (settingsConfigProvider != null && settingsConfigProvider.getConfig() != null) {
            this.mExecutor = settingsConfigProvider.getConfig().getExecutor();
        }
        if (this.mExecutor == null) {
            this.mExecutor = Executors.newCachedThreadPool();
        }
    }

    public static IEnsureWrapper getInstance() {
        if (INSTANCE == null) {
            synchronized (IEnsureWrapper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new IEnsureWrapper();
                }
            }
        }
        return INSTANCE;
    }

    public boolean ensureTrue(boolean z) {
        return EnsureManager.ensureTrue(z);
    }

    public boolean ensureFalse(boolean z) {
        return EnsureManager.ensureFalse(z);
    }

    public boolean ensureTrue(boolean z, String str) {
        return EnsureManager.ensureTrue(z, str);
    }

    public boolean ensureTrue(boolean z, String str, Map<String, String> map) {
        return EnsureManager.ensureTrue(z, str, map);
    }

    public boolean ensureFalse(boolean z, String str) {
        return EnsureManager.ensureFalse(z, str);
    }

    public boolean ensureFalse(boolean z, String str, Map<String, String> map) {
        return EnsureManager.ensureFalse(z, str, map);
    }

    public void ensureNotReachHere() {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.ensureNotReachHere();
            }
        });
    }

    public void ensureNotReachHere(final String str) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.ensureNotReachHere(str);
            }
        });
    }

    public void ensureNotReachHere(final Throwable th) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.3
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.ensureNotReachHere(th);
            }
        });
    }

    public void reportLogException(final Throwable th) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.4
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.reportLogEException(0, th, (String) null, false);
            }
        });
    }

    public void reportLogException(final Throwable th, final String str) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.5
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.reportLogEException(0, th, str, false);
            }
        });
    }

    public void reportLogException(final int i, final Throwable th, final String str) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.6
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.reportLogEException(i, th, str, false);
            }
        });
    }

    public void ensureNotReachHere(final Throwable th, final String str) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.7
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.ensureNotReachHere(th, str);
            }
        });
    }

    public void ensureNotReachHere(final String str, final Map<String, String> map) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.8
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.ensureNotReachHere(str, map);
            }
        });
    }

    public void ensureNotReachHere(final Throwable th, final String str, final Map<String, String> map) {
        this.mExecutor.execute(new Runnable() { // from class: com.bytedance.news.common.settings.internal.IEnsureWrapper.9
            @Override // java.lang.Runnable
            public void run() {
                EnsureManager.ensureNotReachHere(th, str, map);
            }
        });
    }

    public boolean ensureNotEmpty(Collection collection) {
        return EnsureManager.ensureNotEmpty(collection);
    }

    public boolean ensureNotNull(Object obj) {
        return EnsureManager.ensureNotNull(obj);
    }

    public boolean ensureNotNull(Object obj, String str) {
        return EnsureManager.ensureNotNull(obj, str);
    }
}
