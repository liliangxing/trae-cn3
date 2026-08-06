package com.bytedance.android.live.core.setting.p027v2.update;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.cache.CacheManger;
import com.bytedance.android.live.core.setting.p027v2.p028vo.CacheSettingVo;
import com.bytedance.android.live.core.setting.p027v2.storage.SettingConfigConstant;
import com.bytedance.android.live.core.setting.p027v2.strategy.CacheUpdateStrategy;
import com.bytedance.android.live.core.setting.p027v2.strategy.ColdUpdateStrategy;
import com.bytedance.android.live.core.setting.p027v2.strategy.ContextStrategy;
import com.bytedance.android.live.core.setting.p027v2.strategy.PushUpdateStrategy;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingReportMonitor;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import com.bytedance.android.live.core.setting.p027v2.update.IIncSettingV2;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingIncStrategy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy;", "Lcom/bytedance/android/live/core/setting/v2/update/IIncSettingV2;", "()V", "mCacheManger", "Lcom/bytedance/android/live/core/setting/v2/cache/CacheManger;", "getMCacheManger", "()Lcom/bytedance/android/live/core/setting/v2/cache/CacheManger;", "mIsIncUpdate", "", "mUpdateListenerList", "", "Lcom/bytedance/android/live/core/setting/v2/update/IIncSettingV2$ISettingUpdateListener;", "addUpdateListener", "", "updateListener", "cacheUpdate", "scene", "Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy$IncScene;", "key", "", StrategyConstants.VALUE, "", "incUpdate", "settings", "Lcom/google/gson/JsonObject;", StrategyConstants.EXTRA, "incUpdateV2", "isIncUpdate", "notifyUpdate", "removeUpdateListener", "IncScene", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SettingIncStrategy implements IIncSettingV2 {
    private static volatile boolean mIsIncUpdate;
    public static final SettingIncStrategy INSTANCE = new SettingIncStrategy();
    private static final CacheManger mCacheManger = new CacheManger();
    private static final List<IIncSettingV2.ISettingUpdateListener> mUpdateListenerList = new ArrayList();

    /* compiled from: SettingIncStrategy.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/update/SettingIncStrategy$IncScene;", "", "(Ljava/lang/String;I)V", "COLD_LAUNCH", "FRONTIER", "STICK", "OBJECT", "live-setting_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public enum IncScene {
        COLD_LAUNCH,
        FRONTIER,
        STICK,
        OBJECT
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IncScene.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[IncScene.COLD_LAUNCH.ordinal()] = 1;
            iArr[IncScene.FRONTIER.ordinal()] = 2;
        }
    }

    private SettingIncStrategy() {
    }

    public final CacheManger getMCacheManger() {
        return mCacheManger;
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.update.IIncSettingV2
    public boolean incUpdate(IncScene scene, JsonObject settings, JsonObject extra) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(scene, "scene");
        try {
            SettingReportMonitor.printLog(SettingReportMonitor.TAG_MAIN, "///...............................开始更新数据, scene = " + scene.name() + ": ......................///");
            SettingReportMonitor.INSTANCE.startCostTimeMonitor("incUpdate");
            boolean incUpdateV2 = incUpdateV2(scene, settings, extra);
            mIsIncUpdate = true;
            CacheManger cacheManger = mCacheManger;
            cacheManger.updateCacheAllMap(cacheManger.getCacheMap());
            notifyUpdate(scene);
            SettingReportMonitor.INSTANCE.finishTimeMonitor("incUpdate");
            SettingReportMonitor.printLog(SettingReportMonitor.TAG_MAIN, "///...............................更新数据结束, 结果为: " + incUpdateV2 + ".............................................///");
            return incUpdateV2;
        } catch (Exception e) {
            SettingReportMonitor.INSTANCE.printELog(e);
            SettingV2Monitor.localUpdateResult(1, Intrinsics.areEqual((extra == null || (jsonElement = extra.get(SettingConfigConstant.SETTING_V2_SETTING_UPDATE_MODE)) == null) ? null : jsonElement.getAsString(), "full") ? "full" : "incr", scene == IncScene.COLD_LAUNCH ? SettingConfigConstant.SETTING_V2_SETTING_COLD : SettingConfigConstant.SETTING_V2_SETTING_FRONTIER, null, -1, -1, e.getMessage());
            return false;
        }
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.update.IIncSettingV2
    public boolean cacheUpdate(IncScene scene, String key, Object value) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, StrategyConstants.VALUE);
        return ContextStrategy.update$default(new ContextStrategy(new CacheUpdateStrategy()), null, null, new CacheSettingVo(scene, key, value), 3, null);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.update.IIncSettingV2
    public boolean isIncUpdate() {
        return mIsIncUpdate;
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.update.IIncSettingV2
    public void addUpdateListener(IIncSettingV2.ISettingUpdateListener updateListener) {
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        List<IIncSettingV2.ISettingUpdateListener> list = mUpdateListenerList;
        if (list.contains(updateListener)) {
            return;
        }
        list.add(updateListener);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.update.IIncSettingV2
    public void removeUpdateListener(IIncSettingV2.ISettingUpdateListener updateListener) {
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        mUpdateListenerList.remove(updateListener);
    }

    private final boolean incUpdateV2(IncScene scene, JsonObject settings, JsonObject extra) {
        int i = WhenMappings.$EnumSwitchMapping$0[scene.ordinal()];
        if (i == 1) {
            return ContextStrategy.update$default(new ContextStrategy(new ColdUpdateStrategy()), settings, extra, null, 4, null);
        }
        if (i != 2) {
            return false;
        }
        return ContextStrategy.update$default(new ContextStrategy(new PushUpdateStrategy()), settings, extra, null, 4, null);
    }

    private final void notifyUpdate(IncScene scene) {
        Iterator<T> it = mUpdateListenerList.iterator();
        while (it.hasNext()) {
            ((IIncSettingV2.ISettingUpdateListener) it.next()).onSuccess(scene == IncScene.COLD_LAUNCH ? 0 : 1);
        }
    }
}
