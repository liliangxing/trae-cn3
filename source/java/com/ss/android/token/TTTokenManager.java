package com.ss.android.token;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bytedance.android.sdk.bdticketguard.ConsumerRequestContent;
import com.bytedance.android.sdk.bdticketguard.ConsumerRequestParamWithTsSign;
import com.bytedance.android.sdk.bdticketguard.INetwork;
import com.ss.android.IRequestTagHeaderProvider;
import com.ss.android.TTHeader;
import com.ss.android.token.ITokenService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTTokenManager {
    private static final String TAG = "TTTokenManager";
    private static IExceptionCatcher exceptionCatcher = null;
    private static volatile ILogger logger = null;
    private static IRequestTagHeaderProvider requestTagHeaderProvider = null;
    private static volatile boolean sEnable = true;
    private static volatile boolean sInited;
    private static ISessionManager sessionManager;
    private static ITokenService tokenService;
    private static Set<String> sHostList = Collections.synchronizedSet(new HashSet());
    private static List<TokenProcessor> tokenProcessors = new ArrayList();
    private static boolean isLocalTest = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IExceptionCatcher {
        void onException(Throwable th);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ILogger {
        void log(int i, String str, String str2);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ISessionManager {
        void invalidSession(boolean z);

        void notifyLogout(String str);
    }

    public static synchronized void initialize(Context context, TTTokenConfig tTTokenConfig) {
        synchronized (TTTokenManager.class) {
            if (!sInited) {
                if (tokenService == null) {
                    throw new IllegalStateException("did not call TokenManager.setTokenService()!");
                }
                TokenFactory.initialize(context, tTTokenConfig);
                TokenFactory.getInstance().setTokenEnable(sEnable);
                sInited = true;
                if (sHostList.size() != 0) {
                    TokenFactory.getInstance().addConfigHost(sHostList);
                    sHostList.clear();
                    sHostList = null;
                }
                TTTokenMonitor.monitorSdkSessionLaunch();
            }
        }
    }

    public static void onSessionExpired(String str, List<TTTokenHeader> list, ITokenService.Callback callback) {
        if (sInited) {
            TokenFactory.getInstance().onSessionExpired(str, list, true, true, callback);
        }
    }

    public static void onSessionExpired(String str, List<TTTokenHeader> list, boolean z, ITokenService.Callback callback) {
        if (sInited) {
            TokenFactory.getInstance().onSessionExpired(str, list, z, true, callback);
        }
    }

    public static void onSessionExpired(String str, List<TTTokenHeader> list, boolean z, boolean z2, ITokenService.Callback callback) {
        if (sInited) {
            TokenFactory.getInstance().onSessionExpired(str, list, z, z2, callback);
        }
    }

    public static void onSessionDrop(String str, List<TTTokenHeader> list, boolean z) {
        if (sInited) {
            TokenFactory.getInstance().onSessionDrop(str, list, z);
        }
    }

    public static void setEnableToken(boolean z) {
        if (!sInited || z == sEnable) {
            return;
        }
        TokenFactory.getInstance().setTokenEnable(z);
        sEnable = z;
    }

    public static void clearToken() {
        if (sInited) {
            TokenFactory.getInstance().clearToken();
        }
    }

    public static Map<String, String> addRequestHeader(String str) {
        RequestContent addRequestHeader = addRequestHeader(str, null);
        if (addRequestHeader == null) {
            return null;
        }
        return addRequestHeader.headers;
    }

    public static RequestContent addRequestHeader(String str, String str2) {
        Map<String, String> processRequest;
        if (!sInited) {
            return null;
        }
        RequestContent addRequestHeader = TokenFactory.getInstance().addRequestHeader(str, str2);
        if (tokenProcessors != null) {
            if (addRequestHeader == null) {
                addRequestHeader = new RequestContent();
            }
            if (addRequestHeader.headers == null) {
                addRequestHeader.headers = new HashMap();
            }
            Map<String, String> map = addRequestHeader.headers;
            for (TokenProcessor tokenProcessor : tokenProcessors) {
                if (tokenProcessor != null && (processRequest = tokenProcessor.processRequest(str)) != null) {
                    map.putAll(processRequest);
                }
            }
        }
        return addRequestHeader;
    }

    public static void processResponseHeader(String str, List<TTTokenHeader> list) {
        processResponseHeader(str, null, null, list);
    }

    public static void processResponseHeader(String str, RequestContent requestContent, List<TTTokenHeader> list, List<TTTokenHeader> list2) {
        if (sInited) {
            TokenFactory.getInstance().processResponseHeader(str, requestContent, list, list2);
            List<TokenProcessor> list3 = tokenProcessors;
            if (list3 != null) {
                for (TokenProcessor tokenProcessor : list3) {
                    if (tokenProcessor != null) {
                        tokenProcessor.processResponse(str, list2);
                    }
                }
            }
        }
    }

    public static boolean isInited() {
        return sInited;
    }

    public static boolean isTokenEnable() {
        return sEnable;
    }

    public static String getTokenBeatUrl(boolean z, boolean z2, String str) {
        return TokenFactory.getInstance().getTokenBeatUrl(z, z2, str);
    }

    public static void addConfigHost(Collection<String> collection) {
        if (sInited) {
            TokenFactory.getInstance().addConfigHost(collection);
            return;
        }
        Set<String> set = sHostList;
        if (set != null) {
            set.addAll(collection);
        }
    }

    public static void stopUpdateToken() {
        if (sInited) {
            TokenFactory.getInstance().stopUpdateToken();
        }
    }

    public static void startUpdateToken() {
        if (sInited) {
            TokenFactory.getInstance().startUpdateToken();
        }
    }

    public static void updateToken() {
        if (sInited) {
            TokenFactory.getInstance().tryUpdateToken(false, false);
        }
    }

    public static void updateTokenForSessionExpired(String str, String str2, String str3) {
        if (sInited) {
            log(TAG, String.format("session expired, requestHost=%s, requestPath=%s, responseLogid=%s", str, str2, str3));
            TokenFactory.getInstance().tryUpdateToken(false, false, TokenConstants.FRONTIER_LOGOUT, str, str2, str3);
        }
    }

    public static String getXTTToken() {
        TokenObject tokenObject = getTokenObject();
        if (tokenObject != null) {
            return tokenObject.token;
        }
        return null;
    }

    public static TokenObject getTokenObject() {
        if (isInited()) {
            return TokenFactory.getInstance().getTokenObject();
        }
        return null;
    }

    public static ConsumerRequestContent getTokenGuardContent(String str, String str2, TokenObject tokenObject) {
        if (!isInited() || tokenObject == null) {
            return null;
        }
        return TokenFactory.getInstance().getUseTicketGuardParams(new ConsumerRequestParamWithTsSign(tokenObject.tsSign, tokenObject.token, str, str2, TokenConstants.X_TT_TOKEN_TICKET_NAME));
    }

    public static void addTokenProcessor(TokenProcessor tokenProcessor) {
        if (tokenProcessors == null) {
            tokenProcessors = new ArrayList();
        }
        tokenProcessors.add(tokenProcessor);
    }

    public static void removeTokenProcessor(TokenProcessor tokenProcessor) {
        List<TokenProcessor> list = tokenProcessors;
        if (list != null) {
            list.remove(tokenProcessor);
        }
    }

    public static void removeAllTokenProcessors() {
        List<TokenProcessor> list = tokenProcessors;
        if (list != null) {
            list.clear();
        }
    }

    public static void setExceptionCatcher(IExceptionCatcher iExceptionCatcher) {
        exceptionCatcher = iExceptionCatcher;
    }

    public static void onException(Throwable th) {
        IExceptionCatcher iExceptionCatcher = exceptionCatcher;
        if (iExceptionCatcher != null) {
            iExceptionCatcher.onException(th);
        }
    }

    public static void setSessionManager(ISessionManager iSessionManager) {
        sessionManager = iSessionManager;
    }

    public static void setLogger(ILogger iLogger) {
        logger = iLogger;
    }

    public static boolean isNetworkAvailable() {
        if (getApplicationContext() == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getUrl(String str) {
        return "https://" + getHost() + str;
    }

    public static void setRequestTagHeaderProvider(IRequestTagHeaderProvider iRequestTagHeaderProvider) {
        requestTagHeaderProvider = iRequestTagHeaderProvider;
    }

    public static void request(String str, Map<String, String> map, Map<String, String> map2, boolean z, ITokenService.Callback callback) {
        ITokenService iTokenService = tokenService;
        if (iTokenService != null) {
            iTokenService.request(str, map, map2, z, callback);
        }
    }

    public static void userInfo(String str, ITokenService.Callback callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(TokenConstants.SCENE_KEY, str);
        HashMap hashMap2 = new HashMap();
        TTHeader requestTagHeader = getRequestTagHeader(true);
        if (requestTagHeader != null) {
            hashMap2.put(requestTagHeader.getName(), requestTagHeader.getValue());
        }
        request("https://" + getHost() + TokenConstants.ACCOUNT_USERINFO_URL_PATH_NEW, hashMap2, hashMap, true, callback);
    }

    public static void logout(final String str, final ITokenService.Callback callback) {
        HashMap hashMap = new HashMap();
        hashMap.put(TokenConstants.LOGOUT_FROM_KEY, str);
        request("https://" + getHost() + TokenConstants.USER_LOGOUT_URL_PATH_NEW, null, hashMap, false, new ITokenService.Callback() { // from class: com.ss.android.token.TTTokenManager.1
            @Override // com.ss.android.token.ITokenService.Callback
            public void onSuccess(ITokenService.Response response) {
                ITokenService.Callback callback2 = ITokenService.Callback.this;
                if (callback2 != null) {
                    callback2.onSuccess(response);
                }
                if (TTTokenManager.sessionManager != null) {
                    TTTokenManager.sessionManager.notifyLogout(str);
                }
            }

            @Override // com.ss.android.token.ITokenService.Callback
            public void onError(ITokenService.Response response) {
                ITokenService.Callback callback2 = ITokenService.Callback.this;
                if (callback2 != null) {
                    callback2.onError(response);
                }
            }
        });
    }

    public static Context getApplicationContext() {
        ITokenService iTokenService = tokenService;
        if (iTokenService != null) {
            return iTokenService.getApplicationContext();
        }
        return null;
    }

    public static boolean isLogin() {
        ITokenService iTokenService = tokenService;
        if (iTokenService == null) {
            return false;
        }
        return iTokenService.isLogin();
    }

    public static void log(String str, String str2) {
        log(3, str, str2);
    }

    public static void log(int i, String str, String str2) {
        if (logger != null) {
            logger.log(i, str, str2);
        }
    }

    public static void onEvent(String str, JSONObject jSONObject) {
        ITokenService iTokenService = tokenService;
        if (iTokenService != null) {
            iTokenService.onEvent(str, jSONObject);
        }
    }

    public static void invalidSession(boolean z) {
        ISessionManager iSessionManager = sessionManager;
        if (iSessionManager != null) {
            iSessionManager.invalidSession(z);
        }
    }

    public static String getHost() {
        return tokenService.host();
    }

    public static TTHeader getRequestTagHeader(boolean z) {
        IRequestTagHeaderProvider iRequestTagHeaderProvider = requestTagHeaderProvider;
        if (iRequestTagHeaderProvider != null) {
            return iRequestTagHeaderProvider.getRequestTagHeader(z);
        }
        return null;
    }

    public static void setTokenService(ITokenService iTokenService) {
        tokenService = iTokenService;
    }

    public static boolean isLocalTest() {
        return isLocalTest;
    }

    public static void setLocalTest(boolean z) {
        isLocalTest = z;
    }

    public static void showSelfCheckError(String str, String str2) {
        ITokenService iTokenService = tokenService;
        if (iTokenService != null) {
            iTokenService.onSelfCheckError(str, str2);
        }
    }

    public static JSONObject getSettings() {
        ITokenService iTokenService = tokenService;
        if (iTokenService != null) {
            return iTokenService.getSettings();
        }
        return null;
    }

    public static INetwork getTicketNetwork() {
        ITokenService iTokenService = tokenService;
        if (iTokenService != null) {
            return iTokenService.getTicketNetwork();
        }
        return null;
    }
}
