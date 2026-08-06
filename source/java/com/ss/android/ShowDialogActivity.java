package com.ss.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.account.R;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.ss.android.account.TTAccountInit;
import com.ss.ttm.player.C0968C;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ShowDialogActivity extends Activity {
    public static final String EVENT_DIALOG = "event_dialog";
    public static final String KEY_EVENT = "event";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_TITLE = "title";

    public void com_ss_android_ShowDialogActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onStop() {
        m43x1296ce45(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_show_dialog);
        if (TTAccountInit.getConfig().isLocalTest()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        dealWithEvent();
    }

    private void dealWithEvent() {
        Intent intent = getIntent();
        if (TextUtils.equals(intent.getStringExtra("event"), EVENT_DIALOG)) {
            showDialogInner(intent.getStringExtra("title"), intent.getStringExtra("message"));
        }
    }

    private void showDialogInner(String str, String str2) {
        new AlertDialog.Builder(this).setTitle(str).setMessage(str2 + "\nPlease confirm that account adk is initialized correctly.").setPositiveButton("ok", new DialogInterface.OnClickListener() { // from class: com.ss.android.ShowDialogActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ShowDialogActivity.this.finish();
            }
        }).setCancelable(false).show();
    }

    public static void showDialog(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) ShowDialogActivity.class);
        intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
        intent.putExtra("event", EVENT_DIALOG);
        intent.putExtra("title", str);
        intent.putExtra("message", str2);
        context.startActivity(intent);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_ss_android_ShowDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m43x1296ce45(ShowDialogActivity showDialogActivity) {
        showDialogActivity.com_ss_android_ShowDialogActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                showDialogActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
