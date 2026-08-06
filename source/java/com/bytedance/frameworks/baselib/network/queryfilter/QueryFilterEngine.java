package com.bytedance.frameworks.baselib.network.queryfilter;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import coil3.network.internal.Utils_commonKt;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.mime.AbsTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class QueryFilterEngine {
    private static final String CIPHER_VERSION_HEADER = "x-tt-cipher-version";
    private static final String CIPHER_VERSION_VALUE = "1.0.0";
    private static final String ENCRYPT_INFO_HEADER = "x-tt-encrypt-info";
    private static final String KEY_ACTION_NAME = "action";
    private static final String KEY_ACTION_PARAM = "param";
    private static final String KEY_ACTION_PRIORITY = "act_priority";
    public static final String KEY_L0_PARAMS = "L0_params";
    public static final String KEY_QUERY_FILTER_CONFIG = "query_filter_actions";
    public static final String KEY_QUERY_FILTER_ENABLED = "query_filter_enabled";
    private static final String KEY_SET_REQ_PRIORITY = "set_req_priority";
    private static final String TAG = "QueryFilterEngine";
    private static volatile QueryFilterEngine sInstance;
    private volatile String mLocalConfig;
    private volatile boolean mQueryFilterEnabled = false;
    private List<QueryFilterAction> mQueryFilterActions = new CopyOnWriteArrayList();
    private List<String> mL0ParamsList = new CopyOnWriteArrayList();
    private boolean mEnableNewSpaceEncodeRule = false;
    private boolean mOptRetrofitLog = true;

    public static QueryFilterEngine inst() {
        if (sInstance == null) {
            synchronized (QueryFilterEngine.class) {
                if (sInstance == null) {
                    sInstance = new QueryFilterEngine();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public class SortActionByPriority implements Comparator<QueryFilterAction> {
        SortActionByPriority() {
        }

        @Override // java.util.Comparator
        public int compare(QueryFilterAction queryFilterAction, QueryFilterAction queryFilterAction2) {
            return queryFilterAction.getPriority() - queryFilterAction2.getPriority();
        }
    }

    public void setLocalCommonParamsConfig(String str) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(Constants.KEY_DATA);
            int optInt = jSONObject.optInt(KEY_QUERY_FILTER_ENABLED, 0);
            enableQueryFilterEngine(optInt > 0);
            parseL0ParamsString(jSONObject.optString(KEY_L0_PARAMS, ""));
            if (optInt > 0) {
                parseCommonParamsConfig(jSONObject.getString(KEY_QUERY_FILTER_CONFIG));
            }
        } catch (JSONException e) {
            Logger.e(TAG, "Local common params config is invalid: " + str);
            throw e;
        }
    }

    public void enableQueryFilterEngine(boolean z) {
        this.mQueryFilterEnabled = z;
    }

    public void onNetConfigChanged(String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "onNetConfigChanged config: " + str + " enabled: " + this.mQueryFilterEnabled);
        }
        if (!this.mQueryFilterEnabled || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            parseCommonParamsConfig(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void parseL0ParamsString(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mL0ParamsList.clear();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.mL0ParamsList.add(jSONArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> removeL0CommonParams(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            Iterator<String> it = this.mL0ParamsList.iterator();
            while (it.hasNext()) {
                map.remove(it.next());
            }
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String filterUrlWithCommonParams(String str) {
        LinkedHashMap linkedHashMap;
        Pair<String, String> parseUrlWithValueList;
        List<String> value;
        if (!this.mQueryFilterEnabled || TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            linkedHashMap = new LinkedHashMap();
            parseUrlWithValueList = UrlUtils.parseUrlWithValueList(str, linkedHashMap);
        } catch (Throwable th) {
            th = th;
        }
        if (parseUrlWithValueList == null || linkedHashMap.isEmpty() || !dispatchQueryMap(new Request(Utils_commonKt.HTTP_METHOD_GET, str, (List) null, (TypedOutput) null, 0, false, -1, false, (Object) null), linkedHashMap)) {
            return str;
        }
        UrlBuilder urlBuilder = new UrlBuilder(((String) parseUrlWithValueList.first) + ((String) parseUrlWithValueList.second));
        if (!linkedHashMap.isEmpty()) {
            for (Map.Entry<String, List<String>> entry : linkedHashMap.entrySet()) {
                if (entry != null && entry.getKey() != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                    Iterator<String> it = value.iterator();
                    while (it.hasNext()) {
                        urlBuilder.addParam(entry.getKey(), it.next());
                    }
                }
            }
        }
        String str2 = urlBuilder.build();
        try {
            String encodedFragment = Uri.parse(str).getEncodedFragment();
            if (!TextUtils.isEmpty(encodedFragment)) {
                str2 = str2 + "#" + encodedFragment;
            }
        } catch (Throwable th2) {
            th = th2;
            str = str2;
            th.printStackTrace();
            str2 = str;
            if (!this.mEnableNewSpaceEncodeRule) {
            }
        }
        return !this.mEnableNewSpaceEncodeRule ? UrlUtils.replacePlusInEncodeUrl(str2) : str2;
    }

    public Request filterQuery(Request request) {
        String str;
        List<String> value;
        List<String> list;
        if (!this.mQueryFilterEnabled) {
            if (Logger.debug()) {
                Logger.d(TAG, "Query filter engine is not enabled");
            }
            return null;
        }
        if (request.isPureRequest()) {
            return null;
        }
        String url = request.getUrl();
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        if (request.getMetrics() != null) {
            request.getMetrics().queryFilterStart();
        }
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Pair<String, String> parseUrlWithValueList = UrlUtils.parseUrlWithValueList(url, linkedHashMap);
            if (parseUrlWithValueList == null) {
                return null;
            }
            if (!dispatchQueryMap(request, linkedHashMap)) {
                if (request.getMetrics() != null) {
                    request.getMetrics().queryFilterEnd();
                }
                return null;
            }
            if (!request.isQueryEncryptEnabled() || !linkedHashMap.containsKey("x-tt-encrypt-queries") || (list = linkedHashMap.get("x-tt-encrypt-queries")) == null || list.size() <= 0) {
                str = null;
            } else {
                str = list.get(0);
                linkedHashMap.remove("x-tt-encrypt-queries");
            }
            UrlBuilder urlBuilder = new UrlBuilder(((String) parseUrlWithValueList.first) + ((String) parseUrlWithValueList.second));
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry<String, List<String>> entry : linkedHashMap.entrySet()) {
                    if (entry != null && entry.getKey() != null && (value = entry.getValue()) != null && !value.isEmpty()) {
                        Iterator<String> it = value.iterator();
                        while (it.hasNext()) {
                            urlBuilder.addParam(entry.getKey(), it.next());
                        }
                    }
                }
            }
            Request.Builder newBuilder = request.newBuilder();
            tryEncryptRequest(newBuilder, request, str);
            newBuilder.url(urlBuilder.build());
            Request build = newBuilder.build();
            if (request.getMetrics() != null) {
                request.getMetrics().queryFilterEnd();
            }
            return build;
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                if (request.getMetrics() != null) {
                    request.getMetrics().queryFilterEnd();
                }
                return null;
            } finally {
                if (request.getMetrics() != null) {
                    request.getMetrics().queryFilterEnd();
                }
            }
        }
    }

    public List<QueryFilterAction> getQueryFilterActionsForTesting() {
        return this.mQueryFilterActions;
    }

    private QueryFilterEngine() {
    }

    private JSONArray dispatchQueryActionInfo(List<QueryActionInfo> list) {
        JSONArray jSONArray = new JSONArray();
        for (QueryActionInfo queryActionInfo : list) {
            try {
                long dispatchActionDuration = queryActionInfo.getDispatchActionDuration();
                if (!this.mOptRetrofitLog || queryActionInfo.isActionHit() || dispatchActionDuration > 0) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(BaseHttpRequestInfo.KEY_HIT, queryActionInfo.isActionHit());
                    jSONObject.put("priority", queryActionInfo.getActionPriority());
                    if (dispatchActionDuration > 0) {
                        jSONObject.put("consume", dispatchActionDuration);
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (Logger.debug()) {
            Logger.d(TAG, "action info: " + jSONArray.toString());
        }
        return jSONArray;
    }

    private boolean dispatchQueryMap(Request request, Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        request.setQueryFilterPriority(0);
        Iterator<QueryFilterAction> it = this.mQueryFilterActions.iterator();
        while (it.hasNext()) {
            if (it.next().takeAction(request, map, arrayList)) {
                z = true;
            }
        }
        if (Logger.debug()) {
            Logger.d(TAG, "dispatchQueryMap hit: " + z);
        }
        if (request.getMetrics() != null) {
            request.getMetrics().dispatchQueryActionInfo = dispatchQueryActionInfo(arrayList);
        }
        return z;
    }

    private synchronized void parseCommonParamsConfig(String str) throws JSONException {
        if (!TextUtils.isEmpty(this.mLocalConfig) && this.mLocalConfig.equals(str)) {
            if (Logger.debug()) {
                Logger.d(TAG, "Config is same with local config, do not parse.");
            }
            return;
        }
        ArrayList<QueryFilterAction> arrayList = new ArrayList<>();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            parseActionInfo(jSONArray.getJSONObject(i), arrayList);
        }
        Collections.sort(arrayList, new SortActionByPriority());
        this.mQueryFilterActions.clear();
        this.mQueryFilterActions.addAll(arrayList);
        this.mLocalConfig = str;
    }

    private void parseActionInfo(JSONObject jSONObject, ArrayList<QueryFilterAction> arrayList) throws JSONException {
        String string = jSONObject.getString("action");
        int i = jSONObject.getInt(KEY_ACTION_PRIORITY);
        if (i < 0) {
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(KEY_ACTION_PARAM);
        int optInt = jSONObject.optInt(KEY_SET_REQ_PRIORITY, i);
        if (optInt == -1) {
            optInt = Integer.MAX_VALUE;
        }
        QueryFilterAction createQueryFilterAction = QueryFilterAction.createQueryFilterAction(string, i, optInt, jSONObject2);
        if (createQueryFilterAction != null) {
            arrayList.add(createQueryFilterAction);
        }
    }

    private static void tryEncryptRequest(Request.Builder builder, Request request, String str) {
        boolean z;
        if (request.getBody() instanceof AbsTypedOutput) {
            z = request.getBody().isBodyEncrypted();
            if (z) {
                Logger.i(TAG, "Request body has been encrypted before.");
            }
        } else {
            z = false;
        }
        if (request.isQueryEncryptEnabled() || request.isBodyEncryptEnabled() || z) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(new Header("x-tt-encrypt-queries", str));
            }
            if (request.getHeaders() != null) {
                arrayList.addAll(request.getHeaders());
            }
            RetrofitMetrics metrics = request.getMetrics();
            if (!z && request.isBodyEncryptEnabled()) {
                AbsTypedOutput body = request.getBody();
                if (body instanceof AbsTypedOutput) {
                    AbsTypedOutput absTypedOutput = body;
                    if (metrics != null) {
                        metrics.bodyEncryptStart();
                    }
                    try {
                        z = absTypedOutput.interceptRequestBody();
                    } finally {
                        if (metrics != null) {
                            metrics.bodyEncryptEnd();
                        }
                    }
                }
            }
            RetrofitMetrics.EncryptType encryptType = RetrofitMetrics.EncryptType.ENCRYPT_NONE;
            if (z && request.isQueryEncryptEnabled()) {
                addRequestEncryptHeaders(arrayList, RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY);
                encryptType = RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY;
            } else if (z) {
                addRequestEncryptHeaders(arrayList, RetrofitMetrics.EncryptType.ENCRYPT_BODY);
                encryptType = RetrofitMetrics.EncryptType.ENCRYPT_BODY;
            } else if (request.isQueryEncryptEnabled()) {
                addRequestEncryptHeaders(arrayList, RetrofitMetrics.EncryptType.ENCRYPT_QUERY);
                encryptType = RetrofitMetrics.EncryptType.ENCRYPT_QUERY;
            }
            if (metrics != null) {
                metrics.setEncryptType(encryptType);
            }
            builder.headers(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static /* synthetic */ class C09301 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType;

        static {
            int[] iArr = new int[RetrofitMetrics.EncryptType.values().length];
            $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType = iArr;
            try {
                iArr[RetrofitMetrics.EncryptType.ENCRYPT_BOTH_QUERY_AND_BODY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[RetrofitMetrics.EncryptType.ENCRYPT_BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[RetrofitMetrics.EncryptType.ENCRYPT_QUERY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static void addRequestEncryptHeaders(List<Header> list, RetrofitMetrics.EncryptType encryptType) {
        int i = C09301.$SwitchMap$com$bytedance$retrofit2$RetrofitMetrics$EncryptType[encryptType.ordinal()];
        if (i == 1) {
            list.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
            list.add(new Header(ENCRYPT_INFO_HEADER, ExifInterface.GPS_MEASUREMENT_2D));
        } else if (i == 2) {
            list.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
            list.add(new Header(ENCRYPT_INFO_HEADER, DiskLruCache.VERSION));
        } else {
            if (i != 3) {
                return;
            }
            list.add(new Header(CIPHER_VERSION_HEADER, "1.0.0"));
            list.add(new Header(ENCRYPT_INFO_HEADER, "0"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void parseArrayListConfig(JSONArray jSONArray, List<String> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    list.add(string);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    public void setEnableNewSpaceEncodeRule(boolean z) {
        this.mEnableNewSpaceEncodeRule = z;
    }

    public boolean getEnableNewSpaceEncodeRule() {
        return this.mEnableNewSpaceEncodeRule;
    }

    public void setOptRetrofitLog(boolean z) {
        this.mOptRetrofitLog = z;
    }
}
