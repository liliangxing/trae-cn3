package com.bytedance.android.anniex.api;

import android.content.Context;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.service.AnnieXLynxAsyncLoadRunnableMeta;
import com.bytedance.android.anniex.base.service.AnnieXLynxOptimizeService;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.monitorV2.lynx.LynxViewMonitor;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.lynx.tasm.LynxView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000b2@\b\u0002\u0010\f\u001a:\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\u0004\u0018\u0001`\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u001c\u0010\u0019\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u001a\u0010\u001a\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017\u001a\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a&\u0010 \u001a\u00020\n*\u00020\u00022\u0006\u0010!\u001a\u00020\u00172\b\b\u0002\u0010\"\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010\u0017\u001a$\u0010$\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0005\u001a$\u0010&\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0007\u001a\u0014\u0010'\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010)\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0006\u001a\u00020**j\u0010+\"2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\r22\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\r*\"\u0010,\"\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t¨\u0006-"}, d2 = {"asyncLayoutLynxView", "", "Lcom/bytedance/android/anniex/assemble/AnnieX;", "needRender", "lynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "lynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "loadMethod", "Lkotlin/Function1;", "", "Lcom/bytedance/android/anniex/api/AnnieXLynxLoadMethod;", "layoutCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", StrategyConstants.NAME, "view", "success", "Lcom/bytedance/android/anniex/api/AnnieXLynxLayoutCallback;", "loadRunnableMeta", "Lcom/bytedance/android/anniex/base/service/AnnieXLynxAsyncLoadRunnableMeta;", "clearLynxModel", "bid", "", "key", "clearLynxView", "createLynxView", "context", "Landroid/content/Context;", "getLynxModel", "getLynxView", "getViewFromCacheFuture", "preloadTemplate", StreamTrafficObservable.STREAM_URL, "withSubResources", "sessionId", "putLynxModel", StrategyConstants.VALUE, "putLynxView", "removeViewFromCache", "renderAsyncLayoutLynxView", "reportNavigationStart", "Lcom/lynx/tasm/LynxView;", "AnnieXLynxLayoutCallback", "AnnieXLynxLoadMethod", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXApiKt {
    public static final AnnieXLynxView createLynxView(AnnieX annieX, Context context, AnnieXLynxModel annieXLynxModel) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(annieXLynxModel, "lynxModel");
        return AnnieXApi.INSTANCE.createLynxView(context, annieXLynxModel);
    }

    public static /* synthetic */ void putLynxModel$default(AnnieX annieX, String str, String str2, AnnieXLynxModel annieXLynxModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        putLynxModel(annieX, str, str2, annieXLynxModel);
    }

    public static final void putLynxModel(AnnieX annieX, String str, String str2, AnnieXLynxModel annieXLynxModel) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "key");
        Intrinsics.checkNotNullParameter(annieXLynxModel, StrategyConstants.VALUE);
        AnnieXLynxOptimizeService.INSTANCE.putModel(str, str2, annieXLynxModel);
    }

    public static /* synthetic */ AnnieXLynxModel getLynxModel$default(AnnieX annieX, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return getLynxModel(annieX, str, str2);
    }

    public static final AnnieXLynxModel getLynxModel(AnnieX annieX, String str, String str2) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "key");
        return AnnieXLynxOptimizeService.INSTANCE.getModel(str, str2);
    }

    public static /* synthetic */ void clearLynxModel$default(AnnieX annieX, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        clearLynxModel(annieX, str, str2);
    }

    public static final void clearLynxModel(AnnieX annieX, String str, String str2) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "key");
        AnnieXLynxOptimizeService.INSTANCE.clearModel(str, str2);
    }

    public static /* synthetic */ void putLynxView$default(AnnieX annieX, String str, String str2, AnnieXLynxView annieXLynxView, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        putLynxView(annieX, str, str2, annieXLynxView);
    }

    public static final void putLynxView(AnnieX annieX, String str, String str2, AnnieXLynxView annieXLynxView) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "key");
        Intrinsics.checkNotNullParameter(annieXLynxView, StrategyConstants.VALUE);
        AnnieXLynxOptimizeService.INSTANCE.putView(str, str2, annieXLynxView);
    }

    public static /* synthetic */ AnnieXLynxView getLynxView$default(AnnieX annieX, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return getLynxView(annieX, str, str2);
    }

    public static final AnnieXLynxView getLynxView(AnnieX annieX, String str, String str2) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "key");
        return AnnieXLynxOptimizeService.INSTANCE.getView(str, str2);
    }

    public static /* synthetic */ void clearLynxView$default(AnnieX annieX, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        clearLynxView(annieX, str, str2);
    }

    public static final void clearLynxView(AnnieX annieX, String str, String str2) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "key");
        AnnieXLynxOptimizeService.INSTANCE.clearView(str, str2);
    }

    public static /* synthetic */ boolean asyncLayoutLynxView$default(AnnieX annieX, boolean z, AnnieXLynxModel annieXLynxModel, AnnieXLynxView annieXLynxView, Function1 function1, Function2 function2, AnnieXLynxAsyncLoadRunnableMeta annieXLynxAsyncLoadRunnableMeta, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return asyncLayoutLynxView(annieX, z, annieXLynxModel, annieXLynxView, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : function2, (i & 32) != 0 ? null : annieXLynxAsyncLoadRunnableMeta);
    }

    public static final boolean asyncLayoutLynxView(AnnieX annieX, boolean z, AnnieXLynxModel annieXLynxModel, AnnieXLynxView annieXLynxView, Function1<? super AnnieXLynxView, Unit> function1, Function2<? super AnnieXLynxView, ? super Boolean, Unit> function2, AnnieXLynxAsyncLoadRunnableMeta annieXLynxAsyncLoadRunnableMeta) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(annieXLynxModel, "lynxModel");
        Intrinsics.checkNotNullParameter(annieXLynxView, "lynxView");
        return AnnieXLynxOptimizeService.INSTANCE.asyncLayoutView(z, annieXLynxModel, annieXLynxView, function1, function2, annieXLynxAsyncLoadRunnableMeta);
    }

    public static final boolean renderAsyncLayoutLynxView(AnnieX annieX, AnnieXLynxModel annieXLynxModel, AnnieXLynxView annieXLynxView) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(annieXLynxModel, "lynxModel");
        Intrinsics.checkNotNullParameter(annieXLynxView, "lynxView");
        return AnnieXLynxOptimizeService.INSTANCE.renderView(annieXLynxModel, annieXLynxView);
    }

    public static final AnnieXLynxView removeViewFromCache(AnnieX annieX, AnnieXLynxModel annieXLynxModel) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(annieXLynxModel, "lynxModel");
        return AnnieXLynxOptimizeService.INSTANCE.removeViewFromCache(annieXLynxModel);
    }

    public static final AnnieXLynxView getViewFromCacheFuture(AnnieX annieX, AnnieXLynxModel annieXLynxModel) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(annieXLynxModel, "lynxModel");
        return AnnieXLynxOptimizeService.INSTANCE.getViewFromCacheFuture(annieXLynxModel);
    }

    public static /* synthetic */ void preloadTemplate$default(AnnieX annieX, String str, boolean z, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        preloadTemplate(annieX, str, z, str2);
    }

    public static final void preloadTemplate(AnnieX annieX, String str, boolean z, String str2) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(str, StreamTrafficObservable.STREAM_URL);
        AnnieXApi.INSTANCE.preloadTemplate(str, z, str2);
    }

    public static final void reportNavigationStart(AnnieX annieX, LynxView lynxView) {
        Intrinsics.checkNotNullParameter(annieX, "<this>");
        Intrinsics.checkNotNullParameter(lynxView, "lynxView");
        LynxViewMonitor.Companion.getINSTANCE().reportNavigationStart(lynxView);
    }
}
