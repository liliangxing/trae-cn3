package com.bytedance.ttnet.config;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.push.utils.RomVersionParamHelper;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MultiProcStackOptConfig implements SsCronetHttpClient.ICronetThreadStackOptFailureChecker {
    static final long DEFAULT_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS = 10800;
    static final String KEVA_STACK_CONFIG_REPO_KEY = "tt_stack_config";
    static final String KEY_ENABLE_STACK_OPT = "enable_stack_opt";
    static final String KEY_ENABLE_STACK_OPT_FALLBACK_FIX = "enable_stack_opt_fallback_fix";
    static final String KEY_STACK_OPT_FAILURES = "stack_opt_failures";
    static final String KEY_STACK_OPT_FAILURE_TIMESTAMP = "stack_opt_failure_timestamp";
    static final String KEY_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS = "stack_opt_fallback_fix_interval_s";
    static final String TAG = "MultiProcStackOptConfig";
    private static volatile MultiProcStackOptConfig mInstance;
    private Context mContext;
    private final boolean mIsMainProcess;
    private Keva mKeva;
    private String mProcessName;
    private boolean mEnableChromiumThreadStackOpt = false;
    private boolean mEnableThreadStackOptFallbackFix = true;
    private volatile int mChromiumThreadStackOptFailures = -1;
    private long mChromiumThreadStackOptFailureTimestamp = 0;
    private long mChromiumThreadStackOptFallbackFixIntervalSeconds = DEFAULT_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS;
    private boolean mHasChecked = false;
    private boolean mIsCronetThreadStackOptFailureExpected = false;
    private TTNetThreadConfig.ThreadStackInitReason mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.TNC_DISABLED;

    public static MultiProcStackOptConfig inst(Context context) {
        if (mInstance == null) {
            synchronized (MultiProcStackOptConfig.class) {
                if (mInstance == null) {
                    mInstance = new MultiProcStackOptConfig(context);
                }
            }
        }
        return mInstance;
    }

    private MultiProcStackOptConfig(Context context) {
        KevaBuilder.getInstance().setContext(context);
        this.mIsMainProcess = ProcessUtils.isMainProcessByProcessFlag(context);
        this.mKeva = Keva.getRepo(KEVA_STACK_CONFIG_REPO_KEY, 1);
        this.mContext = context;
    }

    private String addPrefixToString(String str) {
        return this.mProcessName + RomVersionParamHelper.SEPARATOR + str;
    }

    public String getThreadStackInitReason() {
        return this.mThreadStackInitReason.toString();
    }

    public boolean isCronetThreadStackOptFailureExpected() {
        try {
            if (this.mHasChecked) {
                this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.CALLED_MULIT_TIMES;
                return false;
            }
            String curProcessName = ProcessUtils.getCurProcessName(this.mContext);
            this.mProcessName = curProcessName;
            if (TextUtils.isEmpty(curProcessName)) {
                this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.PROCESS_NAME_NULL;
                return false;
            }
            this.mHasChecked = true;
            this.mEnableChromiumThreadStackOpt = this.mKeva.getBoolean(KEY_ENABLE_STACK_OPT, false);
            this.mEnableThreadStackOptFallbackFix = this.mKeva.getBoolean(KEY_ENABLE_STACK_OPT_FALLBACK_FIX, true);
            this.mChromiumThreadStackOptFallbackFixIntervalSeconds = this.mKeva.getLong(KEY_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS, DEFAULT_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS);
            this.mChromiumThreadStackOptFailures = this.mKeva.getInt(addPrefixToString(KEY_STACK_OPT_FAILURES), 0);
            this.mChromiumThreadStackOptFailureTimestamp = this.mKeva.getLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), 0L);
            if (this.mEnableThreadStackOptFallbackFix && this.mChromiumThreadStackOptFailures > 0 && System.currentTimeMillis() - this.mChromiumThreadStackOptFailureTimestamp > TimeUnit.SECONDS.toMillis(this.mChromiumThreadStackOptFallbackFixIntervalSeconds)) {
                this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.FALLBACK_FIX;
                this.mChromiumThreadStackOptFailures = 0;
            }
            if (this.mEnableChromiumThreadStackOpt && this.mChromiumThreadStackOptFailures == 0) {
                this.mKeva.storeInt(addPrefixToString(KEY_STACK_OPT_FAILURES), this.mChromiumThreadStackOptFailures + 1);
                this.mKeva.storeLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), System.currentTimeMillis());
                this.mIsCronetThreadStackOptFailureExpected = true;
                if (this.mThreadStackInitReason != TTNetThreadConfig.ThreadStackInitReason.FALLBACK_FIX) {
                    this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.OPT_EFFECTIVE;
                }
                return true;
            }
            if (!this.mEnableChromiumThreadStackOpt) {
                this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.TNC_DISABLED;
            } else {
                this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.CRASH_HAPPENED;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.HAS_EXCEPTION;
            return false;
        }
    }

    public void onTncRequestSucceeded(boolean z, boolean z2, int i) {
        try {
            if (this.mIsMainProcess) {
                this.mKeva.storeBoolean(KEY_ENABLE_STACK_OPT, z);
                this.mKeva.storeBoolean(KEY_ENABLE_STACK_OPT_FALLBACK_FIX, z2);
                this.mKeva.storeLong(KEY_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS, Long.valueOf(i).longValue());
            }
            if (this.mHasChecked && this.mIsCronetThreadStackOptFailureExpected) {
                this.mKeva.storeInt(addPrefixToString(KEY_STACK_OPT_FAILURES), 0);
                this.mKeva.storeLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), 0L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
