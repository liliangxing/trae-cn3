package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction;
import com.bytedance.frameworks.baselib.network.http.util.NetworklibUtils;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.ttnet.TTConfigManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class URLDispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "URLDispatcher";
    private static final String TNC_SP_NAME = "ttnet_tnc_config";
    private static volatile URLDispatcher mInstance;
    private static AtomicBoolean mLocalConfigLoaded = new AtomicBoolean(false);
    private String mTncAbTest;
    private String mTncEtag;
    private Context mContext = null;
    private AtomicBoolean mDispatcherEnabled = new AtomicBoolean(true);
    private AtomicLong mDispatchActionEpoch = new AtomicLong(0);
    private List<URLDispatchAction> mDispatchActions = new ArrayList();
    private final ReentrantReadWriteLock mDispatchActionslock = new ReentrantReadWriteLock();
    private List<DelayTypedAction> mDelayActions = new ArrayList();
    private final ReentrantReadWriteLock mDelayActionslock = new ReentrantReadWriteLock();
    private AtomicInteger mTncUpdateSource = new AtomicInteger(0);
    private AtomicLong mTncUpdateTime = new AtomicLong(0);
    private ConcurrentMap<String, String> mHostReplaceMap = new ConcurrentHashMap();

    public static URLDispatcher inst() {
        if (mInstance == null) {
            synchronized (URLDispatcher.class) {
                if (mInstance == null) {
                    mInstance = new URLDispatcher();
                }
            }
        }
        return mInstance;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setTncAbTest(String str) {
        this.mTncAbTest = str;
    }

    public DispatchResult getDispatchResultForUrl(URLRequest uRLRequest) {
        if (Logger.debug()) {
            Logger.d(TAG, "getDispatchResultForUrl: " + uRLRequest.getOriginUrl());
        }
        if (!UrlUtils.isValidUrl(uRLRequest.getOriginUrl())) {
            if (Logger.debug()) {
                Logger.d(TAG, "illegal url");
            }
            return null;
        }
        if (!this.mDispatcherEnabled.get()) {
            if (Logger.debug()) {
                Logger.d(TAG, "dispatch is unabled by tnc");
            }
            return null;
        }
        return doDispatch(uRLRequest);
    }

    private DispatchResult doDispatch(URLRequest uRLRequest) {
        String originUrl = uRLRequest.getOriginUrl();
        DispatchResult dispatchResult = new DispatchResult();
        ArrayList<DispatchActionInfo> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(0, originUrl);
        this.mDispatchActionslock.readLock().lock();
        Iterator<URLDispatchAction> it = this.mDispatchActions.iterator();
        String str = originUrl;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            URLDispatchAction next = it.next();
            if (Logger.debug()) {
                String str2 = TAG;
                Logger.d(str2, "action url = " + arrayList2);
                Logger.d(str2, "current action priority is " + next.getPriority());
            }
            BaseDispatchAction.DispatchResultEnum takeAction = next.takeAction(uRLRequest, str, arrayList2, arrayList);
            String str3 = (String) arrayList2.get(0);
            if (takeAction == BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP) {
                if (Logger.debug()) {
                    Logger.d(TAG, "the url has been dropped by urldispatcher, skip follow-up actions");
                }
                dispatchResult.mDropCode = next.getTcTypedDropCode();
            } else {
                str = str3;
            }
        }
        String str4 = (String) arrayList2.get(0);
        this.mDispatchActionslock.readLock().unlock();
        ArrayList arrayList3 = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("origin_url", originUrl);
            jSONObject.put("dispatched_url", str4);
            JSONArray jSONArray = new JSONArray();
            for (DispatchActionInfo dispatchActionInfo : arrayList) {
                if (dispatchActionInfo.mActionHit) {
                    JSONObject jSONObject2 = new JSONObject();
                    arrayList3.add(Long.valueOf(dispatchActionInfo.mRuleid));
                    jSONObject2.put(StrategyConstants.RULE_ID, dispatchActionInfo.mRuleid);
                    jSONObject2.put("service_name", dispatchActionInfo.mServiceName);
                    jSONObject2.put("priority", dispatchActionInfo.mPriority);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("action_info_list", jSONArray);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("dispatch", jSONObject);
            new JSONObject().put("dispatchersdk", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dispatchResult.mActionRuleIdList = arrayList3;
        dispatchResult.mDispatchedURL = str4;
        dispatchResult.mDispatchActionChain = arrayList;
        return dispatchResult;
    }

    public boolean isDispatchDelayEnabled() {
        return !this.mDelayActions.isEmpty();
    }

    public int getDelayResult(String str, String str2) {
        if (Logger.debug()) {
            Logger.d(TAG, "getDelayResultForUrl: " + str);
        }
        if (!UrlUtils.isValidUrl(str)) {
            if (Logger.debug()) {
                Logger.d(TAG, "illegal url");
            }
            return 0;
        }
        this.mDelayActionslock.readLock().lock();
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, 0);
        Iterator<DelayTypedAction> it = this.mDelayActions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DelayTypedAction next = it.next();
            if (Logger.debug()) {
                Logger.d(TAG, "current action priority is " + next.getPriority());
            }
            if (next.takeDelayAction(str, str2, arrayList) == BaseDispatchAction.DispatchResultEnum.DISPATCH_DELAY) {
                if (Logger.debug()) {
                    Logger.d(TAG, "the url has been delayed by delay action, skip follow-up actions");
                }
            }
        }
        this.mDelayActionslock.readLock().unlock();
        return ((Integer) arrayList.get(0)).intValue();
    }

    public void onServerConfigChanged(JSONObject jSONObject, int i, String str, String str2, long j) {
        if (Logger.debug()) {
            Logger.d(TAG, "URLDispatcher::onServerConfigChanged, tnc source is " + i + "etag is " + str);
        }
        this.mTncUpdateSource.set(i);
        this.mTncEtag = str;
        this.mTncAbTest = str2;
        this.mTncUpdateTime.set(j);
        int optInt = jSONObject.optInt("ignore_retrofit_slash_enabled_v2", -1);
        if (optInt >= -1) {
            TTConfigManager.setIgnoreSlashEnabledV2(optInt == 1);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("request_delay_actions");
        try {
            this.mDelayActionslock.writeLock().lock();
            this.mDelayActions.clear();
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        parseDelayAction(optJSONObject);
                    }
                }
            }
            if (!this.mDelayActions.isEmpty()) {
                Collections.sort(this.mDelayActions, new ActionComparator());
            }
            int optInt2 = jSONObject.optInt("ttnet_url_dispatcher_enabled", -1);
            if (optInt2 >= 0) {
                this.mDispatcherEnabled.set(optInt2 == 1);
            }
            long optInt3 = jSONObject.optInt("ttnet_dispatch_actions_epoch", -1);
            if (optInt3 == this.mDispatchActionEpoch.get()) {
                if (Logger.debug()) {
                    Logger.d(TAG, "dispatch action epoch not changed");
                    return;
                }
                return;
            }
            this.mDispatchActionEpoch.set(optInt3);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ttnet_dispatch_actions");
            if (optJSONArray2 == null) {
                return;
            }
            try {
                this.mDispatchActionslock.writeLock().lock();
                this.mDispatchActions.clear();
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i3);
                    if (optJSONObject2 != null) {
                        parseAction(optJSONObject2);
                    }
                }
                if (!this.mDispatchActions.isEmpty()) {
                    Collections.sort(this.mDispatchActions, new ActionComparator());
                }
            } finally {
                this.mDispatchActionslock.writeLock().unlock();
                if (Logger.debug()) {
                    Logger.d(TAG, "parse dispatch actions completed, actions size is " + this.mDispatchActions.size());
                }
            }
        } finally {
            this.mDelayActionslock.writeLock().unlock();
            if (Logger.debug()) {
                Logger.d(TAG, "parse delay actions completed, actions size is " + this.mDelayActions.size());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0080 A[LOOP:0: B:17:0x0080->B:23:0x0093, LOOP_START, PHI: r7
      0x0080: PHI (r7v1 int) = (r7v0 int), (r7v2 int) binds: [B:16:0x007e, B:23:0x0093] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseAction(JSONObject jSONObject) {
        int optInt;
        JSONObject optJSONObject;
        long j;
        long longValue;
        JSONArray optJSONArray;
        BaseDispatchAction factory;
        String optString = jSONObject.optString(StrategyConstants.ACTION);
        if (TextUtils.isEmpty(optString) || (optInt = jSONObject.optInt("act_priority", -1)) < 0 || (optJSONObject = jSONObject.optJSONObject("param")) == null) {
            return;
        }
        String optString2 = jSONObject.optString("lifecycle");
        if ("".equals(optString2)) {
            j = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            if (NetworklibUtils.splitUTCTimeSegmentToList(optString2, arrayList) && arrayList.size() == 2) {
                long longValue2 = ((Long) arrayList.get(0)).longValue();
                longValue = ((Long) arrayList.get(1)).longValue();
                j = longValue2;
                long optInt2 = jSONObject.optInt(StrategyConstants.RULE_ID);
                String optString3 = jSONObject.optString("sign");
                ArrayList arrayList2 = new ArrayList();
                optJSONArray = jSONObject.optJSONArray("request_method");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString4 = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString4)) {
                            arrayList2.add(optString4);
                        }
                    }
                }
                factory = BaseDispatchAction.factory(optString, optJSONObject, optInt, j, longValue, optInt2, optString3, this.mDispatchActionEpoch.get(), arrayList2, jSONObject.optInt("set_req_priority", optInt));
                if (factory instanceof URLDispatchAction) {
                    return;
                }
                this.mDispatchActions.add((URLDispatchAction) factory);
                return;
            }
            j = -1;
        }
        longValue = j;
        long optInt22 = jSONObject.optInt(StrategyConstants.RULE_ID);
        String optString32 = jSONObject.optString("sign");
        ArrayList arrayList22 = new ArrayList();
        optJSONArray = jSONObject.optJSONArray("request_method");
        if (optJSONArray != null) {
        }
        factory = BaseDispatchAction.factory(optString, optJSONObject, optInt, j, longValue, optInt22, optString32, this.mDispatchActionEpoch.get(), arrayList22, jSONObject.optInt("set_req_priority", optInt));
        if (factory instanceof URLDispatchAction) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseDelayAction(JSONObject jSONObject) {
        JSONObject optJSONObject;
        long j;
        long longValue;
        long longValue2;
        BaseDispatchAction factory;
        int optInt = jSONObject.optInt("act_priority", -1);
        if (optInt < 0 || (optJSONObject = jSONObject.optJSONObject("param")) == null) {
            return;
        }
        String optString = jSONObject.optString("lifecycle");
        if ("".equals(optString)) {
            j = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            if (NetworklibUtils.splitUTCTimeSegmentToList(optString, arrayList) && arrayList.size() == 2) {
                longValue = ((Long) arrayList.get(0)).longValue();
                longValue2 = ((Long) arrayList.get(1)).longValue();
                factory = BaseDispatchAction.factory("delay", optJSONObject, optInt, longValue, longValue2, 0L, "", this.mDispatchActionEpoch.get(), null, 0);
                if (factory instanceof DelayTypedAction) {
                    return;
                }
                this.mDelayActions.add((DelayTypedAction) factory);
                return;
            }
            j = -1;
        }
        longValue = j;
        longValue2 = longValue;
        factory = BaseDispatchAction.factory("delay", optJSONObject, optInt, longValue, longValue2, 0L, "", this.mDispatchActionEpoch.get(), null, 0);
        if (factory instanceof DelayTypedAction) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class ActionComparator implements Comparator<BaseDispatchAction> {
        ActionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(BaseDispatchAction baseDispatchAction, BaseDispatchAction baseDispatchAction2) {
            return baseDispatchAction.getPriority() - baseDispatchAction2.getPriority();
        }
    }

    public boolean isDispatchActionsEmpty() {
        return this.mDispatchActions.isEmpty();
    }

    public long getEpoch() {
        return this.mDispatchActionEpoch.get();
    }

    public int getTncUpdateSource() {
        return this.mTncUpdateSource.get();
    }

    public long getTncUpdateTime() {
        return this.mTncUpdateTime.get();
    }

    public String getTncEtag() {
        return this.mTncEtag;
    }

    public String getTncAbTest() {
        return this.mTncAbTest;
    }

    public ConcurrentMap<String, String> getHostReplaceMap() {
        return this.mHostReplaceMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String handleHostMapping(String str) {
        String str2;
        ConcurrentMap<String, String> concurrentMap;
        URL url;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v5") && !str.contains("/ies/speed")) {
            String str3 = null;
            try {
                url = new URL(str);
                str2 = url.getProtocol();
            } catch (Throwable th) {
                th = th;
                str2 = null;
            }
            try {
                str3 = url.getHost();
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (!TextUtils.isEmpty(str2)) {
                    concurrentMap = this.mHostReplaceMap;
                    if (concurrentMap != null) {
                    }
                    if (Logger.debug()) {
                    }
                }
                return str;
            }
            if (!TextUtils.isEmpty(str2) && (("http".equals(str2) || ProxyConfig.MATCH_HTTPS.equals(str2)) && !TextUtils.isEmpty(str3))) {
                concurrentMap = this.mHostReplaceMap;
                if (concurrentMap != null || !concurrentMap.containsKey(str3)) {
                    if (Logger.debug()) {
                        Logger.d(TAG, "handleHostMapping, nomatch: " + str3);
                    }
                } else {
                    String str4 = this.mHostReplaceMap.get(str3);
                    if (TextUtils.isEmpty(str4)) {
                        return str;
                    }
                    if (Logger.debug()) {
                        Logger.d(TAG, "handleHostMapping, match, origin: " + str);
                    }
                    String str5 = str2 + "://" + str3;
                    String str6 = str2 + "://" + str4;
                    if (str.startsWith(str5)) {
                        str = str.replaceFirst(str5, str6);
                    }
                    if (Logger.debug()) {
                        Logger.d(TAG, "handleHostMapping, target: " + str);
                    }
                    return str;
                }
            }
        }
        return str;
    }

    public void loadLocalConfig(Context context) {
        JSONObject optJSONObject;
        if (!ProcessUtils.isMainProcessByProcessFlag(context) || mLocalConfigLoaded.get()) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(TNC_SP_NAME, 0);
        boolean z = sharedPreferences.getBoolean("is_full_config", false);
        String string = sharedPreferences.getString("tnc_config_str", null);
        String string2 = sharedPreferences.getString("ttnet_tnc_etag", null);
        String string3 = sharedPreferences.getString("ttnet_tnc_abtest", null);
        try {
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                if (z && (optJSONObject = jSONObject.optJSONObject(Constants.KEY_DATA)) != null) {
                    jSONObject = optJSONObject;
                }
                inst().onServerConfigChanged(jSONObject, 0, string2, string3, System.currentTimeMillis());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mLocalConfigLoaded.set(true);
    }
}
