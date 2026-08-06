package com.bytedance.trae.home.solo.sitemessage;

import android.widget.Toast;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SiteMessageListFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment$fetchFirstPage$1", f = "SiteMessageListFragment.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageListFragment$fetchFirstPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SiteMessageListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SiteMessageListFragment$fetchFirstPage$1(SiteMessageListFragment siteMessageListFragment, Continuation<? super SiteMessageListFragment$fetchFirstPage$1> continuation) {
        super(2, continuation);
        this.this$0 = siteMessageListFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SiteMessageListFragment$fetchFirstPage$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d7, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d2, code lost:
    
        if (r11 == null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        SiteMessageAdapter siteMessageAdapter;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        boolean z = true;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = SiteMessageRepository.fetchList$default(SiteMessageRepository.INSTANCE, 1, 0, (Continuation) this, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Pair pair = (Pair) obj;
                List<SiteMessageItem> list = (List) pair.component1();
                boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
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
                siteMessageAdapter.setData(list);
                this.this$0.updateEmptyState();
                this.this$0.markAllAsRead(list);
                SiteMessageTracker siteMessageTracker = SiteMessageTracker.INSTANCE;
                int size = list.size();
                List<SiteMessageItem> list2 = list;
                if ((list2 instanceof Collection) && list2.isEmpty()) {
                    i = 0;
                } else {
                    Iterator<T> it = list2.iterator();
                    i = 0;
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((SiteMessageItem) it.next()).isRead(), Boxing.boxBoolean(false)) && (i = i + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                siteMessageTracker.trackListPageView(size, i);
            } catch (Exception unused) {
                Toast.makeText(this.this$0.getContext(), C0820R.string.trae_site_message_load_failed, 0).show();
                this.this$0.isLoading = false;
                swipeRefreshLayout = this.this$0.swipeRefresh;
            }
        } finally {
            this.this$0.isLoading = false;
            swipeRefreshLayout2 = this.this$0.swipeRefresh;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setRefreshing(false);
            }
        }
    }
}
