package com.bytedance.sync.p005v4.process;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.sync.SDKMonitor;
import com.bytedance.sync.SyncMonitor;
import com.bytedance.sync.diff.DiffMatchPatch;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.model.DataType;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.IDataErrorServiceV4;
import com.bytedance.sync.p005v4.intf.IDataPatchService;
import com.bytedance.sync.p005v4.notify.MsgNotifierV4;
import com.bytedance.sync.p005v4.presistence.table.Snapshot;
import com.bytedance.sync.p005v4.presistence.table.SyncLogV4;
import com.bytedance.sync.p005v4.protocal.ConsumeType;
import com.bytedance.sync.p005v4.protocal.PacketStatus;
import com.bytedance.sync.p005v4.utils.UtilKtKt;
import com.bytedance.sync.settings.SyncSettings;
import com.bytedance.trae.im.model.MessagePart;
import com.ss.android.ug.bus.IUgBusService;
import com.ss.android.ug.bus.UgBusFramework;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: DataPatchServiceV4.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u000201B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 H\u0002J\u0016\u0010!\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016J$\u0010%\u001a\u0004\u0018\u00010\u00182\u0006\u0010&\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0016\u0010%\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0002J&\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\b2\u0006\u0010)\u001a\u00020$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001c0 H\u0002J(\u0010+\u001a\u00020\u001e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0-2\b\u0010.\u001a\u0004\u0018\u00010\u001a2\u0006\u0010/\u001a\u00020\u001aH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/sync/v4/process/DataPatchServiceV4;", "Lcom/bytedance/sync/v4/intf/IDataPatchService;", "context", "Landroid/content/Context;", "notifier", "Lcom/bytedance/sync/v4/notify/MsgNotifierV4;", "(Landroid/content/Context;Lcom/bytedance/sync/v4/notify/MsgNotifierV4;)V", "TAG", "", "dbService", "Lcom/bytedance/sync/v4/intf/IDBServiceV4;", "mFileCache", "Lcom/bytedance/sync/interfaze/IFileDataCacheService;", "kotlin.jvm.PlatformType", "getMFileCache", "()Lcom/bytedance/sync/interfaze/IFileDataCacheService;", "mFileCache$delegate", "Lkotlin/Lazy;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "doPatch", "Lcom/bytedance/sync/v4/process/DataPatchServiceV4$PatchResult;", "snapshots", "Lcom/bytedance/sync/v4/presistence/table/Snapshot;", MessagePart.TYPE_LOG, "Lcom/bytedance/sync/v4/presistence/table/SyncLogV4;", "handleOneByOne", "", "syncLogs", "", "notifyPatch", "syncIds", "", "", "patch", "syncId", "patchWithSyncIdAndBusinessId", "Lcom/bytedance/sync/v4/process/DataPatchServiceV4$SyncIdPatchResult;", "business", "syncLog", "tryDeleteFiles", "pendingDeleteLogs", "", "originalSnapshot", IFileDataCacheService.TYPE_SNAPSHOT, "PatchResult", "SyncIdPatchResult", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DataPatchServiceV4 implements IDataPatchService {
    private final String TAG;
    private final Context context;
    private IDBServiceV4 dbService;

    /* renamed from: mFileCache$delegate, reason: from kotlin metadata */
    private final Lazy mFileCache;

    /* renamed from: mHandler$delegate, reason: from kotlin metadata */
    private final Lazy mHandler;
    private final MsgNotifierV4 notifier;

    /* compiled from: DataPatchServiceV4.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataType.values().length];
            iArr[DataType.ORIGIN.ordinal()] = 1;
            iArr[DataType.FILE_PATH.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DataPatchServiceV4(Context context, MsgNotifierV4 msgNotifierV4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgNotifierV4, "notifier");
        this.context = context;
        this.notifier = msgNotifierV4;
        this.TAG = "[DataPatchServiceV4] ";
        this.mHandler = LazyKt.lazy(new Function0<Handler>() { // from class: com.bytedance.sync.v4.process.DataPatchServiceV4$mHandler$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Handler m979invoke() {
                return new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get());
            }
        });
        this.mFileCache = LazyKt.lazy(new Function0<IFileDataCacheService>() { // from class: com.bytedance.sync.v4.process.DataPatchServiceV4$mFileCache$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final IFileDataCacheService m978invoke() {
                return (IFileDataCacheService) UgBusFramework.getService(IFileDataCacheService.class);
            }
        });
    }

    private final Handler getMHandler() {
        return (Handler) this.mHandler.getValue();
    }

    private final IFileDataCacheService getMFileCache() {
        return (IFileDataCacheService) this.mFileCache.getValue();
    }

    @Override // com.bytedance.sync.p005v4.intf.IDataPatchService
    public void notifyPatch(final Set<Long> syncIds) {
        Intrinsics.checkNotNullParameter(syncIds, "syncIds");
        LogUtils.m187i(this.TAG + "notify patch " + syncIds);
        getMHandler().post(new Runnable() { // from class: com.bytedance.sync.v4.process.DataPatchServiceV4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DataPatchServiceV4.m977notifyPatch$lambda0(DataPatchServiceV4.this, syncIds);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: notifyPatch$lambda-0, reason: not valid java name */
    public static final void m977notifyPatch$lambda0(DataPatchServiceV4 dataPatchServiceV4, Set set) {
        Intrinsics.checkNotNullParameter(dataPatchServiceV4, "this$0");
        Intrinsics.checkNotNullParameter(set, "$syncIds");
        dataPatchServiceV4.patch(set);
    }

    private final void patch(Set<Long> syncIds) {
        IUgBusService service = UgBusFramework.getService(IDBServiceV4.class);
        Intrinsics.checkNotNullExpressionValue(service, "getService(IDBServiceV4::class.java)");
        this.dbService = (IDBServiceV4) service;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = true;
        int i = 0;
        while (true) {
            if (!z) {
                break;
            }
            try {
                IDBServiceV4 iDBServiceV4 = this.dbService;
                if (iDBServiceV4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dbService");
                    iDBServiceV4 = null;
                }
                List<SyncLogV4> querySyncLogs = iDBServiceV4.querySyncLogs(syncIds, PacketStatus.Full, 100, i, System.currentTimeMillis());
                if (querySyncLogs.isEmpty()) {
                    LogUtils.m187i(Intrinsics.stringPlus(this.TAG, " query sync log is empty, don't notify"));
                    break;
                }
                boolean z2 = querySyncLogs.size() >= 100;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : querySyncLogs) {
                    String str = ((SyncLogV4) obj).syncId;
                    Object obj2 = linkedHashMap.get(str);
                    if (obj2 == null) {
                        obj2 = (List) new ArrayList();
                        linkedHashMap.put(str, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    Iterable iterable = (Iterable) entry.getValue();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Object obj3 : iterable) {
                        Long valueOf = Long.valueOf(((SyncLogV4) obj3).business);
                        Object obj4 = linkedHashMap2.get(valueOf);
                        if (obj4 == null) {
                            obj4 = (List) new ArrayList();
                            linkedHashMap2.put(valueOf, obj4);
                        }
                        ((List) obj4).add(obj3);
                    }
                    Iterator it = linkedHashMap2.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            Object key = entry.getKey();
                            Intrinsics.checkNotNullExpressionValue(key, "syncIdToSyncLog.key");
                            SyncIdPatchResult patchWithSyncIdAndBusinessId = patchWithSyncIdAndBusinessId((String) key, ((Number) entry2.getKey()).longValue(), (List) entry2.getValue());
                            if (!patchWithSyncIdAndBusinessId.getSuccess()) {
                                LogUtils.m186e(this.TAG + "patch error, clear local data " + ((String) entry.getKey()));
                                IDataErrorServiceV4 iDataErrorServiceV4 = (IDataErrorServiceV4) UgBusFramework.getService(IDataErrorServiceV4.class);
                                Object key2 = entry.getKey();
                                Intrinsics.checkNotNullExpressionValue(key2, "syncIdToSyncLog.key");
                                if (iDataErrorServiceV4.clearLocalData((String) key2, true)) {
                                    Object key3 = entry.getKey();
                                    Intrinsics.checkNotNullExpressionValue(key3, "syncIdToSyncLog.key");
                                    linkedHashSet.add(key3);
                                } else {
                                    LogUtils.m186e(this.TAG + "delete local data error, syncId = " + ((String) entry.getKey()));
                                }
                            } else {
                                LogUtils.m187i(this.TAG + "patch success " + ((String) entry.getKey()));
                                i += ((List) entry2.getValue()).size() - patchWithSyncIdAndBusinessId.getDeleteCnt();
                            }
                        }
                    }
                }
                z = z2;
            } catch (Exception e) {
                SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when querySyncLogWithSyncId.");
                e.printStackTrace();
            }
        }
        if (linkedHashSet.isEmpty()) {
            return;
        }
        ((IDataErrorServiceV4) UgBusFramework.getService(IDataErrorServiceV4.class)).pollErrorSyncId(linkedHashSet);
    }

    private final SyncIdPatchResult patchWithSyncIdAndBusinessId(String syncId, long business, List<? extends SyncLogV4> syncLog) {
        long j;
        ArrayList arrayList;
        long j2;
        byte[] bytes;
        boolean z;
        SyncIdPatchResult syncIdPatchResult = new SyncIdPatchResult(false, 0, null, 7, null);
        if (syncLog.get(0).consumeType == ConsumeType.OneByOne) {
            handleOneByOne(syncLog);
            syncIdPatchResult.setSuccess(true);
            syncIdPatchResult.setDeleteCnt(0);
        } else {
            ArrayList arrayList2 = new ArrayList();
            try {
                IDBServiceV4 iDBServiceV4 = this.dbService;
                String str = "dbService";
                if (iDBServiceV4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dbService");
                    j = business;
                    iDBServiceV4 = null;
                } else {
                    j = business;
                }
                Snapshot querySnapshot = iDBServiceV4.querySnapshot(syncId, j);
                Snapshot snapshot = null;
                for (SyncLogV4 syncLogV4 : syncLog) {
                    PatchResult patch = patch(syncId, syncLogV4, snapshot == null ? querySnapshot : snapshot);
                    if (patch == null || !patch.getSuccess()) {
                        break;
                    }
                    syncIdPatchResult.setDeleteCnt(syncIdPatchResult.getDeleteCnt() + 1);
                    arrayList2.add(syncLogV4);
                    if (snapshot == null) {
                        try {
                            snapshot = new Snapshot();
                            if (querySnapshot == null) {
                                arrayList = arrayList2;
                                j2 = 0;
                            } else {
                                arrayList = arrayList2;
                                j2 = querySnapshot.notified;
                            }
                            snapshot.notified = j2;
                            snapshot.business = syncLogV4.business;
                            snapshot.did = syncLogV4.did;
                            snapshot.uid = syncLogV4.uid;
                            snapshot.syncId = syncLogV4.syncId;
                            snapshot.bucket = syncLogV4.bucket;
                            snapshot.consumeType = syncLogV4.consumeType;
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            patch.setSuccess(false);
                            patch.setErrMsg("unsupported encoding when update snapshot");
                        }
                    } else {
                        arrayList = arrayList2;
                    }
                    Snapshot snapshot2 = snapshot;
                    String data = patch.getData();
                    if (data == null) {
                        bytes = null;
                    } else {
                        bytes = data.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    }
                    snapshot2.data = bytes;
                    snapshot2.dataType = DataType.ORIGIN;
                    String str2 = str;
                    snapshot2.publishTs = syncLogV4.publishTs;
                    snapshot2.receiveTs = syncLogV4.receiveTs;
                    snapshot2.cursor = syncLogV4.syncCursor;
                    snapshot2.patchCnt++;
                    try {
                        if (snapshot2.data.length > SyncSettings.inst(this.context).getSettings().dbStoreSizeLimit()) {
                            String putData = getMFileCache().putData(IFileDataCacheService.TYPE_SNAPSHOT, Long.parseLong(syncId), snapshot2.cursor, snapshot2.data, ((SyncLogV4) CollectionsKt.last(syncLog)).md5);
                            Intrinsics.checkNotNullExpressionValue(putData, "mFileCache.putData(\n    …                        )");
                            byte[] bytes2 = putData.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes2, "(this as java.lang.String).getBytes(charset)");
                            snapshot2.data = bytes2;
                            snapshot2.dataType = DataType.FILE_PATH;
                            z = true;
                        } else {
                            snapshot2.dataType = DataType.ORIGIN;
                            z = false;
                        }
                        try {
                            IDBServiceV4 iDBServiceV42 = this.dbService;
                            if (iDBServiceV42 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(str2);
                                arrayList2 = arrayList;
                                iDBServiceV42 = null;
                            } else {
                                arrayList2 = arrayList;
                            }
                            try {
                                try {
                                    if (iDBServiceV42.updateSnapshotAndDeleteSyncLog(snapshot2, arrayList2)) {
                                        tryDeleteFiles(arrayList2, querySnapshot, snapshot2);
                                        MsgNotifierV4.notifySnapshots$default(this.notifier, syncLogV4, 0L, 2, null);
                                        try {
                                            syncIdPatchResult.setSuccess(true);
                                            JSONObject jSONObject = new JSONObject();
                                            jSONObject.put("save_file", z);
                                            SyncMonitor.monitor$default("sync_sdk_snapshot_save_file", jSONObject, null, UtilKtKt.toMonitorExtra(snapshot2), 4, null);
                                        } catch (UnsupportedEncodingException unused) {
                                            LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "patch failed, reason: UnsupportedEncodingException when save to file"));
                                            syncIdPatchResult.setErrMsg("UnsupportedEncodingException when save to file");
                                            syncIdPatchResult.setSuccess(false);
                                            snapshot = snapshot2;
                                            str = str2;
                                        }
                                    } else {
                                        syncIdPatchResult.setSuccess(false);
                                        syncIdPatchResult.setErrMsg("patch failed, reason: updateSnapshotAndDeleteSyncLog failed");
                                        LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "patch failed, reason: updateSnapshotAndDeleteSyncLog failed"));
                                    }
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    SDKMonitor.inst().ensureNotReachHere(e, "execute sql failed when updateSnapshotAndDeleteSyncLog.");
                                    syncIdPatchResult.setSuccess(false);
                                    syncIdPatchResult.setDeleteCnt(0);
                                    syncIdPatchResult.setErrMsg("execute sql failed when updateSnapshotAndDeleteSyncLog.");
                                    return syncIdPatchResult;
                                }
                            } catch (UnsupportedEncodingException unused2) {
                                LogUtils.m186e(Intrinsics.stringPlus(this.TAG, "patch failed, reason: UnsupportedEncodingException when save to file"));
                                syncIdPatchResult.setErrMsg("UnsupportedEncodingException when save to file");
                                syncIdPatchResult.setSuccess(false);
                                snapshot = snapshot2;
                                str = str2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            arrayList2 = arrayList;
                        }
                    } catch (UnsupportedEncodingException unused3) {
                        arrayList2 = arrayList;
                    }
                    snapshot = snapshot2;
                    str = str2;
                }
            } catch (Exception e4) {
                SDKMonitor.inst().ensureNotReachHere(e4, "execute sql failed when patchWithSyncIdAndBusinessId.");
                syncIdPatchResult.setSuccess(false);
                syncIdPatchResult.setDeleteCnt(0);
                return syncIdPatchResult;
            }
        }
        return syncIdPatchResult;
    }

    private final void tryDeleteFiles(List<SyncLogV4> pendingDeleteLogs, Snapshot originalSnapshot, Snapshot snapshot) {
        String str;
        for (SyncLogV4 syncLogV4 : pendingDeleteLogs) {
            if (syncLogV4.dataType == DataType.FILE_PATH) {
                try {
                    IFileDataCacheService mFileCache = getMFileCache();
                    byte[] bArr = syncLogV4.data;
                    Intrinsics.checkNotNullExpressionValue(bArr, "it.data");
                    mFileCache.deleteFile(new String(bArr, Charsets.UTF_8));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (originalSnapshot != null && originalSnapshot.dataType == DataType.FILE_PATH) {
            try {
                byte[] bArr2 = originalSnapshot.data;
                Intrinsics.checkNotNullExpressionValue(bArr2, "originalSnapshot.data");
                String str2 = new String(bArr2, Charsets.UTF_8);
                if (snapshot.dataType == DataType.FILE_PATH) {
                    byte[] bArr3 = snapshot.data;
                    Intrinsics.checkNotNullExpressionValue(bArr3, "snapshot.data");
                    str = new String(bArr3, Charsets.UTF_8);
                } else {
                    str = null;
                }
                if (!TextUtils.equals(str, str2)) {
                    getMFileCache().deleteFile(str2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        pendingDeleteLogs.clear();
    }

    private final PatchResult patch(String syncId, SyncLogV4 log, Snapshot snapshots) {
        String str = log.syncId;
        Intrinsics.checkNotNullExpressionValue(str, "log.syncId");
        if (Long.parseLong(str) <= 0 || log.business <= 0) {
            return null;
        }
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        PatchResult doPatch = doPatch(snapshots, log);
        doPatch.setTimeConsumed(SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis);
        if (doPatch.getSuccess()) {
            String encrypt = StringEncryptUtils.encrypt(doPatch.getData(), "MD5");
            if (!TextUtils.equals(log.md5, encrypt)) {
                doPatch.setErrMsg("different md5. local is {" + ((Object) encrypt) + "},server is {" + ((Object) log.md5) + "} when patch {" + log.syncCursor + "} and syncId = " + log.syncId);
                doPatch.setSuccess(false);
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", doPatch.getSuccess());
        jSONObject.put("reason", doPatch.getErrMsg());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("time_consuming", doPatch.getTimeConsumed());
        SyncMonitor.monitor("sync_sdk_patch", jSONObject, jSONObject2, UtilKtKt.toMonitorExtra(log));
        return doPatch;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0099 A[Catch: all -> 0x0197, TryCatch #0 {all -> 0x0197, blocks: (B:10:0x003e, B:17:0x0057, B:19:0x0099, B:25:0x00b4, B:32:0x00cb, B:34:0x010e, B:36:0x0120, B:38:0x0128, B:40:0x0139, B:42:0x013f, B:44:0x0142, B:46:0x0147, B:50:0x014e, B:52:0x0153, B:55:0x015a, B:66:0x016a, B:68:0x0177, B:69:0x017e, B:70:0x017f, B:71:0x0186, B:72:0x0187, B:74:0x00ec, B:75:0x00f1, B:76:0x00f2, B:78:0x00ff, B:79:0x00ba, B:81:0x00ae, B:82:0x0077, B:83:0x007c, B:84:0x007d, B:86:0x008a, B:87:0x0045), top: B:9:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010e A[Catch: all -> 0x0197, TryCatch #0 {all -> 0x0197, blocks: (B:10:0x003e, B:17:0x0057, B:19:0x0099, B:25:0x00b4, B:32:0x00cb, B:34:0x010e, B:36:0x0120, B:38:0x0128, B:40:0x0139, B:42:0x013f, B:44:0x0142, B:46:0x0147, B:50:0x014e, B:52:0x0153, B:55:0x015a, B:66:0x016a, B:68:0x0177, B:69:0x017e, B:70:0x017f, B:71:0x0186, B:72:0x0187, B:74:0x00ec, B:75:0x00f1, B:76:0x00f2, B:78:0x00ff, B:79:0x00ba, B:81:0x00ae, B:82:0x0077, B:83:0x007c, B:84:0x007d, B:86:0x008a, B:87:0x0045), top: B:9:0x003e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final PatchResult doPatch(Snapshot snapshots, SyncLogV4 log) {
        String str;
        String str2;
        String str3;
        Object obj;
        Object obj2;
        boolean z;
        String str4;
        if (snapshots != null && snapshots.cursor >= log.syncCursor) {
            return new PatchResult(false, null, "local snapshot's cursor " + snapshots.cursor + " is equals or bigger than payload cursor " + log.syncCursor, 0L, 10, null);
        }
        DiffMatchPatch diffMatchPatch = new DiffMatchPatch();
        try {
            DataType dataType = log.dataType;
            int i = dataType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[dataType.ordinal()];
            if (i == -1) {
                byte[] bArr = log.data;
                Intrinsics.checkNotNullExpressionValue(bArr, "log.data");
                str = new String(bArr, Charsets.UTF_8);
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    IFileDataCacheService mFileCache = getMFileCache();
                    String str5 = log.syncId;
                    Intrinsics.checkNotNullExpressionValue(str5, "log.syncId");
                    long parseLong = Long.parseLong(str5);
                    byte[] bArr2 = log.data;
                    Intrinsics.checkNotNullExpressionValue(bArr2, "log.data");
                    str2 = mFileCache.readData(parseLong, new String(bArr2, Charsets.UTF_8));
                    if (str2 != null) {
                        return new PatchResult(false, null, "read diff file from cache failed", 0L, 10, null);
                    }
                    if ((snapshots == null ? null : snapshots.data) != null) {
                        DataType dataType2 = snapshots.dataType;
                        int i2 = dataType2 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[dataType2.ordinal()];
                        if (i2 == -1) {
                            byte[] bArr3 = snapshots.data;
                            Intrinsics.checkNotNullExpressionValue(bArr3, "snapshots.data");
                            str4 = new String(bArr3, Charsets.UTF_8);
                        } else if (i2 == 1) {
                            byte[] bArr4 = snapshots.data;
                            Intrinsics.checkNotNullExpressionValue(bArr4, "snapshots.data");
                            str4 = new String(bArr4, Charsets.UTF_8);
                        } else if (i2 == 2) {
                            IFileDataCacheService mFileCache2 = getMFileCache();
                            String str6 = snapshots.syncId;
                            Intrinsics.checkNotNullExpressionValue(str6, "snapshots.syncId");
                            long parseLong2 = Long.parseLong(str6);
                            byte[] bArr5 = snapshots.data;
                            Intrinsics.checkNotNullExpressionValue(bArr5, "snapshots.data");
                            str3 = mFileCache2.readData(parseLong2, new String(bArr5, Charsets.UTF_8));
                            if (str3 == null) {
                                return new PatchResult(false, null, "read snapshot file from cache failed", 0L, 10, null);
                            }
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        str3 = str4;
                        if (str3 == null) {
                        }
                    } else {
                        str3 = "";
                    }
                    LinkedList<DiffMatchPatch.Patch> linkedList = (LinkedList) diffMatchPatch.patch_fromText(str2);
                    if (linkedList == null) {
                        return new PatchResult(false, null, "patches is empty", 0L, 10, null);
                    }
                    Object[] patch_apply = diffMatchPatch.patch_apply(linkedList, str3);
                    if (patch_apply != null && patch_apply.length == 2 && (obj = patch_apply[0]) != null && (obj2 = patch_apply[1]) != null) {
                        if (obj != null) {
                            String str7 = (String) obj;
                            if (obj2 != null) {
                                boolean[] zArr = (boolean[]) obj2;
                                int length = zArr.length;
                                int i3 = 0;
                                loop0: while (true) {
                                    z = true;
                                    while (i3 < length) {
                                        boolean z2 = zArr[i3];
                                        i3++;
                                        if (!z || !z2) {
                                            z = false;
                                        }
                                    }
                                }
                                return new PatchResult(z, str7, z ? "" : "patch_apply failed with dmp", 0L, 8, null);
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.BooleanArray");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    return new PatchResult(false, null, "apply patch error", 0L, 10, null);
                }
                byte[] bArr6 = log.data;
                Intrinsics.checkNotNullExpressionValue(bArr6, "log.data");
                str = new String(bArr6, Charsets.UTF_8);
            }
            str2 = str;
            if (str2 != null) {
            }
        } catch (Throwable th) {
            SDKMonitor.inst().ensureNotReachHere(th, "patch error");
            th.printStackTrace();
            return new PatchResult(false, null, Log.getStackTraceString(th), 0L, 10, null);
        }
    }

    private final void handleOneByOne(List<? extends SyncLogV4> syncLogs) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : syncLogs) {
            Long valueOf = Long.valueOf(((SyncLogV4) obj).business);
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            this.notifier.doNotifyOnce(((Number) entry.getKey()).longValue(), (List) entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DataPatchServiceV4.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sync/v4/process/DataPatchServiceV4$SyncIdPatchResult;", "", "success", "", "deleteCnt", "", "errMsg", "", "(ZILjava/lang/String;)V", "getDeleteCnt", "()I", "setDeleteCnt", "(I)V", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class SyncIdPatchResult {
        private int deleteCnt;
        private String errMsg;
        private boolean success;

        public SyncIdPatchResult() {
            this(false, 0, null, 7, null);
        }

        public static /* synthetic */ SyncIdPatchResult copy$default(SyncIdPatchResult syncIdPatchResult, boolean z, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = syncIdPatchResult.success;
            }
            if ((i2 & 2) != 0) {
                i = syncIdPatchResult.deleteCnt;
            }
            if ((i2 & 4) != 0) {
                str = syncIdPatchResult.errMsg;
            }
            return syncIdPatchResult.copy(z, i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        /* renamed from: component2, reason: from getter */
        public final int getDeleteCnt() {
            return this.deleteCnt;
        }

        /* renamed from: component3, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        public final SyncIdPatchResult copy(boolean success, int deleteCnt, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            return new SyncIdPatchResult(success, deleteCnt, errMsg);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SyncIdPatchResult)) {
                return false;
            }
            SyncIdPatchResult syncIdPatchResult = (SyncIdPatchResult) other;
            return this.success == syncIdPatchResult.success && this.deleteCnt == syncIdPatchResult.deleteCnt && Intrinsics.areEqual(this.errMsg, syncIdPatchResult.errMsg);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z = this.success;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return (((r0 * 31) + Integer.hashCode(this.deleteCnt)) * 31) + this.errMsg.hashCode();
        }

        public String toString() {
            return "SyncIdPatchResult(success=" + this.success + ", deleteCnt=" + this.deleteCnt + ", errMsg=" + this.errMsg + ')';
        }

        public SyncIdPatchResult(boolean z, int i, String str) {
            Intrinsics.checkNotNullParameter(str, "errMsg");
            this.success = z;
            this.deleteCnt = i;
            this.errMsg = str;
        }

        public /* synthetic */ SyncIdPatchResult(boolean z, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? "" : str);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final void setSuccess(boolean z) {
            this.success = z;
        }

        public final int getDeleteCnt() {
            return this.deleteCnt;
        }

        public final void setDeleteCnt(int i) {
            this.deleteCnt = i;
        }

        public final String getErrMsg() {
            return this.errMsg;
        }

        public final void setErrMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.errMsg = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DataPatchServiceV4.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sync/v4/process/DataPatchServiceV4$PatchResult;", "", "success", "", "data", "", "errMsg", "timeConsumed", "", "(ZLjava/lang/String;Ljava/lang/String;J)V", "getData", "()Ljava/lang/String;", "getErrMsg", "setErrMsg", "(Ljava/lang/String;)V", "getSuccess", "()Z", "setSuccess", "(Z)V", "getTimeConsumed", "()J", "setTimeConsumed", "(J)V", "toString", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class PatchResult {
        private final String data;
        private String errMsg;
        private boolean success;
        private long timeConsumed;

        public PatchResult(boolean z, String str, String str2, long j) {
            this.success = z;
            this.data = str;
            this.errMsg = str2;
            this.timeConsumed = j;
        }

        public /* synthetic */ PatchResult(boolean z, String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? 0L : j);
        }

        public final boolean getSuccess() {
            return this.success;
        }

        public final void setSuccess(boolean z) {
            this.success = z;
        }

        public final String getData() {
            return this.data;
        }

        public final String getErrMsg() {
            return this.errMsg;
        }

        public final void setErrMsg(String str) {
            this.errMsg = str;
        }

        public final long getTimeConsumed() {
            return this.timeConsumed;
        }

        public final void setTimeConsumed(long j) {
            this.timeConsumed = j;
        }

        public String toString() {
            return "PatchResult(success=" + this.success + ", data=~~~, errMsg=" + ((Object) this.errMsg) + ", timeConsumed=" + this.timeConsumed + ')';
        }
    }
}
