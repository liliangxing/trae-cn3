package com.bytedance.upc;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: IUpcTeenModeConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0003H&J\b\u0010\u0011\u001a\u00020\u000bH&¨\u0006\u0012"}, d2 = {"Lcom/bytedance/upc/IUpcTeenModeDialogConfiguration;", "Lcom/bytedance/upc/IUpcDialog;", "teenModeBackground", "", "teenModeBrand", "Lcom/bytedance/upc/IUpcTeenModeDialogImageView;", "teenModeClickContent", "", "Lcom/bytedance/upc/IUpcTeenModeClickText;", "Lcom/bytedance/upc/IUpcTeenModeClickContentListener;", "teenModeDesc", "Lcom/bytedance/upc/IUpcTeenModeDialogTextView;", "teenModeGravity", "teenModeKnow", "teenModeOpenDesc", "teenModeOpenImage", "teenModeTheme", "teenModeTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcTeenModeDialogConfiguration extends IUpcDialog {
    int teenModeBackground();

    IUpcTeenModeDialogImageView teenModeBrand();

    Map<IUpcTeenModeClickText, IUpcTeenModeClickContentListener> teenModeClickContent();

    IUpcTeenModeDialogTextView teenModeDesc();

    int teenModeGravity();

    IUpcTeenModeDialogTextView teenModeKnow();

    IUpcTeenModeDialogTextView teenModeOpenDesc();

    IUpcTeenModeDialogImageView teenModeOpenImage();

    int teenModeTheme();

    IUpcTeenModeDialogTextView teenModeTitle();
}
