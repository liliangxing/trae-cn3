package com.bytedance.ruler.base.models;

import com.bytedance.ruler.base.interfaces.IEnv;
import com.google.gson.JsonObject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuleHardCodeModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ruler/base/models/RuleHardCodeModel;", "", "name", "", "executor", "Lkotlin/Function1;", "Lcom/bytedance/ruler/base/interfaces/IEnv;", "conf", "Lcom/google/gson/JsonObject;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lcom/google/gson/JsonObject;)V", "getConf", "()Lcom/google/gson/JsonObject;", "getExecutor", "()Lkotlin/jvm/functions/Function1;", "getName", "()Ljava/lang/String;", "ruleModel", "Lcom/bytedance/ruler/base/models/RuleModel;", "getRuleModel", "()Lcom/bytedance/ruler/base/models/RuleModel;", "ruleModel$delegate", "Lkotlin/Lazy;", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class RuleHardCodeModel {
    private final JsonObject conf;
    private final Function1<IEnv, Object> executor;
    private final String name;

    /* renamed from: ruleModel$delegate, reason: from kotlin metadata */
    private final Lazy ruleModel;

    public final RuleModel getRuleModel() {
        return (RuleModel) this.ruleModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RuleHardCodeModel(String name, Function1<? super IEnv, ? extends Object> executor, JsonObject conf) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(executor, "executor");
        Intrinsics.checkParameterIsNotNull(conf, "conf");
        this.name = name;
        this.executor = executor;
        this.conf = conf;
        this.ruleModel = LazyKt.lazy(new Function0<RuleModel>() { // from class: com.bytedance.ruler.base.models.RuleHardCodeModel$ruleModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RuleModel invoke() {
                return new RuleModel(null, RuleHardCodeModel.this.getConf(), null, RuleHardCodeModel.this.getName(), 5, null);
            }
        });
    }

    public final String getName() {
        return this.name;
    }

    public final Function1<IEnv, Object> getExecutor() {
        return this.executor;
    }

    public final JsonObject getConf() {
        return this.conf;
    }
}
