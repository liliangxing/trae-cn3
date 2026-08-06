package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTask;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.util.NetworklibUtils;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.TTHttpCallThrottleControl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTHttpCallPriorityControl implements IHttpCallThrottleControl {
    private static String TAG = "TTHttpCallPriorityControl";
    private static volatile TTHttpCallPriorityControl mInstance;
    private final AtomicBoolean mTncModeControlEnabled = new AtomicBoolean(false);
    private final Map<String, BaseModeControl> mModeControlMap = new ConcurrentHashMap();
    private BaseModeControl mCurrentModeControl = new ModeDefault();
    private final ReadWriteLock mCurrentModeRWLock = new ReentrantReadWriteLock();

    public static TTHttpCallPriorityControl getInstance() {
        if (mInstance == null) {
            synchronized (TTHttpCallThrottleControl.class) {
                if (mInstance == null) {
                    mInstance = new TTHttpCallPriorityControl();
                }
            }
        }
        return mInstance;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum ModeType {
        DEFAULT(0),
        NORMAL_DELAY(1),
        RUNTIME_DELAY(2),
        PRIORITY(3),
        NOT_REACHED(4);

        private final int value;

        ModeType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static ModeType fromValue(int i) {
            for (ModeType modeType : values()) {
                if (modeType.getValue() == i) {
                    return modeType;
                }
            }
            throw new IllegalArgumentException("Invalid value: " + i);
        }
    }

    public void startAppStateFromTNC(String str) {
        startMode(this.mModeControlMap.get(str));
    }

    public void startAppStateFromCustom(ModePriorityManagement modePriorityManagement) {
        startMode(modePriorityManagement);
    }

    public void resetToDefaultState() {
        startMode(null);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static abstract class BaseModeControl implements IHttpCallThrottleControl {
        protected final RequestDelayController mRequestDelayController = new RequestDelayController();
        protected String mStateName = "";
        private int mStateId = -1;
        private Date mLifeTimeBegin = null;
        private Date mLifeTimeEnd = null;
        private boolean mLifeIsValid = true;
        private int mDelayDisableTimeMs = BytePatchException.ErrorCode.paramsError;
        private NetworkAsyncTask mClearSelfTask = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean initWithTncConfig(JSONObject jSONObject) {
            String optString = jSONObject.optString("state_name", "");
            this.mStateName = optString;
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            this.mStateId = jSONObject.optInt("state", -1);
            int i = BytePatchException.ErrorCode.paramsError;
            int optInt = jSONObject.optInt("delay_disable_time_ms", BytePatchException.ErrorCode.paramsError);
            this.mDelayDisableTimeMs = optInt;
            if (optInt > 0) {
                i = optInt;
            }
            this.mDelayDisableTimeMs = i;
            initLifecycle(jSONObject);
            return true;
        }

        public void modeStart() {
            this.mClearSelfTask = new NetworkAsyncTask(this.mDelayDisableTimeMs, 0L) { // from class: com.bytedance.ttnet.priority.TTHttpCallPriorityControl.BaseModeControl.1
                public void run() {
                    TTHttpCallPriorityControl.getInstance().resetToDefaultState();
                }
            };
            NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(this.mClearSelfTask);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void modeStop() {
            if (this.mClearSelfTask != null) {
                NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).removeTask(this.mClearSelfTask);
            }
        }

        @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
        public void notifyRequestCompleted(Request request) {
            this.mRequestDelayController.notifyRequestCompleted(request);
        }

        ModeType modeType() {
            return ModeType.NOT_REACHED;
        }

        public void setStateName(String str) {
            this.mStateName = str;
            this.mRequestDelayController.setOwnerStateName(str);
        }

        public String stateName() {
            return this.mStateName;
        }

        public void setDelayDisableTimeMs(int i) {
            this.mDelayDisableTimeMs = i;
        }

        private void initLifecycle(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            String optString = jSONObject.optString("lifecycle");
            if ("".equals(optString)) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (!NetworklibUtils.splitIso8601TimeSegmentToList(optString, arrayList) || arrayList.size() != 2) {
                if (Logger.debug()) {
                    Logger.d(TTHttpCallPriorityControl.TAG, "initLifecycle, parse lifecycle failed");
                }
                this.mLifeIsValid = false;
            } else {
                this.mLifeIsValid = true;
                this.mLifeTimeBegin = (Date) arrayList.get(0);
                this.mLifeTimeEnd = (Date) arrayList.get(1);
                if (Logger.debug()) {
                    Logger.d(TTHttpCallPriorityControl.TAG, "initLifecycle, stateName: " + this.mStateName + ", beginTime: " + this.mLifeTimeBegin.toString() + ", endTime: " + this.mLifeTimeEnd.toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isInLifecycle() {
            if (Logger.debug()) {
                Logger.d(TTHttpCallPriorityControl.TAG, "isInLifecycle, stateName: " + this.mStateName + ", beginTime: " + this.mLifeTimeBegin + ", endTime: " + this.mLifeTimeEnd);
            }
            if (!this.mLifeIsValid) {
                return false;
            }
            if (this.mLifeTimeBegin == null || this.mLifeTimeEnd == null) {
                return true;
            }
            Date date = new Date();
            return date.after(this.mLifeTimeBegin) && date.before(this.mLifeTimeEnd);
        }
    }

    private void startMode(BaseModeControl baseModeControl) {
        if (baseModeControl == null || baseModeControl.isInLifecycle()) {
            this.mCurrentModeRWLock.writeLock().lock();
            try {
                this.mCurrentModeControl.modeStop();
                if (baseModeControl == null) {
                    baseModeControl = new ModeDefault();
                }
                this.mCurrentModeControl = baseModeControl;
                baseModeControl.modeStart();
                if (Logger.debug()) {
                    Logger.d(TAG, "set mode " + this.mCurrentModeControl.modeType());
                }
            } finally {
                this.mCurrentModeRWLock.writeLock().unlock();
            }
        }
    }

    public ModeType getCurrentModeType() {
        this.mCurrentModeRWLock.writeLock().lock();
        try {
            return this.mCurrentModeControl.modeType();
        } finally {
            this.mCurrentModeRWLock.writeLock().unlock();
        }
    }

    public BaseModeControl getCurrentMode() {
        this.mCurrentModeRWLock.writeLock().lock();
        try {
            return this.mCurrentModeControl;
        } finally {
            this.mCurrentModeRWLock.writeLock().unlock();
        }
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void maybeDropRequestOrBlockingDelay(Request request) throws Exception {
        if (Logger.debug()) {
            Logger.d(TAG, "current mode is " + getCurrentModeType());
        }
        if ((this.mTncModeControlEnabled.get() || this.mCurrentModeControl.modeType() == ModeType.DEFAULT) && checkRequest(request) && this.mCurrentModeControl.isInLifecycle()) {
            this.mCurrentModeControl.maybeDropRequestOrBlockingDelay(request);
        }
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public boolean maybeDropRequestOrAsyncDelay(Request request, Executor executor, Runnable runnable) throws Exception {
        if (Logger.debug()) {
            Logger.d(TAG, "current mode is " + getCurrentModeType());
        }
        if ((this.mTncModeControlEnabled.get() || this.mCurrentModeControl.modeType() == ModeType.DEFAULT) && checkRequest(request) && this.mCurrentModeControl.isInLifecycle()) {
            return this.mCurrentModeControl.maybeDropRequestOrAsyncDelay(request, executor, runnable);
        }
        return false;
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public void notifyRequestCompleted(Request request) {
        if (!this.mTncModeControlEnabled.get() || request == null) {
            return;
        }
        this.mCurrentModeControl.notifyRequestCompleted(request);
    }

    @Override // com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl
    public Request setOriginalRequestProperties(Request request) {
        return (!this.mTncModeControlEnabled.get() || request == null) ? request : this.mCurrentModeControl.setOriginalRequestProperties(request);
    }

    public void onServerConfigChangedFromTNCHandler(JSONObject jSONObject) {
        BaseModeControl modePriorityManagement;
        this.mTncModeControlEnabled.set(false);
        this.mModeControlMap.clear();
        JSONArray optJSONArray = jSONObject.optJSONArray("tt_req_delay_config");
        boolean z = jSONObject.optInt("state_delay_enabled") > 0;
        boolean z2 = TTNetInit.getStateDelayNewStrategyEnabled() && (jSONObject.optInt("state_new_strategy_enabled", 1) > 0);
        if (!z || optJSONArray == null || !z2) {
            resetToDefaultState();
            return;
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("state_name", "");
            if (optJSONObject != null && !TextUtils.isEmpty(optString)) {
                ModeType fromValue = ModeType.fromValue(optJSONObject.optInt("type", ModeType.NOT_REACHED.getValue()));
                if (fromValue == ModeType.NORMAL_DELAY) {
                    modePriorityManagement = new ModeNormalDelay();
                } else if (fromValue == ModeType.RUNTIME_DELAY) {
                    modePriorityManagement = new ModeRuntimeDelay();
                } else {
                    modePriorityManagement = fromValue == ModeType.PRIORITY ? new ModePriorityManagement() : null;
                }
                if (modePriorityManagement != null && modePriorityManagement.initWithTncConfig(optJSONObject)) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "mode name is " + optString);
                    }
                    concurrentHashMap.put(optString, modePriorityManagement);
                }
            }
        }
        if (Logger.debug()) {
            Logger.d(TAG, "mode size is " + concurrentHashMap.size());
        }
        this.mModeControlMap.putAll(concurrentHashMap);
        this.mTncModeControlEnabled.set(true);
    }

    public static Integer getMapValueIfMatch(Map<String, Integer> map, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : map.keySet()) {
            if (str.startsWith(str2)) {
                return map.get(str2);
            }
        }
        return null;
    }

    public static boolean isMatch(Set<String> set, String str) {
        if (TextUtils.isEmpty(str) || set == null) {
            return false;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static Set<String> getSetFromJSONArray(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return copyOnWriteArraySet;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                copyOnWriteArraySet.add(optString);
            }
        }
        return copyOnWriteArraySet;
    }

    private boolean checkRequest(Request request) {
        return (request == null || TextUtils.isEmpty(request.getPath())) ? false : true;
    }
}
