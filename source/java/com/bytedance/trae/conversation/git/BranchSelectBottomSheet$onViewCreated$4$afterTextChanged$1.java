package com.bytedance.trae.conversation.git;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* compiled from: BranchSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1", f = "BranchSelectBottomSheet.kt", i = {}, l = {157}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ RecyclerView $rvBranches;
    final /* synthetic */ Ref.ObjectRef<BranchItem> $selectedBranch;
    int label;
    final /* synthetic */ BranchSelectBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1(String str, BranchSelectBottomSheet branchSelectBottomSheet, RecyclerView recyclerView, Ref.ObjectRef<BranchItem> objectRef, Continuation<? super BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1> continuation) {
        super(2, continuation);
        this.$keyword = str;
        this.this$0 = branchSelectBottomSheet;
        this.$rvBranches = recyclerView;
        this.$selectedBranch = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1(this.$keyword, this.this$0, this.$rvBranches, this.$selectedBranch, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        GitSelectionViewModel gitSelectionViewModel;
        TextView textView;
        List list;
        BranchItemAdapter branchItemAdapter;
        List list2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(300L, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        GitSelectionViewModel gitSelectionViewModel2 = null;
        BranchItemAdapter branchItemAdapter2 = null;
        if ((this.$keyword.length() == 0) != false) {
            this.this$0.isSearching = false;
            this.$rvBranches.setVisibility(0);
            textView = this.this$0.tvSearchEmpty;
            if (textView != null) {
                textView.setVisibility(8);
            }
            BranchSelectBottomSheet branchSelectBottomSheet = this.this$0;
            list = branchSelectBottomSheet.fullBranchItems;
            List<BranchItem> list3 = list;
            Ref.ObjectRef<BranchItem> objectRef = this.$selectedBranch;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (BranchItem branchItem : list3) {
                String id = branchItem.getId();
                BranchItem branchItem2 = (BranchItem) objectRef.element;
                arrayList.add(BranchItem.copy$default(branchItem, null, null, Intrinsics.areEqual(id, branchItem2 != null ? branchItem2.getId() : null), false, 11, null));
            }
            branchSelectBottomSheet.branchItems = arrayList;
            branchItemAdapter = this.this$0.adapter;
            if (branchItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                branchItemAdapter2 = branchItemAdapter;
            }
            list2 = this.this$0.branchItems;
            branchItemAdapter2.submitList(list2);
        } else {
            this.this$0.isSearching = true;
            gitSelectionViewModel = this.this$0.gitViewModel;
            if (gitSelectionViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            } else {
                gitSelectionViewModel2 = gitSelectionViewModel;
            }
            gitSelectionViewModel2.searchBranches(this.$keyword);
        }
        return Unit.INSTANCE;
    }
}
