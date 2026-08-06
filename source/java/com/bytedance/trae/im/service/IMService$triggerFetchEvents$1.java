package com.bytedance.trae.im.service;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.im.service.IMService$triggerFetchEvents$1", f = "IMService.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {485, 498}, m = "invokeSuspend", n = {"allEvents", "fromSeqNum", "pageCount", "maxPages", "toSeqNum", "allEvents", "fromSeqNum", "pageCount", "maxPages"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IMService$triggerFetchEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $taskId;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMService$triggerFetchEvents$1(String str, String str2, Continuation<? super IMService$triggerFetchEvents$1> continuation) {
        super(2, continuation);
        this.$taskId = str;
        this.$conversationId = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMService$triggerFetchEvents$1(this.$taskId, this.$conversationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0063  */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00d6 -> B:6:0x0021). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        Ref.IntRef intRef;
        int i;
        int i2;
        IMService$triggerFetchEvents$1 iMService$triggerFetchEvents$1;
        CoroutineScope coroutineScope;
        ConcurrentHashMap concurrentHashMap;
        Object obj2;
        int i3;
        ArrayList arrayList2;
        Ref.IntRef intRef2;
        int i4;
        int i5;
        HttpDataResult.Success success;
        ArrayList arrayList3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            arrayList = new ArrayList();
            intRef = new Ref.IntRef();
            i = 0;
            i2 = 20;
            iMService$triggerFetchEvents$1 = this;
            if (i < i2) {
            }
            coroutineScope = IMService.ioScope;
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C08661(arrayList, iMService$triggerFetchEvents$1.$taskId, iMService$triggerFetchEvents$1.$conversationId, null), 3, (Object) null);
            concurrentHashMap = IMService.pollingJobs;
            concurrentHashMap.remove(iMService$triggerFetchEvents$1.$taskId);
            return Unit.INSTANCE;
        }
        if (i6 == 1) {
            int i7 = this.I$2;
            int i8 = this.I$1;
            int i9 = this.I$0;
            Ref.IntRef intRef3 = (Ref.IntRef) this.L$1;
            ?? r9 = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            i3 = i7;
            i5 = i8;
            i4 = i9;
            intRef2 = intRef3;
            arrayList2 = r9;
            iMService$triggerFetchEvents$1 = this;
            success = (HttpDataResult) obj2;
            if (success instanceof HttpDataResult.Success) {
            }
            intRef2.element = i3;
            iMService$triggerFetchEvents$1.L$0 = arrayList2;
            iMService$triggerFetchEvents$1.L$1 = intRef2;
            iMService$triggerFetchEvents$1.I$0 = i4;
            iMService$triggerFetchEvents$1.I$1 = i5;
            iMService$triggerFetchEvents$1.label = 2;
            arrayList3 = arrayList2;
            if (DelayKt.delay(50L, (Continuation) iMService$triggerFetchEvents$1) == coroutine_suspended) {
            }
            ArrayList arrayList4 = arrayList3;
            i2 = i5;
            arrayList = arrayList4;
            Ref.IntRef intRef4 = intRef2;
            i = i4;
            intRef = intRef4;
            if (i < i2) {
            }
            coroutineScope = IMService.ioScope;
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C08661(arrayList, iMService$triggerFetchEvents$1.$taskId, iMService$triggerFetchEvents$1.$conversationId, null), 3, (Object) null);
            concurrentHashMap = IMService.pollingJobs;
            concurrentHashMap.remove(iMService$triggerFetchEvents$1.$taskId);
            return Unit.INSTANCE;
        }
        if (i6 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i5 = this.I$1;
        i4 = this.I$0;
        intRef2 = (Ref.IntRef) this.L$1;
        ?? r8 = (List) this.L$0;
        ResultKt.throwOnFailure(obj);
        iMService$triggerFetchEvents$1 = this;
        arrayList3 = r8;
        ArrayList arrayList42 = arrayList3;
        i2 = i5;
        arrayList = arrayList42;
        Ref.IntRef intRef42 = intRef2;
        i = i4;
        intRef = intRef42;
        if (i < i2) {
            int i10 = i + 1;
            i3 = intRef.element + FConstants.URI_FAIL_CODE;
            iMService$triggerFetchEvents$1.L$0 = arrayList;
            iMService$triggerFetchEvents$1.L$1 = intRef;
            iMService$triggerFetchEvents$1.I$0 = i10;
            iMService$triggerFetchEvents$1.I$1 = i2;
            iMService$triggerFetchEvents$1.I$2 = i3;
            iMService$triggerFetchEvents$1.label = 1;
            obj2 = IListEventsService.INSTANCE.safeCall(new IMService$triggerFetchEvents$1$result$1(iMService$triggerFetchEvents$1.$taskId, i3, intRef, null), (Continuation) iMService$triggerFetchEvents$1);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            int i11 = i2;
            arrayList2 = arrayList;
            i5 = i11;
            intRef2 = intRef;
            i4 = i10;
            success = (HttpDataResult) obj2;
            if (success instanceof HttpDataResult.Success) {
                ListEventsResponse listEventsResponse = (ListEventsResponse) success.getBizResp().getData();
                List<EventItem> events = listEventsResponse != null ? listEventsResponse.getEvents() : null;
                if (events == null) {
                    events = CollectionsKt.emptyList();
                }
                if (events.isEmpty()) {
                    arrayList = arrayList2;
                } else {
                    arrayList2.addAll(events);
                }
            }
            intRef2.element = i3;
            iMService$triggerFetchEvents$1.L$0 = arrayList2;
            iMService$triggerFetchEvents$1.L$1 = intRef2;
            iMService$triggerFetchEvents$1.I$0 = i4;
            iMService$triggerFetchEvents$1.I$1 = i5;
            iMService$triggerFetchEvents$1.label = 2;
            arrayList3 = arrayList2;
            if (DelayKt.delay(50L, (Continuation) iMService$triggerFetchEvents$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            ArrayList arrayList422 = arrayList3;
            i2 = i5;
            arrayList = arrayList422;
            Ref.IntRef intRef422 = intRef2;
            i = i4;
            intRef = intRef422;
            if (i < i2) {
            }
        }
        coroutineScope = IMService.ioScope;
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C08661(arrayList, iMService$triggerFetchEvents$1.$taskId, iMService$triggerFetchEvents$1.$conversationId, null), 3, (Object) null);
        concurrentHashMap = IMService.pollingJobs;
        concurrentHashMap.remove(iMService$triggerFetchEvents$1.$taskId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.im.service.IMService$triggerFetchEvents$1$1", f = "IMService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.im.service.IMService$triggerFetchEvents$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<EventItem> $allEvents;
        final /* synthetic */ String $conversationId;
        final /* synthetic */ String $taskId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08661(List<EventItem> list, String str, String str2, Continuation<? super C08661> continuation) {
            super(2, continuation);
            this.$allEvents = list;
            this.$taskId = str;
            this.$conversationId = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08661(this.$allEvents, this.$taskId, this.$conversationId, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ConcurrentHashMap concurrentHashMap;
            LinkedHashSet linkedHashSet;
            LinkedHashSet linkedHashSet2;
            ConcurrentHashMap concurrentHashMap2;
            Set set;
            Set set2;
            ConcurrentHashMap concurrentHashMap3;
            Object putIfAbsent;
            ConcurrentHashMap concurrentHashMap4;
            ConcurrentHashMap concurrentHashMap5;
            ConcurrentHashMap concurrentHashMap6;
            ConcurrentHashMap concurrentHashMap7;
            ConcurrentHashMap concurrentHashMap8;
            ConcurrentHashMap concurrentHashMap9;
            boolean parseEvent;
            Object putIfAbsent2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Ref.IntRef intRef = new Ref.IntRef();
            if (!this.$allEvents.isEmpty()) {
                TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                StringBuilder append = new StringBuilder("[Node1] triggerFetchEvents: before clear, taskId=").append(this.$taskId).append(", thoughtMap=");
                concurrentHashMap4 = IMService.thoughtMap;
                traeLogUtil.d("AgentDataFlow", append.append(concurrentHashMap4).toString());
                concurrentHashMap5 = IMService.thoughtMap;
                ParsedChatMessage parsedChatMessage = (ParsedChatMessage) concurrentHashMap5.remove(this.$taskId);
                if (parsedChatMessage != null) {
                    IMMessageKt.releaseAggregator(parsedChatMessage);
                }
                concurrentHashMap6 = IMService.seqNumbers;
                concurrentHashMap6.remove(this.$taskId);
                TraeLogUtil traeLogUtil2 = TraeLogUtil.INSTANCE;
                StringBuilder append2 = new StringBuilder("[Node1] triggerFetchEvents: after clear, taskId=").append(this.$taskId).append(", thoughtMap=");
                concurrentHashMap7 = IMService.thoughtMap;
                traeLogUtil2.d("AgentDataFlow", append2.append(concurrentHashMap7).append(", oldMessage=").append(parsedChatMessage).toString());
                concurrentHashMap8 = IMService.seqNumbers;
                ConcurrentHashMap concurrentHashMap10 = concurrentHashMap8;
                String str = this.$taskId;
                ConcurrentHashMap.KeySetView keySetView = concurrentHashMap10.get(str);
                if (keySetView == null && (putIfAbsent2 = concurrentHashMap10.putIfAbsent(str, (keySetView = ConcurrentHashMap.newKeySet()))) != null) {
                    keySetView = putIfAbsent2;
                }
                Set set3 = (Set) keySetView;
                for (EventItem eventItem : this.$allEvents) {
                    Integer seq = eventItem.getSeq();
                    if (seq == null || seq.intValue() <= 0 || set3.add(seq)) {
                        try {
                            parseEvent = IMService.INSTANCE.parseEvent(eventItem, this.$conversationId);
                            Boxing.boxBoolean(parseEvent);
                        } catch (Throwable th) {
                            TraeLogUtil.INSTANCE.e("AgentDataFlow", "[Node1] triggerFetchEvents: parseEvent error, taskId=" + this.$taskId + ", convId=" + this.$conversationId + ", seq=" + seq + ", item=" + eventItem + ", e=" + th);
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node1] triggerFetchEvents: stream not continuous, taskId=" + this.$taskId + ", convId=" + this.$conversationId + ", seq=" + seq + ", item=" + eventItem);
                    }
                }
                Integer seq2 = ((EventItem) CollectionsKt.last(this.$allEvents)).getSeq();
                intRef.element = seq2 != null ? seq2.intValue() : 0;
                if (intRef.element > 0) {
                    concurrentHashMap9 = IMService.httpTaskSeqNum;
                    concurrentHashMap9.put(this.$taskId, Boxing.boxInt(intRef.element));
                }
            }
            concurrentHashMap = IMService.pendingEventsMap;
            List<ChatEvent> list = (List) concurrentHashMap.remove(this.$taskId);
            linkedHashSet = IMService.pendingTaskIdOrder;
            String str2 = this.$taskId;
            synchronized (linkedHashSet) {
                linkedHashSet2 = IMService.pendingTaskIdOrder;
                linkedHashSet2.remove(str2);
            }
            List list2 = list;
            if (!(list2 == null || list2.isEmpty())) {
                concurrentHashMap3 = IMService.thoughtMap;
                ConcurrentHashMap concurrentHashMap11 = concurrentHashMap3;
                String str3 = this.$taskId;
                String str4 = this.$conversationId;
                Object obj2 = concurrentHashMap11.get(str3);
                if (obj2 == null && (putIfAbsent = concurrentHashMap11.putIfAbsent(str3, (obj2 = new ParsedChatMessage(str4, "", null, null, null, "task", ParsedChatMessage.ROLE_ASSISTANT, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ParsedTaskContent(str3, null, null, 6, null), null, null, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, -100, 8388319, null)))) != null) {
                    obj2 = putIfAbsent;
                }
                ParsedChatMessage parsedChatMessage2 = (ParsedChatMessage) obj2;
                if (intRef.element > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : list) {
                        if (((ChatEvent) obj3).getSeq() > intRef.element) {
                            arrayList.add(obj3);
                        }
                    }
                    list = arrayList;
                }
                for (ChatEvent chatEvent : list) {
                    IMService iMService = IMService.INSTANCE;
                    String str5 = this.$taskId;
                    String str6 = this.$conversationId;
                    Intrinsics.checkNotNull(parsedChatMessage2);
                    iMService.realChatEvent(chatEvent, str5, str6, parsedChatMessage2, "socket");
                }
                TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node1] triggerFetchEvents done: taskId=" + this.$taskId + ", convId=" + this.$conversationId + ", filtered pendingList.size=" + list.size());
            }
            concurrentHashMap2 = IMService.firstSeqNum;
            concurrentHashMap2.put(this.$taskId, Boxing.boxInt(1));
            set = IMService.fetchedConversationDone;
            set.add(this.$conversationId);
            set2 = IMService.fetchingTaskIds;
            set2.remove(this.$taskId);
            TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node1] triggerFetchEvents done: taskId=" + this.$taskId + ", convId=" + this.$conversationId + "，allEvents.size=" + this.$allEvents.size());
            return Unit.INSTANCE;
        }
    }
}
