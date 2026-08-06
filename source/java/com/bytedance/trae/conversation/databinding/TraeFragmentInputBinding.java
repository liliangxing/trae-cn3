package com.bytedance.trae.conversation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.widget.MinimizedVoiceBar;
import com.bytedance.trae.conversation.widget.TranscriptEditText;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeFragmentInputBinding implements ViewBinding {
    public final FrameLayout bottomContextualBar;
    public final LinearLayout btnBranch;
    public final ImageView btnChatNew;
    public final LinearLayout btnDevice;
    public final ImageView btnExpressPass;
    public final LinearLayout btnExtend;
    public final LinearLayout btnGithub;
    public final ImageView btnHoldToTalk;
    public final ImageView btnMicrophone;
    public final ImageView btnPause;
    public final ImageView btnPlus;
    public final LinearLayout btnSelectFolder;
    public final ImageView btnSendText;
    public final TranscriptEditText etInput;
    public final LinearLayout fullInputContainer;
    public final ImageView imgSelectBranch;
    public final RelativeLayout inputBottom;
    public final ImageView ivCloudIcon;
    public final ImageView ivDeviceBadge;
    public final ImageView ivDeviceIcon;
    public final ImageView ivExpressPassBenefitClose;
    public final ImageView ivExpressPassBenefitIcon;
    public final ImageView ivRepoIcon;
    public final LinearLayout llCloud;
    public final LinearLayout llCloudContent;
    public final LinearLayout llDeviceFolderBar;
    public final LinearLayout llExpressPassBenefit;
    public final LinearLayout mainInputArea;
    public final MinimizedVoiceBar minimizedVoiceBar;
    public final LinearLayout modelSelector;
    private final LinearLayout rootView;
    public final RecyclerView rvAttachments;
    public final ProgressBar sending;
    public final TextView tvBranchName;
    public final TextView tvCloudName;
    public final ImageView tvCloudStatus;
    public final TextView tvDeviceName;
    public final TextView tvExpressPassBenefit;
    public final TextView tvFolderName;
    public final TextView tvHoldToTalk;
    public final TextView tvModelName;
    public final TextView tvRepoName;
    public final ViewStub vsTaskTemplates;

    private TraeFragmentInputBinding(LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, ImageView imageView2, LinearLayout linearLayout4, LinearLayout linearLayout5, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout6, ImageView imageView7, TranscriptEditText transcriptEditText, LinearLayout linearLayout7, ImageView imageView8, RelativeLayout relativeLayout, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, MinimizedVoiceBar minimizedVoiceBar, LinearLayout linearLayout13, RecyclerView recyclerView, ProgressBar progressBar, TextView textView, TextView textView2, ImageView imageView15, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ViewStub viewStub) {
        this.rootView = linearLayout;
        this.bottomContextualBar = frameLayout;
        this.btnBranch = linearLayout2;
        this.btnChatNew = imageView;
        this.btnDevice = linearLayout3;
        this.btnExpressPass = imageView2;
        this.btnExtend = linearLayout4;
        this.btnGithub = linearLayout5;
        this.btnHoldToTalk = imageView3;
        this.btnMicrophone = imageView4;
        this.btnPause = imageView5;
        this.btnPlus = imageView6;
        this.btnSelectFolder = linearLayout6;
        this.btnSendText = imageView7;
        this.etInput = transcriptEditText;
        this.fullInputContainer = linearLayout7;
        this.imgSelectBranch = imageView8;
        this.inputBottom = relativeLayout;
        this.ivCloudIcon = imageView9;
        this.ivDeviceBadge = imageView10;
        this.ivDeviceIcon = imageView11;
        this.ivExpressPassBenefitClose = imageView12;
        this.ivExpressPassBenefitIcon = imageView13;
        this.ivRepoIcon = imageView14;
        this.llCloud = linearLayout8;
        this.llCloudContent = linearLayout9;
        this.llDeviceFolderBar = linearLayout10;
        this.llExpressPassBenefit = linearLayout11;
        this.mainInputArea = linearLayout12;
        this.minimizedVoiceBar = minimizedVoiceBar;
        this.modelSelector = linearLayout13;
        this.rvAttachments = recyclerView;
        this.sending = progressBar;
        this.tvBranchName = textView;
        this.tvCloudName = textView2;
        this.tvCloudStatus = imageView15;
        this.tvDeviceName = textView3;
        this.tvExpressPassBenefit = textView4;
        this.tvFolderName = textView5;
        this.tvHoldToTalk = textView6;
        this.tvModelName = textView7;
        this.tvRepoName = textView8;
        this.vsTaskTemplates = viewStub;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TraeFragmentInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TraeFragmentInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C0637R.layout.trae_fragment_input, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static TraeFragmentInputBinding bind(View view) {
        RecyclerView findChildViewById;
        int i = C0637R.id.bottom_contextual_bar;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
        if (frameLayout != null) {
            i = C0637R.id.btn_branch;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = C0637R.id.btn_chat_new;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = C0637R.id.btn_device;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout2 != null) {
                        i = C0637R.id.btn_express_pass;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = C0637R.id.btn_extend;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = C0637R.id.btn_github;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout4 != null) {
                                    i = C0637R.id.btn_hold_to_talk;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = C0637R.id.btn_microphone;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = C0637R.id.btn_pause;
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView5 != null) {
                                                i = C0637R.id.btn_plus;
                                                ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView6 != null) {
                                                    i = C0637R.id.btn_select_folder;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout5 != null) {
                                                        i = C0637R.id.btn_send_text;
                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView7 != null) {
                                                            i = C0637R.id.et_input;
                                                            TranscriptEditText transcriptEditText = (TranscriptEditText) ViewBindings.findChildViewById(view, i);
                                                            if (transcriptEditText != null) {
                                                                i = C0637R.id.full_input_container;
                                                                LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout6 != null) {
                                                                    i = C0637R.id.img_select_branch;
                                                                    ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (imageView8 != null) {
                                                                        i = C0637R.id.input_bottom;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (relativeLayout != null) {
                                                                            i = C0637R.id.iv_cloud_icon;
                                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView9 != null) {
                                                                                i = C0637R.id.iv_device_badge;
                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                if (imageView10 != null) {
                                                                                    i = C0637R.id.iv_device_icon;
                                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView11 != null) {
                                                                                        i = C0637R.id.iv_express_pass_benefit_close;
                                                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView12 != null) {
                                                                                            i = C0637R.id.iv_express_pass_benefit_icon;
                                                                                            ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                            if (imageView13 != null) {
                                                                                                i = C0637R.id.iv_repo_icon;
                                                                                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                if (imageView14 != null) {
                                                                                                    i = C0637R.id.ll_cloud;
                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                    if (linearLayout7 != null) {
                                                                                                        i = C0637R.id.ll_cloud_content;
                                                                                                        LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                        if (linearLayout8 != null) {
                                                                                                            i = C0637R.id.ll_device_folder_bar;
                                                                                                            LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout9 != null) {
                                                                                                                i = C0637R.id.ll_express_pass_benefit;
                                                                                                                LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                if (linearLayout10 != null) {
                                                                                                                    i = C0637R.id.main_input_area;
                                                                                                                    LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout11 != null) {
                                                                                                                        i = C0637R.id.minimized_voice_bar;
                                                                                                                        MinimizedVoiceBar minimizedVoiceBar = (MinimizedVoiceBar) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (minimizedVoiceBar != null) {
                                                                                                                            i = C0637R.id.model_selector;
                                                                                                                            LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout12 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = C0637R.id.rv_attachments))) != null) {
                                                                                                                                i = C0637R.id.sending;
                                                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (progressBar != null) {
                                                                                                                                    i = C0637R.id.tv_branch_name;
                                                                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView != null) {
                                                                                                                                        i = C0637R.id.tv_cloud_name;
                                                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView2 != null) {
                                                                                                                                            i = C0637R.id.tv_cloud_status;
                                                                                                                                            ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (imageView15 != null) {
                                                                                                                                                i = C0637R.id.tv_device_name;
                                                                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView3 != null) {
                                                                                                                                                    i = C0637R.id.tv_express_pass_benefit;
                                                                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView4 != null) {
                                                                                                                                                        i = C0637R.id.tv_folder_name;
                                                                                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView5 != null) {
                                                                                                                                                            i = C0637R.id.tv_hold_to_talk;
                                                                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (textView6 != null) {
                                                                                                                                                                i = C0637R.id.tv_model_name;
                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                    i = C0637R.id.tv_repo_name;
                                                                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (textView8 != null) {
                                                                                                                                                                        i = C0637R.id.vs_task_templates;
                                                                                                                                                                        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (viewStub != null) {
                                                                                                                                                                            return new TraeFragmentInputBinding((LinearLayout) view, frameLayout, linearLayout, imageView, linearLayout2, imageView2, linearLayout3, linearLayout4, imageView3, imageView4, imageView5, imageView6, linearLayout5, imageView7, transcriptEditText, linearLayout6, imageView8, relativeLayout, imageView9, imageView10, imageView11, imageView12, imageView13, imageView14, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, minimizedVoiceBar, linearLayout12, findChildViewById, progressBar, textView, textView2, imageView15, textView3, textView4, textView5, textView6, textView7, textView8, viewStub);
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
