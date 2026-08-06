package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.data.NotificationRepository;
import com.bytedance.trae.home.solo.setting.data.PayRepository;
import com.bytedance.trae.home.solo.setting.data.SettingsCreditsRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsEntryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel$refresh$1", f = "SettingsEntryViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsEntryViewModel$refresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsEntryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsEntryViewModel$refresh$1(SettingsEntryViewModel settingsEntryViewModel, Continuation<? super SettingsEntryViewModel$refresh$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsEntryViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> settingsEntryViewModel$refresh$1 = new SettingsEntryViewModel$refresh$1(this.this$0, continuation);
        settingsEntryViewModel$refresh$1.L$0 = obj;
        return settingsEntryViewModel$refresh$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsEntryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel$refresh$1$1", f = "SettingsEntryViewModel.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel$refresh$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SettingsEntryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08441(SettingsEntryViewModel settingsEntryViewModel, Continuation<? super C08441> continuation) {
            super(2, continuation);
            this.this$0 = settingsEntryViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08441(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            PayRepository payRepository;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                payRepository = this.this$0.payRepository;
                this.label = 1;
                if (payRepository.refresh((Continuation) this) == coroutine_suspended) {
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
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C08441(this.this$0, null), 3, (Object) null);
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C08452(this.this$0, null), 3, (Object) null);
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C08463(this.this$0, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsEntryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel$refresh$1$2", f = "SettingsEntryViewModel.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel$refresh$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08452 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SettingsEntryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08452(SettingsEntryViewModel settingsEntryViewModel, Continuation<? super C08452> continuation) {
            super(2, continuation);
            this.this$0 = settingsEntryViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08452(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            NotificationRepository notificationRepository;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                notificationRepository = this.this$0.notificationRepository;
                this.label = 1;
                if (notificationRepository.refresh((Continuation) this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SettingsEntryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel$refresh$1$3", f = "SettingsEntryViewModel.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel$refresh$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08463 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SettingsEntryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08463(SettingsEntryViewModel settingsEntryViewModel, Continuation<? super C08463> continuation) {
            super(2, continuation);
            this.this$0 = settingsEntryViewModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08463(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            SettingsCreditsRepository settingsCreditsRepository;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                settingsCreditsRepository = this.this$0.creditsRepository;
                this.label = 1;
                if (settingsCreditsRepository.refresh((Continuation) this) == coroutine_suspended) {
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
}
