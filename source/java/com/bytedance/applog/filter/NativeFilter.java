package com.bytedance.applog.filter;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.log.AbsSingleton;
import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.priority.PriorityWrapper;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: NativeFilter.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0018\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t\u0012<\u0010\n\u001a8\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u000bj \u0012\u0004\u0012\u00020\b\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0018\u0001`\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u001c\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0014J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0014J$\u0010\u001f\u001a\u00020\u00122\u0010\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\"\u001a\u00020\u0012H\u0016R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/applog/filter/NativeFilter;", "Lcom/bytedance/applog/filter/AbstractEventFilter;", "appLogInstance", "Lcom/bytedance/applog/AppLogInstance;", "config", "Lorg/json/JSONObject;", "eventSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Lcom/bytedance/applog/AppLogInstance;Lorg/json/JSONObject;Ljava/util/HashSet;Ljava/util/HashMap;)V", "appId", "getAppId", "()Ljava/lang/String;", "hasFilter", "", "getHasFilter", "()Z", "setHasFilter", "(Z)V", "lazySoLoader", "com/bytedance/applog/filter/NativeFilter$lazySoLoader$1", "Lcom/bytedance/applog/filter/NativeFilter$lazySoLoader$1;", "clearCache", "", ReportConst.ReportCheck.FILTER, "eventName", "interceptEventName", "interceptEventParam", "filterParamSet", "param", "noFilter", "agent_chinaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class NativeFilter extends AbstractEventFilter {
    private final String appId;
    private boolean hasFilter;
    private final NativeFilter$lazySoLoader$1 lazySoLoader;

    @Override // com.bytedance.applog.filter.AbstractEventFilter
    protected boolean interceptEventName(String eventName) {
        return false;
    }

    @Override // com.bytedance.applog.filter.AbstractEventFilter
    protected boolean interceptEventParam(HashSet<String> filterParamSet, String param) {
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.applog.filter.NativeFilter$lazySoLoader$1] */
    public NativeFilter(final AppLogInstance appLogInstance, final JSONObject jSONObject, HashSet<String> hashSet, HashMap<String, HashSet<String>> hashMap) {
        super(appLogInstance, hashSet, hashMap);
        Intrinsics.checkNotNullParameter(appLogInstance, "appLogInstance");
        String appId = appLogInstance.getAppId();
        this.appId = appId == null ? "" : appId;
        ?? r4 = new AbsSingleton<Boolean>() { // from class: com.bytedance.applog.filter.NativeFilter$lazySoLoader$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.applog.log.AbsSingleton
            public Boolean create(Object... params) {
                Intrinsics.checkNotNullParameter(params, "params");
                PriorityWrapper.nativeLoader.get(new Object[0]);
                if (AppLogInstance.this.isLogEnabled()) {
                    NativeLogWrapper.setLogEnable(true);
                }
                if (PriorityWrapper.RETURN_SUCCESS == NativeFilterJNI.nativeInitServerFilter(this.getAppId(), AppLogInstance.this.getContext().getFilesDir().getAbsolutePath())) {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 != null) {
                        NativeFilterJNI.nativeSetServerFilterConfig(this.getAppId(), jSONObject2.toString());
                    }
                    this.setHasFilter(!NativeFilterJNI.nativeIsServerFilterEmpty(r4.getAppId()));
                }
                return true;
            }
        };
        this.lazySoLoader = r4;
        r4.get(new Object[0]);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final boolean getHasFilter() {
        return this.hasFilter;
    }

    public final void setHasFilter(boolean z) {
        this.hasFilter = z;
    }

    @Override // com.bytedance.applog.filter.AbstractEventFilter
    protected boolean filter(String eventName, String params) {
        if (!this.hasFilter) {
            return true;
        }
        String str = this.appId;
        if (eventName == null) {
            eventName = "";
        }
        return NativeFilterJNI.nativeIsEventAllowed(str, eventName);
    }

    @Override // com.bytedance.applog.filter.IEventFilter
    public boolean noFilter() {
        return !this.hasFilter;
    }

    public final void clearCache() {
        NativeFilterJNI.nativeClearCache(this.appId);
        this.hasFilter = false;
    }
}
