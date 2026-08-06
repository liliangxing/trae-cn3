package com.bytedance.upc;

import java.util.Map;
import kotlin.Metadata;

/* compiled from: IUpcTeenModeConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/upc/IUpcTeenModeActivityConfiguration;", "", "teenDesc", "Lcom/bytedance/upc/IUpcTeenModeTextView;", "teenEdit", "Lcom/bytedance/upc/IUpcTeenModeEditText;", "teenModeBackground", "", "teenModeClickContent", "", "Lcom/bytedance/upc/IUpcTeenModeClickText;", "Lcom/bytedance/upc/IUpcTeenModeClickContentListener;", "teenModePasswordConfirm", "Lcom/bytedance/upc/IUpcTeenModeConfirmTextView;", "teenModeTheme", "teenPasswordDesc", "teenTitle", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcTeenModeActivityConfiguration {
    IUpcTeenModeTextView teenDesc();

    IUpcTeenModeEditText teenEdit();

    int teenModeBackground();

    Map<IUpcTeenModeClickText, IUpcTeenModeClickContentListener> teenModeClickContent();

    IUpcTeenModeConfirmTextView teenModePasswordConfirm();

    int teenModeTheme();

    IUpcTeenModeTextView teenPasswordDesc();

    IUpcTeenModeTextView teenTitle();
}
