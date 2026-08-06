package com.bytedance.trae.conversation.network;

import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IRemoteModelsApi.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion$preloadOnAppStart$2", f = "IRemoteModelsApi.kt", i = {0, 0, 1, 2, 2, 2, 2, 2, 2}, l = {204, 210, 228}, m = "invokeSuspend", n = {"$this$withContext", "functions", "$this$withContext", "$this$withContext", "clis", "functionMap", "cli", "cliId", "functions"}, s = {"L$0", "L$3", "L$0", "L$0", "L$1", "L$2", "L$5", "L$6", "L$8"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class IRemoteModelsApi$Companion$preloadOnAppStart$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $trigger;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IRemoteModelsApi$Companion$preloadOnAppStart$2(String str, Continuation<? super IRemoteModelsApi$Companion$preloadOnAppStart$2> continuation) {
        super(2, continuation);
        this.$trigger = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> iRemoteModelsApi$Companion$preloadOnAppStart$2 = new IRemoteModelsApi$Companion$preloadOnAppStart$2(this.$trigger, continuation);
        iRemoteModelsApi$Companion$preloadOnAppStart$2.L$0 = obj;
        return iRemoteModelsApi$Companion$preloadOnAppStart$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:114|(3:115|116|117)|118|119|120|(1:122)|123|124|(4:126|127|128|(1:130)(8:131|118|119|120|(0)|123|124|(12:136|137|(1:139)|85|86|(0)|89|(1:90)|106|107|41|(0)(0))(0)))(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:18|(1:19)|20|(1:22)(1:35)|23|24|25|26|(1:28)(8:30|10|11|12|(0)(0)|15|16|(4:39|40|41|(4:51|(3:58|(4:61|(3:66|67|68)|69|59)|72)(1:55)|56|57)(7:43|(1:45)|46|(3:50|16|(0)(0))|40|41|(0)(0)))(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:6|(3:7|8|9)|10|11|12|(1:14)(1:73)|15|16|(9:18|19|20|(1:22)(1:35)|23|24|25|26|(1:28)(8:30|10|11|12|(0)(0)|15|16|(4:39|40|41|(4:51|(3:58|(4:61|(3:66|67|68)|69|59)|72)(1:55)|56|57)(7:43|(1:45)|46|(3:50|16|(0)(0))|40|41|(0)(0)))(0)))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0110, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x02da, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x02de, code lost:
    
        r25 = r6;
        r6 = r4;
        r4 = r12;
        r12 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02d8, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01eb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x0104 -> B:106:0x0109). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:123:0x0118 -> B:108:0x0122). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x02cb -> B:10:0x02d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x02e4 -> B:12:0x02ee). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x024c -> B:40:0x0330). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0258 -> B:40:0x0330). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x025c -> B:16:0x0268). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IRemoteModelsApi$Companion$preloadOnAppStart$2 iRemoteModelsApi$Companion$preloadOnAppStart$2;
        String str;
        Iterator it;
        CoroutineScope coroutineScope;
        CoroutineScope coroutineScope2;
        Throwable th;
        Object obj2;
        Object clis;
        Object fetchModelsForUi;
        Throwable th2;
        Throwable th3;
        Object obj3;
        Throwable th4;
        List list;
        Map mapOf;
        String str2;
        Iterator it2;
        int i;
        List list2;
        IRemoteModelsApi$Companion$preloadOnAppStart$2 iRemoteModelsApi$Companion$preloadOnAppStart$22;
        Throwable th5;
        Object obj4;
        Object fetchPcModelsForUi;
        Throwable th6;
        Object obj5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            TraeLogUtil.INSTANCE.i("IRemoteModelsApi", "preloadOnAppStart: start, trigger=" + this.$trigger);
            List listOf = CollectionsKt.listOf(new List[]{CollectionsKt.listOf("solo_agent_remote"), CollectionsKt.listOf("solo_work_remote")});
            iRemoteModelsApi$Companion$preloadOnAppStart$2 = this;
            str = this.$trigger;
            it = listOf.iterator();
            coroutineScope = coroutineScope3;
            if (!it.hasNext()) {
            }
        } else if (i2 == 1) {
            List<String> list3 = (List) this.L$3;
            it = (Iterator) this.L$2;
            str = (String) this.L$1;
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                fetchModelsForUi = obj;
                coroutineScope2 = coroutineScope4;
                iRemoteModelsApi$Companion$preloadOnAppStart$2 = this;
            } catch (Throwable th7) {
                th = th7;
                coroutineScope2 = coroutineScope4;
                iRemoteModelsApi$Companion$preloadOnAppStart$2 = this;
                Result.Companion companion = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                }
                coroutineScope = coroutineScope2;
                if (!it.hasNext()) {
                }
            }
            obj2 = Result.constructor-impl((List) fetchModelsForUi);
            th2 = Result.exceptionOrNull-impl(obj2);
            if (th2 != null) {
                TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "preloadOnAppStart: remote preload failed, trigger=" + str + ", functions=" + list3, th2);
            }
            coroutineScope = coroutineScope2;
            if (!it.hasNext()) {
                List<String> list4 = (List) it.next();
                try {
                } catch (Throwable th8) {
                    th = th8;
                    coroutineScope2 = coroutineScope;
                    list3 = list4;
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    th2 = Result.exceptionOrNull-impl(obj2);
                    if (th2 != null) {
                    }
                    coroutineScope = coroutineScope2;
                    if (!it.hasNext()) {
                    }
                }
                Result.Companion companion3 = Result.Companion;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$0 = coroutineScope;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$1 = str;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$2 = it;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$3 = list4;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.label = 1;
                fetchModelsForUi = IRemoteModelsApi.Companion.$$INSTANCE.fetchModelsForUi(list4, str + "_remote", iRemoteModelsApi$Companion$preloadOnAppStart$2);
                if (fetchModelsForUi == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope2 = coroutineScope;
                list3 = list4;
                obj2 = Result.constructor-impl((List) fetchModelsForUi);
                th2 = Result.exceptionOrNull-impl(obj2);
                if (th2 != null) {
                }
                coroutineScope = coroutineScope2;
                if (!it.hasNext()) {
                    try {
                        Result.Companion companion4 = Result.Companion;
                        CliListRepository companion5 = CliListRepository.INSTANCE.getInstance();
                        iRemoteModelsApi$Companion$preloadOnAppStart$2.L$0 = coroutineScope;
                        iRemoteModelsApi$Companion$preloadOnAppStart$2.L$1 = null;
                        iRemoteModelsApi$Companion$preloadOnAppStart$2.L$2 = null;
                        iRemoteModelsApi$Companion$preloadOnAppStart$2.L$3 = null;
                        iRemoteModelsApi$Companion$preloadOnAppStart$2.label = 2;
                        clis = companion5.getClis(iRemoteModelsApi$Companion$preloadOnAppStart$2);
                        if (clis == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj3 = Result.constructor-impl((List) clis);
                    } catch (Throwable th9) {
                        th3 = th9;
                        Result.Companion companion6 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
                        String str3 = iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger;
                        th4 = Result.exceptionOrNull-impl(obj3);
                        if (th4 != null) {
                        }
                        list = (List) obj3;
                        mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to(CliType.LOCAL.getValue(), CollectionsKt.listOf(new List[]{CollectionsKt.listOf("solo_agent_lite"), CollectionsKt.listOf("solo_work_lite")})), TuplesKt.to(CliType.IDE.getValue(), CollectionsKt.listOf(CollectionsKt.listOf("solo_agent")))});
                        ArrayList arrayList = new ArrayList();
                        while (r6.hasNext()) {
                        }
                        str2 = iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger;
                        it2 = arrayList.iterator();
                        if (it2.hasNext()) {
                        }
                    }
                    String str32 = iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger;
                    th4 = Result.exceptionOrNull-impl(obj3);
                    if (th4 != null) {
                    }
                    list = (List) obj3;
                    mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to(CliType.LOCAL.getValue(), CollectionsKt.listOf(new List[]{CollectionsKt.listOf("solo_agent_lite"), CollectionsKt.listOf("solo_work_lite")})), TuplesKt.to(CliType.IDE.getValue(), CollectionsKt.listOf(CollectionsKt.listOf("solo_agent")))});
                    ArrayList arrayList2 = new ArrayList();
                    while (r6.hasNext()) {
                    }
                    str2 = iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger;
                    it2 = arrayList2.iterator();
                    if (it2.hasNext()) {
                    }
                }
            }
        } else if (i2 == 2) {
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                clis = obj;
                iRemoteModelsApi$Companion$preloadOnAppStart$2 = this;
                obj3 = Result.constructor-impl((List) clis);
            } catch (Throwable th10) {
                th3 = th10;
                iRemoteModelsApi$Companion$preloadOnAppStart$2 = this;
                Result.Companion companion62 = Result.Companion;
                obj3 = Result.constructor-impl(ResultKt.createFailure(th3));
                String str322 = iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger;
                th4 = Result.exceptionOrNull-impl(obj3);
                if (th4 != null) {
                }
                list = (List) obj3;
                mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to(CliType.LOCAL.getValue(), CollectionsKt.listOf(new List[]{CollectionsKt.listOf("solo_agent_lite"), CollectionsKt.listOf("solo_work_lite")})), TuplesKt.to(CliType.IDE.getValue(), CollectionsKt.listOf(CollectionsKt.listOf("solo_agent")))});
                ArrayList arrayList22 = new ArrayList();
                while (r6.hasNext()) {
                }
                str2 = iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger;
                it2 = arrayList22.iterator();
                if (it2.hasNext()) {
                }
            }
            String str3222 = iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger;
            th4 = Result.exceptionOrNull-impl(obj3);
            if (th4 != null) {
                TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "preloadOnAppStart: list clis failed, trigger=" + str3222, th4);
                obj3 = CollectionsKt.emptyList();
            }
            list = (List) obj3;
            mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to(CliType.LOCAL.getValue(), CollectionsKt.listOf(new List[]{CollectionsKt.listOf("solo_agent_lite"), CollectionsKt.listOf("solo_work_lite")})), TuplesKt.to(CliType.IDE.getValue(), CollectionsKt.listOf(CollectionsKt.listOf("solo_agent")))});
            ArrayList arrayList222 = new ArrayList();
            for (Object obj6 : list) {
                Cli cli = (Cli) obj6;
                if ((Intrinsics.areEqual(cli.getType(), CliType.LOCAL.getValue()) || Intrinsics.areEqual(cli.getType(), CliType.IDE.getValue())) && Intrinsics.areEqual(cli.getStatus(), "online")) {
                    arrayList222.add(obj6);
                }
            }
            str2 = iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger;
            it2 = arrayList222.iterator();
            if (it2.hasNext()) {
            }
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List<String> list5 = (List) this.L$8;
            Iterator it3 = (Iterator) this.L$7;
            String str4 = (String) this.L$6;
            Cli cli2 = (Cli) this.L$5;
            Iterator it4 = (Iterator) this.L$4;
            String str5 = (String) this.L$3;
            Map map = (Map) this.L$2;
            List list6 = (List) this.L$1;
            CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                fetchPcModelsForUi = obj;
                iRemoteModelsApi$Companion$preloadOnAppStart$22 = this;
            } catch (Throwable th11) {
                th5 = th11;
                iRemoteModelsApi$Companion$preloadOnAppStart$22 = this;
                Result.Companion companion7 = Result.Companion;
                obj4 = Result.constructor-impl(ResultKt.createFailure(th5));
                String str6 = str5;
                iRemoteModelsApi$Companion$preloadOnAppStart$2 = iRemoteModelsApi$Companion$preloadOnAppStart$22;
                List<String> list7 = list5;
                str2 = str6;
                th6 = Result.exceptionOrNull-impl(obj4);
                if (th6 != null) {
                }
                coroutine_suspended = obj5;
                if (!it3.hasNext()) {
                }
            }
            obj4 = Result.constructor-impl((List) fetchPcModelsForUi);
            String str62 = str5;
            iRemoteModelsApi$Companion$preloadOnAppStart$2 = iRemoteModelsApi$Companion$preloadOnAppStart$22;
            List<String> list72 = list5;
            str2 = str62;
            th6 = Result.exceptionOrNull-impl(obj4);
            if (th6 != null) {
                obj5 = coroutine_suspended;
                TraeLogUtil.INSTANCE.w("IRemoteModelsApi", "preloadOnAppStart: pc preload failed, trigger=" + str2 + ", cliId=" + str4 + ", functions=" + list72, th6);
            } else {
                obj5 = coroutine_suspended;
            }
            coroutine_suspended = obj5;
            if (!it3.hasNext()) {
                List<String> list8 = (List) it3.next();
                try {
                } catch (Throwable th12) {
                    th5 = th12;
                }
                Result.Companion companion8 = Result.Companion;
                IRemoteModelsApi.Companion companion9 = IRemoteModelsApi.Companion.$$INSTANCE;
                String ideVersion = cli2.getIdeVersion();
                CliType cliType = Intrinsics.areEqual(cli2.getType(), CliType.IDE.getValue()) ? CliType.IDE : CliType.LOCAL;
                String str7 = str2 + "_pc";
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$0 = coroutineScope5;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$1 = list6;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$2 = map;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$3 = str2;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$4 = it4;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$5 = cli2;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$6 = str4;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$7 = it3;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.L$8 = list8;
                iRemoteModelsApi$Companion$preloadOnAppStart$2.label = 3;
                fetchPcModelsForUi = companion9.fetchPcModelsForUi(str4, list8, true, ideVersion, str7, cliType, iRemoteModelsApi$Companion$preloadOnAppStart$2);
                if (fetchPcModelsForUi == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str8 = str2;
                list5 = list8;
                iRemoteModelsApi$Companion$preloadOnAppStart$22 = iRemoteModelsApi$Companion$preloadOnAppStart$2;
                str5 = str8;
                obj4 = Result.constructor-impl((List) fetchPcModelsForUi);
                String str622 = str5;
                iRemoteModelsApi$Companion$preloadOnAppStart$2 = iRemoteModelsApi$Companion$preloadOnAppStart$22;
                List<String> list722 = list5;
                str2 = str622;
                th6 = Result.exceptionOrNull-impl(obj4);
                if (th6 != null) {
                }
                coroutine_suspended = obj5;
                if (!it3.hasNext()) {
                    it2 = it4;
                    mapOf = map;
                    list = list6;
                    coroutineScope = coroutineScope5;
                    if (it2.hasNext()) {
                        cli2 = (Cli) it2.next();
                        String id = cli2.getId();
                        if (id == null) {
                            id = "";
                        }
                        if (!StringsKt.isBlank(id) && (list2 = (List) mapOf.get(cli2.getType())) != null) {
                            list6 = list;
                            coroutineScope5 = coroutineScope;
                            str4 = id;
                            it4 = it2;
                            it3 = list2.iterator();
                            map = mapOf;
                            if (!it3.hasNext()) {
                            }
                        }
                        if (it2.hasNext()) {
                        }
                    } else {
                        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                        StringBuilder append = new StringBuilder("preloadOnAppStart: end, trigger=").append(iRemoteModelsApi$Companion$preloadOnAppStart$2.$trigger).append(", localCliCount=");
                        List list9 = list;
                        if ((list9 instanceof Collection) && list9.isEmpty()) {
                            i = 0;
                        } else {
                            Iterator it5 = list9.iterator();
                            i = 0;
                            while (it5.hasNext()) {
                                if (Intrinsics.areEqual(((Cli) it5.next()).getType(), "local") && (i = i + 1) < 0) {
                                    CollectionsKt.throwCountOverflow();
                                }
                            }
                        }
                        traeLogUtil.i("IRemoteModelsApi", append.append(i).toString());
                        return Unit.INSTANCE;
                    }
                }
            }
        }
    }
}
