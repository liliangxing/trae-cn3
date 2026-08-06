package com.ss.android.ugc.quota;

import android.app.Application;
import android.util.Log;
import android.util.Pair;
import com.ss.android.ugc.quota.launch.BDNetworkLaunchMonitor;
import com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public class BDNetworkTagManager {
    private static final String TAG = "BDNetworkTagManager";
    private static volatile BDNetworkTagManager sInstance;
    private boolean firstInstallLaunch;
    public static final String KEY_BD_NETWORK_REQUEST_TAG = "x-tt-request-tag";
    private static final Pair<String, String> DEFAULT_TAG = new Pair<>(KEY_BD_NETWORK_REQUEST_TAG, "");
    private Lazy<Application> contextLazy = new Lazy<Application>() { // from class: com.ss.android.ugc.quota.BDNetworkTagManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.ugc.quota.Lazy
        public Application initialValue() {
            return DefaultConfigProvider.getApplication();
        }
    };
    private Lazy<IBDNetworkTagDepend> dependLazy = new Lazy<IBDNetworkTagDepend>() { // from class: com.ss.android.ugc.quota.BDNetworkTagManager.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.ugc.quota.Lazy
        public IBDNetworkTagDepend initialValue() {
            IBDNetworkTagDepend tagDepend = DefaultConfigProvider.getTagDepend();
            if (tagDepend != null) {
                BDNetworkTagManager.this.enable.set(tagDepend.enable());
                BDNetworkTagManager.this.firstInstallLaunch = tagDepend.isNewInstall();
            }
            return tagDepend;
        }
    };
    private Lazy<IBDNetworkLaunchMonitor> launchMonitorLazy = new Lazy<IBDNetworkLaunchMonitor>() { // from class: com.ss.android.ugc.quota.BDNetworkTagManager.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.ugc.quota.Lazy
        public IBDNetworkLaunchMonitor initialValue() {
            IBDNetworkLaunchMonitor launchMonitor;
            return (BDNetworkTagManager.this.dependLazy.get() == null || (launchMonitor = ((IBDNetworkTagDepend) BDNetworkTagManager.this.dependLazy.get()).launchMonitor()) == null) ? new BDNetworkLaunchMonitor((Application) BDNetworkTagManager.this.contextLazy.get()) : launchMonitor;
        }
    };
    private AtomicBoolean enable = new AtomicBoolean(false);
    private int launchType = -999;

    private BDNetworkTagManager() {
    }

    public static BDNetworkTagManager getInstance() {
        if (sInstance == null) {
            synchronized (BDNetworkTagManager.class) {
                if (sInstance == null) {
                    sInstance = new BDNetworkTagManager();
                }
            }
        }
        return sInstance;
    }

    public void init(Application application, IBDNetworkTagDepend iBDNetworkTagDepend) {
        if (this.dependLazy.hasInitialized()) {
            Log.d(TAG, "Already inited");
            return;
        }
        if (application == null || iBDNetworkTagDepend == null) {
            throw new IllegalArgumentException("Context or depend is NULL");
        }
        this.contextLazy.set(application);
        this.enable.set(iBDNetworkTagDepend.enable());
        IBDNetworkLaunchMonitor launchMonitor = iBDNetworkTagDepend.launchMonitor();
        if (launchMonitor != null) {
            this.launchMonitorLazy.set(launchMonitor);
        }
        this.firstInstallLaunch = iBDNetworkTagDepend.isNewInstall();
        this.dependLazy.set(iBDNetworkTagDepend);
    }

    public void enable(boolean z) {
        this.enable.set(z);
    }

    public void updateLaunchType(int i) {
        if (enabled()) {
            this.launchType = i;
            if (this.dependLazy.get() != null) {
                this.dependLazy.get().onLaunchTypeUpdate(i);
            }
        }
    }

    public Pair<String, String> buildBDNetworkTag(IBDNetworkTagContextProvider iBDNetworkTagContextProvider) {
        if (!enabled()) {
            return DEFAULT_TAG;
        }
        if (iBDNetworkTagContextProvider == null) {
            return DEFAULT_TAG;
        }
        int currentLaunchType = this.launchMonitorLazy.get().currentLaunchType();
        if (this.launchType != currentLaunchType) {
            updateLaunchType(currentLaunchType);
        }
        return new Pair<>(KEY_BD_NETWORK_REQUEST_TAG, "t=" + iBDNetworkTagContextProvider.triggerType() + ";n=" + (iBDNetworkTagContextProvider.markAsNewUser() ? 1 : 0));
    }

    public int currentLaunchType() {
        if (enabled()) {
            return this.launchType;
        }
        return -999;
    }

    public boolean isFirstInstallLaunch() {
        if (enabled()) {
            return this.firstInstallLaunch;
        }
        return false;
    }

    private boolean enabled() {
        return this.dependLazy.get() != null && this.enable.get();
    }
}
