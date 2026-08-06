package com.bytedance.ies.bullet.base.service;

import bolts.Task;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.sync.SyncBiz;
import com.bytedance.sync.SyncSDK;
import com.bytedance.sync.interfaze.ISyncClient;
import com.bytedance.sync.interfaze.OnDataUpdateListener;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: BulletByteSyncManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\nH\u0002J\u0006\u0010\u0007\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/base/service/BulletByteSyncManager;", "", "()V", "BUSINESS_ID", "", "SYNC_TYPE_UPDATE", "", "updateTimeStamp", "Ljava/lang/Long;", "dealWithUpdate", "", "data", "Lcom/bytedance/sync/interfaze/ISyncClient$Data;", "obj", "Lorg/json/JSONObject;", "doSyncSettings", "publishTimeStamp", "getDataUpdateListener", "Lcom/bytedance/sync/interfaze/OnDataUpdateListener;", "initByteSync", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletByteSyncManager {
    public static final long BUSINESS_ID = 39;
    public static final BulletByteSyncManager INSTANCE = new BulletByteSyncManager();
    private static final int SYNC_TYPE_UPDATE = 1;
    private static Long updateTimeStamp;

    private BulletByteSyncManager() {
    }

    public final synchronized void updateTimeStamp() {
        updateTimeStamp = Long.valueOf(System.currentTimeMillis());
    }

    static {
        Task.callInBackground(new Callable() { // from class: com.bytedance.ies.bullet.base.service.BulletByteSyncManager.1
            @Override // java.util.concurrent.Callable
            public /* bridge */ /* synthetic */ Object call() {
                call();
                return Unit.INSTANCE;
            }

            @Override // java.util.concurrent.Callable
            public final void call() {
                BulletByteSyncManager.INSTANCE.initByteSync();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initByteSync() {
        BulletLogger.onLog$default(BulletLogger.INSTANCE, "BulletByteSyncManager： initByteSync", null, 2, null);
        SyncSDK.registerBusiness(new SyncBiz.Builder(39L).addOnUpdateListener(getDataUpdateListener()).build());
    }

    private final OnDataUpdateListener getDataUpdateListener() {
        return new OnDataUpdateListener() { // from class: com.bytedance.ies.bullet.base.service.BulletByteSyncManager$getDataUpdateListener$1
            public final void onDataUpdate(ISyncClient.Data data) {
                byte[] bArr;
                String str = null;
                BulletLogger.onLog$default(BulletLogger.INSTANCE, "BulletByteSyncManager： receive message : " + (data != null ? data.data : null), null, 2, null);
                if (data != null && (bArr = data.data) != null) {
                    str = new String(bArr, Charsets.UTF_8);
                }
                BulletByteSyncManager.INSTANCE.dealWithUpdate(data, new JSONObject(str));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealWithUpdate(ISyncClient.Data data, JSONObject obj) {
        int optInt = obj.optInt("sync_type");
        BulletLogger.onLog$default(BulletLogger.INSTANCE, "BulletByteSyncManager： dealWithUpdate type : " + optInt, null, 2, null);
        if (optInt == 1) {
            doSyncSettings(data != null ? data.publishTimeStamp : System.currentTimeMillis());
        }
    }

    private final void doSyncSettings(long publishTimeStamp) {
        Long l = updateTimeStamp;
        if (l == null || publishTimeStamp <= l.longValue()) {
            return;
        }
        BulletLogger.onLog$default(BulletLogger.INSTANCE, "BulletByteSyncManager：checkUpdate", null, 2, null);
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        if (iBulletSettingsService != null) {
            iBulletSettingsService.checkUpdate();
        }
    }
}
