package com.bytedance.android.live.core.setting.p027v2.storage;

import android.content.SharedPreferences;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ILiveSpStorageAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\bH&J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J3\u0010\r\u001a\u0004\u0018\u0001H\u000e\"\u0004\b\u0000\u0010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u0001H\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0002\u0010\u0012J/\u0010\u0013\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u0001H\u000e2\u0006\u0010\u0015\u001a\u00020\u000bH&¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J'\u0010\u0018\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u0001H\u000eH&¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/storage/ILiveSpStorageAction;", "", "clear", "", "containsKey", "key", "", "getAll", "", "getAllMap", "getEditor", "Landroid/content/SharedPreferences$Editor;", "getTestOriginValue", "getValue", ExifInterface.GPS_DIRECTION_TRUE, "defaultValue", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "put", StrategyConstants.VALUE, "editor", "(Ljava/lang/String;Ljava/lang/Object;Landroid/content/SharedPreferences$Editor;)Z", "remove", "save", "(Ljava/lang/String;Ljava/lang/Object;)Z", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public interface ILiveSpStorageAction {
    boolean clear();

    boolean containsKey(String key);

    Map<String, ?> getAll();

    Map<String, Object> getAllMap();

    SharedPreferences.Editor getEditor();

    Object getTestOriginValue(String key);

    <T> T getValue(String key, T defaultValue, Type type);

    <T> boolean put(String key, T value, SharedPreferences.Editor editor);

    boolean remove(String key);

    <T> boolean save(String key, T value);
}
