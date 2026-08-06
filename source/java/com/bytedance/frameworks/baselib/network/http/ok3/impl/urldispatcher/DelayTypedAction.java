package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction;
import com.bytedance.frameworks.baselib.network.http.util.NetworklibUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class DelayTypedAction extends BaseDispatchAction {
    private static final String TAG = "DelayTypedAction";
    private static final String kProcessTagKey = "p";
    private static final String kStartUpTagKey = "s";
    private int mDelayTime = 0;
    private int mRandomLeft = 0;
    private int mRandomRight = 0;
    private final Map<String, Set<String>> mTncTagMap = new HashMap();

    public BaseDispatchAction.DispatchResultEnum takeDelayAction(String str, String str2, List<Integer> list) {
        if (Logger.debug()) {
            Logger.d(TAG, "take delay action");
        }
        if (!isDelayActionEffective() || TextUtils.isEmpty(str)) {
            list.set(0, 0);
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        }
        return findDelayResult(str, str2, list);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean initWithActionParam(JSONObject jSONObject, String str, long j) {
        int i;
        int i2;
        loadMatchRules(jSONObject);
        String optString = jSONObject.optString("tag");
        int i3 = 0;
        if (!TextUtils.isEmpty(optString)) {
            for (String str2 : optString.split(";")) {
                ArrayList<Pair> arrayList = new ArrayList();
                if (NetworklibUtils.splitStringIntoKeyValuePairs(str2, ",", "=", arrayList)) {
                    for (Pair pair : arrayList) {
                        Set<String> set = this.mTncTagMap.get(pair.first);
                        if (set == null) {
                            set = new HashSet<>();
                        }
                        set.add((String) pair.second);
                        this.mTncTagMap.put((String) pair.first, set);
                    }
                }
            }
        }
        this.mDelayTime = jSONObject.optInt("delay");
        JSONArray optJSONArray = jSONObject.optJSONArray("random");
        if (this.mDelayTime > 0 || optJSONArray == null) {
            i = 0;
        } else {
            if (optJSONArray.length() != 2) {
                return false;
            }
            try {
                i2 = optJSONArray.getInt(0);
                try {
                    i = optJSONArray.getInt(1);
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    i = 0;
                    if (i2 > 0) {
                    }
                    return false;
                }
            } catch (JSONException e2) {
                e = e2;
                i2 = 0;
            }
            if (i2 > 0 || i <= 0 || i2 >= i) {
                return false;
            }
            i3 = i2;
        }
        this.mRandomLeft = i3;
        this.mRandomRight = i;
        if (Logger.debug()) {
            Logger.d(TAG, "initwithparam tnc tag map is " + this.mTncTagMap);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BaseDispatchAction.DispatchResultEnum findDelayResult(String str, String str2, List<Integer> list) {
        Uri parse = Uri.parse(str);
        if (parse.getHost() == null || !isMatchRules(parse)) {
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        }
        if (this.mTncTagMap.isEmpty()) {
            list.set(0, Integer.valueOf(getDelayTimeForRequest()));
            if (Logger.debug()) {
                Logger.d(TAG, "tnc tag map is empty, result delay time is " + list.get(0));
            }
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
        }
        if (!TTDelayStateManager.getRequestTagDelayEnabled()) {
            if (Logger.debug()) {
                Logger.d(TAG, "this action with tag is not enabled");
            }
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        }
        if ("".equals(str2)) {
            str2 = "s=0;p=0";
        }
        HashMap hashMap = new HashMap();
        ArrayList<Pair> arrayList = new ArrayList();
        if (!NetworklibUtils.splitStringIntoKeyValuePairs(str2, ";", "=", arrayList)) {
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        }
        for (Pair pair : arrayList) {
            hashMap.put((String) pair.first, (String) pair.second);
        }
        String num = Integer.toString(TTDelayStateManager.AppStartState.NormalStart.getValue());
        if (TTDelayStateManager.getAppStartUpState() != TTDelayStateManager.AppStartState.NormalStart) {
            num = Integer.toString(TTDelayStateManager.getCurrentStartUpState().getValue());
        }
        hashMap.put(kStartUpTagKey, num);
        Context context = URLDispatcher.inst().getContext();
        hashMap.put("p", Integer.toString((context != null ? ProcessUtils.isMainProcessByProcessFlag(context) : 1) ^ 1));
        if (Logger.debug()) {
            Logger.d(TAG, "request tag string is " + str2);
        }
        BaseDispatchAction.DispatchResultEnum dispatchResultEnum = BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY;
        Iterator<Map.Entry<String, Set<String>>> it = this.mTncTagMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, Set<String>> next = it.next();
            String str3 = (String) hashMap.get(next.getKey());
            if (str3 == null) {
                dispatchResultEnum = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
                break;
            }
            if (!next.getValue().contains(str3)) {
                dispatchResultEnum = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
                break;
            }
        }
        if (dispatchResultEnum == BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) {
            list.set(0, Integer.valueOf(getDelayTimeForRequest()));
        }
        if (Logger.debug()) {
            String str4 = TAG;
            Logger.d(str4, "match tag result is " + dispatchResultEnum);
            Logger.d(str4, "will delay time is " + list.get(0));
            Logger.d(str4, "request tag map is " + hashMap);
            Logger.d(str4, "tnc tag map is " + this.mTncTagMap);
        }
        return dispatchResultEnum;
    }

    private int getDelayTimeForRequest() {
        int i = this.mDelayTime;
        if (i > 0) {
            return i;
        }
        if (this.mRandomLeft < this.mRandomRight) {
            return new Random().nextInt(this.mRandomRight - this.mRandomLeft) + this.mRandomLeft;
        }
        return 0;
    }
}
