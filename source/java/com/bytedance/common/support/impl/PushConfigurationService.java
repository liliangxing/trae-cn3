package com.bytedance.common.support.impl;

import android.app.Application;
import android.util.Log;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonInitConfigProvider;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.push.helper.EnsureExceptionHelper;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PushConfigurationService implements IPushConfigurationService {
    private volatile PushCommonConfiguration mPushCommonConfiguration;
    private PushCommonConfiguration mDefaultPushCommonConfiguration = new PushCommonConfiguration();
    private final List<Runnable> mRunAfterInitTask = new ArrayList();
    private long mProcessStartTimeStamp = System.currentTimeMillis();

    private PushCommonConfiguration getConfiguration() {
        IPushCommonInitConfigProvider iPushCommonInitConfigProvider;
        if (this.mPushCommonConfiguration == null) {
            synchronized (this) {
                if (this.mPushCommonConfiguration == null && (iPushCommonInitConfigProvider = (IPushCommonInitConfigProvider) UgBusFramework.getService(IPushCommonInitConfigProvider.class)) != null) {
                    this.mPushCommonConfiguration = iPushCommonInitConfigProvider.getConfiguration();
                }
            }
        }
        return this.mPushCommonConfiguration;
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public boolean hasInjectedConfiguration() {
        return getConfiguration() != null;
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public void injectConfiguration(PushCommonConfiguration pushCommonConfiguration) {
        this.mPushCommonConfiguration = pushCommonConfiguration;
        Logger.d("on init,try execute AfterInitTask");
        synchronized (this.mRunAfterInitTask) {
            Logger.d("sRunAfterSmpInitTask.size is " + this.mRunAfterInitTask.size());
            Iterator<Runnable> it = this.mRunAfterInitTask.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            this.mRunAfterInitTask.clear();
        }
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public PushCommonConfiguration getPushCommonConfiguration() {
        Application app;
        if (getConfiguration() == null) {
            if (this.mDefaultPushCommonConfiguration.mApplication == null && (app = AppProvider.getApp()) != null) {
                Logger.w("PushConfigurationService", "[getPushCommonConfiguration]use mDefaultPushCommonConfiguration because mPushCommonConfiguration is null and app is not null,stack is " + Log.getStackTraceString(new Throwable()));
                this.mDefaultPushCommonConfiguration.mApplication = app;
            }
            EnsureExceptionHelper.ensureNotReachHere(new Throwable(), "error when getPushCommonConfiguration,mPushCommonConfiguration is null");
            return this.mDefaultPushCommonConfiguration;
        }
        return getConfiguration();
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public void runAfterInit(Runnable runnable) {
        if (hasInjectedConfiguration()) {
            Logger.d("runAfterInit: has initEd,execute task");
            runnable.run();
        } else {
            synchronized (this.mRunAfterInitTask) {
                Logger.d("runAfterInit: not initEd,add task to list");
                this.mRunAfterInitTask.add(runnable);
            }
        }
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public long getCurProcessStartTimeStamp() {
        return this.mProcessStartTimeStamp;
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public boolean keepOldInitTimeCost() {
        if (ToolUtils.isMainProcess(getConfiguration().mApplication)) {
            return !getConfiguration().mIPushCommonConfiguration.optMainProcessInitTimeCost();
        }
        return true;
    }

    @Override // com.bytedance.common.support.service.IPushConfigurationService
    public boolean keepOldInitTimeCostV2() {
        if (ToolUtils.isMainProcess(getConfiguration().mApplication)) {
            return !getConfiguration().mIPushCommonConfiguration.optMainProcessInitTimeCostV2();
        }
        return true;
    }
}
