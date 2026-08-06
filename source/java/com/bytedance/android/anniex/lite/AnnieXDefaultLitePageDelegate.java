package com.bytedance.android.anniex.lite;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.base.container.IPopupContainer;
import com.bytedance.android.anniex.container.util.CustomViewUtil;
import com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate;
import com.bytedance.android.anniex.lite.model.AnnieXContext;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AnnieXDefaultLitePageDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXDefaultLitePageDelegate;", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLitePageDelegate;", "()V", "dialogFragment", "Landroidx/fragment/app/DialogFragment;", "fragment", "Landroidx/fragment/app/Fragment;", "pageContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "createComponent", "Lcom/bytedance/android/anniex/base/container/IPageContainer$PageComponent;", "rootView", "Landroid/view/View;", "iContainer", "createLiteComponent", "Lcom/bytedance/android/anniex/base/container/IPopupContainer$PopupComponent;", "onBackPress", "", "blockBackPress", "", "onCreate", "bundle", "Landroid/os/Bundle;", "onCreateView", "annieXContext", "Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "onRelease", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class AnnieXDefaultLitePageDelegate implements IAnnieXLitePageDelegate {
    private DialogFragment dialogFragment;
    private Fragment fragment;
    private IContainer pageContainer;

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public List<Object> getBusinessBehavior(Uri uri) {
        return IAnnieXLitePageDelegate.DefaultImpls.getBusinessBehavior(this, uri);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void onActivityResult(int i, int i2, Intent intent) {
        IAnnieXLitePageDelegate.DefaultImpls.onActivityResult(this, i, i2, intent);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void onInitBizContext(ContextProviderFactory contextProviderFactory) {
        IAnnieXLitePageDelegate.DefaultImpls.onInitBizContext(this, contextProviderFactory);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void onPageVisibleChange(boolean z) {
        IAnnieXLitePageDelegate.DefaultImpls.onPageVisibleChange(this, z);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void registerExtraJSB(ContextProviderFactory contextProviderFactory) {
        IAnnieXLitePageDelegate.DefaultImpls.registerExtraJSB(this, contextProviderFactory);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void onCreate(DialogFragment dialogFragment, Bundle bundle) {
        Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.dialogFragment = dialogFragment;
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void onCreate(Fragment fragment, Bundle bundle) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.fragment = fragment;
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void onCreateView(View rootView, IContainer iContainer, AnnieXContext annieXContext) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(iContainer, "iContainer");
        Intrinsics.checkNotNullParameter(annieXContext, "annieXContext");
        this.pageContainer = iContainer;
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public IPopupContainer.PopupComponent createLiteComponent(View rootView, IContainer iContainer) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(iContainer, "iContainer");
        return new IPopupContainer.PopupComponent() { // from class: com.bytedance.android.anniex.lite.AnnieXDefaultLitePageDelegate$createLiteComponent$1
            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public View createLoadingView() {
                IContainer iContainer2;
                iContainer2 = AnnieXDefaultLitePageDelegate.this.pageContainer;
                if (iContainer2 != null) {
                    return CustomViewUtil.INSTANCE.createLoadingView(iContainer2);
                }
                return null;
            }

            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public View createErrorView() {
                IContainer iContainer2;
                iContainer2 = AnnieXDefaultLitePageDelegate.this.pageContainer;
                if (iContainer2 != null) {
                    return CustomViewUtil.INSTANCE.createErrorView(iContainer2);
                }
                return null;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
            
                r0 = r1.dialogFragment;
             */
            @Override // com.bytedance.android.anniex.base.container.UIComponent
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void close() {
                DialogFragment dialogFragment;
                FragmentActivity activity;
                DialogFragment dialogFragment2;
                Dialog dialog;
                DialogFragment dialogFragment3;
                DialogFragment dialogFragment4;
                dialogFragment = AnnieXDefaultLitePageDelegate.this.dialogFragment;
                if (dialogFragment == null || (activity = dialogFragment.getActivity()) == null) {
                    return;
                }
                AnnieXDefaultLitePageDelegate annieXDefaultLitePageDelegate = AnnieXDefaultLitePageDelegate.this;
                if (activity.isDestroyed() || dialogFragment2 == null || (dialog = dialogFragment2.getDialog()) == null) {
                    return;
                }
                if (dialog.isShowing()) {
                    dialogFragment4 = annieXDefaultLitePageDelegate.dialogFragment;
                    if (dialogFragment4 != null) {
                        dialogFragment4.dismiss();
                        return;
                    }
                    return;
                }
                dialogFragment3 = annieXDefaultLitePageDelegate.dialogFragment;
                if (dialogFragment3 != null) {
                    dialogFragment3.dismissAllowingStateLoss();
                }
            }
        };
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public IPageContainer.PageComponent createComponent(View rootView, IContainer iContainer) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(iContainer, "iContainer");
        return new IPageContainer.PageComponent() { // from class: com.bytedance.android.anniex.lite.AnnieXDefaultLitePageDelegate$createComponent$1
            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public View createLoadingView() {
                IContainer iContainer2;
                iContainer2 = AnnieXDefaultLitePageDelegate.this.pageContainer;
                if (iContainer2 != null) {
                    return CustomViewUtil.INSTANCE.createLoadingView(iContainer2);
                }
                return null;
            }

            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public View createErrorView() {
                IContainer iContainer2;
                iContainer2 = AnnieXDefaultLitePageDelegate.this.pageContainer;
                if (iContainer2 != null) {
                    return CustomViewUtil.INSTANCE.createErrorView(iContainer2);
                }
                return null;
            }

            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public void close() {
                Fragment fragment;
                FragmentActivity activity;
                fragment = AnnieXDefaultLitePageDelegate.this.fragment;
                if (fragment == null || (activity = fragment.getActivity()) == null || activity.isDestroyed()) {
                    return;
                }
                activity.finish();
            }
        };
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void onBackPress(boolean blockBackPress) {
        final IContainer iContainer;
        if (!blockBackPress || (iContainer = this.pageContainer) == null) {
            return;
        }
        iContainer.sendEvent(new IEvent(iContainer) { // from class: com.bytedance.android.anniex.lite.AnnieXDefaultLitePageDelegate$onBackPress$1$1
            private final String name = "bulletOnBackPressAction";
            private final Object params;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("containerID", iContainer.getContainerId());
                this.params = jSONObject;
            }

            public String getName() {
                return this.name;
            }

            public Object getParams() {
                return this.params;
            }
        });
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLitePageDelegate
    public void onRelease() {
        this.pageContainer = null;
        this.dialogFragment = null;
        this.fragment = null;
    }
}
