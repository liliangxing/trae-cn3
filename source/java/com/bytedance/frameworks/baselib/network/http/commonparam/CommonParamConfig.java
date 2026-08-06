package com.bytedance.frameworks.baselib.network.http.commonparam;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CommonParamConfig {
    public static final String EQUAL_MATCH = "equal_match";
    private static final String KEY_EQUAL_GROUP = "equal_group";
    private static final String KEY_HOST_GROUP = "host_group";
    private static final String KEY_L0_PATH = "L0_path";
    private static final String KEY_L1_PATH = "L1_path";
    private static final String KEY_MIN_PARAMS_EXCLUDE = "min_params_exclude";
    private static final String KEY_PATTERN_GROUP = "pattern_group";
    private static final String KEY_PREFIX_GROUP = "prefix_group";
    public static final String PATTERN_MATCH = "pattern_match";
    public static final String PREFIX_MATCH = "prefix_match";
    private static final String TAG = "CommonParamConfig";
    private CopyOnWriteArraySet<String> mAddMaxParamsEqualPathSet;
    private CopyOnWriteArraySet<Pattern> mAddMaxParamsPatternSet;
    private CopyOnWriteArraySet<String> mAddMaxParamsPrefixPathSet;
    private volatile boolean mAddMinCommonParamsWhenDomainMatch;
    private CopyOnWriteArraySet<String> mAddMinParamsEqualPathSet;
    private CopyOnWriteArraySet<Pattern> mAddMinParamsPatternSet;
    private CopyOnWriteArraySet<String> mAddMinParamsPrefixPathSet;
    private volatile boolean mCustomCommonParamLevelEnabled;
    private CopyOnWriteArraySet<String> mDomainFilterSet;
    private volatile String mLocalConfig;
    private CopyOnWriteArraySet<String> mMinParamsExcludeSet;
    private volatile boolean mNewStrategyEnabled;

    public CommonParamConfig(Builder builder) {
        this.mNewStrategyEnabled = builder.mNewStrategyEnabled;
        this.mCustomCommonParamLevelEnabled = builder.mCustomCommonParamLevelEnabled;
        this.mAddMinCommonParamsWhenDomainMatch = builder.mMinCommonParamsWhenDomainMatch;
        this.mDomainFilterSet = builder.mDomainFilterSet;
        this.mAddMaxParamsEqualPathSet = builder.mAddMaxParamsEqualPathSet;
        this.mAddMaxParamsPrefixPathSet = builder.mAddMaxParamsPrefixPathSet;
        this.mAddMaxParamsPatternSet = builder.mAddMaxParamsPatternSet;
        this.mAddMinParamsEqualPathSet = builder.mAddMinParamsEqualPathSet;
        this.mAddMinParamsPrefixPathSet = builder.mAddMinParamsPrefixPathSet;
        this.mAddMinParamsPatternSet = builder.mAddMinParamsPatternSet;
        this.mMinParamsExcludeSet = builder.mMinParamsExcludeSet;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean isNewStrategyEnabled() {
        return this.mNewStrategyEnabled;
    }

    public boolean isCustomCommonParamLevelEnabled() {
        return this.mCustomCommonParamLevelEnabled;
    }

    public boolean addMinCommonParamsWhenDomainMatch() {
        return this.mAddMinCommonParamsWhenDomainMatch;
    }

    public Set<String> getDomainFilterSet() {
        return this.mDomainFilterSet;
    }

    public Set<String> getAddMaxParamsEqualPathSet() {
        return this.mAddMaxParamsEqualPathSet;
    }

    public Set<String> getAddMaxParamsPrefixPathSet() {
        return this.mAddMaxParamsPrefixPathSet;
    }

    public Set<Pattern> getAddMaxParamsPatternSet() {
        return this.mAddMaxParamsPatternSet;
    }

    public Set<String> getAddMinParamsEqualPathSet() {
        return this.mAddMinParamsEqualPathSet;
    }

    public Set<String> getAddMinParamsPrefixPathSet() {
        return this.mAddMinParamsPrefixPathSet;
    }

    public Set<Pattern> getAddMinParamsPatternSet() {
        return this.mAddMinParamsPatternSet;
    }

    public Set<String> getMinParamsExcludeSet() {
        return this.mMinParamsExcludeSet;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private boolean mCustomCommonParamLevelEnabled;
        private boolean mMinCommonParamsWhenDomainMatch;
        private boolean mNewStrategyEnabled;
        private CopyOnWriteArraySet<String> mDomainFilterSet = new CopyOnWriteArraySet<>();
        private CopyOnWriteArraySet<String> mAddMaxParamsEqualPathSet = new CopyOnWriteArraySet<>();
        private CopyOnWriteArraySet<String> mAddMaxParamsPrefixPathSet = new CopyOnWriteArraySet<>();
        private CopyOnWriteArraySet<Pattern> mAddMaxParamsPatternSet = new CopyOnWriteArraySet<>();
        private CopyOnWriteArraySet<String> mAddMinParamsEqualPathSet = new CopyOnWriteArraySet<>();
        private CopyOnWriteArraySet<String> mAddMinParamsPrefixPathSet = new CopyOnWriteArraySet<>();
        private CopyOnWriteArraySet<Pattern> mAddMinParamsPatternSet = new CopyOnWriteArraySet<>();
        private CopyOnWriteArraySet<String> mMinParamsExcludeSet = new CopyOnWriteArraySet<>();

        public Builder enableNewAddcommonParamsStrategy(boolean z) {
            this.mNewStrategyEnabled = z;
            return this;
        }

        public Builder enableCustomCommonParamLevel(boolean z) {
            this.mCustomCommonParamLevelEnabled = z;
            return this;
        }

        public Builder enableMinCommonParamsWhenDomainMatch(boolean z) {
            this.mMinCommonParamsWhenDomainMatch = z;
            return this;
        }

        public Builder setDomainFilterList(List<String> list) {
            if (CommonParamConfig.isEmptyList(list)) {
                throw new IllegalArgumentException("domainFilterList can not be null or empty.");
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.mDomainFilterSet.add(it.next());
            }
            return this;
        }

        public Builder setMinParamsExcludeList(List<String> list) {
            if (CommonParamConfig.isEmptyList(list)) {
                throw new IllegalArgumentException("minParamsExcludeList can not be null or empty.");
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.mMinParamsExcludeSet.add(it.next());
            }
            return this;
        }

        public Builder setAddMaxParamsPathFilterMap(Map<String, List<String>> map) {
            if (map == null || map.isEmpty()) {
                throw new IllegalArgumentException("addMaxParamsPathFilterMap can not be null or empty.");
            }
            List<String> list = map.get(CommonParamConfig.EQUAL_MATCH);
            if (!CommonParamConfig.isEmptyList(list)) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    this.mAddMaxParamsEqualPathSet.add(it.next());
                }
            }
            List<String> list2 = map.get(CommonParamConfig.PREFIX_MATCH);
            if (!CommonParamConfig.isEmptyList(list2)) {
                Iterator<String> it2 = list2.iterator();
                while (it2.hasNext()) {
                    this.mAddMaxParamsPrefixPathSet.add(it2.next());
                }
            }
            List<String> list3 = map.get(CommonParamConfig.PATTERN_MATCH);
            if (list3 != null && !list3.isEmpty()) {
                for (String str : list3) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            this.mAddMaxParamsPatternSet.add(Pattern.compile(str, 2));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            return this;
        }

        public Builder setAddMinParamsPathFilterMap(Map<String, List<String>> map) {
            if (map == null || map.isEmpty()) {
                throw new IllegalArgumentException("addMinParamsPathFilterMap can not be null or empty.");
            }
            List<String> list = map.get(CommonParamConfig.EQUAL_MATCH);
            if (!CommonParamConfig.isEmptyList(list)) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    this.mAddMinParamsEqualPathSet.add(it.next());
                }
            }
            List<String> list2 = map.get(CommonParamConfig.PREFIX_MATCH);
            if (!CommonParamConfig.isEmptyList(list2)) {
                Iterator<String> it2 = list2.iterator();
                while (it2.hasNext()) {
                    this.mAddMinParamsPrefixPathSet.add(it2.next());
                }
            }
            List<String> list3 = map.get(CommonParamConfig.PATTERN_MATCH);
            if (!CommonParamConfig.isEmptyList(list3)) {
                for (String str : list3) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            this.mAddMinParamsPatternSet.add(Pattern.compile(str, 2));
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            return this;
        }

        public CommonParamConfig build() {
            return new CommonParamConfig(this);
        }
    }

    public void onNetConfigChanged(String str) {
        if (Logger.debug()) {
            Logger.d(TAG, "onNetConfigChanged config: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.isEmpty(this.mLocalConfig) && this.mLocalConfig.equals(str)) {
            if (Logger.debug()) {
                Logger.d(TAG, "Config is same with local config, do not parse.");
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mLocalConfig = str;
            parseArraySetStringConfig(jSONObject.optJSONArray(KEY_HOST_GROUP), this.mDomainFilterSet);
            parseArraySetStringConfig(jSONObject.optJSONArray(KEY_MIN_PARAMS_EXCLUDE), this.mMinParamsExcludeSet);
            JSONObject optJSONObject = jSONObject.optJSONObject(KEY_L0_PATH);
            if (optJSONObject != null) {
                parseArraySetStringConfig(optJSONObject.optJSONArray(KEY_EQUAL_GROUP), this.mAddMaxParamsEqualPathSet);
                parseArraySetStringConfig(optJSONObject.optJSONArray(KEY_PREFIX_GROUP), this.mAddMaxParamsPrefixPathSet);
                parseArraySetPatternConfig(optJSONObject.optJSONArray(KEY_PATTERN_GROUP), this.mAddMaxParamsPatternSet);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(KEY_L1_PATH);
            if (optJSONObject2 != null) {
                parseArraySetStringConfig(optJSONObject2.optJSONArray(KEY_EQUAL_GROUP), this.mAddMinParamsEqualPathSet);
                parseArraySetStringConfig(optJSONObject2.optJSONArray(KEY_PREFIX_GROUP), this.mAddMinParamsPrefixPathSet);
                parseArraySetPatternConfig(optJSONObject2.optJSONArray(KEY_PATTERN_GROUP), this.mAddMinParamsPatternSet);
            }
        } catch (Throwable unused) {
        }
    }

    private static void parseArraySetPatternConfig(JSONArray jSONArray, Set<Pattern> set) {
        if (jSONArray == null || set == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<Pattern> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().toString());
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string) && !hashSet.contains(string)) {
                    set.add(Pattern.compile(string, 2));
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    private static void parseArraySetStringConfig(JSONArray jSONArray, Set<String> set) {
        if (jSONArray == null || set == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                set.add(jSONArray.getString(i));
            } catch (JSONException unused) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }
}
