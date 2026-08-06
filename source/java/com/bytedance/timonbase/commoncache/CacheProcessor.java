package com.bytedance.timonbase.commoncache;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.timonbase.commoncache.filter.ParametersFilter;
import com.bytedance.timonbase.commoncache.store.CacheStore;
import com.bytedance.timonbase.commoncache.strategy.CacheUpdateStrategy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bf\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012+\u0010\u0007\u001a'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00028\u0000`\r\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\f¢\u0006\u0002\u0010\u0013J\u0013\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00028\u0000¢\u0006\u0002\u0010'J\u0015\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00028\u0000¢\u0006\u0002\u0010)J%\u0010*\u001a\u00020+2\u0006\u0010&\u001a\u00028\u00002\b\u0010,\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u0011¢\u0006\u0002\u0010.R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R3\u0010\u0007\u001a'\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00028\u0000`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010$¨\u0006/"}, d2 = {"Lcom/bytedance/timonbase/commoncache/CacheProcessor;", ExifInterface.GPS_DIRECTION_TRUE, "", "cacheStrategy", "Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;", "cacheStore", "Lcom/bytedance/timonbase/commoncache/store/CacheStore;", "storeKeyGenerator", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "t", "", "Lcom/bytedance/timonbase/commoncache/store/StoreKeyGenerator;", "parametersFilter", "Lcom/bytedance/timonbase/commoncache/filter/ParametersFilter;", "needIntercept", "", "desc", "(Lcom/bytedance/timonbase/commoncache/strategy/CacheUpdateStrategy;Lcom/bytedance/timonbase/commoncache/store/CacheStore;Lkotlin/jvm/functions/Function1;Lcom/bytedance/timonbase/commoncache/filter/ParametersFilter;ZLjava/lang/String;)V", "appMode", "", "getAppMode", "()I", "setAppMode", "(I)V", "getDesc", "()Ljava/lang/String;", "getNeedIntercept", "()Z", "shieldCount", "getShieldCount", "setShieldCount", "suppress", "getSuppress", "setSuppress", "(Z)V", "needUpdate", "args", "(Ljava/lang/Object;)Z", "onGetCache", "(Ljava/lang/Object;)Ljava/lang/Object;", "onUpdateCache", "", "result", "isOriginalCalled", "(Ljava/lang/Object;Ljava/lang/Object;Z)V", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class CacheProcessor<T> {
    private int appMode;
    private final CacheStore cacheStore;
    private final CacheUpdateStrategy cacheStrategy;
    private final String desc;
    private final boolean needIntercept;
    private final ParametersFilter<T> parametersFilter;
    private int shieldCount;
    private final Function1<T, String> storeKeyGenerator;
    private boolean suppress;

    /* JADX WARN: Multi-variable type inference failed */
    public CacheProcessor(CacheUpdateStrategy cacheStrategy, CacheStore cacheStore, Function1<? super T, String> storeKeyGenerator, ParametersFilter<T> parametersFilter, boolean z, String desc) {
        Intrinsics.checkParameterIsNotNull(cacheStrategy, "cacheStrategy");
        Intrinsics.checkParameterIsNotNull(cacheStore, "cacheStore");
        Intrinsics.checkParameterIsNotNull(storeKeyGenerator, "storeKeyGenerator");
        Intrinsics.checkParameterIsNotNull(desc, "desc");
        this.cacheStrategy = cacheStrategy;
        this.cacheStore = cacheStore;
        this.storeKeyGenerator = storeKeyGenerator;
        this.parametersFilter = parametersFilter;
        this.needIntercept = z;
        this.desc = desc;
    }

    public final boolean getNeedIntercept() {
        return this.needIntercept;
    }

    public /* synthetic */ CacheProcessor(CacheUpdateStrategy cacheUpdateStrategy, CacheStore cacheStore, Function1 function1, ParametersFilter parametersFilter, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cacheUpdateStrategy, cacheStore, function1, parametersFilter, (i & 16) != 0 ? false : z, (i & 32) != 0 ? "" : str);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final boolean getSuppress() {
        return this.suppress;
    }

    public final void setSuppress(boolean z) {
        this.suppress = z;
    }

    public final int getAppMode() {
        return this.appMode;
    }

    public final void setAppMode(int i) {
        this.appMode = i;
    }

    public final int getShieldCount() {
        return this.shieldCount;
    }

    public final void setShieldCount(int i) {
        this.shieldCount = i;
    }

    public final boolean needUpdate(T args) {
        ParametersFilter<T> parametersFilter = this.parametersFilter;
        if (parametersFilter != null && !parametersFilter.shouldCache(args)) {
            return true;
        }
        boolean needUpdate = this.cacheStrategy.needUpdate(this.cacheStore, this.storeKeyGenerator.invoke(args));
        if (!needUpdate) {
            this.shieldCount++;
        }
        return needUpdate;
    }

    public final Object onGetCache(T args) {
        return this.cacheStore.get(this.storeKeyGenerator.invoke(args));
    }

    public final void onUpdateCache(T args, Object result, boolean isOriginalCalled) {
        ParametersFilter<T> parametersFilter = this.parametersFilter;
        if (parametersFilter == null || parametersFilter.shouldCache(args)) {
            this.cacheStore.put(this.storeKeyGenerator.invoke(args), result);
        }
    }
}
