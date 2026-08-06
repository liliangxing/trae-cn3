package com.bytedance.trae.update;

import kotlin.Metadata;

/* compiled from: IBitsUpdate.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/update/IBitsUpdate;", "", "checkUpdate", "", "autoCheck", "", "manualUpdateEnable", "isUpdating", "getUpdatePackageDir", "", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IBitsUpdate {
    void checkUpdate(boolean autoCheck);

    String getUpdatePackageDir();

    boolean isUpdating();

    boolean manualUpdateEnable();
}
