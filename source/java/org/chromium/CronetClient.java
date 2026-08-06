package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.block.BlockConstants;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTask;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetAppInfoSubset;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.util.BoeUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.sampling.SamplingSettingProvider;
import com.bytedance.frameworks.baselib.network.sampling.SlaSamplingSettingCreator;
import com.bytedance.frameworks.baselib.network.utils.ReflectWrap;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTAppSecurityManager;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.impl.TTCompressManager;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    private static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    private static final String KEY_TTNET_CRASH_TIMES = "ttnet_crash_times";
    private static final int MAX_THREAD_STACK_SIZE = 5242880;
    private static final int MIN_THREAD_STACK_SIZE = 51200;
    private static final String SP_SS_APP_CONFIG = "ss_app_config";
    public static final String TAG = "CronetClient";
    private static final String TTNET_ALOG_CLASS = "com.bytedance.ttnet.TTALog";
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CACHE_DIR = "ttnet_storage/";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static int sAppID = 0;
    private static ICronetClient.ICronetBootFailureCheckerProvider sCronetBootFailureCheckerProvider = null;
    private static volatile CronetEngine sCronetEngine = null;
    private static ICronetClient.ICronetThreadStackOptFailureCheckerProvider sCronetThreadStackOptFailureCheckerProvider = null;
    private static volatile int sNetworkThreadPriority = 20;
    private int mTTNetCrashTimes;
    private int mCrashLimitTimes = 0;
    private int mCrashDetectTimerInterval = BlockConstants.DEFAULT_ANR;

    public String getCronetVersion() {
        return "TTNetVersion:60391651 2026-03-24 QuicVersion:21ac1950 2025-11-18";
    }

    public void setHttpDnsForTesting(boolean z, boolean z2, boolean z3) throws Exception {
    }

    public void setCronetThreadStackOptFailureCheckerProvider(ICronetClient.ICronetThreadStackOptFailureCheckerProvider iCronetThreadStackOptFailureCheckerProvider) {
        sCronetThreadStackOptFailureCheckerProvider = iCronetThreadStackOptFailureCheckerProvider;
    }

    public HttpURLConnection openConnection(Context context, String str, boolean z, String str2, BaseHttpRequestInfo baseHttpRequestInfo, ICronetAppProvider iCronetAppProvider) throws IOException {
        try {
            if (TTNetInitMetrics.inst().mode == TTNetInitMetrics.CronetInitMode.NONE) {
                TTNetInitMetrics.inst().mode = TTNetInitMetrics.CronetInitMode.LAZY_INIT;
            }
            tryCreateCronetEngine(context, false, false, false, z, str2, false, iCronetAppProvider);
            CronetHttpURLConnection openConnection = sCronetEngine.openConnection(new URL(str), Proxy.NO_PROXY, baseHttpRequestInfo.useCronetInputStreamWithTTBuffer);
            openConnection.setRequestFinishedListener(new TTCronetRequestFinishedInfoListener(baseHttpRequestInfo));
            return openConnection;
        } catch (Throwable th) {
            if (th instanceof MalformedURLException) {
                throw th;
            }
            if ((th instanceof UnsupportedOperationException) && th.getMessage() != null && th.getMessage().contains("Unexpected protocol")) {
                throw new IOException("MalformedURLException", th);
            }
            throw new IOException(th);
        }
    }

    public void setCronetBootFailureCheckerProvider(ICronetClient.ICronetBootFailureCheckerProvider iCronetBootFailureCheckerProvider) {
        sCronetBootFailureCheckerProvider = iCronetBootFailureCheckerProvider;
    }

    public static void setNetworkThreadPriority(int i) {
        sNetworkThreadPriority = i;
    }

    private void detectCronetColdStartCrash(final Context context, ExperimentalCronetEngine.Builder builder) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        int i = sharedPreferences.getInt(KEY_CRASH_LIMIT_TIMES, 0);
        this.mCrashLimitTimes = i;
        if (i <= 0) {
            int i2 = sharedPreferences.getInt(KEY_TTNET_CRASH_TIMES, 0);
            this.mTTNetCrashTimes = i2;
            if (i2 > 0) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt(KEY_TTNET_CRASH_TIMES, 0);
                edit.apply();
                return;
            }
            return;
        }
        this.mTTNetCrashTimes = sharedPreferences.getInt(KEY_TTNET_CRASH_TIMES, 0);
        int i3 = sharedPreferences.getInt(KEY_CRASH_DETECT_INTERVAL_MS, BlockConstants.DEFAULT_ANR);
        this.mCrashDetectTimerInterval = i3;
        if (i3 <= 0) {
            this.mCrashDetectTimerInterval = BlockConstants.DEFAULT_ANR;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(context) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
        }
        if (this.mTTNetCrashTimes >= this.mCrashLimitTimes) {
            if (Logger.debug()) {
                Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(context) + "set secure mode true");
            }
            builder.enableTncSecureMode(true);
        }
        if (ProcessUtils.isMainProcessByProcessFlag(context)) {
            final SharedPreferences.Editor edit2 = sharedPreferences.edit();
            int i4 = this.mTTNetCrashTimes + 1;
            this.mTTNetCrashTimes = i4;
            edit2.putInt(KEY_TTNET_CRASH_TIMES, i4);
            edit2.commit();
            if (Logger.debug()) {
                Logger.d(TAG, "processname is " + ProcessUtils.getCurProcessName(context) + " save count " + this.mTTNetCrashTimes);
            }
            NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask(this.mCrashDetectTimerInterval, 0L) { // from class: org.chromium.CronetClient.1
                public void run() {
                    if (Logger.debug()) {
                        Logger.d(CronetClient.TAG, "processname is " + ProcessUtils.getCurProcessName(context) + " clear count ");
                    }
                    edit2.putInt(CronetClient.KEY_TTNET_CRASH_TIMES, 0);
                    edit2.apply();
                }
            });
        }
    }

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(TTNetAppInfoSubset tTNetAppInfoSubset) {
        TTAppInfoProvider.AppInfo appInfo = new TTAppInfoProvider.AppInfo();
        appInfo.setAbSdkVersion(tTNetAppInfoSubset.mAbSdkVersion);
        appInfo.setHostFirst(tTNetAppInfoSubset.mHostFirst);
        appInfo.setHostSecond(tTNetAppInfoSubset.mHostSecond);
        appInfo.setHostThird(tTNetAppInfoSubset.mHostThird);
        appInfo.setDomainHttpDns(tTNetAppInfoSubset.mDomainHttpDns);
        appInfo.setDomainBoe(tTNetAppInfoSubset.mDomainBoe);
        appInfo.setDomainBoeHttps(tTNetAppInfoSubset.mDomainBoeHttps);
        appInfo.setInitRegion(tTNetAppInfoSubset.mInitRegion);
        return appInfo;
    }

    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<TTNetThreadConfig> arrayList, boolean z) {
        if (arrayList != null) {
            try {
                if (!arrayList.isEmpty()) {
                    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> arrayList2 = new ArrayList<>();
                    EnumSet noneOf = EnumSet.noneOf(TTNetThreadConfig.ThreadType.class);
                    Iterator<TTNetThreadConfig> it = arrayList.iterator();
                    while (it.hasNext()) {
                        TTNetThreadConfig next = it.next();
                        boolean z2 = true;
                        boolean z3 = next.mThreadPriority >= -20 && next.mThreadPriority <= 19;
                        if (!z || next.mThreadStackSize < MIN_THREAD_STACK_SIZE || next.mThreadStackSize > MAX_THREAD_STACK_SIZE) {
                            z2 = false;
                        }
                        if (z3 || z2) {
                            if (!noneOf.contains(next.mThreadType)) {
                                TTThreadConfigInfoProvider.ThreadConfigInfo threadConfigInfo = new TTThreadConfigInfoProvider.ThreadConfigInfo();
                                threadConfigInfo.setThreadType(TTThreadConfigInfoProvider.ThreadType.values()[next.mThreadType.ordinal()]);
                                if (z3) {
                                    threadConfigInfo.setThreadPriority(next.mThreadPriority);
                                }
                                if (z2) {
                                    threadConfigInfo.setThreadStackSize(next.mThreadStackSize);
                                }
                                arrayList2.add(threadConfigInfo);
                                noneOf.add(next.mThreadType);
                            }
                        }
                    }
                    return arrayList2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback(final TTNetThreadConfig.Callback callback) {
        if (callback == null) {
            return null;
        }
        return new TTThreadConfigInfoProvider.Callback() { // from class: org.chromium.CronetClient.2
            public void bindBigCore(int i) {
                callback.bindBigCore(i);
            }

            public void bindLittleCore(int i) {
                callback.bindLittleCore(i);
            }

            public void resetCoreBind(int i) {
                callback.resetCoreBind(i);
            }
        };
    }

    private static TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting(SamplingSettingProvider.SlaSamplingSetting slaSamplingSetting) {
        TTSamplingSettingProvider.TTSlaSamplingRule tTSlaSamplingRule;
        TTSamplingSettingProvider.TTEventLogSamplingRule tTEventLogSamplingRule;
        if (slaSamplingSetting == null) {
            return null;
        }
        try {
            SamplingSettingProvider.SlaSamplingRule slaSamplingRule = slaSamplingSetting.getSlaSamplingRule();
            if (slaSamplingRule != null) {
                tTSlaSamplingRule = new TTSamplingSettingProvider.TTSlaSamplingRule();
                tTSlaSamplingRule.mEnableBaseApiAll = slaSamplingRule.getEnableBaseApiAll();
                tTSlaSamplingRule.mEnableApiAllUpload = slaSamplingRule.getEnableApiAllUpload();
                tTSlaSamplingRule.mUrlRegexBlackList = slaSamplingRule.getUrlRegexBlackList();
                tTSlaSamplingRule.mPathEqualWhiteList = slaSamplingRule.getPathEqualWhiteList();
                tTSlaSamplingRule.mPathPrefixWhiteList = slaSamplingRule.getPathPrefixWhiteList();
                tTSlaSamplingRule.mPathContainWhiteList = slaSamplingRule.getPathContainWhiteList();
                tTSlaSamplingRule.mPathRegexWhiteList = slaSamplingRule.getPathRegexWhiteList();
                tTSlaSamplingRule.mHostPatternWhiteList = slaSamplingRule.getHostPatternWhiteList();
                tTSlaSamplingRule.mUrlRegexWhiteList = slaSamplingRule.getUrlRegexWhiteList();
            } else {
                tTSlaSamplingRule = null;
            }
            SamplingSettingProvider.SlaEventLogSamplingRule slaEventLogSamplingRule = slaSamplingSetting.getSlaEventLogSamplingRule();
            if (slaEventLogSamplingRule != null) {
                tTEventLogSamplingRule = new TTSamplingSettingProvider.TTEventLogSamplingRule();
                tTEventLogSamplingRule.mEventLogTypeWhiteList = slaEventLogSamplingRule.getEventLogTypeWhiteList();
            } else {
                tTEventLogSamplingRule = null;
            }
            TTSamplingSettingProvider.TTSlaSamplingSetting tTSlaSamplingSetting = new TTSamplingSettingProvider.TTSlaSamplingSetting();
            tTSlaSamplingSetting.mHostAid = slaSamplingSetting.getHostAid();
            tTSlaSamplingSetting.mSdkAid = slaSamplingSetting.getSdkAid();
            tTSlaSamplingSetting.mSlaSamplingRule = tTSlaSamplingRule;
            tTSlaSamplingSetting.mEventLogSamplingRule = tTEventLogSamplingRule;
            return tTSlaSamplingSetting;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0357 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x035d A[Catch: all -> 0x04b9, TRY_LEAVE, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x039f A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03e3 A[Catch: all -> 0x04b9, TRY_LEAVE, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03ee A[Catch: Exception -> 0x040a, all -> 0x04b9, TRY_LEAVE, TryCatch #1 {Exception -> 0x040a, blocks: (B:131:0x03e6, B:133:0x03ee), top: B:130:0x03e6, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0410 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0455 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0463 A[Catch: all -> 0x04b9, TRY_LEAVE, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0459 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x041b A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c4 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01d1 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e1 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ee A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x021e A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x022f A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0258 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0278 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0286 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02cd A[Catch: all -> 0x04b9, LOOP:0: B:88:0x02c7->B:90:0x02cd, LOOP_END, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0303 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0319 A[Catch: all -> 0x04b9, TryCatch #3 {, blocks: (B:6:0x000d, B:8:0x0011, B:10:0x002e, B:12:0x0032, B:15:0x0039, B:16:0x0047, B:18:0x0048, B:20:0x0057, B:23:0x0060, B:25:0x007e, B:26:0x0085, B:28:0x00d7, B:29:0x00e1, B:31:0x0138, B:32:0x013b, B:42:0x01ad, B:44:0x01b3, B:46:0x01b9, B:47:0x01be, B:49:0x01c4, B:50:0x01c7, B:52:0x01d1, B:53:0x01d7, B:55:0x01e1, B:56:0x01e4, B:58:0x01ee, B:59:0x01f1, B:61:0x021e, B:63:0x022f, B:64:0x0237, B:66:0x0258, B:67:0x026e, B:69:0x0278, B:70:0x0280, B:72:0x0286, B:73:0x0289, B:75:0x0293, B:77:0x0299, B:78:0x029c, B:80:0x02a6, B:82:0x02ac, B:83:0x02af, B:85:0x02b9, B:87:0x02bf, B:88:0x02c7, B:90:0x02cd, B:92:0x02f9, B:94:0x0303, B:95:0x030b, B:97:0x0319, B:99:0x0333, B:100:0x034d, B:102:0x0357, B:104:0x035d, B:115:0x038e, B:117:0x0393, B:119:0x0399, B:121:0x039f, B:123:0x03ad, B:124:0x03b0, B:126:0x03ba, B:127:0x03d5, B:129:0x03e3, B:131:0x03e6, B:133:0x03ee, B:136:0x0410, B:137:0x0413, B:140:0x0421, B:142:0x0455, B:143:0x045d, B:145:0x0463, B:157:0x04a2, B:158:0x0459, B:159:0x041b, B:161:0x040b, B:166:0x019f, B:176:0x04a5, B:177:0x04b7, B:147:0x0467, B:149:0x046f, B:150:0x048a, B:153:0x0492, B:154:0x0495, B:107:0x0369, B:109:0x037c, B:110:0x037f, B:112:0x0388), top: B:5:0x000d, inners: #0, #1, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void tryCreateCronetEngine(Context context, boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, ICronetAppProvider iCronetAppProvider) {
        int appSecurityLevel;
        boolean z6;
        String domainConfigByRegion;
        ArrayList<byte[]> opaqueData;
        Map<String[], Pair<byte[], byte[]>> clientOpaqueData;
        Map<String, Pair<Integer, Integer>> quicHint;
        String cronetSoPath;
        boolean isBOEProxyEnabled;
        String storeIdcRuleJSON;
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider iCronetThreadStackOptFailureCheckerProvider;
        String threadStackInitReason;
        boolean z7;
        long aLogFuncAddr;
        ICronetClient.ICronetBootFailureCheckerProvider iCronetBootFailureCheckerProvider;
        if (sCronetEngine == null) {
            synchronized (CronetClient.class) {
                if (sCronetEngine == null) {
                    Log.w(TAG, "CronetClient tryCreateCronetEngine");
                    TTNetInitMetrics.inst().createEngineStartTime = System.currentTimeMillis();
                    TTNetInitMetrics.inst().createEngineStart = System.nanoTime();
                    if (!z5 && (iCronetBootFailureCheckerProvider = sCronetBootFailureCheckerProvider) != null && !iCronetBootFailureCheckerProvider.isCronetBootFailureExpected()) {
                        Log.w(TAG, "isCronetBootFailureExpected return false.");
                        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");
                    }
                    TTNetInitMetrics.inst().getStackOptConfigStart = System.nanoTime();
                    ICronetClient.ICronetThreadStackOptFailureCheckerProvider iCronetThreadStackOptFailureCheckerProvider2 = sCronetThreadStackOptFailureCheckerProvider;
                    boolean z8 = iCronetThreadStackOptFailureCheckerProvider2 != null && iCronetThreadStackOptFailureCheckerProvider2.isCronetThreadStackOptFailureExpected();
                    TTNetInitMetrics.inst().getStackOptConfigEnd = System.nanoTime();
                    TTNetInitMetrics.inst().constructAppInfoSubsetStart = System.nanoTime();
                    boolean optInit = CronetAppProviderManager.inst().getOptInit();
                    TTNetAppInfoSubset appInfoSubset = optInit ? iCronetAppProvider.getAppInfoSubset() : null;
                    TTNetInitMetrics.inst().constructAppInfoSubsetEnd = System.nanoTime();
                    TTNetInitMetrics.inst().constructThreadConfigListStart = TTNetInitMetrics.inst().constructAppInfoSubsetEnd;
                    ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList = convertToCronetThreadConfigInfoList(getThreadConfigInfoList(), z8);
                    TTNetInitMetrics.inst().constructThreadConfigListEnd = System.nanoTime();
                    TTNetInitMetrics.inst().constructThreadConfigCallbackStart = TTNetInitMetrics.inst().constructThreadConfigListEnd;
                    TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());
                    TTNetInitMetrics.inst().constructThreadConfigCallbackEnd = System.nanoTime();
                    TTNetInitMetrics.inst().constructSlaSamplingSettingStart = TTNetInitMetrics.inst().constructThreadConfigCallbackEnd;
                    try {
                        sAppID = Integer.parseInt(iCronetAppProvider.getAppId());
                    } catch (Exception unused) {
                    }
                    TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting = convertToCronetSlaSamplingSetting(SlaSamplingSettingCreator.create(getSlaSamplingSetting(), sAppID));
                    TTNetInitMetrics.inst().constructSlaSamplingSettingEnd = System.nanoTime();
                    TTNetInitMetrics.inst().buildContextConfigStart = TTNetInitMetrics.inst().constructSlaSamplingSettingEnd;
                    ExperimentalCronetEngine.Builder enableNetworkQualityEstimator = new ExperimentalCronetEngine.Builder(context, optInit).enableQuic(z).enableHttp2(z2).enableSdch(z3).enableHttpDns(z4).listenAppStateIndependently(getListenAppStateIndependently()).enableNetworkQualityEstimator(true);
                    if (CronetDependManager.inst().loggerDebug()) {
                        enableNetworkQualityEstimator.enableVerboseLog();
                    }
                    TTNetAppInfoSubset tTNetAppInfoSubset = appInfoSubset;
                    boolean z9 = z8;
                    enableNetworkQualityEstimator.setTTNetInitStart(Math.min(TTNetInitMetrics.inst().initTTNetStart, TTNetInitMetrics.inst().createEngineStart));
                    detectCronetColdStartCrash(context, enableNetworkQualityEstimator);
                    String str2 = "";
                    try {
                        str2 = context.getCacheDir().getPath() + "/";
                        try {
                            enableNetworkQualityEstimator.setStoragePath(str2 + TTNET_CACHE_DIR);
                            try {
                                enableNetworkQualityEstimator.enableHttpCache(3, getMaxHttpDiskCacheSize());
                                str2 = str2;
                            } catch (Throwable th) {
                                th = th;
                                str2 = str2;
                                Log.w(TAG, "ExperimentalCronetEngine.Builder enable HTTP Cache failed.");
                                th.printStackTrace();
                                enableNetworkQualityEstimator.enableHttpCache(0, 0L);
                                if (sNetworkThreadPriority >= -20) {
                                    enableNetworkQualityEstimator.setThreadPriority(sNetworkThreadPriority);
                                }
                                appSecurityLevel = getAppSecurityLevel();
                                if (appSecurityLevel > 0) {
                                }
                                if (CronetAppProviderManager.inst().isEnableBrotli()) {
                                }
                                if (CronetAppProviderManager.inst().isEnableQuic()) {
                                }
                                if (CronetAppProviderManager.inst().isEnableHttp2()) {
                                }
                                TTAppSecurityManager.getInstance().setSystemApiSandbox(CronetSystemApiSandbox.inst());
                                enableNetworkQualityEstimator.setAppInfoProvider(CronetAppInfoProvider.inst(context));
                                enableNetworkQualityEstimator.setEventListener(CronetEventListener.inst());
                                enableNetworkQualityEstimator.setIsMainProcess(ProcessUtils.isMainProcessByProcessFlag(context));
                                enableNetworkQualityEstimator.setProcessName(ProcessUtils.getCurProcessName(context));
                                if (ProcessUtils.isMainProcessByProcessFlag(context)) {
                                }
                                if (optInit) {
                                }
                                enableNetworkQualityEstimator.setOptInit(optInit);
                                enableNetworkQualityEstimator.setOptNqeInit(iCronetAppProvider.getOptNqeDefault(), iCronetAppProvider.getOptNqePersist());
                                enableNetworkQualityEstimator.setThreadConfigInfoList(convertToCronetThreadConfigInfoList);
                                enableNetworkQualityEstimator.setThreadConfigCallbackImpl(convertToCronetThreadConfigCallback);
                                enableNetworkQualityEstimator.setLazyInitIPC(iCronetAppProvider.getLazyInitCronetIPC());
                                if (!TextUtils.isEmpty(str)) {
                                }
                                domainConfigByRegion = getDomainConfigByRegion();
                                if (TextUtils.isEmpty(domainConfigByRegion)) {
                                }
                                if (!TextUtils.isEmpty(domainConfigByRegion)) {
                                }
                                opaqueData = CronetAppProviderManager.inst().getOpaqueData();
                                if (opaqueData != null) {
                                    enableNetworkQualityEstimator.setOpaqueData(opaqueData);
                                }
                                clientOpaqueData = CronetAppProviderManager.inst().getClientOpaqueData();
                                if (clientOpaqueData != null) {
                                    enableNetworkQualityEstimator.setClientOpaqueData(clientOpaqueData);
                                }
                                quicHint = CronetAppProviderManager.inst().getQuicHint();
                                if (quicHint != null) {
                                    while (r0.hasNext()) {
                                    }
                                }
                                if (CronetAppProviderManager.inst().needCustomLoadLibrary()) {
                                }
                                cronetSoPath = CronetAppProviderManager.inst().getCronetSoPath();
                                if (!TextUtils.isEmpty(cronetSoPath)) {
                                }
                                isBOEProxyEnabled = CronetAppProviderManager.inst().isBOEProxyEnabled();
                                if (isBOEProxyEnabled) {
                                }
                                if (!isBOEProxyEnabled) {
                                }
                                if (!isBOEProxyEnabled) {
                                    enableNetworkQualityEstimator.enableBoeProxy(true);
                                }
                                if (isBOEProxyEnabled) {
                                }
                                storeIdcRuleJSON = CronetAppProviderManager.inst().getStoreIdcRuleJSON();
                                if (!TextUtils.isEmpty(storeIdcRuleJSON)) {
                                }
                                aLogFuncAddr = getALogFuncAddr();
                                if (aLogFuncAddr != 0) {
                                }
                                if (convertToCronetSlaSamplingSetting != null) {
                                }
                                iCronetThreadStackOptFailureCheckerProvider = sCronetThreadStackOptFailureCheckerProvider;
                                if (iCronetThreadStackOptFailureCheckerProvider != null) {
                                }
                                enableNetworkQualityEstimator.setStackInfo(z7, threadStackInitReason);
                                TTNetInitMetrics.inst().buildContextConfigEnd = System.nanoTime();
                                TTNetInitMetrics.inst().buildBuilderStart = TTNetInitMetrics.inst().buildContextConfigEnd;
                                sCronetEngine = enableNetworkQualityEstimator.build();
                                TTNetInitMetrics.inst().buildBuilderEnd = System.nanoTime();
                                if (!CronetDependManager.inst().loggerDebug()) {
                                }
                                if (sCronetEngine instanceof ExperimentalCronetEngine) {
                                }
                                TTRequestCompressManager.setCompressDataCallback(new TTRequestCompressManager.CompressDataCallback() { // from class: org.chromium.CronetClient.4
                                    public byte[] compressData(byte[] bArr, int i, int i2, int i3) {
                                        if (i3 == TTCompressManager.CompressType.BROTLI.getValue()) {
                                            return TTCompressManager.compressData(bArr, i, i2, TTCompressManager.CompressType.BROTLI);
                                        }
                                        return null;
                                    }

                                    public byte[] decompressData(byte[] bArr, int i, int i2) {
                                        if (i2 == TTCompressManager.CompressType.BROTLI.getValue()) {
                                            return TTCompressManager.decompressData(bArr, i, TTCompressManager.CompressType.BROTLI);
                                        }
                                        return null;
                                    }
                                });
                                TTNetInitMetrics.inst().createEngineEnd = System.nanoTime();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    if (sNetworkThreadPriority >= -20 && sNetworkThreadPriority <= 19) {
                        enableNetworkQualityEstimator.setThreadPriority(sNetworkThreadPriority);
                    }
                    appSecurityLevel = getAppSecurityLevel();
                    if (appSecurityLevel > 0) {
                        enableNetworkQualityEstimator.setAppSecurityLevel(appSecurityLevel);
                    }
                    if (CronetAppProviderManager.inst().isEnableBrotli()) {
                        z6 = true;
                    } else {
                        z6 = true;
                        enableNetworkQualityEstimator.enableBrotli(true);
                    }
                    if (CronetAppProviderManager.inst().isEnableQuic()) {
                        enableNetworkQualityEstimator.enableQuic(z6);
                    }
                    if (CronetAppProviderManager.inst().isEnableHttp2()) {
                        enableNetworkQualityEstimator.enableHttp2(z6);
                    }
                    TTAppSecurityManager.getInstance().setSystemApiSandbox(CronetSystemApiSandbox.inst());
                    enableNetworkQualityEstimator.setAppInfoProvider(CronetAppInfoProvider.inst(context));
                    enableNetworkQualityEstimator.setEventListener(CronetEventListener.inst());
                    enableNetworkQualityEstimator.setIsMainProcess(ProcessUtils.isMainProcessByProcessFlag(context));
                    enableNetworkQualityEstimator.setProcessName(ProcessUtils.getCurProcessName(context));
                    if (ProcessUtils.isMainProcessByProcessFlag(context)) {
                        enableNetworkQualityEstimator.setAppMonitorProvider(CronetAppMonitorProvider.inst());
                        CronetEventListener.inst().setIsMainProcess(true);
                    }
                    if (optInit) {
                        enableNetworkQualityEstimator.setTTAppInfoColdStartSubset(convertToCronetAppInfo(tTNetAppInfoSubset));
                    }
                    enableNetworkQualityEstimator.setOptInit(optInit);
                    enableNetworkQualityEstimator.setOptNqeInit(iCronetAppProvider.getOptNqeDefault(), iCronetAppProvider.getOptNqePersist());
                    enableNetworkQualityEstimator.setThreadConfigInfoList(convertToCronetThreadConfigInfoList);
                    enableNetworkQualityEstimator.setThreadConfigCallbackImpl(convertToCronetThreadConfigCallback);
                    enableNetworkQualityEstimator.setLazyInitIPC(iCronetAppProvider.getLazyInitCronetIPC());
                    if (!TextUtils.isEmpty(str)) {
                        enableNetworkQualityEstimator.setUserAgent(str + " cronet/TTNetVersion:60391651 2026-03-24 QuicVersion:21ac1950 2025-11-18");
                    }
                    domainConfigByRegion = getDomainConfigByRegion();
                    if (TextUtils.isEmpty(domainConfigByRegion)) {
                        domainConfigByRegion = CronetAppProviderManager.inst().getGetDomainDefaultJSON();
                    }
                    if (!TextUtils.isEmpty(domainConfigByRegion)) {
                        enableNetworkQualityEstimator.setGetDomainDefaultJSON(domainConfigByRegion);
                    }
                    opaqueData = CronetAppProviderManager.inst().getOpaqueData();
                    if (opaqueData != null && !opaqueData.isEmpty()) {
                        enableNetworkQualityEstimator.setOpaqueData(opaqueData);
                    }
                    clientOpaqueData = CronetAppProviderManager.inst().getClientOpaqueData();
                    if (clientOpaqueData != null && !clientOpaqueData.isEmpty()) {
                        enableNetworkQualityEstimator.setClientOpaqueData(clientOpaqueData);
                    }
                    quicHint = CronetAppProviderManager.inst().getQuicHint();
                    if (quicHint != null && !quicHint.isEmpty()) {
                        for (Map.Entry<String, Pair<Integer, Integer>> entry : quicHint.entrySet()) {
                            enableNetworkQualityEstimator.addQuicHint(entry.getKey(), ((Integer) entry.getValue().first).intValue(), ((Integer) entry.getValue().second).intValue());
                        }
                    }
                    if (CronetAppProviderManager.inst().needCustomLoadLibrary()) {
                        enableNetworkQualityEstimator.setLibraryLoader(new CronetEngine.Builder.LibraryLoader() { // from class: org.chromium.CronetClient.3
                            public void loadLibrary(String str3) {
                                CronetAppProviderManager.inst().doLoadLibrary(str3);
                            }
                        });
                    }
                    cronetSoPath = CronetAppProviderManager.inst().getCronetSoPath();
                    if (!TextUtils.isEmpty(cronetSoPath)) {
                        String substring = cronetSoPath.substring(cronetSoPath.lastIndexOf(File.separator) + 1);
                        String absolutePath = context.getCacheDir().getAbsolutePath();
                        if (FileUtils.copyFile(cronetSoPath, absolutePath, substring)) {
                            enableNetworkQualityEstimator.setCronetSoPath(absolutePath + File.separator + substring);
                        }
                    }
                    isBOEProxyEnabled = CronetAppProviderManager.inst().isBOEProxyEnabled();
                    if (isBOEProxyEnabled) {
                        enableNetworkQualityEstimator.enableBoeProxy(true);
                    }
                    if (!isBOEProxyEnabled) {
                        String configFromAssets = BoeUtils.getConfigFromAssets(context, TTNET_CONFIG_FILE);
                        if (!TextUtils.isEmpty(configFromAssets)) {
                            try {
                                JSONObject jSONObject = new JSONObject(configFromAssets);
                                String optString = jSONObject.optString("ttnet_proxy", "");
                                if (!TextUtils.isEmpty(optString)) {
                                    enableNetworkQualityEstimator.setProxyConfig(optString);
                                }
                                isBOEProxyEnabled = jSONObject.optBoolean("boe_proxy_enabled", false);
                                if (isBOEProxyEnabled) {
                                    enableNetworkQualityEstimator.enableBoeProxy(true);
                                }
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                    }
                    if (!isBOEProxyEnabled && (isBOEProxyEnabled = BoeUtils.isBoeProxyEnabledByBoeFlag(context))) {
                        enableNetworkQualityEstimator.enableBoeProxy(true);
                    }
                    if (isBOEProxyEnabled) {
                        String bypassBOEJSON = CronetAppProviderManager.inst().getBypassBOEJSON();
                        if (!TextUtils.isEmpty(bypassBOEJSON)) {
                            enableNetworkQualityEstimator.setBypassBOEJSON(bypassBOEJSON);
                        }
                        String proxyConfig = getProxyConfig(str2);
                        if (!TextUtils.isEmpty(proxyConfig)) {
                            Log.e(TAG, "set proxy config: " + proxyConfig);
                            enableNetworkQualityEstimator.setProxyConfig(proxyConfig);
                        }
                    }
                    storeIdcRuleJSON = CronetAppProviderManager.inst().getStoreIdcRuleJSON();
                    if (!TextUtils.isEmpty(storeIdcRuleJSON)) {
                        enableNetworkQualityEstimator.setStoreIdcRuleJSON(storeIdcRuleJSON);
                    }
                    try {
                        aLogFuncAddr = getALogFuncAddr();
                        if (aLogFuncAddr != 0) {
                            Log.e(TAG, "set alog address: " + aLogFuncAddr);
                            enableNetworkQualityEstimator.setALogFuncAddr(aLogFuncAddr);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (convertToCronetSlaSamplingSetting != null) {
                        enableNetworkQualityEstimator.setSlaSamplingSetting(convertToCronetSlaSamplingSetting);
                    }
                    iCronetThreadStackOptFailureCheckerProvider = sCronetThreadStackOptFailureCheckerProvider;
                    if (iCronetThreadStackOptFailureCheckerProvider != null) {
                        z7 = z9;
                        threadStackInitReason = null;
                    } else {
                        threadStackInitReason = iCronetThreadStackOptFailureCheckerProvider.getThreadStackInitReason();
                        z7 = z9;
                    }
                    enableNetworkQualityEstimator.setStackInfo(z7, threadStackInitReason);
                    TTNetInitMetrics.inst().buildContextConfigEnd = System.nanoTime();
                    TTNetInitMetrics.inst().buildBuilderStart = TTNetInitMetrics.inst().buildContextConfigEnd;
                    sCronetEngine = enableNetworkQualityEstimator.build();
                    TTNetInitMetrics.inst().buildBuilderEnd = System.nanoTime();
                    if (!CronetDependManager.inst().loggerDebug()) {
                        Logger.setLogLevel(2);
                    } else {
                        Logger.setLogLevel(4);
                    }
                    if (sCronetEngine instanceof ExperimentalCronetEngine) {
                        ExperimentalCronetEngine experimentalCronetEngine = sCronetEngine;
                        try {
                            long aLogFuncAddr2 = getALogFuncAddr();
                            if (aLogFuncAddr2 != 0) {
                                Log.e(TAG, "ensure setting alog address: " + aLogFuncAddr2);
                                experimentalCronetEngine.setAlogFuncAddr(aLogFuncAddr2);
                            }
                            int appStartUpState = TTAppStateManager.getAppStartUpState();
                            if (appStartUpState >= 0 && appStartUpState <= 2) {
                                experimentalCronetEngine.setAppStartUpState(appStartUpState);
                            }
                            TTNetInitMetrics.inst().initMSSdk(context, experimentalCronetEngine.getOpaqueFuncAddress());
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
                TTRequestCompressManager.setCompressDataCallback(new TTRequestCompressManager.CompressDataCallback() { // from class: org.chromium.CronetClient.4
                    public byte[] compressData(byte[] bArr, int i, int i2, int i3) {
                        if (i3 == TTCompressManager.CompressType.BROTLI.getValue()) {
                            return TTCompressManager.compressData(bArr, i, i2, TTCompressManager.CompressType.BROTLI);
                        }
                        return null;
                    }

                    public byte[] decompressData(byte[] bArr, int i, int i2) {
                        if (i2 == TTCompressManager.CompressType.BROTLI.getValue()) {
                            return TTCompressManager.decompressData(bArr, i, TTCompressManager.CompressType.BROTLI);
                        }
                        return null;
                    }
                });
                TTNetInitMetrics.inst().createEngineEnd = System.nanoTime();
            }
        }
    }

    public static CronetEngine getCronetEngine() {
        if (sCronetEngine == null) {
            throw new NullPointerException("Cronet engine is null.");
        }
        return sCronetEngine;
    }

    public boolean isCronetHttpURLConnection(HttpURLConnection httpURLConnection) {
        return httpURLConnection instanceof CronetHttpURLConnection;
    }

    public int getCronetInternalErrorCode(HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection instanceof CronetHttpURLConnection) {
                return ((CronetHttpURLConnection) httpURLConnection).getCronetInternalErrorCode();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void triggerGetDomain(boolean z) {
        try {
            if (CronetDependManager.inst().loggerDebug()) {
                CronetDependManager.inst().loggerD(TAG, "triggerGetDomain start");
            }
            if (sCronetEngine instanceof ExperimentalCronetEngine) {
                sCronetEngine.triggerGetDomain(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void runInBackGround(boolean z) {
        try {
            if (CronetDependManager.inst().loggerDebug()) {
                CronetDependManager.inst().loggerD(TAG, "runInBackGround start");
            }
            if (sCronetEngine instanceof ExperimentalCronetEngine) {
                sCronetEngine.runInBackGround(z);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void addClientOpaqueData(String[] strArr, byte[] bArr, byte[] bArr2, long j, long j2) {
        try {
            if (CronetDependManager.inst().loggerDebug()) {
                CronetDependManager.inst().loggerD(TAG, "addClientOpaqueData start");
            }
            if (sCronetEngine instanceof ExperimentalCronetEngine) {
                sCronetEngine.addClientOpaqueData(strArr, bArr, bArr2, j, j2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void clearClientOpaqueData() {
        try {
            if (CronetDependManager.inst().loggerDebug()) {
                CronetDependManager.inst().loggerD(TAG, "clearClientOpaqueData start");
            }
            if (sCronetEngine instanceof ExperimentalCronetEngine) {
                sCronetEngine.clearClientOpaqueData();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeClientOpaqueData(String str) {
        try {
            if (CronetDependManager.inst().loggerDebug()) {
                CronetDependManager.inst().loggerD(TAG, "removeClientOpaqueData start");
            }
            if (sCronetEngine instanceof ExperimentalCronetEngine) {
                sCronetEngine.removeClientOpaqueData(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public TTDispatchResult ttUrlDispatch(String str, int i, boolean z) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            Map ttUrlDispatch = sCronetEngine.ttUrlDispatch(str, i, z);
            String str2 = (String) ttUrlDispatch.get("final_url");
            if (TextUtils.isEmpty(str2)) {
                throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
            }
            new URL(str2).toURI();
            return new TTDispatchResult(str, str2, (String) ttUrlDispatch.get("epoch"), (String) ttUrlDispatch.get("etag"), TTDispatchResult.DispatchState.SUCCESS, (String) ttUrlDispatch.get("ttnet_origin_host"));
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void preconnectUrl(String str, Map<String, String> map) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.preconnectUrl(str, 1, map);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void tryStartNetDetect(String[] strArr, int i, int i2) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.tryStartNetDetect(strArr, i, i2);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void ttDnsResolve(String str, int i, String str2, Map<String, String> map) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.ttDnsResolve(str, i, str2, map);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void getMappingRequestState(final String str) {
        try {
            CronetUrlRequest GetRequest = CronetUrlRequestMapping.GetRequest(str);
            if (GetRequest != null) {
                GetRequest.getStatus(new UrlRequest.StatusListener() { // from class: org.chromium.CronetClient.5
                    public void onStatus(int i) {
                        CronetEventListener.inst().onMappingRequestStatus(str, i);
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getEffectiveConnectionType() throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            return sCronetEngine.getEffectiveConnectionType();
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void notifyTNCConfigUpdated(String str, String str2, String str3, String str4, String str5, String str6) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.notifyTNCConfigUpdated(str, str2, str3, str4, str5, str6);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void notifyStoreRegionUpdated(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.updateStoreRegionFromServer(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void setProxy(String str) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.setProxy(str);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public NetworkQuality getNetworkQuality() throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            ExperimentalCronetEngine experimentalCronetEngine = sCronetEngine;
            NetworkQuality networkQuality = new NetworkQuality();
            networkQuality.transportRttMs = experimentalCronetEngine.getTransportRttMs();
            networkQuality.httpRttMs = experimentalCronetEngine.getHttpRttMs();
            networkQuality.downstreamThroughputKbps = experimentalCronetEngine.getDownstreamThroughputKbps();
            return networkQuality;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public PacketLossMetrics getPacketLossRateMetrics(int i) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            PacketLossMetrics packetLossMetrics = new PacketLossMetrics();
            ExperimentalCronetEngine experimentalCronetEngine = sCronetEngine;
            packetLossMetrics.protocol = i;
            packetLossMetrics.upstreamLossRate = experimentalCronetEngine.getUpstreamPacketLossRate(i);
            packetLossMetrics.upstreamLossRateVariance = experimentalCronetEngine.getUpstreamPacketLossRateVariance(i);
            packetLossMetrics.downstreamLossRate = experimentalCronetEngine.getDownstreamPacketLossRate(i);
            packetLossMetrics.downstreamLossRateVariance = experimentalCronetEngine.getDownstreamPacketLossRateVariance(i);
            return packetLossMetrics;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            ExperimentalCronetEngine experimentalCronetEngine = sCronetEngine;
            HashMap hashMap = new HashMap();
            for (Map.Entry entry : experimentalCronetEngine.getGroupRttEstimates().entrySet()) {
                if (((int[]) entry.getValue()).length != 2) {
                    throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
                }
                NetworkQuality networkQuality = new NetworkQuality();
                networkQuality.transportRttMs = ((int[]) entry.getValue())[0];
                networkQuality.httpRttMs = ((int[]) entry.getValue())[1];
                networkQuality.downstreamThroughputKbps = -1;
                hashMap.put((String) entry.getKey(), networkQuality);
            }
            return hashMap;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void setHostResolverRules(String str) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.setHostResolverRules(str);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void setAlogFuncAddr(long j) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.setAlogFuncAddr(j);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void setZstdFuncAddr(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.setZstdFuncAddr(j, j2, j3, j4, j5, j6, j7, j8);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void startThrottle(String[] strArr, int i, long j) {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.startThrottle(strArr, i, j);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void stopThrottle(String[] strArr, int i) {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.stopThrottle(strArr, i);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void setBestHostWithRouteSelectionName(String str, String str2) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.setRouteSelectionBestHost(str, str2);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void setCookieInitCompleted() {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.setCookieInitCompleted();
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public int getNetworkQualityLevel() throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            return sCronetEngine.getNetworkQualityLevel();
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public int getEffectiveHttpRttMs() throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            return sCronetEngine.getEffectiveHttpRtt();
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public int getEffectiveTransportRttMs() throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            return sCronetEngine.getEffectiveTransportRtt();
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public int getEffectiveRxThroughputKbps() throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            return sCronetEngine.getEffectiveRxThroughput();
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void reportNetDiagnosisUserLog(String str) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.reportNetDiagnosisUserLog(str);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void enableTTBizHttpDns(boolean z, String str, String str2, String str3, boolean z2, String str4) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.enableTTBizHttpDns(z, str, str2, str3, z2, str4);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void bindBigCore(TTNetThreadConfig.ThreadType threadType) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.bindBigCore(threadType.ordinal());
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void bindLittleCore(TTNetThreadConfig.ThreadType threadType) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.bindLittleCore(threadType.ordinal());
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void resetCoreBind(TTNetThreadConfig.ThreadType threadType) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.resetCoreBind(threadType.ordinal());
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void setSlaSamplingSetting(JSONObject jSONObject) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            if (sAppID <= 0) {
                sAppID = Integer.parseInt(CronetAppProviderManager.inst().getAppId());
            }
            TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting = convertToCronetSlaSamplingSetting(SlaSamplingSettingCreator.create(jSONObject, sAppID));
            if (convertToCronetSlaSamplingSetting == null) {
                return;
            }
            sCronetEngine.addSamplingSetting(convertToCronetSlaSamplingSetting);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public void setAppStartUpState(int i) throws Exception {
        if (sCronetEngine instanceof ExperimentalCronetEngine) {
            sCronetEngine.setAppStartUpState(i);
            return;
        }
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static long getALogFuncAddr() throws Exception {
        return ((Long) ReflectWrap.on(Class.forName(TTNET_ALOG_CLASS).newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private static boolean getListenAppStateIndependently() {
        try {
            return ((Boolean) ReflectWrap.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    private static String getDomainConfigByRegion() {
        String carrierRegion = CronetAppProviderManager.inst().getCarrierRegion();
        String sysRegion = CronetAppProviderManager.inst().getSysRegion();
        String region = CronetAppProviderManager.inst().getRegion();
        if (TextUtils.isEmpty(carrierRegion)) {
            carrierRegion = !TextUtils.isEmpty(sysRegion) ? sysRegion : region;
        }
        if (TextUtils.isEmpty(carrierRegion)) {
            return null;
        }
        try {
            return (String) ReflectWrap.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{carrierRegion}).get();
        } catch (Exception unused) {
            return null;
        }
    }

    private static long getMaxHttpDiskCacheSize() {
        try {
            return ((Long) ReflectWrap.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getMaxHttpDiskCacheSize").get()).longValue();
        } catch (Exception unused) {
            return 67108864L;
        }
    }

    private static JSONObject getSlaSamplingSetting() {
        try {
            return (JSONObject) ReflectWrap.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getSlaSamplingSetting").get();
        } catch (Exception unused) {
            return null;
        }
    }

    private static int getAppSecurityLevel() {
        try {
            return ((Integer) ReflectWrap.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getAppSecurityLevel").get()).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private static ArrayList<TTNetThreadConfig> getThreadConfigInfoList() {
        try {
            return (ArrayList) ReflectWrap.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigInfoList").get();
        } catch (Exception unused) {
            return null;
        }
    }

    private static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        try {
            return (TTNetThreadConfig.Callback) ReflectWrap.on(Class.forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigCallbackImpl").get();
        } catch (Exception unused) {
            return null;
        }
    }

    private String getProxyConfig(String str) {
        Throwable th;
        BufferedReader bufferedReader;
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    File file = new File(str + TTNET_CONFIG_FILE);
                    if (file.exists()) {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            str2 = new JSONObject(sb.toString()).optString("ttnet_proxy", "");
                            bufferedReader2 = bufferedReader;
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                th.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return str2;
                            } catch (Throwable th3) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
            }
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
        }
        return str2;
    }
}
