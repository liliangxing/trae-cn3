package com.bytedance.android.anniex.base.container;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IPopupContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001$J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH'J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H'J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0017H&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH'J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u0017H&J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0006H&J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u0017H&J\b\u0010#\u001a\u00020\tH&¨\u0006%"}, d2 = {"Lcom/bytedance/android/anniex/base/container/IPopupContainer;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "Lcom/bytedance/android/anniex/base/container/IPopupAndPage;", "Lcom/bytedance/android/anniex/base/container/INavBarHost;", "Lcom/bytedance/android/anniex/base/container/IStatusBarHost;", "getPopupInitHeight", "", "()Ljava/lang/Integer;", "hidePopupClose", "", "onAttach", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialogInterface", "Landroid/content/DialogInterface;", "onShow", "setEnableToFull", "enableToFull", "", "setEnableToHalf", "enableToHalf", "setPopupComponent", "popupComponent", "Lcom/bytedance/android/anniex/base/container/IPopupContainer$PopupComponent;", "setPullDownClose", "pullDownClose", "setPullDownHeight", "pullDownHeight", "setShowTopClose", "showTopClose", "showPopupClose", "PopupComponent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface IPopupContainer extends IContainer, IPopupAndPage, INavBarHost, IStatusBarHost {

    /* compiled from: IPopupContainer.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/anniex/base/container/IPopupContainer$PopupComponent;", "Lcom/bytedance/android/anniex/base/container/UIComponent;", "()V", "getBottomHeight", "", "map", "", "", "", "(Ljava/util/Map;)Ljava/lang/Integer;", "isFullScreen", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onSheetDialogCollapsed", "", "onSheetDialogExpanded", "onSheetStateChange", StrategyConstants.STATE, "onSlide", "slideOffset", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static abstract class PopupComponent extends UIComponent {
        public Integer getBottomHeight(Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return null;
        }

        public final boolean isFullScreen() {
            return false;
        }

        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return null;
        }

        public void onSheetDialogCollapsed() {
        }

        public void onSheetDialogExpanded() {
        }

        public void onSheetStateChange(int state) {
        }

        public void onSlide(float slideOffset) {
        }
    }

    Integer getPopupInitHeight();

    void hidePopupClose();

    void onAttach(DialogFragment dialogFragment);

    Dialog onCreateDialog(Bundle savedInstanceState);

    void onDismiss(DialogInterface dialogInterface);

    void onShow(DialogInterface dialogInterface);

    void setEnableToFull(boolean enableToFull);

    void setEnableToHalf(boolean enableToHalf);

    void setPopupComponent(PopupComponent popupComponent);

    void setPullDownClose(boolean pullDownClose);

    void setPullDownHeight(int pullDownHeight);

    void setShowTopClose(boolean showTopClose);

    void showPopupClose();

    /* compiled from: IPopupContainer.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class DefaultImpls {
        public static Integer getPopupInitHeight(IPopupContainer iPopupContainer) {
            return null;
        }

        public static void finish(IPopupContainer iPopupContainer) {
            IContainer.DefaultImpls.finish(iPopupContainer);
        }

        public static ISchemaData getCurrentSchema(IPopupContainer iPopupContainer) {
            return IContainer.DefaultImpls.getCurrentSchema(iPopupContainer);
        }

        public static Context getSystemContext(IPopupContainer iPopupContainer) {
            return IContainer.DefaultImpls.getSystemContext(iPopupContainer);
        }

        public static void loadSchema(IPopupContainer iPopupContainer, String str, Map<String, ? extends Object> map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle) {
            Intrinsics.checkNotNullParameter(str, StrategyConstants.SCHEMA);
            IContainer.DefaultImpls.loadSchema(iPopupContainer, str, map, contextProviderFactory, absAnnieXLifecycle);
        }

        public static void onAttachToWindow(IPopupContainer iPopupContainer) {
            IContainer.DefaultImpls.onAttachToWindow(iPopupContainer);
        }

        public static void onEngineReady(IPopupContainer iPopupContainer, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
            IContainer.DefaultImpls.onEngineReady(iPopupContainer, contextProviderFactory);
        }
    }
}
