package com.ss.android.common.applog;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.applog.CompressResult;
import com.bytedance.applog.ILogCompressor;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;
import com.ss.android.common.AppContext;
import com.ss.android.common.applog.NetUtil;
import com.ss.android.common.util.BDNetworkTagManagerHelper;
import com.ss.android.common.util.TLog;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.INewUserModeManager;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.base.DrHelperWithRegion;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.core.PrivateAgreement;
import com.ss.android.deviceregister.core.cache.internal.EncryptUtils;
import com.ss.android.deviceregister.service.ServiceManager;
import com.ss.android.deviceregister.utils.Cdid;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ttm.player.MediaFormat;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPOutputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetUtilWrapper {
    private static final String APP_LOG_ENCRYPT_FAILD_COUNT = "app_log_encrypt_faild_count";
    private static final String TAG = "AppLog";
    private static IAliYunHandler sAliYunHandler;
    private static NetUtil.IAppParam sAppParam;
    private static volatile int sEncryptFaildCount;
    private static volatile NetUtil.IExtraParams sExtraparams;
    private static IParamFilter sFilter;
    private static volatile boolean sIsReadConfigFromSP;
    private static volatile boolean sIsWriteConfigSP;
    private static INetworkProvider sNetworkProvider;
    private static final String KEY_TT_DATA = "tt_data";
    public static final String[] KEYS_PLAINTEXT = {"aid", "app_version", KEY_TT_DATA, "device_id"};
    private static final String KEY_DEVICE_PLATFORM = "device_platform";
    private static final String KEY_IID = "iid";
    public static final String[] KEYS_CONFIG_QUERY = {KEY_TT_DATA, KEY_DEVICE_PLATFORM, "aid", "device_id", KEY_IID};
    private static final String KEY_AB_VERSION = "ab_version";
    public static final String[] KEYS_REPORT_QUERY = {"aid", "version_code", KEY_AB_VERSION, "device_id", KEY_IID, KEY_DEVICE_PLATFORM};
    private static AppContext sAppContext = null;
    private static Object mLock = new Object();
    private static volatile String APP_LOG_ENCRYPT_COUNT = "app_log_encrypt_switch_count";
    private static final ConcurrentHashMap<String, String> sCustomParam = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> sL0OnlyParams = new ConcurrentHashMap<>();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface INetworkProvider {
        NetworkUtils.NetworkType getNetworkType();
    }

    @Deprecated
    public static int checkHttpRequestException(Throwable th, String[] strArr) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAppParam(NetUtil.IAppParam iAppParam) {
        sAppParam = iAppParam;
    }

    public static void setNetworkProvider(INetworkProvider iNetworkProvider) {
        sNetworkProvider = iNetworkProvider;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setExtraparams(NetUtil.IExtraParams iExtraParams) {
        if (sExtraparams != null || iExtraParams == null) {
            return;
        }
        sExtraparams = iExtraParams;
    }

    public static void setAppContext(AppContext appContext) {
        sAppContext = appContext;
    }

    public static void appendCommonParamsWithLevel(StringBuilder sb, boolean z, Level level) {
        if (sAppContext == null || sb == null) {
            return;
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        Uri parse = Uri.parse(sb2);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Uri.Builder buildUpon = parse.buildUpon();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        putCommonParamsWithLevel(linkedHashMap, z, level);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!queryParameterNames.contains(str) && !TextUtils.isEmpty(str2)) {
                buildUpon.appendQueryParameter(str, (String) entry.getValue());
            }
        }
        sb.delete(0, sb.length());
        sb.append(buildUpon.build().toString());
    }

    public static String addCommonParamsWithLevel(String str, boolean z, Level level) {
        AppContext appContext = sAppContext;
        if (StringUtils.isEmpty(str) || appContext == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        appendCommonParamsWithLevel(sb, z, level);
        return sb.toString();
    }

    public static void putCommonParamsWithLevel(Map<String, String> map, boolean z, Level level) {
        INewUserModeManager iNewUserModeManager;
        HashMap<String, String> extrparams;
        AppContext appContext = sAppContext;
        if (map == null || appContext == null || level == null) {
            return;
        }
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            BDInstall.putCommonParams(appContext.getContext(), map, z, level);
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            if (ToolUtils.isMessageProcess(appContext.getContext())) {
                NetUtil.IAppParam iAppParam = sAppParam;
                if (iAppParam != null) {
                    iAppParam.getSSIDs(appContext.getContext(), hashMap);
                }
                if (Logger.debug()) {
                    TLog.m73d("PushService idmap = " + StringUtils.mapToString(hashMap));
                }
            } else {
                DeviceRegisterManager.getSSIDs(hashMap);
            }
        } catch (Exception unused) {
            DeviceRegisterManager.getSSIDs(hashMap);
        }
        String str = (String) hashMap.get(AppLogConstants.KLINK_EGDI);
        if (!StringUtils.isEmpty(str)) {
            map.put(AppLogConstants.KLINK_EGDI, str);
        }
        String str2 = (String) hashMap.get("install_id");
        if (!StringUtils.isEmpty(str2)) {
            map.put(KEY_IID, str2);
        }
        String str3 = (String) hashMap.get("device_id");
        if (!StringUtils.isEmpty(str3)) {
            map.put("device_id", str3);
        }
        Context context = appContext.getContext();
        if (context != null) {
            INetworkProvider iNetworkProvider = sNetworkProvider;
            if (iNetworkProvider != null) {
                String name = iNetworkProvider.getNetworkType().name();
                if (!StringUtils.isEmpty(name)) {
                    map.put("ac", name);
                    if (Logger.debug()) {
                        TLog.m73d("NetUtil get access from broad receiver " + name);
                    }
                }
            } else {
                String networkAccessType = NetworkUtils.getNetworkAccessType(context);
                if (!StringUtils.isEmpty(networkAccessType)) {
                    map.put("ac", networkAccessType);
                    if (Logger.debug()) {
                        TLog.m73d("NetUtil get access from access " + networkAccessType);
                    }
                }
            }
        }
        boolean hasAccept = PrivateAgreement.hasAccept(context);
        String tweakedChannel = appContext.getTweakedChannel();
        if (tweakedChannel != null) {
            map.put("channel", tweakedChannel);
        }
        map.put("aid", String.valueOf(appContext.getAid()));
        String appName = appContext.getAppName();
        if (appName != null) {
            map.put("app_name", appName);
        }
        map.put("version_code", String.valueOf(appContext.getVersionCode()));
        map.put("version_name", appContext.getVersion());
        map.put(KEY_DEVICE_PLATFORM, RomUtils.OS_ANDROID);
        appendCommonParam(map);
        String abVersion = appContext.getAbVersion();
        if (!StringUtils.isEmpty(abVersion)) {
            map.put(KEY_AB_VERSION, abVersion);
        }
        String abClient = appContext.getAbClient();
        if (!StringUtils.isEmpty(abClient)) {
            map.put("ab_client", abClient);
        }
        String abGroup = appContext.getAbGroup();
        if (!StringUtils.isEmpty(abGroup)) {
            map.put("ab_group", abGroup);
        }
        String abFeature = appContext.getAbFeature();
        if (!StringUtils.isEmpty(abFeature)) {
            map.put("ab_feature", abFeature);
        }
        long abFlag = appContext.getAbFlag();
        if (abFlag > 0) {
            map.put("abflag", String.valueOf(abFlag));
        }
        if (z) {
            map.put("ssmix", "a");
        }
        map.put("device_type", Build.MODEL);
        map.put("device_brand", Build.BRAND);
        map.put(MediaFormat.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        map.put(RegistrationHeaderHelper.KEY_OS_API, String.valueOf(Build.VERSION.SDK_INT));
        try {
            String str4 = Build.VERSION.RELEASE;
            if (str4 != null && str4.length() > 10) {
                str4 = str4.substring(0, 10);
            }
            map.put(RegistrationHeaderHelper.KEY_OS_VERSION, str4);
        } catch (Exception unused2) {
        }
        if (level == Level.L0) {
            if (!DeviceRegisterManager.isChildMode()) {
                String str5 = (String) hashMap.get("openudid");
                if (!StringUtils.isEmpty(str5)) {
                    map.put("openudid", str5);
                }
            }
            IAliYunHandler iAliYunHandler = sAliYunHandler;
            if (iAliYunHandler != null) {
                String cloudUUID = iAliYunHandler.getCloudUUID();
                if (!TextUtils.isEmpty(cloudUUID)) {
                    map.put("aliyun_uuid", cloudUUID);
                }
            }
        }
        map.put("manifest_version_code", String.valueOf(appContext.getManifestVersionCode()));
        String screenResolution = UIUtils.getScreenResolution(appContext.getContext());
        if (!StringUtils.isEmpty(screenResolution)) {
            map.put("resolution", screenResolution);
        }
        int dpi = UIUtils.getDpi(appContext.getContext());
        if (dpi > 0) {
            map.put("dpi", String.valueOf(dpi));
        }
        map.put(PushCommonConstants.KEY_UPDATE_VERSION_CODE, String.valueOf(appContext.getUpdateVersionCode()));
        map.put("_rticket", String.valueOf(System.currentTimeMillis()));
        copyMap(sCustomParam, map);
        if (level == Level.L0) {
            copyMap(sL0OnlyParams, map);
        }
        try {
            if (sExtraparams != null && (extrparams = sExtraparams.getExtrparams(level)) != null && !extrparams.isEmpty()) {
                for (Map.Entry<String, String> entry : extrparams.entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value) && !map.containsKey(key)) {
                            map.put(key, value);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String str6 = Cdid.get(context);
        if (!StringUtils.isEmpty(str6)) {
            map.put(RegistrationHeaderHelper.KEY_CDID, str6);
        }
        if (level == Level.L0) {
            DrHelperWithRegion.appendCommonParam(context, appContext, map, hasAccept);
        }
        if (DeviceRegisterManager.isNewUserMode(context) && (iNewUserModeManager = (INewUserModeManager) ServiceManager.getService(INewUserModeManager.class)) != null) {
            iNewUserModeManager.mapCustomParams(map);
        }
        IParamFilter iParamFilter = sFilter;
        if (iParamFilter != null) {
            iParamFilter.filterCommonParams(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void copyMap(Map<String, String> map, Map<String, String> map2) {
        try {
            if (map.isEmpty()) {
                return;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value)) {
                        map2.put(key, value);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void addCustomParamsWithLevel(String str, String str2, Level level) {
        if (level == null || StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return;
        }
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            BDInstall.addCustomParamsWithLevel(str, str2, level);
            return;
        }
        int i = C03871.$SwitchMap$com$bytedance$bdinstall$Level[level.ordinal()];
        if (i == 1) {
            sL0OnlyParams.put(str, str2);
        } else {
            if (i != 2) {
                return;
            }
            sCustomParam.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.common.applog.NetUtilWrapper$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C03871 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bdinstall$Level;

        static {
            int[] iArr = new int[Level.values().length];
            $SwitchMap$com$bytedance$bdinstall$Level = iArr;
            try {
                iArr[Level.L0.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$bdinstall$Level[Level.L1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static void removeCustomParamsWithLevel(String str, Level level) {
        if (level == null || StringUtils.isEmpty(str)) {
            return;
        }
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            BDInstall.removeCustomParamsWithLevel(str, level);
            return;
        }
        int i = C03871.$SwitchMap$com$bytedance$bdinstall$Level[level.ordinal()];
        if (i == 1) {
            sL0OnlyParams.remove(str);
        } else {
            if (i != 2) {
                return;
            }
            sCustomParam.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setAliYunHanlder(IAliYunHandler iAliYunHandler) {
        sAliYunHandler = iAliYunHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAliyunUuid() {
        IAliYunHandler iAliYunHandler = sAliYunHandler;
        if (iAliYunHandler != null) {
            return iAliYunHandler.getCloudUUID();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String sendEncryptLog(ILogCompressor iLogCompressor, String str, byte[] bArr, Context context, boolean z, String[] strArr, Map<String, String> map, String str2, boolean z2, boolean z3) throws Exception {
        if (StringUtils.isEmpty(str) || bArr == null || bArr.length <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("log-encode-type", DownloadHelper.GZIP);
        if (str.contains(UrlConfig.PATH_APP_LOG)) {
            if (iLogCompressor != null) {
                try {
                    CompressResult compress = iLogCompressor.compress(bArr);
                    if (compress != null && compress.getData() != null) {
                        bArr = compress.getData();
                        if (compress.getHeaders() != null && !compress.getHeaders().isEmpty()) {
                            hashMap.putAll(compress.getHeaders());
                        }
                    }
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.COMPRESS_ERROR_COUNT);
                    return null;
                } catch (Throwable th) {
                    TLog.m76e("compress log data failed", th);
                }
            }
            if (bArr == null) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.COMPRESS_ERROR_COUNT);
                return null;
            }
            if (context != null) {
                addFailedCount(context);
                if (sEncryptFaildCount < 3) {
                    bArr = TTEncryptUtils.encrypt(bArr, bArr.length);
                    minusFailedCount(context);
                    if (bArr == null) {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.ENCRYPT_ERROR_COUNT);
                    }
                } else {
                    bArr = null;
                }
            } else {
                bArr = TTEncryptUtils.encrypt(bArr, bArr.length);
                if (bArr == null) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.ENCRYPT_ERROR_COUNT);
                }
            }
        } else {
            bArr = compressAndEncryptData(context, bArr, str2);
        }
        if (bArr != null) {
            String str3 = str + "&tt_data=a";
            if (z) {
                str3 = str3 + "&config_retry=b";
            }
            hashMap.remove("Content-Encoding");
            hashMap.put("Content-Type", "application/octet-stream;tt-data=a");
            if (map != null) {
                hashMap.putAll(map);
            }
            if (!z3) {
                BDNetworkTagManagerHelper.addHeader(hashMap, z2);
            }
            if (EncryptUtils.isValidKeyIv(strArr)) {
                byte[] postDataStream = NetworkClient.getDefault().postDataStream(str3, bArr, hashMap, (NetworkClient.ReqContext) null);
                if (postDataStream == null) {
                    throw new RuntimeException("get encrypted resp failed");
                }
                byte[] decryptAesCbc = EncryptUtils.decryptAesCbc(postDataStream, strArr[0], strArr[1]);
                if (decryptAesCbc == null) {
                    return new String(postDataStream);
                }
                return new String(EncryptUtils.gzipUncompress(decryptAesCbc));
            }
            return NetworkClient.getDefault().post(str3, bArr, hashMap, (NetworkClient.ReqContext) null);
        }
        throw new RuntimeException("encrypt failed");
    }

    private static byte[] compressAndEncryptData(Context context, byte[] bArr, String str) throws Exception {
        byte[] bArr2 = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (context != null) {
                addFailedCount(context);
                if (sEncryptFaildCount < 3) {
                    bArr2 = TTEncryptUtils.encrypt(byteArray, byteArray.length);
                    minusFailedCount(context);
                    if (bArr2 == null) {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.ENCRYPT_ERROR_COUNT);
                    }
                }
            } else {
                bArr2 = TTEncryptUtils.encrypt(byteArray, byteArray.length);
                if (bArr2 == null) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.ENCRYPT_ERROR_COUNT);
                }
            }
            return bArr2;
        } catch (Throwable th) {
            try {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.COMPRESS_ERROR_COUNT);
                TLog.m76e("AppLog compress with gzip exception: ", th);
                return null;
            } finally {
                gZIPOutputStream.close();
            }
        }
    }

    private static void addFailedCount(Context context) {
        if (sIsReadConfigFromSP || context == null) {
            return;
        }
        synchronized (mLock) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(APP_LOG_ENCRYPT_COUNT, 0);
                sEncryptFaildCount = sharedPreferences.getInt(APP_LOG_ENCRYPT_FAILD_COUNT, 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt(APP_LOG_ENCRYPT_FAILD_COUNT, sEncryptFaildCount + 1);
                edit.apply();
                sIsReadConfigFromSP = true;
            } catch (Throwable unused) {
            }
        }
    }

    private static void minusFailedCount(Context context) {
        if (sIsWriteConfigSP || context == null) {
            return;
        }
        synchronized (mLock) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(APP_LOG_ENCRYPT_COUNT, 0).edit();
                if (sEncryptFaildCount > 2) {
                    sEncryptFaildCount -= 2;
                } else {
                    sEncryptFaildCount = 0;
                }
                edit.putInt(APP_LOG_ENCRYPT_FAILD_COUNT, sEncryptFaildCount);
                edit.apply();
                sIsWriteConfigSP = true;
            } catch (Throwable unused) {
            }
        }
    }

    public static void setEncryptSPName(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        APP_LOG_ENCRYPT_COUNT = str;
    }

    public static String filterQuery(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        HashMap hashMap = new HashMap(strArr.length);
        for (String str2 : strArr) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                hashMap.put(str2, queryParameter);
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (String str3 : hashMap.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
        }
        return buildUpon.build().toString();
    }

    public static String encryptUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(filterQuery(str, KEYS_PLAINTEXT)).buildUpon();
        try {
            buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(compressAndEncryptData(null, Uri.parse(str).getQuery().getBytes(HTTP.UTF_8), null), 8)));
            return buildUpon.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    private static void appendCommonParam(Map<String, String> map) {
        map.put(RegistrationHeaderHelper.KEY_OS, com.ss.android.deviceregister.utils.RomUtils.isHarmonyUI() ? RomUtils.OS_HARMONY : RomUtils.OS_ANDROID);
        try {
            if (com.ss.android.deviceregister.utils.RomUtils.isHarmonyUI()) {
                map.put("sub_os_api", String.valueOf(SystemPropertiesWithCache.get("hw_sc.build.os.apiversion")));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setParamsFilter(IParamFilter iParamFilter) {
        sFilter = iParamFilter;
    }
}
