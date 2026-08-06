package com.bytedance.android.anniex.lite.flow.base.model;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXModelProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0087\u0002¢\u0006\u0002\u0010\fJ-\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0007¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider;", "", "owner", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelStore;", "factory", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider$Factory;", "(Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelStore;Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider$Factory;)V", "get", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "Companion", "Factory", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXModelProvider {
    private static final String DEFAULT_KEY = "AnnieXModelProvider.DefaultKey";
    private final Factory factory;
    private final AnnieXModelStore owner;

    /* compiled from: AnnieXModelProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider$Factory;", "", "create", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface Factory {
        <T extends AnnieXModel> T create(Class<T> modelClass);
    }

    public AnnieXModelProvider(AnnieXModelStore annieXModelStore, Factory factory) {
        Intrinsics.checkNotNullParameter(annieXModelStore, "owner");
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.owner = annieXModelStore;
        this.factory = factory;
    }

    public final <T extends AnnieXModel> T get(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) get(DEFAULT_KEY + ':' + canonicalName, modelClass);
    }

    public final <T extends AnnieXModel> T get(String key, Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        T t = (T) this.owner.get(key);
        if (t != null && modelClass.isInstance(t)) {
            return t;
        }
        T t2 = (T) this.factory.create(modelClass);
        this.owner.put(key, t2);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider.get");
        return t2;
    }
}
