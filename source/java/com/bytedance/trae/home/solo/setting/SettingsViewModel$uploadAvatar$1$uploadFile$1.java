package com.bytedance.trae.home.solo.setting;

import android.app.Application;
import android.net.Uri;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.SettingsViewModel$uploadAvatar$1$uploadFile$1", f = "SettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class SettingsViewModel$uploadAvatar$1$uploadFile$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super File>, Object> {
    final /* synthetic */ Application $context;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel$uploadAvatar$1$uploadFile$1(SettingsViewModel settingsViewModel, Application application, Uri uri, Continuation<? super SettingsViewModel$uploadAvatar$1$uploadFile$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsViewModel;
        this.$context = application;
        this.$uri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsViewModel$uploadAvatar$1$uploadFile$1(this.this$0, this.$context, this.$uri, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super File> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        File copyAndCompressAvatar;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            copyAndCompressAvatar = this.this$0.copyAndCompressAvatar(this.$context, this.$uri);
            return copyAndCompressAvatar;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
