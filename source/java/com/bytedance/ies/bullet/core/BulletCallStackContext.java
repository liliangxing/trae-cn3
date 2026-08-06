package com.bytedance.ies.bullet.core;

import android.app.Activity;
import android.content.Context;
import bolts.Task;
import com.bytedance.ies.bullet.core.common.Scenes;
import com.bytedance.ies.bullet.core.util.ContextUtil;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletCallStackContext;", "", "()V", "attachCallee", "", "callee", "Landroid/content/Context;", "sessionId", "", "scenes", "Lcom/bytedance/ies/bullet/core/common/Scenes;", "attachCaller", "caller", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BulletCallStackContext {
    public final void attachCaller(final Context caller, final String sessionId) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.core.BulletCallStackContext$attachCaller$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                Unit unit;
                Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(caller);
                if (ownerActivity != null) {
                    BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, sessionId, "Caller " + ownerActivity.getComponentName().toShortString() + ": " + ownerActivity.hashCode(), "XView", null, 8, null);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, sessionId, "Caller unknown", "XView", null, 8, null);
                }
            }
        });
    }

    public final void attachCallee(final Context callee, final String sessionId, final Scenes scenes) {
        Intrinsics.checkNotNullParameter(callee, "callee");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(scenes, "scenes");
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.core.BulletCallStackContext$attachCallee$1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                Unit unit;
                Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(callee);
                if (ownerActivity != null) {
                    BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, sessionId, "Callee " + ownerActivity.getComponentName().toShortString() + ": " + ownerActivity.hashCode() + " on " + scenes.getTag(), "XView", null, 8, null);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    BulletLogger.printCoreLog$default(BulletLogger.INSTANCE, sessionId, "Callee unknown on " + scenes.getTag(), "XView", null, 8, null);
                }
            }
        });
    }
}
