package com.bytedance.upc;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/upc/PopupImpl;", "Lcom/bytedance/upc/IPopup;", "showPopup", "", "permission", "", "popupTitle", "popupContent", "iUpcPopupGuideCallback", "Lcom/bytedance/upc/IUpcPopupGuideCallback;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public interface PopupImpl extends IPopup {
    @Override // com.bytedance.upc.IPopup
    void showPopup(String permission, String popupTitle, String popupContent, IUpcPopupGuideCallback iUpcPopupGuideCallback);

    /* compiled from: UpcImpl.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class DefaultImpls {
        public static void showPopup(PopupImpl popupImpl, String str, String str2, String str3, IUpcPopupGuideCallback iUpcPopupGuideCallback) {
            Intrinsics.checkParameterIsNotNull(str, "permission");
            Intrinsics.checkParameterIsNotNull(str2, "popupTitle");
            Intrinsics.checkParameterIsNotNull(str3, "popupContent");
            try {
                for (IUpcLifecycleService iUpcLifecycleService : ServiceManager.get().getServices(IUpcLifecycleService.class)) {
                    if (iUpcLifecycleService instanceof IUpcPopupService) {
                        ((IUpcPopupService) iUpcLifecycleService).showPopup(str, str2, str3, iUpcPopupGuideCallback);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
