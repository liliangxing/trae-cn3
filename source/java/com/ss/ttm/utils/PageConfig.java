package com.ss.ttm.utils;

/* loaded from: classes7.dex */
public class PageConfig extends ReuseConfig {
    public PageConfig(UserConfig user) {
        super(user, 0);
    }

    private PageConfig(PageConfig page) {
        super(page, 1);
    }

    public PageConfig copy() {
        return new PageConfig(this);
    }
}
