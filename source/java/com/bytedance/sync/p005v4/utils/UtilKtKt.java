package com.bytedance.sync.p005v4.utils;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: UtilKt.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000f\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0010"}, d2 = {"CALLBACK_EXECUTORS", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getCALLBACK_EXECUTORS", "()Ljava/util/concurrent/ExecutorService;", "CALLBACK_EXECUTORS$delegate", "Lkotlin/Lazy;", "callbackExecutors", "gzip", "", ReportConstant.COMMON_CONTENT, "ungzip", "toMonitorExtra", "Lorg/json/JSONObject;", "Lcom/bytedance/sync/v4/presistence/table/Snapshot;", "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "sync-sdk_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UtilKtKt {
    private static final Lazy CALLBACK_EXECUTORS$delegate = LazyKt.lazy(new Function0<ExecutorService>() { // from class: com.bytedance.sync.v4.utils.UtilKtKt$CALLBACK_EXECUTORS$2
        public final ExecutorService invoke() {
            return Executors.newSingleThreadExecutor();
        }
    });

    private static final byte[] gzip(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(gZIPOutputStream, (Throwable) null);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "bos.toByteArray()");
            return byteArray;
        } finally {
        }
    }

    public static final byte[] ungzip(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        try {
            byte[] readBytes = ByteStreamsKt.readBytes(gZIPInputStream);
            CloseableKt.closeFinally(gZIPInputStream, (Throwable) null);
            return readBytes;
        } finally {
        }
    }

    public static final JSONObject toMonitorExtra(SyncLogV4 syncLogV4) {
        Intrinsics.checkNotNullParameter(syncLogV4, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sync_id", syncLogV4.syncId);
        jSONObject.put("cursor", syncLogV4.syncCursor);
        jSONObject.put("business", syncLogV4.business);
        return jSONObject;
    }

    public static final JSONObject toMonitorExtra(Snapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sync_id", snapshot.syncId);
        jSONObject.put("cursor", snapshot.cursor);
        jSONObject.put("business", snapshot.business);
        return jSONObject;
    }

    private static final ExecutorService getCALLBACK_EXECUTORS() {
        return (ExecutorService) CALLBACK_EXECUTORS$delegate.getValue();
    }

    public static final ExecutorService callbackExecutors() {
        ExecutorService callback_executors = getCALLBACK_EXECUTORS();
        Intrinsics.checkNotNullExpressionValue(callback_executors, "CALLBACK_EXECUTORS");
        return callback_executors;
    }
}
