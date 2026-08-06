package com.bytedance.upc;

import kotlin.Metadata;

/* compiled from: IUpcPrivacyDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/upc/IUpcPrivacyDialogTextView;", "", "background", "", "clickListener", "Lcom/bytedance/upc/IUpcTextViewClickListener;", "color", "", "fontType", "size", "text", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcPrivacyDialogTextView {
    int background();

    IUpcTextViewClickListener clickListener();

    String color();

    int fontType();

    int size();

    String text();
}
