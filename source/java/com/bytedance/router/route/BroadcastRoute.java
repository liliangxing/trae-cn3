package com.bytedance.router.route;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes4.dex */
public class BroadcastRoute extends SysComponentRoute {
    @Override // com.bytedance.router.route.SysComponentRoute
    public void openComponent(Context context, Intent intent) {
        context.sendBroadcast(intent);
    }
}
