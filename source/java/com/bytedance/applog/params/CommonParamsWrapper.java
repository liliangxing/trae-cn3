package com.bytedance.applog.params;

import com.bytedance.applog.log.AbsSingleton;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.log.NativeLogWrapper;
import com.bytedance.applog.params.lifecycle.LifecycleValueObserver;
import com.bytedance.applog.priority.PriorityWrapper;
import com.bytedance.applog.sampling.EventSampling;
import com.bytedance.applog.server.Api;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonParamsWrapper.kt */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000*\u0001\r\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0017J\u0019\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0082 J#\u0010\u001d\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082 J!\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0082 J)\u0010!\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0082 J!\u0010$\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010%\u001a\u00020 H\u0082 J!\u0010&\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0004H\u0082 J\u0011\u0010(\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0004H\u0082 J!\u0010)\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0082 J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00130\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/applog/params/CommonParamsWrapper;", "Lcom/bytedance/applog/params/CommonParamsApi;", "Lcom/bytedance/applog/params/CommonParamsHelper;", "applogHashCode", "", "(Ljava/lang/String;)V", "bizCommonParamsApiMap", "Ljava/util/HashMap;", "Lcom/bytedance/applog/params/BizCommonParamsApi;", "Lkotlin/collections/HashMap;", "empty", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lazySoLoader", "com/bytedance/applog/params/CommonParamsWrapper$lazySoLoader$1", "Lcom/bytedance/applog/params/CommonParamsWrapper$lazySoLoader$1;", "loggerTag", "", "valueLifecycleObservers", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/applog/params/lifecycle/LifecycleValueObserver;", "destroy", "", "getBiz", "biz", "handleEvent", "event", "paramsJsonString", "nativeBizClear", "istHashCode", "nativeBizGet", Api.KEY_ENCRYPT_RESP_KEY, "nativeBizRemove", "", "nativeBizSet", "keyValueJsonString", "contextJsonString", "nativeBizSetCacheCapability", EventSampling.KEY_SAMPLING_CAPABILITY, "nativeHandleEvent", "params", "nativeInit", "nativeSetRuleConfig", "configJson", "setLogEnable", "enabled", "", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CommonParamsWrapper implements CommonParamsApi, CommonParamsHelper {
    private final String applogHashCode;
    private final HashMap<String, BizCommonParamsApi> bizCommonParamsApiMap;
    private final AtomicBoolean empty;
    private final CommonParamsWrapper$lazySoLoader$1 lazySoLoader;
    private final List<String> loggerTag;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, LifecycleValueObserver>> valueLifecycleObservers;

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeBizClear(String istHashCode, String biz);

    /* JADX INFO: Access modifiers changed from: private */
    public final native String nativeBizGet(String istHashCode, String biz, String key);

    /* JADX INFO: Access modifiers changed from: private */
    public final native int nativeBizRemove(String istHashCode, String biz, String key);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeBizSet(String istHashCode, String biz, String keyValueJsonString, String contextJsonString);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeBizSetCacheCapability(String istHashCode, String biz, int capability);

    private final native String nativeHandleEvent(String istHashCode, String event, String params);

    /* JADX INFO: Access modifiers changed from: private */
    public final native int nativeInit(String istHashCode);

    /* JADX INFO: Access modifiers changed from: private */
    public final native int nativeSetRuleConfig(String istHashCode, String biz, String configJson);

    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.applog.params.CommonParamsWrapper$lazySoLoader$1] */
    public CommonParamsWrapper(String str) {
        Intrinsics.checkNotNullParameter(str, "applogHashCode");
        this.applogHashCode = str;
        this.loggerTag = CollectionsKt.listOf("CommonParamsWrapper");
        this.empty = new AtomicBoolean(true);
        this.bizCommonParamsApiMap = new HashMap<>();
        this.valueLifecycleObservers = new ConcurrentHashMap<>();
        this.lazySoLoader = new AbsSingleton<Boolean>() { // from class: com.bytedance.applog.params.CommonParamsWrapper$lazySoLoader$1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.bytedance.applog.log.AbsSingleton
            public Boolean create(Object... params) {
                String str2;
                Intrinsics.checkNotNullParameter(params, "params");
                PriorityWrapper.nativeLoader.get(new Object[0]);
                CommonParamsWrapper commonParamsWrapper = CommonParamsWrapper.this;
                str2 = commonParamsWrapper.applogHashCode;
                commonParamsWrapper.nativeInit(str2);
                return true;
            }
        };
    }

    @Override // com.bytedance.applog.params.CommonParamsHelper
    public String handleEvent(String event, String paramsJsonString) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.empty.get()) {
            return "";
        }
        String str = this.applogHashCode;
        if (paramsJsonString == null) {
            paramsJsonString = "";
        }
        String nativeHandleEvent = nativeHandleEvent(str, event, paramsJsonString);
        if (nativeHandleEvent.length() > 0) {
            LoggerImpl.global().debug(this.loggerTag, "event:{} had append some params!!", event);
        }
        return nativeHandleEvent;
    }

    @Override // com.bytedance.applog.params.CommonParamsHelper
    public void setLogEnable(boolean enabled) {
        get(new Object[0]);
        NativeLogWrapper.setLogEnable(enabled);
    }

    @Override // com.bytedance.applog.params.CommonParamsHelper
    public synchronized void destroy() {
        LoggerImpl.global().debug(this.loggerTag, "start to destroy common params wrapper...", new Object[0]);
        if (!this.valueLifecycleObservers.isEmpty()) {
            int size = this.valueLifecycleObservers.size();
            Collection<ConcurrentHashMap<String, LifecycleValueObserver>> values = this.valueLifecycleObservers.values();
            Intrinsics.checkNotNullExpressionValue(values, "valueLifecycleObservers.values");
            Iterator<T> it = values.iterator();
            while (it.hasNext()) {
                Collection values2 = ((ConcurrentHashMap) it.next()).values();
                Intrinsics.checkNotNullExpressionValue(values2, "it.values");
                Iterator it2 = values2.iterator();
                while (it2.hasNext()) {
                    ((LifecycleValueObserver) it2.next()).destroy();
                }
            }
            this.valueLifecycleObservers.clear();
            LoggerImpl.global().debug(this.loggerTag, "{} lifecycle observers has been destroyed...", Integer.valueOf(size));
        }
        if (!this.bizCommonParamsApiMap.isEmpty()) {
            int size2 = this.bizCommonParamsApiMap.size();
            Iterator<Map.Entry<String, BizCommonParamsApi>> it3 = this.bizCommonParamsApiMap.entrySet().iterator();
            while (it3.hasNext()) {
                it3.next().getValue().clear();
            }
            this.bizCommonParamsApiMap.clear();
            LoggerImpl.global().debug(this.loggerTag, "{} biz params object has been cleared...", Integer.valueOf(size2));
        }
    }

    @Override // com.bytedance.applog.params.CommonParamsApi
    public BizCommonParamsApi getBiz(String biz) {
        Intrinsics.checkNotNullParameter(biz, "biz");
        HashMap<String, BizCommonParamsApi> hashMap = this.bizCommonParamsApiMap;
        CommonParamsWrapper$getBiz$1$1 commonParamsWrapper$getBiz$1$1 = hashMap.get(biz);
        if (commonParamsWrapper$getBiz$1$1 == null) {
            commonParamsWrapper$getBiz$1$1 = new CommonParamsWrapper$getBiz$1$1(this, biz);
            hashMap.put(biz, commonParamsWrapper$getBiz$1$1);
        }
        return commonParamsWrapper$getBiz$1$1;
    }
}
