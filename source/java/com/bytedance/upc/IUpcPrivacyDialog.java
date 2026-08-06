package com.bytedance.upc;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IUpcPrivacyDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0007H&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/IUpcPrivacyDialog;", "Lcom/bytedance/upc/IUpcDialog;", "privacyClickContent", "", "Lcom/bytedance/upc/IUpcPrivacyDialogClickText;", "Lcom/bytedance/upc/IUpcPrivacyDialogClickContentListener;", "privacyDialogDesc", "Lcom/bytedance/upc/IUpcPrivacyDialogTextView;", "privacyDialogScrollHeight", "", "privacyDialogTheme", "privacyDialogTitle", "privacyLinearLayout", "Lcom/bytedance/upc/IUpcPrivacyDialogLinearLayout;", "privacyTextViewList", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcPrivacyDialog extends IUpcDialog {
    Map<IUpcPrivacyDialogClickText, IUpcPrivacyDialogClickContentListener> privacyClickContent();

    IUpcPrivacyDialogTextView privacyDialogDesc();

    int privacyDialogScrollHeight();

    int privacyDialogTheme();

    IUpcPrivacyDialogTextView privacyDialogTitle();

    IUpcPrivacyDialogLinearLayout privacyLinearLayout();

    List<IUpcPrivacyDialogTextView> privacyTextViewList();
}
