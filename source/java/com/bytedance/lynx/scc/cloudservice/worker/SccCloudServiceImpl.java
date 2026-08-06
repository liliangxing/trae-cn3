package com.bytedance.lynx.scc.cloudservice.worker;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import com.bytedance.lynx.scc.cloudservice.SccCloudService;
import com.bytedance.lynx.scc.cloudservice.SccCloudServiceManager;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.lynx.scc.cloudservice.SccSettings;
import com.bytedance.lynx.scc.cloudservice.SccUrlCheckResult;
import com.bytedance.lynx.scc.cloudservice.network.UrlResponse;
import com.bytedance.lynx.scc.cloudservice.utils.Logger;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SccCloudServiceImpl {
    private static final int MAX_EVENT_WAIT_TIME = 5;
    private final ConcurrentHashMap<String, EventTracker> mEventRecords;
    private final ScheduledExecutorService mExecutorService;
    private final ConcurrentHashMap<String, Future<UrlResponse>> mPrefetchTasks;
    private final ConcurrentHashMap<String, Future<SccResult>> mSccTasks;
    private final SccSettings mSettings;
    private final SccCloudService.SccUrlCheckerDelegate mUrlCheckerDelegate;
    private final List<String> mWvUserAllowUrl;

    public SccCloudServiceImpl() {
        this(null);
    }

    public SccCloudServiceImpl(SccCloudService.SccUrlCheckerDelegate delegate) {
        this.mUrlCheckerDelegate = delegate;
        this.mExecutorService = Executors.newScheduledThreadPool(3);
        this.mSccTasks = new ConcurrentHashMap<>();
        this.mPrefetchTasks = new ConcurrentHashMap<>();
        this.mWvUserAllowUrl = new ArrayList();
        this.mSettings = new SccSettings(SccCloudServiceManager.getGlobalSccSettings());
        this.mEventRecords = new ConcurrentHashMap<>();
    }

    protected void finalize() throws Throwable {
        try {
            this.mExecutorService.shutdown();
        } catch (Throwable unused) {
        }
        super.finalize();
    }

    public void doCheck(String url) {
        boolean isEnableScc;
        boolean isEnablePrefetch;
        String seclinkScene;
        int csMaxWaitMs;
        Logger.m93d("!!! scc cloud service doCheck() !!!");
        if (SccCloudServiceManager.getNetAdapter() == null) {
            Logger.m97w("net adapter null, skip check!");
            return;
        }
        if (TextUtils.isEmpty(url) || !SccUtils.schemeIsHttpOrHttps(url)) {
            Logger.m93d("url schema not http/https, skip check!");
            return;
        }
        final String urlWithPathUnify = SccUtils.getUrlWithPathUnify(url);
        EventTracker eventTracker = new EventTracker();
        eventTracker.onStart(urlWithPathUnify);
        synchronized (this) {
            isEnableScc = this.mSettings.isEnableScc();
            isEnablePrefetch = this.mSettings.isEnablePrefetch();
            seclinkScene = this.mSettings.getSeclinkScene();
            csMaxWaitMs = this.mSettings.getCsMaxWaitMs();
        }
        if (!isEnableScc) {
            Logger.m97w("cloud service not enable, skip check!");
            eventTracker.onDisabled();
            return;
        }
        SccUrlCheckResult isHostHitAllowList = isHostHitAllowList(SccUtils.getHost(urlWithPathUnify));
        if (isHostHitAllowList != null && isHostHitAllowList.isSuccess()) {
            Logger.m93d("url hit allow host:" + isHostHitAllowList.getMatchRule());
            eventTracker.onHitAllowList(isHostHitAllowList.getMatchRule());
            return;
        }
        if (CacheManager.getInstance().hitAllowUrlCache(urlWithPathUnify)) {
            Logger.m93d("url hit allow cache:" + urlWithPathUnify);
            eventTracker.onHitCache(urlWithPathUnify);
            return;
        }
        SccUrlCheckResult isUrlHitUserAllowList = isUrlHitUserAllowList(urlWithPathUnify);
        if (isUrlHitUserAllowList != null && isUrlHitUserAllowList.isSuccess()) {
            Logger.m93d("url hit user allow:" + isUrlHitUserAllowList.getMatchRule());
            eventTracker.onUserSkip();
            return;
        }
        synchronized (this) {
            if (this.mSccTasks.containsKey(urlWithPathUnify)) {
                Logger.m93d("url already checking, skip check!");
                return;
            }
            eventTracker.onCSStart();
            this.mEventRecords.put(urlWithPathUnify, eventTracker);
            this.mExecutorService.schedule(new Runnable() { // from class: com.bytedance.lynx.scc.cloudservice.worker.SccCloudServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    EventTracker eventTracker2 = (EventTracker) SccCloudServiceImpl.this.mEventRecords.remove(urlWithPathUnify);
                    if (eventTracker2 != null) {
                        eventTracker2.onUserRequestEnd(false, "UserTimeout");
                    }
                }
            }, 5L, TimeUnit.SECONDS);
            this.mSccTasks.putIfAbsent(urlWithPathUnify, this.mExecutorService.submit(new CloudCheckWorker(urlWithPathUnify, seclinkScene, this)));
            if (isEnablePrefetch) {
                this.mPrefetchTasks.putIfAbsent(urlWithPathUnify, this.mExecutorService.submit(new PrefetchWorker(urlWithPathUnify, csMaxWaitMs, eventTracker)));
            }
        }
    }

    public void setSettingsJsonConfig(JsonObject json) {
        synchronized (this) {
            SccSettings.fromJson(json, this.mSettings);
        }
    }

    public void setSeclinkScene(String scene) {
        if (TextUtils.isEmpty(scene)) {
            return;
        }
        synchronized (this) {
            this.mSettings.setSeclinkScene(scene);
        }
    }

    public void onUserAllow(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        String urlWithPathUnify = SccUtils.getUrlWithPathUnify(url);
        synchronized (this) {
            this.mWvUserAllowUrl.add(urlWithPathUnify);
        }
    }

    public SccUrlCheckResult isUrlHitUserAllowList(String url) {
        String urlWithPathUnify = SccUtils.getUrlWithPathUnify(url);
        SccCloudService.SccUrlCheckerDelegate sccUrlCheckerDelegate = this.mUrlCheckerDelegate;
        if (sccUrlCheckerDelegate != null && sccUrlCheckerDelegate.isInAllowList(urlWithPathUnify)) {
            return new SccUrlCheckResult(true, urlWithPathUnify);
        }
        synchronized (this) {
            if (!this.mWvUserAllowUrl.remove(urlWithPathUnify)) {
                return null;
            }
            return new SccUrlCheckResult(true, urlWithPathUnify);
        }
    }

    public void addDomainsAllowList(List<String> domains) {
        if (domains == null || domains.size() == 0) {
            return;
        }
        SccUtils.removeTrailingSlash(domains);
        synchronized (this) {
            this.mSettings.addAllowDomains(domains);
        }
    }

    public SccUrlCheckResult isHostHitAllowList(String host) {
        SccUrlCheckResult hitAllowDomains;
        if (TextUtils.isEmpty(host)) {
            return null;
        }
        String removeTrailingSlash = SccUtils.removeTrailingSlash(host);
        synchronized (this) {
            hitAllowDomains = this.mSettings.hitAllowDomains(removeTrailingSlash);
        }
        return hitAllowDomains;
    }

    public void clearAllowList() {
        synchronized (this) {
            this.mSettings.clearAllowDomains();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SccResult getCloudServiceResponse(String url) {
        String urlWithPathUnify;
        Future<SccResult> remove;
        int csMaxWaitMs;
        Exception e;
        SccResult sccResult;
        if (TextUtils.isEmpty(url) || (remove = this.mSccTasks.remove((urlWithPathUnify = SccUtils.getUrlWithPathUnify(url)))) == null) {
            return null;
        }
        EventTracker eventTracker = this.mEventRecords.get(urlWithPathUnify);
        if (eventTracker != null) {
            eventTracker.onUserRequestStart();
        }
        Logger.m93d("will wait response, url: " + urlWithPathUnify);
        synchronized (this) {
            csMaxWaitMs = this.mSettings.getCsMaxWaitMs();
        }
        try {
            sccResult = remove.get(csMaxWaitMs, TimeUnit.MILLISECONDS);
            if (eventTracker != null) {
                try {
                    eventTracker.onUserRequestEnd(true, null);
                } catch (InterruptedException e2) {
                    e = e2;
                    Logger.m97w("getCloudServiceResponse error:" + Log.getStackTraceString(e));
                    if (eventTracker != null) {
                        eventTracker.onUserRequestEnd(false, e.toString());
                    }
                    this.mEventRecords.remove(urlWithPathUnify);
                    Logger.m93d("res json: " + sccResult);
                    return sccResult;
                } catch (ExecutionException e3) {
                    e = e3;
                    Logger.m97w("getCloudServiceResponse error:" + Log.getStackTraceString(e));
                    if (eventTracker != null) {
                    }
                    this.mEventRecords.remove(urlWithPathUnify);
                    Logger.m93d("res json: " + sccResult);
                    return sccResult;
                } catch (TimeoutException e4) {
                    e = e4;
                    Logger.m97w("getCloudServiceResponse error:" + Log.getStackTraceString(e));
                    if (eventTracker != null) {
                    }
                    this.mEventRecords.remove(urlWithPathUnify);
                    Logger.m93d("res json: " + sccResult);
                    return sccResult;
                }
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            e = e5;
            sccResult = null;
        }
        this.mEventRecords.remove(urlWithPathUnify);
        Logger.m93d("res json: " + sccResult);
        return sccResult;
    }

    public WebResourceResponse tryGetPrefetchResponse(String url) {
        Future<UrlResponse> future = this.mPrefetchTasks.get(SccUtils.getUrlWithPathUnify(url));
        if (future == null) {
            return null;
        }
        try {
            if (future.isDone()) {
                return SccUtils.getWebResponse(future.get());
            }
        } catch (InterruptedException e) {
            Logger.m97w("tryGetPrefetchResponse timeout:" + e);
        } catch (ExecutionException e2) {
            Logger.m94e("tryGetPrefetchResponse exec error:" + e2);
        }
        return null;
    }

    public EventTracker getEventTracker(String url) {
        return this.mEventRecords.get(SccUtils.getUrlWithPathUnify(url));
    }

    public SccSettings getSettings() {
        return this.mSettings;
    }
}
