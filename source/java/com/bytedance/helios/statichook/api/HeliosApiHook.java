package com.bytedance.helios.statichook.api;

import android.util.Log;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class HeliosApiHook {
    private final List<ActionInvoker> postInvokers = new ArrayList();

    public Result preInvoke(int i, String str, String str2, Object obj, Object[] objArr, String str3, ExtraInfo extraInfo) {
        Result preInvoke;
        for (ActionInvoker actionInvoker : ApiHookConfig.getInvokersById(Integer.valueOf(i))) {
            try {
                preInvoke = actionInvoker.preInvoke(i, str, str2, obj, objArr, str3, extraInfo);
            } catch (Exception e) {
                e = e;
            }
            if (preInvoke.isIntercept()) {
                return preInvoke;
            }
            try {
                this.postInvokers.add(actionInvoker);
            } catch (Exception e2) {
                e = e2;
                Log.e("HeliosApiHook", null, e);
            }
        }
        return new Result(false, null);
    }

    public void postInvoke(int i, String str, String str2, Object obj, Object[] objArr, Object obj2, ExtraInfo extraInfo, boolean z) {
        for (int size = this.postInvokers.size() - 1; size >= 0; size--) {
            try {
                this.postInvokers.get(size).postInvoke(i, str, str2, obj, objArr, obj2, extraInfo, z);
            } catch (Exception e) {
                Log.e("HeliosApiHook", null, e);
            }
        }
    }
}
