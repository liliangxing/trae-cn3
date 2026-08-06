package com.bytedance.android.anniex.lite.flow.base.model;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXModelProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u0002H\u0004\"\n\b\u0000\u0010\u0004*\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0016¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/model/DefaultModelFactory;", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider$Factory;", "()V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class DefaultModelFactory implements AnnieXModelProvider.Factory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static DefaultModelFactory sInstance;

    @Override // com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider.Factory
    public <T extends AnnieXModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        try {
            return modelClass.newInstance();
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
        }
    }

    /* compiled from: AnnieXModelProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/model/DefaultModelFactory$Companion;", "", "()V", "instance", "Lcom/bytedance/android/anniex/lite/flow/base/model/DefaultModelFactory;", "getInstance", "()Lcom/bytedance/android/anniex/lite/flow/base/model/DefaultModelFactory;", "sInstance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DefaultModelFactory getInstance() {
            if (DefaultModelFactory.sInstance == null) {
                DefaultModelFactory.sInstance = new DefaultModelFactory();
            }
            DefaultModelFactory defaultModelFactory = DefaultModelFactory.sInstance;
            Intrinsics.checkNotNull(defaultModelFactory);
            return defaultModelFactory;
        }
    }
}
