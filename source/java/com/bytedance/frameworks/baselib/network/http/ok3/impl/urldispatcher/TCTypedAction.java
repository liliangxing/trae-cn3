package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import androidx.webkit.ProxyConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction;
import java.util.List;
import java.util.Random;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class TCTypedAction extends URLDispatchAction {
    public static final int DEFAULT_DROP_CODE = -555;
    private static final int MAX_USER_DEFINED_DROP_CODE = -5551;
    private static final int MIN_USER_DEFINED_DROP_CODE = -5559;
    private static final String TAG = "TCTypedAction";
    private String mHostReplace;
    private String mPathReplace;
    private String mReplaceRegex;
    private String mReplaceValue;
    private String mSchemeReplace;
    private boolean mIsDrop = false;
    private int mDropCode = DEFAULT_DROP_CODE;
    private int mPossibility = 100;
    private boolean mIsInvalid = false;

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getDispatchStrategyType() {
        return -1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    protected void onRequestCompleted(String str, boolean z, int i) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public BaseDispatchAction.DispatchResultEnum dispatch(URLRequest uRLRequest, String str, List<String> list) {
        if (Logger.debug()) {
            Logger.d(TAG, "tc action");
        }
        Uri parse = Uri.parse(str);
        if (this.mIsInvalid || !isMatchRules(parse)) {
            list.set(0, str);
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        }
        list.set(0, str);
        if (this.mIsDrop) {
            if (Logger.debug()) {
                Logger.d(TAG, "drop action");
            }
            if (isPossibilityHit()) {
                list.set(0, "");
                return BaseDispatchAction.DispatchResultEnum.DISPATCH_DROP;
            }
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        }
        if (!this.mHostReplace.isEmpty() || !this.mSchemeReplace.isEmpty() || !this.mPathReplace.isEmpty()) {
            if (parse.getScheme() != null && canReplceScheme(parse.getScheme(), this.mSchemeReplace)) {
                str = str.replaceFirst(parse.getScheme(), this.mSchemeReplace);
            }
            if (parse.getHost() != null && !TextUtils.isEmpty(this.mHostReplace)) {
                str = str.replaceFirst(parse.getHost(), this.mHostReplace);
            }
            if (parse.getPath() != null && !TextUtils.isEmpty(this.mPathReplace)) {
                str = str.replaceFirst(parse.getPath(), this.mPathReplace);
            }
            list.set(0, str);
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
        }
        if (!TextUtils.isEmpty(this.mReplaceValue) && !TextUtils.isEmpty(this.mReplaceRegex)) {
            list.set(0, str.replaceAll(this.mReplaceRegex, this.mReplaceValue));
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
        }
        return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    protected boolean loadActionParam(JSONObject jSONObject, List<Boolean> list, String str, long j) {
        loadMatchRules(jSONObject);
        this.mServiceName = jSONObject.optString("service_name");
        this.mSchemeReplace = jSONObject.optString("scheme_replace");
        this.mHostReplace = jSONObject.optString("host_replace");
        this.mPathReplace = jSONObject.optString("path_replace");
        String optString = jSONObject.optString("replace");
        this.mReplaceValue = optString;
        if (!TextUtils.isEmpty(optString)) {
            String optString2 = jSONObject.optString("regex");
            if (isPatternStringValid(optString2)) {
                this.mReplaceRegex = optString2;
            } else {
                this.mIsInvalid = true;
                return true;
            }
        }
        this.mIsDrop = jSONObject.optInt("drop") == 1;
        int optInt = jSONObject.optInt("drop_code", -1);
        if (optInt == -555 || (optInt >= MIN_USER_DEFINED_DROP_CODE && optInt <= MAX_USER_DEFINED_DROP_CODE)) {
            this.mDropCode = optInt;
        }
        int optInt2 = jSONObject.optInt("possibility", 100);
        if (optInt2 >= 0 && optInt2 <= 100) {
            this.mPossibility = optInt2;
        }
        if ((this.mEqualGroup.isEmpty() && this.mPrefixGroup.isEmpty() && this.mContainGroup.isEmpty() && this.mPatternGroup.isEmpty() && this.mFullUrlGroup.isEmpty()) || (!this.mIsDrop && this.mSchemeReplace.isEmpty() && this.mHostReplace.isEmpty() && this.mPathReplace.isEmpty() && this.mReplaceValue.isEmpty())) {
            this.mIsInvalid = true;
        }
        list.set(0, false);
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getTcTypedDropCode() {
        return this.mDropCode;
    }

    private boolean isPossibilityHit() {
        int i = this.mPossibility;
        if (i >= 100) {
            return true;
        }
        if (i <= 0) {
            return false;
        }
        if (new Random().nextInt(100) < this.mPossibility) {
            return true;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "tc drop action was probabilistic discard");
        }
        return false;
    }

    private boolean canReplceScheme(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        return ((str.equals("http") || str.equals(ProxyConfig.MATCH_HTTPS)) && (str2.equals("http") || str2.equals(ProxyConfig.MATCH_HTTPS))) || ((str.equals("ws") || str.equals("wss")) && (str2.equals("ws") || str2.equals("wss")));
    }
}
