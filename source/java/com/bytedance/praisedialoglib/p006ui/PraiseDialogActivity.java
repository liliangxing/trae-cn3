package com.bytedance.praisedialoglib.p006ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.praisedialoglib.C0497R;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.praisedialoglib.manager.PraiseDialogManager;
import com.bytedance.praisedialoglib.utils.EventReportUtil;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PraiseDialogActivity extends Activity {
    private RelativeLayout mBackground;
    private ImageView mCenterImg;
    private ImageView mCloseImageView;
    private TextView mComplainTv;
    private String mFrom = "";
    private boolean mIsUserClickBadOrGoodBtn = false;
    private TextView mPraiseTv;
    private TextView mSecondTitleTv;
    private TextView mTitleTv;

    @Override // android.app.Activity
    protected void onStop() {
        m230x44f869ae(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0497R.layout.praise_dialog);
        initView();
        handleIntent();
    }

    private void handleIntent() {
        Intent intent = getIntent();
        this.mFrom = intent.getStringExtra(PraiseDialogConstant.FROM);
        if (intent.getIntExtra(PraiseDialogConstant.BACKGROUND_RES, -1) != -1) {
            this.mBackground.setBackgroundResource(intent.getIntExtra(PraiseDialogConstant.BACKGROUND_RES, -1));
        }
        if (intent.getIntExtra(PraiseDialogConstant.MIDDLE_IMAGE_RES, -1) != -1) {
            this.mCenterImg.setBackgroundResource(intent.getIntExtra(PraiseDialogConstant.MIDDLE_IMAGE_RES, -1));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra(PraiseDialogConstant.MAIN_TITLE_TEXT))) {
            this.mTitleTv.setText(intent.getStringExtra(PraiseDialogConstant.MAIN_TITLE_TEXT));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra(PraiseDialogConstant.MAIN_TITLE_TEXT_COLOR))) {
            this.mTitleTv.setTextColor(Color.parseColor(intent.getStringExtra(PraiseDialogConstant.MAIN_TITLE_TEXT_COLOR)));
        }
        if (intent.getIntExtra(PraiseDialogConstant.MAIN_TITLE_TEXT_SIZE, -1) != -1) {
            this.mTitleTv.setTextSize(intent.getIntExtra(PraiseDialogConstant.MAIN_TITLE_TEXT_SIZE, -1));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra(PraiseDialogConstant.SECOND_TITLE_TEXT))) {
            this.mSecondTitleTv.setText(intent.getStringExtra(PraiseDialogConstant.SECOND_TITLE_TEXT));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra(PraiseDialogConstant.SECOND_TITLE_TEXT_COLOR))) {
            this.mSecondTitleTv.setTextColor(Color.parseColor(intent.getStringExtra(PraiseDialogConstant.SECOND_TITLE_TEXT_COLOR)));
        }
        if (intent.getIntExtra(PraiseDialogConstant.SECOND_TITLE_TEXT_SIZE, -1) != -1) {
            this.mSecondTitleTv.setTextSize(intent.getIntExtra(PraiseDialogConstant.SECOND_TITLE_TEXT_SIZE, -1));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT))) {
            this.mComplainTv.setText(intent.getStringExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT));
        }
        if (intent.getIntExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_SIZE, -1) != -1) {
            this.mComplainTv.setTextSize(intent.getIntExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_SIZE, -1));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_COLOR))) {
            this.mComplainTv.setTextColor(Color.parseColor(intent.getStringExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_COLOR)));
        }
        if (intent.getIntExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_BG, -1) != -1) {
            this.mComplainTv.setBackgroundResource(intent.getIntExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_BG, -1));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT))) {
            this.mPraiseTv.setText(intent.getStringExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT));
        }
        if (intent.getIntExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_SIZE, -1) != -1) {
            this.mPraiseTv.setTextSize(intent.getIntExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_SIZE, -1));
        }
        if (!TextUtils.isEmpty(intent.getStringExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_COLOR))) {
            this.mPraiseTv.setTextColor(Color.parseColor(intent.getStringExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_COLOR)));
        }
        if (intent.getIntExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_BG, -1) != -1) {
            this.mPraiseTv.setBackgroundResource(intent.getIntExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_BG, -1));
        }
    }

    private void initView() {
        this.mBackground = (RelativeLayout) findViewById(C0497R.id.dialog_container);
        this.mTitleTv = (TextView) findViewById(C0497R.id.market_feedback_dialog_title);
        this.mSecondTitleTv = (TextView) findViewById(C0497R.id.market_feedback_dialog_tips);
        this.mComplainTv = (TextView) findViewById(C0497R.id.tv_market_feedback_dialog_complaint);
        this.mPraiseTv = (TextView) findViewById(C0497R.id.tv_market_feedback_dialog_praise);
        this.mCloseImageView = (ImageView) findViewById(C0497R.id.market_feedback_dialog_close);
        this.mCenterImg = (ImageView) findViewById(C0497R.id.market_feedback_dialog_center);
        this.mCloseImageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.praisedialoglib.ui.PraiseDialogActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PraiseDialogActivity.this.finish();
            }
        });
        this.mPraiseTv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.praisedialoglib.ui.PraiseDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_GOOD, PraiseDialogActivity.this.mFrom);
                PraiseDialogActivity.this.mIsUserClickBadOrGoodBtn = true;
                PraiseDialogActivity.this.finish();
                PraiseDialogManager.getInstance().goToMarket();
            }
        });
        this.mComplainTv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.praisedialoglib.ui.PraiseDialogActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_BAD, PraiseDialogActivity.this.mFrom);
                PraiseDialogActivity.this.mIsUserClickBadOrGoodBtn = true;
                PraiseDialogActivity.this.finish();
                PraiseDialogManager.getInstance().goToAppFeedback();
            }
        });
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_SHOW, this.mFrom);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        if (this.mIsUserClickBadOrGoodBtn) {
            EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_FORCE_CLOSE, this.mFrom);
        } else {
            EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_CLOSE, this.mFrom);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    /* renamed from: com_bytedance_praisedialoglib_ui_PraiseDialogActivity__onStop$___twin___ */
    public void m231xe50bf86d() {
        super.onStop();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    /* renamed from: com_bytedance_praisedialoglib_ui_PraiseDialogActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop */
    public static void m230x44f869ae(PraiseDialogActivity praiseDialogActivity) {
        praiseDialogActivity.m231xe50bf86d();
        if (EnterTransitionCrashOptimizer.getContext() != null) {
            try {
                praiseDialogActivity.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();
            } catch (Throwable unused) {
            }
        }
    }
}
