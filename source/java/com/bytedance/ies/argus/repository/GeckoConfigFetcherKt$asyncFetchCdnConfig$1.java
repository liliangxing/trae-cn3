package com.bytedance.ies.argus.repository;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.ies.argus.api.interfaces.ArgusGeckoResponse;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeckoConfigFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.repository.GeckoConfigFetcherKt$asyncFetchCdnConfig$1", f = "GeckoConfigFetcher.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoConfigFetcherKt$asyncFetchCdnConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArgusConfigType $configType;
    final /* synthetic */ boolean $retry;
    final /* synthetic */ ArgusConfigManager $this_asyncFetchCdnConfig;
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
    public GeckoConfigFetcherKt$asyncFetchCdnConfig$1(boolean z, ArgusConfigType argusConfigType, ArgusConfigManager argusConfigManager, Continuation<? super GeckoConfigFetcherKt$asyncFetchCdnConfig$1> continuation) {
        super(2, continuation);
        this.$retry = z;
        this.$configType = argusConfigType;
        this.$this_asyncFetchCdnConfig = argusConfigManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GeckoConfigFetcherKt$asyncFetchCdnConfig$1(this.$retry, this.$configType, this.$this_asyncFetchCdnConfig, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$retry) {
                this.label = 1;
                if (DelayKt.delay(PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.$configType.ordinal()];
        if (i2 == 1) {
            str = GeckoConfigConst.GLOBAL_CONFIG_CDN_URL;
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            str = GeckoConfigConst.CONTAINER_CONFIG_CDN_URL;
        }
        if (IConditionCallKt.enableArgusFetchCdnConfigInternal()) {
            ArgusGeckoLoader argusGeckoLoader = ArgusGeckoLoader.INSTANCE;
            boolean z = this.$retry;
            final ArgusConfigManager argusConfigManager = this.$this_asyncFetchCdnConfig;
            final ArgusConfigType argusConfigType = this.$configType;
            argusGeckoLoader.getRemoteResourceV2(str, z, new Function1<ArgusGeckoResponse, Unit>() { // from class: com.bytedance.ies.argus.repository.GeckoConfigFetcherKt$asyncFetchCdnConfig$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((ArgusGeckoResponse) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(ArgusGeckoResponse argusGeckoResponse) {
                    Intrinsics.checkNotNullParameter(argusGeckoResponse, "it");
                    GeckoConfigFetcherKt.parseResponse(ArgusConfigManager.this, argusConfigType, ArgusGeckoFetchType.CDN, argusGeckoResponse);
                }
            });
        } else {
            ArgusGeckoLoader argusGeckoLoader2 = ArgusGeckoLoader.INSTANCE;
            boolean z2 = this.$retry;
            final ArgusConfigManager argusConfigManager2 = this.$this_asyncFetchCdnConfig;
            final ArgusConfigType argusConfigType2 = this.$configType;
            argusGeckoLoader2.getRemoteResource(str, z2, new Function1<ArgusGeckoResponse, Unit>() { // from class: com.bytedance.ies.argus.repository.GeckoConfigFetcherKt$asyncFetchCdnConfig$1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((ArgusGeckoResponse) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(ArgusGeckoResponse argusGeckoResponse) {
                    Intrinsics.checkNotNullParameter(argusGeckoResponse, "it");
                    GeckoConfigFetcherKt.parseResponse(ArgusConfigManager.this, argusConfigType2, ArgusGeckoFetchType.CDN, argusGeckoResponse);
                }
            });
        }
        return Unit.INSTANCE;
    }
}
