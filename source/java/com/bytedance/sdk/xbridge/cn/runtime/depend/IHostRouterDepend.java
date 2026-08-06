package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostRouterDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0007H&J8\u0010\u000b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostRouterDepend;", "", "assembleHandlerChain", "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/AbsRouteOpenHandler;", "xBridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "closeView", "", "containerID", "", "animated", "openSchema", "schema", "extraParams", "", "context", "Landroid/content/Context;", "provideRouteOpenExceptionHandler", "provideRouteOpenHandlerList", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IHostRouterDepend {
    boolean closeView(IBDXBridgeContext xBridgeContext, String containerID, boolean animated);

    boolean openSchema(IBDXBridgeContext xBridgeContext, String schema, Map<String, ? extends Object> extraParams, Context context);

    AbsRouteOpenHandler provideRouteOpenExceptionHandler(IBDXBridgeContext xBridgeContext);

    List<AbsRouteOpenHandler> provideRouteOpenHandlerList(IBDXBridgeContext xBridgeContext);

    /* compiled from: IHostRouterDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class DefaultImpls {
        public static AbsRouteOpenHandler provideRouteOpenExceptionHandler(IHostRouterDepend iHostRouterDepend, IBDXBridgeContext iBDXBridgeContext) {
            return null;
        }

        public static List<AbsRouteOpenHandler> provideRouteOpenHandlerList(IHostRouterDepend iHostRouterDepend, IBDXBridgeContext iBDXBridgeContext) {
            return CollectionsKt.emptyList();
        }

        public static boolean openSchema(IHostRouterDepend iHostRouterDepend, IBDXBridgeContext iBDXBridgeContext, String str, Map<String, ? extends Object> map, Context context) {
            Activity ownerActivity;
            Intrinsics.checkNotNullParameter(str, "schema");
            Intrinsics.checkNotNullParameter(map, "extraParams");
            AbsRouteOpenHandler assembleHandlerChain = assembleHandlerChain(iHostRouterDepend, iBDXBridgeContext);
            boolean z = false;
            if (assembleHandlerChain == null) {
                return false;
            }
            while (!z && assembleHandlerChain != null) {
                if (iBDXBridgeContext != null) {
                    try {
                        ownerActivity = iBDXBridgeContext.getOwnerActivity();
                    } catch (Throwable unused) {
                        assembleHandlerChain = assembleHandlerChain.getExceptionHandler();
                    }
                } else {
                    ownerActivity = null;
                }
                z = assembleHandlerChain.openSchema(str, map, ownerActivity);
                if (z) {
                    break;
                }
                assembleHandlerChain = assembleHandlerChain.getNextHandler();
            }
            return z;
        }

        private static AbsRouteOpenHandler assembleHandlerChain(IHostRouterDepend iHostRouterDepend, IBDXBridgeContext iBDXBridgeContext) {
            List<AbsRouteOpenHandler> provideRouteOpenHandlerList = iHostRouterDepend.provideRouteOpenHandlerList(iBDXBridgeContext);
            AbsRouteOpenHandler provideRouteOpenExceptionHandler = iHostRouterDepend.provideRouteOpenExceptionHandler(iBDXBridgeContext);
            AbsRouteOpenHandler absRouteOpenHandler = null;
            AbsRouteOpenHandler absRouteOpenHandler2 = null;
            for (AbsRouteOpenHandler absRouteOpenHandler3 : provideRouteOpenHandlerList) {
                if (absRouteOpenHandler2 == null) {
                    absRouteOpenHandler = absRouteOpenHandler3;
                }
                if (absRouteOpenHandler2 != null) {
                    absRouteOpenHandler2.setNextHandler(absRouteOpenHandler3);
                }
                absRouteOpenHandler3.setExceptionHandler(provideRouteOpenExceptionHandler);
                absRouteOpenHandler2 = absRouteOpenHandler3;
            }
            return absRouteOpenHandler;
        }

        public static /* synthetic */ boolean closeView$default(IHostRouterDepend iHostRouterDepend, IBDXBridgeContext iBDXBridgeContext, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeView");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return iHostRouterDepend.closeView(iBDXBridgeContext, str, z);
        }
    }
}
