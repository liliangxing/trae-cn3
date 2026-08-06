package com.ss.android.token;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.ConsumerRequestContent;
import com.bytedance.android.sdk.bdticketguard.ConsumerRequestParam;
import com.bytedance.android.sdk.bdticketguard.ConsumerRequestParamWithTsSign;
import com.bytedance.android.sdk.bdticketguard.HandleConsumerResponseParam;
import com.bytedance.android.sdk.bdticketguard.HandleProviderResponseParam;
import com.bytedance.android.sdk.bdticketguard.ProviderRequestContent;
import com.bytedance.android.sdk.bdticketguard.ProviderRequestParam;
import com.bytedance.android.sdk.bdticketguard.TicketData;
import com.bytedance.android.sdk.bdticketguard.TicketGuardApi;
import com.bytedance.android.sdk.bdticketguard.TicketGuardEventHelper;
import com.bytedance.android.sdk.bdticketguard.TicketGuardService;
import com.bytedance.sdk.account.CsrfTokenManager;
import com.bytedance.sdk.account.settings.common.TokenSaveManager;
import com.bytedance.sdk.account.settings.common.TokenUseManager;
import com.bytedance.sdk.account.ticketguard.AccountTicketGuardManager;
import com.bytedance.sdk.account.ticketguard.TokenGuardSettingManager;
import com.bytedance.sdk.account.ticketguard.TsSignCacheHelper;
import com.bytedance.sdk.account.trace.TraceManager;
import com.bytedance.sdk.account.utils.ActivityStack;
import com.bytedance.sdk.account.utils.CommonRequestCacheHelper;
import com.bytedance.sdk.account.utils.TypeUtils;
import com.bytedance.sdk.account.utils.UrlBuilder;
import com.bytedance.sdk.account.utils.Utils;
import com.bytedance.sdk.account.utils.WeakHandler;
import com.lynx.tasm.core.ResManager;
import com.lynx.tasm.utils.LynxConstants;
import com.ss.android.TTHeader;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.token.AuthTokenMultiProcessSharedProvider;
import com.ss.android.token.ITokenService;
import com.ss.android.token.TTTokenConfig;
import com.ss.android.token.TTTokenMonitor;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TokenFactory implements WeakHandler.IHandler {
    private static final String TAG = "TokenFactory";
    private static volatile boolean hasCallInit;
    private static TokenFactory sInstance;
    private static volatile boolean sIsMainProcess;
    private ITokenService.Callback callback;
    private volatile JSONObject configExtraJson;
    private volatile boolean isAddHeaderAtNormalRequest;
    private volatile boolean isAddHeaderAtPassportRequest;
    private volatile boolean isUpdateToken;
    private final TTTokenConfig mConfig;
    private final Context mContext;
    private final Handler mHandler;
    private volatile boolean mIsFirstRequestToken;
    private AuthTokenMultiProcessSharedProvider.MultiProcessShared mMultiProcessShared;
    private TokenObjectProviderHelper tokenObjectProviderHelper;
    private volatile boolean mIsUpdateLoading = false;
    private volatile boolean mBeating = true;
    private volatile boolean isTokenValid = false;
    private volatile boolean mIsRecordLost = false;
    private final Object lock = new Object();
    private volatile TokenObject tokenObject = new TokenObject("", "");
    private final int MSG_RETRY = 1000;
    private final int MSG_CHECK = 2000;
    private final long GET_USER_INFO_INTERVAL = DownloadConstants.DAY;
    private final long NO_NET_RETRY_INTERVAL = 10000;
    private volatile boolean isEnable = true;
    private volatile boolean isApiConfigSuc = true;
    private volatile boolean isTicketInited = false;
    private final Object ticketInitLock = new Object();

    private String getSdkVersion() {
        return "2";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void initialize(Context context, TTTokenConfig tTTokenConfig) {
        sInstance = new TokenFactory(context, tTTokenConfig);
    }

    private TokenFactory(Context context, TTTokenConfig tTTokenConfig) {
        this.mConfig = tTTokenConfig;
        tTTokenConfig.addHostListFromLocalAndTTNet();
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        String tokenSaveName = tTTokenConfig.getTokenSaveName();
        tokenSaveName = TextUtils.isEmpty(tokenSaveName) ? "token_shared_preference" : tokenSaveName;
        Application application = (Application) applicationContext;
        if (application != null) {
            ActivityStack.init(application);
        }
        sIsMainProcess = TokenUtils.isMainProcess(applicationContext);
        this.mMultiProcessShared = AuthTokenMultiProcessSharedProvider.getMultiprocessShared(applicationContext, tokenSaveName, sIsMainProcess);
        this.mHandler = new WeakHandler(Looper.getMainLooper(), this);
        if (sIsMainProcess) {
            if (TextUtils.isEmpty(tTTokenConfig.getBeatHost())) {
                throw new IllegalStateException("not set beat host");
            }
            loadDataFromSp();
        } else {
            this.tokenObjectProviderHelper = new TokenObjectProviderHelper(applicationContext);
        }
        if (TokenGuardSettingManager.isEnableTokenGuard()) {
            AccountTicketGuardManager.INSTANCE.tryInit(applicationContext, new Function1<Boolean, Unit>() { // from class: com.ss.android.token.TokenFactory.1
                public Unit invoke(Boolean bool) {
                    TokenFactory.this.afterInit();
                    return null;
                }
            });
        } else {
            afterInit();
        }
        hasCallInit = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterInit() {
        synchronized (this.ticketInitLock) {
            this.isTicketInited = true;
            this.ticketInitLock.notifyAll();
        }
        if (sIsMainProcess) {
            getUserInfo();
            tryUpdateToken(true, false);
            startCheck();
        }
    }

    private void loadDataFromSp() {
        synchronized (this.lock) {
            String string = this.mMultiProcessShared.getString(TokenConstants.X_TT_TOKEN, "");
            this.tokenObject = new TokenObject(string, TextUtils.isEmpty(string) ? "" : this.mMultiProcessShared.getString("ts_sign", ""));
            this.isTokenValid = isTokenValid(string);
        }
        this.mIsFirstRequestToken = this.mMultiProcessShared.getBoolean(TokenConstants.FIRST_BEATE_KEY, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cookieHasSession() {
        return !TextUtils.isEmpty(Utils.getSpecialCookieInfo(this.mConfig.getBeatHost(), TokenConstants.COOKIE_KEY_SESSION_ID));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static TokenFactory getInstance() {
        return sInstance;
    }

    private boolean isTokenLost() {
        if (!sIsMainProcess || this.mIsRecordLost || this.isTokenValid) {
            return false;
        }
        this.mIsRecordLost = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TokenObject getTokenObject() {
        if (sIsMainProcess) {
            TTTokenManager.log(TAG, "getTokenObject " + this.tokenObject.getLoggableString());
            return this.tokenObject;
        }
        return this.tokenObjectProviderHelper.getTokenObject();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTokenObject(TokenObject tokenObject) {
        if (sIsMainProcess) {
            synchronized (this.lock) {
                TTTokenManager.log(TAG, "setTokenObject " + tokenObject.getLoggableString());
                this.tokenObject = tokenObject;
                AuthTokenMultiProcessSharedProvider.Editor edit = this.mMultiProcessShared.edit();
                edit.putString(TokenConstants.X_TT_TOKEN, tokenObject.token);
                edit.putString("ts_sign", tokenObject.tsSign);
                edit.apply();
            }
        } else {
            this.tokenObjectProviderHelper.setTokenObject(tokenObject);
        }
        this.isTokenValid = isTokenValid(tokenObject.token);
        TicketGuardEventHelper.INSTANCE.monitorGetTicketResponse(TokenConstants.X_TT_TOKEN_TICKET_NAME, tokenObject.token, tokenObject.tsSign);
    }

    private boolean isTokenValid(String str) {
        return ("change.token".equals(str) || TextUtils.isEmpty(str)) ? false : true;
    }

    private void postTokenLostEventIfNeed(String str) {
        if (sIsMainProcess && TTTokenManager.isLogin() && !this.mIsRecordLost && !this.isTokenValid) {
            this.mIsRecordLost = true;
            TTTokenMonitor.monitorTokenLost(str);
        }
    }

    public static boolean isHasCallInit() {
        return hasCallInit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearToken() {
        TTTokenManager.log(TAG, "clearToken");
        setTokenObject(new TokenObject("", ""));
    }

    protected boolean isHost(String str) {
        return this.isEnable && TokenUtils.isInDomainList(str, this.mConfig.getHostList());
    }

    private String getHostFromStandardUrl(String str) {
        int i;
        try {
            if (str.startsWith("https://")) {
                i = 8;
            } else {
                if (!str.startsWith(ResManager.HTTP_SCHEME)) {
                    return null;
                }
                i = 7;
            }
            int indexOf = str.indexOf(47, i);
            if (indexOf > 0) {
                return str.substring(i, indexOf).toLowerCase();
            }
            return str.substring(i).toLowerCase();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String getUrlPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str).getPath();
    }

    protected boolean inBlockList(String str) {
        TTTokenConfig.IBlockList blockList;
        if (str == null || (blockList = this.mConfig.getBlockList()) == null) {
            return false;
        }
        return blockList.inBlockList(str);
    }

    protected boolean isHostInDomainList(String str) {
        return this.isEnable && TokenUtils.isHostInDomainList(str, this.mConfig.getHostList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RequestContent addRequestHeader(String str, String str2) {
        boolean z;
        boolean z2;
        String str3;
        if (sInstance != null && !TextUtils.isEmpty(str)) {
            String hostFromStandardUrl = getHostFromStandardUrl(str);
            if (!isHostInDomainList(hostFromStandardUrl) || inBlockList(str)) {
                TTTokenMonitor.monitorNotAddToken(str, this.mConfig.getHostList());
            } else {
                if (str.startsWith(ResManager.HTTP_SCHEME)) {
                    if (TokenUseManager.isEnableHttpForbid()) {
                        return null;
                    }
                    if (TokenUseManager.isEnableHttpRequestTrack()) {
                        z = true;
                        Uri parse = Uri.parse(str);
                        String path = parse.getPath();
                        z2 = TextUtils.isEmpty(path) && path.startsWith("/passport/");
                        HashMap hashMap = new HashMap();
                        TokenObject tokenObject = getTokenObject();
                        str3 = tokenObject.token;
                        if (!TextUtils.isEmpty(str3)) {
                            hashMap.put(TokenConstants.X_TT_TOKEN, str3);
                        }
                        hashMap.put("sdk-version", sInstance.getSdkVersion());
                        hashMap.put(TokenConstants.ACCOUNT_SDK_VERSION, String.valueOf(505180));
                        if (z2) {
                            String traceId = TraceManager.getTraceId();
                            if (!TextUtils.isEmpty(traceId)) {
                                hashMap.put(TokenConstants.X_TT_PASSPORT_TRACE_ID, traceId);
                            }
                        }
                        RequestContent requestContent = new RequestContent();
                        requestContent.headers = hashMap;
                        requestContent.getAllRequestHeader = z;
                        addTicketGuardHeader(parse, hostFromStandardUrl, path, tokenObject, z2, str2, requestContent);
                        postTokenLostEventIfNeed(str);
                        if (this.isAddHeaderAtPassportRequest || !this.isAddHeaderAtNormalRequest) {
                            if (!z2) {
                                this.isAddHeaderAtPassportRequest = true;
                            } else {
                                if (!TTTokenManager.isLogin()) {
                                    this.isAddHeaderAtPassportRequest = true;
                                }
                                this.isAddHeaderAtNormalRequest = true;
                            }
                        }
                        return requestContent;
                    }
                }
                z = false;
                Uri parse2 = Uri.parse(str);
                String path2 = parse2.getPath();
                if (TextUtils.isEmpty(path2)) {
                }
                HashMap hashMap2 = new HashMap();
                TokenObject tokenObject2 = getTokenObject();
                str3 = tokenObject2.token;
                if (!TextUtils.isEmpty(str3)) {
                }
                hashMap2.put("sdk-version", sInstance.getSdkVersion());
                hashMap2.put(TokenConstants.ACCOUNT_SDK_VERSION, String.valueOf(505180));
                if (z2) {
                }
                RequestContent requestContent2 = new RequestContent();
                requestContent2.headers = hashMap2;
                requestContent2.getAllRequestHeader = z;
                addTicketGuardHeader(parse2, hostFromStandardUrl, path2, tokenObject2, z2, str2, requestContent2);
                postTokenLostEventIfNeed(str);
                if (this.isAddHeaderAtPassportRequest) {
                }
                if (!z2) {
                }
                return requestContent2;
            }
        }
        return null;
    }

    private void addTicketGuardHeader(Uri uri, String str, String str2, TokenObject tokenObject, boolean z, String str3, RequestContent requestContent) {
        boolean z2;
        boolean z3;
        ConsumerRequestParamWithTsSign consumerRequestParamWithTsSign;
        ProviderRequestContent obtainTicketGuardParams;
        ConsumerRequestContent consumerRequestContent;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean z4 = TokenConstants.ACCOUNT_USERINFO_URL_PATH_NEW.equalsIgnoreCase(str2) || "/passport/token/beat/v2/".equalsIgnoreCase(str2);
        if (!TokenGuardSettingManager.isEnableTokenGuard()) {
            if (z4) {
                TTTokenMonitor.monitorPassportNotMarkGetTicket(str, str2, "experiment disable");
                return;
            }
            return;
        }
        Map<String, String> map = requestContent.headers;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (z && TokenGuardSettingManager.isPathGetToken(str, str2)) {
            sb.append("x-tt-token,");
            sb2.append("x-tt-token,");
            z2 = true;
        } else {
            if (z4) {
                TTTokenMonitor.monitorPassportNotMarkGetTicket(str, str2, "not match rules, rules=" + TokenGuardSettingManager.getConfigString());
            }
            z2 = false;
        }
        boolean z5 = map.containsKey(TokenConstants.X_TT_TOKEN) && TokenGuardSettingManager.isPathNeedGuard(str2);
        if (z) {
            Iterator it = AccountTicketGuardManager.INSTANCE.getList().iterator();
            z3 = false;
            consumerRequestParamWithTsSign = null;
            while (it.hasNext()) {
                AccountTicketGuardManager.Processor processor = (AccountTicketGuardManager.Processor) it.next();
                AccountTicketGuardManager.MarkGetContent markGet = processor.markGet(uri, str3, map);
                if (markGet != null) {
                    sb.append(markGet.getSettingsTag());
                    if (markGet.isGet()) {
                        sb2.append(markGet.getSignTag());
                        z3 = true;
                    }
                }
                if (consumerRequestParamWithTsSign == null) {
                    consumerRequestParamWithTsSign = processor.markUse(uri, str3, map);
                }
            }
        } else {
            z3 = false;
            consumerRequestParamWithTsSign = null;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            map.put("passport-sdk-settings", sb.toString());
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
            map.put("passport-sdk-sign", sb2.toString());
        }
        if (!this.isTicketInited && ((z2 || z3 || consumerRequestParamWithTsSign != null || z5) && TokenGuardSettingManager.isEnableWaitingInit())) {
            TTTokenManager.log(TAG, String.format("%s start waiting for ticketInitLock", str2));
            synchronized (this.ticketInitLock) {
                if (!this.isTicketInited) {
                    try {
                        this.ticketInitLock.wait(TokenGuardSettingManager.getWaitingTimeout());
                    } catch (InterruptedException e) {
                        TTTokenManager.log(TAG, "ticketInitLock wait failed, e=" + Log.getStackTraceString(e));
                    }
                }
            }
            TTTokenManager.log(TAG, String.format("%s request continue, isTicketInited=%s", str2, Boolean.valueOf(this.isTicketInited)));
            TTTokenMonitor.monitorWaitTicketInitResult(str2, this.isTicketInited);
        }
        if (z2 || z3) {
            obtainTicketGuardParams = getObtainTicketGuardParams(str, str2);
            addObtainTicketGuardParams(map, obtainTicketGuardParams);
            if (obtainTicketGuardParams == null && z4) {
                TTTokenMonitor.monitorPassportNotMarkGetTicket(str, str2, "service null");
            }
        } else {
            obtainTicketGuardParams = null;
        }
        ConsumerRequestParamWithTsSign consumerRequestParamWithTsSign2 = (consumerRequestParamWithTsSign == null && z5) ? new ConsumerRequestParamWithTsSign(tokenObject.tsSign, tokenObject.token, str, str2, TokenConstants.X_TT_TOKEN_TICKET_NAME) : consumerRequestParamWithTsSign;
        if (consumerRequestParamWithTsSign2 != null) {
            consumerRequestContent = getUseTicketGuardParams(consumerRequestParamWithTsSign2);
            addUseTicketGuardParams(map, consumerRequestParamWithTsSign2, consumerRequestContent);
        } else {
            consumerRequestContent = null;
        }
        requestContent.ticketProviderRequestContent = obtainTicketGuardParams;
        requestContent.ticketConsumerRequestContent = consumerRequestContent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void processResponseHeader(String str, RequestContent requestContent, List<TTTokenHeader> list, List<TTTokenHeader> list2) {
        String str2;
        ProviderRequestContent providerRequestContent;
        ConsumerRequestContent consumerRequestContent;
        String str3;
        ConsumerRequestParam requestParam;
        boolean z;
        if (sInstance == null || TextUtils.isEmpty(str)) {
            return;
        }
        String hostFromStandardUrl = getHostFromStandardUrl(str);
        if (list != null) {
            Iterator<TTTokenHeader> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                TTTokenHeader next = it.next();
                if (TokenConstants.X_TT_TOKEN.equalsIgnoreCase(next.getName())) {
                    z = !TextUtils.isEmpty(next.getValue());
                    break;
                }
            }
            str2 = getUrlPath(str);
            TTTokenMonitor.monitorHttpRequest(hostFromStandardUrl, str2, z);
        } else {
            str2 = null;
        }
        if (sIsMainProcess && isHostInDomainList(hostFromStandardUrl) && !inBlockList(str)) {
            if (str2 == null) {
                str2 = getUrlPath(str);
            }
            if (TextUtils.isEmpty(hostFromStandardUrl) || TextUtils.isEmpty(str2) || !TokenSaveManager.check(hostFromStandardUrl, str2)) {
                return;
            }
            boolean startsWith = str2.startsWith("/passport/");
            ArrayList arrayList = new ArrayList();
            Iterator<TTTokenHeader> it2 = list2.iterator();
            String str4 = "";
            String str5 = "";
            String str6 = str5;
            String str7 = str6;
            String str8 = str7;
            while (it2.hasNext()) {
                TTTokenHeader next2 = it2.next();
                String value = next2.getValue();
                if (!TextUtils.isEmpty(value)) {
                    Iterator<TTTokenHeader> it3 = it2;
                    String str9 = hostFromStandardUrl;
                    arrayList.add(new Pair(next2.getName(), next2.getValue()));
                    if (TokenConstants.X_TT_TOKEN.equalsIgnoreCase(next2.getName())) {
                        str8 = value;
                    } else if ("X-Tt-Logid".equalsIgnoreCase(next2.getName())) {
                        TTTokenManager.log(TAG, "processResponseHeader logid = " + value);
                        str7 = value;
                    } else if ("passport-sdk-sign-check-result".equalsIgnoreCase(next2.getName())) {
                        str6 = next2.getValue();
                    } else if ("bd-ticket-guard-result".equalsIgnoreCase(next2.getName())) {
                        str5 = next2.getValue();
                    }
                    it2 = it3;
                    hostFromStandardUrl = str9;
                }
            }
            String str10 = hostFromStandardUrl;
            boolean z2 = (TextUtils.isEmpty(str5) || str5.equals("0")) ? false : true;
            if (startsWith && !TextUtils.isEmpty(str2) && TokenGuardSettingManager.isEnableTokenGuard()) {
                if (!TextUtils.isEmpty(str6) && requestContent != null && requestContent.headers != null && requestContent.headers.containsKey("bd-ticket-guard-client-data") && (requestParam = requestContent.ticketConsumerRequestContent.getRequestParam()) != null) {
                    String ticketName = requestParam.getTicketName();
                    if (!TextUtils.isEmpty(ticketName)) {
                        TTTokenMonitor.monitorUseTicketResponse(ticketName, str6, str2, str7);
                    }
                }
                TicketGuardService service = TicketGuardApi.INSTANCE.getService();
                if (service != null) {
                    if (requestContent != null) {
                        providerRequestContent = requestContent.ticketProviderRequestContent;
                        consumerRequestContent = requestContent.ticketConsumerRequestContent;
                    } else {
                        providerRequestContent = null;
                        consumerRequestContent = null;
                    }
                    if (providerRequestContent != null) {
                        List handleProviderResponse = service.handleProviderResponse(new HandleProviderResponseParam("", false, providerRequestContent, arrayList));
                        if (!handleProviderResponse.isEmpty()) {
                            Iterator it4 = handleProviderResponse.iterator();
                            str3 = "";
                            while (it4.hasNext()) {
                                TicketData ticketData = (TicketData) it4.next();
                                Iterator it5 = it4;
                                TTTokenManager.log(TAG, "save ts_sign: " + getMixVal(ticketData.getTs_sign()));
                                if (!TextUtils.isEmpty(str8) && str8.equals(ticketData.getTicket())) {
                                    str3 = ticketData.getTs_sign();
                                } else {
                                    TsSignCacheHelper.saveTsSign(ticketData.getTicket(), ticketData.getTs_sign());
                                }
                                it4 = it5;
                            }
                            if (consumerRequestContent == null) {
                                service.handleConsumerResponse(new HandleConsumerResponseParam(consumerRequestContent, arrayList));
                            } else if (z2 && ("/passport/token/beat/v2/".equals(str2) || TokenConstants.ACCOUNT_USERINFO_URL_PATH_NEW.equals(str2))) {
                                TicketGuardEventHelper.monitorUseTicketFail(str2, str7, "", str5, "");
                            }
                            str4 = str3;
                        }
                    }
                    str3 = "";
                    if (consumerRequestContent == null) {
                    }
                    str4 = str3;
                }
            }
            if (!((TextUtils.isEmpty(str8) || TextUtils.equals(str8, this.tokenObject.token)) ? false : true) || this.mMultiProcessShared == null) {
                return;
            }
            TokenObject tokenObject = new TokenObject(str8, str4);
            setTokenObject(tokenObject);
            TTTokenMonitor.monitorUpdateToken(str10, str2, str7, requestContent, tokenObject);
            TTTokenMonitor.monitorTokenChange(str8, str7);
        }
    }

    private List<Pair<String, String>> parseRequestBody(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                arrayList.add(new Pair(URLDecoder.decode(split[0], HTTP.UTF_8), URLDecoder.decode(split[1], HTTP.UTF_8)));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    private ProviderRequestContent getObtainTicketGuardParams(String str, String str2) {
        TicketGuardService service = TicketGuardApi.INSTANCE.getService();
        if (service == null) {
            return null;
        }
        return service.getProviderContent(new ProviderRequestParam(str, str2));
    }

    private void addObtainTicketGuardParams(Map<String, String> map, ProviderRequestContent providerRequestContent) {
        Map<? extends String, ? extends String> convertPairListToMap;
        if (providerRequestContent == null || (convertPairListToMap = TypeUtils.convertPairListToMap(providerRequestContent.getHeaders())) == null) {
            return;
        }
        map.putAll(convertPairListToMap);
    }

    public ConsumerRequestContent getUseTicketGuardParams(ConsumerRequestParamWithTsSign consumerRequestParamWithTsSign) {
        TicketGuardService service = TicketGuardApi.INSTANCE.getService();
        if (service == null) {
            return null;
        }
        return service.getConsumerRequestContent(consumerRequestParamWithTsSign);
    }

    private void addUseTicketGuardParams(Map<String, String> map, ConsumerRequestParamWithTsSign consumerRequestParamWithTsSign, ConsumerRequestContent consumerRequestContent) {
        String path = consumerRequestParamWithTsSign.getPath();
        String ticketName = consumerRequestParamWithTsSign.getTicketName();
        if (TicketGuardApi.INSTANCE.getService() == null) {
            TTTokenMonitor.monitorTokenGuardFail(consumerRequestParamWithTsSign.getPath(), ticketName, LynxConstants.LYNX_DEFAULT_COMPONENT_ID, "ticket guard service is null");
            return;
        }
        if (TextUtils.isEmpty(consumerRequestParamWithTsSign.getTarget()) || TextUtils.isEmpty(consumerRequestParamWithTsSign.getTsSign())) {
            TTTokenMonitor.monitorTokenGuardFail(path, ticketName, "-2", "tsSign or target is empty");
            return;
        }
        if (consumerRequestContent == null || consumerRequestContent.getHeaders() == null || consumerRequestContent.getHeaders().isEmpty()) {
            TTTokenMonitor.monitorTokenGuardFail(path, ticketName, "-3", "TicketGuardHeader is null or empty");
        } else {
            map.putAll(TypeUtils.convertPairListToMap(consumerRequestContent.getHeaders()));
            TTTokenMonitor.monitorUseTicketRequest(ticketName, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tryUpdateToken(boolean z, boolean z2) {
        tryUpdateToken(z, z2, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tryUpdateToken(boolean z, boolean z2, final String str, final String str2, final String str3, final String str4) {
        if (sIsMainProcess && this.mBeating && !this.mIsUpdateLoading) {
            this.mIsUpdateLoading = true;
            this.isUpdateToken = true;
            if (!TTTokenManager.isLogin()) {
                this.mHandler.sendEmptyMessageDelayed(1000, this.mConfig.getUpdateInterval());
                this.mIsUpdateLoading = false;
                return;
            }
            final String tokenBeatUrl = getTokenBeatUrl(z, z2, str);
            if (TextUtils.isEmpty(tokenBeatUrl)) {
                this.mIsUpdateLoading = false;
                return;
            }
            this.callback = new ITokenService.Callback() { // from class: com.ss.android.token.TokenFactory.2
                @Override // com.ss.android.token.ITokenService.Callback
                public void onSuccess(ITokenService.Response response) {
                    try {
                        TokenFactory.this.mIsUpdateLoading = false;
                        TokenFactory.this.mHandler.sendEmptyMessageDelayed(1000, TokenFactory.this.mConfig.getUpdateInterval());
                        TokenFactory.this.updateFirstRequestToken();
                    } catch (Exception e) {
                        TTTokenMonitor.monitorError(e);
                    }
                    TokenFactory.this.monitorSessionExpiredResult(str, str2, str3, str4, TTTokenMonitor.SessionExpiredHandleResult.ignore);
                }

                @Override // com.ss.android.token.ITokenService.Callback
                public void onError(ITokenService.Response response) {
                    String str5;
                    String str6;
                    try {
                        TokenFactory.this.mIsUpdateLoading = false;
                        if (response.data != null) {
                            str5 = response.data.optString("error_name");
                            str6 = response.data.optString("log_id");
                            TokenFactory.this.updateFirstRequestToken();
                        } else {
                            str5 = null;
                            str6 = null;
                        }
                        TTTokenMonitor.SessionExpiredHandleResult sessionExpiredHandleResult = TTTokenMonitor.SessionExpiredHandleResult.ignore;
                        if ("session_expired".equalsIgnoreCase(str5)) {
                            sessionExpiredHandleResult = TTTokenMonitor.SessionExpiredHandleResult.logout;
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(str6)) {
                                arrayList.add(new TTTokenHeader(TTTokenMonitor.TT_LOGID_KEY, str6));
                            }
                            TokenFactory.this.onSessionExpired(tokenBeatUrl, arrayList, true, TTTokenManager.isLogin(), null);
                        } else if (response.errorCode == 400) {
                            TTTokenManager.showSelfCheckError("token sdk status error", "SDK self-check failed:" + response.errorMessage + ";please check network interceptor work fine");
                        } else {
                            String str7 = response.detailErrorMessage != null ? response.detailErrorMessage : "";
                            TTTokenMonitor.monitorToken(TTTokenMonitor.TT_TOKEN_BEAT, null, response.errorCode, str7);
                            if (TokenFactory.this.configExtraJson == null) {
                                TokenFactory.this.configExtraJson = new JSONObject();
                                TokenFactory.this.configExtraJson.put("error_code", response.errorCode);
                                TokenFactory.this.configExtraJson.put("error_detail_msg", str7);
                            }
                            if ("Not Found".equalsIgnoreCase(str7)) {
                                TokenFactory.this.isApiConfigSuc = false;
                            }
                        }
                        TokenFactory.this.monitorSessionExpiredResult(str, str2, str3, str4, sessionExpiredHandleResult);
                        TokenFactory.this.mHandler.sendEmptyMessageDelayed(1000, TokenFactory.this.mConfig.getUpdateInterval());
                    } catch (Exception e) {
                        TTTokenMonitor.monitorError(e);
                    }
                }
            };
            HashMap hashMap = new HashMap();
            TTHeader requestTagHeader = TTTokenManager.getRequestTagHeader(true);
            if (requestTagHeader != null) {
                hashMap.put(requestTagHeader.getName(), requestTagHeader.getValue());
            }
            TTTokenManager.request(tokenBeatUrl, hashMap, null, true, this.callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFirstRequestToken() {
        if (this.mIsFirstRequestToken) {
            this.mIsFirstRequestToken = false;
            AuthTokenMultiProcessSharedProvider.MultiProcessShared multiProcessShared = this.mMultiProcessShared;
            if (multiProcessShared != null) {
                multiProcessShared.edit().putBoolean(TokenConstants.FIRST_BEATE_KEY, false).apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void monitorSessionExpiredResult(String str, String str2, String str3, String str4, TTTokenMonitor.SessionExpiredHandleResult sessionExpiredHandleResult) {
        if (TextUtils.equals(str, TokenConstants.FRONTIER_LOGOUT)) {
            TTTokenMonitor.monitorSessionExpiredResult(str, str2, str3, str4, sessionExpiredHandleResult);
        }
    }

    protected void stopTokenBeat() {
        this.mBeating = false;
    }

    private void getUserInfo() {
        final String str = TTTokenManager.getUrl(TokenConstants.ACCOUNT_USERINFO_URL_PATH_NEW) + "cache";
        boolean isLogin = TTTokenManager.isLogin();
        TTTokenManager.log(TAG, "isLogin = " + isLogin);
        if (isLogin) {
            if (TokenGuardSettingManager.isEnableTokenLaunch()) {
                TTTokenManager.log(TAG, "do account/info request, login");
                TTTokenManager.userInfo(TokenConstants.BOOT_SCENE, null);
                return;
            }
            return;
        }
        String cache = CommonRequestCacheHelper.getInstance().getCache(str, (Map) null);
        TTTokenManager.log(TAG, "cache = " + cache);
        if (TextUtils.isEmpty(cache)) {
            TTTokenManager.log(TAG, "do account/info request, un-login");
            TTTokenManager.userInfo("normal", new ITokenService.Callback() { // from class: com.ss.android.token.TokenFactory.3
                @Override // com.ss.android.token.ITokenService.Callback
                public void onSuccess(ITokenService.Response response) {
                    try {
                        if (response.data.optLong("user_id", 0L) > 0) {
                            TTTokenMonitor.onSyncLoginStatusError();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    CommonRequestCacheHelper.getInstance().putCache(str, (Map) null, "whatever", System.currentTimeMillis() + DownloadConstants.DAY);
                }

                @Override // com.ss.android.token.ITokenService.Callback
                public void onError(ITokenService.Response response) {
                    CommonRequestCacheHelper.getInstance().putCache(str, (Map) null, "whatever", System.currentTimeMillis() + DownloadConstants.DAY);
                }
            });
        }
    }

    public void handleMsg(Message message) {
        if (message.what == 1000) {
            this.mHandler.removeMessages(1000);
            tryUpdateToken(false, false);
        } else if (message.what == 2000) {
            checkStatus();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSessionExpired(String str, List<TTTokenHeader> list, boolean z, boolean z2, ITokenService.Callback callback) {
        TTTokenMonitor.monitorSessionExpired(str, list, z2);
        if (sIsMainProcess && TTTokenManager.isLogin()) {
            clearToken();
            TTTokenManager.invalidSession(z);
            sessionExpiredInternal(TokenConstants.SESSION_LOGOUT, callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSessionDrop(String str, List<TTTokenHeader> list, boolean z) {
        TTTokenMonitor.monitorSessionExpired(str, list, z);
        if (sIsMainProcess && TTTokenManager.isLogin()) {
            clearToken();
            TTTokenManager.invalidSession(true);
            sessionExpiredInternal(TokenConstants.FRONTIER_LOGOUT, null);
        }
    }

    private void sessionExpiredInternal(String str, ITokenService.Callback callback) {
        TTTokenManager.logout(str, callback);
    }

    public void stopUpdateToken() {
        if (sIsMainProcess) {
            this.mHandler.removeMessages(1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startUpdateToken() {
        if (sIsMainProcess) {
            this.mHandler.sendEmptyMessageDelayed(1000, this.mConfig.getUpdateInterval());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTokenEnable(boolean z) {
        this.isEnable = z;
        if (this.isEnable || !sIsMainProcess) {
            return;
        }
        clearToken();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getTokenBeatUrl(boolean z, boolean z2, String str) {
        UrlBuilder urlBuilder = new UrlBuilder(this.mConfig.getBeatHost() + "/passport/token/beat/v2/");
        String str2 = z ? TokenConstants.BOOT_SCENE : TokenConstants.POLLING_SCENE;
        if (z2) {
            str2 = TokenConstants.WAP_LOGIN_SCENE;
        }
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        urlBuilder.addParam(TokenConstants.SCENE_KEY, str);
        urlBuilder.addParam(TokenConstants.FIRST_BEATE_KEY, this.mIsFirstRequestToken ? "true" : "false");
        return urlBuilder.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addConfigHost(Collection<String> collection) {
        TTTokenConfig tTTokenConfig = this.mConfig;
        if (tTTokenConfig != null) {
            tTTokenConfig.dynamicAddHostList(collection);
        }
    }

    private void startCheck() {
        this.mHandler.sendEmptyMessageDelayed(2000, 60000L);
    }

    private void checkStatus() {
        if (sIsMainProcess) {
            StringBuilder sb = new StringBuilder();
            boolean isLocalTest = TTTokenManager.isLocalTest();
            if (TTTokenManager.isLogin() && !this.isUpdateToken) {
                String string = this.mContext.getString(C0721R.string.invoke_api_error);
                if (!isLocalTest) {
                    TTTokenMonitor.monitorConfigError("token_beat_not_poll", string, null);
                }
                sb.append(string);
            }
            if (!this.isApiConfigSuc) {
                String string2 = this.mContext.getString(C0721R.string.config_api_error);
                if (!isLocalTest) {
                    TTTokenMonitor.monitorConfigError("token_beat_not_config", string2, this.configExtraJson);
                }
                sb.append(string2);
            }
            if (TTTokenManager.isNetworkAvailable() && (!this.isAddHeaderAtPassportRequest || !this.isAddHeaderAtNormalRequest)) {
                String string3 = this.mContext.getString(C0721R.string.sdk_version_params_error);
                if (!isLocalTest) {
                    TTTokenMonitor.monitorConfigError("sdk-version-not-add", string3, null);
                }
                sb.append(string3);
            }
            if (!this.mConfig.hasCallAddHostList()) {
                if (!isLocalTest) {
                    TTTokenMonitor.monitorNotCallAddHostList();
                }
                sb.append(this.mContext.getString(C0721R.string.token_host_list_is_not_added));
            }
            String sb2 = sb.toString();
            if (isLocalTest && !TextUtils.isEmpty(sb2)) {
                TTTokenManager.showSelfCheckError("token sdk status error", sb2);
            }
            new Thread(new Runnable() { // from class: com.ss.android.token.TokenFactory.4
                @Override // java.lang.Runnable
                public void run() {
                    TTTokenMonitor.eventLoadToken(TTTokenManager.isLogin(), TokenFactory.this.cookieHasSession(), TokenFactory.this.isTokenValid, CsrfTokenManager.getCsrfTokenLocation());
                }
            }).start();
        }
    }

    public static String getMixVal(Object obj) {
        String obj2 = obj.toString();
        return TextUtils.isEmpty(obj2) ? "" : obj2.length() > 10 ? obj2.substring(0, 9) + "***" + obj2.substring(obj2.length() - 5) : obj2;
    }
}
