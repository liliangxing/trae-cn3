package com.bytedance.android.anniex.ability.service;

import com.bytedance.android.anniex.base.container.listener.AnnieXDialogListener;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import kotlin.Metadata;

/* compiled from: IAnnieXLifecycleConfigService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/ability/service/IAnnieXLifecycleConfigService;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "createDialogListener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXDialogListener;", "createFragmentListener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "createLifecycle", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnnieXLifecycleConfigService extends IAnnieXService {

    /* compiled from: IAnnieXLifecycleConfigService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static AnnieXDialogListener createDialogListener(IAnnieXLifecycleConfigService iAnnieXLifecycleConfigService) {
            return null;
        }

        public static AnnieXFragmentListener createFragmentListener(IAnnieXLifecycleConfigService iAnnieXLifecycleConfigService) {
            return null;
        }

        public static AbsAnnieXLifecycle createLifecycle(IAnnieXLifecycleConfigService iAnnieXLifecycleConfigService) {
            return null;
        }
    }

    AnnieXDialogListener createDialogListener();

    AnnieXFragmentListener createFragmentListener();

    AbsAnnieXLifecycle createLifecycle();
}
