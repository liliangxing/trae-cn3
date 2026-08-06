package com.bytedance.tobshadow.applog;

import android.accounts.Account;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import com.bytedance.tobshadow.applog.network.INetworkClient;
import com.bytedance.tobshadow.applog.network.INetworkClientV2;
import com.bytedance.tobshadow.applog.store.IEventDropStrategy;
import com.bytedance.tobshadow.applog.store.p007kv.KVStoreConfig;
import com.bytedance.tobshadow.bdtracker.C0411e;
import com.bytedance.tobshadow.bdtracker.C0440i0;
import com.bytedance.tobshadow.bdtracker.C0473m5;
import com.bytedance.tobshadow.bdtracker.C0540w2;
import com.bytedance.tobshadow.bdtracker.InterfaceC0439i;
import com.bytedance.tobshadow.mpaas.IEncryptor;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class InitConfig {

    /* renamed from: A */
    public String f269A;

    /* renamed from: B */
    @Deprecated
    public String f271B;

    /* renamed from: B0 */
    public SSLSocketFactory f272B0;

    /* renamed from: C */
    public Map<String, Object> f273C;

    /* renamed from: D */
    @Deprecated
    public Account f275D;

    /* renamed from: E */
    public boolean f277E;

    /* renamed from: F */
    public INetworkClient f279F;

    /* renamed from: G */
    public INetworkClientV2 f281G;

    /* renamed from: I */
    public boolean f285I;

    /* renamed from: L0 */
    public IEventDropStrategy f292L0;

    /* renamed from: N */
    public String f294N;

    /* renamed from: O */
    public String f295O;

    /* renamed from: P */
    public ISensitiveInfoProvider f296P;

    /* renamed from: V */
    public List<String> f302V;

    /* renamed from: Z */
    public String f306Z;

    /* renamed from: a */
    public final String f307a;

    /* renamed from: a0 */
    public boolean f308a0;

    /* renamed from: b */
    public String f309b;

    /* renamed from: d */
    public String f313d;

    /* renamed from: e */
    public String f315e;

    /* renamed from: f */
    public C0440i0 f317f;

    /* renamed from: g */
    public String f319g;

    /* renamed from: h */
    public String f321h;

    /* renamed from: i */
    public ILogger f323i;

    /* renamed from: j */
    public String f325j;

    /* renamed from: k */
    @Deprecated
    public String f327k;

    /* renamed from: l */
    public IPicker f329l;

    /* renamed from: m */
    @Deprecated
    public boolean f331m;

    /* renamed from: o */
    public boolean f335o;

    /* renamed from: q */
    public String f339q;

    /* renamed from: r */
    @Deprecated
    public boolean f341r;

    /* renamed from: s */
    public String f343s;

    /* renamed from: t */
    public UriConfig f345t;

    /* renamed from: u */
    public String f347u;

    /* renamed from: v */
    @Deprecated
    public String f349v;

    /* renamed from: w */
    public int f351w;

    /* renamed from: x */
    public int f353x;

    /* renamed from: y */
    public int f355y;

    /* renamed from: z */
    @Deprecated
    public String f357z;

    /* renamed from: c */
    public boolean f311c = true;

    /* renamed from: n */
    @Deprecated
    public boolean f333n = false;

    /* renamed from: p */
    public int f337p = 0;

    /* renamed from: H */
    public boolean f283H = true;

    /* renamed from: J */
    public boolean f287J = false;

    /* renamed from: K */
    public boolean f289K = true;

    /* renamed from: L */
    public boolean f291L = true;

    /* renamed from: M */
    public boolean f293M = true;

    /* renamed from: Q */
    public boolean f297Q = true;

    /* renamed from: R */
    public boolean f298R = true;

    /* renamed from: S */
    public boolean f299S = false;

    /* renamed from: T */
    public boolean f300T = false;

    /* renamed from: U */
    public boolean f301U = false;

    /* renamed from: W */
    public boolean f303W = false;

    /* renamed from: X */
    public boolean f304X = false;

    /* renamed from: Y */
    public boolean f305Y = true;

    /* renamed from: b0 */
    public IpcDataChecker f310b0 = null;

    /* renamed from: c0 */
    @Deprecated
    public String f312c0 = null;

    /* renamed from: d0 */
    @Deprecated
    public String f314d0 = null;

    /* renamed from: e0 */
    public boolean f316e0 = true;

    /* renamed from: f0 */
    public boolean f318f0 = false;

    /* renamed from: g0 */
    public boolean f320g0 = false;

    /* renamed from: h0 */
    public boolean f322h0 = true;

    /* renamed from: i0 */
    public boolean f324i0 = true;

    /* renamed from: j0 */
    public boolean f326j0 = true;

    /* renamed from: k0 */
    public boolean f328k0 = false;

    /* renamed from: l0 */
    public boolean f330l0 = false;

    /* renamed from: m0 */
    public boolean f332m0 = false;

    /* renamed from: n0 */
    public boolean f334n0 = false;

    /* renamed from: o0 */
    public boolean f336o0 = false;

    /* renamed from: p0 */
    public boolean f338p0 = true;

    /* renamed from: q0 */
    public int f340q0 = 6;

    /* renamed from: r0 */
    public boolean f342r0 = true;

    /* renamed from: s0 */
    public boolean f344s0 = false;

    /* renamed from: t0 */
    public int f346t0 = 2000;

    /* renamed from: u0 */
    public int f348u0 = 0;

    /* renamed from: v0 */
    public Map<String, String> f350v0 = null;

    /* renamed from: w0 */
    public DynamicValueCallback<Map<String, String>> f352w0 = null;

    /* renamed from: x0 */
    public boolean f354x0 = true;

    /* renamed from: y0 */
    @Deprecated
    public boolean f356y0 = true;

    /* renamed from: z0 */
    public boolean f358z0 = true;

    /* renamed from: A0 */
    public final Set<String> f270A0 = new HashSet(4);

    /* renamed from: C0 */
    public KVStoreConfig f274C0 = KVStoreConfig.DEFAULT_CONFIG;

    /* renamed from: D0 */
    public DynamicValueCallback<String> f276D0 = null;

    /* renamed from: E0 */
    public boolean f278E0 = true;

    /* renamed from: F0 */
    public boolean f280F0 = true;

    /* renamed from: G0 */
    public boolean f282G0 = true;

    /* renamed from: H0 */
    public boolean f284H0 = true;

    /* renamed from: I0 */
    public boolean f286I0 = true;

    /* renamed from: J0 */
    public boolean f288J0 = false;

    /* renamed from: K0 */
    public boolean f290K0 = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface IpcDataChecker {
        boolean checkIpcData(String[] strArr);
    }

    public InitConfig(String str, String str2) {
        this.f307a = str;
        this.f313d = str2;
    }

    public void addLoaderFilter(String str) {
        this.f270A0.add(str);
    }

    public boolean autoStart() {
        return this.f311c;
    }

    public InitConfig clearABCacheOnUserChange(boolean z) {
        this.f305Y = z;
        return this;
    }

    public void clearDidAndIid(String str) {
        this.f277E = true;
        this.f315e = str;
    }

    public InitConfig disableDeferredALink() {
        this.f304X = false;
        return this;
    }

    public InitConfig enableDeferredALink() {
        this.f304X = true;
        return this;
    }

    public Account getAccount() {
        return this.f275D;
    }

    public String getAid() {
        String str;
        String trim = this.f307a.trim();
        if (!trim.startsWith("rangers://")) {
            return trim;
        }
        if (!TextUtils.isEmpty(this.f309b)) {
            return this.f309b;
        }
        try {
            URI uri = new URI(trim);
            String replace = uri.getPath().replace("/", "");
            String host = uri.getHost();
            if (!TextUtils.isEmpty(replace) && !TextUtils.isEmpty(host)) {
                try {
                    str = new String(Base64.decode(replace.getBytes("UTF-8"), 2));
                } catch (Throwable unused) {
                    str = "";
                }
                if (host.equalsIgnoreCase(C0473m5.m533a(str))) {
                    this.f309b = str;
                    return str;
                }
                Log.w("AppLog", "Init failed. App id can't parse! AppId: " + trim + ", parserAid: " + str + ", aidMd5: " + host);
            }
            Log.w("AppLog", "Init failed. App id can't parse! RawAppId: " + trim);
            return "";
        } catch (Throwable unused2) {
            Log.e("AppLog", "Init failed. App id parse error! AppId: " + trim);
            return "";
        }
    }

    @Deprecated
    public String getAliyunUdid() {
        return this.f327k;
    }

    @Deprecated
    public boolean getAnonymous() {
        return this.f331m;
    }

    public String getAppImei() {
        return this.f306Z;
    }

    public String getAppName() {
        return this.f343s;
    }

    public int getAutoTrackEventType() {
        return this.f340q0;
    }

    public String getChannel() {
        return this.f313d;
    }

    public String getClearKey() {
        return this.f315e;
    }

    public Map<String, Object> getCommonHeader() {
        return this.f273C;
    }

    public DynamicValueCallback<String> getCustomOaidCallback() {
        return this.f276D0;
    }

    public String getDbName() {
        return TextUtils.isEmpty(this.f294N) ? C0411e.m347a((Object) getAid()) + "@bd_tea_agent.db" : this.f294N;
    }

    public IEncryptor getEncryptor() {
        return this.f317f;
    }

    public IEventDropStrategy getEventDropStrategy() {
        return this.f292L0;
    }

    public int getGaidTimeOutMilliSeconds() {
        return this.f346t0;
    }

    public String getGoogleAid() {
        return this.f319g;
    }

    public List<String> getH5BridgeAllowlist() {
        return this.f302V;
    }

    public DynamicValueCallback<Map<String, String>> getHttpHeaderCallback() {
        return this.f352w0;
    }

    @Deprecated
    public Map<String, String> getHttpHeaders() {
        return this.f350v0;
    }

    public IpcDataChecker getIpcDataChecker() {
        return this.f310b0;
    }

    public KVStoreConfig getKvStoreConfig() {
        return this.f274C0;
    }

    public String getLanguage() {
        return this.f321h;
    }

    public Set<String> getLoaderFilters() {
        return this.f270A0;
    }

    @Deprecated
    public boolean getLocalTest() {
        return this.f333n;
    }

    public ILogger getLogger() {
        return this.f323i;
    }

    @Deprecated
    public String getManifestVersion() {
        return this.f357z;
    }

    public int getManifestVersionCode() {
        return this.f355y;
    }

    public INetworkClient getNetworkClient() {
        return this.f279F;
    }

    public INetworkClientV2 getNetworkClientV2() {
        return this.f281G;
    }

    @Deprecated
    public boolean getNotReuqestSender() {
        return this.f341r;
    }

    public IPicker getPicker() {
        return this.f329l;
    }

    @Deprecated
    public InterfaceC0439i getPreInstallCallback() {
        return null;
    }

    public int getProcess() {
        return this.f337p;
    }

    public String getRegion() {
        return this.f325j;
    }

    public String getReleaseBuild() {
        return this.f339q;
    }

    public ISensitiveInfoProvider getSensitiveInfoProvider() {
        return this.f296P;
    }

    public String getSpName() {
        return this.f295O;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f272B0;
    }

    public int getTrackCrashType() {
        return this.f348u0;
    }

    @Deprecated
    public String getTweakedChannel() {
        return this.f349v;
    }

    public int getUpdateVersionCode() {
        return this.f353x;
    }

    public UriConfig getUriConfig() {
        return this.f345t;
    }

    @Deprecated
    public String getUserUniqueId() {
        return this.f312c0;
    }

    @Deprecated
    public String getUserUniqueIdType() {
        return this.f314d0;
    }

    public String getVersion() {
        return this.f347u;
    }

    public int getVersionCode() {
        return this.f351w;
    }

    public String getVersionMinor() {
        return this.f269A;
    }

    @Deprecated
    public String getZiJieCloudPkg() {
        return this.f271B;
    }

    public boolean isAbEnable() {
        return this.f287J;
    }

    public boolean isAbTestExposureEventRepeatEnabled() {
        return this.f282G0;
    }

    public boolean isAndroidIdEnabled() {
        return this.f326j0;
    }

    public boolean isAutoActive() {
        return this.f283H;
    }

    public boolean isAutoTrackEnabled() {
        return this.f289K;
    }

    public boolean isAutoTrackFragmentEnabled() {
        return this.f320g0;
    }

    public boolean isCPUAbiEnabled() {
        return this.f284H0;
    }

    public boolean isClearABCacheOnUserChange() {
        return this.f305Y;
    }

    public boolean isClearDidAndIid() {
        return this.f277E;
    }

    public boolean isClickFillPagePropertiesEnable() {
        return this.f288J0;
    }

    public boolean isCongestionControlEnable() {
        return this.f293M;
    }

    public boolean isDeferredALinkEnabled() {
        return this.f304X;
    }

    public boolean isDisplayDensityAndDpiEnabled() {
        return this.f286I0;
    }

    public boolean isEventFilterEnable() {
        return this.f308a0;
    }

    public boolean isExposureEnabled() {
        return this.f328k0;
    }

    public boolean isGaidEnabled() {
        return this.f344s0;
    }

    public boolean isH5BridgeAllowAll() {
        return this.f303W;
    }

    public boolean isH5BridgeEnable() {
        return this.f299S;
    }

    public boolean isH5CollectEnable() {
        return this.f300T;
    }

    public boolean isHandleLifeCycle() {
        return this.f291L;
    }

    public boolean isHarmonyEnabled() {
        return this.f318f0;
    }

    @Deprecated
    public boolean isIccIdEnabled() {
        return false;
    }

    public boolean isImeiEnable() {
        return this.f298R;
    }

    public boolean isLaunchTerminateEnabled() {
        return this.f358z0;
    }

    public boolean isLogEnable() {
        return this.f301U;
    }

    public boolean isMacEnable() {
        return this.f297Q;
    }

    public boolean isMetaSecEnabled() {
        return this.f322h0;
    }

    public boolean isMigrateEnabled() {
        return this.f342r0;
    }

    public boolean isMonitorEnabled() {
        return this.f332m0;
    }

    public boolean isOaidEnabled() {
        return this.f324i0;
    }

    public boolean isOperatorInfoEnabled() {
        return this.f338p0;
    }

    public boolean isPageLeaveRefreshPropertiesEnable() {
        return this.f290K0;
    }

    @Deprecated
    public boolean isPageMetaAnnotationEnable() {
        return this.f356y0;
    }

    public boolean isPlayEnable() {
        return this.f335o;
    }

    public boolean isReportOaidEnable() {
        return this.f336o0;
    }

    public boolean isResponseEncryptEnabled() {
        return this.f280F0;
    }

    public boolean isScreenOrientationEnabled() {
        return this.f334n0;
    }

    public boolean isScrollObserveEnabled() {
        return this.f330l0;
    }

    public boolean isSerialNumberEnable() {
        return this.f354x0;
    }

    public boolean isSilenceInBackground() {
        return this.f285I;
    }

    public boolean isTrackEventEnabled() {
        return this.f316e0;
    }

    public boolean isUseBridgeUpdateUUIDEnabled() {
        return this.f278E0;
    }

    @Deprecated
    public InitConfig putCommonHeader(Map<String, Object> map) {
        this.f273C = map;
        return this;
    }

    public void setAbEnable(boolean z) {
        this.f287J = z;
    }

    public void setAbTestExposureEventRepeatEnabled(boolean z) {
        this.f282G0 = z;
    }

    @Deprecated
    public InitConfig setAccount(Account account) {
        this.f275D = account;
        return this;
    }

    @Deprecated
    public InitConfig setAliyunUdid(String str) {
        this.f327k = str;
        return this;
    }

    public void setAndroidIdEnabled(boolean z) {
        this.f326j0 = z;
    }

    @Deprecated
    public InitConfig setAnonymous(boolean z) {
        this.f331m = z;
        return this;
    }

    public void setAppImei(String str) {
        this.f306Z = str;
    }

    public InitConfig setAppName(String str) {
        this.f343s = str;
        return this;
    }

    public void setAutoActive(boolean z) {
        this.f283H = z;
    }

    public InitConfig setAutoStart(boolean z) {
        this.f311c = z;
        return this;
    }

    public void setAutoTrackEnabled(boolean z) {
        this.f289K = z;
    }

    public void setAutoTrackEventType(int i) {
        this.f340q0 = i;
    }

    public void setAutoTrackFragmentEnabled(boolean z) {
        this.f320g0 = z;
    }

    public void setCPUAbiEnabled(boolean z) {
        this.f284H0 = z;
    }

    public void setChannel(String str) {
        this.f313d = str;
    }

    public void setClickFillPagePropertiesEnable(boolean z) {
        this.f288J0 = z;
    }

    public void setCongestionControlEnable(boolean z) {
        this.f293M = z;
    }

    public void setCustomOaidCallback(DynamicValueCallback<String> dynamicValueCallback) {
        this.f276D0 = dynamicValueCallback;
    }

    public InitConfig setDbName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f294N = str;
        }
        return this;
    }

    public void setDisplayDensityAndDpiEnabled(boolean z) {
        this.f286I0 = z;
    }

    public InitConfig setEnablePlay(boolean z) {
        this.f335o = z;
        return this;
    }

    public InitConfig setEncryptor(IEncryptor iEncryptor) {
        this.f317f = new C0440i0(iEncryptor, IEncryptorType.DEFAULT_ENCRYPTOR);
        return this;
    }

    public InitConfig setEncryptor(IEncryptor iEncryptor, String str) {
        this.f317f = new C0440i0(iEncryptor, str);
        return this;
    }

    public void setEventDropStrategy(IEventDropStrategy iEventDropStrategy) {
        this.f292L0 = iEventDropStrategy;
    }

    public void setEventFilterEnable(boolean z) {
        this.f308a0 = z;
    }

    public void setExposureEnabled(boolean z) {
        this.f328k0 = z;
    }

    public void setGaidEnabled(boolean z) {
        this.f344s0 = z;
    }

    public void setGaidTimeOutMilliSeconds(int i) {
        this.f346t0 = i;
    }

    public InitConfig setGoogleAid(String str) {
        this.f319g = str;
        return this;
    }

    public InitConfig setH5BridgeAllowAll(boolean z) {
        this.f303W = z;
        return this;
    }

    public InitConfig setH5BridgeAllowlist(List<String> list) {
        this.f302V = list;
        return this;
    }

    public InitConfig setH5BridgeEnable(boolean z) {
        this.f299S = z;
        return this;
    }

    public InitConfig setH5CollectEnable(boolean z) {
        this.f300T = z;
        return this;
    }

    public void setHandleLifeCycle(boolean z) {
        this.f291L = z;
    }

    public void setHarmonyEnable(boolean z) {
        this.f318f0 = z;
    }

    @Deprecated
    public void setHttpHeaders(Map<String, String> map) {
        this.f350v0 = map;
    }

    public void setHttpHeadersCallback(DynamicValueCallback<Map<String, String>> dynamicValueCallback) {
        this.f352w0 = dynamicValueCallback;
    }

    @Deprecated
    public void setIccIdEnabled(boolean z) {
    }

    public InitConfig setImeiEnable(boolean z) {
        this.f298R = z;
        return this;
    }

    public InitConfig setIpcDataChecker(IpcDataChecker ipcDataChecker) {
        this.f310b0 = ipcDataChecker;
        return this;
    }

    public void setKvStoreConfig(KVStoreConfig kVStoreConfig) {
        this.f274C0 = kVStoreConfig;
    }

    public InitConfig setLanguage(String str) {
        this.f321h = str;
        return this;
    }

    public void setLaunchTerminateEnabled(boolean z) {
        this.f358z0 = z;
    }

    @Deprecated
    public InitConfig setLocalTest(boolean z) {
        this.f333n = z;
        return this;
    }

    public InitConfig setLogEnable(boolean z) {
        this.f301U = z;
        return this;
    }

    public InitConfig setLogger(ILogger iLogger) {
        this.f323i = iLogger;
        return this;
    }

    public void setMacEnable(boolean z) {
        this.f297Q = z;
    }

    public InitConfig setMainProcess() {
        this.f337p = 1;
        return this;
    }

    @Deprecated
    public InitConfig setManifestVersion(String str) {
        this.f357z = str;
        return this;
    }

    public InitConfig setManifestVersionCode(int i) {
        this.f355y = i;
        return this;
    }

    public void setMetaSecEnabled(boolean z) {
        this.f322h0 = z;
    }

    public void setMigrateEnabled(boolean z) {
        this.f342r0 = z;
    }

    public void setMonitorEnabled(boolean z) {
        C0540w2.m725b(this);
        this.f332m0 = z;
    }

    public InitConfig setNetworkClient(INetworkClient iNetworkClient) {
        this.f279F = iNetworkClient;
        return this;
    }

    public void setNetworkClient(INetworkClientV2 iNetworkClientV2) {
        this.f281G = iNetworkClientV2;
    }

    @Deprecated
    public InitConfig setNotRequestSender(boolean z) {
        this.f341r = z;
        return this;
    }

    public void setOaidEnabled(boolean z) {
        this.f324i0 = z;
    }

    public void setOperatorInfoEnabled(boolean z) {
        this.f338p0 = z;
    }

    public void setPageLeaveRefreshPropertiesEnable(boolean z) {
        this.f290K0 = z;
    }

    @Deprecated
    public void setPageMetaAnnotationEnable(boolean z) {
        this.f356y0 = z;
    }

    public InitConfig setPicker(IPicker iPicker) {
        this.f329l = iPicker;
        return this;
    }

    @Deprecated
    public InitConfig setPreInstallChannelCallback(InterfaceC0439i interfaceC0439i) {
        return this;
    }

    public InitConfig setProcess(int i) {
        this.f337p = i;
        return this;
    }

    public InitConfig setRegion(String str) {
        this.f325j = str;
        return this;
    }

    public InitConfig setReleaseBuild(String str) {
        this.f339q = str;
        return this;
    }

    public void setReportOaidEnable(boolean z) {
        this.f336o0 = z;
    }

    public void setResponseEncryptEnabled(boolean z) {
        this.f280F0 = z;
    }

    public void setScreenOrientationEnabled(boolean z) {
        this.f334n0 = z;
    }

    public void setScrollObserveEnabled(boolean z) {
        this.f330l0 = z;
    }

    public void setSensitiveInfoProvider(ISensitiveInfoProvider iSensitiveInfoProvider) {
        this.f296P = iSensitiveInfoProvider;
    }

    public void setSerialNumberEnable(boolean z) {
        this.f354x0 = z;
    }

    public void setSilenceInBackground(boolean z) {
        this.f285I = z;
    }

    public InitConfig setSpName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f295O = str;
        }
        return this;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f272B0 = sSLSocketFactory;
    }

    public void setTrackCrashType(int i) {
        this.f348u0 = i;
    }

    public void setTrackEventEnabled(boolean z) {
        this.f316e0 = z;
    }

    @Deprecated
    public InitConfig setTweakedChannel(String str) {
        this.f349v = str;
        return this;
    }

    public InitConfig setUpdateVersionCode(int i) {
        this.f353x = i;
        return this;
    }

    public InitConfig setUriConfig(int i) {
        this.f345t = UriConfig.createUriConfig(i);
        return this;
    }

    public InitConfig setUriConfig(UriConfig uriConfig) {
        this.f345t = uriConfig;
        return this;
    }

    public void setUseBridgeUpdateUUIDEnabled(boolean z) {
        this.f278E0 = z;
    }

    @Deprecated
    public InitConfig setUserUniqueId(String str) {
        this.f312c0 = str;
        return this;
    }

    @Deprecated
    public InitConfig setUserUniqueIdType(String str) {
        this.f314d0 = str;
        return this;
    }

    public InitConfig setVersion(String str) {
        this.f347u = str;
        return this;
    }

    public InitConfig setVersionCode(int i) {
        this.f351w = i;
        return this;
    }

    public InitConfig setVersionMinor(String str) {
        this.f269A = str;
        return this;
    }

    @Deprecated
    public InitConfig setZiJieCloudPkg(String str) {
        this.f271B = str;
        return this;
    }
}
