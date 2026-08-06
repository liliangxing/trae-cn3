package com.bytedance.upc;

import kotlin.Metadata;

/* compiled from: IClipBoardConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/bytedance/upc/IClipBoardConfiguration;", "", "getShowPopupInterval", "", "intercept", "", "isIgnoreSystemPermission", "tryShowDialog", "tryShowPopup", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IClipBoardConfiguration {

    /* compiled from: IClipBoardConfiguration.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static boolean isIgnoreSystemPermission(IClipBoardConfiguration iClipBoardConfiguration) {
            return false;
        }
    }

    long getShowPopupInterval();

    boolean intercept();

    boolean isIgnoreSystemPermission();

    boolean tryShowDialog();

    boolean tryShowPopup();
}
