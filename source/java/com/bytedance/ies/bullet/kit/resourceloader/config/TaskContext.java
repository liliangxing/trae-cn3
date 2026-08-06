package com.bytedance.ies.bullet.kit.resourceloader.config;

import androidx.exifinterface.media.ExifInterface;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/config/TaskContext;", "", "()V", "extra", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "getDependency", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Ljava/lang/Object;", "putDependency", "", "instance", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class TaskContext {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ConcurrentHashMap<Class<?>, Object> extra = new ConcurrentHashMap<>();

    @JvmStatic
    public static final TaskContext from(Map<Class<?>, ? extends Object> map) {
        return INSTANCE.from(map);
    }

    public final <T> void putDependency(Class<T> clazz, Object instance) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (instance != null) {
            this.extra.put(clazz, instance);
        }
    }

    public final <T> T getDependency(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Object obj = this.extra.get(clazz);
        if (obj == null) {
            return null;
        }
        if (!clazz.isAssignableFrom(obj.getClass())) {
            obj = null;
        }
        if (obj != null) {
            return (T) obj;
        }
        return null;
    }

    /* compiled from: TaskContext.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u001a\u0010\u0005\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/config/TaskContext$Companion;", "", "()V", "from", "Lcom/bytedance/ies/bullet/kit/resourceloader/config/TaskContext;", "map", "", "Ljava/lang/Class;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TaskContext from(Map<Class<?>, ? extends Object> map) {
            TaskContext taskContext = new TaskContext();
            if (map != null) {
                for (Map.Entry<Class<?>, ? extends Object> entry : map.entrySet()) {
                    taskContext.putDependency(entry.getKey(), entry.getValue());
                }
            }
            return taskContext;
        }
    }
}
