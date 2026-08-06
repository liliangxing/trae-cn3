package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CronetSsCallConfig {
    private static final int CONNECT_INTERVAL = 4000;
    private static final String KEY_BLOCK_ERROR_CODE_LIST = "block_code_list";
    private static final String KEY_BYPASS_ROUTE_SELECTION_ENABLED = "bypass_rs_enabled";
    private static final String KEY_CONCURRENT_HOST_GROUP = "concurrent_hosts";
    private static final String KEY_CONCURRENT_REQUEST_ENABLED = "enabled_v2";
    private static final String KEY_CONNECT_TIME_INTERVAL = "connect_interval_millis";
    private static final String KEY_CONTINUE_FAILED_COUNTS = "fail_count";
    private static final String KEY_FORBIDDEN_SECONDS = "forbid_seconds";
    private static final String KEY_HOST_GROUP = "host_group";
    private static final String KEY_MAX_WAIT_SECONDS = "max_wait_seconds";
    private static final String KEY_PATH_EQUAL_GROUP = "equal_group";
    private static final String KEY_PATH_PATTERN_GROUP = "pattern_group";
    private static final String KEY_PATH_PREFIX_GROUP = "prefix_group";
    private static final String KEY_REFINE_WITH_CONCURRENT_ROUTE = "concurrent_route";
    private static final String KEY_REFINE_WITH_ROUTE_SELECTION = "rs_name";
    private static final String KEY_REQUEST_FINISH_FIX_ENABLED = "fin_fix_enabled";
    private static final String KEY_RETRY_FOR_NOT_2XX_CODE = "retry_for_not_2xx_code";
    private static final String KEY_URL_MATCH_RULE = "match_rules";
    private static final String TAG = "CronetSsCallConfig";
    private static volatile CronetSsCallConfig sInstance;
    private volatile int mConcurrentRequestEnabled = 0;
    private List<UrlMatchRule> mUrlMatchRuleList = new CopyOnWriteArrayList();

    public static CronetSsCallConfig inst() {
        if (sInstance == null) {
            synchronized (CronetSsCallConfig.class) {
                if (sInstance == null) {
                    sInstance = new CronetSsCallConfig();
                }
            }
        }
        return sInstance;
    }

    private CronetSsCallConfig() {
    }

    public boolean isConcurrentRequestEnabled() {
        return this.mConcurrentRequestEnabled > 0;
    }

    public UrlMatchRule getUrlMatchRuleFromRequest(Request request) {
        recoverRuleStatusFromForbidden();
        for (UrlMatchRule urlMatchRule : this.mUrlMatchRuleList) {
            if (isUrlMatchRule(request, urlMatchRule)) {
                return urlMatchRule;
            }
        }
        return null;
    }

    public boolean inBlockErrorCode(int i, String str) {
        UrlMatchRule ruleById;
        if (i == 0 || TextUtils.isEmpty(str) || (ruleById = getRuleById(str)) == null || ruleById.mBlockErrorCodeSet == null) {
            return false;
        }
        return ruleById.mBlockErrorCodeSet.contains(Integer.valueOf(i));
    }

    private UrlMatchRule getRuleById(String str) {
        for (UrlMatchRule urlMatchRule : this.mUrlMatchRuleList) {
            if (urlMatchRule.getRuleId().equals(str)) {
                return urlMatchRule;
            }
        }
        return null;
    }

    private void recoverRuleStatusFromForbidden() {
        for (UrlMatchRule urlMatchRule : this.mUrlMatchRuleList) {
            if (urlMatchRule.mIsForbidden) {
                long uptimeMillis = SystemClock.uptimeMillis() - urlMatchRule.mForbiddenTimeStart;
                if (uptimeMillis > urlMatchRule.mForbiddenDurationSeconds * 1000) {
                    urlMatchRule.mIsForbidden = false;
                }
                if (Logger.debug()) {
                    Logger.d(TAG, "Rule id: " + urlMatchRule.mRuleId + " has forbidden duration: " + uptimeMillis + " fail count: " + urlMatchRule.mContinueFailedCount + " forbidden duration: " + (urlMatchRule.mForbiddenDurationSeconds * 1000));
                }
            }
        }
    }

    private boolean isUrlMatchRule(Request request, UrlMatchRule urlMatchRule) {
        boolean z;
        if (urlMatchRule.mForbiddenDurationSeconds > 0 && urlMatchRule.mIsForbidden) {
            return false;
        }
        String url = request.getUrl();
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        Iterator<String> it = urlMatchRule.mHostList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (UrlUtils.matchPattern(request.getHost(), it.next())) {
                z = true;
                break;
            }
        }
        if (!z) {
            if (Logger.debug()) {
                Logger.d(TAG, "host not match: " + url);
            }
            return false;
        }
        String path = request.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        if (!isEmpty(urlMatchRule.mEqualPathList)) {
            Iterator<String> it2 = urlMatchRule.mEqualPathList.iterator();
            while (it2.hasNext()) {
                if (path.equals(it2.next())) {
                    return true;
                }
            }
        }
        if (!isEmpty(urlMatchRule.mPrefixPathList)) {
            Iterator<String> it3 = urlMatchRule.mPrefixPathList.iterator();
            while (it3.hasNext()) {
                if (path.startsWith(it3.next())) {
                    return true;
                }
            }
        }
        if (!isEmpty(urlMatchRule.mPatternPathList)) {
            for (Pattern pattern : urlMatchRule.mPatternPathList) {
                if (pattern != null) {
                    try {
                        if (pattern.matcher(path).matches()) {
                            return true;
                        }
                    } catch (IllegalArgumentException unused) {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class UrlMatchRule {
        Set<Integer> mBlockErrorCodeSet;
        final List<String> mConcurrentHostList;
        List<String> mEqualPathList;
        final List<String> mHostList;
        List<Pattern> mPatternPathList;
        List<String> mPrefixPathList;
        boolean mEnableRequestReportFix = false;
        int mTNCRequestMaxWaitTime = 0;
        volatile long mForbiddenTimeStart = SystemClock.uptimeMillis();
        volatile int mContinueFailedCount = 0;
        int mMaxFailedCount = Integer.MAX_VALUE;
        int mForbiddenDurationSeconds = 0;
        volatile boolean mIsForbidden = false;
        String mRuleId = UUID.randomUUID().toString();
        boolean mRetryForNot2xxCode = false;
        int mConnectTimeInterval = 4000;
        boolean mBypassRouteSelectionEnabled = true;
        String mRefineRsName = null;

        public UrlMatchRule(List<String> list, List<String> list2) {
            this.mHostList = list;
            this.mConcurrentHostList = list2;
        }

        public List<String> getDomainList() {
            return this.mConcurrentHostList;
        }

        public String getRuleId() {
            return this.mRuleId;
        }
    }

    public void onNetConfigChanged(String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "onNetConfigChanged config: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mConcurrentRequestEnabled = jSONObject.optInt(KEY_CONCURRENT_REQUEST_ENABLED, 0);
            this.mUrlMatchRuleList.clear();
            JSONArray jSONArray = jSONObject.getJSONArray(KEY_URL_MATCH_RULE);
            for (int i = 0; i < jSONArray.length(); i++) {
                parseUrlMatchRule((JSONObject) jSONArray.get(i));
            }
        } catch (Throwable unused) {
            if (Logger.debug()) {
                Logger.d(TAG, "parse json config error");
            }
        }
    }

    private static boolean parseJSONArrayList(JSONObject jSONObject, String str, List<String> list) {
        JSONArray optJSONArray;
        if (jSONObject == null || TextUtils.isEmpty(str) || list == null || (optJSONArray = jSONObject.optJSONArray(str)) == null) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            String optString = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                list.add(optString);
            }
        }
        return true;
    }

    private void parseUrlMatchRule(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        parseJSONArrayList(jSONObject, KEY_HOST_GROUP, arrayList);
        ArrayList arrayList2 = new ArrayList();
        parseJSONArrayList(jSONObject, KEY_CONCURRENT_HOST_GROUP, arrayList2);
        if (arrayList.isEmpty() || arrayList2.size() < 2) {
            return;
        }
        UrlMatchRule urlMatchRule = new UrlMatchRule(arrayList, arrayList2);
        ArrayList arrayList3 = new ArrayList();
        if (parseJSONArrayList(jSONObject, KEY_PATH_EQUAL_GROUP, arrayList3)) {
            urlMatchRule.mEqualPathList = arrayList3;
        }
        ArrayList arrayList4 = new ArrayList();
        if (parseJSONArrayList(jSONObject, KEY_PATH_PREFIX_GROUP, arrayList4)) {
            urlMatchRule.mPrefixPathList = arrayList4;
        }
        ArrayList arrayList5 = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray(KEY_PATH_PATTERN_GROUP);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        arrayList5.add(Pattern.compile(optString, 2));
                    } catch (Throwable unused) {
                    }
                }
            }
            urlMatchRule.mPatternPathList = arrayList5;
        }
        urlMatchRule.mMaxFailedCount = jSONObject.optInt(KEY_CONTINUE_FAILED_COUNTS, Integer.MAX_VALUE);
        urlMatchRule.mForbiddenDurationSeconds = jSONObject.optInt(KEY_FORBIDDEN_SECONDS, 0);
        urlMatchRule.mConnectTimeInterval = jSONObject.optInt(KEY_CONNECT_TIME_INTERVAL, 4000);
        urlMatchRule.mBypassRouteSelectionEnabled = jSONObject.optInt(KEY_BYPASS_ROUTE_SELECTION_ENABLED, 1) > 0;
        urlMatchRule.mRefineRsName = jSONObject.optString(KEY_REFINE_WITH_CONCURRENT_ROUTE);
        if (TextUtils.isEmpty(urlMatchRule.mRefineRsName)) {
            urlMatchRule.mRefineRsName = jSONObject.optString(KEY_REFINE_WITH_ROUTE_SELECTION, null);
        }
        urlMatchRule.mEnableRequestReportFix = jSONObject.optInt(KEY_REQUEST_FINISH_FIX_ENABLED, 0) > 0;
        urlMatchRule.mTNCRequestMaxWaitTime = jSONObject.optInt(KEY_MAX_WAIT_SECONDS, 0);
        if (urlMatchRule.mConnectTimeInterval <= 0) {
            return;
        }
        urlMatchRule.mRetryForNot2xxCode = jSONObject.optInt(KEY_RETRY_FOR_NOT_2XX_CODE, 0) > 0;
        HashSet hashSet = new HashSet();
        JSONArray optJSONArray2 = jSONObject.optJSONArray(KEY_BLOCK_ERROR_CODE_LIST);
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                hashSet.add(Integer.valueOf(optJSONArray2.optInt(i2)));
            }
            urlMatchRule.mBlockErrorCodeSet = hashSet;
        }
        this.mUrlMatchRuleList.add(urlMatchRule);
    }

    private static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    private void tryForbiddenCurrentRule(UrlMatchRule urlMatchRule, boolean z) {
        if (Logger.debug()) {
            Logger.d(TAG, "Forbidden: " + urlMatchRule.mIsForbidden + " failed count: " + urlMatchRule.mContinueFailedCount + " max count: " + urlMatchRule.mMaxFailedCount);
        }
        if (z) {
            if (urlMatchRule.mContinueFailedCount != 0 || urlMatchRule.mIsForbidden) {
                urlMatchRule.mContinueFailedCount = 0;
                urlMatchRule.mIsForbidden = false;
                return;
            }
            return;
        }
        int i = urlMatchRule.mContinueFailedCount + 1;
        urlMatchRule.mContinueFailedCount = i;
        if (i < urlMatchRule.mMaxFailedCount) {
            return;
        }
        if (!urlMatchRule.mIsForbidden) {
            urlMatchRule.mIsForbidden = true;
            urlMatchRule.mForbiddenTimeStart = SystemClock.uptimeMillis();
        }
        if (Logger.debug()) {
            Logger.d(TAG, "Forbidden: " + urlMatchRule.mIsForbidden + " failed count: " + urlMatchRule.mContinueFailedCount);
        }
    }

    public void notifyConcurrentRequestFinished(String str, boolean z) {
        UrlMatchRule ruleById;
        if (TextUtils.isEmpty(str) || (ruleById = getRuleById(str)) == null) {
            return;
        }
        tryForbiddenCurrentRule(ruleById, z);
    }
}
