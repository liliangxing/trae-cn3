package com.bytedance.trae.common.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;

/* compiled from: TraceFragment.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/common/fragment/TraceFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "enterPageTraced", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "autoLogEnterPage", "logEnterPage", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public abstract class TraceFragment extends Fragment {
    private boolean enterPageTraced;

    public abstract boolean autoLogEnterPage();

    public void logEnterPage() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onResume() {
        super.onResume();
        if (!autoLogEnterPage() || this.enterPageTraced) {
            return;
        }
        logEnterPage();
        this.enterPageTraced = true;
    }
}
