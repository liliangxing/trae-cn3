package com.bytedance.pia.page.bridge;

import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.pia.core.plugins.PrefetchPlugin;
import com.bytedance.pia.core.runtime.PiaPlugin;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.worker.Worker;
import com.bytedance.pia.page.PrefetchManager;
import com.bytedance.pia.page.bridge.PiaPostWorkerMessageMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PiaPostWorkerMessageMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\r\u000eB\u0005¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0096\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pia/page/bridge/PiaPostWorkerMessageMethod;", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$ICall;", "Lcom/bytedance/pia/page/bridge/PiaPostWorkerMessageMethod$Params;", "", "()V", "invoke", "bridge", "Lcom/bytedance/pia/core/api/bridge/IPiaBridge;", "params", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$Error;", "Companion", "Params", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaPostWorkerMessageMethod implements PiaMethod.ICall<Params, Unit> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "pia.postWorkerMessage";
    private static final PiaMethod<Params, Unit> method = new PiaMethod<>(NAME, PiaMethod.Scope.Render, new IFactory() { // from class: com.bytedance.pia.page.bridge.PiaPostWorkerMessageMethod$Companion$method$1
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final PiaMethod.ICall<PiaPostWorkerMessageMethod.Params, Unit> create() {
            return new PiaPostWorkerMessageMethod();
        }
    });

    /* compiled from: PiaPostWorkerMessageMethod.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Worker.Status.values().length];
            try {
                iArr[Worker.Status.Ready.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Worker.Status.Create.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Worker.Status.Fetching.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Worker.Status.Terminate.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final PiaMethod<Params, Unit> getMethod() {
        return INSTANCE.getMethod();
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Unit> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* compiled from: PiaPostWorkerMessageMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/page/bridge/PiaPostWorkerMessageMethod$Companion;", "", "()V", "NAME", "", "method", "Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "Lcom/bytedance/pia/page/bridge/PiaPostWorkerMessageMethod$Params;", "", "getMethod$annotations", "getMethod", "()Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getMethod$annotations() {
        }

        private Companion() {
        }

        public final PiaMethod<Params, Unit> getMethod() {
            return PiaPostWorkerMessageMethod.method;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge bridge, Params params, IConsumer<Unit> resolve, IConsumer<PiaMethod.Error> reject) {
        PrefetchManager prefetchManager;
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        if (params.getData() == null) {
            reject.accept(new PiaMethod.InvalidParamsError("Parameter 'data' requested!"));
            return;
        }
        IPiaContext context = bridge.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.bytedance.pia.core.runtime.PiaRuntime");
        PiaPlugin plugin = ((PiaRuntime) context).getPlugin(ErrorType.PREFETCH);
        PrefetchPlugin prefetchPlugin = plugin instanceof PrefetchPlugin ? (PrefetchPlugin) plugin : null;
        Worker worker = (prefetchPlugin == null || (prefetchManager = prefetchPlugin.getPrefetchManager()) == null) ? null : prefetchManager.getWorker();
        Worker.Status status = worker != null ? worker.getStatus() : null;
        int i = status == null ? -1 : WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            worker.postMessage(params.getData());
            resolve.accept(Unit.INSTANCE);
        } else if (i == 2 || i == 3) {
            reject.accept(new PiaMethod.Error("{\"state\":\"fetching\"}"));
        } else if (i == 4) {
            reject.accept(new PiaMethod.Error("{\"state\":\"terminate\"}"));
        } else {
            reject.accept(new PiaMethod.Error("{\"state\":\"unusable\"}"));
        }
    }

    /* compiled from: PiaPostWorkerMessageMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pia/page/bridge/PiaPostWorkerMessageMethod$Params;", "", "data", "", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Params {

        @SerializedName("data")
        private final String data;

        public static /* synthetic */ Params copy$default(Params params, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.data;
            }
            return params.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        public final Params copy(String data) {
            return new Params(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Params) && Intrinsics.areEqual(this.data, ((Params) other).data);
        }

        public int hashCode() {
            String str = this.data;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Params(data=" + this.data + ')';
        }

        public Params(String str) {
            this.data = str;
        }

        public final String getData() {
            return this.data;
        }
    }
}
