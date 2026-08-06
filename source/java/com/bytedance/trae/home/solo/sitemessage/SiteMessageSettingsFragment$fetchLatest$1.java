package com.bytedance.trae.home.solo.sitemessage;

import android.widget.ProgressBar;
import android.widget.ScrollView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.sitemessage.SiteMessagePreferencesGetResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SiteMessageSettingsFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment$fetchLatest$1", f = "SiteMessageSettingsFragment.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageSettingsFragment$fetchLatest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SiteMessageSettingsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SiteMessageSettingsFragment$fetchLatest$1(SiteMessageSettingsFragment siteMessageSettingsFragment, Continuation<? super SiteMessageSettingsFragment$fetchLatest$1> continuation) {
        super(2, continuation);
        this.this$0 = siteMessageSettingsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SiteMessageSettingsFragment$fetchLatest$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ProgressBar progressBar;
        ScrollView scrollView;
        List<SiteMessagePreferencesTypeItem> items;
        Map<String, Boolean> preferences;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = SiteMessageRepository.INSTANCE.fetchPreferences((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SiteMessagePreferencesGetResponse.PreferencesData preferencesData = (SiteMessagePreferencesGetResponse.PreferencesData) obj;
            if (preferencesData != null && (preferences = preferencesData.getPreferences()) != null) {
                this.this$0.preferences = preferences;
                SiteMessagePreferencesCache.INSTANCE.save(preferences);
            }
            if (preferencesData != null && (items = preferencesData.getItems()) != null) {
                SiteMessageSettingsFragment siteMessageSettingsFragment = this.this$0;
                if (!items.isEmpty()) {
                    siteMessageSettingsFragment.items = items;
                    SiteMessagePreferencesCache.INSTANCE.saveItems(items);
                }
            }
        } catch (CancellationException e) {
            throw e;
        } catch (Exception unused) {
        }
        progressBar = this.this$0.loadingView;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        scrollView = this.this$0.scrollView;
        if (scrollView != null) {
            scrollView.setVisibility(0);
        }
        this.this$0.renderItems();
        return Unit.INSTANCE;
    }
}
