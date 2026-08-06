package com.bytedance.applog.engine;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.manager.ConfigManager;
import com.bytedance.applog.monitor.MonitorUtils;
import com.bytedance.applog.monitor.p006v3.EventStage;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.store.BaseData;
import com.bytedance.applog.store.Launch;
import com.bytedance.applog.store.Page;
import com.bytedance.applog.store.Terminate;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.utility.NetworkUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Session {
    private static final List<String> logTags = Collections.singletonList("Session");
    private static TermTrigger mTermTrigger;
    private final Engine mEngine;
    private volatile boolean mHadUi;
    private String mId;
    private Page mLastActivity;
    private String mLastDay;
    private volatile String mLastFgId;
    private Page mLastFragment;
    private long mLastPauseTs;
    private volatile long mLastPlayTs;
    private volatile long mLatestForgroundSessionTime;
    private int mPlayCount;
    private int mSessionOfDay;
    private volatile long sUserId;
    public volatile long sUidFromResp = 0;
    public volatile int sUserTypeFromResp = 0;
    public volatile int sUserIsLoginFromResp = 0;
    public volatile int sUserIsAuthFromResp = 0;
    private final AtomicLong sEventId = new AtomicLong(1000);
    private long mStartTs = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session(Engine engine) {
        this.mEngine = engine;
        this.mLatestForgroundSessionTime = engine.getConfig().getLatestFgSessionTime();
    }

    public static String genSessionId() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return this.mId;
    }

    public String getLastFgId() {
        return this.mLastFgId;
    }

    public long getUserId() {
        return this.sUserId;
    }

    public void setUserId(long j) {
        this.sUserId = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Bundle getPlayBundle(long j, long j2) {
        Bundle bundle;
        long j3 = this.mLastPlayTs;
        if (this.mEngine.getConfig().isPlayEnable() && isResume() && j3 > 0) {
            long j4 = j - j3;
            if (j4 > j2) {
                bundle = new Bundle();
                bundle.putInt("session_no", this.mSessionOfDay);
                int i = this.mPlayCount + 1;
                this.mPlayCount = i;
                bundle.putInt("send_times", i);
                bundle.putLong("current_duration", j4 / 1000);
                bundle.putString("session_start_time", BaseData.formatDateMS(this.mStartTs));
                this.mLastPlayTs = j;
            }
        }
        bundle = null;
        return bundle;
    }

    public boolean hadUi() {
        return this.mHadUi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isResume() {
        return hadUi() && this.mLastPauseTs == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Launch startSession(BaseData baseData, ArrayList<BaseData> arrayList, boolean z) {
        long j;
        Launch launch;
        if (baseData != null) {
            j = baseData instanceof TermTrigger ? -1L : baseData.f80ts;
        } else {
            j = 0;
        }
        this.mId = genSessionId();
        if (z) {
            this.mLatestForgroundSessionTime = j;
            this.mEngine.getConfig().setLatestForgroundSessionTime(this.mLatestForgroundSessionTime);
            if (!this.mEngine.mUuidChanged && TextUtils.isEmpty(this.mLastFgId)) {
                this.mLastFgId = this.mId;
            }
        }
        this.sEventId.set(GWorker.INTERVAL);
        this.mStartTs = j;
        this.mHadUi = z;
        this.mLastPauseTs = 0L;
        this.mLastPlayTs = 0L;
        boolean z2 = true;
        if (z) {
            Calendar calendar = Calendar.getInstance();
            String str = "" + calendar.get(1) + calendar.get(2) + calendar.get(5);
            ConfigManager config = this.mEngine.getConfig();
            if (TextUtils.isEmpty(this.mLastDay)) {
                this.mLastDay = config.getLastDay();
                this.mSessionOfDay = config.getSessionOrder();
            }
            if (!str.equals(this.mLastDay)) {
                this.mLastDay = str;
                this.mSessionOfDay = 1;
            } else {
                this.mSessionOfDay++;
            }
            config.setLastDay(str, this.mSessionOfDay);
            this.mPlayCount = 0;
            this.mLastPlayTs = j;
        }
        if (j != -1) {
            launch = new Launch();
            launch.setAppId(this.mEngine.getAppLog().getAppId());
            launch.sid = this.mId;
            if (this.mHadUi) {
                z2 = false;
            }
            launch.mBg = z2;
            launch.eid = nextEventId();
            launch.setTs(this.mStartTs);
            launch.verName = this.mEngine.getDm().getVersionName();
            launch.verCode = this.mEngine.getDm().getVersionCode();
            fillUserInfoAndAbSdkVersion(launch, getUserId());
            launch.uuid = this.mEngine.getAppLog().getUserUniqueID();
            launch.sentryStained = MonitorUtils.getStainedValue(this.mEngine.getAppLog().getMonitorHelper(), launch);
            if (baseData instanceof Page) {
                launch.flatParams = ((Page) baseData).flatParams;
            }
            arrayList.add(launch);
            if (launch.sentryStained > 0) {
                MonitorUtils.stageEvent(this.mEngine.getAppLog().getMonitorHelper(), EventStage.COLLECTED, launch);
            }
            this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.COLLECT_LAUNCH_COUNT);
            if (this.mHadUi) {
                this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.COLLECT_FRONT_LAUNCH_COUNT);
            }
            this.mEngine.getAppLog().getLaunchObserverHolder().onLaunch(launch.sid, launch.f80ts, launch.mBg);
        } else {
            launch = null;
        }
        if (this.mEngine.getAppLog().getLaunchFrom() <= 0) {
            this.mEngine.getAppLog().setLaunchFrom(6);
        }
        this.mEngine.getAppLog().getLogger().info(logTags, "startSession, " + (this.mHadUi ? "fg" : "bg") + ", " + this.mId + ", " + j, new Object[0]);
        return launch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isResumeEvent(BaseData baseData) {
        if (baseData instanceof Page) {
            return ((Page) baseData).isResumeEvent();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean process(BaseData baseData, ArrayList<BaseData> arrayList) {
        boolean z = baseData instanceof Page;
        boolean isResumeEvent = isResumeEvent(baseData);
        boolean z2 = false;
        if (this.mStartTs == -1) {
            this.mEngine.getAppLog().getLogger().debug(logTags, "session process start session 1, data={}, isResume=" + isResumeEvent, baseData);
            startSession(baseData, arrayList, isResumeEvent(baseData));
        } else if (!this.mHadUi && isResumeEvent) {
            this.mEngine.getAppLog().getLogger().debug(logTags, "session process start session 2, data={}", baseData);
            startSession(baseData, arrayList, true);
        } else if (this.mLastPauseTs != 0 && baseData.f80ts > this.mLastPauseTs + this.mEngine.getBackgroundSessionKeepMills()) {
            this.mEngine.getAppLog().getLogger().debug(logTags, "session process start session 3, data={}, isResume=" + isResumeEvent, baseData);
            startSession(baseData, arrayList, isResumeEvent);
        } else {
            if (this.mStartTs > baseData.f80ts + 7200000) {
                this.mEngine.getAppLog().getLogger().debug(logTags, "session process start session 4, data={}, isResume=" + isResumeEvent, baseData);
                startSession(baseData, arrayList, isResumeEvent);
            }
            if (!z) {
                Page page = (Page) baseData;
                if (page.isResumeEvent()) {
                    this.mLastPauseTs = 0L;
                    arrayList.add(baseData);
                    if (TextUtils.isEmpty(page.last)) {
                        if (this.mLastFragment != null && (page.f80ts - this.mLastFragment.f80ts) - this.mLastFragment.duration < 500) {
                            page.last = this.mLastFragment.name;
                        } else if (this.mLastActivity != null && (page.f80ts - this.mLastActivity.f80ts) - this.mLastActivity.duration < 500) {
                            page.last = this.mLastActivity.name;
                        }
                    }
                } else {
                    Bundle playBundle = getPlayBundle(baseData.f80ts, 0L);
                    if (this.mEngine.getAppLog() != null && playBundle != null) {
                        this.mEngine.getAppLog().onEventV3("play_session", playBundle);
                    }
                    this.mLastPauseTs = page.f80ts;
                    arrayList.add(baseData);
                    if (page.isActivity()) {
                        this.mLastActivity = page;
                    } else {
                        this.mLastFragment = page;
                        this.mLastActivity = null;
                    }
                }
            } else if (!(baseData instanceof TermTrigger)) {
                arrayList.add(baseData);
            }
            fillSessionParams(baseData);
            return z2;
        }
        z2 = true;
        if (!z) {
        }
        fillSessionParams(baseData);
        return z2;
    }

    public void fillSessionParams(BaseData baseData) {
        if (baseData != null) {
            fillUserInfoAndAbSdkVersion(baseData, getUserId());
            baseData.setAppId(this.mEngine.getAppLog().getAppId());
            baseData.uuid = this.mEngine.getAppLog().getUserUniqueID();
            baseData.sid = this.mId;
            baseData.eid = nextEventId();
            baseData.f79nt = NetworkUtils.getNetworkTypeFast(this.mEngine.getContext()).getValue();
        }
    }

    public long nextEventId() {
        return this.sEventId.incrementAndGet();
    }

    public void fillUserInfoAndAbSdkVersion(BaseData baseData, long j) {
        IBDAccountCallback bDAccountCallback = this.mEngine.getAppLog().getBDAccountCallback();
        if (this.mEngine.getAppLog().getEnableEventUserId() && bDAccountCallback != null) {
            Pair<Integer, Long> odinUserInfo = bDAccountCallback.getOdinUserInfo();
            if (((Long) odinUserInfo.second).longValue() > 0) {
                baseData.user_id = ((Long) odinUserInfo.second).longValue();
                baseData.userIsLogin = 1;
                baseData.userIsAuth = 1;
                baseData.userType = ((Integer) odinUserInfo.first).intValue();
                baseData.uid = ((Long) odinUserInfo.second).longValue();
            } else if (this.sUserIsLoginFromResp == 0) {
                baseData.uid = this.sUidFromResp;
                baseData.userType = this.sUserTypeFromResp;
                baseData.userIsLogin = this.sUserIsLoginFromResp;
                baseData.userIsAuth = this.sUserIsAuthFromResp;
            }
        } else {
            baseData.user_id = j;
        }
        baseData.abSdkVersion = this.mEngine.getAppLog().getAbSdkVersion(String.valueOf(baseData.user_id));
    }

    public long getLatestForgroundSessionTime() {
        return this.mLatestForgroundSessionTime;
    }

    public long getStartTs() {
        return this.mStartTs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class TermTrigger extends Terminate {
        TermTrigger() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TermTrigger getTermTrigger() {
        if (mTermTrigger == null) {
            mTermTrigger = new TermTrigger();
        }
        mTermTrigger.setTs(0L);
        return mTermTrigger;
    }
}
