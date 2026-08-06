package com.bytedance.upc.common.storage;

import com.bytedance.webx.addr.AddressParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpPrivacySettingsStorage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/upc/common/storage/SpPrivacySettingsStorage;", "", "()V", "LAST_REQ_SERVER_RESULT", "", "LAST_SYNC_SERVER_RESULT", "lastReqServerResult", "", "lastSyncServerResult", "setReqServerResult", "", "result", "setSyncServerResult", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class SpPrivacySettingsStorage {
    public static final SpPrivacySettingsStorage INSTANCE = new SpPrivacySettingsStorage();
    private static final String LAST_SYNC_SERVER_RESULT = LAST_SYNC_SERVER_RESULT;
    private static final String LAST_SYNC_SERVER_RESULT = LAST_SYNC_SERVER_RESULT;
    private static final String LAST_REQ_SERVER_RESULT = LAST_REQ_SERVER_RESULT;
    private static final String LAST_REQ_SERVER_RESULT = LAST_REQ_SERVER_RESULT;

    private SpPrivacySettingsStorage() {
    }

    public final boolean lastSyncServerResult() {
        return Intrinsics.areEqual(SpStorage.INSTANCE.getString(SpStorage.STORAGE_SETTINGS, LAST_SYNC_SERVER_RESULT, AddressParam.TYPE_DISAPPROVE), AddressParam.TYPE_DISAPPROVE);
    }

    public final void setSyncServerResult(boolean result) {
        SpStorage.INSTANCE.setString(SpStorage.STORAGE_SETTINGS, LAST_SYNC_SERVER_RESULT, result ? AddressParam.TYPE_DISAPPROVE : "1");
    }

    public final boolean lastReqServerResult() {
        return Intrinsics.areEqual(SpStorage.INSTANCE.getString(SpStorage.STORAGE_SETTINGS, LAST_REQ_SERVER_RESULT, AddressParam.TYPE_DISAPPROVE), AddressParam.TYPE_DISAPPROVE);
    }

    public final void setReqServerResult(boolean result) {
        SpStorage.INSTANCE.setString(SpStorage.STORAGE_SETTINGS, LAST_REQ_SERVER_RESULT, result ? AddressParam.TYPE_DISAPPROVE : "1");
    }
}
