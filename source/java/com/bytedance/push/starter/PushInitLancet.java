package com.bytedance.push.starter;

import android.app.Application;
import android.util.Log;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: classes4.dex */
public class PushInitLancet {
    public static boolean enableHook = true;

    @TargetClass(scope = Scope.ALL, value = "android.app.Application")
    @Insert("onCreate")
    public void onCreate() {
        Log.d("PushStarter", "hook of Application.onCreate by Lancet");
        if (!enableHook) {
            Origin.callVoid();
        } else if (PushHook.onHookApplicationOnCreate((Application) This.get())) {
            Origin.callVoid();
        }
    }
}
