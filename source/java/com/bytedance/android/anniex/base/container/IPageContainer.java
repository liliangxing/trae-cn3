package com.bytedance.android.anniex.base.container;

import android.content.Context;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPageContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\rJ\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH'¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/anniex/base/container/IPageContainer;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "Lcom/bytedance/android/anniex/base/container/IPopupAndPage;", "Lcom/bytedance/android/anniex/base/container/INavBarHost;", "Lcom/bytedance/android/anniex/base/container/IStatusBarHost;", "onPause", "", "setDelegate", "pageDelegate", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "setPageComponent", "pageComponent", "Lcom/bytedance/android/anniex/base/container/IPageContainer$PageComponent;", "PageComponent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IPageContainer extends IContainer, IPopupAndPage, INavBarHost, IStatusBarHost {

    /* compiled from: IPageContainer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/container/IPageContainer$PageComponent;", "Lcom/bytedance/android/anniex/base/container/UIComponent;", "()V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static abstract class PageComponent extends UIComponent {
    }

    @Override // com.bytedance.android.anniex.base.container.IPopupAndPage
    void onPause();

    void setDelegate(IAnnieXLitePageDelegate pageDelegate);

    void setPageComponent(PageComponent pageComponent);

    /* compiled from: IPageContainer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static void onPause(IPageContainer iPageContainer) {
        }

        public static void setDelegate(IPageContainer iPageContainer, IAnnieXLitePageDelegate iAnnieXLitePageDelegate) {
        }

        public static void finish(IPageContainer iPageContainer) {
            IContainer.DefaultImpls.finish(iPageContainer);
        }

        public static ISchemaData getCurrentSchema(IPageContainer iPageContainer) {
            return IContainer.DefaultImpls.getCurrentSchema(iPageContainer);
        }

        public static Context getSystemContext(IPageContainer iPageContainer) {
            return IContainer.DefaultImpls.getSystemContext(iPageContainer);
        }

        public static void loadSchema(IPageContainer iPageContainer, String str, Map<String, ? extends Object> map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle) {
            Intrinsics.checkNotNullParameter(str, StrategyConstants.SCHEMA);
            IContainer.DefaultImpls.loadSchema(iPageContainer, str, map, contextProviderFactory, absAnnieXLifecycle);
        }

        public static void onAttachToWindow(IPageContainer iPageContainer) {
            IContainer.DefaultImpls.onAttachToWindow(iPageContainer);
        }

        public static void onEngineReady(IPageContainer iPageContainer, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
            IContainer.DefaultImpls.onEngineReady(iPageContainer, contextProviderFactory);
        }
    }
}
