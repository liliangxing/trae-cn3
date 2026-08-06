package com.bytedance.push.appstatus;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.process.cross.ICrossProcessAbilityInitListener;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.Singleton;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushCommonSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AppStatusObserverForChildProcess extends Observable implements IMethodObserver {
    public static final String CHANGE_TYPE_APP_ENTRANCE = "app_entrance";
    public static final String CHANGE_TYPE_APP_EXIT = "app_exit";
    public static final String GET_CUR_APP_STATUS = "get_cur_app_status";
    private static boolean mInitEd;
    private final String TAG;
    private long mBackGroundSystemTime;
    private long mBackGroundSystemTimeLockTime;
    private ProcessEnum mCurProcess;
    private long mFirstToForeGroundTimeStamp;
    private boolean mHasForeGround;
    private long mLastForeGroundTimeStamp;
    private List<ProcessEnum> mProcessEnums;
    private static final Singleton<AppStatusObserverForChildProcess> INST = new Singleton<AppStatusObserverForChildProcess>() { // from class: com.bytedance.push.appstatus.AppStatusObserverForChildProcess.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.push.utils.Singleton
        public AppStatusObserverForChildProcess create(Object... objArr) {
            return new AppStatusObserverForChildProcess();
        }
    };
    private static boolean mIsInBackGround = true;

    public String getMethodName() {
        return "onAppStatusChanged";
    }

    private AppStatusObserverForChildProcess() {
        this.TAG = "AppStatusObserverForChildProcess";
        this.mBackGroundSystemTimeLockTime = 0L;
        this.mBackGroundSystemTime = 0L;
        Logger.m274i("AppStatusObserverForChildProcess", "on AppStatusObserverForChildProcess init");
        this.mCurProcess = ToolUtils.getCurProcess(AppProvider.getApp());
        ArrayList arrayList = new ArrayList();
        this.mProcessEnums = arrayList;
        arrayList.add(ProcessEnum.PUSH);
        this.mProcessEnums.add(ProcessEnum.SMP);
        if (this.mProcessEnums.contains(this.mCurProcess)) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.appstatus.AppStatusObserverForChildProcess.2
                @Override // java.lang.Runnable
                public void run() {
                    CrossProcessHelper.getInstance().addTargetProcessAbilityInitListener(ProcessEnum.MAIN, new ICrossProcessAbilityInitListener() { // from class: com.bytedance.push.appstatus.AppStatusObserverForChildProcess.2.1
                        public void initFinished() {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(AppStatusObserverForChildProcess.GET_CUR_APP_STATUS);
                            String callMethod = CrossProcessHelper.getInstance().callMethod(ProcessEnum.MAIN, AppStatusObserverForChildProcess.this.getMethodName(), arrayList2);
                            Logger.m274i("AppStatusObserverForChildProcess", "success connection with main process,cur is in background:" + callMethod + " mIsInBackGround:" + AppStatusObserverForChildProcess.mIsInBackGround);
                            if (TextUtils.isEmpty(callMethod) || Boolean.parseBoolean(callMethod) || !AppStatusObserverForChildProcess.mIsInBackGround) {
                                return;
                            }
                            AppStatusObserverForChildProcess.this.onEnterForeground();
                        }
                    });
                }
            });
        }
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mEnableLazy) {
            return;
        }
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.appstatus.AppStatusObserverForChildProcess.3
            @Override // java.lang.Runnable
            public void run() {
                CrossProcessHelper.getInstance().registerMethodObserver(AppStatusObserverForChildProcess.this);
            }
        });
    }

    public static AppStatusObserverForChildProcess getIns() {
        return INST.get(new Object[0]);
    }

    public void onEnterBackground() {
        Logger.m274i("AppStatusObserverForChildProcess", "onEnterBackground on " + this.mCurProcess + " process");
        mInitEd = true;
        mIsInBackGround = true;
        this.mBackGroundSystemTimeLockTime = SystemClock.uptimeMillis();
        this.mBackGroundSystemTime = System.currentTimeMillis();
        tryNotifyChildProcess(CHANGE_TYPE_APP_EXIT);
        setChanged();
        notifyObservers(Boolean.valueOf(mIsInBackGround));
    }

    public void onEnterForeground() {
        Logger.m274i("AppStatusObserverForChildProcess", "onEnterForeground on " + this.mCurProcess + " process,mIsInBackGround:" + mIsInBackGround + " countObservers:" + countObservers());
        if (mIsInBackGround) {
            if (this.mFirstToForeGroundTimeStamp == 0) {
                this.mFirstToForeGroundTimeStamp = System.currentTimeMillis();
            }
            mInitEd = true;
            if (mIsInBackGround) {
                this.mLastForeGroundTimeStamp = System.currentTimeMillis();
            }
            mIsInBackGround = false;
            this.mHasForeGround = true;
            tryNotifyChildProcess(CHANGE_TYPE_APP_ENTRANCE);
            setChanged();
            notifyObservers(Boolean.valueOf(mIsInBackGround));
        }
    }

    public long getLastForeGroundTimeStamp() {
        return this.mLastForeGroundTimeStamp;
    }

    public boolean hasForeGround() {
        return this.mHasForeGround;
    }

    public long getFirstToForeGroundTimeStamp() {
        return this.mFirstToForeGroundTimeStamp;
    }

    private void tryNotifyChildProcess(final String str) {
        if (this.mCurProcess != ProcessEnum.MAIN) {
            return;
        }
        TTExecutors.getCPUThreadPool().submit(new Runnable() { // from class: com.bytedance.push.appstatus.AppStatusObserverForChildProcess.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                Iterator it = AppStatusObserverForChildProcess.this.mProcessEnums.iterator();
                while (it.hasNext()) {
                    CrossProcessHelper.getInstance().callMethod((ProcessEnum) it.next(), "onAppStatusChanged", arrayList);
                }
            }
        });
    }

    public static boolean sIsInBackGround(boolean z) {
        if (z) {
            return sIsInBackGround();
        }
        return mIsInBackGround;
    }

    public static boolean sIsInBackGround() {
        if (!mInitEd) {
            return !PushCommonSetting.getInstance().isAppForeground();
        }
        return mIsInBackGround;
    }

    public boolean isInBackGround() {
        return sIsInBackGround();
    }

    public long getBackGroundSystemTimeLockTime() {
        return this.mBackGroundSystemTimeLockTime;
    }

    public long getBackGroundSystemTime() {
        return this.mBackGroundSystemTime;
    }

    public String onMethodCall(ProcessEnum processEnum, List list) {
        if (list == null) {
            return null;
        }
        String str = (String) list.get(0);
        if (this.mCurProcess != ProcessEnum.MAIN) {
            if (TextUtils.equals(CHANGE_TYPE_APP_ENTRANCE, str)) {
                onEnterForeground();
                return null;
            }
            if (!TextUtils.equals(CHANGE_TYPE_APP_EXIT, str)) {
                return null;
            }
            onEnterBackground();
            return null;
        }
        if (TextUtils.equals(GET_CUR_APP_STATUS, str)) {
            return String.valueOf(sIsInBackGround());
        }
        return null;
    }
}
