package com.bytedance.push.event.sync.adapter;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.common.device.DeviceKeyReceiver;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.HostUserExitsSignalInfo;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.event.sync.IUserExitsSignalInfoProvider;
import com.bytedance.push.event.sync.UserExitsReason;
import com.bytedance.push.settings.signal.sync.SignalReportConfig;
import com.bytedance.push.utils.Logger;
import java.lang.ref.WeakReference;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UserExitsSignalReporter extends AbsSignalReporterAdapter implements Application.ActivityLifecycleCallbacks, Observer {
    private WeakReference<Activity> mCurActivity;
    private boolean mIsInBackGround;
    private UserExitsReason mUserExitsReason;
    private final String TAG = "UserExitsSignalReporter";
    private final String METHOD_DISPATCH_KEY_EVENT = "dispatchKeyEvent";

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public String getSignalName() {
        return ISignalReportConstants.SIGNAL_NAME_USER_EXITS;
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
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.bytedance.push.event.sync.adapter.AbsSignalReporterAdapter
    public void startSignalReport(String str, SignalReportConfig signalReportConfig) {
        super.startSignalReport(str, signalReportConfig);
        Activity topActivity = ActivityLifecycleObserver.getIns().getTopActivity();
        if (topActivity != null) {
            proxyWindowCallback(topActivity);
        }
        this.mIsInBackGround = ActivityLifecycleObserver.getIns().isBackGround();
        ActivityLifecycleObserver.getIns().addObserver(this);
        ActivityLifecycleObserver.getIns().addActivityLifeCycleListener(this);
        DeviceKeyReceiver.registerMultiTaskListener(new DeviceKeyReceiver.IMultiTaskListener() { // from class: com.bytedance.push.event.sync.adapter.UserExitsSignalReporter.1
            public void enterMultiTask() {
                Logger.m268d("UserExitsSignalReporter", "[enterMultiTask]");
                UserExitsSignalReporter.this.mUserExitsReason = UserExitsReason.HOME;
            }

            public void onPressHomeKey() {
                Logger.m268d("UserExitsSignalReporter", "[onPressHomeKey]");
                UserExitsSignalReporter.this.mUserExitsReason = UserExitsReason.HOME;
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Logger.m268d("UserExitsSignalReporter", "[onActivityCreated]activity:" + activity);
        proxyWindowCallback(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Logger.m268d("UserExitsSignalReporter", "[onActivityStarted]activity:" + activity);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (!this.mIsInBackGround && booleanValue) {
            Logger.m268d("UserExitsSignalReporter", "[update]app from foreground to background,mLastOperateType:" + this.mUserExitsReason);
            if (this.mUserExitsReason == null) {
                Logger.m271e("UserExitsSignalReporter", "[update]invalid app status change because mUserExitsReason is null");
                return;
            }
            IUserExitsSignalInfoProvider iUserExitsValidityChecker = PushSupporter.get().getSignalReportService().getIUserExitsValidityChecker();
            if (iUserExitsValidityChecker == null) {
                Logger.m271e("UserExitsSignalReporter", "[update]invalid app status change because userExitsValidityChecker is null");
                return;
            }
            WeakReference<Activity> weakReference = this.mCurActivity;
            HostUserExitsSignalInfo hostUserExitsSignalInfo = iUserExitsValidityChecker.getHostUserExitsSignalInfo(weakReference != null ? weakReference.get() : null, this.mUserExitsReason);
            if (hostUserExitsSignalInfo == null) {
                Logger.m271e("UserExitsSignalReporter", "[update]invalid app status change because userExitsValidityInfo is null");
                return;
            }
            if (!hostUserExitsSignalInfo.mIsValid) {
                Logger.m271e("UserExitsSignalReporter", "[update]invalid app status change because userExitsValidityInfo#isValid is false,last_page:" + hostUserExitsSignalInfo.mLastPage);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            add(jSONObject, ISignalReportConstants.KEY_REASON, this.mUserExitsReason.exitsReasonStr);
            if (!TextUtils.isEmpty(hostUserExitsSignalInfo.mLastPage)) {
                add(jSONObject, ISignalReportConstants.KEY_LAST_PAGE, hostUserExitsSignalInfo.mLastPage);
            } else {
                Logger.m278w("UserExitsSignalReporter", "[update]userExitsValidityInfo#extra is null,can't report last_page");
            }
            PushSupporter.get().getSignalReportService().getISignalReporter().reportSignal(this.mSignalReportConfig, getSignalName(), this.mTriggerScene, jSONObject);
        }
        this.mIsInBackGround = booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class WindowCallback implements Window.Callback {
        private Activity mActivity;
        private Window.Callback mBase;

        public WindowCallback(Window.Callback callback, Activity activity) {
            this.mBase = callback;
            this.mActivity = activity;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.dispatchKeyEvent(keyEvent);
            }
            UserExitsSignalReporter.this.findDispatchKeyEvent(this.mActivity, keyEvent);
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.dispatchKeyShortcutEvent(keyEvent);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.dispatchTouchEvent(motionEvent);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.dispatchTrackballEvent(motionEvent);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.dispatchGenericMotionEvent(motionEvent);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public View onCreatePanelView(int i) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.onCreatePanelView(i);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.onPreparePanel(i, view, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.onMenuOpened(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean onMenuItemSelected(int i, MenuItem menuItem) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.onMenuItemSelected(i, menuItem);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.onWindowAttributesChanged(layoutParams);
            }
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.onContentChanged();
            }
        }

        @Override // android.view.Window.Callback
        public void onWindowFocusChanged(boolean z) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.onWindowFocusChanged(z);
            }
        }

        @Override // android.view.Window.Callback
        public void onAttachedToWindow() {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.onAttachedToWindow();
            }
        }

        @Override // android.view.Window.Callback
        public void onDetachedFromWindow() {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.onDetachedFromWindow();
            }
        }

        @Override // android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.onPanelClosed(i, menu);
            }
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested() {
            Window.Callback callback = this.mBase;
            if (callback == null) {
                return false;
            }
            callback.onSearchRequested();
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested(SearchEvent searchEvent) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                return callback.onSearchRequested(searchEvent);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            Window.Callback callback2 = this.mBase;
            if (callback2 != null) {
                return callback2.onWindowStartingActionMode(callback);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            Window.Callback callback2 = this.mBase;
            if (callback2 != null) {
                return callback2.onWindowStartingActionMode(callback, i);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onActionModeStarted(ActionMode actionMode) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.onActionModeStarted(actionMode);
            }
        }

        @Override // android.view.Window.Callback
        public void onActionModeFinished(ActionMode actionMode) {
            Window.Callback callback = this.mBase;
            if (callback != null) {
                callback.onActionModeFinished(actionMode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findDispatchKeyEvent(Activity activity, KeyEvent keyEvent) {
        Logger.m268d("UserExitsSignalReporter", "[findDispatchKeyEvent]event：" + keyEvent);
        if (keyEvent.getKeyCode() == 3) {
            Logger.m268d("UserExitsSignalReporter", "[findDispatchKeyEvent]find home press");
            this.mCurActivity = new WeakReference<>(activity);
            this.mUserExitsReason = UserExitsReason.HOME;
        } else if (keyEvent.getKeyCode() == 4) {
            Logger.m268d("UserExitsSignalReporter", "[findDispatchKeyEvent]find back press");
            this.mCurActivity = new WeakReference<>(activity);
            this.mUserExitsReason = UserExitsReason.BACK;
        }
    }

    private void proxyWindowCallback(Activity activity) {
        Logger.m268d("UserExitsSignalReporter", "[proxyWindowCallback]activity:" + activity + " window:" + activity.getWindow());
        if (activity.getWindow() != null) {
            Window.Callback callback = activity.getWindow().getCallback();
            Logger.m268d("UserExitsSignalReporter", "[proxyWindowCallback]callback:" + callback);
            activity.getWindow().setCallback(new WindowCallback(callback, activity));
        }
    }
}
