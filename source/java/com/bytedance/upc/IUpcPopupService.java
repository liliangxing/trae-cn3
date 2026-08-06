package com.bytedance.upc;

import com.bytedance.upc.IUpcLifecycleService;
import kotlin.Metadata;

/* compiled from: IUpcPopupService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/upc/IUpcPopupService;", "Lcom/bytedance/upc/IUpcLifecycleService;", "showPopup", "", "permission", "", "popupTitle", "popupContent", "guideCallback", "Lcom/bytedance/upc/IUpcPopupGuideCallback;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcPopupService extends IUpcLifecycleService {
    void showPopup(String permission, String popupTitle, String popupContent, IUpcPopupGuideCallback guideCallback);

    /* compiled from: IUpcPopupService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static int priority(IUpcPopupService iUpcPopupService) {
            return IUpcLifecycleService.DefaultImpls.priority(iUpcPopupService);
        }

        public static /* synthetic */ void showPopup$default(IUpcPopupService iUpcPopupService, String str, String str2, String str3, IUpcPopupGuideCallback iUpcPopupGuideCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showPopup");
            }
            if ((i & 8) != 0) {
                iUpcPopupGuideCallback = null;
            }
            iUpcPopupService.showPopup(str, str2, str3, iUpcPopupGuideCallback);
        }
    }
}
