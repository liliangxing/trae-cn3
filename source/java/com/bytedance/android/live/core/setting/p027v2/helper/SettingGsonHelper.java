package com.bytedance.android.live.core.setting.p027v2.helper;

import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingGsonHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/core/setting/v2/helper/SettingGsonHelper;", "", "()V", "mGson", "Lcom/google/gson/Gson;", "getMGson", "()Lcom/google/gson/Gson;", "convertGson", ExifInterface.GPS_DIRECTION_TRUE, StrategyConstants.VALUE, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "Ljava/lang/reflect/Type;", "(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "live-setting_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SettingGsonHelper {
    public static final SettingGsonHelper INSTANCE = new SettingGsonHelper();
    private static final Gson mGson;

    /* JADX WARN: Type inference failed for: r1v0, types: [com.bytedance.android.live.core.setting.v2.helper.SettingGsonHelper$mGson$1] */
    static {
        Gson create = new GsonBuilder().registerTypeAdapter(new TypeToken<HashMap<String, Object>>() { // from class: com.bytedance.android.live.core.setting.v2.helper.SettingGsonHelper$mGson$1
        }.getType(), new MapDeserializerDoubleAsIntFix()).registerTypeAdapter(Boolean.TYPE, new SettingBooleanTypeAdapter()).create();
        Intrinsics.checkNotNullExpressionValue(create, "GsonBuilder()\n          …())\n            .create()");
        mGson = create;
    }

    private SettingGsonHelper() {
    }

    public final Gson getMGson() {
        return mGson;
    }

    public final <T> T convertGson(Object value, Type type) {
        Intrinsics.checkNotNullParameter(value, StrategyConstants.VALUE);
        if (Intrinsics.areEqual(type, String.class) || Intrinsics.areEqual(type, (Object) null)) {
            Gson gson = mGson;
            return (T) gson.fromJson(gson.toJson(value.toString()), type);
        }
        return (T) mGson.fromJson(value.toString(), type);
    }
}
