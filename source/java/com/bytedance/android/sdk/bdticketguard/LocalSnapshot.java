package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/LocalSnapshot;", "", "()V", "create_at", "", "getCreate_at", "()Ljava/lang/String;", "local_client_cert", "getLocal_client_cert", "local_public_key_ree", "getLocal_public_key_ree", "local_public_key_tee", "getLocal_public_key_tee", "timestamp", "", "getTimestamp", "()J", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LocalSnapshot {

    @SerializedName("create_at")
    private final String create_at;

    @SerializedName("local_client_cert")
    private final String local_client_cert;

    @SerializedName("local_public_key_ree")
    private final String local_public_key_ree;

    @SerializedName("local_public_key_tee")
    private final String local_public_key_tee;

    @SerializedName("timestamp")
    private final long timestamp;

    public LocalSnapshot() {
        String teePublic;
        String mask;
        String base64ReePub;
        String mask2;
        String clientCert;
        String mask3;
        TicketGuardManager manager = TicketGuardInnerFrameWork.INSTANCE.getManager();
        String str = "";
        this.local_client_cert = (manager == null || (clientCert = manager.getClientCert()) == null || (mask3 = SnapshotKt.mask(clientCert)) == null) ? "" : mask3;
        TicketGuardManager manager2 = TicketGuardInnerFrameWork.INSTANCE.getManager();
        this.local_public_key_ree = (manager2 == null || (base64ReePub = manager2.getBase64ReePub()) == null || (mask2 = SnapshotKt.mask(base64ReePub)) == null) ? "" : mask2;
        TicketGuardManager manager3 = TicketGuardInnerFrameWork.INSTANCE.getManager();
        if (manager3 != null && (teePublic = manager3.getTeePublic()) != null && (mask = SnapshotKt.mask(teePublic)) != null) {
            str = mask;
        }
        this.local_public_key_tee = str;
        long currentTimeMillis = System.currentTimeMillis();
        this.timestamp = currentTimeMillis;
        String format = SnapshotKt.getSdf().format(new Date(currentTimeMillis));
        Intrinsics.checkExpressionValueIsNotNull(format, "sdf.format(Date(timestamp))");
        this.create_at = format;
    }

    public final String getLocal_client_cert() {
        return this.local_client_cert;
    }

    public final String getLocal_public_key_ree() {
        return this.local_public_key_ree;
    }

    public final String getLocal_public_key_tee() {
        return this.local_public_key_tee;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getCreate_at() {
        return this.create_at;
    }
}
