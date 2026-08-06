package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.apm.constant.ReportConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class BaseDispatchAction {
    private static final String TAG = "BaseDispatchAction";
    private long mLifetimeBegin;
    private long mLifetimeEnd;
    private int mPriority;
    private long mRuleId;
    protected String mServiceName;
    protected int mSetReqPriority;
    protected List<String> mHostGroup = new ArrayList();
    protected List<String> mEqualGroup = new ArrayList();
    protected List<String> mPrefixGroup = new ArrayList();
    protected List<String> mContainGroup = new ArrayList();
    protected List<String> mPatternGroup = new ArrayList();
    protected List<String> mFullUrlGroup = new ArrayList();
    protected List<String> mFullUrlGroupPathContain = new ArrayList();
    private List<String> mSupportedMethods = new ArrayList();

    /* loaded from: classes2.dex */
    public enum DispatchResultEnum {
        DISPATCH_NONE,
        DISPATCH_HIT,
        DISPATCH_DROP,
        DISPATCH_DELAY
    }

    public abstract boolean initWithActionParam(JSONObject jSONObject, String str, long j);

    public static BaseDispatchAction factory(String str, JSONObject jSONObject, int i, long j, long j2, long j3, String str2, long j4, List<String> list, int i2) {
        BaseDispatchAction tCTypedAction = str.equals("tc") ? new TCTypedAction() : null;
        if (str.equals("dispatch")) {
            tCTypedAction = new DispatchTypedAction();
        }
        if (str.equals(ReportConsts.RESPONSE_DELAY)) {
            tCTypedAction = new DelayTypedAction();
        }
        if (tCTypedAction == null) {
            return null;
        }
        tCTypedAction.setPriority(i);
        tCTypedAction.setLifeCycle(j, j2);
        tCTypedAction.setRuleId(j3);
        tCTypedAction.setSupportedMethods(list);
        tCTypedAction.setSetRequestPriority(i2);
        if (tCTypedAction.initWithActionParam(jSONObject, str2, j4)) {
            return tCTypedAction;
        }
        return null;
    }

    private void setPriority(int i) {
        this.mPriority = i;
    }

    private void setLifeCycle(long j, long j2) {
        this.mLifetimeBegin = j;
        this.mLifetimeEnd = j2;
    }

    private void setRuleId(long j) {
        this.mRuleId = j;
    }

    private void setSupportedMethods(List<String> list) {
        this.mSupportedMethods = list;
    }

    private void setSetRequestPriority(int i) {
        if (i < 0) {
            this.mSetReqPriority = Integer.MAX_VALUE;
        } else {
            this.mSetReqPriority = i;
        }
    }

    public int getPriority() {
        return this.mPriority;
    }

    public long getRuleId() {
        return this.mRuleId;
    }

    public String getServiceName() {
        return this.mServiceName;
    }

    public boolean isActionEffective(URLRequest uRLRequest) {
        if (uRLRequest.getDispatchPriority() > this.mPriority) {
            if (Logger.debug()) {
                Logger.d(TAG, "jump action: " + this.mServiceName + ", dispatchPriority: " + uRLRequest.getDispatchPriority() + ", actionPriority: " + this.mPriority);
            }
            return false;
        }
        if (!this.mSupportedMethods.isEmpty() && !TextUtils.isEmpty(uRLRequest.getMethod()) && !this.mSupportedMethods.contains(uRLRequest.getMethod())) {
            if (Logger.debug()) {
                Logger.d(TAG, "request method not support: " + uRLRequest.getMethod());
            }
            return false;
        }
        return isLifeTimeEffective();
    }

    public boolean isDelayActionEffective() {
        return isLifeTimeEffective();
    }

    private boolean isLifeTimeEffective() {
        long j = this.mLifetimeBegin;
        if (j == 0 && this.mLifetimeEnd == 0) {
            return true;
        }
        if (j != -1 && this.mLifetimeEnd != -1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis > this.mLifetimeBegin && currentTimeMillis < this.mLifetimeEnd) {
                return true;
            }
            if (Logger.debug()) {
                Logger.d(TAG, "current time is out action lifecycle");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void loadMatchRules(JSONObject jSONObject) {
        loadParamList(jSONObject, "host_group", this.mHostGroup, false);
        loadParamList(jSONObject, "equal_group", this.mEqualGroup, false);
        loadParamList(jSONObject, "prefixes_group", this.mPrefixGroup, false);
        loadParamList(jSONObject, "contain_group", this.mContainGroup, false);
        loadParamList(jSONObject, "pattern_group", this.mPatternGroup, true);
        loadParamList(jSONObject, "url_group", this.mFullUrlGroup, true);
        loadParamList(jSONObject, "path_contain", this.mFullUrlGroupPathContain, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isMatchRules(Uri uri) {
        boolean z;
        boolean z2;
        if (!this.mHostGroup.isEmpty()) {
            Iterator<String> it = this.mHostGroup.iterator();
            while (it.hasNext()) {
                if (UrlUtils.matchPattern(uri.getHost(), it.next())) {
                }
            }
            z = false;
            if (z) {
                if (Logger.debug()) {
                    Logger.d(TAG, "host group is not match");
                }
                return false;
            }
            String path = uri.getPath();
            if (TextUtils.isEmpty(path)) {
                return false;
            }
            if (!this.mEqualGroup.isEmpty()) {
                for (String str : this.mEqualGroup) {
                    if (path.equals(str)) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "path equal hit: " + str);
                        }
                        return true;
                    }
                }
            }
            if (!this.mPrefixGroup.isEmpty()) {
                for (String str2 : this.mPrefixGroup) {
                    if (path.startsWith(str2)) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "path prefix hit: " + str2);
                        }
                        return true;
                    }
                }
            }
            if (!this.mContainGroup.isEmpty()) {
                for (String str3 : this.mContainGroup) {
                    if (path.contains(str3)) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "path contain hit: " + str3);
                        }
                        return true;
                    }
                }
            }
            if (!this.mPatternGroup.isEmpty()) {
                for (String str4 : this.mPatternGroup) {
                    if (path.matches(str4)) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "path pattern hit: " + str4);
                        }
                        return true;
                    }
                }
            }
            if (!this.mFullUrlGroup.isEmpty()) {
                if (!this.mFullUrlGroupPathContain.isEmpty()) {
                    Iterator<String> it2 = this.mFullUrlGroupPathContain.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        }
                        if (path.contains(it2.next())) {
                            z2 = true;
                            break;
                        }
                    }
                    if (!z2) {
                        return false;
                    }
                }
                for (String str5 : this.mFullUrlGroup) {
                    if (uri.toString().matches(str5)) {
                        if (Logger.debug()) {
                            Logger.d(TAG, "full url hit: " + str5);
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        z = true;
        if (z) {
        }
    }

    private void loadParamList(JSONObject jSONObject, String str, List<String> list, boolean z) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    if (z) {
                        if (isPatternStringValid(optString)) {
                            list.add(optString);
                        }
                    } else {
                        list.add(optString);
                    }
                }
            }
        }
    }

    public static boolean isPatternStringValid(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Pattern.compile(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
