package com.bytedance.trae.conversation.chat.viewholder;

import com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder;
import com.bytedance.trae.conversation.fileupload.BizType;
import com.bytedance.trae.conversation.fileupload.ConversationCopilotResourceUploadApi;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlRequest;
import com.bytedance.trae.conversation.fileupload.GetResourceUrlResponse;
import com.bytedance.trae.conversation.imageupload.ConversationCopilotImageUploadApi;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.products.LocalArtifactPath;
import com.bytedance.trae.im.service.GetDownloadUrlData;
import com.bytedance.trae.im.service.GetDownloadUrlRequest;
import com.bytedance.trae.im.service.IGetDownloadUrlApi;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder$bind$1$fetched$1", f = "UserMessageViewHolder.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {972, 977, 994}, m = "invokeSuspend", n = {"$this$withContext", "result", "missingRemoteResources", "missingLocalArtifacts", "$this$withContext", "result", "missingRemoteResources", "missingLocalArtifacts", "result", "requestTargets"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class UserMessageViewHolder$bind$1$fetched$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, String>>, Object> {
    final /* synthetic */ List<UserPreviewImageItem> $missing;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ UserMessageViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMessageViewHolder$bind$1$fetched$1(List<UserPreviewImageItem> list, UserMessageViewHolder userMessageViewHolder, Continuation<? super UserMessageViewHolder$bind$1$fetched$1> continuation) {
        super(2, continuation);
        this.$missing = list;
        this.this$0 = userMessageViewHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> userMessageViewHolder$bind$1$fetched$1 = new UserMessageViewHolder$bind$1$fetched$1(this.$missing, this.this$0, continuation);
        userMessageViewHolder$bind$1$fetched$1.L$0 = obj;
        return userMessageViewHolder$bind$1$fetched$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0305 A[Catch: all -> 0x0027, TryCatch #1 {all -> 0x0027, blocks: (B:8:0x0020, B:10:0x02ff, B:12:0x0305, B:14:0x030b, B:16:0x0311, B:18:0x0319, B:20:0x031f, B:21:0x0323), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x031f A[Catch: all -> 0x0027, TryCatch #1 {all -> 0x0027, blocks: (B:8:0x0020, B:10:0x02ff, B:12:0x0305, B:14:0x030b, B:16:0x0311, B:18:0x0319, B:20:0x031f, B:21:0x0323), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x028b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        LinkedHashMap linkedHashMap;
        List distinct;
        List distinct2;
        Map map;
        ConversationCopilotImageUploadApi imageUploadApi;
        Object imageUrls;
        Object obj2;
        List<String> list;
        List list2;
        Map map2;
        ConversationCopilotResourceUploadApi resourceUploadApi;
        Object resourceUrl;
        Map map3;
        Object obj3;
        Map map4;
        Map map5;
        UserMessageViewHolder.AttachmentListAdapter attachmentListAdapter;
        UserMessageViewHolder.AttachmentListAdapter attachmentListAdapter2;
        Object downloadUrlRawCall;
        Map map6;
        Object obj4;
        HttpDataResult.Success success;
        BizResponse bizResp;
        GetDownloadUrlData getDownloadUrlData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Map<String, String> map7 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            linkedHashMap = new LinkedHashMap();
            List<UserPreviewImageItem> list3 = this.$missing;
            ArrayList arrayList = new ArrayList();
            for (Object obj5 : list3) {
                if (((UserPreviewImageItem) obj5).getKind() == UserPreviewImageKind.IMAGE_ID) {
                    arrayList.add(obj5);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((UserPreviewImageItem) it.next()).getSourceId());
            }
            List<String> distinct3 = CollectionsKt.distinct(arrayList3);
            List<UserPreviewImageItem> list4 = this.$missing;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj6 : list4) {
                if (((UserPreviewImageItem) obj6).getKind() == UserPreviewImageKind.REMOTE_RESOURCE) {
                    arrayList4.add(obj6);
                }
            }
            ArrayList arrayList5 = arrayList4;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            Iterator it2 = arrayList5.iterator();
            while (it2.hasNext()) {
                arrayList6.add(((UserPreviewImageItem) it2.next()).getSourceId());
            }
            distinct = CollectionsKt.distinct(arrayList6);
            List<UserPreviewImageItem> list5 = this.$missing;
            ArrayList arrayList7 = new ArrayList();
            for (Object obj7 : list5) {
                if (((UserPreviewImageItem) obj7).getKind() == UserPreviewImageKind.LOCAL_ARTIFACT) {
                    arrayList7.add(obj7);
                }
            }
            ArrayList arrayList8 = arrayList7;
            ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
            Iterator it3 = arrayList8.iterator();
            while (it3.hasNext()) {
                arrayList9.add(((UserPreviewImageItem) it3.next()).getSourceId());
            }
            distinct2 = CollectionsKt.distinct(arrayList9);
            if (!distinct3.isEmpty()) {
                UserMessageViewHolder userMessageViewHolder = this.this$0;
                try {
                    Result.Companion companion = Result.Companion;
                    imageUploadApi = userMessageViewHolder.getImageUploadApi();
                    this.L$0 = coroutineScope;
                    this.L$1 = linkedHashMap;
                    this.L$2 = distinct;
                    this.L$3 = distinct2;
                    this.L$4 = linkedHashMap;
                    this.label = 1;
                    imageUrls = imageUploadApi.getImageUrls(distinct3, this);
                    if (imageUrls == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    map = linkedHashMap;
                } catch (Throwable th) {
                    th = th;
                    map = linkedHashMap;
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj2)) {
                    }
                    map3 = (Map) obj2;
                    if (map3 == null) {
                    }
                    linkedHashMap.putAll(map3);
                    list = distinct;
                    if (!(!list.isEmpty())) {
                    }
                }
            } else {
                map = linkedHashMap;
                list = distinct;
                if (!(!list.isEmpty())) {
                    UserMessageViewHolder userMessageViewHolder2 = this.this$0;
                    try {
                        Result.Companion companion3 = Result.Companion;
                        resourceUploadApi = userMessageViewHolder2.getResourceUploadApi();
                        GetResourceUrlRequest getResourceUrlRequest = new GetResourceUrlRequest(list, BizType.RemoteResource);
                        this.L$0 = coroutineScope;
                        this.L$1 = map;
                        this.L$2 = list;
                        this.L$3 = distinct2;
                        this.L$4 = null;
                        this.label = 2;
                        resourceUrl = resourceUploadApi.getResourceUrl(getResourceUrlRequest, this);
                    } catch (Throwable th2) {
                        th = th2;
                        list2 = distinct2;
                        map2 = map;
                        Result.Companion companion4 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.isFailure-impl(obj3)) {
                        }
                        map6 = (Map) obj3;
                        if (map6 == null) {
                        }
                        while (r6.hasNext()) {
                        }
                        if (!list2.isEmpty()) {
                        }
                        return map2;
                    }
                    if (resourceUrl == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list2 = distinct2;
                    map2 = map;
                    obj3 = Result.constructor-impl(((GetResourceUrlResponse) resourceUrl).getUrlMap());
                    if (Result.isFailure-impl(obj3)) {
                    }
                    map6 = (Map) obj3;
                    if (map6 == null) {
                    }
                    while (r6.hasNext()) {
                    }
                    if (!list2.isEmpty()) {
                    }
                    return map2;
                }
                list2 = distinct2;
                map2 = map;
                if (!list2.isEmpty()) {
                }
                return map2;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map4 = (Map) this.L$1;
                    map5 = (Map) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        downloadUrlRawCall = obj;
                        HttpDataResult.Success success2 = (HttpDataResult) downloadUrlRawCall;
                        success = !(success2 instanceof HttpDataResult.Success) ? success2 : null;
                        if (success != null && (bizResp = success.getBizResp()) != null && (getDownloadUrlData = (GetDownloadUrlData) bizResp.getData()) != null) {
                            map7 = getDownloadUrlData.getUrlMap();
                        }
                        if (map7 == null) {
                            map7 = MapsKt.emptyMap();
                        }
                        obj4 = Result.constructor-impl(map7);
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion5 = Result.Companion;
                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                        map2 = map5;
                        Map emptyMap = MapsKt.emptyMap();
                        if (Result.isFailure-impl(obj4)) {
                        }
                        Map map8 = (Map) obj4;
                        while (r2.hasNext()) {
                        }
                        return map2;
                    }
                    map2 = map5;
                    Map emptyMap2 = MapsKt.emptyMap();
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = emptyMap2;
                    }
                    Map map82 = (Map) obj4;
                    for (Map.Entry entry : map4.entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) map82.get((String) entry.getValue());
                        if (str2 == null) {
                            str2 = (String) map82.get(str);
                        }
                        String str3 = str2;
                        if (!(str3 == null || str3.length() == 0)) {
                            map2.put(str, str2);
                        }
                    }
                    return map2;
                }
                list2 = (List) this.L$3;
                list = (List) this.L$2;
                map2 = (Map) this.L$1;
                try {
                    ResultKt.throwOnFailure(obj);
                    resourceUrl = obj;
                    obj3 = Result.constructor-impl(((GetResourceUrlResponse) resourceUrl).getUrlMap());
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion42 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.isFailure-impl(obj3)) {
                    }
                    map6 = (Map) obj3;
                    if (map6 == null) {
                    }
                    while (r6.hasNext()) {
                    }
                    if (!list2.isEmpty()) {
                    }
                    return map2;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                map6 = (Map) obj3;
                if (map6 == null) {
                    map6 = MapsKt.emptyMap();
                }
                for (String str4 : list) {
                    String str5 = (String) map6.get(str4);
                    if (str5 == null) {
                        str5 = (String) map6.get("trae-res://remote_resource/" + str4);
                    }
                    String str6 = str5;
                    if (!(str6 == null || str6.length() == 0)) {
                        map2.put(str4, str5);
                    }
                }
                if (!list2.isEmpty()) {
                    List list6 = list2;
                    LocalArtifactPath localArtifactPath = LocalArtifactPath.INSTANCE;
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list6, 10)), 16));
                    for (Object obj8 : list6) {
                        linkedHashMap2.put(obj8, localArtifactPath.requestTarget((String) obj8));
                    }
                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                    UserMessageViewHolder userMessageViewHolder3 = this.this$0;
                    try {
                        Result.Companion companion6 = Result.Companion;
                        IGetDownloadUrlApi.Companion companion7 = IGetDownloadUrlApi.INSTANCE;
                        List distinct4 = CollectionsKt.distinct(linkedHashMap3.values());
                        attachmentListAdapter = userMessageViewHolder3.attachmentAdapter;
                        String conversationId = attachmentListAdapter.getConversationId();
                        attachmentListAdapter2 = userMessageViewHolder3.attachmentAdapter;
                        GetDownloadUrlRequest getDownloadUrlRequest = new GetDownloadUrlRequest(distinct4, conversationId, attachmentListAdapter2.getMessageId(), Boxing.boxBoolean(true));
                        this.L$0 = map2;
                        this.L$1 = linkedHashMap3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.label = 3;
                        downloadUrlRawCall = companion7.getDownloadUrlRawCall(getDownloadUrlRequest, this);
                    } catch (Throwable th5) {
                        th = th5;
                        map4 = linkedHashMap3;
                        map5 = map2;
                        Result.Companion companion52 = Result.Companion;
                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                        map2 = map5;
                        Map emptyMap22 = MapsKt.emptyMap();
                        if (Result.isFailure-impl(obj4)) {
                        }
                        Map map822 = (Map) obj4;
                        while (r2.hasNext()) {
                        }
                        return map2;
                    }
                    if (downloadUrlRawCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    map4 = linkedHashMap3;
                    map5 = map2;
                    HttpDataResult.Success success22 = (HttpDataResult) downloadUrlRawCall;
                    if (!(success22 instanceof HttpDataResult.Success)) {
                    }
                    if (success != null) {
                        map7 = getDownloadUrlData.getUrlMap();
                    }
                    if (map7 == null) {
                    }
                    obj4 = Result.constructor-impl(map7);
                    map2 = map5;
                    Map emptyMap222 = MapsKt.emptyMap();
                    if (Result.isFailure-impl(obj4)) {
                    }
                    Map map8222 = (Map) obj4;
                    while (r2.hasNext()) {
                    }
                }
                return map2;
            }
            linkedHashMap = (Map) this.L$4;
            distinct2 = (List) this.L$3;
            distinct = (List) this.L$2;
            map = (Map) this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                imageUrls = obj;
            } catch (Throwable th6) {
                th = th6;
                Result.Companion companion22 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                if (Result.isFailure-impl(obj2)) {
                }
                map3 = (Map) obj2;
                if (map3 == null) {
                }
                linkedHashMap.putAll(map3);
                list = distinct;
                if (!(!list.isEmpty())) {
                }
            }
        }
        obj2 = Result.constructor-impl((Map) imageUrls);
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        map3 = (Map) obj2;
        if (map3 == null) {
            map3 = MapsKt.emptyMap();
        }
        linkedHashMap.putAll(map3);
        list = distinct;
        if (!(!list.isEmpty())) {
        }
    }
}
