package com.bytedance.applog.collector;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.store.Page;
import com.bytedance.common.wschannel.WsConstants;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Navigator implements Application.ActivityLifecycleCallbacks {
    public static final int DELAY_MULTY_PROC = 500;
    private static final String RESUME_EVENT_NAME = "applog_activity_resume";
    private final AppLogInstance appLogInstance;
    private volatile NavigatorCallback callback;
    private Page sCurActPage;
    private String sLastActivity;
    private long sLastActivityPauseTs;
    private int sActiveCount = 0;
    private final HashSet<Integer> sNewActivity = new HashSet<>(8);
    private boolean isCodeLaunch = true;
    private boolean hasAnyActivityResumed = false;
    private volatile boolean mTrackResumeEvent = false;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void setTrackResumeEvent(boolean z) {
        this.mTrackResumeEvent = z;
    }

    public Navigator(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    public Page getCurPage() {
        return this.sCurActPage;
    }

    public void setCallback(NavigatorCallback navigatorCallback) {
        this.callback = navigatorCallback;
    }

    public String getPageName() {
        Page curPage = getCurPage();
        return curPage != null ? curPage.name : "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        onActivityResumed(activity.getClass().getName(), activity.hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResumed(String str, int i) {
        this.appLogInstance.getPageHolder().setSdkPageId(str + "___" + i);
        long currentTimeMillis = System.currentTimeMillis();
        this.appLogInstance.getLogger().debug("onActivityResumed: {}", str);
        Object[] objArr = this.sCurActPage == null && this.sLastActivityPauseTs > 0;
        Page resumePage = resumePage(str, "", currentTimeMillis, this.sLastActivity);
        this.sCurActPage = resumePage;
        resumePage.back = !this.sNewActivity.remove(Integer.valueOf(i)) ? 1 : 0;
        if (this.mTrackResumeEvent) {
            if (this.hasAnyActivityResumed) {
                if (objArr != false) {
                    long j = this.sLastActivityPauseTs;
                    if (j < currentTimeMillis - WsConstants.EXIT_DELAY_TIME && j > currentTimeMillis - 30000) {
                        this.appLogInstance.onEventV3String(RESUME_EVENT_NAME, "{\"v\":2}");
                    }
                }
                if (objArr != false && this.sLastActivityPauseTs < currentTimeMillis - 30000) {
                    this.appLogInstance.onEventV3String(RESUME_EVENT_NAME, "{\"v\":3}");
                }
            } else {
                this.appLogInstance.onEventV3String(RESUME_EVENT_NAME, "{\"v\":1}");
            }
        }
        this.hasAnyActivityResumed = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.appLogInstance.getPageHolder().setSdkPageId("");
        long currentTimeMillis = System.currentTimeMillis();
        IAppLogLogger logger = this.appLogInstance.getLogger();
        Object[] objArr = new Object[1];
        objArr[0] = activity != null ? activity.getClass().getName() : "";
        logger.debug("onActivityPaused:{}", objArr);
        Page page = this.sCurActPage;
        if (page != null) {
            this.sLastActivity = page.name;
            this.sLastActivityPauseTs = currentTimeMillis;
            pausePage(page, currentTimeMillis);
            this.sCurActPage = null;
        }
    }

    public Page resumePage(String str, String str2, long j, String str3) {
        Page page = new Page();
        if (!TextUtils.isEmpty(str2)) {
            page.name = str + ":" + str2;
        } else {
            page.name = str;
        }
        page.setTs(j);
        page.duration = -1L;
        if (str3 == null) {
            str3 = "";
        }
        page.last = str3;
        NavigatorCallback navigatorCallback = this.callback;
        if (navigatorCallback != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                navigatorCallback.onResume(page.name, jSONObject);
                if (jSONObject.length() > 0) {
                    page.flatParams = jSONObject.toString();
                }
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error("Navigator callback onResume:{} failed", th, page.name);
            }
        }
        this.appLogInstance.receive(page);
        return page;
    }

    public Page pausePage(Page page, long j) {
        Page page2 = (Page) page.m432clone();
        page2.setTs(j);
        long j2 = j - page.f80ts;
        if (j2 <= 0) {
            j2 = 1000;
        }
        page2.duration = j2;
        NavigatorCallback navigatorCallback = this.callback;
        if (navigatorCallback != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                navigatorCallback.onPause(page2.name, jSONObject);
                if (jSONObject.length() > 0) {
                    page2.flatParams = jSONObject.toString();
                }
            } catch (Throwable th) {
                this.appLogInstance.getLogger().error("Navigator callback onPause:{} failed", th, page2.name);
            }
        }
        this.appLogInstance.receive(page2);
        return page2;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.sActiveCount++;
        this.isCodeLaunch = false;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (this.sLastActivity != null) {
            int i = this.sActiveCount - 1;
            this.sActiveCount = i;
            if (i <= 0) {
                this.sLastActivity = null;
                this.sLastActivityPauseTs = 0L;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        this.sNewActivity.remove(Integer.valueOf(activity.hashCode()));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.sNewActivity.add(Integer.valueOf(activity.hashCode()));
    }
}
