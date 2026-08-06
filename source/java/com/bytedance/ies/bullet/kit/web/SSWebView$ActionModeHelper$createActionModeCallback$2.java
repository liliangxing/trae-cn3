package com.bytedance.ies.bullet.kit.web;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import kotlin.Metadata;

/* compiled from: SSWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000e"}, d2 = {"com/bytedance/ies/bullet/kit/web/SSWebView$ActionModeHelper$createActionModeCallback$2", "Landroid/view/ActionMode$Callback;", "onActionItemClicked", "", "mode", "Landroid/view/ActionMode;", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onDestroyActionMode", "", "onPrepareActionMode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SSWebView$ActionModeHelper$createActionModeCallback$2 implements ActionMode.Callback {
    final /* synthetic */ SSWebView.ActionModeHelper.IActionModeCallbackDelegate $delegate;

    SSWebView$ActionModeHelper$createActionModeCallback$2(SSWebView.ActionModeHelper.IActionModeCallbackDelegate iActionModeCallbackDelegate) {
        this.$delegate = iActionModeCallbackDelegate;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return this.$delegate.onCreateActionMode(mode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return this.$delegate.onPrepareActionMode(mode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return this.$delegate.onActionItemClicked(mode, item);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode mode) {
        this.$delegate.onDestroyActionMode(mode);
    }
}
