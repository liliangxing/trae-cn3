package org.jetbrains.compose.resources;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: ImageResources.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lorg/jetbrains/compose/resources/ImageCache;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "org.jetbrains.compose.resources.ImageResourcesKt$loadImage$2", f = "ImageResources.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
final class ImageResourcesKt$loadImage$2 extends SuspendLambda implements Function1<Continuation<? super ImageCache>, Object> {
    final /* synthetic */ Function1<byte[], ImageCache> $decode;
    final /* synthetic */ String $path;
    final /* synthetic */ ResourceReader $resourceReader;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ImageResourcesKt$loadImage$2(Function1<? super byte[], ? extends ImageCache> function1, ResourceReader resourceReader, String str, Continuation<? super ImageResourcesKt$loadImage$2> continuation) {
        super(1, continuation);
        this.$decode = function1;
        this.$resourceReader = resourceReader;
        this.$path = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImageResourcesKt$loadImage$2(this.$decode, this.$resourceReader, this.$path, continuation);
    }

    public final Object invoke(Continuation<? super ImageCache> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Function1<byte[], ImageCache> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<byte[], ImageCache> function12 = this.$decode;
            this.L$0 = function12;
            this.label = 1;
            Object read = this.$resourceReader.read(this.$path, (Continuation) this);
            if (read == coroutine_suspended) {
                return coroutine_suspended;
            }
            function1 = function12;
            obj = read;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return function1.invoke(obj);
    }
}
