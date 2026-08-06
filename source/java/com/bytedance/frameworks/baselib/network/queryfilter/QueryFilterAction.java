package com.bytedance.frameworks.baselib.network.queryfilter;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Request;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class QueryFilterAction {
    private static final String KEY_ENCRYPT_ACTION = "encrypt";
    private static final String KEY_EQUAL_GROUP = "equal_group";
    private static final String KEY_HOST_GROUP = "host_group";
    private static final String KEY_PATTERN_GROUP = "pattern_group";
    private static final String KEY_PREFIX_GROUP = "prefix_group";
    private static final String KEY_RM_ACTION = "rm";
    private static final String TAG = "QueryFilterAction";
    private int mPriority;
    private int mSetReqPriority;
    protected boolean mNeedBackgroundProtect = false;
    private Set<String> mDomainFilterSet = new HashSet();
    private Set<String> mEqualPathSet = new HashSet();
    private Set<String> mPrefixPathSet = new HashSet();
    private Set<Pattern> mPatternPathSet = new HashSet();

    protected abstract boolean dispatch(Request request, Map<String, List<String>> map);

    protected abstract void loadActionParam(JSONObject jSONObject);

    public QueryFilterAction(int i) {
        this.mPriority = i;
        this.mSetReqPriority = i;
    }

    public int getPriority() {
        return this.mPriority;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean takeAction(Request request, Map<String, List<String>> map, List<QueryActionInfo> list) {
        QueryActionInfo queryActionInfo = new QueryActionInfo();
        queryActionInfo.setActionStartTime(SystemClock.uptimeMillis());
        boolean doDispatch = doDispatch(request, map);
        if (doDispatch) {
            request.setQueryFilterPriority(this.mSetReqPriority);
        }
        queryActionInfo.setActionHit(doDispatch);
        queryActionInfo.setActionPriority(this.mPriority);
        queryActionInfo.setActionEndTime(SystemClock.uptimeMillis());
        list.add(queryActionInfo);
        return doDispatch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static QueryFilterAction createQueryFilterAction(String str, int i, int i2, JSONObject jSONObject) {
        QueryFilterAction queryEncryptAction;
        if (str.equals(KEY_RM_ACTION)) {
            queryEncryptAction = new QueryRemoveAction(i);
        } else {
            if (!str.equals(KEY_ENCRYPT_ACTION)) {
                return null;
            }
            queryEncryptAction = new QueryEncryptAction(i);
        }
        queryEncryptAction.loadActionParam(jSONObject);
        queryEncryptAction.setReqPriority(i2);
        return queryEncryptAction;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadMatchRules(JSONObject jSONObject) {
        parseArraySetStringConfig(jSONObject.optJSONArray(KEY_HOST_GROUP), this.mDomainFilterSet);
        parseArraySetStringConfig(jSONObject.optJSONArray(KEY_EQUAL_GROUP), this.mEqualPathSet);
        parseArraySetStringConfig(jSONObject.optJSONArray(KEY_PREFIX_GROUP), this.mPrefixPathSet);
        parseArraySetPatternConfig(jSONObject.optJSONArray(KEY_PATTERN_GROUP), this.mPatternPathSet);
    }

    private boolean isHostMatch(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = this.mDomainFilterSet.iterator();
        while (it.hasNext()) {
            if (UrlUtils.matchPattern(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isMatchUrlRules(Request request) {
        if (this.mNeedBackgroundProtect && !QueryFilterStateListener.getInstance().mIsBackgroundState.get()) {
            return false;
        }
        if (!isEmptySet(this.mDomainFilterSet) && !isHostMatch(request.getHost())) {
            return false;
        }
        String path = request.getPath();
        if (TextUtils.isEmpty(path)) {
            if (Logger.debug()) {
                Logger.d(TAG, "Path is empty: " + path);
            }
            return false;
        }
        int length = path.length();
        if (length > 1) {
            int i = length - 1;
            if (path.substring(i).equals("/")) {
                path = path.substring(0, i);
            }
        }
        if (!isEmptySet(this.mEqualPathSet) && this.mEqualPathSet.contains(path)) {
            return true;
        }
        if (!isEmptySet(this.mPrefixPathSet)) {
            Iterator<String> it = this.mPrefixPathSet.iterator();
            while (it.hasNext()) {
                if (path.startsWith(it.next())) {
                    return true;
                }
            }
        }
        if (!isEmptySet(this.mPatternPathSet)) {
            for (Pattern pattern : this.mPatternPathSet) {
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

    private static void parseArraySetPatternConfig(JSONArray jSONArray, Set<Pattern> set) {
        if (jSONArray == null || set == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        set.add(Pattern.compile(string, 2));
                    } catch (Throwable unused) {
                    }
                }
            } catch (JSONException unused2) {
                return;
            }
        }
    }

    private void parseArraySetStringConfig(JSONArray jSONArray, Set<String> set) {
        if (jSONArray == null || set == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    set.add(string);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    private void setReqPriority(int i) {
        this.mSetReqPriority = i;
    }

    private boolean isActionEffective(Request request) {
        return request.getQueryFilterPriority() <= this.mPriority;
    }

    private boolean doDispatch(Request request, Map<String, List<String>> map) {
        if (isActionEffective(request)) {
            return dispatch(request, map);
        }
        return false;
    }

    private static boolean isEmptySet(Set<?> set) {
        return set == null || set.isEmpty();
    }
}
