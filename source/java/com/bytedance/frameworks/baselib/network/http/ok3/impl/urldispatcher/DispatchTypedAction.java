package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class DispatchTypedAction extends URLDispatchAction {
    private static final String TAG = "DispatchTypedAction";
    private DispatchStrategy mDispatchStrategy;

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public BaseDispatchAction.DispatchResultEnum dispatch(URLRequest uRLRequest, String str, List<String> list) {
        if (Logger.debug()) {
            Logger.d(TAG, "dispatch action " + this.mDispatchStrategy.getDispatchStrategyType());
        }
        BaseDispatchAction.DispatchResultEnum dispatchResultEnum = BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        Uri parse = Uri.parse(str);
        if (parse.getHost() != null && isMatchRules(parse) && this.mDispatchStrategy != null) {
            dispatchResultEnum = BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT;
            if (this.mDispatchStrategy.getDispatchStrategyType() == DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY) {
                this.mDispatchStrategy.dispatchRequestHeaders(uRLRequest);
                list.set(0, str);
                return dispatchResultEnum;
            }
            String targetUrl = this.mDispatchStrategy.getTargetUrl(parse);
            if (!str.equals(targetUrl)) {
                list.set(0, targetUrl);
            } else {
                list.set(0, str);
            }
        }
        return dispatchResultEnum;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    protected void onRequestCompleted(String str, boolean z, int i) {
        this.mDispatchStrategy.notifyRequestResult(str, z, i);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    public int getDispatchStrategyType() {
        return this.mDispatchStrategy.getDispatchStrategyType().ordinal();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatchAction
    protected boolean loadActionParam(JSONObject jSONObject, List<Boolean> list, String str, long j) {
        loadMatchRules(jSONObject);
        String optString = jSONObject.optString("service_name");
        if (!TextUtils.isEmpty(optString)) {
            this.mServiceName = optString;
        }
        int optInt = jSONObject.optInt("dispatch_strategy", 0);
        JSONObject optJSONObject = jSONObject.optJSONObject("strategy_info");
        if (optInt < 0 || optInt > 6) {
            this.mDispatchStrategy = null;
            return false;
        }
        DispatchStrategy factory = DispatchStrategy.factory(DispatchStrategy.DispatchStrategyType.values()[optInt], optJSONObject, str, j, getPriority());
        this.mDispatchStrategy = factory;
        list.set(0, Boolean.valueOf(factory.needRequestResultFeedback()));
        return true;
    }
}
