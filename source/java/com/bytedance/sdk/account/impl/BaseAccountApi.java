package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.account.CsrfTokenManager;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.api.pool.IApiController;
import com.bytedance.sdk.account.api.pool.IApiThreadPool;
import com.bytedance.sdk.account.api.pool.IBaseAccountJob;
import com.bytedance.sdk.account.api.pool.IJobController;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.sdk.account.error.handler.ErrorHandler;
import com.bytedance.sdk.account.error.handler.ErrorHandlerCenter;
import com.bytedance.sdk.account.execute.ApiRequest;
import com.bytedance.sdk.account.execute.ApiResponse;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.account.settings.AuthExpirationConfigManager;
import com.bytedance.sdk.account.utils.AbsApiThread;
import com.bytedance.sdk.account.utils.NetUtils;
import com.bytedance.sdk.account.utils.NetworkUtils;
import com.bytedance.sdk.account.utils.UrlBuilder;
import com.bytedance.sdk.account.utils.Utils;
import com.bytedance.sdk.xbridge.cn.runtime.utils.XBridgeAPIRequestUtils;
import com.ss.android.LogHelper;
import com.ss.android.TTHeader;
import com.ss.android.TTRequest;
import com.ss.android.TTResponse;
import com.ss.android.account.TTAccountInit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class BaseAccountApi<R extends BaseApiResponse> implements IBaseAccountJob, IApiController {
    public static final String KEY_IGNORE_COMMON_PARAM = "account_sdk_ignore_common_param";
    public static final String PASSPORT_CSRF_TOKEN_DEFAULT_KEY_KEY = "passport_csrf_token_default";
    public static final String PASSPORT_CSRF_TOKEN_KEY_KEY = "passport_csrf_token";
    private static final String TAG = "BaseAccountApi";
    public static final String USE_NEW_TOKEN_EXPIRE_RULE = "use_new_token_expire_rule";
    protected ApiRequest apiRequest;
    protected ApiResponse apiResponse;
    private boolean executeStatus;
    protected AbsApiCall mApiCall;
    protected Context mContext;
    private String mPath;
    private IJobController mPoolJobController;
    private int requestCsrfToken = 0;
    private String requestSessionId;
    private String requestXTTToken;
    protected TTResponse response;
    String responseCsrfToken;
    boolean responseSessionId;
    boolean responseXTTToken;
    private static IApiThreadPool threadPool = new IApiThreadPool() { // from class: com.bytedance.sdk.account.impl.BaseAccountApi.2
        @Override // com.bytedance.sdk.account.api.pool.IApiThreadPool
        public IJobController start(IBaseAccountJob iBaseAccountJob) {
            AccountApiThread accountApiThread = new AccountApiThread(iBaseAccountJob);
            accountApiThread.start();
            return accountApiThread;
        }
    };
    private static IDispatchSender sDispatch = new IDispatchSender() { // from class: com.bytedance.sdk.account.impl.BaseAccountApi.3
        @Override // com.bytedance.sdk.account.impl.IDispatchSender
        public void dispatch(ResponseCallable responseCallable) {
            Handler dispatchHandler = BDAccountManager.instance(TTAccountInit.getConfig().getApplicationContext()).getDispatchHandler();
            Message obtain = Message.obtain(dispatchHandler, 100);
            obtain.obj = responseCallable;
            dispatchHandler.sendMessage(obtain);
        }
    };

    public abstract void onSendEvent(R r);

    protected abstract void onStatusError(JSONObject jSONObject, JSONObject jSONObject2);

    protected abstract void parseData(JSONObject jSONObject, JSONObject jSONObject2) throws Exception;

    protected abstract R transformResponse(boolean z, ApiResponse apiResponse);

    public BaseAccountApi(Context context, ApiRequest apiRequest, AbsApiCall absApiCall) {
        this.mContext = context.getApplicationContext();
        this.mPath = apiRequest.url;
        this.apiRequest = apiRequest;
        this.mApiCall = absApiCall;
        if (absApiCall != null) {
            absApiCall.attachController(this);
        }
        this.apiResponse = new ApiResponse(apiRequest);
    }

    @Override // com.bytedance.sdk.account.api.pool.IJobController
    public void cancel() {
        releaseRef();
        IJobController iJobController = this.mPoolJobController;
        if (iJobController != null) {
            iJobController.cancel();
        }
    }

    @Override // com.bytedance.sdk.account.api.pool.IApiController
    public void releaseRef() {
        this.mApiCall = null;
    }

    protected void onPostData(R r) {
        dispatchInvokeCallBack(new ResponseCallable(this.mApiCall, r));
    }

    private void run() {
        final R execute = execute();
        if (execute != null) {
            ApiResponse apiResponse = this.apiResponse;
            if (apiResponse != null) {
                execute.mRequestUrl = apiResponse.mRequestUrl;
                execute.logId = this.apiResponse.logId;
                execute.secondaryDecisionConf = this.apiResponse.secondaryDecisionConf;
                execute.headers = this.apiResponse.headers;
                execute.result = this.apiResponse.body;
            }
            if (TextUtils.isEmpty(execute.mRequestUrl)) {
                execute.mRequestUrl = this.mPath;
            }
            onSendEvent(execute);
            if (this.apiResponse.mError != 0) {
                ErrorHandler.HandlerCallback handlerCallback = new ErrorHandler.HandlerCallback() { // from class: com.bytedance.sdk.account.impl.BaseAccountApi.1
                    @Override // com.bytedance.sdk.account.error.handler.ErrorHandler.HandlerCallback
                    public void onHandlerResult(boolean z, boolean z2, Map<String, String> map) {
                        onHandlerResult(z, z2, map, null);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.bytedance.sdk.account.error.handler.ErrorHandler.HandlerCallback
                    public void onHandlerResult(boolean z, boolean z2, Map<String, String> map, BaseApiResponse baseApiResponse) {
                        if (z && z2) {
                            if (map != null && !map.isEmpty()) {
                                if (BaseAccountApi.this.apiRequest.parms != null) {
                                    BaseAccountApi.this.apiRequest.parms.putAll(map);
                                } else {
                                    BaseAccountApi baseAccountApi = BaseAccountApi.this;
                                    baseAccountApi.apiRequest = baseAccountApi.apiRequest.newBuilder().parameters(map).build();
                                }
                            }
                            BaseAccountApi.this.apiResponse = new ApiResponse(BaseAccountApi.this.apiRequest);
                            BaseAccountApi.this.start();
                            return;
                        }
                        if (z && baseApiResponse != null) {
                            BaseAccountApi.this.reverseResponse(baseApiResponse);
                            final BaseApiResponse transformResponse = BaseAccountApi.this.transformResponse(baseApiResponse.success, BaseAccountApi.this.apiResponse);
                            if (BaseAccountApi.this.mApiCall == null || transformResponse == null) {
                                return;
                            }
                            transformResponse.headers = baseApiResponse.headers;
                            transformResponse.result = baseApiResponse.result;
                            transformResponse.mRequestUrl = baseApiResponse.mRequestUrl;
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                BaseAccountApi.this.mApiCall.dispatchOnResponse(transformResponse);
                                return;
                            } else {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.account.impl.BaseAccountApi.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        BaseAccountApi.this.mApiCall.dispatchOnResponse(transformResponse);
                                    }
                                });
                                return;
                            }
                        }
                        execute.error = AccountErrorCode.CommonError.COMMON_ERROR_HANDLER_FAIL;
                        execute.errorMsg = "";
                        BaseAccountApi.this.onPostData(execute);
                    }
                };
                ErrorHandler handler = ErrorHandlerCenter.getHandler(this.apiResponse.mError);
                if (handler != null && handler.handle(this.apiResponse.mError, this.apiRequest.parms, this.apiResponse.body, handlerCallback)) {
                    return;
                }
                Iterator<ErrorHandler> it = ErrorHandlerCenter.getGlobalHandlerList().iterator();
                while (it.hasNext()) {
                    if (it.next().handle(this.apiResponse.mError, this.apiRequest.parms, this.apiResponse.body, handlerCallback)) {
                        return;
                    }
                }
            }
            onPostData(execute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reverseResponse(BaseApiResponse baseApiResponse) {
        if (this.apiResponse == null) {
            this.apiResponse = new ApiResponse(this.apiRequest);
        }
        this.apiResponse.mRequestUrl = baseApiResponse.mRequestUrl;
        List<TTHeader> list = baseApiResponse.headers;
        this.apiResponse.headers = list;
        if (list != null) {
            for (TTHeader tTHeader : list) {
                if (XBridgeAPIRequestUtils.X_TT_LOG_ID.equalsIgnoreCase(tTHeader.getName())) {
                    String value = tTHeader.getValue();
                    if (!TextUtils.isEmpty(value)) {
                        this.apiResponse.logId = value;
                    }
                }
                if (AccountConstants.X_TT_TOKEN.equalsIgnoreCase(tTHeader.getName())) {
                    String value2 = tTHeader.getValue();
                    if (!TextUtils.isEmpty(value2)) {
                        this.apiResponse.xTtToken = value2;
                    }
                }
            }
        }
        if (baseApiResponse.result != null) {
            try {
                parseBody(baseApiResponse.result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.sdk.account.api.pool.IBaseAccountJob
    public void runInPool() {
        run();
    }

    public final void start() {
        this.mPoolJobController = threadPool.start(this);
    }

    public R execute() {
        this.executeStatus = false;
        try {
            this.executeStatus = executeRequest();
        } catch (Throwable th) {
            th.printStackTrace();
            this.apiResponse.mError = NetUtils.checkApiException(this.mContext, th);
            AccountMonitorUtil.netExceptionEvent(this.apiRequest.url, th, this.apiResponse.mError, "");
            this.apiResponse.mDetailErrorMsg = th.getMessage();
        }
        R transformResponse = transformResponse(this.executeStatus, this.apiResponse);
        applyExceptionError(transformResponse);
        return transformResponse;
    }

    private void applyExceptionError(BaseApiResponse baseApiResponse) {
        T t;
        T t2;
        if (baseApiResponse != null) {
            if (this.apiResponse.mError < 0) {
                if (this.apiResponse.mError == -26 || this.apiResponse.mError == -27) {
                    baseApiResponse.error = AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_DOWNGRADE;
                } else {
                    baseApiResponse.error = AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API;
                }
                baseApiResponse.mDetailErrorCode = this.apiResponse.mError;
                if ((baseApiResponse instanceof MobileApiResponse) && (t2 = ((MobileApiResponse) baseApiResponse).mobileObj) != 0) {
                    t2.mError = baseApiResponse.error;
                    t2.mDetailErrorCode = this.apiResponse.mError;
                }
            } else if (this.apiResponse.mError > 0) {
                baseApiResponse.mDetailErrorCode = this.apiResponse.mError;
                if ((baseApiResponse instanceof MobileApiResponse) && (t = ((MobileApiResponse) baseApiResponse).mobileObj) != 0) {
                    t.mDetailErrorCode = this.apiResponse.mError;
                }
            }
            if (this.apiResponse.mError != 0) {
                if (TextUtils.isEmpty(baseApiResponse.mDetailErrorMsg)) {
                    baseApiResponse.mDetailErrorMsg = this.apiResponse.mDetailErrorMsg != null ? this.apiResponse.mDetailErrorMsg : "";
                }
                AccountMonitorUtil.netExceptionEvent(this.apiRequest.url, null, this.apiResponse.mError, this.apiResponse.mDetailErrorMsg);
            }
        }
    }

    private void notSuccess(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        if ("error".equals(str) || "exception".equals(str)) {
            if (jSONObject2 == null) {
                jSONObject2 = jSONObject;
            }
            if (jSONObject2 != null) {
                if (jSONObject2.has("error_code")) {
                    ApiResponse apiResponse = this.apiResponse;
                    apiResponse.mError = jSONObject2.optInt("error_code", apiResponse.mError);
                } else if (jSONObject2.has("code")) {
                    ApiResponse apiResponse2 = this.apiResponse;
                    apiResponse2.mError = jSONObject2.optInt("code", apiResponse2.mError);
                }
                this.apiResponse.mErrorMsg = jSONObject2.optString("description");
                ApiResponse apiResponse3 = this.apiResponse;
                apiResponse3.mDetailErrorMsg = apiResponse3.mErrorMsg;
                this.apiResponse.decisionConf = jSONObject2.optString("verify_center_decision_conf");
                this.apiResponse.secondaryDecisionConf = jSONObject2.optString("verify_center_secondary_decision_conf");
                onStatusError(jSONObject2, jSONObject);
            }
        }
    }

    private boolean executeRequest() throws Exception {
        Context context = this.mContext;
        if (context == null) {
            this.apiResponse.mError = -24;
            this.apiResponse.mDetailErrorMsg = AccountErrorCode.ErrorMsg.ERROR_NULL_CONTEXT;
            return false;
        }
        if (!NetUtils.isNetworkAvailable(context)) {
            this.apiResponse.mError = -12;
            this.apiResponse.mDetailErrorMsg = AccountErrorCode.ErrorMsg.ERROR_NO_CONNECTION;
            return false;
        }
        Map<String, String> filterParams = filterParams(this.apiRequest.parms, this.apiRequest.valueNullable);
        checkRequestCookie(this.mPath);
        long currentTimeMillis = System.currentTimeMillis();
        if (ApiRequest.METHOD_GET.equals(this.apiRequest.method)) {
            this.response = executeGet(this.mPath, filterParams, this.apiRequest.headers);
        } else if (ApiRequest.METHOD_POST.equals(this.apiRequest.method)) {
            this.response = executePost(this.mPath, filterParams, this.apiRequest.headers);
        } else if (ApiRequest.METHOD_POST_FILE.equals(this.apiRequest.method)) {
            this.response = postFile(this.mPath, filterParams, this.apiRequest.headers, this.apiRequest.paramName, this.apiRequest.filePath);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        parseHeaders(this.response);
        TTResponse tTResponse = this.response;
        if (tTResponse == null || StringUtils.isEmpty(tTResponse.getBody())) {
            this.apiResponse.mError = -25;
            this.apiResponse.mDetailErrorMsg = "response null";
            return false;
        }
        boolean parseBody = parseBody(new JSONObject(this.response.getBody()));
        monitorNetRequest(currentTimeMillis2, this.apiResponse.logId);
        return parseBody;
    }

    private void checkRequestCookie(String str) {
        this.requestSessionId = Utils.getSpecialCookieInfo(str, "sessionid");
    }

    private void monitorNetRequest(long j, String str) {
        Uri parse = Uri.parse(this.mPath);
        String host = parse.getHost();
        String path = parse.getPath();
        if (!TextUtils.isEmpty(this.responseCsrfToken)) {
            LogHelper.d(TAG, String.format("Passport service has set csrf token: host=%s, path=%s, logid=%s", host, path, str));
        }
        if (this.responseXTTToken) {
            LogHelper.d(TAG, String.format("Passport service has set x-tt-token: host=%s, path=%s, logid=%s", host, path, str));
        }
        if (this.responseSessionId) {
            LogHelper.d(TAG, String.format("set-cookie sessionid: host=%s, path=%s, logid=%s", host, path, str));
        }
        AccountMonitorUtil.netEvent(host, path, j, this.apiResponse.mError, this.apiResponse.mDetailErrorMsg, str, !TextUtils.isEmpty(this.requestXTTToken), this.requestCsrfToken, this.responseXTTToken, !TextUtils.isEmpty(this.responseCsrfToken), CsrfTokenManager.getCsrfTokenStatus());
        if (TextUtils.isEmpty(this.requestXTTToken) || !this.requestXTTToken.contains(this.requestSessionId)) {
            return;
        }
        AccountMonitorUtil.eventTokenError(host, path, str);
    }

    private void parseHeaders(TTResponse tTResponse) {
        char c;
        int i;
        if (tTResponse != null) {
            try {
                List<TTHeader> headers = tTResponse.getHeaders();
                this.apiResponse.headers = headers;
                if (headers != null) {
                    for (TTHeader tTHeader : headers) {
                        String name = tTHeader.getName();
                        if (!TextUtils.isEmpty(name)) {
                            String value = tTHeader.getValue();
                            if (!TextUtils.isEmpty(value)) {
                                String lowerCase = name.toLowerCase();
                                switch (lowerCase.hashCode()) {
                                    case -694021551:
                                        if (lowerCase.equals(AccountConstants.MULTI_SID_KEY)) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                    case -272647289:
                                        if (lowerCase.equals(XBridgeAPIRequestUtils.X_TT_LOG_ID)) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case -265255391:
                                        if (lowerCase.equals(AccountConstants.X_TT_TOKEN)) {
                                            c = 4;
                                            break;
                                        }
                                        break;
                                    case 1200578924:
                                        if (lowerCase.equals(AccountConstants.HEADER_SESSION_SIGN)) {
                                            c = 2;
                                            break;
                                        }
                                        break;
                                    case 1237214767:
                                        if (lowerCase.equals("set-cookie")) {
                                            c = 3;
                                            break;
                                        }
                                        break;
                                }
                                c = 65535;
                                if (c == 0) {
                                    updateMultiSid(value);
                                } else if (c == 1) {
                                    this.apiResponse.logId = value;
                                } else if (c == 2) {
                                    BDAccountManager.instance(this.mContext).setXttSessionSign(value);
                                } else if (c != 3) {
                                    if (c == 4) {
                                        this.apiResponse.xTtToken = value;
                                        this.responseXTTToken = true;
                                    }
                                } else if (value.contains("sessionid")) {
                                    this.responseSessionId = true;
                                    Utils.flushCookie();
                                } else if (value.startsWith("passport_csrf_token=") || (TextUtils.isEmpty(this.responseCsrfToken) && value.startsWith("passport_csrf_token_default="))) {
                                    int indexOf = value.indexOf("=");
                                    int indexOf2 = value.indexOf(";");
                                    if (indexOf2 == -1) {
                                        indexOf2 = value.length();
                                    }
                                    if (indexOf > 0 && (i = indexOf + 1) < value.length()) {
                                        String substring = value.substring(i, indexOf2);
                                        this.responseCsrfToken = substring;
                                        CsrfTokenManager.setCsrfToken(substring);
                                    }
                                }
                            }
                        }
                    }
                }
                TTRequest ttRequest = tTResponse.getTtRequest();
                if (ttRequest != null) {
                    for (TTHeader tTHeader2 : ttRequest.headers) {
                        if ("X-Tt-Token".equalsIgnoreCase(tTHeader2.getName())) {
                            this.requestXTTToken = tTHeader2.getValue();
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean parseBody(JSONObject jSONObject) {
        this.apiResponse.body = jSONObject;
        JSONObject parseData = parseData(jSONObject);
        String optString = jSONObject.optString("message");
        try {
            if (!TextUtils.isEmpty(optString)) {
                return parseInner(jSONObject, parseData, optString);
            }
            if (parseData != null) {
                return parseInner(parseData, parseData(parseData), parseData.optString("message"));
            }
            return parseInner(jSONObject, new JSONObject(), "success");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void updateMultiSid(String str) {
        Context context = this.mContext;
        if (context != null) {
            BDAccountManager.instance(context).updateMultiSid(str);
        }
    }

    private JSONObject parseData(JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        if (jSONObject != null && jSONObject.has("data")) {
            try {
                Object opt = jSONObject.opt("data");
                if (opt == null) {
                    return null;
                }
                if (opt instanceof JSONObject) {
                    jSONObject2 = (JSONObject) opt;
                } else if (opt instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) opt;
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("data", jSONArray);
                        jSONObject2 = jSONObject3;
                    } catch (Exception e) {
                        e = e;
                        jSONObject2 = jSONObject3;
                        e.printStackTrace();
                        return jSONObject2;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return jSONObject2;
    }

    private boolean parseInner(JSONObject jSONObject, JSONObject jSONObject2, String str) throws Exception {
        if (!"success".equals(str)) {
            notSuccess(str, jSONObject, jSONObject2);
            return false;
        }
        if (jSONObject2 == null) {
            return true;
        }
        parseData(jSONObject, jSONObject2);
        return true;
    }

    private TTResponse executeGet(String str, Map<String, String> map, List<TTHeader> list) throws Exception {
        UrlBuilder pathWithCommonQuery = getPathWithCommonQuery(str);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                pathWithCommonQuery.addParam(entry.getKey(), entry.getValue());
            }
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (TTAccountInit.getConfig().isSupportMultiLogin()) {
            pathWithCommonQuery.addParam("multi_login", "1");
            addRequestHeader(list);
        }
        addCustomHeader(list);
        addCsrfToken(str, list);
        pathWithCommonQuery.addParam(AccountMonitorConstants.SDK_SOURCE, "app");
        pathWithCommonQuery.addParam(AccountMonitorConstants.PASSPORT_SUPPORT_FLOW, ErrorHandlerCenter.getPassportSupportFlow());
        String urlBuilder = pathWithCommonQuery.toString();
        this.apiResponse.mRequestUrl = urlBuilder;
        return NetworkUtils.executeGet(Integer.MAX_VALUE, urlBuilder, list);
    }

    public void addRequestHeader(List<TTHeader> list) {
        try {
            Context context = this.mContext;
            String multiSid = context != null ? BDAccountManager.instance(context).getMultiSid() : null;
            if (TextUtils.isEmpty(multiSid)) {
                return;
            }
            list.add(new TTHeader(AccountConstants.MULTI_SID_KEY, multiSid));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCustomHeader(List<TTHeader> list) {
        try {
            if (this.apiRequest.headers != null) {
                list.addAll(this.apiRequest.headers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCsrfToken(String str, List<TTHeader> list) {
        try {
            Pair<Integer, String> csrfToken = CsrfTokenManager.getCsrfToken(str);
            this.requestCsrfToken = ((Integer) csrfToken.first).intValue();
            String str2 = (String) csrfToken.second;
            if (!TextUtils.isEmpty(str2)) {
                list.add(new TTHeader(AccountConstants.CSRF_TOKEN_KEY, str2));
                CsrfTokenManager.setCsrfToken(str2);
            } else {
                LogHelper.d(TAG, String.format("Csrf token is empty: csrf_token_status=%s, cookie for url=%s, cookie for domain=%s", Boolean.valueOf(CsrfTokenManager.getCsrfTokenStatus()), Utils.getAllCookieKeys(str), Utils.getAllCookieKeysForDomain(str)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TTResponse executePost(String str, Map<String, String> map, List<TTHeader> list) throws Exception {
        HashMap hashMap = new HashMap();
        UrlBuilder pathWithCommonQuery = getPathWithCommonQuery(str);
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(AccountMonitorConstants.SDK_SOURCE, "app");
        hashMap.put(AccountMonitorConstants.PASSPORT_SUPPORT_FLOW, ErrorHandlerCenter.getPassportSupportFlow());
        if (list == null) {
            list = new ArrayList<>();
        }
        if (TTAccountInit.getConfig().isSupportMultiLogin()) {
            hashMap.put("multi_login", "1");
            addRequestHeader(list);
        }
        addCustomHeader(list);
        addCsrfToken(str, list);
        String urlBuilder = pathWithCommonQuery.toString();
        this.apiResponse.mRequestUrl = urlBuilder;
        return NetworkUtils.executePost(Integer.MAX_VALUE, urlBuilder, hashMap, list);
    }

    private TTResponse postFile(String str, Map<String, String> map, List<TTHeader> list, String str2, String str3) throws Exception {
        HashMap hashMap = new HashMap();
        UrlBuilder pathWithCommonQuery = getPathWithCommonQuery(str);
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(AccountMonitorConstants.SDK_SOURCE, "app");
        hashMap.put(AccountMonitorConstants.PASSPORT_SUPPORT_FLOW, ErrorHandlerCenter.getPassportSupportFlow());
        if (list == null) {
            list = new ArrayList<>();
        }
        List<TTHeader> list2 = list;
        if (TTAccountInit.getConfig().isSupportMultiLogin()) {
            hashMap.put("multi_login", "1");
            addRequestHeader(list2);
        }
        addCustomHeader(list2);
        addCsrfToken(str, list2);
        String urlBuilder = pathWithCommonQuery.toString();
        this.apiResponse.mRequestUrl = urlBuilder;
        return NetworkUtils.postFile(Integer.MAX_VALUE, urlBuilder, hashMap, str2, str3, list2);
    }

    private UrlBuilder getPathWithCommonQuery(String str) {
        UrlBuilder urlBuilder = new UrlBuilder(str);
        urlBuilder.addParam(AuthorizeMonitorUtil.Param.PASSPORT_SDK_VERSION, 505180);
        if (AuthExpirationConfigManager.isEnable()) {
            urlBuilder.addParam(USE_NEW_TOKEN_EXPIRE_RULE, "true");
        }
        return urlBuilder;
    }

    private Map<String, String> filterParams(Map<String, String> map, boolean z) {
        if (map == null || map.size() <= 0) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && (z || !TextUtils.isEmpty(entry.getValue()))) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class AccountApiThread extends AbsApiThread implements IJobController {
        private IBaseAccountJob thread;

        private AccountApiThread(IBaseAccountJob iBaseAccountJob) {
            this.thread = iBaseAccountJob;
        }

        @Override // com.bytedance.sdk.account.network.dispatcher.ApiThread, java.lang.Runnable
        public void run() {
            this.thread.runInPool();
        }
    }

    public static void dispatchInvokeCallBack(ResponseCallable responseCallable) {
        sDispatch.dispatch(responseCallable);
    }
}
