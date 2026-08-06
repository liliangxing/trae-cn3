package com.bytedance.android.live.core.setting.p027v2.storage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.live.core.setting.p027v2.SettingCacheV2;
import com.bytedance.android.live.core.setting.p027v2.cache.ICacheManger;
import com.bytedance.android.live.core.setting.p027v2.tools.ContextHelper;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingReportMonitor;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LocalUpdateManger.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rJ\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rJ\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\u0011\u001a\u00020\u000bH\u0002J/\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u0001H\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J/\u0010\u0018\u001a\u0004\u0018\u0001H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u0001H\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u001c\u0010\u001b\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rH\u0002J\u001c\u0010\u001d\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rH\u0002J\u001c\u0010\u001e\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rH\u0002J\u001c\u0010\u001f\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rH\u0002J\"\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rJ\u001e\u0010#\u001a\u00020\u001a2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\rJ\"\u0010%\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/storage/LocalUpdateManger;", "", "()V", "mStorageAction", "Lcom/bytedance/android/live/core/setting/v2/storage/LiveSpStorageAction;", "mTestStorageAction", "clear", "", "clearAllTestKeys", "containsTestKey", "key", "", "getAll", "", "getLocalMap", "getOnlineSpFile", "getTestOriginValue", "getTestSpFile", "getTestValue", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "getValue", "lazyTestFile", "", "minusMap", "map", "minusTestMap", "plusMap", "plusTestMap", SettingV2Monitor.REPORT_TYPE_UPDATE, "operation", "Lcom/bytedance/android/live/core/setting/v2/cache/ICacheManger$Operation;", "updateAllCacheMap", "allCacheMap", "updateTest", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LocalUpdateManger {
    private final LiveSpStorageAction mStorageAction;
    private LiveSpStorageAction mTestStorageAction;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ICacheManger.Operation.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ICacheManger.Operation.PLUS.ordinal()] = 1;
            iArr[ICacheManger.Operation.MINUS.ordinal()] = 2;
            int[] iArr2 = new int[ICacheManger.Operation.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ICacheManger.Operation.PLUS.ordinal()] = 1;
            iArr2[ICacheManger.Operation.MINUS.ordinal()] = 2;
        }
    }

    private final String getOnlineSpFile() {
        return SettingConfigConstant.SETTING_V2_SP_FILE_NAME_ONLINE;
    }

    private final String getTestSpFile() {
        return SettingConfigConstant.SETTING_V2_SP_FILE_NAME_TEST;
    }

    public LocalUpdateManger() {
        Context context = ContextHelper.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "ContextHelper.getContext()");
        this.mStorageAction = new LiveSpStorageAction(context, getOnlineSpFile());
    }

    public final void updateAllCacheMap(Map<String, ? extends Object> allCacheMap) {
        LiveSpStorageAction liveSpStorageAction = this.mStorageAction;
        LinkedHashMap linkedHashMap = null;
        if (allCacheMap != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry : allCacheMap.entrySet()) {
                boolean z = false;
                if (StringsKt.startsWith$default(entry.getKey(), SettingCacheV2.PREFIX, false, 2, (Object) null) && (Intrinsics.areEqual(entry.getValue(), 4) || Intrinsics.areEqual(entry.getValue(), 3))) {
                    z = true;
                }
                if (z) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            linkedHashMap = linkedHashMap2;
        }
        liveSpStorageAction.setMAllCacheMap$live_setting_release(linkedHashMap);
    }

    public final boolean update(ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(map, "map");
        int i = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i == 1) {
            return plusMap(map);
        }
        if (i == 2) {
            return minusMap(map);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <T> T getValue(String key, T defaultValue, Type type) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) this.mStorageAction.getValue(key, defaultValue, type);
    }

    public final boolean clear() {
        return this.mStorageAction.clear();
    }

    public final Map<String, Object> getLocalMap() {
        return this.mStorageAction.getAllMap();
    }

    public final boolean updateTest(ICacheManger.Operation operation, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(map, "map");
        lazyTestFile();
        int i = WhenMappings.$EnumSwitchMapping$1[operation.ordinal()];
        if (i == 1) {
            return plusTestMap(map);
        }
        if (i == 2) {
            return minusTestMap(map);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final <T> T getTestValue(String key, T defaultValue, Type type) {
        Intrinsics.checkNotNullParameter(key, "key");
        lazyTestFile();
        LiveSpStorageAction liveSpStorageAction = this.mTestStorageAction;
        if (liveSpStorageAction != null) {
            return (T) liveSpStorageAction.getValue(key, defaultValue, type);
        }
        return null;
    }

    public final boolean containsTestKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        lazyTestFile();
        LiveSpStorageAction liveSpStorageAction = this.mTestStorageAction;
        return liveSpStorageAction != null && liveSpStorageAction.containsKey(key);
    }

    public final boolean clearAllTestKeys() {
        lazyTestFile();
        LiveSpStorageAction liveSpStorageAction = this.mTestStorageAction;
        return liveSpStorageAction != null && liveSpStorageAction.clear();
    }

    public final Map<String, Object> getAll() {
        return this.mStorageAction.getAll();
    }

    public final Object getTestOriginValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        lazyTestFile();
        LiveSpStorageAction liveSpStorageAction = this.mTestStorageAction;
        if (liveSpStorageAction != null) {
            return liveSpStorageAction.getTestOriginValue(key);
        }
        return null;
    }

    private final void lazyTestFile() {
        if (this.mTestStorageAction == null) {
            Context context = ContextHelper.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "ContextHelper.getContext()");
            this.mTestStorageAction = new LiveSpStorageAction(context, getTestSpFile());
        }
    }

    private final boolean plusMap(Map<String, ? extends Object> map) {
        int i;
        SharedPreferences.Editor editor = this.mStorageAction.getEditor();
        if (editor != null) {
            i = 0;
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                if (this.mStorageAction.put(entry.getKey(), entry.getValue(), editor)) {
                    i++;
                }
            }
            editor.apply();
        } else {
            i = 0;
        }
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_MAIN, "SP plus：本次总共数据条数：" + map.size() + ", plus成功条数 " + i);
        return i == map.size();
    }

    private final boolean minusMap(Map<String, ? extends Object> map) {
        int i;
        SharedPreferences.Editor editor = this.mStorageAction.getEditor();
        if (editor != null) {
            Iterator<Map.Entry<String, ? extends Object>> it = map.entrySet().iterator();
            i = 0;
            while (it.hasNext()) {
                if (this.mStorageAction.remove(it.next().getKey())) {
                    i++;
                }
            }
            editor.apply();
        } else {
            i = 0;
        }
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_MAIN, "SP minus： 本次总共数据条数：" + map.size() + ", minus成功条数 " + i);
        return i == map.size();
    }

    private final boolean plusTestMap(Map<String, ? extends Object> map) {
        int i = 0;
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            LiveSpStorageAction liveSpStorageAction = this.mTestStorageAction;
            if (Intrinsics.areEqual(liveSpStorageAction != null ? Boolean.valueOf(liveSpStorageAction.save(entry.getKey(), entry.getValue())) : null, true)) {
                i++;
            }
        }
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_MAIN, "SP plus：本次Test总共数据条数：" + map.size() + ", plus成功条数 " + i);
        return i == map.size();
    }

    private final boolean minusTestMap(Map<String, ? extends Object> map) {
        int i = 0;
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            LiveSpStorageAction liveSpStorageAction = this.mTestStorageAction;
            if (Intrinsics.areEqual(liveSpStorageAction != null ? Boolean.valueOf(liveSpStorageAction.remove(entry.getKey())) : null, true)) {
                i++;
            }
        }
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_MAIN, "SP minus： 本次Test总共数据条数：" + map.size() + ", minus成功条数 " + i);
        return i == map.size();
    }
}
