package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper;
import com.bytedance.trae.conversation.fileupload.ResourceUploadUtilKt;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArtifactFileUrlHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper$fetchTextContent$2", f = "ArtifactFileUrlHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactFileUrlHelper$fetchTextContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cliType;
    final /* synthetic */ String $url;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtifactFileUrlHelper$fetchTextContent$2(String str, String str2, Continuation<? super ArtifactFileUrlHelper$fetchTextContent$2> continuation) {
        super(2, continuation);
        this.$cliType = str;
        this.$url = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ArtifactFileUrlHelper$fetchTextContent$2(this.$cliType, this.$url, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        byte[] readAllBytes;
        String str;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            ArrayList arrayList = new ArrayList();
            if (Intrinsics.areEqual(this.$cliType, CliType.LOCAL.getValue())) {
                final String str2 = this.$url;
                arrayList.add(new Interceptor() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ArtifactFileUrlHelper$fetchTextContent$2$$ExternalSyntheticLambda0
                    public final SsResponse intercept(Interceptor.Chain chain) {
                        SsResponse invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = ArtifactFileUrlHelper$fetchTextContent$2.invokeSuspend$lambda$0(str2, chain);
                        return invokeSuspend$lambda$0;
                    }
                });
            }
            ArtifactFileUrlHelper.TxtFetchApi txtFetchApi = (ArtifactFileUrlHelper.TxtFetchApi) RetrofitUtils.createSsRetrofit("https://placeholder.trae/", arrayList, (Converter.Factory) null).create(ArtifactFileUrlHelper.TxtFetchApi.class);
            if (txtFetchApi == null) {
                return null;
            }
            TypedInput typedInput = (TypedInput) txtFetchApi.get(this.$url, 52428800).execute().body();
            if (typedInput == null) {
                return "";
            }
            ArtifactFileUrlHelper artifactFileUrlHelper = ArtifactFileUrlHelper.INSTANCE;
            InputStream in = typedInput.in();
            Intrinsics.checkNotNullExpressionValue(in, "in(...)");
            readAllBytes = artifactFileUrlHelper.readAllBytes(in);
            if (Intrinsics.areEqual(this.$cliType, CliType.LOCAL.getValue())) {
                str = new String(ResourceUploadUtilKt.decodeContent(readAllBytes), Charsets.UTF_8);
            } else {
                str = new String(readAllBytes, Charsets.UTF_8);
            }
            return str;
        } catch (Exception e) {
            FLogger.INSTANCE.e("ArtifactFileUrlHelper", "fetchTextContent error", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SsResponse invokeSuspend$lambda$0(String str, Interceptor.Chain chain) {
        Request request;
        if (chain == null || (request = chain.request()) == null) {
            return null;
        }
        return chain.proceed(request.newBuilder().url(str).build());
    }
}
