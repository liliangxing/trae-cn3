package com.bytedance.router.route;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import com.bytedance.router.RouteIntent;
import com.bytedance.router.util.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ActivityRoute extends SysComponentRoute {
    @Override // com.bytedance.router.route.SysComponentRoute
    public void openComponent(Context context, Intent intent) {
        RouteIntent routeIntent = getRouteIntent();
        if (routeIntent.getData() != null) {
            intent.setData(routeIntent.getData());
        }
        Activity tryGetActivity = tryGetActivity(context);
        if (tryGetActivity != null) {
            if (routeIntent.hasRequestCode()) {
                tryGetActivity.startActivityForResult(intent, routeIntent.getRequestCode());
            } else {
                context.startActivity(intent);
            }
            if (routeIntent.getEnterAnim() == -1 && routeIntent.getExitAnim() == -1) {
                return;
            }
            tryGetActivity.overridePendingTransition(getRouteIntent().getEnterAnim(), getRouteIntent().getExitAnim());
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
        if (routeIntent.hasRequestCode()) {
            Logger.m352e("SmartRoute.open(int requestCode):the context must be Activity !!!");
        }
        if (routeIntent.getEnterAnim() == -1 && routeIntent.getExitAnim() == -1) {
            return;
        }
        Logger.m352e("SmartRoute.withAnimation(int enterAnim, int exitAnim):the context must be Activity !!!");
    }

    private Activity tryGetActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return tryGetActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}
