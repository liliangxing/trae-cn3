package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.service.INewUserModeService;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.LocalConstants;
import com.bytedance.bdinstall.util.NetworkStatusProvider;
import com.bytedance.bdinstall.util.OptionsForCommonParamProxy;
import com.bytedance.bdinstall.util.RomUtils;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.bdinstall.util.UIUtils;
import com.bytedance.bdturing.utils.Consts;
import com.bytedance.common.utility.NetworkUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApiParamsUtil {
    private final IBDInstallApi installApi;
    private IExtraParams sExtraParams;
    private NetworkStatusProvider sNetworkProvider;
    private volatile boolean sStarted = false;
    private int sParamCount = 36;
    private final Map<String, String> sCustomParam = new ConcurrentHashMap();
    private final Map<String, String> sL0OnlyParams = new ConcurrentHashMap();

    public ApiParamsUtil(IBDInstallApi iBDInstallApi) {
        this.installApi = iBDInstallApi;
    }

    public void setExtraParams(IExtraParams iExtraParams) {
        if (this.sExtraParams != null || iExtraParams == null) {
            return;
        }
        this.sExtraParams = iExtraParams;
    }

    public void setNetworkProvider(NetworkStatusProvider networkStatusProvider) {
        this.sNetworkProvider = networkStatusProvider;
    }

    public String appendNetParams(Context context, StringBuilder sb, String str, boolean z, Level level) {
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return sb2;
        }
        Uri parse = Uri.parse(sb2);
        Set<String> queryParameterNames = parse.getQueryParameterNames();
        Uri.Builder buildUpon = parse.buildUpon();
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sParamCount);
        appendParamsToMap(context, z, str, linkedHashMap, level);
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!queryParameterNames.contains(key) && !TextUtils.isEmpty(value)) {
                buildUpon.appendQueryParameter(key, entry.getValue());
            }
        }
        sb.delete(0, sb.length());
        sb.append(buildUpon.build().toString());
        this.sParamCount = linkedHashMap.size();
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void appendParamsToMap(Context context, boolean z, String str, Map<String, String> map, Level level) {
        INewUserModeService iNewUserModeService;
        if (map == null) {
            return;
        }
        map.put("device_platform", Consts.OS_NAME);
        addCommonParam(map);
        if (z) {
            map.put(Api.KEY_SSMIX, "a");
        }
        map.put(Api.KEY_RTICKET, String.valueOf(System.currentTimeMillis()));
        InstallOptions installOptions = this.installApi.getInstallOptions();
        AppContext appContext = this.installApi.getAppContext();
        String str2 = Cdid.get(installOptions);
        if (TextUtils.isEmpty(str2) && appContext != 0 && appContext.isMainInstance()) {
            str2 = Cdid.getMainInstanceCdid(context);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put(Cdid.KEY_CDID, str2);
        }
        HashMap<String, String> hashMap = null;
        OptionsForCommonParamProxy optionsForCommonParamProxy = installOptions != null ? new OptionsForCommonParamProxy(installOptions) : null;
        if (optionsForCommonParamProxy == null && appContext != 0) {
            optionsForCommonParamProxy = new OptionsForCommonParamProxy(appContext);
        }
        if (optionsForCommonParamProxy != null) {
            String channel = optionsForCommonParamProxy.getChannel();
            if (!TextUtils.isEmpty(channel)) {
                map.put("channel", channel);
            }
            if (str != null) {
                map.put("aid", str);
            } else {
                map.put("aid", String.valueOf(optionsForCommonParamProxy.getAid()));
            }
            String appName = optionsForCommonParamProxy.getAppName();
            if (appName != null) {
                map.put(Api.KEY_APP_NAME, appName);
            } else {
                DrLog.ysnp(new IllegalArgumentException("app_name is null"));
            }
            map.put("version_code", String.valueOf(optionsForCommonParamProxy.getVersionCode()));
            String version = optionsForCommonParamProxy.getVersion();
            if (version != null) {
                map.put("version_name", version);
            }
            map.put("manifest_version_code", String.valueOf(optionsForCommonParamProxy.getManifestVersionCode()));
            map.put("update_version_code", String.valueOf(optionsForCommonParamProxy.getUpdateVersionCode()));
        }
        IAbContext abContext = installOptions != null ? installOptions.getAbContext() : null;
        if (abContext != null) {
            appContext = abContext;
        }
        if (appContext != 0) {
            String abVersion = appContext.getAbVersion();
            if (!TextUtils.isEmpty(abVersion)) {
                map.put("ab_version", abVersion);
            }
            String abClient = appContext.getAbClient();
            if (!TextUtils.isEmpty(abClient)) {
                map.put(Api.KEY_AB_CLIENT, abClient);
            }
            String abGroup = appContext.getAbGroup();
            if (!TextUtils.isEmpty(abGroup)) {
                map.put(Api.KEY_AB_GROUP, abGroup);
            }
            String abFeature = appContext.getAbFeature();
            if (!TextUtils.isEmpty(abFeature)) {
                map.put(Api.KEY_AB_FEATURE, abFeature);
            }
            long abFlag = appContext.getAbFlag();
            if (abFlag > 0) {
                map.put(Api.KEY_ABFLAG, String.valueOf(abFlag));
            }
        }
        if (installOptions != null && (iNewUserModeService = (INewUserModeService) ServiceManager.getService(INewUserModeService.class, String.valueOf(installOptions.getAid()))) != null) {
            iNewUserModeService.mapCustomParams(map);
        }
        String screenResolution = UIUtils.getScreenResolution(context);
        if (!TextUtils.isEmpty(screenResolution)) {
            map.put("resolution", screenResolution);
        }
        int dpi = UIUtils.getDpi(context);
        if (dpi > 0) {
            map.put(Api.KEY_DPI, String.valueOf(dpi));
        }
        map.put(Api.KEY_DEVICE_TYPE, Build.BRAND.equals("Pico") ? RomUtils.getProductName() : Build.MODEL);
        map.put("device_brand", Build.BRAND);
        map.put(Api.KEY_LANGUAGE, Locale.getDefault().getLanguage());
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        try {
            String str3 = Build.VERSION.RELEASE;
            if (str3 != null && str3.length() > 10) {
                str3 = str3.substring(0, 10);
            }
            map.put("os_version", str3);
        } catch (Exception unused) {
        }
        NetworkStatusProvider networkStatusProvider = this.sNetworkProvider;
        if (networkStatusProvider != null) {
            String name = networkStatusProvider.getNetworkType().name();
            if (!TextUtils.isEmpty(name)) {
                map.put("ac", name);
                DrLog.m139d("NetworkStatusProvider network type is " + name);
            }
        } else {
            String networkAccessType = NetworkUtils.getNetworkAccessType(context);
            if (!TextUtils.isEmpty(networkAccessType)) {
                map.put("ac", networkAccessType);
                DrLog.m139d("NetworkUtils network type is " + networkAccessType);
            }
        }
        copyMap(this.sCustomParam, map, false);
        if (level == Level.L0) {
            copyMap(this.sL0OnlyParams, map, false);
        }
        try {
            IExtraParams iExtraParams = this.sExtraParams;
            if (iExtraParams != null) {
                hashMap = iExtraParams.getExtraParams(level);
            }
            copyMap(hashMap, map, true);
        } catch (Exception e) {
            DrLog.ysnp(e);
        }
        boolean isMainProcess = Utils.isMainProcess(context);
        InstallInfo installInfo = this.installApi.getInstallInfo();
        if (started(context, installOptions, isMainProcess, installInfo)) {
            if (installInfo != null) {
                if (!TextUtils.isEmpty(installInfo.getEDid())) {
                    map.put(Api.KEY_ENCRYPT_DID, installInfo.getEDid());
                }
                if (!TextUtils.isEmpty(installInfo.getEIid())) {
                    map.put(Api.KEY_ENCRYPT_IID, installInfo.getEIid());
                }
                if (!TextUtils.isEmpty(installInfo.getIid())) {
                    map.put("iid", installInfo.getIid());
                }
                if (!TextUtils.isEmpty(installInfo.getDid())) {
                    map.put("device_id", installInfo.getDid());
                }
                if (!TextUtils.isEmpty(installInfo.getEgdi())) {
                    map.put(Api.KEY_KLINK_EGDI, installInfo.getEgdi());
                }
                if (level == Level.L0) {
                    String openUdid = installInfo.getOpenUdid();
                    if (!TextUtils.isEmpty(openUdid)) {
                        map.put("openudid", openUdid);
                    }
                }
            }
            if (level == Level.L0) {
                ApiParamsForFlavor.addSstParams(context, map, isMainProcess, installOptions);
            }
        }
        ApiParamsForFlavor.addCommonParams(isMainProcess, context, installOptions);
        IParamFilter paramsFilter = this.installApi.getParamsFilter();
        if (paramsFilter != null) {
            paramsFilter.filterCommonParams(map);
        }
    }

    public void addCustomParamsWithLevel(String str, String str2, Level level) {
        if (level == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        int i = C05061.$SwitchMap$com$bytedance$bdinstall$Level[level.ordinal()];
        if (i == 1) {
            this.sL0OnlyParams.put(str, str2);
        } else {
            if (i != 2) {
                return;
            }
            this.sCustomParam.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.bdinstall.ApiParamsUtil$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static /* synthetic */ class C05061 {
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

    public void removeCustomParamsWithLevel(String str, Level level) {
        if (level == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = C05061.$SwitchMap$com$bytedance$bdinstall$Level[level.ordinal()];
        if (i == 1) {
            this.sL0OnlyParams.remove(str);
        } else {
            if (i != 2) {
                return;
            }
            this.sCustomParam.remove(str);
        }
    }

    private boolean started(Context context, InstallOptions installOptions, boolean z, InstallInfo installInfo) {
        if (!z) {
            return (installInfo == null || TextUtils.isEmpty(installInfo.getDid()) || TextUtils.isEmpty(installInfo.getIid())) ? false : true;
        }
        boolean z2 = this.sStarted;
        if (!z2 && (z2 = LocalConstants.getCommonSp(context, installOptions).getBoolean(Api.KEY_STARTED, false))) {
            this.sStarted = true;
        }
        return z2;
    }

    private void addCommonParam(Map<String, String> map) {
        map.put("os", RomUtils.isHarmonyUI() ? "harmony" : Consts.OS_NAME);
        try {
            if (RomUtils.isHarmonyUI()) {
                map.put("sub_os_api", String.valueOf(SystemPropertiesWithCache.get("hw_sc.build.os.apiversion")));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void copyMap(Map<String, String> map, Map<String, String> map2, boolean z) {
        if (map != null) {
            try {
                if (map.isEmpty()) {
                    return;
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value) && (!z || !map2.containsKey(key))) {
                            map2.put(key, value);
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
