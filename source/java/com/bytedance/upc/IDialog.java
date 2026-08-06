package com.bytedance.upc;

import android.app.Activity;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IUpc.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J&\u0010\f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000eH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/IDialog;", "", "disMissDialog", "", "id", "", "showDialog", "", "activity", "Landroid/app/Activity;", "iUpcDialog", "Lcom/bytedance/upc/IUpcDialog;", "tryCheckPrivacy", "config", "", "Lcom/bytedance/upc/IUpcPrivacyDialog;", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IDialog {
    void disMissDialog(String id);

    boolean showDialog(String id, Activity activity, IUpcDialog iUpcDialog);

    void tryCheckPrivacy(Activity activity, Map<String, ? extends IUpcPrivacyDialog> config);
}
