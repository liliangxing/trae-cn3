package com.bytedance.ies.bullet.kit.web;

import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.bytedance.android.anniex.R;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: SearchActionCallBack.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/kit/web/SearchActionCallBack;", "Landroid/view/ActionMode$Callback;", "()V", "currentMode", "Landroid/view/ActionMode;", "onActionItemClicked", "", "mode", "item", "Landroid/view/MenuItem;", "onCreateActionMode", "menu", "Landroid/view/Menu;", "onDestroyActionMode", "", "onPrepareActionMode", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SearchActionCallBack implements ActionMode.Callback {
    private ActionMode currentMode;

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        if (menu != null) {
            int i = 0;
            int i2 = 0;
            for (int size = menu.size() - 1; -1 < size; size--) {
                MenuItem item = menu.getItem(size);
                if (item.getItemId() == 16908321) {
                    i = item.getGroupId();
                    i2 = item.getOrder();
                }
            }
            menu.add(i, R.id.bullet_web_selection_search, i2 + 1, "搜索");
        }
        this.currentMode = mode;
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        if (menu != null) {
            for (int size = menu.size() - 1; -1 < size; size--) {
                try {
                    MenuItem item = menu.getItem(size);
                    CharSequence title = item.getTitle();
                    Log.d("SearchTextSelection", "title = " + ((Object) title) + " itemId = " + item.getItemId());
                    boolean z = false;
                    if (title != null && StringsKt.contains$default(title, "搜索", false, 2, (Object) null)) {
                        z = true;
                    }
                    if (z && item.getItemId() != R.id.bullet_web_selection_search) {
                        menu.removeItem(item.getItemId());
                    }
                } catch (Exception unused) {
                }
            }
        }
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        Integer valueOf = item != null ? Integer.valueOf(item.getItemId()) : null;
        int i = R.id.bullet_web_selection_search;
        if (valueOf == null || valueOf.intValue() != i || mode == null) {
            return false;
        }
        mode.finish();
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode mode) {
        this.currentMode = null;
    }
}
