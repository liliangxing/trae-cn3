package com.bytedance.upc;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: IPrivacyService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bH&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/upc/IPrivacyService;", "", "addPrivacyStatusChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/upc/IPrivacyChangeListener;", "getPrivacyStatus", "", "key", "default", "sync", "", "init", "removePrivacyStatusChangeListener", "setPrivacyStatus", "", "value", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IPrivacyService {
    void addPrivacyStatusChangeListener(IPrivacyChangeListener listener);

    String getPrivacyStatus(String key, String r2, int sync);

    void init();

    void removePrivacyStatusChangeListener(IPrivacyChangeListener listener);

    boolean setPrivacyStatus(String key, String value, int sync);

    /* compiled from: IPrivacyService.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ String getPrivacyStatus$default(IPrivacyService iPrivacyService, String str, String str2, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrivacyStatus");
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return iPrivacyService.getPrivacyStatus(str, str2, i);
        }

        public static /* synthetic */ boolean setPrivacyStatus$default(IPrivacyService iPrivacyService, String str, String str2, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setPrivacyStatus");
            }
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return iPrivacyService.setPrivacyStatus(str, str2, i);
        }
    }
}
