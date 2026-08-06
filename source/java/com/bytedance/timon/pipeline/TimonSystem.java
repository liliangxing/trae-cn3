package com.bytedance.timon.pipeline;

import com.ss.android.download.api.constant.Downloads;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.bm.Rule;

/* compiled from: TimonSystem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\t\n\u000bJ\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/timon/pipeline/TimonSystem;", "", "name", "", "postInvoke", "", Downloads.Impl.COLUMN_APP_DATA, "Lcom/bytedance/timon/pipeline/TimonEntity;", "preInvoke", "InvokeType", "OnlyPostInvokeSystem", "OnlyPreInvokeSystem", "pipeline_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface TimonSystem {

    /* compiled from: TimonSystem.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static boolean postInvoke(TimonSystem timonSystem, TimonEntity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            return true;
        }

        public static boolean preInvoke(TimonSystem timonSystem, TimonEntity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            return true;
        }
    }

    /* compiled from: TimonSystem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/timon/pipeline/TimonSystem$InvokeType;", "", "(Ljava/lang/String;I)V", "PRE_INVOKE", "POST_INVOKE", Rule.ALL, "pipeline_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public enum InvokeType {
        PRE_INVOKE,
        POST_INVOKE,
        ALL
    }

    /* renamed from: name */
    String getName();

    boolean postInvoke(TimonEntity entity);

    boolean preInvoke(TimonEntity entity);

    /* compiled from: TimonSystem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timon/pipeline/TimonSystem$OnlyPreInvokeSystem;", "Lcom/bytedance/timon/pipeline/TimonSystem;", "name", "", "delegate", "(Ljava/lang/String;Lcom/bytedance/timon/pipeline/TimonSystem;)V", "postInvoke", "", Downloads.Impl.COLUMN_APP_DATA, "Lcom/bytedance/timon/pipeline/TimonEntity;", "preInvoke", "pipeline_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public static final class OnlyPreInvokeSystem implements TimonSystem {
        private final TimonSystem delegate;
        private final String name;

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public boolean postInvoke(TimonEntity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            return false;
        }

        public OnlyPreInvokeSystem(String name, TimonSystem delegate) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            this.name = name;
            this.delegate = delegate;
        }

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public boolean preInvoke(TimonEntity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            return this.delegate.preInvoke(entity);
        }

        @Override // com.bytedance.timon.pipeline.TimonSystem
        /* renamed from: name, reason: from getter */
        public String getName() {
            return this.name;
        }
    }

    /* compiled from: TimonSystem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/timon/pipeline/TimonSystem$OnlyPostInvokeSystem;", "Lcom/bytedance/timon/pipeline/TimonSystem;", "name", "", "delegate", "(Ljava/lang/String;Lcom/bytedance/timon/pipeline/TimonSystem;)V", "postInvoke", "", Downloads.Impl.COLUMN_APP_DATA, "Lcom/bytedance/timon/pipeline/TimonEntity;", "preInvoke", "pipeline_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes5.dex */
    public static final class OnlyPostInvokeSystem implements TimonSystem {
        private final TimonSystem delegate;
        private final String name;

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public boolean preInvoke(TimonEntity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            return false;
        }

        public OnlyPostInvokeSystem(String name, TimonSystem delegate) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            this.name = name;
            this.delegate = delegate;
        }

        @Override // com.bytedance.timon.pipeline.TimonSystem
        public boolean postInvoke(TimonEntity entity) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            return this.delegate.postInvoke(entity);
        }

        @Override // com.bytedance.timon.pipeline.TimonSystem
        /* renamed from: name, reason: from getter */
        public String getName() {
            return this.name;
        }
    }
}
