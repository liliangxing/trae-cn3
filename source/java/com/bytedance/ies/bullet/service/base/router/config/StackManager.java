package com.bytedance.ies.bullet.service.base.router.config;

import android.app.Activity;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IRouterAbilityProvider;
import com.bytedance.ies.bullet.service.base.utils.XConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StackManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u001a\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/router/config/StackManager;", "", "()V", "activityList", "", "Lcom/bytedance/ies/bullet/service/base/IRouterAbilityProvider;", "popupList", "add", "", "item", "sessionId", "", "getActivityList", "", "remove", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StackManager {
    private static final String TAG = "StackManager";
    private final List<IRouterAbilityProvider> activityList = new ArrayList();
    private final List<IRouterAbilityProvider> popupList = new ArrayList();

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<StackManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<StackManager>() { // from class: com.bytedance.ies.bullet.service.base.router.config.StackManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StackManager m557invoke() {
            return new StackManager();
        }
    });

    /* compiled from: StackManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/router/config/StackManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/bytedance/ies/bullet/service/base/router/config/StackManager;", "getInstance", "()Lcom/bytedance/ies/bullet/service/base/router/config/StackManager;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StackManager getInstance() {
            return (StackManager) StackManager.instance$delegate.getValue();
        }
    }

    public static /* synthetic */ void add$default(StackManager stackManager, IRouterAbilityProvider iRouterAbilityProvider, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        stackManager.add(iRouterAbilityProvider, str);
    }

    public final void add(IRouterAbilityProvider item, String sessionId) {
        Object obj;
        boolean add;
        Intrinsics.checkNotNullParameter(item, "item");
        LoggerContext loggerContext = new LoggerContext();
        if (sessionId == null) {
            sessionId = "";
        }
        loggerContext.pushStage(XConstant.SESSION_ID, sessionId);
        try {
            Result.Companion companion = Result.Companion;
            if (item instanceof Activity) {
                HybridLogger.INSTANCE.m11i("XPage", "add activity to stack", MapsKt.mapOf(new Pair[]{TuplesKt.to("activity url", String.valueOf(item.getSchema())), TuplesKt.to("activity stack", this.activityList.toString())}), loggerContext);
                add = this.activityList.add(item);
            } else {
                HybridLogger.INSTANCE.m11i("XPopup", "add popup to stack", MapsKt.mapOf(new Pair[]{TuplesKt.to("popup url", String.valueOf(item.getSchema())), TuplesKt.to("popup stack", this.popupList.toString())}), loggerContext);
                add = this.popupList.add(item);
            }
            obj = Result.constructor-impl(Boolean.valueOf(add));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("activity url", String.valueOf(item.getSchema()));
            String message = th2.getMessage();
            pairArr[1] = TuplesKt.to("error message", message != null ? message : "");
            hybridLogger.m9e("XPage", "add stack error", MapsKt.mapOf(pairArr), loggerContext);
        }
    }

    public static /* synthetic */ void remove$default(StackManager stackManager, IRouterAbilityProvider iRouterAbilityProvider, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        stackManager.remove(iRouterAbilityProvider, str);
    }

    public final void remove(IRouterAbilityProvider item, String sessionId) {
        Object obj;
        boolean remove;
        Intrinsics.checkNotNullParameter(item, "item");
        LoggerContext loggerContext = new LoggerContext();
        if (sessionId == null) {
            sessionId = "";
        }
        loggerContext.pushStage(XConstant.SESSION_ID, sessionId);
        try {
            Result.Companion companion = Result.Companion;
            if (item instanceof Activity) {
                HybridLogger.INSTANCE.m11i("XPage", "remove activity to stack", MapsKt.mapOf(TuplesKt.to("activity url", String.valueOf(item.getSchema()))), loggerContext);
                remove = this.activityList.remove(item);
            } else {
                HybridLogger.INSTANCE.m11i("XPopup", "remove popup to stack", MapsKt.mapOf(TuplesKt.to("popup url", String.valueOf(item.getSchema()))), loggerContext);
                remove = this.popupList.remove(item);
            }
            obj = Result.constructor-impl(Boolean.valueOf(remove));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger hybridLogger = HybridLogger.INSTANCE;
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("activity url", String.valueOf(item.getSchema()));
            String message = th2.getMessage();
            pairArr[1] = TuplesKt.to("error message", message != null ? message : "");
            hybridLogger.m9e("XPage", "remove stack error", MapsKt.mapOf(pairArr), loggerContext);
        }
    }

    public final List<IRouterAbilityProvider> getActivityList() {
        BulletLogger.printLog$default(BulletLogger.INSTANCE, "getActivityList:" + this.activityList, null, "XPage", 2, null);
        return CollectionsKt.reversed(this.activityList);
    }
}
