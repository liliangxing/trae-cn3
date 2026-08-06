package com.bytedance.trae.conversation.products;

import com.bytedance.crash.Ensure;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.network.response.HttpDataResult;
import com.larus.business.markdown.impl.common.utils.ExtrasKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactListActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.ArtifactListActivity$loadArtifactList$1", f = "ArtifactListActivity.kt", i = {0, 1}, l = {107, 157}, m = "invokeSuspend", n = {"paramsMap", "paramsMap"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactListActivity$loadArtifactList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $turnId;
    Object L$0;
    int label;
    final /* synthetic */ ArtifactListActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactListActivity$loadArtifactList$1(String str, String str2, ArtifactListActivity artifactListActivity, String str3, String str4, Continuation<? super ArtifactListActivity$loadArtifactList$1> continuation) {
        super(2, continuation);
        this.$cliType = str;
        this.$conversationId = str2;
        this.this$0 = artifactListActivity;
        this.$chatSessionId = str3;
        this.$turnId = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactListActivity$loadArtifactList$1(this.$cliType, this.$conversationId, this.this$0, this.$chatSessionId, this.$turnId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object safeCall;
        Map map;
        Object fetchArtifactList;
        Map map2;
        HttpDataResult.Success success;
        ArrayList arrayList;
        ArtifactItem artifactItem;
        int iconForFileName;
        HttpDataResult.Success success2;
        int iconForFileName2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(this.$cliType, CliType.LOCAL.getValue()) || Intrinsics.areEqual(this.$cliType, CliType.IDE.getValue())) {
                Map mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("conversation_id", this.$conversationId), TuplesKt.to("cliType", this.$cliType)});
                this.L$0 = mapOf;
                this.label = 1;
                safeCall = IGetArtifactListApi.INSTANCE.safeCall(new ArtifactListActivity$loadArtifactList$1$result$1(this.$conversationId, null), (Continuation) this);
                if (safeCall == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map = mapOf;
                success = (HttpDataResult) safeCall;
                if (!(success instanceof HttpDataResult.Success)) {
                }
            } else {
                String str = this.$chatSessionId;
                String str2 = this.$turnId;
                Map mapOf2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("conversation_id", this.$conversationId), TuplesKt.to("cliType", this.$cliType), TuplesKt.to(str, str), TuplesKt.to(str2, str2)});
                this.L$0 = mapOf2;
                this.label = 2;
                fetchArtifactList = new ArtifactListManager().fetchArtifactList(this.$cliType, this.$chatSessionId, this.$turnId, (Continuation) this);
                if (fetchArtifactList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map2 = mapOf2;
                success2 = (HttpDataResult) fetchArtifactList;
                if (!(success2 instanceof HttpDataResult.Success)) {
                }
            }
        } else if (i == 1) {
            map = (Map) this.L$0;
            ResultKt.throwOnFailure(obj);
            safeCall = obj;
            success = (HttpDataResult) safeCall;
            if (!(success instanceof HttpDataResult.Success)) {
                GetArtifactListData getArtifactListData = (GetArtifactListData) success.getBizResp().getData();
                if (getArtifactListData == null) {
                    this.this$0.showError();
                    return Unit.INSTANCE;
                }
                StringBuilder sb = new StringBuilder("");
                List<HubArtifactItem> artifacts = getArtifactListData.getArtifacts();
                ExtrasKt.putExtra(map, "result", sb.append(artifacts != null ? Boxing.boxInt(artifacts.size()) : null).toString());
                Ensure.ensureNotReachHereWithLogType("ArtifactListActivity", new Throwable(), "ArtifactListActivity:Success " + map);
                List<HubArtifactItem> artifacts2 = getArtifactListData.getArtifacts();
                if (artifacts2 != null) {
                    ArtifactListActivity artifactListActivity = this.this$0;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<T> it = artifacts2.iterator();
                    while (it.hasNext()) {
                        String path = ((HubArtifactItem) it.next()).getPath();
                        if (path == null) {
                            artifactItem = null;
                        } else {
                            String substringAfterLast$default = StringsKt.substringAfterLast$default(path, "/", (String) null, 2, (Object) null);
                            if (substringAfterLast$default.length() > 0) {
                                iconForFileName = artifactListActivity.getIconForFileName(substringAfterLast$default);
                                artifactItem = new ArtifactItem(substringAfterLast$default, iconForFileName, path);
                            } else {
                                artifactItem = null;
                            }
                        }
                        if (artifactItem != null) {
                            arrayList2.add(artifactItem);
                        }
                    }
                    arrayList = arrayList2;
                } else {
                    arrayList = null;
                }
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                this.this$0.showContent(arrayList);
            } else {
                if (!(success instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                ExtrasKt.putExtra(map, "error", success);
                Ensure.ensureNotReachHereWithLogType("ArtifactListActivity", new Throwable(), "ArtifactPreviewActivity:Error " + map);
                this.this$0.showError();
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            map2 = (Map) this.L$0;
            ResultKt.throwOnFailure(obj);
            fetchArtifactList = obj;
            success2 = (HttpDataResult) fetchArtifactList;
            if (!(success2 instanceof HttpDataResult.Success)) {
                ArtifactListResponse artifactListResponse = (ArtifactListResponse) success2.getBizResp().getData();
                if (artifactListResponse == null) {
                    this.this$0.showError();
                    return Unit.INSTANCE;
                }
                Ensure.ensureNotReachHereWithLogType("ArtifactListActivity", new Throwable(), "ArtifactPreviewActivity:Error " + map2);
                ArrayList arrayList3 = new ArrayList();
                List<String> flatten = CollectionsKt.flatten(CollectionsKt.listOfNotNull(new List[]{artifactListResponse.getChangedCodes(), artifactListResponse.getChangedDocs(), artifactListResponse.getChangedImages(), artifactListResponse.getChangedSheets(), artifactListResponse.getChangedSlides(), artifactListResponse.getChangedSkills(), artifactListResponse.getMergeProducts()}));
                ArtifactListActivity artifactListActivity2 = this.this$0;
                for (String str3 : flatten) {
                    String substringAfterLast$default2 = StringsKt.substringAfterLast$default(str3, "/", (String) null, 2, (Object) null);
                    if (substringAfterLast$default2.length() > 0) {
                        iconForFileName2 = artifactListActivity2.getIconForFileName(substringAfterLast$default2);
                        arrayList3.add(new ArtifactItem(substringAfterLast$default2, iconForFileName2, str3));
                    }
                }
                this.this$0.showContent(arrayList3);
            } else {
                if (!(success2 instanceof HttpDataResult.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                Ensure.ensureNotReachHereWithLogType("ArtifactListActivity", new Throwable(), "ArtifactPreviewActivity:Error " + map2);
                this.this$0.showError();
            }
        }
        return Unit.INSTANCE;
    }
}
