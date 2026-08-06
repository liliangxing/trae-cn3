package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SiteMessageListFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$loadMore$1", f = "SiteMessageListFragment.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageListFragment$loadMore$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $nextPage;
    int label;
    final /* synthetic */ SiteMessageListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SiteMessageListFragment$loadMore$1(int i, SiteMessageListFragment siteMessageListFragment, Continuation<? super SiteMessageListFragment$loadMore$1> continuation) {
        super(2, continuation);
        this.$nextPage = i;
        this.this$0 = siteMessageListFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SiteMessageListFragment$loadMore$1(this.$nextPage, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SiteMessageAdapter siteMessageAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = SiteMessageRepository.fetchList$default(SiteMessageRepository.INSTANCE, this.$nextPage, 0, (Continuation) this, 2, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Pair pair = (Pair) obj;
            List<SiteMessageItem> list = (List) pair.component1();
            boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
            this.this$0.currentPage = this.$nextPage;
            SiteMessageListFragment siteMessageListFragment = this.this$0;
            if (!booleanValue) {
                z = false;
            }
            siteMessageListFragment.hasMore = z;
            siteMessageAdapter = this.this$0.adapter;
            if (siteMessageAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                siteMessageAdapter = null;
            }
            siteMessageAdapter.appendData(list);
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.this$0.isLoading = false;
            throw th;
        }
        this.this$0.isLoading = false;
        return Unit.INSTANCE;
    }
}
