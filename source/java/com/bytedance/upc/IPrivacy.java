package com.bytedance.upc;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;

/* compiled from: IUpc.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u001c\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\nH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/IPrivacy;", "", "addPrivacyStatusChangeListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bytedance/upc/IPrivacyChangeListener;", "clearPrivacyStatus", "", "syncService", "getPrivacyStatus", "", "key", "default", "removePrivacyStatusChangeListener", "setPrivacyStatus", "value", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IPrivacy {
    void addPrivacyStatusChangeListener(IPrivacyChangeListener listener);

    boolean clearPrivacyStatus(boolean syncService);

    String getPrivacyStatus(String key, String r2);

    void removePrivacyStatusChangeListener(IPrivacyChangeListener listener);

    boolean setPrivacyStatus(String key, String value);
}
