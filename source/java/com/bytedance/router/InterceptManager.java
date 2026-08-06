package com.bytedance.router;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.router.RouteIntent;
import com.bytedance.router.interceptor.IInterceptor;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class InterceptManager {
    private List<IInterceptor> mInterceptors = null;

    public synchronized void addInterceptor(IInterceptor iInterceptor) {
        if (iInterceptor == null) {
            return;
        }
        if (this.mInterceptors == null) {
            this.mInterceptors = new LinkedList();
        }
        this.mInterceptors.add(iInterceptor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean processRouteIntent(Context context, RouteIntent routeIntent) {
        if (routeIntent == null) {
            return true;
        }
        List<IInterceptor> list = this.mInterceptors;
        if (list != null && list.size() != 0) {
            for (IInterceptor iInterceptor : this.mInterceptors) {
                if (iInterceptor.matchInterceptRules(routeIntent) && iInterceptor.onInterceptRoute(context, routeIntent)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean whetherIntercept(String str) {
        List<IInterceptor> list;
        if (!TextUtils.isEmpty(str) && (list = this.mInterceptors) != null && list.size() != 0) {
            RouteIntent build = new RouteIntent.Builder(str).build();
            Iterator<IInterceptor> it = this.mInterceptors.iterator();
            while (it.hasNext()) {
                if (it.next().matchInterceptRules(build)) {
                    return true;
                }
            }
        }
        return false;
    }
}
