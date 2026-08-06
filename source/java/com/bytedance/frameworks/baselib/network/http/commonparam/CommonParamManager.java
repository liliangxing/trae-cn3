package com.bytedance.frameworks.baselib.network.http.commonparam;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class CommonParamManager {
    private static final int MAX_PARAM_LEVEL = 0;
    private static final int MIN_PARAM_LEVEL = 1;
    private static final String TAG = "CommonParamManager";
    private static volatile CommonParamManager sInstance;
    private CommonParamConfig mCommonParamConfig;
    private volatile boolean mForceAddMinParamsEnabled = false;

    public static CommonParamManager inst() {
        if (sInstance == null) {
            synchronized (CommonParamManager.class) {
                if (sInstance == null) {
                    sInstance = new CommonParamManager();
                }
            }
        }
        return sInstance;
    }

    private CommonParamManager() {
    }

    public CommonParamConfig getCommonParamConfig() {
        return this.mCommonParamConfig;
    }

    public void setCommonParamConfig(CommonParamConfig commonParamConfig) {
        if (this.mCommonParamConfig != null) {
            throw new IllegalStateException("CommonParamConfig has been initialized before.");
        }
        if (commonParamConfig == null) {
            throw new IllegalArgumentException("config is null, please init CommonParamConfig before.");
        }
        this.mCommonParamConfig = commonParamConfig;
    }

    public void setForceAddMinParamsEnabled(boolean z) {
        this.mForceAddMinParamsEnabled = z;
    }

    public String addCommonParams(Request request, String str, RetrofitMetrics retrofitMetrics) {
        boolean z;
        if (this.mCommonParamConfig.isCustomCommonParamLevelEnabled()) {
            if (Logger.debug()) {
                Logger.d(TAG, "addCommonParamsByLevel commonParamLevel: " + request.getCommonParamLevel());
            }
            return addCommonParamsByQueryMap(NetworkParams.addCommonParamsByLevel(str, true, request.getCommonParamLevel(), retrofitMetrics), str, false);
        }
        Set<String> domainFilterSet = this.mCommonParamConfig.getDomainFilterSet();
        if (isEmptySet(domainFilterSet)) {
            return str;
        }
        Iterator<String> it = domainFilterSet.iterator();
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
                Logger.d(TAG, "Domain not match: " + str);
            }
            return str;
        }
        if (TextUtils.isEmpty(request.getPath())) {
            if (Logger.debug()) {
                Logger.d(TAG, "Path is empty: " + request.getPath());
            }
            return str;
        }
        if (this.mForceAddMinParamsEnabled) {
            if (Logger.debug()) {
                Logger.d(TAG, "ForceAddMinParams match url: " + str);
            }
            return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(1, retrofitMetrics), str, true);
        }
        if (isMatchPathRule(this.mCommonParamConfig.getAddMaxParamsEqualPathSet(), this.mCommonParamConfig.getAddMaxParamsPrefixPathSet(), this.mCommonParamConfig.getAddMaxParamsPatternSet(), request.getPath())) {
            if (Logger.debug()) {
                Logger.d(TAG, "AddMaxParamsPathFilterMap match: " + str);
            }
            return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(0, retrofitMetrics), str, false);
        }
        if (isMatchPathRule(this.mCommonParamConfig.getAddMinParamsEqualPathSet(), this.mCommonParamConfig.getAddMinParamsPrefixPathSet(), this.mCommonParamConfig.getAddMinParamsPatternSet(), request.getPath())) {
            if (Logger.debug()) {
                Logger.d(TAG, "AddMinParamsPathFilterMap match: " + str);
            }
            return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(1, retrofitMetrics), str, true);
        }
        if (this.mCommonParamConfig.addMinCommonParamsWhenDomainMatch()) {
            if (Logger.debug()) {
                Logger.d(TAG, "addMinCommonParamsWhenDomainMatch is enabled.");
            }
            return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(1, retrofitMetrics), str, true);
        }
        if (Logger.debug()) {
            Logger.d(TAG, "add max common params by default.");
        }
        return addCommonParamsByQueryMap(NetworkParams.getCommonParamsByLevel(0, retrofitMetrics), str, false);
    }

    private boolean isMatchPathRule(Set<String> set, Set<String> set2, Set<Pattern> set3, String str) {
        if (!isEmptySet(set)) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next())) {
                    return true;
                }
            }
        }
        if (!isEmptySet(set2)) {
            Iterator<String> it2 = set2.iterator();
            while (it2.hasNext()) {
                if (str.startsWith(it2.next())) {
                    return true;
                }
            }
        }
        if (isEmptySet(set3)) {
            return false;
        }
        for (Pattern pattern : set3) {
            if (pattern != null) {
                try {
                    if (pattern.matcher(str).matches()) {
                        return true;
                    }
                } catch (IllegalArgumentException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    private String addCommonParamsByQueryMap(Map<String, String> map, String str, boolean z) {
        if (map == null || map.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                Set<String> minParamsExcludeSet = this.mCommonParamConfig.getMinParamsExcludeSet();
                if (!z || isEmptySet(minParamsExcludeSet) || !minParamsExcludeSet.contains(entry.getKey())) {
                    arrayList.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
        }
        sb.append(NetworkUtils.format(arrayList, UrlUtils.UTF_8));
        if (Logger.debug()) {
            Logger.d(TAG, "addCommonParamsByQueryMap url: " + sb.toString());
        }
        return sb.toString();
    }

    private static boolean isEmptySet(Set<?> set) {
        return set == null || set.isEmpty();
    }
}
