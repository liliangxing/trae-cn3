package com.bytedance.android.live.core.setting.p027v2.storage;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.SettingCacheV2;
import com.bytedance.android.live.core.setting.p027v2.helper.ConvertHelper;
import com.bytedance.android.live.core.setting.p027v2.helper.SettingGsonHelper;
import com.bytedance.android.live.core.setting.p027v2.helper.SettingOptConfig;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingReportMonitor;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveSpStorageAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0016\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\bH\u0016J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t0\bH\u0016J!\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u001aJ)\u0010\u001c\u001a\u00020\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0002\u0010#J!\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020%H\u0002¢\u0006\u0002\u0010&J!\u0010'\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010(J+\u0010)\u001a\u0004\u0018\u00010!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020!H\u0002¢\u0006\u0002\u0010*J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J!\u0010-\u001a\u0004\u0018\u00010%2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020%H\u0002¢\u0006\u0002\u0010&J+\u0010.\u001a\u0004\u0018\u00010%2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020%H\u0002¢\u0006\u0002\u0010/J!\u00100\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010(J\u0012\u00101\u001a\u00020\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002J!\u00102\u001a\u0004\u0018\u0001032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u000203H\u0002¢\u0006\u0002\u00104J\u001e\u00105\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u00106\u001a\u0004\u0018\u00010\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J3\u00107\u001a\u0004\u0018\u0001H8\"\u0004\b\u0000\u001082\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u00109\u001a\u0004\u0018\u0001H82\b\u0010:\u001a\u0004\u0018\u00010;H\u0016¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J/\u0010?\u001a\u00020\u0013\"\u0004\b\u0000\u001082\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u0001H82\u0006\u0010@\u001a\u00020,H\u0016¢\u0006\u0002\u0010AJ\u0012\u0010B\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016J'\u0010C\u001a\u00020\u0013\"\u0004\b\u0000\u001082\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u0001H8H\u0016¢\u0006\u0002\u0010DJ&\u0010E\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u00132\n\b\u0002\u0010@\u001a\u0004\u0018\u00010,H\u0002J&\u0010F\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u001e2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010,H\u0002J&\u0010G\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u0002032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010,H\u0002J(\u0010H\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010@\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010I\u001a\u00020\u00132\b\u0010@\u001a\u0004\u0018\u00010,H\u0002R*\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/storage/LiveSpStorageAction;", "Lcom/bytedance/android/live/core/setting/v2/storage/ILiveSpStorageAction;", "context", "Landroid/content/Context;", "fileName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "mAllCacheMap", "", "", "getMAllCacheMap$live_setting_release", "()Ljava/util/Map;", "setMAllCacheMap$live_setting_release", "(Ljava/util/Map;)V", "mContext", "mFileName", "mSpf", "Landroid/content/SharedPreferences;", "clear", "", "containsKey", "key", "getAll", "getAllMap", "getBoolean", "defValue", "(Ljava/lang/String;Z)Ljava/lang/Boolean;", "getBooleanByAll", "getBooleanByType", "originType", "", "(Ljava/lang/Integer;Ljava/lang/String;Z)Z", "getCompatibleDouble", "", StrategyConstants.VALUE, "(Ljava/lang/String;D)Ljava/lang/Double;", "getCompatibleFloat", "", "(Ljava/lang/String;F)Ljava/lang/Float;", "getCompatibleInt", "(Ljava/lang/String;I)Ljava/lang/Integer;", "getDoubleByType", "(Ljava/lang/Integer;Ljava/lang/String;D)Ljava/lang/Double;", "getEditor", "Landroid/content/SharedPreferences$Editor;", "getFloatByAll", "getFloatByType", "(Ljava/lang/Integer;Ljava/lang/String;F)Ljava/lang/Float;", "getInt", "getIntType", "getLong", "", "(Ljava/lang/String;J)Ljava/lang/Long;", "getString", "getTestOriginValue", "getValue", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "lazyInit", "", "put", "editor", "(Ljava/lang/String;Ljava/lang/Object;Landroid/content/SharedPreferences$Editor;)Z", "remove", "save", "(Ljava/lang/String;Ljava/lang/Object;)Z", "setBoolean", "setInt", "setLong", "setString", "submit", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LiveSpStorageAction implements ILiveSpStorageAction {
    private Map<String, ? extends Object> mAllCacheMap;
    private Context mContext;
    private final String mFileName;
    private SharedPreferences mSpf;

    public LiveSpStorageAction(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "fileName");
        this.mContext = context;
        this.mFileName = str;
    }

    public final Map<String, Object> getMAllCacheMap$live_setting_release() {
        return this.mAllCacheMap;
    }

    public final void setMAllCacheMap$live_setting_release(Map<String, ? extends Object> map) {
        this.mAllCacheMap = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public <T> boolean save(String key, T value) {
        lazyInit(this.mFileName);
        if (value instanceof Boolean) {
            setBoolean$default(this, key, ((Boolean) value).booleanValue(), null, 4, null);
            return setInt$default(this, SettingCacheV2.PREFIX + key, 4, null, 4, null);
        }
        if (value instanceof String) {
            setString$default(this, key, (String) value, null, 4, null);
            return setInt$default(this, SettingCacheV2.PREFIX + key, 3, null, 4, null);
        }
        if (value instanceof Integer) {
            setLong$default(this, key, ((Number) value).intValue(), null, 4, null);
            return setInt$default(this, SettingCacheV2.PREFIX + key, 2, null, 4, null);
        }
        if (value instanceof Long) {
            setLong$default(this, key, ((Number) value).longValue(), null, 4, null);
            return setInt$default(this, SettingCacheV2.PREFIX + key, 2, null, 4, null);
        }
        if (value instanceof Float) {
            setString$default(this, key, value.toString(), null, 4, null);
            return setInt$default(this, SettingCacheV2.PREFIX + key, 3, null, 4, null);
        }
        if (value instanceof LinkedTreeMap) {
            setString$default(this, key, SettingGsonHelper.INSTANCE.getMGson().toJson(value), null, 4, null);
            return setInt$default(this, SettingCacheV2.PREFIX + key, 0, null, 4, null);
        }
        if (value instanceof ArrayList) {
            setString$default(this, key, SettingGsonHelper.INSTANCE.getMGson().toJson(value), null, 4, null);
            return setInt$default(this, SettingCacheV2.PREFIX + key, 1, null, 4, null);
        }
        return setString$default(this, key, SettingGsonHelper.INSTANCE.getMGson().toJson(value), null, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public <T> boolean put(String key, T value, SharedPreferences.Editor editor) {
        Intrinsics.checkNotNullParameter(editor, "editor");
        lazyInit(this.mFileName);
        if (value instanceof Boolean) {
            setBoolean(key, ((Boolean) value).booleanValue(), editor);
            return setInt(SettingCacheV2.PREFIX + key, 4, editor);
        }
        if (value instanceof String) {
            setString(key, (String) value, editor);
            return setInt(SettingCacheV2.PREFIX + key, 3, editor);
        }
        if (value instanceof Integer) {
            setLong(key, ((Number) value).intValue(), editor);
            return setInt(SettingCacheV2.PREFIX + key, 2, editor);
        }
        if (value instanceof Long) {
            setLong(key, ((Number) value).longValue(), editor);
            return setInt(SettingCacheV2.PREFIX + key, 2, editor);
        }
        if (value instanceof Float) {
            setString(key, value.toString(), editor);
            return setInt(SettingCacheV2.PREFIX + key, 3, editor);
        }
        if (value instanceof Double) {
            setString(key, value.toString(), editor);
            return setInt(SettingCacheV2.PREFIX + key, 3, editor);
        }
        if (value instanceof LinkedTreeMap) {
            setString(key, SettingGsonHelper.INSTANCE.getMGson().toJson(value), editor);
            return setInt(SettingCacheV2.PREFIX + key, 0, editor);
        }
        if (value instanceof ArrayList) {
            setString(key, SettingGsonHelper.INSTANCE.getMGson().toJson(value), editor);
            return setInt(SettingCacheV2.PREFIX + key, 1, editor);
        }
        return setString(key, SettingGsonHelper.INSTANCE.getMGson().toJson(value), editor);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public Map<String, Object> getAllMap() {
        Map<String, ?> all;
        lazyInit(this.mFileName);
        SharedPreferences sharedPreferences = this.mSpf;
        return (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) ? new HashMap() : all;
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public boolean remove(String key) {
        lazyInit(this.mFileName);
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences == null || !sharedPreferences.contains(key)) {
            return true;
        }
        String str = SettingCacheV2.PREFIX + key;
        SharedPreferences sharedPreferences2 = this.mSpf;
        if (sharedPreferences2 != null && sharedPreferences2.contains(str)) {
            SharedPreferences.Editor editor = getEditor();
            submit(editor != null ? editor.remove(str) : null);
        }
        SharedPreferences.Editor editor2 = getEditor();
        return submit(editor2 != null ? editor2.remove(key) : null);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public boolean containsKey(String key) {
        lazyInit(this.mFileName);
        SharedPreferences sharedPreferences = this.mSpf;
        return sharedPreferences != null && sharedPreferences.contains(key);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public Map<String, ?> getAll() {
        Map<String, ?> all;
        lazyInit(this.mFileName);
        SharedPreferences sharedPreferences = this.mSpf;
        return (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) ? new HashMap() : all;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public <T> T getValue(String key, T defaultValue, Type type) {
        T t;
        Map<String, ?> all;
        lazyInit(this.mFileName);
        if (defaultValue == 0) {
            SharedPreferences sharedPreferences = this.mSpf;
            Object obj = (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) ? null : all.get(key);
            if (obj != null) {
                return (T) SettingGsonHelper.INSTANCE.convertGson(obj.toString(), type);
            }
            return null;
        }
        if (defaultValue instanceof Boolean) {
            t = (T) getBoolean(key, ((Boolean) defaultValue).booleanValue());
        } else if (defaultValue instanceof String) {
            t = (T) getString(key, (String) defaultValue);
        } else if (defaultValue instanceof Integer) {
            t = (T) getCompatibleInt(key, ((Number) defaultValue).intValue());
        } else if (defaultValue instanceof Long) {
            t = (T) getLong(key, ((Number) defaultValue).longValue());
        } else if (defaultValue instanceof Float) {
            t = (T) getCompatibleFloat(key, ((Number) defaultValue).floatValue());
        } else if (defaultValue instanceof Double) {
            t = (T) getCompatibleDouble(key, ((Number) defaultValue).doubleValue());
        } else if (SettingOptConfig.INSTANCE.isOptV2()) {
            String string = getString(key, null);
            t = defaultValue;
            if (string != null) {
                T t2 = (T) SettingGsonHelper.INSTANCE.getMGson().fromJson(string, type);
                Intrinsics.checkNotNullExpressionValue(t2, "SettingGsonHelper.mGson.fromJson(spStr, type)");
                t = t2;
            }
        } else {
            T t3 = (T) SettingGsonHelper.INSTANCE.getMGson().fromJson(getString(key, SettingGsonHelper.INSTANCE.getMGson().toJson(defaultValue)), type);
            Intrinsics.checkNotNullExpressionValue(t3, "SettingGsonHelper.mGson.…son(defaultValue)), type)");
            t = t3;
        }
        if (t instanceof Object) {
            return t;
        }
        return null;
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public Object getTestOriginValue(String key) {
        Map<String, ?> all;
        lazyInit(this.mFileName);
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) {
            return null;
        }
        return all.get(key);
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public boolean clear() {
        SharedPreferences.Editor clear;
        lazyInit(this.mFileName);
        SharedPreferences.Editor editor = getEditor();
        return (editor == null || (clear = editor.clear()) == null || !clear.commit()) ? false : true;
    }

    @Override // com.bytedance.android.live.core.setting.p027v2.storage.ILiveSpStorageAction
    public SharedPreferences.Editor getEditor() {
        lazyInit(this.mFileName);
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences != null) {
            return sharedPreferences.edit();
        }
        return null;
    }

    private final void lazyInit(String fileName) {
        Context context;
        if (this.mSpf != null || (context = this.mContext) == null) {
            return;
        }
        this.mSpf = context.getSharedPreferences(fileName, 0);
    }

    private final boolean submit(SharedPreferences.Editor editor) {
        if (editor == null) {
            return false;
        }
        editor.apply();
        return true;
    }

    static /* synthetic */ boolean setString$default(LiveSpStorageAction liveSpStorageAction, String str, String str2, SharedPreferences.Editor editor, int i, Object obj) {
        if ((i & 4) != 0) {
            editor = null;
        }
        return liveSpStorageAction.setString(str, str2, editor);
    }

    private final boolean setString(String key, String value, SharedPreferences.Editor editor) {
        if (editor != null) {
            return editor.putString(key, value) != null;
        }
        SharedPreferences.Editor editor2 = getEditor();
        return submit(editor2 != null ? editor2.putString(key, value) : null);
    }

    static /* synthetic */ boolean setBoolean$default(LiveSpStorageAction liveSpStorageAction, String str, boolean z, SharedPreferences.Editor editor, int i, Object obj) {
        if ((i & 4) != 0) {
            editor = null;
        }
        return liveSpStorageAction.setBoolean(str, z, editor);
    }

    private final boolean setBoolean(String key, boolean value, SharedPreferences.Editor editor) {
        if (editor != null) {
            return editor.putBoolean(key, value) != null;
        }
        SharedPreferences.Editor editor2 = getEditor();
        return submit(editor2 != null ? editor2.putBoolean(key, value) : null);
    }

    static /* synthetic */ boolean setInt$default(LiveSpStorageAction liveSpStorageAction, String str, int i, SharedPreferences.Editor editor, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            editor = null;
        }
        return liveSpStorageAction.setInt(str, i, editor);
    }

    private final boolean setInt(String key, int value, SharedPreferences.Editor editor) {
        if (editor != null) {
            return editor.putInt(key, value) != null;
        }
        SharedPreferences.Editor editor2 = getEditor();
        return submit(editor2 != null ? editor2.putInt(key, value) : null);
    }

    static /* synthetic */ boolean setLong$default(LiveSpStorageAction liveSpStorageAction, String str, long j, SharedPreferences.Editor editor, int i, Object obj) {
        if ((i & 4) != 0) {
            editor = null;
        }
        return liveSpStorageAction.setLong(str, j, editor);
    }

    private final boolean setLong(String key, long value, SharedPreferences.Editor editor) {
        if (editor != null) {
            return editor.putLong(key, value) != null;
        }
        SharedPreferences.Editor editor2 = getEditor();
        return submit(editor2 != null ? editor2.putLong(key, value) : null);
    }

    private final String getString(String key, String defValue) {
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(key, defValue);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private final Boolean getBoolean(String key, boolean defValue) {
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences != null && sharedPreferences.contains(key)) {
            try {
                int intType = getIntType(key);
                if (intType == -1) {
                    key = getBooleanByAll(key, defValue);
                } else {
                    key = Boolean.valueOf(getBooleanByType(Integer.valueOf(intType), key, defValue));
                }
                return key;
            } catch (Exception e) {
                SettingReportMonitor.INSTANCE.printELog(e);
                return getBooleanByAll(key, defValue);
            }
        }
        return Boolean.valueOf(defValue);
    }

    private final Integer getInt(String key, int value) {
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences != null) {
            return Integer.valueOf(sharedPreferences.getInt(key, value));
        }
        return null;
    }

    private final Integer getCompatibleInt(String key, int value) {
        Long l = getLong(key, value);
        if (l != null) {
            return Integer.valueOf(ConvertHelper.safeConvertInt(l.longValue(), value));
        }
        return Integer.valueOf(value);
    }

    private final Long getLong(String key, long value) {
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences != null) {
            return Long.valueOf(sharedPreferences.getLong(key, value));
        }
        return null;
    }

    private final Double getCompatibleDouble(String key, double value) {
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences != null && sharedPreferences.contains(key)) {
            int intType = getIntType(key);
            if (intType == -1) {
                return Double.valueOf(ConvertHelper.safeConvertDouble(getString(key, String.valueOf(value)), value));
            }
            return getDoubleByType(Integer.valueOf(intType), key, value);
        }
        return Double.valueOf(value);
    }

    private final Float getCompatibleFloat(String key, float defValue) {
        SharedPreferences sharedPreferences = this.mSpf;
        if (sharedPreferences != null && sharedPreferences.contains(key)) {
            int intType = getIntType(key);
            if (intType == -1) {
                return getFloatByAll(key, defValue);
            }
            return getFloatByType(Integer.valueOf(intType), key, defValue);
        }
        return Float.valueOf(defValue);
    }

    private final Boolean getBooleanByAll(String key, boolean defValue) {
        Map<String, ?> all;
        SharedPreferences sharedPreferences = this.mSpf;
        Object obj = (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) ? null : all.get(key);
        if (obj != null) {
            defValue = ConvertHelper.convertBoolean(obj, defValue);
        }
        return Boolean.valueOf(defValue);
    }

    private final boolean getBooleanByType(Integer originType, String key, boolean defValue) {
        if (originType != null && originType.intValue() == 4) {
            SharedPreferences sharedPreferences = this.mSpf;
            Boolean valueOf = sharedPreferences != null ? Boolean.valueOf(sharedPreferences.getBoolean(key, defValue)) : null;
            if (valueOf == null) {
                return defValue;
            }
            valueOf.booleanValue();
            return ConvertHelper.convertBoolean(valueOf, defValue);
        }
        if (originType != null && originType.intValue() == 3) {
            SharedPreferences sharedPreferences2 = this.mSpf;
            String string = sharedPreferences2 != null ? sharedPreferences2.getString(key, null) : null;
            return string != null ? ConvertHelper.convertBoolean(string, defValue) : defValue;
        }
        if (originType == null || originType.intValue() != 2) {
            return defValue;
        }
        SharedPreferences sharedPreferences3 = this.mSpf;
        Long valueOf2 = sharedPreferences3 != null ? Long.valueOf(sharedPreferences3.getLong(key, -100L)) : null;
        if ((valueOf2 != null && valueOf2.longValue() == -100) || valueOf2 == null) {
            return defValue;
        }
        valueOf2.longValue();
        return ConvertHelper.convertBoolean(valueOf2, defValue);
    }

    private final Float getFloatByAll(String key, float defValue) {
        Map<String, ?> all;
        SettingReportMonitor.printLog(SettingReportMonitor.TAG_GET_ALL, "key=" + key + ", defValue= " + defValue);
        SharedPreferences sharedPreferences = this.mSpf;
        Object obj = (sharedPreferences == null || (all = sharedPreferences.getAll()) == null) ? null : all.get(key);
        if (obj != null) {
            return Float.valueOf(ConvertHelper.safeConvertFloat(obj.toString(), defValue));
        }
        return null;
    }

    private final Float getFloatByType(Integer originType, String key, float defValue) {
        if (originType != null && originType.intValue() == 3) {
            SharedPreferences sharedPreferences = this.mSpf;
            String string = sharedPreferences != null ? sharedPreferences.getString(key, null) : null;
            if (string != null) {
                defValue = ConvertHelper.safeConvertFloat(string.toString(), defValue);
            }
            return Float.valueOf(defValue);
        }
        if (originType != null && originType.intValue() == 2) {
            SharedPreferences sharedPreferences2 = this.mSpf;
            Long valueOf = sharedPreferences2 != null ? Long.valueOf(sharedPreferences2.getLong(key, -100L)) : null;
            if (valueOf != null) {
                valueOf.longValue();
                defValue = ConvertHelper.safeConvertFloat(String.valueOf(valueOf.longValue()), defValue);
            }
            return Float.valueOf(defValue);
        }
        return Float.valueOf(defValue);
    }

    private final Double getDoubleByType(Integer originType, String key, double defValue) {
        if (originType != null && originType.intValue() == 3) {
            SharedPreferences sharedPreferences = this.mSpf;
            String string = sharedPreferences != null ? sharedPreferences.getString(key, null) : null;
            if (string != null) {
                defValue = ConvertHelper.safeConvertDouble(string.toString(), defValue);
            }
            return Double.valueOf(defValue);
        }
        if (originType != null && originType.intValue() == 2) {
            SharedPreferences sharedPreferences2 = this.mSpf;
            Long valueOf = sharedPreferences2 != null ? Long.valueOf(sharedPreferences2.getLong(key, -100L)) : null;
            if (valueOf != null) {
                valueOf.longValue();
                defValue = ConvertHelper.safeConvertDouble(String.valueOf(valueOf.longValue()), defValue);
            }
            return Double.valueOf(defValue);
        }
        return Double.valueOf(defValue);
    }

    private final int getIntType(String key) {
        Integer num;
        Map<String, ? extends Object> map;
        String str = SettingCacheV2.PREFIX + key;
        if (SettingOptConfig.INSTANCE.isTypeOpt() && (map = this.mAllCacheMap) != null && map.containsKey(str)) {
            Map<String, ? extends Object> map2 = this.mAllCacheMap;
            Object obj = map2 != null ? map2.get(str) : null;
            num = (Integer) (obj instanceof Integer ? obj : null);
        } else {
            num = getInt(str, -1);
        }
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
