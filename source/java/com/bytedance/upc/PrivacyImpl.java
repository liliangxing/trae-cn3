package com.bytedance.upc;

import com.bytedance.trae.keva.KevaRepos;
import com.bytedance.upc.IPrivacyService;
import com.bytedance.upc.common.ICommonBusinessService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcImpl.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/PrivacyImpl;", "Lcom/bytedance/upc/IPrivacy;", "addPrivacyStatusChangeListener", "", "listener", "Lcom/bytedance/upc/IPrivacyChangeListener;", "clearPrivacyStatus", "", "syncService", "getPrivacyStatus", "", "key", KevaRepos.REPO_DEFAULT, "removePrivacyStatusChangeListener", "setPrivacyStatus", "value", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public interface PrivacyImpl extends IPrivacy {
    @Override // com.bytedance.upc.IPrivacy
    void addPrivacyStatusChangeListener(IPrivacyChangeListener listener);

    @Override // com.bytedance.upc.IPrivacy
    boolean clearPrivacyStatus(boolean syncService);

    @Override // com.bytedance.upc.IPrivacy
    String getPrivacyStatus(String key, String r2);

    @Override // com.bytedance.upc.IPrivacy
    void removePrivacyStatusChangeListener(IPrivacyChangeListener listener);

    @Override // com.bytedance.upc.IPrivacy
    boolean setPrivacyStatus(String key, String value);

    /* compiled from: UpcImpl.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class DefaultImpls {
        public static boolean clearPrivacyStatus(PrivacyImpl privacyImpl, boolean z) {
            return true;
        }

        public static String getPrivacyStatus(PrivacyImpl privacyImpl, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            IPrivacyService iPrivacyService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIPrivacyService;
            if (iPrivacyService != null) {
                return IPrivacyService.DefaultImpls.getPrivacyStatus$default(iPrivacyService, str, str2, 0, 4, null);
            }
            return null;
        }

        public static boolean setPrivacyStatus(PrivacyImpl privacyImpl, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(str, "key");
            IPrivacyService iPrivacyService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIPrivacyService;
            if (iPrivacyService != null) {
                return IPrivacyService.DefaultImpls.setPrivacyStatus$default(iPrivacyService, str, str2, 0, 4, null);
            }
            return false;
        }

        public static void addPrivacyStatusChangeListener(PrivacyImpl privacyImpl, IPrivacyChangeListener iPrivacyChangeListener) {
            Intrinsics.checkParameterIsNotNull(iPrivacyChangeListener, "listener");
            IPrivacyService iPrivacyService = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration().mIPrivacyService;
            if (iPrivacyService != null) {
                iPrivacyService.addPrivacyStatusChangeListener(iPrivacyChangeListener);
            }
        }

        public static void removePrivacyStatusChangeListener(PrivacyImpl privacyImpl, IPrivacyChangeListener iPrivacyChangeListener) {
            IPrivacyService iPrivacyService;
            Intrinsics.checkParameterIsNotNull(iPrivacyChangeListener, "listener");
            Configuration configuration = ((ICommonBusinessService) ServiceManager.get().getService(ICommonBusinessService.class)).getConfiguration();
            if (configuration == null || (iPrivacyService = configuration.mIPrivacyService) == null) {
                return;
            }
            iPrivacyService.removePrivacyStatusChangeListener(iPrivacyChangeListener);
        }
    }
}
