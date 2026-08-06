package com.bytedance.ies.argus.repository;

import com.bytedance.ies.argus.base.ArgusEnv;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeckoConfigFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.repository.GeckoConfigFetcherKt$asyncFetchOfflineConfig$1", f = "GeckoConfigFetcher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoConfigFetcherKt$asyncFetchOfflineConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArgusConfigType $configType;
    final /* synthetic */ ArgusConfigManager $this_asyncFetchOfflineConfig;
    int label;

    /* compiled from: GeckoConfigFetcher.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArgusConfigType.values().length];
            try {
                iArr[ArgusConfigType.GLOBAL_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArgusConfigType.CONTAINER_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GeckoConfigFetcherKt$asyncFetchOfflineConfig$1(ArgusConfigType argusConfigType, ArgusConfigManager argusConfigManager, Continuation<? super GeckoConfigFetcherKt$asyncFetchOfflineConfig$1> continuation) {
        super(2, continuation);
        this.$configType = argusConfigType;
        this.$this_asyncFetchOfflineConfig = argusConfigManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GeckoConfigFetcherKt$asyncFetchOfflineConfig$1(this.$configType, this.$this_asyncFetchOfflineConfig, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int i = WhenMappings.$EnumSwitchMapping$0[this.$configType.ordinal()];
        if (i == 1) {
            str = GeckoConfigConst.GLOBAL_CONFIG_CHANNEL;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = GeckoConfigConst.CONTAINER_CONFIG_CHANNEL;
        }
        GeckoConfigFetcherKt.parseResponse(this.$this_asyncFetchOfflineConfig, this.$configType, ArgusGeckoFetchType.OFFLINE, ArgusGeckoLoader.INSTANCE.getBuiltinResource(ArgusEnv.INSTANCE.getInstance().getApplication(), str, GeckoConfigConst.DEFAULT_BUNDLE_NAME));
        return Unit.INSTANCE;
    }
}
