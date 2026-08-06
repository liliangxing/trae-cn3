package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class URLDispatchAction extends BaseDispatchAction {
    private static final String TAG = "URLDispatchAction";
    private boolean mNeedRequestResultFeedBack = false;

    public abstract BaseDispatchAction.DispatchResultEnum dispatch(URLRequest uRLRequest, String str, List<String> list);

    public abstract int getDispatchStrategyType();

    public int getTcTypedDropCode() {
        return -555;
    }

    protected abstract boolean loadActionParam(JSONObject jSONObject, List<Boolean> list, String str, long j);

    protected abstract void onRequestCompleted(String str, boolean z, int i);

    public BaseDispatchAction.DispatchResultEnum takeAction(URLRequest uRLRequest, String str, List<String> list, List<DispatchActionInfo> list2) {
        if (!isActionEffective(uRLRequest) || TextUtils.isEmpty(str)) {
            list.set(0, str);
            return BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE;
        }
        BaseDispatchAction.DispatchResultEnum dispatch = dispatch(uRLRequest, str, list);
        DispatchActionInfo dispatchActionInfo = new DispatchActionInfo();
        if (dispatch != BaseDispatchAction.DispatchResultEnum.DISPATCH_NONE) {
            dispatchActionInfo.mActionHit = true;
            dispatchActionInfo.mRuleid = getRuleId();
            dispatchActionInfo.mPriority = getPriority();
            dispatchActionInfo.mStrategyType = getDispatchStrategyType();
            dispatchActionInfo.mServiceName = getServiceName();
            if (dispatch == BaseDispatchAction.DispatchResultEnum.DISPATCH_HIT) {
                dispatchActionInfo.mDispatchedUrl = list.get(0);
                dispatchActionInfo.mNeedFeedBack = needRequestResultFeedBack();
            }
            uRLRequest.setDispatchPriority(this.mSetReqPriority);
        }
        list2.add(dispatchActionInfo);
        return dispatch;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.BaseDispatchAction
    public boolean initWithActionParam(JSONObject jSONObject, String str, long j) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, false);
        boolean loadActionParam = loadActionParam(jSONObject, arrayList, str, j);
        this.mNeedRequestResultFeedBack = arrayList.get(0).booleanValue();
        return loadActionParam;
    }

    public void notifyRequestCompleted(String str, boolean z, int i) {
        if (this.mNeedRequestResultFeedBack) {
            onRequestCompleted(str, z, i);
        }
    }

    public boolean needRequestResultFeedBack() {
        return this.mNeedRequestResultFeedBack;
    }
}
