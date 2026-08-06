package com.bytedance.trae.home.solo.sitemessage;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import java.util.Map;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SiteMessageSettingsFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment$onSwitchToggled$1", f = "SiteMessageSettingsFragment.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SiteMessageSettingsFragment$onSwitchToggled$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $card;
    final /* synthetic */ SiteMessagePreferencesTypeItem $item;
    final /* synthetic */ boolean $newValue;
    final /* synthetic */ Map<String, Boolean> $previousPreferences;
    final /* synthetic */ SwitchCompat $toggle;
    int label;
    final /* synthetic */ SiteMessageSettingsFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SiteMessageSettingsFragment$onSwitchToggled$1(SiteMessagePreferencesTypeItem siteMessagePreferencesTypeItem, boolean z, SiteMessageSettingsFragment siteMessageSettingsFragment, Map<String, Boolean> map, SwitchCompat switchCompat, View view, Continuation<? super SiteMessageSettingsFragment$onSwitchToggled$1> continuation) {
        super(2, continuation);
        this.$item = siteMessagePreferencesTypeItem;
        this.$newValue = z;
        this.this$0 = siteMessageSettingsFragment;
        this.$previousPreferences = map;
        this.$toggle = switchCompat;
        this.$card = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SiteMessageSettingsFragment$onSwitchToggled$1(this.$item, this.$newValue, this.this$0, this.$previousPreferences, this.$toggle, this.$card, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = SiteMessageRepository.INSTANCE.updatePreferences(MapsKt.mapOf(TuplesKt.to(this.$item.getKey(), Boxing.boxBoolean(this.$newValue))), (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Map<String, Boolean> map = (Map) obj;
                if (map != null) {
                    this.this$0.preferences = map;
                    SiteMessagePreferencesCache.INSTANCE.save(map);
                }
                SiteMessageTracker.INSTANCE.trackSettingsToggle(this.$item.getKey(), this.$newValue);
            } catch (CancellationException e) {
                throw e;
            } catch (Exception unused) {
                this.this$0.preferences = this.$previousPreferences;
                SiteMessagePreferencesCache.INSTANCE.save(this.$previousPreferences);
                this.$toggle.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                this.$toggle.setChecked(!this.$newValue);
                final SwitchCompat switchCompat = this.$toggle;
                final SiteMessageSettingsFragment siteMessageSettingsFragment = this.this$0;
                final SiteMessagePreferencesTypeItem siteMessagePreferencesTypeItem = this.$item;
                final View view = this.$card;
                switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bytedance.trae.home.solo.sitemessage.SiteMessageSettingsFragment$onSwitchToggled$1$$ExternalSyntheticLambda0
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        SiteMessageSettingsFragment.access$onSwitchToggled(SiteMessageSettingsFragment.this, siteMessagePreferencesTypeItem, z, switchCompat, view);
                    }
                });
                Toast.makeText(this.this$0.getContext(), C0820R.string.trae_site_message_settings_update_failed, 0).show();
            }
            return Unit.INSTANCE;
        } finally {
            this.$toggle.setEnabled(true);
            this.$card.setClickable(true);
        }
    }
}
