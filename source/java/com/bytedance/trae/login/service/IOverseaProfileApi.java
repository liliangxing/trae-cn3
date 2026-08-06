package com.bytedance.trae.login.service;

import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Part;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import com.bytedance.trae.network.TraeHttpConnection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: OverseaProfileApi.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ$\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/login/service/IOverseaProfileApi;", "", "updateUserInfo", "Lcom/bytedance/trae/login/service/OverseaUpdateProfileResponse;", "params", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadAvatar", "Lcom/bytedance/trae/login/service/OverseaUploadAvatarResponse;", "file", "Lcom/bytedance/retrofit2/mime/TypedFile;", "(Lcom/bytedance/retrofit2/mime/TypedFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IOverseaProfileApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @FormUrlEncoded
    @POST("user/update/user_info/?aid=677332")
    Object updateUserInfo(@FieldMap Map<String, String> map, Continuation<? super OverseaUpdateProfileResponse> continuation);

    @Multipart
    @POST("user/update/upload_avatar/?aid=677332")
    Object uploadAvatar(@Part("avatar") TypedFile typedFile, Continuation<? super OverseaUploadAvatarResponse> continuation);

    /* compiled from: OverseaProfileApi.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;", "", "<init>", "()V", "create", "Lcom/bytedance/trae/login/service/IOverseaProfileApi;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final IOverseaProfileApi create() {
            return (IOverseaProfileApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "oversea_profile", IOverseaProfileApi.class, null, HostResolver.INSTANCE.getBaseUrl(HostType.ONLINE), null, false, 20, null);
        }
    }
}
