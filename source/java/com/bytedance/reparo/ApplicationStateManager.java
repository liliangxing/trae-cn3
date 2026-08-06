package com.bytedance.reparo;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class ApplicationStateManager {
    private static ApplicationStateManager applicationStateManager;
    private int count = 0;
    private boolean appIsBackground = true;
    private List<ApplicationStateListener> stateListeners = new ArrayList();
    boolean firstActivityIsStarted = false;

    static /* synthetic */ int access$008(ApplicationStateManager applicationStateManager2) {
        int i = applicationStateManager2.count;
        applicationStateManager2.count = i + 1;
        return i;
    }

    static /* synthetic */ int access$010(ApplicationStateManager applicationStateManager2) {
        int i = applicationStateManager2.count;
        applicationStateManager2.count = i - 1;
        return i;
    }

    private ApplicationStateManager() {
    }

    public static ApplicationStateManager getInstance() {
        if (applicationStateManager == null) {
            synchronized (ApplicationStateManager.class) {
                if (applicationStateManager == null) {
                    applicationStateManager = new ApplicationStateManager();
                }
            }
        }
        return applicationStateManager;
    }

    public boolean isBackground() {
        return this.appIsBackground;
    }

    public boolean isFirstActivityStarted() {
        return this.firstActivityIsStarted;
    }

    public void addAppStateListener(ApplicationStateListener applicationStateListener) {
        this.stateListeners.add(applicationStateListener);
    }

    public void removeAppStateListener(ApplicationStateListener applicationStateListener) {
        this.stateListeners.remove(applicationStateListener);
    }

    public ApplicationStateManager init(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.reparo.ApplicationStateManager.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (ApplicationStateManager.this.count == 0) {
                    ApplicationStateManager.this.appIsBackground = false;
                    if (!ApplicationStateManager.this.firstActivityIsStarted) {
                        Iterator it = ApplicationStateManager.this.stateListeners.iterator();
                        while (it.hasNext()) {
                            ((ApplicationStateListener) it.next()).startFirstActivity();
                        }
                        ApplicationStateManager.this.firstActivityIsStarted = true;
                    }
                    Iterator it2 = ApplicationStateManager.this.stateListeners.iterator();
                    while (it2.hasNext()) {
                        ((ApplicationStateListener) it2.next()).intoFront();
                    }
                }
                ApplicationStateManager.access$008(ApplicationStateManager.this);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (ApplicationStateManager.this.firstActivityIsStarted) {
                    ApplicationStateManager.access$010(ApplicationStateManager.this);
                    if (ApplicationStateManager.this.count == 0) {
                        ApplicationStateManager.this.appIsBackground = true;
                        Iterator it = ApplicationStateManager.this.stateListeners.iterator();
                        while (it.hasNext()) {
                            ((ApplicationStateListener) it.next()).intoBackground();
                        }
                    }
                }
            }
        });
        return this;
    }
}
