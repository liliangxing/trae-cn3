package com.bytedance.ies.xbridge.base.runtime.depend;

import android.app.Activity;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.xbridge.base.runtime.model.XShowLoadingParams;
import com.bytedance.ies.xbridge.model.context.XContextProviderFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostStyleUIDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001f\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0016¢\u0006\u0002\u0010\u001e¨\u0006 "}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostStyleUIDepend;", "", "hideLoading", "", "contextProviderFactory", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "(Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;)Ljava/lang/Boolean;", "setPageNaviStyle", "", "activity", "Landroid/app/Activity;", SchemaConstants.QUERY_KEY_TITLE, "Lcom/bytedance/ies/xbridge/base/runtime/depend/PageTitleBar;", "showActionSheet", "actionSheetBuilder", "Lcom/bytedance/ies/xbridge/base/runtime/depend/ActionSheetBuilder;", "showActionSheetListener", "Lcom/bytedance/ies/xbridge/base/runtime/depend/ShowActionSheetListener;", "(Lcom/bytedance/ies/xbridge/base/runtime/depend/ActionSheetBuilder;Lcom/bytedance/ies/xbridge/base/runtime/depend/ShowActionSheetListener;)Ljava/lang/Boolean;", "showDialog", "dialogBuilder", "Lcom/bytedance/ies/xbridge/base/runtime/depend/DialogBuilder;", "(Lcom/bytedance/ies/xbridge/base/runtime/depend/DialogBuilder;)Ljava/lang/Boolean;", "showLoading", "showLoadingParams", "Lcom/bytedance/ies/xbridge/base/runtime/model/XShowLoadingParams;", "(Lcom/bytedance/ies/xbridge/base/runtime/model/XShowLoadingParams;Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;)Ljava/lang/Boolean;", "showToast", "toastBuilder", "Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;", "(Lcom/bytedance/ies/xbridge/base/runtime/depend/ToastBuilder;)Ljava/lang/Boolean;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IHostStyleUIDepend {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String TOAST_TYPE_ERROR = "error";
    public static final String TOAST_TYPE_SUCCESS = "success";
    public static final String TOAST_TYPE_WARN = "warn";

    /* compiled from: IHostStyleUIDepend.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static Boolean hideLoading(IHostStyleUIDepend iHostStyleUIDepend, XContextProviderFactory xContextProviderFactory) {
            return null;
        }

        public static void setPageNaviStyle(IHostStyleUIDepend iHostStyleUIDepend, XContextProviderFactory xContextProviderFactory, Activity activity, PageTitleBar pageTitleBar) {
        }

        public static Boolean showActionSheet(IHostStyleUIDepend iHostStyleUIDepend, ActionSheetBuilder actionSheetBuilder, ShowActionSheetListener showActionSheetListener) {
            Intrinsics.checkNotNullParameter(actionSheetBuilder, "actionSheetBuilder");
            Intrinsics.checkNotNullParameter(showActionSheetListener, "showActionSheetListener");
            return null;
        }

        public static Boolean showDialog(IHostStyleUIDepend iHostStyleUIDepend, DialogBuilder dialogBuilder) {
            Intrinsics.checkNotNullParameter(dialogBuilder, "dialogBuilder");
            return null;
        }

        public static Boolean showLoading(IHostStyleUIDepend iHostStyleUIDepend, XShowLoadingParams xShowLoadingParams, XContextProviderFactory xContextProviderFactory) {
            Intrinsics.checkNotNullParameter(xShowLoadingParams, "showLoadingParams");
            return null;
        }

        public static Boolean showLoading(IHostStyleUIDepend iHostStyleUIDepend, XContextProviderFactory xContextProviderFactory) {
            return null;
        }

        public static Boolean showToast(IHostStyleUIDepend iHostStyleUIDepend, ToastBuilder toastBuilder) {
            Intrinsics.checkNotNullParameter(toastBuilder, "toastBuilder");
            return null;
        }
    }

    Boolean hideLoading(XContextProviderFactory contextProviderFactory);

    void setPageNaviStyle(XContextProviderFactory contextProviderFactory, Activity activity, PageTitleBar title);

    Boolean showActionSheet(ActionSheetBuilder actionSheetBuilder, ShowActionSheetListener showActionSheetListener);

    Boolean showDialog(DialogBuilder dialogBuilder);

    Boolean showLoading(XShowLoadingParams showLoadingParams, XContextProviderFactory contextProviderFactory);

    Boolean showLoading(XContextProviderFactory contextProviderFactory);

    Boolean showToast(ToastBuilder toastBuilder);

    /* compiled from: IHostStyleUIDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostStyleUIDepend$Companion;", "", "()V", "TOAST_TYPE_ERROR", "", "TOAST_TYPE_SUCCESS", "TOAST_TYPE_WARN", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String TOAST_TYPE_ERROR = "error";
        public static final String TOAST_TYPE_SUCCESS = "success";
        public static final String TOAST_TYPE_WARN = "warn";

        private Companion() {
        }
    }
}
