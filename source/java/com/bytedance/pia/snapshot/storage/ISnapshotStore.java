package com.bytedance.pia.snapshot.storage;

import android.net.Uri;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ISnapshotStore.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0015J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&JJ\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0007H&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/pia/snapshot/storage/ISnapshotStore;", "", "query", "Lcom/bytedance/pia/snapshot/storage/SnapshotEntity;", "url", "Landroid/net/Uri;", "remove", "", "", "Lorg/json/JSONObject;", MonitorConstants.MONITOR_FROM_SDK, "", "removeExpires", "", "save", "content", "head", "expires", "", "version", "enforce", "SnapshotConflictException", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ISnapshotStore {
    SnapshotEntity query(Uri url);

    boolean remove(String url, JSONObject query, int sdk);

    void removeExpires();

    boolean save(String content, String head, long expires, JSONObject query, int sdk, String version, String url, boolean enforce);

    /* compiled from: ISnapshotStore.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/pia/snapshot/storage/ISnapshotStore$SnapshotConflictException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class SnapshotConflictException extends Exception {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SnapshotConflictException(String message) {
            super(message);
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }
}
