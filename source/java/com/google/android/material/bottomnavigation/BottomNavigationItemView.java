package com.google.android.material.bottomnavigation;

import android.content.Context;
import com.google.android.material.C0425R;
import com.google.android.material.navigation.NavigationBarItemView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class BottomNavigationItemView extends NavigationBarItemView {
    public BottomNavigationItemView(Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemLayoutResId() {
        return C0425R.layout.design_bottom_navigation_item;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    protected int getItemDefaultMarginResId() {
        return C0425R.dimen.design_bottom_navigation_margin;
    }
}
