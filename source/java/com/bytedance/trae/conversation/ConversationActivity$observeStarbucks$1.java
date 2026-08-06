package com.bytedance.trae.conversation;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.trae.conversation.ConversationActivity$observeStarbucks$1;
import com.bytedance.trae.conversation.chat.track.CustomActivityTracker;
import com.bytedance.trae.conversation.databinding.TraeActivityConversationBinding;
import com.bytedance.trae.conversation.network.CustomActivityRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
/* compiled from: ConversationActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeStarbucks$1", f = "ConversationActivity.kt", i = {}, l = {1174}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationActivity$observeStarbucks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationActivity$observeStarbucks$1(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$observeStarbucks$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$observeStarbucks$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConversationActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "bannerUrl", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.ConversationActivity$observeStarbucks$1$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.ConversationActivity$observeStarbucks$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C05991 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConversationActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05991(ConversationActivity conversationActivity, Continuation<? super C05991> continuation) {
            super(2, continuation);
            this.this$0 = conversationActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c05991 = new C05991(this.this$0, continuation);
            c05991.L$0 = obj;
            return c05991;
        }

        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z;
            TraeActivityConversationBinding traeActivityConversationBinding;
            TraeActivityConversationBinding traeActivityConversationBinding2;
            TraeActivityConversationBinding traeActivityConversationBinding3;
            TraeActivityConversationBinding traeActivityConversationBinding4;
            TraeActivityConversationBinding traeActivityConversationBinding5;
            TraeActivityConversationBinding traeActivityConversationBinding6;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String str = (String) this.L$0;
                z = this.this$0.isNewConversation;
                if (!z) {
                    return Unit.INSTANCE;
                }
                TraeActivityConversationBinding traeActivityConversationBinding7 = null;
                if (str == null) {
                    traeActivityConversationBinding = this.this$0.binding;
                    if (traeActivityConversationBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        traeActivityConversationBinding = null;
                    }
                    traeActivityConversationBinding.btnOperationIcon.setVisibility(8);
                    traeActivityConversationBinding2 = this.this$0.binding;
                    if (traeActivityConversationBinding2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        traeActivityConversationBinding2 = null;
                    }
                    traeActivityConversationBinding2.btnOperationIcon.setOnClickListener((View.OnClickListener) null);
                } else {
                    CustomActivityTracker.trackHomeEntryShow(CustomActivityTracker.Position.NEW_SESSION);
                    traeActivityConversationBinding3 = this.this$0.binding;
                    if (traeActivityConversationBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        traeActivityConversationBinding3 = null;
                    }
                    traeActivityConversationBinding3.btnOperationIcon.setVisibility(0);
                    traeActivityConversationBinding4 = this.this$0.binding;
                    if (traeActivityConversationBinding4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        traeActivityConversationBinding4 = null;
                    }
                    traeActivityConversationBinding4.btnOperationIcon.setImageURI(str);
                    final String h5Url = CustomActivityRepository.INSTANCE.getInstance().getH5Url();
                    if (h5Url == null || TextUtils.isEmpty(h5Url)) {
                        traeActivityConversationBinding5 = this.this$0.binding;
                        if (traeActivityConversationBinding5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            traeActivityConversationBinding5 = null;
                        }
                        traeActivityConversationBinding5.btnOperationIcon.setOnClickListener((View.OnClickListener) null);
                    } else {
                        traeActivityConversationBinding6 = this.this$0.binding;
                        if (traeActivityConversationBinding6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        } else {
                            traeActivityConversationBinding7 = traeActivityConversationBinding6;
                        }
                        SimpleDraweeView simpleDraweeView = traeActivityConversationBinding7.btnOperationIcon;
                        final ConversationActivity conversationActivity = this.this$0;
                        simpleDraweeView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ConversationActivity$observeStarbucks$1$1$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ConversationActivity$observeStarbucks$1.C05991.invokeSuspend$lambda$0(ConversationActivity.this, h5Url, view);
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void invokeSuspend$lambda$0(ConversationActivity conversationActivity, String str, View view) {
            CustomActivityTracker.trackHomeEntryClick(CustomActivityTracker.Position.NEW_SESSION);
            ShareWebViewActivity.INSTANCE.start((Context) conversationActivity, str, (r16 & 4) != 0 ? null : "", (r16 & 8) != 0 ? null : CustomActivityRepository.INSTANCE.getInstance().getShareUrl(), (r16 & 16) != 0 ? null : CustomActivityRepository.INSTANCE.getInstance().getPostUrl(), (r16 & 32) != 0 ? "inside" : null);
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (FlowKt.collectLatest(CustomActivityRepository.INSTANCE.getInstance().getFirstBanner(), new C05991(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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
