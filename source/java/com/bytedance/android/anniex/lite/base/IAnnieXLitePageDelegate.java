package com.bytedance.android.anniex.lite.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.base.container.IPopupContainer;
import com.bytedance.android.anniex.lite.model.AnnieXContext;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.lynx.animax.monitor.AnimaXMonitorUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IAnnieXLitePageDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cH&J \u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0017H\u0016J\b\u0010'\u001a\u00020\u000fH&J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016¨\u0006)"}, d2 = {"Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "", "createComponent", "Lcom/bytedance/android/anniex/base/container/IPageContainer$PageComponent;", "rootView", "Landroid/view/View;", "iContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "createLiteComponent", "Lcom/bytedance/android/anniex/base/container/IPopupContainer$PopupComponent;", "getBusinessBehavior", "", "schema", "Landroid/net/Uri;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "blockBackPress", "", "onCreate", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "bundle", "Landroid/os/Bundle;", "fragment", "Landroidx/fragment/app/Fragment;", "onCreateView", "annieXContext", "Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "onInitBizContext", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "onPageVisibleChange", "isVisible", AnimaXMonitorUtil.TRIGGER_ON_RELEASE, "registerExtraJSB", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXLitePageDelegate {

    /* compiled from: IAnnieXLitePageDelegate.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static List<Object> getBusinessBehavior(IAnnieXLitePageDelegate iAnnieXLitePageDelegate, Uri schema) {
            Intrinsics.checkNotNullParameter(schema, "schema");
            return null;
        }

        public static void onActivityResult(IAnnieXLitePageDelegate iAnnieXLitePageDelegate, int i, int i2, Intent intent) {
        }

        public static void onBackPress(IAnnieXLitePageDelegate iAnnieXLitePageDelegate, boolean z) {
        }

        public static void onInitBizContext(IAnnieXLitePageDelegate iAnnieXLitePageDelegate, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        }

        public static void onPageVisibleChange(IAnnieXLitePageDelegate iAnnieXLitePageDelegate, boolean z) {
        }

        public static void registerExtraJSB(IAnnieXLitePageDelegate iAnnieXLitePageDelegate, ContextProviderFactory contextProviderFactory) {
            Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        }
    }

    IPageContainer.PageComponent createComponent(View rootView, IContainer iContainer);

    IPopupContainer.PopupComponent createLiteComponent(View rootView, IContainer iContainer);

    List<Object> getBusinessBehavior(Uri schema);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onBackPress(boolean blockBackPress);

    void onCreate(DialogFragment dialogFragment, Bundle bundle);

    void onCreate(Fragment fragment, Bundle bundle);

    void onCreateView(View rootView, IContainer iContainer, AnnieXContext annieXContext);

    void onInitBizContext(ContextProviderFactory contextProviderFactory);

    void onPageVisibleChange(boolean isVisible);

    void onRelease();

    void registerExtraJSB(ContextProviderFactory contextProviderFactory);
}
