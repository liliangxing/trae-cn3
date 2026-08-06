package com.bytedance.upc;

import android.app.Activity;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/DialogImpl;", "Lcom/bytedance/upc/IDialog;", "disMissDialog", "", "id", "", "showDialog", "", "activity", "Landroid/app/Activity;", "iUpcDialog", "Lcom/bytedance/upc/IUpcDialog;", "tryCheckPrivacy", "config", "", "Lcom/bytedance/upc/IUpcPrivacyDialog;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public interface DialogImpl extends IDialog {
    @Override // com.bytedance.upc.IDialog
    void disMissDialog(String id);

    @Override // com.bytedance.upc.IDialog
    boolean showDialog(String id, Activity activity, IUpcDialog iUpcDialog);

    @Override // com.bytedance.upc.IDialog
    void tryCheckPrivacy(Activity activity, Map<String, ? extends IUpcPrivacyDialog> config);

    /* compiled from: UpcImpl.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class DefaultImpls {
        public static void disMissDialog(DialogImpl dialogImpl, String str) {
            Intrinsics.checkParameterIsNotNull(str, "id");
            IUpcDialogService iUpcDialogService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIUpcPrivacyDialogService;
            if (iUpcDialogService != null) {
                iUpcDialogService.disMissDialog(str);
            }
        }

        public static boolean showDialog(DialogImpl dialogImpl, String str, Activity activity, IUpcDialog iUpcDialog) {
            Intrinsics.checkParameterIsNotNull(str, "id");
            Intrinsics.checkParameterIsNotNull(iUpcDialog, "iUpcDialog");
            IUpcDialogService iUpcDialogService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIUpcPrivacyDialogService;
            if (iUpcDialogService != null) {
                return iUpcDialogService.showDialog(str, activity, iUpcDialog);
            }
            return false;
        }

        public static void tryCheckPrivacy(DialogImpl dialogImpl, Activity activity, Map<String, ? extends IUpcPrivacyDialog> map) {
            Intrinsics.checkParameterIsNotNull(map, "config");
            IUpcDialogService iUpcDialogService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIUpcPrivacyDialogService;
            if (iUpcDialogService != null) {
                iUpcDialogService.tryCheckPrivacy(activity, map);
            }
        }
    }
}
