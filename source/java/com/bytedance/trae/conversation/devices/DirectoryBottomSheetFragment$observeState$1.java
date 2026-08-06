package com.bytedance.trae.conversation.devices;

import android.view.View;
import android.widget.Button;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.devices.DirectoryViewModel;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.multilanguage.R;
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
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DirectoryBottomSheetFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeState$1", f = "DirectoryBottomSheetFragment.kt", i = {}, l = {351}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DirectoryBottomSheetFragment$observeState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DirectoryBottomSheetFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryBottomSheetFragment$observeState$1(DirectoryBottomSheetFragment directoryBottomSheetFragment, Continuation<? super DirectoryBottomSheetFragment$observeState$1> continuation) {
        super(2, continuation);
        this.this$0 = directoryBottomSheetFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DirectoryBottomSheetFragment$observeState$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DirectoryBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeState$1$1", f = "DirectoryBottomSheetFragment.kt", i = {}, l = {352}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeState$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DirectoryBottomSheetFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07221(DirectoryBottomSheetFragment directoryBottomSheetFragment, Continuation<? super C07221> continuation) {
            super(2, continuation);
            this.this$0 = directoryBottomSheetFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07221(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            DirectoryViewModel viewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                viewModel = this.this$0.getViewModel();
                StateFlow<DirectoryUiState> uiState = viewModel.getUiState();
                final DirectoryBottomSheetFragment directoryBottomSheetFragment = this.this$0;
                this.label = 1;
                if (uiState.collect(new FlowCollector() { // from class: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment.observeState.1.1.1

                    /* compiled from: DirectoryBottomSheetFragment.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    /* renamed from: com.bytedance.trae.conversation.devices.DirectoryBottomSheetFragment$observeState$1$1$1$WhenMappings */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[DirectoryViewModel.Mode.values().length];
                            try {
                                iArr[DirectoryViewModel.Mode.RECENT.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[DirectoryViewModel.Mode.DOCUMENT.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((DirectoryUiState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(DirectoryUiState directoryUiState, Continuation<? super Unit> continuation) {
                        TraeTitleBar traeTitleBar;
                        Button button;
                        View view;
                        View view2;
                        RecyclerView recyclerView;
                        Button button2;
                        DirectoryAdapter directoryAdapter;
                        TraeTitleBar traeTitleBar2;
                        Button button3;
                        TraeTitleBar traeTitleBar3;
                        Button button4;
                        DirectoryViewModel.Mode resolvedMode = directoryUiState.getResolvedMode();
                        int i2 = resolvedMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[resolvedMode.ordinal()];
                        DirectoryAdapter directoryAdapter2 = null;
                        if (i2 == -1) {
                            traeTitleBar = DirectoryBottomSheetFragment.this.titleBar;
                            if (traeTitleBar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                                traeTitleBar = null;
                            }
                            traeTitleBar.setTitle(DirectoryBottomSheetFragment.this.getString(R.string.trae_dir_your_folders));
                            button = DirectoryBottomSheetFragment.this.btnAddFolder;
                            if (button == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("btnAddFolder");
                                button = null;
                            }
                            button.setText(DirectoryBottomSheetFragment.this.getString(R.string.trae_dir_add_new_folder));
                        } else if (i2 == 1) {
                            traeTitleBar2 = DirectoryBottomSheetFragment.this.titleBar;
                            if (traeTitleBar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                                traeTitleBar2 = null;
                            }
                            traeTitleBar2.setTitle(DirectoryBottomSheetFragment.this.getString(R.string.trae_dir_recent_folders));
                            button3 = DirectoryBottomSheetFragment.this.btnAddFolder;
                            if (button3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("btnAddFolder");
                                button3 = null;
                            }
                            button3.setText(DirectoryBottomSheetFragment.this.getString(R.string.trae_dir_more_folders));
                        } else if (i2 == 2) {
                            traeTitleBar3 = DirectoryBottomSheetFragment.this.titleBar;
                            if (traeTitleBar3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("titleBar");
                                traeTitleBar3 = null;
                            }
                            traeTitleBar3.setTitle(DirectoryBottomSheetFragment.this.getString(R.string.trae_dir_your_folders));
                            button4 = DirectoryBottomSheetFragment.this.btnAddFolder;
                            if (button4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("btnAddFolder");
                                button4 = null;
                            }
                            button4.setText(DirectoryBottomSheetFragment.this.getString(R.string.trae_dir_add_new_folder));
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        boolean isRootLoading = directoryUiState.isRootLoading();
                        boolean z = directoryUiState.getNodes().isEmpty() && !isRootLoading;
                        view = DirectoryBottomSheetFragment.this.progressLoading;
                        if (view == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("progressLoading");
                            view = null;
                        }
                        view.setVisibility(isRootLoading ? 0 : 8);
                        view2 = DirectoryBottomSheetFragment.this.tvEmptyState;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tvEmptyState");
                            view2 = null;
                        }
                        view2.setVisibility(z ? 0 : 8);
                        recyclerView = DirectoryBottomSheetFragment.this.recyclerView;
                        if (recyclerView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            recyclerView = null;
                        }
                        recyclerView.setVisibility((isRootLoading || z) ? 8 : 0);
                        button2 = DirectoryBottomSheetFragment.this.btnAddFolder;
                        if (button2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("btnAddFolder");
                            button2 = null;
                        }
                        button2.setVisibility((isRootLoading || !(directoryUiState.getNodes().isEmpty() ^ true)) ? 8 : 0);
                        directoryAdapter = DirectoryBottomSheetFragment.this.adapter;
                        if (directoryAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        } else {
                            directoryAdapter2 = directoryAdapter;
                        }
                        directoryAdapter2.submitList(CollectionsKt.toList(directoryUiState.getNodes()));
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
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
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C07221(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
