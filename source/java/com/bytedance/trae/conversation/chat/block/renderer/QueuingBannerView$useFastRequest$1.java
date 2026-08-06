package com.bytedance.trae.conversation.chat.block.renderer;

import android.widget.Toast;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.ExpressPassBenefitManager;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.ConfirmTaskRequest;
import com.bytedance.trae.im.service.IConfirmTaskApi;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueuingBannerView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$useFastRequest$1", f = "QueuingBannerView.kt", i = {}, l = {324, 331, 342, 353, 353}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class QueuingBannerView$useFastRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $queueId;
    final /* synthetic */ String $taskId;
    Object L$0;
    int label;
    final /* synthetic */ QueuingBannerView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueuingBannerView$useFastRequest$1(String str, String str2, String str3, String str4, QueuingBannerView queuingBannerView, Continuation<? super QueuingBannerView$useFastRequest$1> continuation) {
        super(2, continuation);
        this.$conversationId = str;
        this.$taskId = str2;
        this.$queueId = str3;
        this.$messageId = str4;
        this.this$0 = queuingBannerView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QueuingBannerView$useFastRequest$1(this.$conversationId, this.$taskId, this.$queueId, this.$messageId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0109 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object safeCall;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                JSONObject jSONObject = new JSONObject();
                String str = this.$queueId;
                String str2 = this.$messageId;
                jSONObject.put("queue_id", str);
                jSONObject.put("message_id", str2);
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                ConfirmTaskRequest confirmTaskRequest = new ConfirmTaskRequest(this.$conversationId, this.$taskId, "use_fast_request", "", "", "", jSONObject2);
                this.label = 1;
                safeCall = IConfirmTaskApi.INSTANCE.safeCall(new QueuingBannerView$useFastRequest$1$result$1(confirmTaskRequest, null), (Continuation) this);
                if (safeCall == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        IApplog.Companion companion = IApplog.INSTANCE;
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("result", false);
                        Unit unit = Unit.INSTANCE;
                        companion.reportEvent("im_queue_banner_click", jSONObject3);
                        this.label = 4;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C06935(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 4;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C06935(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (i == 4) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Throwable th = (Throwable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                ResultKt.throwOnFailure(obj);
                safeCall = obj;
            }
            if (((HttpDataResult) safeCall) instanceof HttpDataResult.Error) {
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C06911(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                IApplog.Companion companion2 = IApplog.INSTANCE;
                JSONObject jSONObject32 = new JSONObject();
                jSONObject32.put("result", false);
                Unit unit2 = Unit.INSTANCE;
                companion2.reportEvent("im_queue_banner_click", jSONObject32);
                this.label = 4;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C06935(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            IApplog.Companion companion3 = IApplog.INSTANCE;
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("result", true);
            Unit unit3 = Unit.INSTANCE;
            companion3.reportEvent("im_queue_banner_click", jSONObject4);
            this.label = 3;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C06924(this.this$0, this.$messageId, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.label = 4;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C06935(this.this$0, null), (Continuation) this) == coroutine_suspended) {
            }
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            this.L$0 = th2;
            this.label = 5;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C06935(this.this$0, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueuingBannerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$useFastRequest$1$1", f = "QueuingBannerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$useFastRequest$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ QueuingBannerView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06911(QueuingBannerView queuingBannerView, Continuation<? super C06911> continuation) {
            super(2, continuation);
            this.this$0 = queuingBannerView;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06911(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.this$0.getContext(), R.string.trae_conversation_network_disconnected, 0).show();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueuingBannerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$useFastRequest$1$4", f = "QueuingBannerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$useFastRequest$1$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06924 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $messageId;
        int label;
        final /* synthetic */ QueuingBannerView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06924(QueuingBannerView queuingBannerView, String str, Continuation<? super C06924> continuation) {
            super(2, continuation);
            this.this$0 = queuingBannerView;
            this.$messageId = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06924(this.this$0, this.$messageId, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ExpressPassBenefitManager.INSTANCE.notifyBenefitEnable();
            if (!Intrinsics.areEqual(this.this$0.getQueryItem().getOriginMessage().getMessageId(), this.$messageId)) {
                return Unit.INSTANCE;
            }
            QueuingManager.INSTANCE.usePayRight(this.this$0.getQueryItem().getOriginMessage().getMessageId(), this.this$0.getQueryItem().getRequestUUid());
            this.this$0.setVisibility(8);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: QueuingBannerView.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$useFastRequest$1$5", f = "QueuingBannerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.chat.block.renderer.QueuingBannerView$useFastRequest$1$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C06935 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ QueuingBannerView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06935(QueuingBannerView queuingBannerView, Continuation<? super C06935> continuation) {
            super(2, continuation);
            this.this$0 = queuingBannerView;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06935(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.hideLoading();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
