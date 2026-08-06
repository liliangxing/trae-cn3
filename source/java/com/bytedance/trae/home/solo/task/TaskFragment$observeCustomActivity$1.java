package com.bytedance.trae.home.solo.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.ShareWebViewActivity;
import com.bytedance.trae.conversation.chat.track.CustomActivityTracker;
import com.bytedance.trae.conversation.network.CustomActivityRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.task.TaskFragment$observeCustomActivity$1;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskFragment$observeCustomActivity$1", f = "TaskFragment.kt", i = {}, l = {865}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskFragment$observeCustomActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SimpleDraweeView $ivOperationIcon;
    final /* synthetic */ TraeTitleBar $titleBar;
    int label;
    final /* synthetic */ TaskFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskFragment$observeCustomActivity$1(TaskFragment taskFragment, TraeTitleBar traeTitleBar, SimpleDraweeView simpleDraweeView, Continuation<? super TaskFragment$observeCustomActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = taskFragment;
        this.$titleBar = traeTitleBar;
        this.$ivOperationIcon = simpleDraweeView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskFragment$observeCustomActivity$1(this.this$0, this.$titleBar, this.$ivOperationIcon, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskFragment$observeCustomActivity$1$1", f = "TaskFragment.kt", i = {}, l = {866}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.solo.task.TaskFragment$observeCustomActivity$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SimpleDraweeView $ivOperationIcon;
        final /* synthetic */ TraeTitleBar $titleBar;
        int label;
        final /* synthetic */ TaskFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08501(TraeTitleBar traeTitleBar, SimpleDraweeView simpleDraweeView, TaskFragment taskFragment, Continuation<? super C08501> continuation) {
            super(2, continuation);
            this.$titleBar = traeTitleBar;
            this.$ivOperationIcon = simpleDraweeView;
            this.this$0 = taskFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08501(this.$titleBar, this.$ivOperationIcon, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TaskFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "banner", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskFragment$observeCustomActivity$1$1$1", f = "TaskFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.bytedance.trae.home.solo.task.TaskFragment$observeCustomActivity$1$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
            final /* synthetic */ SimpleDraweeView $ivOperationIcon;
            final /* synthetic */ TraeTitleBar $titleBar;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ TaskFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TraeTitleBar traeTitleBar, SimpleDraweeView simpleDraweeView, TaskFragment taskFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$titleBar = traeTitleBar;
                this.$ivOperationIcon = simpleDraweeView;
                this.this$0 = taskFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$titleBar, this.$ivOperationIcon, this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(String str, Continuation<? super Unit> continuation) {
                return create(str, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                if (str != null) {
                    this.$titleBar.setTaskOperationIconVisible(true);
                    this.$ivOperationIcon.setImageURI(Uri.parse(str));
                    CustomActivityTracker.trackHomeEntryShow(CustomActivityTracker.Position.TASK_MANAGE);
                    SimpleDraweeView simpleDraweeView = this.$ivOperationIcon;
                    final TaskFragment taskFragment = this.this$0;
                    simpleDraweeView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskFragment$observeCustomActivity$1$1$1$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TaskFragment$observeCustomActivity$1.C08501.AnonymousClass1.invokeSuspend$lambda$0(TaskFragment.this, view);
                        }
                    });
                } else {
                    this.$titleBar.setTaskOperationIconVisible(false);
                    this.$ivOperationIcon.setOnClickListener((View.OnClickListener) null);
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0(TaskFragment taskFragment, View view) {
                String h5Url = CustomActivityRepository.INSTANCE.getInstance().getH5Url();
                if (h5Url == null || TextUtils.isEmpty(h5Url)) {
                    return;
                }
                CustomActivityTracker.trackHomeEntryClick(CustomActivityTracker.Position.TASK_MANAGE);
                ShareWebViewActivity.Companion companion = ShareWebViewActivity.INSTANCE;
                Context requireContext = taskFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                companion.start(requireContext, h5Url, (r16 & 4) != 0 ? null : "", (r16 & 8) != 0 ? null : CustomActivityRepository.INSTANCE.getInstance().getShareUrl(), (r16 & 16) != 0 ? null : CustomActivityRepository.INSTANCE.getInstance().getPostUrl(), (r16 & 32) != 0 ? "inside" : null);
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (FlowKt.collectLatest(CustomActivityRepository.INSTANCE.getInstance().getFirstBanner(), new AnonymousClass1(this.$titleBar, this.$ivOperationIcon, this.this$0, null), (Continuation) this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, Lifecycle.State.STARTED, new C08501(this.$titleBar, this.$ivOperationIcon, this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
