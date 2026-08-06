package com.google.android.material.internal;

import android.content.Context;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class NavigationSubMenu extends SubMenuBuilder {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, MenuItemImpl menuItemImpl) {
        super(context, navigationMenu, menuItemImpl);
    }

    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        getParentMenu().onItemsChanged(z);
    }
}
