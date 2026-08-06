package com.bytedance.kmp.network.cinterop;

import com.bytedance.kmp.spi.KmpServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IKmpNetworkCommonParamsProvider.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.kmp.network.cinterop.IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2$getCommonHeaders$2", f = "IKmpNetworkCommonParamsProvider.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.kmp.network.cinterop.IKmpNetworkCommonParamsProviderKt$initKmpCinteropCommonParamsProvider$2$getCommonHeaders$2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class C0201x95241bbf extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends String>>, Object> {
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0201x95241bbf(String str, Continuation<? super C0201x95241bbf> continuation) {
        super(2, continuation);
        this.$url = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0201x95241bbf(this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Map<String, String>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IKmpNetworkCommonParamsProvider iKmpNetworkCommonParamsProvider = (IKmpNetworkCommonParamsProvider) KmpServiceManager.INSTANCE.get(Reflection.getOrCreateKotlinClass(IKmpNetworkCommonParamsProvider.class));
            if (iKmpNetworkCommonParamsProvider != null) {
                this.label = 1;
                obj = iKmpNetworkCommonParamsProvider.getCommonHeaders(this.$url, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return MapsKt.emptyMap();
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Map map = (Map) obj;
        if (map != null) {
            return map;
        }
        return MapsKt.emptyMap();
    }
}
