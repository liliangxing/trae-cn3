package com.bytedance.trae.conversation.devices;

import android.widget.Toast;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeEvents$1;
import com.bytedance.trae.conversation.devices.DirectoryEvent;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.multilanguage.R;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DirectoryBottomSheetFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeEvents$1", f = "DirectoryBottomSheetFragment.kt", i = {}, l = {383}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryBottomSheetFragment$observeEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DirectoryBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryBottomSheetFragment$observeEvents$1(DirectoryBottomSheetFragment directoryBottomSheetFragment, Continuation<? super DirectoryBottomSheetFragment$observeEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = directoryBottomSheetFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirectoryBottomSheetFragment$observeEvents$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DirectoryBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeEvents$1$1", f = "DirectoryBottomSheetFragment.kt", i = {}, l = {384}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeEvents$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DirectoryBottomSheetFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07211(DirectoryBottomSheetFragment directoryBottomSheetFragment, Continuation<? super C07211> continuation) {
            super(2, continuation);
            this.this$0 = directoryBottomSheetFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07211(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DirectoryBottomSheetFragment.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* renamed from: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeEvents$1$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ DirectoryBottomSheetFragment this$0;

            AnonymousClass1(DirectoryBottomSheetFragment directoryBottomSheetFragment) {
                this.this$0 = directoryBottomSheetFragment;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((DirectoryEvent) obj, (Continuation<? super Unit>) continuation);
            }

            public final Object emit(final DirectoryEvent directoryEvent, Continuation<? super Unit> continuation) {
                DirectoryAdapter directoryAdapter;
                DirectoryViewModel viewModel;
                if (directoryEvent instanceof DirectoryEvent.ShowToast) {
                    Toast.makeText(this.this$0.requireContext(), ((DirectoryEvent.ShowToast) directoryEvent).getMessage(), 0).show();
                } else if (directoryEvent instanceof DirectoryEvent.FolderCreated) {
                    Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.trae_dir_folder_created, new Object[]{((DirectoryEvent.FolderCreated) directoryEvent).getName()}), 0).show();
                } else if (directoryEvent instanceof DirectoryEvent.FocusNewFolder) {
                    directoryAdapter = this.this$0.adapter;
                    if (directoryAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        directoryAdapter = null;
                    }
                    viewModel = this.this$0.getViewModel();
                    List list = CollectionsKt.toList(((DirectoryUiState) viewModel.getUiState().getValue()).getNodes());
                    final DirectoryBottomSheetFragment directoryBottomSheetFragment = this.this$0;
                    directoryAdapter.submitList(list, new Runnable() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeEvents$1$1$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            DirectoryBottomSheetFragment$observeEvents$1.C07211.AnonymousClass1.emit$lambda$0(DirectoryBottomSheetFragment.this, directoryEvent);
                        }
                    });
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void emit$lambda$0(DirectoryBottomSheetFragment directoryBottomSheetFragment, DirectoryEvent directoryEvent) {
                RecyclerView recyclerView;
                recyclerView = directoryBottomSheetFragment.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                recyclerView.scrollToPosition(((DirectoryEvent.FocusNewFolder) directoryEvent).getPosition());
            }
        }

        public final Object invokeSuspend(Object obj) {
            DirectoryViewModel viewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                viewModel = this.this$0.getViewModel();
                this.label = 1;
                if (viewModel.getEvents().collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C07211(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
