package com.bytedance.trae.conversation.plugin;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.network.PluginItem;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.plugin.PluginListCache;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.PluginsViewModel$loadPlugins$1", f = "PluginsViewModel.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginsViewModel$loadPlugins$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PluginItem> $cached;
    int label;
    final /* synthetic */ PluginsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginsViewModel$loadPlugins$1(PluginsViewModel pluginsViewModel, List<PluginItem> list, Continuation<? super PluginsViewModel$loadPlugins$1> continuation) {
        super(2, continuation);
        this.this$0 = pluginsViewModel;
        this.$cached = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PluginsViewModel$loadPlugins$1(this.this$0, this.$cached, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a6, code lost:
    
        r1 = r8.this$0._error;
        r1.setValue("Failed to load plugins");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        MutableLiveData mutableLiveData6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        mutableLiveData3 = this.this$0._isLoading;
                        mutableLiveData3.setValue(Boxing.boxBoolean(this.$cached == null));
                        mutableLiveData4 = this.this$0._error;
                        mutableLiveData4.setValue((Object) null);
                        this.label = 1;
                        obj = PluginListCache.INSTANCE.getPlugins(this.this$0.getCliId(), this.this$0.getWorkspaceFolder(), (Continuation) this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    PluginListCache.PluginListResult pluginListResult = (PluginListCache.PluginListResult) obj;
                    mutableLiveData5 = this.this$0._plugins;
                    mutableLiveData5.setValue(pluginListResult.getPlugins());
                    if (pluginListResult.getPlugins().isEmpty()) {
                        mutableLiveData6 = this.this$0._error;
                        mutableLiveData6.setValue((Object) null);
                    }
                } catch (CancellationException e) {
                    throw e;
                }
            } catch (Exception e2) {
                mutableLiveData = this.this$0._plugins;
                Collection collection = (Collection) mutableLiveData.getValue();
                if (collection != null && !collection.isEmpty()) {
                    z = false;
                }
                PluginTracker pluginTracker = PluginTracker.INSTANCE;
                StringBuilder sb = new StringBuilder("load_error:");
                String message = e2.getMessage();
                pluginTracker.trackAuthFail("plugin_list", sb.append(message != null ? StringsKt.take(message, 100) : null).toString());
            }
            return Unit.INSTANCE;
        } finally {
            mutableLiveData2 = this.this$0._isLoading;
            mutableLiveData2.setValue(Boxing.boxBoolean(false));
        }
    }
}
