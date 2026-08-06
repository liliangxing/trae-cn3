package com.ss.android.update;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes7.dex */
public class UpdateContentLinearLayout extends LinearLayout {
    private TextView mUpdateContent;

    public UpdateContentLinearLayout(Context context) {
        this(context, null);
    }

    public UpdateContentLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R.layout.update_content_layout, this);
        bindView();
    }

    private void bindView() {
        this.mUpdateContent = (TextView) findViewById(R.id.update_check_description);
    }

    public void bindUpdateContent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mUpdateContent.setText(str);
    }
}
