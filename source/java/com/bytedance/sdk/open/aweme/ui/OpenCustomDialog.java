package com.bytedance.sdk.open.aweme.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.open.aweme.R;

/* loaded from: classes5.dex */
public class OpenCustomDialog extends Dialog {
    Builder builder;

    /* loaded from: classes5.dex */
    public static class Builder {
        private Context context;
        private int height;
        private View mContentView;
        private String mMessage;
        private DialogInterface.OnClickListener mNegativeListener;
        private String mNegativeText;
        private boolean mOnlyConfirm = false;
        private DialogInterface.OnClickListener mPositiveListener;
        private String mPositiveText;

        public Builder(Context context) {
            this.context = context;
        }

        public OpenCustomDialog create() {
            return new OpenCustomDialog(this, null);
        }

        public Builder setContentView(View view) {
            this.mContentView = view;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setMessage(String str) {
            this.mMessage = str;
            return this;
        }

        public Builder setNegativeListener(DialogInterface.OnClickListener onClickListener) {
            this.mNegativeListener = onClickListener;
            return this;
        }

        public Builder setNegativeText(String str) {
            this.mNegativeText = str;
            return this;
        }

        public Builder setOnlyConfirm(boolean z) {
            this.mOnlyConfirm = z;
            return this;
        }

        public Builder setPositiveListener(DialogInterface.OnClickListener onClickListener) {
            this.mPositiveListener = onClickListener;
            return this;
        }

        public Builder setPositiveText(String str) {
            this.mPositiveText = str;
            return this;
        }
    }

    /* loaded from: classes5.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OpenCustomDialog.this.builder.mPositiveListener.onClick(OpenCustomDialog.this, 1);
        }
    }

    /* loaded from: classes5.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OpenCustomDialog.this.builder.mNegativeListener.onClick(OpenCustomDialog.this, 0);
        }
    }

    private OpenCustomDialog(Builder builder) {
        super(builder.context, R.style.custom_dialog);
        this.builder = builder;
    }

    /* synthetic */ OpenCustomDialog(Builder builder, a aVar) {
        this(builder);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.openplatform_open_custom_dialog);
        if (!TextUtils.isEmpty(this.builder.mMessage)) {
            ((TextView) findViewById(R.id.content_tv)).setText(this.builder.mMessage);
        }
        TextView textView = (TextView) findViewById(R.id.confirm);
        if (!TextUtils.isEmpty(this.builder.mPositiveText)) {
            textView.setText(this.builder.mPositiveText);
        }
        if (this.builder.mPositiveListener != null) {
            textView.setOnClickListener(new a());
        }
        TextView textView2 = (TextView) findViewById(R.id.cancel);
        if (!TextUtils.isEmpty(this.builder.mNegativeText)) {
            textView2.setText(this.builder.mNegativeText);
        }
        if (this.builder.mNegativeListener != null) {
            textView2.setOnClickListener(new b());
        }
        if (this.builder.mOnlyConfirm) {
            findViewById(R.id.vertical_divide).setVisibility(8);
            textView2.setVisibility(8);
        }
        if (this.builder.mContentView != null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content_fl);
            frameLayout.addView(this.builder.mContentView, new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setVisibility(0);
            ((TextView) findViewById(R.id.content_tv)).setVisibility(8);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        WindowManager.LayoutParams attributes;
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            if (this.builder.height > 0) {
                attributes.height = this.builder.height;
            } else {
                attributes.height = -2;
            }
            attributes.width = -2;
            attributes.gravity = 17;
        }
        super.onStart();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }
}
