package com.bytedance.trae.home.solo.task;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.task.TaskFragment;
import com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1", f = "TaskFragment.kt", i = {}, l = {659}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskFragment$observeViewModel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $emptyStateView;
    final /* synthetic */ View $networkErrorView;
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ TextView $searchEmptyText;
    final /* synthetic */ View $searchEmptyView;
    final /* synthetic */ View $searchLoadingView;
    int label;
    final /* synthetic */ TaskFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskFragment$observeViewModel$1(TaskFragment taskFragment, RecyclerView recyclerView, View view, View view2, View view3, TextView textView, View view4, Continuation<? super TaskFragment$observeViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = taskFragment;
        this.$recyclerView = recyclerView;
        this.$emptyStateView = view;
        this.$searchLoadingView = view2;
        this.$searchEmptyView = view3;
        this.$searchEmptyText = textView;
        this.$networkErrorView = view4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskFragment$observeViewModel$1(this.this$0, this.$recyclerView, this.$emptyStateView, this.$searchLoadingView, this.$searchEmptyView, this.$searchEmptyText, this.$networkErrorView, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1", f = "TaskFragment.kt", i = {}, l = {686}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ View $emptyStateView;
        final /* synthetic */ View $networkErrorView;
        final /* synthetic */ RecyclerView $recyclerView;
        final /* synthetic */ TextView $searchEmptyText;
        final /* synthetic */ View $searchEmptyView;
        final /* synthetic */ View $searchLoadingView;
        int label;
        final /* synthetic */ TaskFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08511(TaskFragment taskFragment, RecyclerView recyclerView, View view, View view2, View view3, TextView textView, View view4, Continuation<? super C08511> continuation) {
            super(2, continuation);
            this.this$0 = taskFragment;
            this.$recyclerView = recyclerView;
            this.$emptyStateView = view;
            this.$searchLoadingView = view2;
            this.$searchEmptyView = view3;
            this.$searchEmptyText = textView;
            this.$networkErrorView = view4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08511(this.this$0, this.$recyclerView, this.$emptyStateView, this.$searchLoadingView, this.$searchEmptyView, this.$searchEmptyText, this.$networkErrorView, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            TaskViewModel taskViewModel;
            TaskViewModel taskViewModel2;
            TaskViewModel taskViewModel3;
            TaskViewModel taskViewModel4;
            TaskViewModel taskViewModel5;
            TaskViewModel taskViewModel6;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                taskViewModel = this.this$0.viewModel;
                if (taskViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    taskViewModel = null;
                }
                Flow tasks = taskViewModel.getTasks();
                taskViewModel2 = this.this$0.viewModel;
                if (taskViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    taskViewModel2 = null;
                }
                Flow loadError = taskViewModel2.getLoadError();
                taskViewModel3 = this.this$0.viewModel;
                if (taskViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    taskViewModel3 = null;
                }
                Flow isSearchMode = taskViewModel3.isSearchMode();
                taskViewModel4 = this.this$0.viewModel;
                if (taskViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    taskViewModel4 = null;
                }
                Flow searchQuery = taskViewModel4.getSearchQuery();
                taskViewModel5 = this.this$0.viewModel;
                if (taskViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    taskViewModel5 = null;
                }
                Flow combine = FlowKt.combine(tasks, loadError, isSearchMode, searchQuery, taskViewModel5.isSearchLoading(), new AnonymousClass1(null));
                taskViewModel6 = this.this$0.viewModel;
                if (taskViewModel6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    taskViewModel6 = null;
                }
                this.label = 1;
                if (FlowKt.collectLatest(FlowKt.combine(combine, taskViewModel6.getSearchResults(), new AnonymousClass2(null)), new AnonymousClass3(this.this$0, this.$recyclerView, this.$emptyStateView, this.$searchLoadingView, this.$searchEmptyView, this.$searchEmptyText, this.$networkErrorView, null), (Continuation) this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TaskFragment.kt */
        @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;", "tasks", "", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "hasError", "", "isSearchMode", "query", "", "isSearchLoading"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1$1", f = "TaskFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function6<List<? extends TaskModel>, Boolean, Boolean, String, Boolean, Continuation<? super TaskFragment.RawTaskContentState>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            /* synthetic */ boolean Z$0;
            /* synthetic */ boolean Z$1;
            /* synthetic */ boolean Z$2;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(6, continuation);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                return invoke((List<TaskModel>) obj, ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), (String) obj4, ((Boolean) obj5).booleanValue(), (Continuation<? super TaskFragment.RawTaskContentState>) obj6);
            }

            public final Object invoke(List<TaskModel> list, boolean z, boolean z2, String str, boolean z3, Continuation<? super TaskFragment.RawTaskContentState> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                anonymousClass1.L$0 = list;
                anonymousClass1.Z$0 = z;
                anonymousClass1.Z$1 = z2;
                anonymousClass1.L$1 = str;
                anonymousClass1.Z$2 = z3;
                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return new TaskFragment.RawTaskContentState((List) this.L$0, this.Z$0, this.Z$1, (String) this.L$1, this.Z$2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TaskFragment.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;", "rawState", "Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;", "searchResults", "", "Lcom/bytedance/trae/home/solo/task/TaskModel;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1$2", f = "TaskFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1$2, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class AnonymousClass2 extends SuspendLambda implements Function3<TaskFragment.RawTaskContentState, List<? extends TaskModel>, Continuation<? super TaskFragment.TaskContentState>, Object> {
            /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
            }

            public final Object invoke(TaskFragment.RawTaskContentState rawTaskContentState, List<TaskModel> list, Continuation<? super TaskFragment.TaskContentState> continuation) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                anonymousClass2.L$0 = rawTaskContentState;
                anonymousClass2.L$1 = list;
                return anonymousClass2.invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                TaskFragment.RawTaskContentState rawTaskContentState = (TaskFragment.RawTaskContentState) this.L$0;
                List<TaskModel> list = (List) this.L$1;
                return new TaskFragment.TaskContentState(TaskSearchContentResolver.INSTANCE.displayTasks(rawTaskContentState.getTasks(), rawTaskContentState.isSearchMode(), rawTaskContentState.getQuery(), list), rawTaskContentState.getHasError(), rawTaskContentState.isSearchMode(), rawTaskContentState.getQuery(), list, rawTaskContentState.isSearchLoading());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TaskFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "state", "Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1$3", f = "TaskFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1$3, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class AnonymousClass3 extends SuspendLambda implements Function2<TaskFragment.TaskContentState, Continuation<? super Unit>, Object> {
            final /* synthetic */ View $emptyStateView;
            final /* synthetic */ View $networkErrorView;
            final /* synthetic */ RecyclerView $recyclerView;
            final /* synthetic */ TextView $searchEmptyText;
            final /* synthetic */ View $searchEmptyView;
            final /* synthetic */ View $searchLoadingView;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TaskFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(TaskFragment taskFragment, RecyclerView recyclerView, View view, View view2, View view3, TextView textView, View view4, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = taskFragment;
                this.$recyclerView = recyclerView;
                this.$emptyStateView = view;
                this.$searchLoadingView = view2;
                this.$searchEmptyView = view3;
                this.$searchEmptyText = textView;
                this.$networkErrorView = view4;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass3 = new AnonymousClass3(this.this$0, this.$recyclerView, this.$emptyStateView, this.$searchLoadingView, this.$searchEmptyView, this.$searchEmptyText, this.$networkErrorView, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            public final Object invoke(TaskFragment.TaskContentState taskContentState, Continuation<? super Unit> continuation) {
                return create(taskContentState, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                TaskAdapter taskAdapter;
                TaskAdapter taskAdapter2;
                TaskAdapter taskAdapter3;
                TaskAdapter taskAdapter4;
                TaskAdapter taskAdapter5;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                final TaskFragment.TaskContentState taskContentState = (TaskFragment.TaskContentState) this.L$0;
                final List<TaskModel> tasks = taskContentState.getTasks();
                boolean hasMultipleLocalCliTypes = CliListRepository.INSTANCE.getInstance().hasMultipleLocalCliTypes();
                taskAdapter = this.this$0.adapter;
                TaskAdapter taskAdapter6 = null;
                if (taskAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    taskAdapter = null;
                }
                boolean z = taskAdapter.getShowProductType() != hasMultipleLocalCliTypes;
                taskAdapter2 = this.this$0.adapter;
                if (taskAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    taskAdapter2 = null;
                }
                taskAdapter2.setShowProductType(hasMultipleLocalCliTypes);
                if (z) {
                    taskAdapter4 = this.this$0.adapter;
                    if (taskAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        taskAdapter4 = null;
                    }
                    taskAdapter5 = this.this$0.adapter;
                    if (taskAdapter5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        taskAdapter5 = null;
                    }
                    taskAdapter4.notifyItemRangeChanged(0, taskAdapter5.getItemCount());
                }
                final boolean shouldWaitForListCommitBeforeShowingContent = TaskSearchContentResolver.INSTANCE.shouldWaitForListCommitBeforeShowingContent(tasks, taskContentState.getHasError(), taskContentState.isSearchMode(), taskContentState.getQuery(), taskContentState.isSearchLoading(), taskContentState.getSearchResults());
                this.this$0.setTaskListItemAnimationsSuppressed(this.$recyclerView, TaskSearchContentResolver.INSTANCE.shouldSuppressListItemAnimations(taskContentState.isSearchMode(), taskContentState.getQuery()));
                final TaskFragment taskFragment = this.this$0;
                final RecyclerView recyclerView = this.$recyclerView;
                final View view = this.$emptyStateView;
                final View view2 = this.$searchLoadingView;
                final View view3 = this.$searchEmptyView;
                final TextView textView = this.$searchEmptyText;
                final View view4 = this.$networkErrorView;
                final Function0 function0 = new Function0() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TaskFragment$observeViewModel$1.C08511.AnonymousClass3.invokeSuspend$lambda$0(TaskFragment.this, taskContentState, recyclerView, view, view2, view3, textView, view4);
                        return invokeSuspend$lambda$0;
                    }
                };
                taskAdapter3 = this.this$0.adapter;
                if (taskAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    taskAdapter6 = taskAdapter3;
                }
                final TaskFragment taskFragment2 = this.this$0;
                final RecyclerView recyclerView2 = this.$recyclerView;
                taskAdapter6.submitList(tasks, new Runnable() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$observeViewModel$1$1$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskFragment$observeViewModel$1.C08511.AnonymousClass3.invokeSuspend$lambda$3(tasks, taskFragment2, recyclerView2, shouldWaitForListCommitBeforeShowingContent, function0);
                    }
                });
                if (!shouldWaitForListCommitBeforeShowingContent) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(TaskFragment taskFragment, TaskFragment.TaskContentState taskContentState, RecyclerView recyclerView, View view, View view2, View view3, TextView textView, View view4) {
                taskFragment.renderTaskContent(taskContentState, recyclerView, view, view2, view3, textView, view4);
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x00c7, code lost:
            
                if (r3 != false) goto L61;
             */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x00d1  */
            /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:69:0x005f  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static final void invokeSuspend$lambda$3(List list, TaskFragment taskFragment, RecyclerView recyclerView, boolean z, Function0 function0) {
                String str;
                boolean z2;
                String str2;
                boolean z3;
                boolean z4;
                String str3;
                TaskModel taskModel = (TaskModel) CollectionsKt.firstOrNull(list);
                String id = taskModel != null ? taskModel.getId() : null;
                str = taskFragment.topTaskId;
                boolean z5 = true;
                if (str != null && id != null) {
                    str3 = taskFragment.topTaskId;
                    if (!Intrinsics.areEqual(id, str3)) {
                        z2 = true;
                        str2 = taskFragment.suppressNextTopChangedScrollTaskId;
                        TaskModel taskModel2 = (TaskModel) CollectionsKt.firstOrNull(list);
                        boolean z6 = (z2 || str2 == null || taskModel2 == null || !Intrinsics.areEqual(taskModel2.getId(), str2) || !taskModel2.isPinned()) ? false : true;
                        z3 = taskFragment.shouldScrollToTop;
                        if ((!z3 || (z2 && !z6)) && (!list.isEmpty())) {
                            if (recyclerView != null) {
                                recyclerView.scrollToPosition(0);
                            }
                            taskFragment.shouldScrollToTop = false;
                        }
                        if (str2 != null) {
                            List<TaskModel> list2 = list;
                            boolean z7 = list2 instanceof Collection;
                            if (!z7 || !list2.isEmpty()) {
                                for (TaskModel taskModel3 : list2) {
                                    if (Intrinsics.areEqual(taskModel3.getId(), str2) && taskModel3.isPinned()) {
                                        z4 = true;
                                        break;
                                    }
                                }
                            }
                            z4 = false;
                            if (!z4) {
                                if (!z7 || !list2.isEmpty()) {
                                    Iterator it = list2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Intrinsics.areEqual(((TaskModel) it.next()).getId(), str2)) {
                                                z5 = false;
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                            }
                            taskFragment.suppressNextTopChangedScrollTaskId = null;
                        }
                        taskFragment.topTaskId = id;
                        if (z) {
                            return;
                        }
                        function0.invoke();
                        return;
                    }
                }
                z2 = false;
                str2 = taskFragment.suppressNextTopChangedScrollTaskId;
                TaskModel taskModel22 = (TaskModel) CollectionsKt.firstOrNull(list);
                if (z2) {
                }
                z3 = taskFragment.shouldScrollToTop;
                if (!z3) {
                }
                if (recyclerView != null) {
                }
                taskFragment.shouldScrollToTop = false;
                if (str2 != null) {
                }
                taskFragment.topTaskId = id;
                if (z) {
                }
            }
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
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C08511(this.this$0, this.$recyclerView, this.$emptyStateView, this.$searchLoadingView, this.$searchEmptyView, this.$searchEmptyText, this.$networkErrorView, null), (Continuation) this) == coroutine_suspended) {
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
