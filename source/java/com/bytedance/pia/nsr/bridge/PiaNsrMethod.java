package com.bytedance.pia.nsr.bridge;

import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.nsr.NsrManager;
import com.bytedance.pia.nsr.bridge.PiaNsrMethod;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PiaNsrMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0096\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod;", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$ICall;", "Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Params;", "Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Result;", "()V", "invoke", "", "bridge", "Lcom/bytedance/pia/core/api/bridge/IPiaBridge;", "params", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$Error;", "Companion", "Params", "Result", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaNsrMethod implements PiaMethod.ICall<Params, Result> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "pia.nsr";
    private static final PiaMethod<Params, Result> method = new PiaMethod<>(NAME, PiaMethod.Scope.Render, new IFactory() { // from class: com.bytedance.pia.nsr.bridge.PiaNsrMethod$Companion$method$1
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final PiaMethod.ICall<PiaNsrMethod.Params, PiaNsrMethod.Result> create() {
            return new PiaNsrMethod();
        }
    });

    public static final PiaMethod<Params, Result> getMethod() {
        return INSTANCE.getMethod();
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* compiled from: PiaNsrMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Companion;", "", "()V", "NAME", "", "method", "Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Params;", "Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Result;", "getMethod$annotations", "getMethod", "()Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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

        public final PiaMethod<Params, Result> getMethod() {
            return PiaNsrMethod.method;
        }
    }

    /* compiled from: PiaNsrMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Params;", "", "url", "", "expires", "", SchemaConstants.QUERY_KEY_REUSE, "", "nameSpace", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)V", "getExpires", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNameSpace", "()Ljava/lang/String;", "getReuse", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Params;", "equals", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Params {

        @SerializedName("expires")
        private final Long expires;

        @SerializedName("namespace")
        private final String nameSpace;

        @SerializedName(SchemaConstants.QUERY_KEY_REUSE)
        private final Boolean reuse;

        @SerializedName("url")
        private final String url;

        public static /* synthetic */ Params copy$default(Params params, String str, Long l, Boolean bool, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.url;
            }
            if ((i & 2) != 0) {
                l = params.expires;
            }
            if ((i & 4) != 0) {
                bool = params.reuse;
            }
            if ((i & 8) != 0) {
                str2 = params.nameSpace;
            }
            return params.copy(str, l, bool, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getExpires() {
            return this.expires;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getReuse() {
            return this.reuse;
        }

        /* renamed from: component4, reason: from getter */
        public final String getNameSpace() {
            return this.nameSpace;
        }

        public final Params copy(String url, Long expires, Boolean reuse, String nameSpace) {
            return new Params(url, expires, reuse, nameSpace);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return Intrinsics.areEqual(this.url, params.url) && Intrinsics.areEqual(this.expires, params.expires) && Intrinsics.areEqual(this.reuse, params.reuse) && Intrinsics.areEqual(this.nameSpace, params.nameSpace);
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            Long l = this.expires;
            int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
            Boolean bool = this.reuse;
            int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str2 = this.nameSpace;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Params(url=" + this.url + ", expires=" + this.expires + ", reuse=" + this.reuse + ", nameSpace=" + this.nameSpace + ')';
        }

        public Params(String str, Long l, Boolean bool, String str2) {
            this.url = str;
            this.expires = l;
            this.reuse = bool;
            this.nameSpace = str2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final Long getExpires() {
            return this.expires;
        }

        public final Boolean getReuse() {
            return this.reuse;
        }

        public final String getNameSpace() {
            return this.nameSpace;
        }
    }

    /* compiled from: PiaNsrMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0010"}, d2 = {"Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Result;", "", "isUpdate", "", "(Ljava/lang/Boolean;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/bytedance/pia/nsr/bridge/PiaNsrMethod$Result;", "equals", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Result {

        @SerializedName("isUpdate")
        private final Boolean isUpdate;

        public static /* synthetic */ Result copy$default(Result result, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = result.isUpdate;
            }
            return result.copy(bool);
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getIsUpdate() {
            return this.isUpdate;
        }

        public final Result copy(Boolean isUpdate) {
            return new Result(isUpdate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Result) && Intrinsics.areEqual(this.isUpdate, ((Result) other).isUpdate);
        }

        public int hashCode() {
            Boolean bool = this.isUpdate;
            if (bool == null) {
                return 0;
            }
            return bool.hashCode();
        }

        public String toString() {
            return "Result(isUpdate=" + this.isUpdate + ')';
        }

        public Result(Boolean bool) {
            this.isUpdate = bool;
        }

        public final Boolean isUpdate() {
            return this.isUpdate;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge bridge, Params params, final IConsumer<Result> resolve, final IConsumer<PiaMethod.Error> reject) {
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        if (params.getUrl() == null) {
            reject.accept(new PiaMethod.InvalidParamsError("Parameter 'url' requested!"));
            return;
        }
        IPiaContext context = bridge.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.bytedance.pia.core.runtime.PiaRuntime");
        PiaRuntime piaRuntime = (PiaRuntime) context;
        NsrManager nsrManager = NsrManager.INSTANCE;
        String url = params.getUrl();
        Long expires = params.getExpires();
        long longValue = expires != null ? expires.longValue() : 60000L;
        String nameSpace = params.getNameSpace();
        if (nameSpace == null) {
            nameSpace = piaRuntime.getNamespace();
            Intrinsics.checkNotNullExpressionValue(nameSpace, "runtime.namespace");
        }
        nsrManager.render(url, longValue, nameSpace, !(params.getReuse() != null ? r11.booleanValue() : true), piaRuntime, new Function2<String, Boolean, Unit>() { // from class: com.bytedance.pia.nsr.bridge.PiaNsrMethod$invoke$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                resolve.accept(new PiaNsrMethod.Result(Boolean.valueOf(z)));
            }
        }, new Function1<String, Unit>() { // from class: com.bytedance.pia.nsr.bridge.PiaNsrMethod$invoke$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                reject.accept(new PiaMethod.Error(str));
            }
        });
    }
}
