package com.bytedance.android.anniex.base.container;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IViewContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/base/container/IViewContainer;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "onCreateView", "", "rootView", "Landroid/view/ViewGroup;", "setViewComponent", "viewComponent", "Lcom/bytedance/android/anniex/base/container/IViewContainer$ViewComponent;", "ViewComponent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IViewContainer extends IContainer {

    /* compiled from: IViewContainer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/container/IViewContainer$ViewComponent;", "Lcom/bytedance/android/anniex/base/container/UIComponent;", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static abstract class ViewComponent extends UIComponent {
    }

    void onCreateView(ViewGroup rootView);

    void setViewComponent(ViewComponent viewComponent);

    /* compiled from: IViewContainer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static void finish(IViewContainer iViewContainer) {
            IContainer.DefaultImpls.finish(iViewContainer);
        }

        public static ISchemaData getCurrentSchema(IViewContainer iViewContainer) {
            return IContainer.DefaultImpls.getCurrentSchema(iViewContainer);
        }

        public static Context getSystemContext(IViewContainer iViewContainer) {
            return IContainer.DefaultImpls.getSystemContext(iViewContainer);
        }

        public static void loadSchema(IViewContainer iViewContainer, String str, Map<String, ? extends Object> map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle) {
            Intrinsics.checkNotNullParameter(str, StrategyConstants.SCHEMA);
            IContainer.DefaultImpls.loadSchema(iViewContainer, str, map, contextProviderFactory, absAnnieXLifecycle);
        }

        public static void onAttachToWindow(IViewContainer iViewContainer) {
            IContainer.DefaultImpls.onAttachToWindow(iViewContainer);
        }

        public static void onEngineReady(IViewContainer iViewContainer, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
            IContainer.DefaultImpls.onEngineReady(iViewContainer, contextProviderFactory);
        }
    }
}
