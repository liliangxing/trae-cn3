package com.ss.android.update;

/* loaded from: classes7.dex */
public interface IUpdateMainDialog {
    public static final String SP_DIALOG_UPGRADE = "upgrade_dialog.prefs";
    public static final String SP_KEY_LAST_SHOW_TIMESTAMP = "last_show_timestamp";

    void isAutoUpdate(boolean z);

    boolean isShowMainDialog();

    void showMainDialog(boolean z);
}
