package com.bytedance.applog.params;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.params.lifecycle.LifecycleValueObserver;
import com.bytedance.applog.sampling.EventSampling;
import com.bytedance.applog.server.Api;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: CommonParamsWrapper.kt */
@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\tH\u0016J \u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J4\u0010\u0018\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"com/bytedance/applog/params/CommonParamsWrapper$getBiz$1$1", "Lcom/bytedance/applog/params/BizCommonParamsApi;", "lifecycleEnabled", "", "clear", "", "get", "", Api.KEY_ENCRYPT_RESP_KEY, "", "invokeNativeSetRuleConfig", "configJsonString", "remove", "set", "value", "context", "", "setCacheCapability", EventSampling.KEY_SAMPLING_CAPABILITY, "", "setLifecycleEnable", "enable", "setRuleConfig", "configJsonArray", "setWithLifecycle", "valueLifecycle", "Landroidx/lifecycle/LifecycleOwner;", "params_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CommonParamsWrapper$getBiz$1$1 implements BizCommonParamsApi {
    final /* synthetic */ String $biz;
    private boolean lifecycleEnabled = true;
    final /* synthetic */ CommonParamsWrapper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CommonParamsWrapper$getBiz$1$1(CommonParamsWrapper commonParamsWrapper, String str) {
        this.this$0 = commonParamsWrapper;
        this.$biz = str;
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void set(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        set(key, value, MapsKt.emptyMap());
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void set(String key, Object value, Map<String, ? extends Object> context) {
        CommonParamsWrapper$lazySoLoader$1 commonParamsWrapper$lazySoLoader$1;
        String str;
        String str2;
        AtomicBoolean atomicBoolean;
        List<String> list;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        remove(key);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(key, value);
        commonParamsWrapper$lazySoLoader$1 = this.this$0.lazySoLoader;
        commonParamsWrapper$lazySoLoader$1.get(new Object[0]);
        JSONObject jSONObject2 = context.isEmpty() ^ true ? new JSONObject(context) : null;
        CommonParamsWrapper commonParamsWrapper = this.this$0;
        str = commonParamsWrapper.applogHashCode;
        String str3 = this.$biz;
        String jSONObject3 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.toString()");
        if (jSONObject2 == null || (str2 = jSONObject2.toString()) == null) {
            str2 = "";
        }
        commonParamsWrapper.nativeBizSet(str, str3, jSONObject3, str2);
        atomicBoolean = this.this$0.empty;
        atomicBoolean.set(false);
        IAppLogLogger global = LoggerImpl.global();
        list = this.this$0.loggerTag;
        global.debug(list, "biz:{} add param:{} success!", this.$biz, key);
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void setWithLifecycle(String key, Object value, LifecycleOwner valueLifecycle) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(valueLifecycle, "valueLifecycle");
        setWithLifecycle(key, value, MapsKt.emptyMap(), valueLifecycle);
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void setWithLifecycle(final String key, Object value, Map<String, ? extends Object> context, LifecycleOwner valueLifecycle) {
        ConcurrentHashMap concurrentHashMap;
        List<String> list;
        Object putIfAbsent;
        List<String> list2;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(valueLifecycle, "valueLifecycle");
        if (this.lifecycleEnabled) {
            concurrentHashMap = this.this$0.valueLifecycleObservers;
            ConcurrentHashMap concurrentHashMap2 = concurrentHashMap;
            String str = this.$biz;
            Object obj = concurrentHashMap2.get(str);
            if (obj == null && (putIfAbsent = concurrentHashMap2.putIfAbsent(str, (obj = new ConcurrentHashMap()))) != null) {
                obj = putIfAbsent;
            }
            ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) obj;
            if (concurrentHashMap3.contains(key)) {
                remove(key);
            }
            set(key, value, context);
            IAppLogLogger global = LoggerImpl.global();
            list = this.this$0.loggerTag;
            global.info(list, "biz:{} add param:{} with lifecycle success!", this.$biz, key);
            return;
        }
        IAppLogLogger global2 = LoggerImpl.global();
        list2 = this.this$0.loggerTag;
        global2.info(list2, "biz:{} params lifecycle disabled!", this.$biz, key);
        set(key, value, context);
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void remove(String key) {
        AtomicBoolean atomicBoolean;
        CommonParamsWrapper$lazySoLoader$1 commonParamsWrapper$lazySoLoader$1;
        String str;
        ConcurrentHashMap concurrentHashMap;
        List<String> list;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        atomicBoolean = this.this$0.empty;
        if (atomicBoolean.get()) {
            return;
        }
        commonParamsWrapper$lazySoLoader$1 = this.this$0.lazySoLoader;
        commonParamsWrapper$lazySoLoader$1.get(new Object[0]);
        CommonParamsWrapper commonParamsWrapper = this.this$0;
        str = commonParamsWrapper.applogHashCode;
        commonParamsWrapper.nativeBizRemove(str, this.$biz, key);
        concurrentHashMap = this.this$0.valueLifecycleObservers;
        ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) concurrentHashMap.get(this.$biz);
        if (concurrentHashMap2 != null) {
            LifecycleValueObserver lifecycleValueObserver = (LifecycleValueObserver) concurrentHashMap2.get(key);
            if (lifecycleValueObserver != null) {
                lifecycleValueObserver.destroy();
            }
        }
        IAppLogLogger global = LoggerImpl.global();
        list = this.this$0.loggerTag;
        global.debug(list, "biz:{} removed param:{} success!", this.$biz, key);
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public Object get(String key) {
        AtomicBoolean atomicBoolean;
        CommonParamsWrapper$lazySoLoader$1 commonParamsWrapper$lazySoLoader$1;
        String str;
        String nativeBizGet;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        atomicBoolean = this.this$0.empty;
        if (atomicBoolean.get()) {
            return null;
        }
        commonParamsWrapper$lazySoLoader$1 = this.this$0.lazySoLoader;
        commonParamsWrapper$lazySoLoader$1.get(new Object[0]);
        CommonParamsWrapper commonParamsWrapper = this.this$0;
        str = commonParamsWrapper.applogHashCode;
        nativeBizGet = commonParamsWrapper.nativeBizGet(str, this.$biz, key);
        if (nativeBizGet != null) {
            if (nativeBizGet.length() > 0) {
                try {
                    return new JSONObject(nativeBizGet).opt(key);
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void setRuleConfig(final String configJsonArray) {
        Intrinsics.checkNotNullParameter(configJsonArray, "configJsonArray");
        UtilsKt.noMainThreadRun(new Function0<Unit>() { // from class: com.bytedance.applog.params.CommonParamsWrapper$getBiz$1$1$setRuleConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m422invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m422invoke() {
                CommonParamsWrapper$getBiz$1$1.this.invokeNativeSetRuleConfig(configJsonArray);
            }
        });
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void setCacheCapability(int capability) {
        CommonParamsWrapper$lazySoLoader$1 commonParamsWrapper$lazySoLoader$1;
        String str;
        List<String> list;
        commonParamsWrapper$lazySoLoader$1 = this.this$0.lazySoLoader;
        commonParamsWrapper$lazySoLoader$1.get(new Object[0]);
        CommonParamsWrapper commonParamsWrapper = this.this$0;
        str = commonParamsWrapper.applogHashCode;
        commonParamsWrapper.nativeBizSetCacheCapability(str, this.$biz, capability);
        IAppLogLogger global = LoggerImpl.global();
        list = this.this$0.loggerTag;
        global.debug(list, "biz:{} set capability to: {} success!", this.$biz, Integer.valueOf(capability));
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void setLifecycleEnable(boolean enable) {
        this.lifecycleEnabled = enable;
    }

    @Override // com.bytedance.applog.params.BizCommonParamsApi
    public void clear() {
        CommonParamsWrapper$lazySoLoader$1 commonParamsWrapper$lazySoLoader$1;
        String str;
        List<String> list;
        commonParamsWrapper$lazySoLoader$1 = this.this$0.lazySoLoader;
        commonParamsWrapper$lazySoLoader$1.get(new Object[0]);
        CommonParamsWrapper commonParamsWrapper = this.this$0;
        str = commonParamsWrapper.applogHashCode;
        commonParamsWrapper.nativeBizClear(str, this.$biz);
        IAppLogLogger global = LoggerImpl.global();
        list = this.this$0.loggerTag;
        global.debug(list, "biz:{} clear params success!", this.$biz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invokeNativeSetRuleConfig(String configJsonString) {
        CommonParamsWrapper$lazySoLoader$1 commonParamsWrapper$lazySoLoader$1;
        List<String> list;
        String str;
        AtomicBoolean atomicBoolean;
        List<String> list2;
        List<String> list3;
        commonParamsWrapper$lazySoLoader$1 = this.this$0.lazySoLoader;
        commonParamsWrapper$lazySoLoader$1.get(new Object[0]);
        if (configJsonString.length() == 0) {
            IAppLogLogger global = LoggerImpl.global();
            list3 = this.this$0.loggerTag;
            global.error(list3, "biz:{} setRuleConfig json empty!", this.$biz);
        } else {
            if (!StringsKt.startsWith$default(configJsonString, "[", false, 2, (Object) null) || !StringsKt.endsWith$default(configJsonString, "]", false, 2, (Object) null)) {
                IAppLogLogger global2 = LoggerImpl.global();
                list = this.this$0.loggerTag;
                global2.error(list, "biz:{} setRuleConfig json: {} is invalid (not a json array)!", this.$biz, configJsonString);
                return;
            }
            CommonParamsWrapper commonParamsWrapper = this.this$0;
            str = commonParamsWrapper.applogHashCode;
            commonParamsWrapper.nativeSetRuleConfig(str, this.$biz, configJsonString);
            atomicBoolean = this.this$0.empty;
            atomicBoolean.set(false);
            IAppLogLogger global3 = LoggerImpl.global();
            list2 = this.this$0.loggerTag;
            global3.debug(list2, "biz:{} setRuleConfig: {} success!", this.$biz, configJsonString);
        }
    }
}
