package com.bytedance.frameworks.baselib.network.config.hostpathmatch;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathValueBase;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class TTHostPathRuleBaseTNCConfig<T extends TTHostPathValueBase> {
    private static final String TAG = "TTHostPathMatchRule";
    private T mDefaultValue;
    protected final AtomicBoolean mEnable = new AtomicBoolean(false);
    private final List<Pair<TTHostPathCondition, T>> mRuleList = new CopyOnWriteArrayList();

    public abstract String getConfigRootKey();

    public abstract T parseHostPathValue(Object obj);

    boolean parseSpecificConfig(JSONObject jSONObject) {
        return true;
    }

    public boolean parseTNCConfig(JSONObject jSONObject) {
        this.mEnable.set(false);
        this.mRuleList.clear();
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject(getConfigRootKey());
        if (optJSONObject == null || optJSONObject.length() == 0) {
            return true;
        }
        this.mEnable.set(optJSONObject.optInt("enabled", 0) > 0);
        if (!this.mEnable.get()) {
            return true;
        }
        if (!parseSpecificConfig(optJSONObject)) {
            return false;
        }
        Object opt = optJSONObject.opt("default");
        if (opt != null) {
            this.mDefaultValue = parseHostPathValue(opt);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("rule_list");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return false;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
            if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                TTHostPathCondition tTHostPathCondition = new TTHostPathCondition();
                tTHostPathCondition.hostEq = parseJSONArrayToSet(optJSONObject2.optJSONArray("host_eq"));
                tTHostPathCondition.hostWc = parseJSONArrayToSet(optJSONObject2.optJSONArray("host_wc"));
                if ((tTHostPathCondition.hostEq == null || tTHostPathCondition.hostEq.isEmpty()) && (tTHostPathCondition.hostWc == null || tTHostPathCondition.hostWc.isEmpty())) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "both host_eq and host_wc empty.");
                    }
                } else {
                    tTHostPathCondition.pathEq = parseJSONArrayToSet(optJSONObject2.optJSONArray("path_eq"));
                    tTHostPathCondition.pathPrefix = parseJSONArrayToSet(optJSONObject2.optJSONArray("path_prefix"));
                    tTHostPathCondition.pathContain = parseJSONArrayToSet(optJSONObject2.optJSONArray("path_contain"));
                    Set<String> parseJSONArrayToSet = parseJSONArrayToSet(optJSONObject2.optJSONArray("path_pattern"));
                    if (parseJSONArrayToSet != null) {
                        tTHostPathCondition.pathPattern = new HashSet();
                        Iterator<String> it = parseJSONArrayToSet.iterator();
                        while (it.hasNext()) {
                            try {
                                tTHostPathCondition.pathPattern.add(Pattern.compile(it.next()));
                            } catch (Throwable unused) {
                            }
                        }
                    }
                    if ((tTHostPathCondition.pathEq == null || tTHostPathCondition.pathEq.isEmpty()) && ((tTHostPathCondition.pathPrefix == null || tTHostPathCondition.pathPrefix.isEmpty()) && ((tTHostPathCondition.pathContain == null || tTHostPathCondition.pathContain.isEmpty()) && (tTHostPathCondition.pathPattern == null || tTHostPathCondition.pathPattern.isEmpty())))) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "no path filter exist.");
                        }
                    } else {
                        Object opt2 = optJSONObject2.opt("value");
                        if (opt2 == null) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "value is null.");
                            }
                        } else {
                            T parseHostPathValue = parseHostPathValue(opt2);
                            if (parseHostPathValue == null) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "ParseHostPathValue failed.");
                                }
                            } else {
                                String optString = optJSONObject2.optString(TicketGuardProviderKt.PATH_SIGN);
                                if (!TextUtils.isEmpty(optString)) {
                                    parseHostPathValue.sign = optString;
                                }
                                this.mRuleList.add(new Pair<>(tTHostPathCondition, parseHostPathValue));
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x013a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0034 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public T getValue(String str) {
        Uri parse;
        TTHostPathCondition tTHostPathCondition;
        boolean z;
        if (TextUtils.isEmpty(str) || !this.mEnable.get() || (parse = Uri.parse(str)) == null) {
            return null;
        }
        String host = parse.getHost();
        String path = parse.getPath();
        if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(path)) {
            for (Pair<TTHostPathCondition, T> pair : this.mRuleList) {
                if (pair != null && (tTHostPathCondition = (TTHostPathCondition) pair.first) != null) {
                    boolean z2 = false;
                    boolean z3 = true;
                    if (tTHostPathCondition.hostEq == null || !tTHostPathCondition.hostEq.contains(host)) {
                        z = false;
                    } else {
                        if (Logger.debug()) {
                            Logger.d(TAG, "hitRule: host_eq.");
                        }
                        z = true;
                    }
                    if (!z && tTHostPathCondition.hostWc != null) {
                        Iterator<String> it = tTHostPathCondition.hostWc.iterator();
                        while (it.hasNext()) {
                            if (UrlUtils.matchPattern(host, it.next())) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "hitRule: host_wc.");
                                }
                                z = true;
                            }
                        }
                    }
                    if (!z) {
                        break;
                    }
                    if (tTHostPathCondition.pathEq != null && tTHostPathCondition.pathEq.contains(path)) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "hitRule: path_eq.");
                        }
                        z2 = true;
                    }
                    if (!z2 && tTHostPathCondition.pathPrefix != null) {
                        Iterator<String> it2 = tTHostPathCondition.pathPrefix.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            if (path.startsWith(it2.next())) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "hitRule: path_prefix.");
                                }
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && tTHostPathCondition.pathContain != null) {
                        Iterator<String> it3 = tTHostPathCondition.pathContain.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            if (path.contains(it3.next())) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "hitRule: path_contain.");
                                }
                                z2 = true;
                            }
                        }
                    }
                    if (!z2 && tTHostPathCondition.pathPattern != null) {
                        for (Pattern pattern : tTHostPathCondition.pathPattern) {
                            if (pattern != null) {
                                try {
                                    if (pattern.matcher(path).matches()) {
                                        try {
                                            if (Logger.debug()) {
                                                Logger.d(TAG, "hitRule: path_pattern.");
                                            }
                                            if (!z3) {
                                                return (T) pair.second;
                                            }
                                        } catch (Throwable unused) {
                                            z2 = true;
                                        }
                                    } else {
                                        continue;
                                    }
                                } catch (Throwable unused2) {
                                    continue;
                                }
                            }
                        }
                    }
                    z3 = z2;
                    if (!z3) {
                    }
                }
            }
            if (Logger.debug()) {
                Logger.d(TAG, "use default config");
            }
            return this.mDefaultValue;
        }
        return null;
    }

    public void setEnabled(boolean z) {
        this.mEnable.set(z);
    }

    public boolean isEnabled() {
        return this.mEnable.get();
    }

    public List<Pair<TTHostPathCondition, T>> getmRuleList() {
        return this.mRuleList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<String> parseJSONArrayToSet(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                hashSet.add(optString);
            }
        }
        return hashSet;
    }
}
