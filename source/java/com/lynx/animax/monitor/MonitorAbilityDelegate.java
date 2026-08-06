package com.lynx.animax.monitor;

import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.listener.AnimaXErrorParam;
import com.lynx.animax.listener.AnimaXParam;
import com.lynx.animax.listener.AnimationListenerAdapter;
import com.lynx.animax.p034ui.IAnimaXPlayer;
import com.lynx.animax.service.IAnimaXMonitorService;
import com.lynx.animax.service.ServiceRegistry;
import com.lynx.animax.util.AnimaXMetricsCallback;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MonitorAbilityDelegate extends AnimationListenerAdapter {
    private WeakReference<IAnimaXPlayer> mAnimaXPlayer;
    private long mLastPlayReportTimestamp;
    private int mPlayCount;
    private int mPlayTriggerCount;
    private final ServiceRegistry mServiceRegistry;
    private final long mStayDurationStartTimestamp;
    private boolean mHasReportedFirstPlay = false;
    private final Map<String, Object> mPlatformReportItems = new ConcurrentHashMap();

    public MonitorAbilityDelegate(ServiceRegistry serviceRegistry) {
        this.mServiceRegistry = serviceRegistry;
        long currentTimeMillis = System.currentTimeMillis();
        this.mStayDurationStartTimestamp = currentTimeMillis;
        this.mLastPlayReportTimestamp = currentTimeMillis;
    }

    public void setAnimaXPlayer(AnimaXPlayer animaXPlayer) {
        this.mAnimaXPlayer = new WeakReference<>(animaXPlayer);
    }

    public void setDisplayMode(String str) {
        this.mPlatformReportItems.put(AnimaXMonitorUtil.PLATFORM_KEY_DISPLAY_MODE, str);
    }

    public void setTag(String str) {
        this.mPlatformReportItems.put("tag", str);
    }

    @Override // com.lynx.animax.listener.AnimationListenerAdapter, com.lynx.animax.listener.IAnimationListener
    public void onError(AnimaXErrorParam animaXErrorParam) {
        IAnimaXMonitorService iAnimaXMonitorService = (IAnimaXMonitorService) this.mServiceRegistry.getService(IAnimaXMonitorService.class);
        if (iAnimaXMonitorService != null) {
            iAnimaXMonitorService.reportError(animaXErrorParam);
        }
    }

    @Override // com.lynx.animax.listener.AnimationListenerAdapter, com.lynx.animax.listener.IAnimationListener
    public void onRepeat(AnimaXParam animaXParam) {
        reportOnPlay(false);
    }

    public void updateUrl(String str) {
        IAnimaXMonitorService iAnimaXMonitorService = (IAnimaXMonitorService) this.mServiceRegistry.getService(IAnimaXMonitorService.class);
        if (str == null || iAnimaXMonitorService == null) {
            return;
        }
        iAnimaXMonitorService.setCurrentUrl(str);
    }

    public void onRelease() {
        this.mPlatformReportItems.put(AnimaXMonitorUtil.PLATFORM_KEY_STAY_DURATION, Long.valueOf(System.currentTimeMillis() - this.mStayDurationStartTimestamp));
        reportPerformance(AnimaXMonitorUtil.TRIGGER_ON_RELEASE);
    }

    public void onResume() {
        reportOnPlay();
    }

    public void onPlaySegment() {
        reportOnPlay();
    }

    public void onPlay() {
        reportOnPlay();
    }

    private void reportOnPlay() {
        reportOnPlay(true);
    }

    private void reportOnPlay(boolean z) {
        this.mPlayCount++;
        if (z) {
            this.mPlayTriggerCount++;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.mHasReportedFirstPlay || this.mPlayTriggerCount >= 5 || currentTimeMillis - this.mLastPlayReportTimestamp >= 300000) {
            reportPerformance(AnimaXMonitorUtil.TRIGGER_ON_PLAY);
            this.mHasReportedFirstPlay = true;
            this.mLastPlayReportTimestamp = currentTimeMillis;
        }
    }

    private void reportPerformance(String str) {
        IAnimaXMonitorService iAnimaXMonitorService = (IAnimaXMonitorService) this.mServiceRegistry.getService(IAnimaXMonitorService.class);
        WeakReference<IAnimaXPlayer> weakReference = this.mAnimaXPlayer;
        IAnimaXPlayer iAnimaXPlayer = weakReference != null ? weakReference.get() : null;
        if (iAnimaXPlayer == null || iAnimaXMonitorService == null) {
            return;
        }
        HashMap hashMap = new HashMap(this.mPlatformReportItems);
        int i = this.mPlayCount;
        if (i > 0) {
            hashMap.put(AnimaXMonitorUtil.PLATFORM_KEY_PLAY_COUNT, Integer.valueOf(i));
            this.mPlayCount = 0;
            this.mPlayTriggerCount = 0;
        }
        iAnimaXPlayer.getMetricsAsync(new AnimaXMetricsCallback(iAnimaXMonitorService, str, hashMap));
    }
}
