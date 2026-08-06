package com.bytedance.upc.common.settings;

import com.bytedance.upc.common.storage.SpStorage;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: UpcLocalSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/upc/common/settings/UpcLocalSettings;", "", "()V", "STORAGE_TYPE", "", "UPC_SETTINGS_PRIVACY_LAST_SYNC_TIMESTAMP", "UPC_SETTINGS_PRIVACY_LAST__REQ_TIMESTAMP", "mSp", "Lcom/bytedance/upc/common/storage/SpStorage;", "getMSp", "()Lcom/bytedance/upc/common/storage/SpStorage;", "mSp$delegate", "Lkotlin/Lazy;", "getLastReqPrivacyTimeStamp", "", "getLastSyncPrivacyTimeStamp", "setLastReqPrivacyTimeStamp", "", "curReqTimeStamp", "setLastSyncPrivacyTimeStamp", "curSyncTimeStamp", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UpcLocalSettings {
    private static final String STORAGE_TYPE = "upc_sdk_settings";
    private static final String UPC_SETTINGS_PRIVACY_LAST_SYNC_TIMESTAMP = "upc_privacy_last_sync_timestamp";
    private static final String UPC_SETTINGS_PRIVACY_LAST__REQ_TIMESTAMP = "upc_privacy_last_req_timestamp";
    public static final UpcLocalSettings INSTANCE = new UpcLocalSettings();

    /* renamed from: mSp$delegate, reason: from kotlin metadata */
    private static final Lazy mSp = LazyKt.lazy(new Function0<SpStorage>() { // from class: com.bytedance.upc.common.settings.UpcLocalSettings$mSp$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SpStorage m2606invoke() {
            return SpStorage.INSTANCE;
        }
    });

    private final SpStorage getMSp() {
        return (SpStorage) mSp.getValue();
    }

    private UpcLocalSettings() {
    }

    public final long getLastReqPrivacyTimeStamp() {
        Long l = getMSp().getLong("upc_sdk_settings", UPC_SETTINGS_PRIVACY_LAST__REQ_TIMESTAMP, 0L);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final void setLastReqPrivacyTimeStamp(long curReqTimeStamp) {
        getMSp().setLong("upc_sdk_settings", UPC_SETTINGS_PRIVACY_LAST__REQ_TIMESTAMP, curReqTimeStamp);
    }

    public final long getLastSyncPrivacyTimeStamp() {
        Long l = getMSp().getLong("upc_sdk_settings", UPC_SETTINGS_PRIVACY_LAST_SYNC_TIMESTAMP, 0L);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final void setLastSyncPrivacyTimeStamp(long curSyncTimeStamp) {
        getMSp().setLong("upc_sdk_settings", UPC_SETTINGS_PRIVACY_LAST_SYNC_TIMESTAMP, curSyncTimeStamp);
    }
}
