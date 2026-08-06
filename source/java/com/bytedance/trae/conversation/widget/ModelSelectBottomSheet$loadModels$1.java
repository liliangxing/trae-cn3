package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import com.bytedance.trae.conversation.network.RemoteModelItem;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModelSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$loadModels$1", f = "ModelSelectBottomSheet.kt", i = {}, l = {181, 190}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ModelSelectBottomSheet$loadModels$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RemoteModelItem> $cachedModels;
    final /* synthetic */ List<String> $functions;
    final /* synthetic */ boolean $hasCachedModels;
    int label;
    final /* synthetic */ ModelSelectBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModelSelectBottomSheet$loadModels$1(ModelSelectBottomSheet modelSelectBottomSheet, List<String> list, boolean z, List<RemoteModelItem> list2, Continuation<? super ModelSelectBottomSheet$loadModels$1> continuation) {
        super(2, continuation);
        this.this$0 = modelSelectBottomSheet;
        this.$functions = list;
        this.$hasCachedModels = z;
        this.$cachedModels = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ModelSelectBottomSheet$loadModels$1(this.this$0, this.$functions, this.$hasCachedModels, this.$cachedModels, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List<RemoteModelItem> list;
        Context context;
        ProgressBar progressBar;
        CliType cliType;
        String str;
        String str2;
        CliType cliType2;
        CliType cliType3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (CancellationException e) {
            throw e;
        } catch (Throwable th) {
            TraeLogUtil.INSTANCE.w(ModelSelectBottomSheet.TAG, "loadModels failed", th);
            if (!this.$hasCachedModels && this.this$0.isAdded() && (context = this.this$0.getContext()) != null) {
                Toast.makeText(context, C0637R.string.imkit_model_list_load_failed, 0).show();
            }
            list = this.$cachedModels;
            if (list == null) {
                list = CollectionsKt.listOf(RemoteModelItem.INSTANCE.auto());
            }
        }
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                list = (List) obj;
                Context context2 = this.this$0.getContext();
                if (!this.this$0.isAdded()) {
                }
                TraeLogUtil.INSTANCE.i(ModelSelectBottomSheet.TAG, "loadModels: skip result, fragment detached");
                return Unit.INSTANCE;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            list = (List) obj;
            Context context22 = this.this$0.getContext();
            if (!this.this$0.isAdded() && this.this$0.getView() != null && context22 != null) {
                progressBar = this.this$0.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(8);
                this.this$0.updateModelList(list, "network", true, context22);
                return Unit.INSTANCE;
            }
            TraeLogUtil.INSTANCE.i(ModelSelectBottomSheet.TAG, "loadModels: skip result, fragment detached");
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        cliType = this.this$0.cliType;
        if (cliType != CliType.LOCAL) {
            cliType3 = this.this$0.cliType;
            if (cliType3 != CliType.IDE) {
                this.label = 2;
                obj = IRemoteModelsApi.INSTANCE.fetchModelsForUi(this.$functions, "model_select_dialog", (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = (List) obj;
                Context context222 = this.this$0.getContext();
                if (!this.this$0.isAdded()) {
                }
                TraeLogUtil.INSTANCE.i(ModelSelectBottomSheet.TAG, "loadModels: skip result, fragment detached");
                return Unit.INSTANCE;
            }
        }
        IRemoteModelsApi.Companion companion = IRemoteModelsApi.INSTANCE;
        str = this.this$0.cliId;
        str2 = this.this$0.ideVersion;
        cliType2 = this.this$0.cliType;
        this.label = 1;
        obj = companion.fetchPcModelsForUi(str, this.$functions, false, str2, "model_select_dialog", cliType2, (Continuation) this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        list = (List) obj;
        Context context2222 = this.this$0.getContext();
        if (!this.this$0.isAdded()) {
        }
        TraeLogUtil.INSTANCE.i(ModelSelectBottomSheet.TAG, "loadModels: skip result, fragment detached");
        return Unit.INSTANCE;
    }
}
