package com.bytedance.iesgurd.strategy;

import android.os.Environment;
import android.os.StatFs;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.model.Resources;
import com.bytedance.geckox.utils.ChannelState;
import com.bytedance.ies.bullet.preloadv2.PreloadV2Kt;
import com.bytedance.iesgurd.core.GeckoStore;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: StorageManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/iesgurd/strategy/StorageManager;", "", "()V", "extremeLowThreshold", "", "freeStorage", "lastTime", "", "checkNeedUpdate", "", IPiaCacheProvider.CacheConfig.FIELD_META, "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "getAvailableSize", "putStorageStatus", "", "jsonObject", "Lorg/json/JSONObject;", "updateFreeStorage", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StorageManager {
    public static final StorageManager INSTANCE = new StorageManager();
    private static final int extremeLowThreshold = 30;
    private static int freeStorage;
    private static long lastTime;

    private StorageManager() {
    }

    public final boolean checkNeedUpdate(PrepareMeta meta) {
        Intrinsics.checkParameterIsNotNull(meta, IPiaCacheProvider.CacheConfig.FIELD_META);
        updateFreeStorage();
        if (freeStorage < extremeLowThreshold) {
            return false;
        }
        if (meta.getIgnoreStorage()) {
            return true;
        }
        String accessKey = meta.getAccessKey();
        String channel = meta.getChannel();
        List<String> groups = meta.getGroups();
        boolean isChannelUsed = ChannelState.INSTANCE.isChannelUsed(accessKey, channel);
        if (meta.getUpdateWithPatch() && isChannelUsed) {
            return true;
        }
        Pair<Integer, Integer> storageAvailableValue = GeckoStore.INSTANCE.getStorageAvailableValue();
        int intValue = ((Number) storageAvailableValue.getFirst()).intValue();
        int intValue2 = ((Number) storageAvailableValue.getSecond()).intValue();
        if (intValue > 0 && freeStorage < intValue) {
            Resources lowStorageWhiteList = GeckoStore.INSTANCE.getLowStorageWhiteList(accessKey);
            return lowStorageWhiteList != null && lowStorageWhiteList.isHit$geckox_noasanRelease(groups, channel);
        }
        if (intValue2 <= 0 || freeStorage >= intValue2) {
            return true;
        }
        Resources sensitiveStorageBlockList = GeckoStore.INSTANCE.getSensitiveStorageBlockList(accessKey);
        return sensitiveStorageBlockList == null || !sensitiveStorageBlockList.isHit$geckox_noasanRelease(groups, channel);
    }

    public final void putStorageStatus(JSONObject jsonObject) {
        Intrinsics.checkParameterIsNotNull(jsonObject, "jsonObject");
        updateFreeStorage();
        Pair<Integer, Integer> storageAvailableValue = GeckoStore.INSTANCE.getStorageAvailableValue();
        int intValue = ((Number) storageAvailableValue.getFirst()).intValue();
        int intValue2 = ((Number) storageAvailableValue.getSecond()).intValue();
        if (intValue > 0) {
            jsonObject.put("low_storage_threshold", intValue);
        }
        if (intValue2 > 0) {
            jsonObject.put("sensitive_storage_threshold", intValue2);
        }
        int i = freeStorage;
        if (i < extremeLowThreshold) {
            jsonObject.put("storage_status", 1);
            return;
        }
        if (intValue > 0 && i < intValue) {
            jsonObject.put("storage_status", 2);
        } else {
            if (intValue2 <= 0 || i >= intValue2) {
                return;
            }
            jsonObject.put("storage_status", 3);
        }
    }

    private final void updateFreeStorage() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastTime > 15000) {
            freeStorage = (int) getAvailableSize();
            lastTime = currentTimeMillis;
        }
    }

    private final long getAvailableSize() {
        File dataDirectory = Environment.getDataDirectory();
        long j = -1;
        if (dataDirectory != null) {
            try {
                StatFs statFs = new StatFs(dataDirectory.getPath());
                j = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            } catch (IllegalArgumentException e) {
                GeckoLogger.w("getAvailableSize error: " + e);
            }
        }
        return j / PreloadV2Kt.M_MEM_SIZE;
    }
}
