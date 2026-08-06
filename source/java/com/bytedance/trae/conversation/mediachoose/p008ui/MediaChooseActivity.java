package com.bytedance.trae.conversation.mediachoose.p008ui;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.trae.common.activity.TraeCommonAppCompatActivity;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* compiled from: MediaChooseActivity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseActivity;", "Lcom/bytedance/trae/common/activity/TraeCommonAppCompatActivity;", "<init>", "()V", "getDecorViewBackgroundColor", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MediaChooseActivity extends TraeCommonAppCompatActivity {
    /* renamed from: com_bytedance_trae_conversation_mediachoose_ui_MediaChooseActivity__onStop$___twin___ */
    public void m832x95183967() {
        super.onStop();
    }

    protected void onStop() {
        m831x9e411cf4(this);
    }

    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public int getDecorViewBackgroundColor() {
        return getColor(C0591R.color.trae_bg_bg_base_default);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.trae.common.activity.TraeCommonAppCompatActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0637R.layout.trae_media_choose_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(C0637R.id.trae_media_choose_container, new MediaChooseFragment()).commit();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_trae_conversation_mediachoose_ui_MediaChooseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m831x9e411cf4(MediaChooseActivity mediaChooseActivity) {
        mediaChooseActivity.m832x95183967();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                ((Activity) mediaChooseActivity).getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
