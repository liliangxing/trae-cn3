package com.bytedance.vcloud.strategy;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class StrategyCenter {
    public static final int ALGO_CONFIG_SMART_SERVICE_PACKAGE_URL = 31021;
    public static final int ALGO_CONFIG_STRING_BANDWIDTH = 31007;
    public static final int ALGO_CONFIG_STRING_COMMON = 31001;
    public static final int ALGO_CONFIG_STRING_DASP = 31026;
    public static final int ALGO_CONFIG_STRING_DOWNLOAD_IO = 31023;
    public static final int ALGO_CONFIG_STRING_DYNAMIC = 31011;
    public static final int ALGO_CONFIG_STRING_DYNAMIC_DOWNLOAD_IO = 31024;
    public static final int ALGO_CONFIG_STRING_DYNAMIC_PLAYLOAD = 31015;
    public static final int ALGO_CONFIG_STRING_DYNAMIC_PLAYRANGE = 31016;
    public static final int ALGO_CONFIG_STRING_DYNAMIC_PLAY_BUFFER = 31019;
    public static final int ALGO_CONFIG_STRING_DYNAMIC_PRELOAD = 31014;
    public static final int ALGO_CONFIG_STRING_DYNAMIC_SELECT_BITRATE = 31017;
    public static final int ALGO_CONFIG_STRING_DYNAMIC_TIMEINFO = 31013;
    public static final int ALGO_CONFIG_STRING_IO_DEMAND = 31022;
    public static final int ALGO_CONFIG_STRING_MODULE_CONFIG = 31008;
    public static final int ALGO_CONFIG_STRING_OPTION = 31012;
    public static final int ALGO_CONFIG_STRING_PLAY_BUFFER = 31018;
    public static final int ALGO_CONFIG_STRING_PLAY_LOAD = 31004;
    public static final int ALGO_CONFIG_STRING_PLAY_RANGE = 31005;
    public static final int ALGO_CONFIG_STRING_PRELOAD = 31010;
    public static final int ALGO_CONFIG_STRING_PRELOAD_BACKGROUND = 31020;
    public static final int ALGO_CONFIG_STRING_PRELOAD_TIMELINESS = 31003;
    public static final int ALGO_CONFIG_STRING_SELECT_BITRATE = 31006;
    public static final int ALGO_CONFIG_STRING_SELECT_DYNAMIC_CURVE = 31025;
    public static final int ALGO_CONFIG_STRING_SMART_PRELOAD = 31002;

    @Deprecated
    public static final int ALGO_CONFIG_STRING_SMART_RANGE_REQUEST = 31009;
    public static final int ALGO_CONFIG_STRING_VOLUME_BALANCE = 31028;
    public static final int ALGO_STRING_BEGIN = 59000;
    public static final int ALGO_STRING_GET_VOLUME_BALANCE = 59015;
    public static final int ALGO_STRING_IO_DEMAND_CHECK_CONFIG = 59008;
    public static final int ALGO_STRING_SELECT_PORTRAIT_NEED = 59004;
    public static final int APP_BLOCK_TYPE = 1011;
    public static final int APP_CONFIG_CACHE_DIR = 31209;
    public static final int APP_CONFIG_SESSION_ID = 31211;

    @Deprecated
    public static final int APP_DASP_FEATURE = 31223;
    public static final int APP_HAR_MODE = 1009;
    public static final int APP_MEDIA_LIST_LOAD_MORE = 31220;
    public static final int APP_MEDIA_LIST_UPDATE = 31221;
    public static final int APP_PAUSE_ALL_PRELOAD = 31215;
    public static final int APP_PAUSE_SCENE_PRELOAD = 31217;
    public static final int APP_PRELOAD_CANCEL_ALL_EVENT = 31205;
    public static final int APP_REFRESH_MEDIA_LIST = 31219;
    public static final int APP_RESUME_ALL_PRELOAD = 31216;
    public static final int APP_RESUME_SCENE_PRELOAD = 31218;
    public static final int APP_SOLARIA_PORTRAIT = 31222;
    public static final int APP_STATE = 1001;
    public static final int APP_STATE_BACKGROUND = 2;
    public static final int APP_STATE_FOREGROUND = 1;
    public static final int APP_UPDATE_TRACE_HOST = 31207;
    public static final int BANDWIDTH_DEFAULT_INITIAL_SPEED = 1004;
    public static final int BANDWIDTH_QUEUE_SIZE = 1002;
    public static final int BIZ_AD_MODULE_VALUE = 31228;
    public static final int BIZ_CANCEL_ALL_ORIGIN_PRELOAD_TASKS = 31231;
    public static final int BIZ_CANCEL_ORIGIN_PRELOAD_TASK_BY_KEY = 31229;
    public static final int BIZ_CANCEL_ORIGIN_PRELOAD_TASK_BY_VIDEO_ID = 31230;
    public static final int BIZ_NEXT_MEDIA_IS_LIVE_STREAM = 31234;
    public static final int CLEAR_DATA = 6;
    public static final int CONFIG_PEAK_SETTING = 31206;
    public static final int DASP_ASYNC_ENGINE_PREPARE = 31232;
    public static final int DASP_SIGNAL_DISPOSABLE = 31227;
    public static final int DASP_SIGNAL_PLAY = 31224;
    public static final int DASP_SIGNAL_REALTIME = 31226;
    public static final int DASP_SIGNAL_SAMPLE = 31223;
    public static final int DASP_SIGNAL_SESSION = 31225;
    public static final int DATA_SERIALIZED_KEY_VALUE = 31212;
    public static final int DATA_SERIALIZED_UPDATE = 31210;
    public static final int DEVICE_BATTERY_TEMPERATURE = 1017;
    public static final int DEVICE_CASE_TEMPERATURE = 1019;
    public static final int DEVICE_IS_CHARGING = 1015;
    public static final int DEVICE_POWER_MODE = 1012;
    public static final int DEVICE_POWER_PERCENT = 1016;
    public static final int DEVICE_THERMAL_MODE = 1013;
    public static final int DOWNLOAD_IO_STATE_DOWNLOADING = 1;
    public static final int DOWNLOAD_IO_STATE_IDLE = 2;
    public static final int DOWNLOAD_IO_STATE_UNKNOWN = 0;
    public static final int DOWNLOAD_STATUS = 1207;
    public static final int ENABLE_SMART_SERVICE = 808;
    public static final int ENGINE_NET_SCORE = 31213;
    public static final int EVENT_ADAPTIVE_RANGE_BUFFER = 2009;
    public static final int EVENT_ADAPTIVE_RANGE_ENABLED = 2008;
    public static final int EVENT_FIRST_FRAME_LABEL = 2007;
    public static final int EVENT_LOAD_CONTROL_SLIDING_WINDOW = 2017;
    public static final int EVENT_LOAD_CONTROL_VERSION = 2016;
    public static final int EVENT_MODULE_ACTIVATED = 2014;
    public static final int EVENT_NETWORK_STALL_LIST = 2020;
    public static final int EVENT_NORIFY_DOWNLOAD_STATE = 2500;
    public static final int EVENT_NOTIFY_DASP_OUTPUT = 2503;
    public static final int EVENT_NOTIFY_DASP_SIMP_CTL = 2502;
    public static final int EVENT_NOTIFY_IO_DEMAND_STATE_LABEL = 2501;
    public static final int EVENT_NOTIFY_IO_DEMAND_STATE_MULTI = 2504;
    public static final int EVENT_NOTIFY_VOD_EXIT_HINT = 2506;
    public static final int EVENT_NOTIFY_WEAK_NETWORK_STATE = 2505;
    public static final int EVENT_PLAYER_RANGE_DETERMINED = 2013;
    public static final int EVENT_PLAY_BUFFER_DIFF_RESULT = 2011;
    public static final int EVENT_PLAY_RELATED_PRELOAD_FINISHED = 2012;
    public static final int EVENT_PLAY_TASK_OPERATE = 2000;
    public static final int EVENT_PRELOAD_DECISION_INFO = 2015;
    public static final int EVENT_PRELOAD_DECISION_INFO2 = 2021;
    public static final int EVENT_PRELOAD_PERSONALIZED_OPTION = 2004;
    public static final int EVENT_PRELOAD_SWITCH = 2001;
    public static final int EVENT_REMAINING_BUFFER_DURATION_AT_STOP = 2010;
    public static final int EVENT_RE_BUFFER_DURATION_INITIAL = 2002;
    public static final int EVENT_SCENE_SWITCH = 2018;
    public static final int EVENT_SERIALIZED_DATA = 2019;
    public static final int EVENT_STALL_LABEL = 2006;
    public static final int EVENT_STARTUP_DURATION = 2003;
    public static final int EVENT_WATCH_DURATION_LABEL = 2005;
    public static final int GET_MEDIA_LIST_BY_SCENE_ID = 31302;
    public static final int GET_NETWORK_SPEED = 20401;
    public static final int GET_PRELOAD_STRATEGY_LOG_INFO = 31301;
    public static final int GLOBAL_OPTION_END = 60000;
    public static final int GLOBAL_OPTION_START = 50000;
    public static final String IMAGE_RESULT_KEY_SHARPEN = "sharpen";
    public static final String IMAGE_RESULT_KEY_SR = "super_resolution";
    public static final int IO_DEMAND_LEVEL = 1208;
    public static final int IO_DEMAND_LEVEL_DEFAULT = -1;
    public static final int IO_DEMAND_LEVEL_HIGH = 2;
    public static final int IO_DEMAND_LEVEL_LOW = 0;
    public static final int IO_DEMAND_LEVEL_MEDIUM = 1;
    public static final int IO_DEMAND_LEVEL_TYPE_DEFAULT = -1;
    public static final int IO_DEMAND_LEVEL_TYPE_LABEL = -2;
    public static final int IO_DEMAND_LEVEL_TYPE_MULTI = -3;
    public static final int LANDSCAPE_PLAY_TYPE = 1007;
    public static final int LIVE_MEDIA_OPERATE_EVENT = 1014;
    public static final int LOAD_DATA = 1;
    public static final int LOAD_KEY_VALUE_DATA = 5;
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 4;
    public static final int LOG_FATAL = 5;
    public static final int LOG_INFO = 2;
    public static final int LOG_LEVEL = 10000;
    public static final int LOG_TYPE_ERROR = 3;
    public static final int LOG_TYPE_EVENT = 1;
    public static final int LOG_TYPE_PLAY = 0;
    public static final int LOG_TYPE_PRIORITY_TASK = 4;
    public static final int LOG_TYPE_STRATEGY = 2;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 3;
    public static final int MODULE_SWITCH_ABR = 807;
    public static final int MODULE_SWITCH_BANDWIDTH = 803;
    public static final int MODULE_SWITCH_PLAY_LOAD = 806;
    public static final int MODULE_SWITCH_PRELOAD = 805;
    public static final int MODULE_SWITCH_SELECT_BITRATE = 804;
    public static final int NETWORK_TYPE_APP = 1008;
    public static final int NET_SIGNAL_STRENGTH_UPDATE = 1211;
    public static final int NET_STATE_CHANGED = 1202;
    public static final int NetStateUnReachable = 0;
    public static final int NetStateUnknown = -1;
    public static final int NetStateWWAN = 10;
    public static final int NetStateWifi = 20;
    public static final int ONE_PLAY_CONFIG_PLAY_BUFFER = 56008;
    public static final int ONE_PLAY_CONFIG_PLAY_LOAD = 56006;
    public static final int ONE_PLAY_CONFIG_PLAY_RANGE = 56007;
    public static final int ONE_PLAY_OPEN_SUPER_RESOLUTION = 50030;
    public static final int OPTION_ALL_PRELOAD_FINISH_MESSAGE = 50007;
    public static final int OPTION_AUTO_RESUME_TASK_WHEN_PLAY = 50009;
    public static final int OPTION_CACHE_SELECTED_REP = 50020;
    public static final int OPTION_CACHE_TIMESTAMP = 50003;
    public static final int OPTION_CHECK_EXITED_LC = 50004;
    public static final int OPTION_CHECK_ORIGIN_LC = 50005;
    public static final int OPTION_ENABLE_IO_DECISION = 50008;
    public static final int OPTION_ENABLE_USE_CACHE_FLAG = 50011;
    public static final int OPTION_JAVA_KEY_BEGIN = 58000;
    public static final int OPTION_JAVA_KEY_END = 58999;
    public static final int OPTION_JAVA_SPEED_INFO_UPDATE = 58001;
    public static final int OPTION_LIMIT_REQ_LOG_COUNT = 50024;
    public static final int OPTION_PAUSE_IO_WHEN_REQ_END = 50010;
    public static final int OPTION_PLAYER_CONTEXT_INFO = 50012;
    public static final int OPTION_PRELOAD_MP3_SUPPORT = 50019;
    public static final int OPTION_SELECT_BITRATE_MODE = 50006;
    public static final int OPTION_STOP_BACKGROUND = 50001;
    public static final int OPTION_STOP_TASK_END_PLAY = 50002;
    public static final int OPTION_USE_ENGINE_NETWORK_TIMEOUT = 50080;
    public static final int PLAY_INTERACTION_BLOCK_DURATION_NON_PRELOADED = 802;
    public static final int PLAY_INTERACTION_BLOCK_DURATION_PRELOADED = 801;
    public static final int PLAY_TASK_EST_PLAYTIME = 103;
    public static final int PLAY_TASK_FIRST_BLOCK_DECISION_TIME = 101;
    public static final int PLAY_TASK_FIRST_BLOCK_EXEC_TIME = 102;
    public static final int PLAY_TASK_PAUSE = 1;
    public static final int PLAY_TASK_RANGE = 4;
    public static final int PLAY_TASK_RANGE_DURATION = 5;
    public static final int PLAY_TASK_RESUME = 2;
    public static final int PLAY_TASK_SAFE_FACTOR = 7;
    public static final int PLAY_TASK_SEEK_LABEL = 100;
    public static final int PLAY_TASK_SMART_LEVEL = 104;
    public static final int PLAY_TASK_STOP = 3;
    public static final int PLAY_TASK_TARGET_BUFFER = 6;
    public static final int PORTRAIT_CHANGED = 1003;
    public static final int PRELOAD_SMART_CONFIG_JSON_UPDATE = 31203;
    public static final int PRELOAD_SMART_RET_LABEL = 31201;
    public static final int PRELOAD_TIMELINESS_RET_LABEL = 31202;
    public static final int REMOVE_DATA = 3;
    public static final int RUNNING_PRELOAD_TASK = 1206;
    public static final int SAVE_DATA = 2;
    public static final int SAVE_KEY_VALUE_DATA = 4;
    public static final int SCENE_PLAY_SPEED_UPDATE = 31235;
    public static final int SELECT_BITRATE_TYPE_PLAY = 1;
    public static final int SELECT_BITRATE_TYPE_PRELOAD = 2;

    @Deprecated
    public static final int SMART_RANGE_REQUEST_LABEL = 31204;
    private static final String TAG = "VCStrategy";
    public static final int TRAFFIC_EXCITATION = 1005;
    public static final int TTNETWORK_LEVEL = 1010;
    public static final int USER_CHOOSE_QUALITY_MODE = 1006;
    public static final int VOD_SETTINGS_PORTRAIT = 31214;
    public static final int WEAK_NETWORK_STATE = 1212;
    private IStrategyEventListener mListener;
    private long mHandle = 0;
    private boolean mDidStart = false;
    private int mLogLevel = 3;
    private SmartServiceWrapper mSmartServiceWrapper = new SmartServiceWrapper();
    private ISmartServiceSupplier mSmartServiceSupplier = new ISmartServiceSupplier() { // from class: com.bytedance.vcloud.strategy.StrategyCenter.1
        @Override // com.bytedance.vcloud.strategy.ISmartServiceSupplier
        public String executeSmartService(String str, String str2) {
            try {
                return String.valueOf(StrategyCenter.this.mSmartServiceWrapper.predictSmartSlice(new JSONObject(str2)));
            } catch (JSONException unused) {
                return "";
            }
        }

        @Override // com.bytedance.vcloud.strategy.ISmartServiceSupplier
        public String getLastResult(String str) {
            return String.valueOf(StrategyCenter.this.mSmartServiceWrapper.getLastResult());
        }
    };

    private native void _addInterimMedia(long j, String str, ISelectBitrateListener iSelectBitrateListener, String str2, boolean z, boolean z2);

    private native void _addMedia(long j, String str, ISelectBitrateListener iSelectBitrateListener, String str2, boolean z);

    private native void _addMediaWithCallback(long j, String str, ISelectBitrateListener iSelectBitrateListener, IPreloadTaskCallbackListener iPreloadTaskCallbackListener, String str2, boolean z, boolean z2);

    private native void _addPriorityTask(long j, String str, ISelectBitrateListener iSelectBitrateListener, IPreloadTaskCallbackListener iPreloadTaskCallbackListener);

    private native void _businessEvent(long j, int i, int i2);

    private native void _businessEvent(long j, int i, int i2, int i3);

    private native void _businessEvent(long j, int i, int i2, String str);

    private native void _businessEvent(long j, int i, String str);

    private native long _create(IStrategyEventListener iStrategyEventListener);

    private native void _createPlayer(long j, long j2, String str, String str2);

    private native void _createPlayerWithTag(long j, long j2, String str, String str2, String str3);

    private native void _createScene(long j, String str);

    private native void _destroyScene(long j, String str);

    private native String _ensureQualityEnhancement(long j, Object obj, String str);

    private native void _focusMedia(long j, String str, int i);

    private native float _getFloatValue(long j, int i, float f);

    private native Object _getImageSelectBitrateResult(long j, String str, String str2);

    private native String _getImageStrategyResult(long j, String str, String str2);

    private native int _getIntValue(long j, int i, int i2);

    private native long _getLongValue(long j, int i, long j2);

    private native long _getLongValue(long j, int i, String str, long j2);

    private native String _getStrValue(long j, int i, String str);

    private native int _iPlayerVersion(long j);

    private native void _insertMedia(long j, String str, ISelectBitrateListener iSelectBitrateListener, IPreloadTaskCallbackListener iPreloadTaskCallbackListener, String str2, int i);

    private native boolean _isIOManagerVersionMatch(long j);

    private native boolean _isMediaExist(long j, String str, String str2);

    private native void _makeCurrentPlayer(long j, String str);

    private native void _moveMedia(long j, String str, int i, int i2);

    private native void _moveToScene(long j, String str);

    private native void _playSelection(long j, String str, String str2, String str3);

    private native String _popLogData(long j, int i, String str);

    private native Map<Integer, Object[]> _popOptionLog(long j, String str);

    private native void _relatePlaySessionRef(long j, String str, String str2, IPlaySessionRef iPlaySessionRef, IPlayStrategyRef iPlayStrategyRef);

    private native void _release(long j);

    private native void _releasePlayer(long j, String str, String str2);

    private native void _removeAllMedia(long j, String str, int i);

    private native void _removeMedia(long j, String str, int i, int i2);

    private native void _removeMedia(long j, String str, String str2);

    private native void _removePriorityTask(long j, String str);

    private native String _selectBitrate(long j, String str, int i, String str2, Object obj);

    private native String _selectBitrateStringMap(long j, String str, int i, String str2, Object obj);

    private native String _selectBitrateStringMapWithObject(long j, Object obj, int i, String str, Object obj2);

    private native void _setAlgorithmJson(long j, int i, String str);

    private native void _setAppInfo(long j, String str);

    private native void _setAppServer(long j, IAppService iAppService);

    private native void _setEventListener(long j, IStrategyEventListener iStrategyEventListener);

    private native void _setFloatValue(long j, int i, float f);

    private native void _setIOManager(long j, long j2, long j3);

    private native void _setIntValue(long j, int i, int i2);

    private native void _setIntervalMS(long j, int i);

    private native void _setLogCallback(long j, ILogCallback iLogCallback);

    private native void _setLongValue(long j, int i, long j2);

    private native void _setPlayDoubleConfig(long j, String str, int i, double d);

    private native void _setPlayIntConfig(long j, String str, int i, int i2);

    private native void _setPlayLongConfig(long j, String str, int i, long j2);

    private native void _setPlayStringConfig(long j, String str, int i, String str2);

    private native void _setPlayTaskProgress(long j, float f);

    private native void _setProbeType(long j, int i);

    private native void _setSettingsInfo(long j, String str, String str2);

    private native void _setSmartServiceSupplier(long j, ISmartServiceSupplier iSmartServiceSupplier);

    private native void _setStateSupplier(long j, IStrategyStateSupplier iStrategyStateSupplier);

    private native void _setStrValue(long j, int i, String str);

    private native void _start(long j);

    private native void _stop(long j);

    private native void _updateMedia(long j, String str, String str2, String str3);

    public StrategyCenter(IStrategyEventListener iStrategyEventListener) {
        this.mListener = null;
        this.mListener = iStrategyEventListener;
    }

    public boolean isLoadLibrarySucceed() {
        return this.mHandle != 0;
    }

    public void create(Context context, boolean z) {
        if (isLoadLibrarySucceed()) {
            return;
        }
        if (z) {
            StrategyCenterJniLoader.loadLibrary(context);
            if (!StrategyCenterJniLoader.isLibraryLoaded) {
                Log.i(TAG, "load library fail.");
                return;
            }
        }
        this.mHandle = _create(this.mListener);
    }

    public void start(Context context, boolean z) {
        String stringValue;
        if (this.mDidStart) {
            return;
        }
        create(context, z);
        if (this.mHandle == 0) {
            return;
        }
        setIntValue(10000, this.mLogLevel);
        _start(this.mHandle);
        if (getIntValue(ENABLE_SMART_SERVICE, 0) != 0 && (stringValue = getStringValue(ALGO_CONFIG_SMART_SERVICE_PACKAGE_URL, "")) != null && !stringValue.isEmpty()) {
            this.mSmartServiceWrapper.configServer(stringValue);
            setSmartServiceSupplier(this.mSmartServiceSupplier);
        }
        this.mDidStart = true;
    }

    public boolean isRunning() {
        return this.mDidStart;
    }

    public void stop() {
        if (this.mDidStart) {
            long j = this.mHandle;
            if (j == 0) {
                return;
            }
            _stop(j);
            this.mDidStart = false;
        }
    }

    public void setEventListener(IStrategyEventListener iStrategyEventListener) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setEventListener(j, iStrategyEventListener);
    }

    public void setIntValue(int i, int i2) {
        if (i == 10000) {
            this.mLogLevel = i2;
        }
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setIntValue(j, i, i2);
    }

    public int getIntValue(int i, int i2) {
        long j = this.mHandle;
        if (j == 0) {
            return i2;
        }
        try {
            return _getIntValue(j, i, i2);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return i2;
        }
    }

    public float getFloatValue(int i, float f) {
        long j = this.mHandle;
        if (j == 0) {
            return f;
        }
        try {
            return _getFloatValue(j, i, f);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return f;
        }
    }

    public void setLongValue(int i, long j) {
        long j2 = this.mHandle;
        if (j2 == 0) {
            return;
        }
        try {
            _setLongValue(j2, i, j);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    public long getLongValue(int i, long j) {
        long j2 = this.mHandle;
        if (j2 == 0) {
            return j;
        }
        try {
            return _getLongValue(j2, i, j);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return j;
        }
    }

    public long getLongValue(int i, String str, long j) {
        long j2 = this.mHandle;
        if (j2 == 0) {
            return j;
        }
        try {
            return _getLongValue(j2, i, str, j);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return j;
        }
    }

    public void setStringValue(int i, String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _setStrValue(j, i, str);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    public String getStringValue(int i, String str) {
        long j = this.mHandle;
        if (j == 0) {
            return str;
        }
        try {
            return _getStrValue(j, i, str);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return str;
        }
    }

    public void setFloatValue(int i, float f) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setFloatValue(j, i, f);
    }

    public void setStateSupplier(IStrategyStateSupplier iStrategyStateSupplier) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setStateSupplier(j, iStrategyStateSupplier);
    }

    public void addMedia(String str, ISelectBitrateListener iSelectBitrateListener, String str2, boolean z) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _addMedia(j, str, iSelectBitrateListener, str2, z);
    }

    public void insertMedia(String str, ISelectBitrateListener iSelectBitrateListener, IPreloadTaskCallbackListener iPreloadTaskCallbackListener, String str2, int i) {
        Log.d("StrategyBridge", "handle = " + this.mHandle + ",insert media, sceneId = " + str2 + " pos = " + i + ",info = " + str);
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _insertMedia(j, str, iSelectBitrateListener, iPreloadTaskCallbackListener, str2, i);
    }

    public void removeMedia(String str, int i, int i2) {
        Log.d("StrategyBridge", "handle = " + this.mHandle + ",remove media, sceneId = " + str + " startPosition = " + i + ",count = " + i2);
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _removeMedia(j, str, i, i2);
    }

    public void moveMedia(String str, int i, int i2) {
        Log.d("StrategyBridge", "handle = " + this.mHandle + ",move media, sceneId = " + str + " fromPosition = " + i + ",toPosition = " + i2);
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _moveMedia(j, str, i, i2);
    }

    public void addMedia(String str, ISelectBitrateListener iSelectBitrateListener, String str2, boolean z, boolean z2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _addInterimMedia(j, str, iSelectBitrateListener, str2, z, z2);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public void addMedia(String str, ISelectBitrateListener iSelectBitrateListener, IPreloadTaskCallbackListener iPreloadTaskCallbackListener, String str2, boolean z, boolean z2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _addMediaWithCallback(j, str, iSelectBitrateListener, iPreloadTaskCallbackListener, str2, z, z2);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
            try {
                _addInterimMedia(this.mHandle, str, iSelectBitrateListener, str2, z, z2);
            } catch (Throwable th2) {
                Log.i(TAG, th2.toString());
            }
        }
    }

    public void addPriorityTask(String str, ISelectBitrateListener iSelectBitrateListener, IPreloadTaskCallbackListener iPreloadTaskCallbackListener) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _addPriorityTask(j, str, iSelectBitrateListener, iPreloadTaskCallbackListener);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public void removePriorityTask(String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _removePriorityTask(j, str);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public void removeMedia(String str, String str2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _removeMedia(j, str, str2);
    }

    public void removeAllMedia(String str, int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _removeAllMedia(j, str, i);
    }

    public void focusMedia(String str, int i) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _focusMedia(j, str, i);
    }

    public void updateMedia(String str, String str2, String str3) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _updateMedia(j, str, str2, str3);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    public void createScene(String str) {
        long j = this.mHandle;
        if (j == 0 || str == null) {
            return;
        }
        _createScene(j, str);
    }

    public void destroyScene(String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _destroyScene(j, str);
    }

    public void switchToScene(String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _moveToScene(j, str);
    }

    public void createPlayer(long j, String str, String str2) {
        long j2 = this.mHandle;
        if (j2 == 0) {
            return;
        }
        _createPlayer(j2, j, str, str2);
    }

    public void createPlayer(long j, String str, String str2, String str3) {
        long j2 = this.mHandle;
        if (j2 == 0) {
            return;
        }
        try {
            _createPlayerWithTag(j2, j, str, str2, str3);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            _createPlayer(this.mHandle, j, str, str2);
        }
    }

    public void releasePlayer(String str, String str2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _releasePlayer(j, str, str2);
    }

    public void makeCurrentPlayer(String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _makeCurrentPlayer(j, str);
    }

    public WeakReference<IPlayStrategyRef> relatePlaySessionRef(String str, String str2, WeakReference<IPlaySessionRef> weakReference) {
        IPlaySessionRef iPlaySessionRef = weakReference != null ? weakReference.get() : null;
        if (this.mHandle == 0) {
            Log.e(TAG, "add session fail. mHandle " + this.mHandle + ", traceId " + str);
            return null;
        }
        try {
            PlayStrategyConfig playStrategyConfig = !TextUtils.isEmpty(str) ? new PlayStrategyConfig(str, this.mHandle) : null;
            _relatePlaySessionRef(this.mHandle, str, str2, iPlaySessionRef, playStrategyConfig);
            if (playStrategyConfig != null) {
                return new WeakReference<>(playStrategyConfig);
            }
            return null;
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
            return null;
        }
    }

    public void playSelection(String str, String str2, String str3) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _playSelection(j, str, str2, str3);
    }

    public void setIOManager(long j, long j2) {
        long j3 = this.mHandle;
        if (j3 == 0) {
            return;
        }
        _setIOManager(j3, j, j2);
    }

    public boolean isIOManagerVersionMatch() {
        long j = this.mHandle;
        if (j == 0) {
            return false;
        }
        return _isIOManagerVersionMatch(j);
    }

    public void setAppInfo(String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setAppInfo(j, str);
    }

    public void setAlgorithmJson(int i, String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setAlgorithmJson(j, i, str);
    }

    public void setSettingsInfo(String str, String str2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setSettingsInfo(j, str, str2);
    }

    public String popLogData(int i, String str) {
        long j = this.mHandle;
        return j == 0 ? "" : _popLogData(j, i, str);
    }

    public Map<Integer, Object[]> popOptionLog(String str) {
        long j = this.mHandle;
        if (j == 0) {
            return null;
        }
        return _popOptionLog(j, str);
    }

    public void setLogCallback(ILogCallback iLogCallback) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        _setLogCallback(j, iLogCallback);
    }

    public void businessEvent(int i, int i2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _businessEvent(j, i, i2);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    public void businessEvent(int i, String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _businessEvent(j, i, str);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    public void businessEvent(int i, int i2, int i3) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _businessEvent(j, i, i2, i3);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    public void businessEvent(int i, int i2, String str) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _businessEvent(j, i, i2, str);
        } catch (Throwable th) {
            Log.e(TAG, th.toString());
        }
    }

    public String selectBitrate(String str, int i, String str2, Object obj) {
        long j = this.mHandle;
        if (j == 0) {
            return null;
        }
        try {
            return _selectBitrate(j, str, i, str2, obj);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
            return null;
        }
    }

    @Deprecated
    public String selectBitrateStringMap(String str, int i, String str2, Object obj) {
        long j = this.mHandle;
        if (j == 0) {
            return null;
        }
        try {
            return _selectBitrateStringMap(j, str, i, str2, obj);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
            return null;
        }
    }

    public String selectBitrateStringMapWithObject(JSONObject jSONObject, int i, String str, Object obj) {
        long j = this.mHandle;
        if (j == 0) {
            return null;
        }
        try {
            return _selectBitrateStringMapWithObject(j, jSONObject, i, str, obj);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
            return null;
        }
    }

    public String ensureQualityEnhancement(JSONObject jSONObject, String str) {
        long j = this.mHandle;
        if (j == 0) {
            return null;
        }
        try {
            return _ensureQualityEnhancement(j, jSONObject, str);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
            return null;
        }
    }

    public int iPlayerVersion() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _iPlayerVersion(j);
    }

    public void setAppServer(IAppService iAppService) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _setAppServer(j, iAppService);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public void setSmartServiceSupplier(ISmartServiceSupplier iSmartServiceSupplier) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _setSmartServiceSupplier(j, iSmartServiceSupplier);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public void setPlayStringConfig(String str, int i, String str2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _setPlayStringConfig(j, str, i, str2);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public void setPlayIntConfig(String str, int i, int i2) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _setPlayIntConfig(j, str, i, i2);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public void setPlayDoubleConfig(String str, int i, double d) {
        long j = this.mHandle;
        if (j == 0) {
            return;
        }
        try {
            _setPlayDoubleConfig(j, str, i, d);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public void setPlayLongConfig(String str, int i, long j) {
        long j2 = this.mHandle;
        if (j2 == 0) {
            return;
        }
        try {
            _setPlayLongConfig(j2, str, i, j);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
        }
    }

    public boolean isMediaExist(String str, String str2) {
        if (this.mHandle == 0 || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            return _isMediaExist(this.mHandle, str, str2);
        } catch (Throwable th) {
            Log.i(TAG, th.toString());
            return false;
        }
    }

    public Map<String, Object> getImageStrategyResult(String str, Map<String, Object> map) {
        String jSONObject;
        if (this.mHandle != 0 && str != null && !str.isEmpty()) {
            if (map != null) {
                try {
                    jSONObject = new JSONObject(map).toString();
                } catch (Throwable th) {
                    Log.i(TAG, th.toString());
                }
            } else {
                jSONObject = null;
            }
            String _getImageStrategyResult = _getImageStrategyResult(this.mHandle, str, jSONObject);
            if (_getImageStrategyResult != null && !_getImageStrategyResult.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject(_getImageStrategyResult);
                Iterator<String> keys = jSONObject2.keys();
                HashMap hashMap = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.get(next));
                }
                return hashMap;
            }
        }
        return null;
    }

    public JSONObject getImageSelectBitrateResult(String str, Map<String, Object> map) {
        if (this.mHandle != 0 && !TextUtils.isEmpty(str) && map != null && !map.isEmpty()) {
            try {
                Object _getImageSelectBitrateResult = _getImageSelectBitrateResult(this.mHandle, str, new JSONObject(map).toString());
                if (_getImageSelectBitrateResult != null && (_getImageSelectBitrateResult instanceof JSONObject)) {
                    return (JSONObject) _getImageSelectBitrateResult;
                }
            } catch (Throwable th) {
                Log.i(TAG, th.toString());
            }
        }
        return null;
    }
}
