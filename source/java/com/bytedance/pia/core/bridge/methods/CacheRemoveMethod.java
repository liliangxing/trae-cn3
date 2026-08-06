package com.bytedance.pia.core.bridge.methods;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.api.bridge.IPiaBridge;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IFactory;
import com.bytedance.pia.core.bridge.methods.CacheRemoveMethod;
import com.bytedance.pia.core.cache.PIACacheManager;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.UrlUtils;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheRemoveMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0096\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/CacheRemoveMethod;", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$ICall;", "Lcom/bytedance/pia/core/bridge/methods/CacheRemoveMethod$Params;", "Lcom/bytedance/pia/core/bridge/methods/CacheRemoveMethod$Result;", "()V", "invoke", "", "bridge", "Lcom/bytedance/pia/core/api/bridge/IPiaBridge;", "params", "resolve", "Lcom/bytedance/pia/core/api/utils/IConsumer;", "reject", "Lcom/bytedance/pia/core/api/bridge/PiaMethod$Error;", "Companion", "Params", "Result", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class CacheRemoveMethod implements PiaMethod.ICall<Params, Result> {
    public static final String CACHE_FAILED = "[Cache] PIA Cache Remove Failed, reason: (";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String NAME = "pia.internal.cache.remove";
    private static final PiaMethod<Params, Result> method = new PiaMethod<>(NAME, PiaMethod.Scope.All, new IFactory() { // from class: com.bytedance.pia.core.bridge.methods.CacheRemoveMethod$Companion$method$1
        @Override // com.bytedance.pia.core.api.utils.IFactory
        public final PiaMethod.ICall<CacheRemoveMethod.Params, CacheRemoveMethod.Result> create() {
            return new CacheRemoveMethod();
        }
    });

    public static final PiaMethod<Params, Result> getMethod() {
        return INSTANCE.getMethod();
    }

    /* compiled from: CacheRemoveMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/CacheRemoveMethod$Companion;", "", "()V", "CACHE_FAILED", "", "NAME", "method", "Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "Lcom/bytedance/pia/core/bridge/methods/CacheRemoveMethod$Params;", "Lcom/bytedance/pia/core/bridge/methods/CacheRemoveMethod$Result;", "getMethod$annotations", "getMethod", "()Lcom/bytedance/pia/core/api/bridge/PiaMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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
            return CacheRemoveMethod.method;
        }
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.ICall
    public /* bridge */ /* synthetic */ void invoke(IPiaBridge iPiaBridge, Params params, IConsumer<Result> iConsumer, IConsumer iConsumer2) {
        invoke2(iPiaBridge, params, iConsumer, (IConsumer<PiaMethod.Error>) iConsumer2);
    }

    /* compiled from: CacheRemoveMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/CacheRemoveMethod$Params;", "", "url", "", "extraVary", "", "(Ljava/lang/String;Ljava/util/List;)V", "getExtraVary", "()Ljava/util/List;", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Params {

        @SerializedName("extraVary")
        private final List<String> extraVary;

        @SerializedName("url")
        private final String url;

        /* JADX WARN: Multi-variable type inference failed */
        public Params() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Params copy$default(Params params, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.url;
            }
            if ((i & 2) != 0) {
                list = params.extraVary;
            }
            return params.copy(str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final List<String> component2() {
            return this.extraVary;
        }

        public final Params copy(String url, List<String> extraVary) {
            return new Params(url, extraVary);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return Intrinsics.areEqual(this.url, params.url) && Intrinsics.areEqual(this.extraVary, params.extraVary);
        }

        public int hashCode() {
            String str = this.url;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            List<String> list = this.extraVary;
            return hashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "Params(url=" + this.url + ", extraVary=" + this.extraVary + ')';
        }

        public Params(String str, List<String> list) {
            this.url = str;
            this.extraVary = list;
        }

        public /* synthetic */ Params(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : list);
        }

        public final String getUrl() {
            return this.url;
        }

        public final List<String> getExtraVary() {
            return this.extraVary;
        }
    }

    /* compiled from: CacheRemoveMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/CacheRemoveMethod$Result;", "", "delete", "", "(Z)V", "getDelete", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class Result {

        @SerializedName("delete")
        private final boolean delete;

        public static /* synthetic */ Result copy$default(Result result, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = result.delete;
            }
            return result.copy(z);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getDelete() {
            return this.delete;
        }

        public final Result copy(boolean delete) {
            return new Result(delete);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Result) && this.delete == ((Result) other).delete;
        }

        public int hashCode() {
            return Boolean.hashCode(this.delete);
        }

        public String toString() {
            return "Result(delete=" + this.delete + ')';
        }

        public Result(boolean z) {
            this.delete = z;
        }

        public final boolean getDelete() {
            return this.delete;
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(IPiaBridge bridge, Params params, final IConsumer<Result> resolve, final IConsumer<PiaMethod.Error> reject) {
        Object obj;
        Intrinsics.checkNotNullParameter(bridge, "bridge");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(resolve, "resolve");
        Intrinsics.checkNotNullParameter(reject, "reject");
        if (TextUtils.isEmpty(params.getUrl())) {
            reject.accept(new PiaMethod.InvalidParamsError("Parameter 'url' required!"));
            return;
        }
        try {
            Result.Companion companion = kotlin.Result.Companion;
            Uri parse = Uri.parse(params.getUrl());
            Intrinsics.checkNotNullExpressionValue(parse, "parse(params.url)");
            obj = kotlin.Result.constructor-impl(UrlUtils.compatV2(parse));
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.Companion;
            obj = kotlin.Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (kotlin.Result.exceptionOrNull-impl(obj) != null) {
            reject.accept(new PiaMethod.InvalidParamsError("Parameter 'url' invalid!"));
            return;
        }
        Uri uri = (Uri) obj;
        final String normalizeUrl$default = UrlUtils.normalizeUrl$default(uri, null, 2, null);
        String str = normalizeUrl$default;
        if (str == null || str.length() == 0) {
            reject.accept(new PiaMethod.InvalidParamsError("Parameter 'url' invalid!"));
            return;
        }
        final String normalizeUrl = UrlUtils.normalizeUrl(uri, params.getExtraVary());
        String str2 = normalizeUrl;
        if (str2 == null || str2.length() == 0) {
            reject.accept(new PiaMethod.InvalidParamsError("Parameter 'url' & 'extraVary' invalid!"));
        } else if (Intrinsics.areEqual(normalizeUrl$default, normalizeUrl)) {
            reject.accept(new PiaMethod.Error(ErrorCode.WORKER_SYNTAX_ERROR, "Can't modify the original html."));
        } else {
            ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.bridge.methods.CacheRemoveMethod$invoke$1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        if (!PIACacheManager.INSTANCE.getHasInit().get()) {
                            resolve.accept(new CacheRemoveMethod.Result(false));
                        } else {
                            Keva configRepo = PIACacheManager.getConfigRepo(normalizeUrl$default);
                            resolve.accept(new CacheRemoveMethod.Result(configRepo != null ? PIACacheManager.deleteWithNormalizeUrl(normalizeUrl, configRepo) : false));
                        }
                    } catch (Exception e) {
                        reject.accept(new PiaMethod.Error(CacheRemoveMethod.CACHE_FAILED + e.getMessage() + ')'));
                    }
                }
            });
        }
    }
}
