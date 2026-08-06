package com.bytedance.trae.conversation.chat.viewholder;

import com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder;
import com.bytedance.trae.conversation.imageupload.ResourceRepoManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$bind$1", f = "UserMessageViewHolder.kt", i = {}, l = {956}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserMessageViewHolder$bind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $cached;
    final /* synthetic */ List<UserPreviewImageItem> $missing;
    final /* synthetic */ List<UserPreviewImageItem> $previewImages;
    int label;
    final /* synthetic */ UserMessageViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMessageViewHolder$bind$1(List<UserPreviewImageItem> list, UserMessageViewHolder userMessageViewHolder, Map<String, String> map, List<UserPreviewImageItem> list2, Continuation<? super UserMessageViewHolder$bind$1> continuation) {
        super(2, continuation);
        this.$previewImages = list;
        this.this$0 = userMessageViewHolder;
        this.$cached = map;
        this.$missing = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserMessageViewHolder$bind$1(this.$previewImages, this.this$0, this.$cached, this.$missing, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        UserMessageViewHolder.AttachmentListAdapter attachmentListAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new UserMessageViewHolder$bind$1$fetched$1(this.$missing, this.this$0, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Map map = (Map) obj;
        if (!map.isEmpty()) {
            List<UserPreviewImageItem> list = this.$previewImages;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list) {
                if (((UserPreviewImageItem) obj2).getKind() == UserPreviewImageKind.LOCAL_ARTIFACT) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((UserPreviewImageItem) it.next()).getSourceId());
            }
            Set set = CollectionsKt.toSet(arrayList3);
            ResourceRepoManager resourceRepoManager = ResourceRepoManager.INSTANCE;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (!set.contains((String) entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            resourceRepoManager.putAll(linkedHashMap);
            attachmentListAdapter = this.this$0.attachmentAdapter;
            attachmentListAdapter.updateResolvedUrls(MapsKt.plus(this.$cached, map));
        }
        return Unit.INSTANCE;
    }
}
