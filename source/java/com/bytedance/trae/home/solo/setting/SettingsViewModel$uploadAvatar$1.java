package com.bytedance.trae.home.solo.setting;

import android.app.Application;
import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.SettingsViewModel$uploadAvatar$1", f = "SettingsViewModel.kt", i = {}, l = {234}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsViewModel$uploadAvatar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $context;
    final /* synthetic */ ILoginService $loginService;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel$uploadAvatar$1(SettingsViewModel settingsViewModel, ILoginService iLoginService, Application application, Uri uri, Continuation<? super SettingsViewModel$uploadAvatar$1> continuation) {
        super(2, continuation);
        this.this$0 = settingsViewModel;
        this.$loginService = iLoginService;
        this.$context = application;
        this.$uri = uri;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingsViewModel$uploadAvatar$1(this.this$0, this.$loginService, this.$context, this.$uri, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new SettingsViewModel$uploadAvatar$1$uploadFile$1(this.this$0, this.$context, this.$uri, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        final File file = (File) obj;
        if (file == null) {
            mutableLiveData = this.this$0._isLoading;
            mutableLiveData.setValue(Boxing.boxBoolean(false));
            mutableLiveData2 = this.this$0._uploadAvatarResult;
            mutableLiveData2.setValue(new Event(Boxing.boxBoolean(false)));
            return Unit.INSTANCE;
        }
        ILoginService iLoginService = this.$loginService;
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        final ILoginService iLoginService2 = this.$loginService;
        final SettingsViewModel settingsViewModel = this.this$0;
        Function1 function1 = new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda2
            public final Object invoke(Object obj2) {
                Unit invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = SettingsViewModel$uploadAvatar$1.invokeSuspend$lambda$2(file, iLoginService2, settingsViewModel, (String) obj2);
                return invokeSuspend$lambda$2;
            }
        };
        final SettingsViewModel settingsViewModel2 = this.this$0;
        iLoginService.uploadAvatar(absolutePath, function1, new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda3
            public final Object invoke(Object obj2) {
                Unit invokeSuspend$lambda$3;
                invokeSuspend$lambda$3 = SettingsViewModel$uploadAvatar$1.invokeSuspend$lambda$3(file, settingsViewModel2, (Long) obj2);
                return invokeSuspend$lambda$3;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(File file, ILoginService iLoginService, final SettingsViewModel settingsViewModel, final String str) {
        file.delete();
        iLoginService.updateUserProfile(MapsKt.mapOf(TuplesKt.to("avatar", str)), new Function0() { // from class: com.bytedance.trae.home.solo.setting.SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit invokeSuspend$lambda$2$lambda$0;
                invokeSuspend$lambda$2$lambda$0 = SettingsViewModel$uploadAvatar$1.invokeSuspend$lambda$2$lambda$0(SettingsViewModel.this, str);
                return invokeSuspend$lambda$2$lambda$0;
            }
        }, new Function1() { // from class: com.bytedance.trae.home.solo.setting.SettingsViewModel$uploadAvatar$1$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$2$lambda$1;
                invokeSuspend$lambda$2$lambda$1 = SettingsViewModel$uploadAvatar$1.invokeSuspend$lambda$2$lambda$1(SettingsViewModel.this, ((Integer) obj).intValue());
                return invokeSuspend$lambda$2$lambda$1;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2$lambda$0(SettingsViewModel settingsViewModel, String str) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        mutableLiveData = settingsViewModel._isLoading;
        mutableLiveData.postValue(false);
        mutableLiveData2 = settingsViewModel._userProfile;
        UserProfileState userProfileState = (UserProfileState) mutableLiveData2.getValue();
        if (userProfileState != null) {
            mutableLiveData4 = settingsViewModel._userProfile;
            mutableLiveData4.postValue(UserProfileState.copy$default(userProfileState, null, str, null, null, null, 0, null, 125, null));
        }
        mutableLiveData3 = settingsViewModel._uploadAvatarResult;
        mutableLiveData3.postValue(new Event(true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2$lambda$1(SettingsViewModel settingsViewModel, int i) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        FLogger.INSTANCE.e("SettingsViewModel", "updateUserProfile avatar failed, errorCode=" + i);
        mutableLiveData = settingsViewModel._isLoading;
        mutableLiveData.postValue(false);
        mutableLiveData2 = settingsViewModel._uploadAvatarResult;
        mutableLiveData2.postValue(new Event(false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$3(File file, SettingsViewModel settingsViewModel, Long l) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        file.delete();
        FLogger.INSTANCE.e("SettingsViewModel", "uploadAvatar failed, errorCode=" + l);
        mutableLiveData = settingsViewModel._isLoading;
        mutableLiveData.postValue(false);
        mutableLiveData2 = settingsViewModel._uploadAvatarResult;
        mutableLiveData2.postValue(new Event(false));
        return Unit.INSTANCE;
    }
}
