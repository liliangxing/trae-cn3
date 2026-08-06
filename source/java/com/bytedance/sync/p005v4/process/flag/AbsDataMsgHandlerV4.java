package com.bytedance.sync.p005v4.process.flag;

import android.content.Context;
import android.util.Log;
import com.bytedance.sync.SyncEventCompat;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.presistence.table.SyncCursor;
import com.bytedance.sync.p005v4.protocal.BsyncHeader;
import com.bytedance.sync.p005v4.protocal.BsyncPacket;
import com.bytedance.sync.p005v4.protocal.BsyncTopic;
import com.bytedance.sync.p005v4.protocal.Bucket;
import com.bytedance.sync.p005v4.protocal.TopicType;
import com.bytedance.sync.settings.SyncSettings;
import com.bytedance.sync.util.JSONUtils;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: AbsDataMsgHandlerV4.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH&J \u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0004J \u0010#\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eH&J&\u0010(\u001a\u00020$2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eJ0\u0010)\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u001eH\u0014J6\u0010)\u001a\u00020*2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006,"}, d2 = {"Lcom/bytedance/sync/v4/process/flag/AbsDataMsgHandlerV4;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dbService", "Lcom/bytedance/sync/v4/intf/IDBServiceV4;", "getDbService", "()Lcom/bytedance/sync/v4/intf/IDBServiceV4;", "dbService$delegate", "Lkotlin/Lazy;", "fileDataCache", "Lcom/bytedance/sync/interfaze/IFileDataCacheService;", "getFileDataCache", "()Lcom/bytedance/sync/interfaze/IFileDataCacheService;", "fileDataCache$delegate", "mSettings", "Lcom/bytedance/sync/interfaze/ISettings;", "getMSettings", "()Lcom/bytedance/sync/interfaze/ISettings;", "mSettings$delegate", "dealWithTopic", "", "method", "syncId", "", "header", "Lcom/bytedance/sync/v4/protocal/BsyncHeader;", "topics", "", "Lcom/bytedance/sync/v4/protocal/BsyncTopic;", "ensureSyncCursor", "", "syncCursor", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "monitorReceive", "", "packet", "Lcom/bytedance/sync/v4/protocal/BsyncPacket;", "topic", "onEventRecvData", "patchAndSave", "Lcom/bytedance/sync/v4/process/flag/AbsDataMsgHandlerV4$PatchResult;", "PatchResult", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class AbsDataMsgHandlerV4 {
    private final Context context;

    /* renamed from: dbService$delegate, reason: from kotlin metadata */
    private final Lazy dbService;

    /* renamed from: fileDataCache$delegate, reason: from kotlin metadata */
    private final Lazy fileDataCache;

    /* renamed from: mSettings$delegate, reason: from kotlin metadata */
    private final Lazy mSettings;

    /* compiled from: AbsDataMsgHandlerV4.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TopicType.values().length];
            iArr[TopicType.SpecTopic.ordinal()] = 1;
            iArr[TopicType.CustomTopic.ordinal()] = 2;
            iArr[TopicType.GlobalTopic.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract int dealWithTopic(int method, long syncId, BsyncHeader header, List<BsyncTopic> topics);

    public abstract void monitorReceive(long syncId, BsyncPacket packet, BsyncTopic topic);

    public AbsDataMsgHandlerV4(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.dbService = LazyKt.lazy(new Function0<IDBServiceV4>() { // from class: com.bytedance.sync.v4.process.flag.AbsDataMsgHandlerV4$dbService$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IDBServiceV4 m987invoke() {
                return (IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class);
            }
        });
        this.fileDataCache = LazyKt.lazy(new Function0<IFileDataCacheService>() { // from class: com.bytedance.sync.v4.process.flag.AbsDataMsgHandlerV4$fileDataCache$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IFileDataCacheService m988invoke() {
                return (IFileDataCacheService) UgBusFramework.getService(IFileDataCacheService.class);
            }
        });
        this.mSettings = LazyKt.lazy(new Function0<ISettings>() { // from class: com.bytedance.sync.v4.process.flag.AbsDataMsgHandlerV4$mSettings$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final ISettings m989invoke() {
                Context context2;
                context2 = AbsDataMsgHandlerV4.this.context;
                return SyncSettings.inst(context2).getSettings();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IDBServiceV4 getDbService() {
        Object value = this.dbService.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dbService>(...)");
        return (IDBServiceV4) value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IFileDataCacheService getFileDataCache() {
        Object value = this.fileDataCache.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-fileDataCache>(...)");
        return (IFileDataCacheService) value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ISettings getMSettings() {
        Object value = this.mSettings.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mSettings>(...)");
        return (ISettings) value;
    }

    protected PatchResult patchAndSave(int method, long syncId, SyncCursor syncCursor, BsyncHeader header, BsyncTopic topic) {
        Intrinsics.checkNotNullParameter(syncCursor, "syncCursor");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topic, "topic");
        return new PatchResult(false, null);
    }

    protected PatchResult patchAndSave(int method, long syncId, SyncCursor syncCursor, BsyncHeader header, List<BsyncTopic> topics) {
        Intrinsics.checkNotNullParameter(syncCursor, "syncCursor");
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(topics, "topics");
        return new PatchResult(false, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean ensureSyncCursor(long syncId, BsyncHeader header, SyncCursor syncCursor) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(syncCursor, "syncCursor");
        String str = syncCursor.syncId;
        Intrinsics.checkNotNullExpressionValue(str, "syncCursor.syncId");
        if (syncId != Long.parseLong(str)) {
            LogUtils.m186e("syncId not match. server = " + syncId + ", local db = " + syncCursor.syncId);
            return false;
        }
        if (!Intrinsics.areEqual(header.did, syncCursor.did)) {
            LogUtils.m186e("did not match. server = " + ((Object) header.did) + ", local db = " + ((Object) syncCursor.did));
            return false;
        }
        if (syncCursor.bucket != Bucket.User || Intrinsics.areEqual(header.uid, syncCursor.uid)) {
            return true;
        }
        LogUtils.m186e("uid not match. server = " + ((Object) header.uid) + ", local db = " + ((Object) syncCursor.uid));
        return false;
    }

    public final void onEventRecvData(int method, long syncId, BsyncPacket packet, BsyncTopic topic) {
        String str;
        List split$default;
        Intrinsics.checkNotNullParameter(packet, "packet");
        Intrinsics.checkNotNullParameter(topic, "topic");
        try {
            Map<String, String> map = packet.extra;
            if (map != null && Intrinsics.areEqual(map.get("hit_sampling"), "1")) {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                String str2 = map.get("msg_id");
                if (str2 == null) {
                    str2 = "";
                }
                JSONUtils.safePutParam(jSONObject, "msg_id", str2);
                JSONUtils.safePutParam(jSONObject, "biz_id", packet.payload.business.intValue());
                Long l = topic.sync_id;
                Intrinsics.checkNotNullExpressionValue(l, "topic.sync_id");
                JSONUtils.safePutParam(jSONObject, "sync_id", l.longValue());
                if (topic.topic_type == TopicType.CustomTopic) {
                    String str3 = topic.req_id;
                    String str4 = null;
                    if (str3 != null && (split$default = StringsKt.split$default(str3, new String[]{":"}, false, 0, 6, (Object) null)) != null) {
                        str4 = (String) CollectionsKt.last(split$default);
                    }
                    JSONUtils.safePutParam(jSONObject, "topic", str4);
                }
                Long l2 = packet.cursor.cursor;
                Intrinsics.checkNotNullExpressionValue(l2, "packet.cursor.cursor");
                JSONUtils.safePutParam(jSONObject, "cursor", l2.longValue());
                TopicType topicType = topic.topic_type;
                int i = topicType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[topicType.ordinal()];
                if (i == 1) {
                    str = "spec";
                } else if (i == 2) {
                    str = "custom";
                } else {
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    str = "global";
                }
                JSONUtils.safePutParam(jSONObject, "topic_type", str);
                JSONUtils.safePutParam(jSONObject, "step", "sdk_recv");
                JSONUtils.safePutParam(jSONObject, "ev_channel", method == 0 ? "frontier" : "http");
                JSONUtils.safePutParam(jSONObject, "start_ms", System.currentTimeMillis());
                Long l3 = packet.f238ts;
                Intrinsics.checkNotNullExpressionValue(l3, "packet.ts");
                JSONUtils.safePutParam(jSONObject, "cost_ms", currentTimeMillis - l3.longValue());
                JSONUtils.safePutParam(jSONObject, "result", "success");
                SyncEventCompat.onEvent("sync_sdk_event_recv", jSONObject);
            }
        } catch (Throwable th) {
            LogUtils.m186e(Intrinsics.stringPlus("eventReceive error: ", Log.getStackTraceString(th)));
        }
    }

    /* compiled from: AbsDataMsgHandlerV4.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sync/v4/process/flag/AbsDataMsgHandlerV4$PatchResult;", "", "success", "", "syncCursor", "Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "(ZLcom/bytedance/sync/v4/presistence/table/SyncCursor;)V", "getSuccess", "()Z", "getSyncCursor", "()Lcom/bytedance/sync/v4/presistence/table/SyncCursor;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class PatchResult {
        private final boolean success;
        private final SyncCursor syncCursor;

        public static /* synthetic */ PatchResult copy$default(PatchResult patchResult, boolean z, SyncCursor syncCursor, int i, Object obj) {
            if ((i & 1) != 0) {
                z = patchResult.success;
            }
            if ((i & 2) != 0) {
                syncCursor = patchResult.syncCursor;
            }
            return patchResult.copy(z, syncCursor);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* renamed from: component2, reason: from getter */
        public final SyncCursor getSyncCursor() {
            return this.syncCursor;
        }

        public final PatchResult copy(boolean success, SyncCursor syncCursor) {
            return new PatchResult(success, syncCursor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PatchResult)) {
                return false;
            }
            PatchResult patchResult = (PatchResult) other;
            return this.success == patchResult.success && Intrinsics.areEqual(this.syncCursor, patchResult.syncCursor);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z = this.success;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            int i = r0 * 31;
            SyncCursor syncCursor = this.syncCursor;
            return i + (syncCursor == null ? 0 : syncCursor.hashCode());
        }

        public String toString() {
            return "PatchResult(success=" + this.success + ", syncCursor=" + this.syncCursor + ')';
        }

        public PatchResult(boolean z, SyncCursor syncCursor) {
            this.success = z;
            this.syncCursor = syncCursor;
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final SyncCursor getSyncCursor() {
            return this.syncCursor;
        }
    }
}
