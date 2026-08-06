package com.bytedance.android.anniex.lite.flow.base.model;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0007J\u001b\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\rH\u0014J!\u0010\u0013\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u0002H\u000f¢\u0006\u0002\u0010\u0015R+\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel;", "", "()V", "mBagOfTags", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getMBagOfTags", "()Ljava/util/concurrent/ConcurrentHashMap;", "mBagOfTags$delegate", "Lkotlin/Lazy;", "mCleared", "", "clear", "", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "onCleared", "setTagIfAbsent", "newValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AnnieXModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mBagOfTags$delegate, reason: from kotlin metadata */
    private final Lazy mBagOfTags = LazyKt.lazy(new Function0<ConcurrentHashMap<String, Object>>() { // from class: com.bytedance.android.anniex.lite.flow.base.model.AnnieXModel$mBagOfTags$2
        @Override // kotlin.jvm.functions.Function0
        public final ConcurrentHashMap<String, Object> invoke() {
            return new ConcurrentHashMap<>();
        }
    });
    private volatile boolean mCleared;

    protected void onCleared() {
    }

    private final ConcurrentHashMap<String, Object> getMBagOfTags() {
        return (ConcurrentHashMap) this.mBagOfTags.getValue();
    }

    public final void clear() {
        this.mCleared = true;
        ConcurrentHashMap<String, Object> mBagOfTags = getMBagOfTags();
        if (mBagOfTags != null) {
            Iterator<Map.Entry<String, Object>> it = mBagOfTags.entrySet().iterator();
            while (it.hasNext()) {
                Object value = it.next().getValue();
                if (value != null) {
                    INSTANCE.closeWithRuntimeException(value);
                }
            }
        }
        ConcurrentHashMap<String, Object> mBagOfTags2 = getMBagOfTags();
        if (mBagOfTags2 != null) {
            mBagOfTags2.clear();
        }
        onCleared();
    }

    public final <T> T setTagIfAbsent(String key, T newValue) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        ConcurrentHashMap<String, Object> mBagOfTags = getMBagOfTags();
        if (mBagOfTags != null) {
            obj = mBagOfTags.get(key);
            if (obj == null) {
                mBagOfTags.put(key, newValue);
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            newValue = (T) obj;
        }
        if (this.mCleared && newValue != null) {
            INSTANCE.closeWithRuntimeException(newValue);
        }
        return newValue;
    }

    public final <T> T getTag(String key) {
        ConcurrentHashMap<String, Object> mBagOfTags;
        Intrinsics.checkNotNullParameter(key, "key");
        if (getMBagOfTags() == null || (mBagOfTags = getMBagOfTags()) == null) {
            return null;
        }
        return (T) mBagOfTags.get(key);
    }

    /* compiled from: AnnieXModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModel$Companion;", "", "()V", "closeWithRuntimeException", "", "obj", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void closeWithRuntimeException(Object obj) {
            if (obj instanceof Closeable) {
                try {
                    ((Closeable) obj).close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
