package com.bytedance.ies.bullet.service.base;

import android.view.View;
import com.bytedance.push.interfaze.IMessageCallbackService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: IView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\tH&J\b\u0010\n\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IErrorView;", "", "getView", "Landroid/view/View;", "doClose", "Lkotlin/Function0;", "", "Lcom/bytedance/ies/bullet/service/base/CloseMethod;", "doReLoad", "Lcom/bytedance/ies/bullet/service/base/ReloadMethod;", "hide", IMessageCallbackService.EVENT_TYPE_SHOW, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IErrorView {
    View getView(Function0<Unit> doClose, Function0<Unit> doReLoad);

    void hide();

    void show();

    /* compiled from: IView.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ View getView$default(IErrorView iErrorView, Function0 function0, Function0 function02, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getView");
            }
            if ((i & 1) != 0) {
                function0 = null;
            }
            if ((i & 2) != 0) {
                function02 = null;
            }
            return iErrorView.getView(function0, function02);
        }

        public static void show(IErrorView iErrorView) {
            getView$default(iErrorView, null, null, 3, null).setVisibility(0);
        }

        public static void hide(IErrorView iErrorView) {
            getView$default(iErrorView, null, null, 3, null).setVisibility(8);
        }
    }
}
