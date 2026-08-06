package com.bytedance.ies.xbridge.base.runtime.depend;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostRouterDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J0\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007H&J@\u0010\r\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostRouterDepend;", "", "assembleHandlerChain", "Lcom/bytedance/ies/xbridge/base/runtime/depend/AbsRouteOpenHandler;", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "closeView", "", "type", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "containerID", "", "animated", "openSchema", "schema", "extraParams", "", "platformType", "context", "Landroid/content/Context;", "provideRouteOpenExceptionHandler", "provideRouteOpenHandlerList", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IHostRouterDepend {
    boolean closeView(XContextProviderFactory contextProviderFactory, XBridgePlatformType type, String containerID, boolean animated);

    boolean openSchema(XContextProviderFactory contextProviderFactory, String schema, Map<String, ? extends Object> extraParams, XBridgePlatformType platformType, Context context);

    AbsRouteOpenHandler provideRouteOpenExceptionHandler(XContextProviderFactory contextProviderFactory);

    List<AbsRouteOpenHandler> provideRouteOpenHandlerList(XContextProviderFactory contextProviderFactory);

    /* compiled from: IHostRouterDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static AbsRouteOpenHandler provideRouteOpenExceptionHandler(IHostRouterDepend iHostRouterDepend, XContextProviderFactory xContextProviderFactory) {
            return null;
        }

        public static List<AbsRouteOpenHandler> provideRouteOpenHandlerList(IHostRouterDepend iHostRouterDepend, XContextProviderFactory xContextProviderFactory) {
            return CollectionsKt.emptyList();
        }

        public static boolean openSchema(IHostRouterDepend iHostRouterDepend, XContextProviderFactory xContextProviderFactory, String str, Map<String, ? extends Object> map, XBridgePlatformType xBridgePlatformType, Context context) {
            Context context2;
            Intrinsics.checkNotNullParameter(str, "schema");
            Intrinsics.checkNotNullParameter(map, "extraParams");
            Intrinsics.checkNotNullParameter(xBridgePlatformType, "platformType");
            AbsRouteOpenHandler assembleHandlerChain = assembleHandlerChain(iHostRouterDepend, xContextProviderFactory);
            boolean z = false;
            if (assembleHandlerChain == null) {
                return false;
            }
            while (!z && assembleHandlerChain != null) {
                if (assembleHandlerChain.getSupportPlatformTypeList().contains(XBridgePlatformType.ALL) || assembleHandlerChain.getSupportPlatformTypeList().contains(xBridgePlatformType)) {
                    if (xContextProviderFactory != null) {
                        try {
                            context2 = (Context) xContextProviderFactory.provideInstance(Context.class);
                        } catch (Throwable unused) {
                            assembleHandlerChain = assembleHandlerChain.getExceptionHandler();
                        }
                    } else {
                        context2 = null;
                    }
                    z = assembleHandlerChain.openSchema(str, map, context2);
                    if (z) {
                        break;
                    }
                    assembleHandlerChain = assembleHandlerChain.getNextHandler();
                } else {
                    assembleHandlerChain = assembleHandlerChain.getNextHandler();
                }
            }
            return z;
        }

        private static AbsRouteOpenHandler assembleHandlerChain(IHostRouterDepend iHostRouterDepend, XContextProviderFactory xContextProviderFactory) {
            List<AbsRouteOpenHandler> provideRouteOpenHandlerList = iHostRouterDepend.provideRouteOpenHandlerList(xContextProviderFactory);
            AbsRouteOpenHandler provideRouteOpenExceptionHandler = iHostRouterDepend.provideRouteOpenExceptionHandler(xContextProviderFactory);
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

        public static /* synthetic */ boolean closeView$default(IHostRouterDepend iHostRouterDepend, XContextProviderFactory xContextProviderFactory, XBridgePlatformType xBridgePlatformType, String str, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: closeView");
            }
            if ((i & 4) != 0) {
                str = null;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            return iHostRouterDepend.closeView(xContextProviderFactory, xBridgePlatformType, str, z);
        }
    }
}
