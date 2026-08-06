package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesGetResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SiteMessageRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository$initPreferences$1", f = "SiteMessageRepository.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageRepository$initPreferences$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SiteMessageRepository$initPreferences$1(Continuation<? super SiteMessageRepository$initPreferences$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SiteMessageRepository$initPreferences$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List<SiteMessagePreferencesTypeItem> items;
        Map<String, Boolean> preferences;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ISiteMessageApi createService = ISiteMessageApi.INSTANCE.createService();
                Pair[] pairArr = {TuplesKt.to("platform", SiteMessageParams.platform), TuplesKt.to("storeCountryCode", SiteMessagePreferencesCache.INSTANCE.getStoreCountryCode())};
                this.label = 1;
                obj = createService.getPreferences(MapsKt.mapOf(pairArr), (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SiteMessagePreferencesGetResponse siteMessagePreferencesGetResponse = (SiteMessagePreferencesGetResponse) obj;
            SiteMessagePreferencesGetResponse.PreferencesData data = siteMessagePreferencesGetResponse.getData();
            if (data != null && (preferences = data.getPreferences()) != null) {
                SiteMessagePreferencesCache.INSTANCE.save(preferences);
            }
            SiteMessagePreferencesGetResponse.PreferencesData data2 = siteMessagePreferencesGetResponse.getData();
            if (data2 != null && (items = data2.getItems()) != null && (!items.isEmpty())) {
                SiteMessagePreferencesCache.INSTANCE.saveItems(items);
            }
            SiteMessagePreferencesGetResponse.PreferencesData data3 = siteMessagePreferencesGetResponse.getData();
            if ((data3 != null ? data3.getLastUpdatedBy() : null) == null) {
                SiteMessageRepository.INSTANCE.migrateDefaultPreferences();
            }
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
