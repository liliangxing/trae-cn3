package com.bytedance.salamander.anniex;

import com.bytedance.rts.foundation.RTSArrayKt;
import com.bytedance.rts.foundation.RTSMapKt;
import com.bytedance.salamander.adapter.Lock;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnniexMonitorCoreSLAnnieXMonitorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 '2\u00020\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016J\u0018\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\fH\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u0014\u0010\u001a\u001a\u00020\u00142\n\u0010\u001b\u001a\u00060\u001cj\u0002`\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\nj\b\u0012\u0004\u0012\u00020\u000e`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/salamander/anniex/SLAnnieXMonitorManager;", "", "()V", "dummySLMonitor", "Lcom/bytedance/salamander/anniex/SLAnnieXMonitor;", "manager", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "reportListeners", "Ljava/util/ArrayList;", "Lcom/bytedance/salamander/anniex/ISLMonitorReportListener;", "Lcom/bytedance/rts/foundation/RTSArray;", "settingsListeners", "Lcom/bytedance/salamander/anniex/ISettingsListener;", "setupConfig", "Lcom/bytedance/salamander/anniex/SLMonitorSetupConfig;", "slMonitorHostSwitch", "", "fetchSettings", "", "getMonitorWithSessionId", "sessionId", "getReportListeners", "getSettingsListeners", "globalSwitch", "parseSettingsWithV2JSONSettings", "jsonSettings", "Lorg/json/JSONObject;", "Lcom/bytedance/salamander/anniex/AnnieXJSONObject;", "parseSettingsWithV2Response", "responseStr", "registerReportListener", "listener", "registerSettingsListener", "releaseMonitorWithSessionId", "setup", "unregisterReportListener", "unregisterSettingsListener", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SLAnnieXMonitorManager {
    private static SLAnnieXMonitorManager instance;
    private boolean slMonitorHostSwitch;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Lock settingsListenerLock = new Lock();
    private static Lock reportListenerLock = new Lock();
    private static Lock instanceLock = new Lock();
    private Map<String, SLAnnieXMonitor> manager = RTSMapKt.RTSMap();
    private SLMonitorSetupConfig setupConfig = new SLMonitorSetupConfig();
    private ArrayList<ISettingsListener> settingsListeners = new ArrayList<>();
    private ArrayList<ISLMonitorReportListener> reportListeners = new ArrayList<>();
    private SLAnnieXMonitor dummySLMonitor = new SLAnnieXMonitor("dummy");

    /* renamed from: globalSwitch, reason: from getter */
    public boolean getSlMonitorHostSwitch() {
        return this.slMonitorHostSwitch;
    }

    public void setup(SLMonitorSetupConfig setupConfig) {
        Intrinsics.checkNotNullParameter(setupConfig, "setupConfig");
        this.slMonitorHostSwitch = true;
        this.setupConfig = setupConfig;
    }

    public void fetchSettings() {
        HybridSettings.INSTANCE.fetchSettings(this.setupConfig.getSettingsConfig());
    }

    public void parseSettingsWithV2Response(String responseStr) {
        Intrinsics.checkNotNullParameter(responseStr, "responseStr");
        HybridSettings.INSTANCE.parseSettingsWithV2Response(responseStr);
    }

    public void parseSettingsWithV2JSONSettings(JSONObject jsonSettings) {
        Intrinsics.checkNotNullParameter(jsonSettings, "jsonSettings");
        HybridSettings.INSTANCE.parseSettingsWithV2JSONSettings(jsonSettings);
    }

    public ArrayList<ISettingsListener> getSettingsListeners() {
        return this.settingsListeners;
    }

    public SLAnnieXMonitor getMonitorWithSessionId(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        if (!this.slMonitorHostSwitch) {
            return this.dummySLMonitor;
        }
        if (RTSMapKt.has(this.manager, sessionId)) {
            SLAnnieXMonitor sLAnnieXMonitor = this.manager.get(sessionId);
            Intrinsics.checkNotNull(sLAnnieXMonitor);
            return sLAnnieXMonitor;
        }
        SLAnnieXMonitor sLAnnieXMonitor2 = new SLAnnieXMonitor(sessionId);
        RTSMapKt.set(this.manager, sessionId, sLAnnieXMonitor2);
        return sLAnnieXMonitor2;
    }

    public void releaseMonitorWithSessionId(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        RTSMapKt.delete(this.manager, sessionId);
    }

    public void registerSettingsListener(ISettingsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        settingsListenerLock.lock();
        RTSArrayKt.push(this.settingsListeners, listener);
        settingsListenerLock.unlock();
    }

    public void unregisterSettingsListener(final ISettingsListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        settingsListenerLock.lock();
        int findIndex = RTSArrayKt.findIndex(this.settingsListeners, new Function1<ISettingsListener, Boolean>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitorManager$unregisterSettingsListener$i$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Boolean invoke(ISettingsListener iSettingsListener) {
                Intrinsics.checkNotNullParameter(iSettingsListener, "value");
                return Boolean.valueOf(Intrinsics.areEqual(iSettingsListener, ISettingsListener.this));
            }
        });
        if (findIndex != -1) {
            RTSArrayKt.splice(this.settingsListeners, findIndex, 1, new ISettingsListener[0]);
        }
        settingsListenerLock.unlock();
    }

    public void registerReportListener(ISLMonitorReportListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        reportListenerLock.lock();
        RTSArrayKt.push(this.reportListeners, listener);
        reportListenerLock.unlock();
    }

    public void unregisterReportListener(final ISLMonitorReportListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        reportListenerLock.lock();
        int findIndex = RTSArrayKt.findIndex(this.reportListeners, new Function1<ISLMonitorReportListener, Boolean>() { // from class: com.bytedance.salamander.anniex.SLAnnieXMonitorManager$unregisterReportListener$i$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Boolean invoke(ISLMonitorReportListener iSLMonitorReportListener) {
                Intrinsics.checkNotNullParameter(iSLMonitorReportListener, "value");
                return Boolean.valueOf(Intrinsics.areEqual(iSLMonitorReportListener, ISLMonitorReportListener.this));
            }
        });
        if (findIndex != -1) {
            RTSArrayKt.splice(this.reportListeners, findIndex, 1, new ISLMonitorReportListener[0]);
        }
        reportListenerLock.unlock();
    }

    public ArrayList<ISLMonitorReportListener> getReportListeners() {
        return this.reportListeners;
    }

    /* compiled from: AnniexMonitorCoreSLAnnieXMonitorManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/bytedance/salamander/anniex/SLAnnieXMonitorManager$Companion;", "", "()V", "instance", "Lcom/bytedance/salamander/anniex/SLAnnieXMonitorManager;", "instanceLock", "Lcom/bytedance/salamander/adapter/Lock;", "getInstanceLock", "()Lcom/bytedance/salamander/adapter/Lock;", "setInstanceLock", "(Lcom/bytedance/salamander/adapter/Lock;)V", "reportListenerLock", "getReportListenerLock", "setReportListenerLock", "settingsListenerLock", "getSettingsListenerLock", "setSettingsListenerLock", "getInstance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public Lock getSettingsListenerLock() {
            return SLAnnieXMonitorManager.settingsListenerLock;
        }

        public void setSettingsListenerLock(Lock lock) {
            Intrinsics.checkNotNullParameter(lock, "<set-?>");
            SLAnnieXMonitorManager.settingsListenerLock = lock;
        }

        public Lock getReportListenerLock() {
            return SLAnnieXMonitorManager.reportListenerLock;
        }

        public void setReportListenerLock(Lock lock) {
            Intrinsics.checkNotNullParameter(lock, "<set-?>");
            SLAnnieXMonitorManager.reportListenerLock = lock;
        }

        public Lock getInstanceLock() {
            return SLAnnieXMonitorManager.instanceLock;
        }

        public void setInstanceLock(Lock lock) {
            Intrinsics.checkNotNullParameter(lock, "<set-?>");
            SLAnnieXMonitorManager.instanceLock = lock;
        }

        public SLAnnieXMonitorManager getInstance() {
            if (SLAnnieXMonitorManager.instance != null) {
                SLAnnieXMonitorManager sLAnnieXMonitorManager = SLAnnieXMonitorManager.instance;
                Intrinsics.checkNotNull(sLAnnieXMonitorManager);
                return sLAnnieXMonitorManager;
            }
            SLAnnieXMonitorManager.INSTANCE.getInstanceLock().lock();
            if (SLAnnieXMonitorManager.instance != null) {
                SLAnnieXMonitorManager.INSTANCE.getInstanceLock().unlock();
                SLAnnieXMonitorManager sLAnnieXMonitorManager2 = SLAnnieXMonitorManager.instance;
                Intrinsics.checkNotNull(sLAnnieXMonitorManager2);
                return sLAnnieXMonitorManager2;
            }
            Companion companion = SLAnnieXMonitorManager.INSTANCE;
            SLAnnieXMonitorManager.instance = new SLAnnieXMonitorManager();
            SLAnnieXMonitorManager.INSTANCE.getInstanceLock().unlock();
            SLAnnieXMonitorManager sLAnnieXMonitorManager3 = SLAnnieXMonitorManager.instance;
            Intrinsics.checkNotNull(sLAnnieXMonitorManager3);
            return sLAnnieXMonitorManager3;
        }
    }
}
