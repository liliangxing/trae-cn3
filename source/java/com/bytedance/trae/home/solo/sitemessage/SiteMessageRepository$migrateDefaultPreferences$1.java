package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SiteMessageRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository$migrateDefaultPreferences$1", f = "SiteMessageRepository.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class SiteMessageRepository$migrateDefaultPreferences$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Boolean> $defaults;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SiteMessageRepository$migrateDefaultPreferences$1(Map<String, Boolean> map, Continuation<? super SiteMessageRepository$migrateDefaultPreferences$1> continuation) {
        super(2, continuation);
        this.$defaults = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SiteMessageRepository$migrateDefaultPreferences$1(this.$defaults, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = SiteMessageRepository.INSTANCE.updatePreferences(this.$defaults, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Map<String, Boolean> map = (Map) obj;
            if (map != null) {
                SiteMessagePreferencesCache.INSTANCE.save(map);
            }
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
