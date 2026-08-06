package com.bytedance.platform.horae;

import android.app.Application;
import com.bytedance.platform.horae.common.ILog;
import com.bytedance.platform.horae.common.Logger;
import com.bytedance.platform.horae.java_impl.ServiceScheduleManager;
import java.util.Set;

/* loaded from: classes4.dex */
public class HoraeManager {
    private boolean mDangerBarrierFeature;
    private boolean mDebug;
    private Set<String> mIgnoreService;
    private boolean mIsSync;
    private OnEventOccur mOnEventOccur;
    private String mThreadName;
    private long mWorkTime;

    /* loaded from: classes4.dex */
    public static class Builder {
        private Set<String> mIgnoreService;
        private boolean mIsSync;
        private OnEventOccur mOnEventOccur;
        private boolean mDebug = false;
        private String mThreadName = "double_turbo_quicken_engine";
        private boolean mDangerBarrierFeature = false;
        private long mWorkTime = Long.MAX_VALUE;

        public Builder applySync(boolean z) {
            this.mIsSync = z;
            return this;
        }

        public Builder applyLog(ILog iLog, Logger.Level level) {
            Logger.setLog(iLog);
            Logger.setLogLevel(level);
            return this;
        }

        public Builder applyOnEventOccur(OnEventOccur onEventOccur) {
            this.mOnEventOccur = onEventOccur;
            return this;
        }

        public Builder applyThreadName(String str) {
            this.mThreadName = str;
            return this;
        }

        public Builder applyDebugAble(boolean z) {
            this.mDebug = z;
            return this;
        }

        public Builder applyDangerBarrier(boolean z) {
            this.mDangerBarrierFeature = z;
            return this;
        }

        public Builder applyIgnoreList(Set<String> set) {
            this.mIgnoreService = set;
            return this;
        }

        private Builder applyWorkTime(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("time must > 0!");
            }
            this.mWorkTime = j;
            return this;
        }

        public HoraeManager build() {
            return new HoraeManager(this.mIsSync, this.mOnEventOccur, this.mThreadName, this.mDebug, this.mIgnoreService, this.mDangerBarrierFeature, this.mWorkTime);
        }
    }

    private HoraeManager(boolean z, OnEventOccur onEventOccur, String str, boolean z2, Set<String> set, boolean z3, long j) {
        this.mIsSync = z;
        this.mOnEventOccur = onEventOccur;
        this.mThreadName = str;
        this.mDebug = z2;
        this.mIgnoreService = set;
        this.mDangerBarrierFeature = z3;
        this.mWorkTime = j;
    }

    public void start(Application application) {
        ServiceScheduleManager.getInstance(application).start(this.mIsSync, this.mThreadName, this.mOnEventOccur, this.mIgnoreService, this.mDangerBarrierFeature, this.mWorkTime);
    }
}
