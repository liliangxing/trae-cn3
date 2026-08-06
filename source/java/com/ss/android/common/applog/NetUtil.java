package com.ss.android.common.applog;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.CompressResult;
import com.bytedance.applog.ILogCompressor;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.AppContext;
import com.ss.android.common.util.BDNetworkTagManagerHelper;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetUtil {
    private static final String TAG = "AppLog";
    private static AppContext sAppContext;
    private static final ConcurrentHashMap<String, String> sCustomParam = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> sL0OnlyParams = new ConcurrentHashMap<>();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IAppParam {
        void getSSIDs(Context context, Map<String, String> map);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IExtraParams {
        HashMap<String, String> getExtrparams(Level level);
    }

    @Deprecated
    public static int checkHttpRequestException(Throwable th, String[] strArr) {
        return 1;
    }

    public static String doPost(ILogCompressor iLogCompressor, String str, byte[] bArr, boolean z, String str2, boolean z2, Map<String, String> map, boolean z3, boolean z4) throws CommonHttpException {
        boolean z5;
        CompressResult compress;
        HashMap hashMap = new HashMap();
        if (!StringUtils.isEmpty(str2)) {
            hashMap.put("Content-Type", str2);
        }
        if (z) {
            if (iLogCompressor == null || !str.contains(UrlConfig.PATH_APP_LOG) || (compress = iLogCompressor.compress(bArr)) == null || compress.getData() == null) {
                z5 = false;
            } else {
                bArr = compress.getData();
                if (compress.getHeaders() != null && !compress.getHeaders().isEmpty()) {
                    hashMap.putAll(compress.getHeaders());
                }
                z5 = true;
            }
            if (!z5) {
                try {
                    bArr = NetworkClient.compressWithgzip(bArr);
                    hashMap.put("Content-Encoding", DownloadHelper.GZIP);
                } catch (Exception e) {
                    throw new CommonHttpException(0, e.getMessage());
                }
            }
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        if (!z4) {
            BDNetworkTagManagerHelper.addHeader(hashMap, z3);
        }
        NetworkClient.ReqContext reqContext = new NetworkClient.ReqContext();
        reqContext.addCommonParams = z2;
        return NetworkClient.getDefault().post(str, bArr, hashMap, reqContext);
    }

    public static void setParamsFilter(IParamFilter iParamFilter) {
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            BDInstall.setParamsFilter(iParamFilter);
        } else {
            NetUtilWrapper.setParamsFilter(iParamFilter);
        }
    }

    public static void setAppParam(IAppParam iAppParam) {
        NetUtilWrapper.setAppParam(iAppParam);
    }

    public static void setExtraparams(final IExtraParams iExtraParams) {
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            BDInstall.setCommonExtraParam(new com.bytedance.bdinstall.IExtraParams() { // from class: com.ss.android.common.applog.NetUtil.1
                public HashMap<String, String> getExtraParams(Level level) {
                    HashMap<String, String> extrparams;
                    HashMap<String, String> hashMap = new HashMap<>(NetUtil.sCustomParam);
                    if (level == Level.L0) {
                        NetUtilWrapper.copyMap(NetUtil.sL0OnlyParams, hashMap);
                    }
                    IExtraParams iExtraParams2 = IExtraParams.this;
                    if (iExtraParams2 != null && (extrparams = iExtraParams2.getExtrparams(level)) != null) {
                        hashMap.putAll(extrparams);
                    }
                    return hashMap;
                }
            });
        } else {
            NetUtilWrapper.setExtraparams(iExtraParams);
        }
    }

    public static void setAppContext(AppContext appContext) {
        sAppContext = appContext;
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            DeviceRegisterManager.getBdtrackerImpl().setAppContext(appContext);
        } else {
            NetUtilWrapper.setAppContext(appContext);
        }
    }

    @Deprecated
    public static void appendCommonParams(StringBuilder sb, boolean z) {
        appendCommonParamsWithLevel(sb, z, Level.L0);
    }

    @Deprecated
    public static void putCommonParams(Map<String, String> map, boolean z) {
        putCommonParamsWithLevel(map, z, Level.L0);
    }

    @Deprecated
    public static String addCommonParams(String str, boolean z) {
        return addCommonParamsWithLevel(str, z, Level.L0);
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

    public static void activePutCommonParams(StringBuilder sb, Map<String, String> map) {
        Uri parse = Uri.parse(sb.toString());
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Uri.Builder buildUpon = parse.buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!queryParameterNames.contains(key) && !TextUtils.isEmpty(value)) {
                buildUpon.appendQueryParameter(key, entry.getValue());
            }
        }
        sb.delete(0, sb.length());
        sb.append(buildUpon.build().toString());
    }

    public static void putCommonParamsWithLevel(Map<String, String> map, boolean z, Level level) {
        AppContext appContext = sAppContext;
        if (appContext == null) {
            return;
        }
        Context context = appContext.getContext();
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            BDInstall.putCommonParams(context, map, z, level);
        } else {
            NetUtilWrapper.putCommonParamsWithLevel(map, z, level);
        }
    }

    @Deprecated
    public static void addCustomParams(String str, String str2) {
        addCustomParamsWithLevel(str, str2, Level.L1);
    }

    public static void removeCustomParams(String str) {
        removeCustomParamsWithLevel(str, Level.L1);
    }

    public static void addCustomParamsWithLevel(String str, String str2, Level level) {
        if (level == null || StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return;
        }
        if (DeviceRegisterManager.getSwitchToBdtracker()) {
            BDInstall.addCustomParamsWithLevel(str, str2, level);
            return;
        }
        int i = C03862.$SwitchMap$com$bytedance$bdinstall$Level[level.ordinal()];
        if (i == 1) {
            sL0OnlyParams.put(str, str2);
        } else if (i == 2) {
            sCustomParam.put(str, str2);
        }
        NetUtilWrapper.addCustomParamsWithLevel(str, str2, level);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.common.applog.NetUtil$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C03862 {
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
        int i = C03862.$SwitchMap$com$bytedance$bdinstall$Level[level.ordinal()];
        if (i == 1) {
            sL0OnlyParams.remove(str);
        } else if (i == 2) {
            sCustomParam.remove(str);
        }
        NetUtilWrapper.removeCustomParamsWithLevel(str, level);
    }

    public static boolean isBadId(String str) {
        if (StringUtils.isEmpty(str) || str.equalsIgnoreCase("unknown") || str.equalsIgnoreCase("None")) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }

    public static void setAliYunHanlder(IAliYunHandler iAliYunHandler) {
        NetUtilWrapper.setAliYunHanlder(iAliYunHandler);
    }

    public static String getAliyunUuid() {
        return NetUtilWrapper.getAliyunUuid();
    }

    public static String sendEncryptLog(ILogCompressor iLogCompressor, String str, byte[] bArr, Context context, boolean z, String[] strArr, Map<String, String> map, String str2, boolean z2, boolean z3) throws Exception {
        return NetUtilWrapper.sendEncryptLog(iLogCompressor, str, bArr, context, z, strArr, map, str2, z2, z3);
    }
}
