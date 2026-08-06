package com.bytedance.android.anniex.utils;

import android.view.View;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p000.WebcastContainerInitializer;

/* compiled from: WebcastContainerInitializerInAnnieX.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/utils/WebcastContainerInitializerInAnnieX;", "", "()V", "initializeWithAnnieXLynxModelInLynx", "", "annieXLynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "view", "Landroid/view/View;", "lynxBDXBridge", "Lcom/bytedance/sdk/xbridge/cn/platform/lynx/LynxBDXBridge;", "providerFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WebcastContainerInitializerInAnnieX {
    public final void initializeWithAnnieXLynxModelInLynx(AnnieXLynxModel annieXLynxModel, final View view, LynxBDXBridge lynxBDXBridge, ContextProviderFactory providerFactory) {
        Intrinsics.checkNotNullParameter(annieXLynxModel, "annieXLynxModel");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(providerFactory, "providerFactory");
        new WebcastContainerInitializer().initializeCommon(null, view, lynxBDXBridge, providerFactory, annieXLynxModel.getSessionId(), annieXLynxModel.getOriginalUri(), new Function2<String, Object, Unit>() { // from class: com.bytedance.android.anniex.utils.WebcastContainerInitializerInAnnieX$initializeWithAnnieXLynxModelInLynx$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, Object obj) {
                Intrinsics.checkNotNullParameter(str, "eventName");
                try {
                    Object obj2 = view;
                    AnnieXLynxView annieXLynxView = obj2 instanceof AnnieXLynxView ? (AnnieXLynxView) obj2 : null;
                    if (annieXLynxView != null) {
                        AnnieXLynxView.sendEvent$default(annieXLynxView, str, obj, false, 4, null);
                    }
                } catch (Exception e) {
                    HybridLogger.e$default(HybridLogger.INSTANCE, "WebcastContainerInitializer", "Error converting params: " + e.getMessage() + " params: " + obj, (Map) null, (LoggerContext) null, 12, (Object) null);
                }
            }
        });
    }
}
