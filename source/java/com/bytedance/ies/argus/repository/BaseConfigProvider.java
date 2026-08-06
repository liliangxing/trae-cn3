package com.bytedance.ies.argus.repository;

import com.bytedance.ies.argus.base.ArgusLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONObject;

/* compiled from: ArgusConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH&¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\u001a\u0010\u0012\u001a\u00020\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bJ\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/argus/repository/BaseConfigProvider;", "T", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "collectorRepo", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "lastConfigInfo", "Lcom/bytedance/ies/argus/repository/ConfigInfo;", "innerParse", "data", "Lorg/json/JSONObject;", "info", "(Lorg/json/JSONObject;Lcom/bytedance/ies/argus/repository/ConfigInfo;)Ljava/lang/Object;", "onConfigUpdate", "registerCollector", "collector", "shouldUpdate", "Lkotlin/Pair;", "", "", "updateInfo", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseConfigProvider<T> {
    private final CopyOnWriteArrayList<Function1<T, Unit>> collectorRepo;
    private ConfigInfo lastConfigInfo;
    private final CoroutineScope scope;

    public abstract T innerParse(JSONObject data, ConfigInfo info);

    public BaseConfigProvider(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.scope = coroutineScope;
        this.collectorRepo = new CopyOnWriteArrayList<>();
    }

    public final void registerCollector(Function1<? super T, Unit> collector) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        this.collectorRepo.add(collector);
    }

    public final void onConfigUpdate(JSONObject data, ConfigInfo info) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(info, "info");
        Pair<Boolean, String> shouldUpdate = shouldUpdate(info);
        boolean booleanValue = ((Boolean) shouldUpdate.component1()).booleanValue();
        String str = (String) shouldUpdate.component2();
        if (booleanValue) {
            T innerParse = innerParse(data, info);
            if (innerParse == null || !(!this.collectorRepo.isEmpty())) {
                return;
            }
            StateFlow asStateFlow = FlowKt.asStateFlow(StateFlowKt.MutableStateFlow(innerParse));
            Iterator<T> it = this.collectorRepo.iterator();
            while (it.hasNext()) {
                BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new BaseConfigProvider$onConfigUpdate$1$1(asStateFlow, (Function1) it.next(), null), 3, (Object) null);
            }
            return;
        }
        ArgusLog.i$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, "no need update " + getClass().getSimpleName() + ", " + str, null, 4, null);
    }

    private final Pair<Boolean, String> shouldUpdate(ConfigInfo updateInfo) {
        Pair<Boolean, String> pair;
        Long createTimeStamp = updateInfo.getCreateTimeStamp();
        ConfigInfo configInfo = this.lastConfigInfo;
        Long createTimeStamp2 = configInfo != null ? configInfo.getCreateTimeStamp() : null;
        if (createTimeStamp != null && Intrinsics.areEqual(createTimeStamp, createTimeStamp2)) {
            pair = new Pair<>(false, "timeStamp is same: " + createTimeStamp);
        } else {
            pair = new Pair<>(true, "");
        }
        this.lastConfigInfo = updateInfo;
        return pair;
    }
}
