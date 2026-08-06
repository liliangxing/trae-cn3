package com.bytedance.bdturing.comonui;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DialogParam {
    private static String DEFAULT_MSG_COLOR = "#bf161823";
    private static String DEFAULT_TITLE_COLOR = "#161823";
    public AgreementConfig agreement;
    public boolean back_close_enable;
    public String bg_color;
    public List<ButtonConfig> buttonConfigList;
    public String divide_line_color;
    public TextConfig message;
    public TextConfig title;
    public boolean touch_outside_close;

    /* loaded from: classes3.dex */
    public static class AgreementConfig {
        public String agreement_url;
        public CheckBoxConfig checkBox;
        public String title;
    }

    /* loaded from: classes3.dex */
    public static class CheckBoxConfig {
        public String checked_bg_color;
        public String checked_color;
        public String stroken_color;
    }

    /* loaded from: classes3.dex */
    public static class TextConfig {
        public boolean bold_style = false;
        public String text;
        public String text_color;
        public double text_size;
    }

    public DialogParam(String str) {
        this.back_close_enable = false;
        this.touch_outside_close = false;
        this.divide_line_color = "#1f161823";
        this.bg_color = "#ffffff";
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.back_close_enable = jSONObject.optBoolean("back_close_enable", false);
            this.touch_outside_close = jSONObject.optBoolean("touch_outside_close", false);
            this.bg_color = jSONObject.optString("bg_color", "#ffffff");
            this.divide_line_color = jSONObject.optString("divide_line_color", "#1f161823");
            JSONObject optJSONObject = jSONObject.optJSONObject("title");
            if (optJSONObject != null) {
                TextConfig textConfig = new TextConfig();
                textConfig.text = optJSONObject.optString("text", "");
                textConfig.text_color = optJSONObject.optString("text_color", "#161823");
                textConfig.text_size = optJSONObject.optDouble("text_size", 17.0d);
                textConfig.bold_style = optJSONObject.optBoolean("bold_style", false);
                this.title = textConfig;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("message");
            if (optJSONObject2 != null) {
                TextConfig textConfig2 = new TextConfig();
                textConfig2.text = optJSONObject2.optString("text", "");
                textConfig2.text_color = optJSONObject2.optString("text_color", "#bf161823");
                textConfig2.text_size = optJSONObject2.optDouble("text_size", 14.0d);
                textConfig2.bold_style = optJSONObject2.optBoolean("bold_style", false);
                this.message = textConfig2;
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("agreement");
            if (optJSONObject3 != null) {
                this.agreement = new AgreementConfig();
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("check_box");
                if (optJSONObject4 != null) {
                    CheckBoxConfig checkBoxConfig = new CheckBoxConfig();
                    checkBoxConfig.stroken_color = optJSONObject4.optString("stroken_color", "#000000");
                    checkBoxConfig.checked_bg_color = optJSONObject4.optString("checked_bg_color", "#0000ff");
                    checkBoxConfig.checked_color = optJSONObject4.optString("checked_color", "#ffffff");
                    this.agreement.checkBox = checkBoxConfig;
                }
                this.agreement.title = optJSONObject3.optString("title", "");
                this.agreement.agreement_url = optJSONObject3.optString("agreement_url", "");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("btn_array");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            this.buttonConfigList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
                if (optJSONObject5 != null) {
                    ButtonConfig buttonConfig = new ButtonConfig();
                    buttonConfig.text = optJSONObject5.optString("text");
                    buttonConfig.text_color = optJSONObject5.optString("text_color", "#161823");
                    buttonConfig.bold_style = optJSONObject5.optBoolean("bold_style", false);
                    buttonConfig.text_size = optJSONObject5.optDouble("text_size");
                    buttonConfig.on_click = optJSONObject5.optInt("on_click", 0);
                    this.buttonConfigList.add(buttonConfig);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float getTitleTextSize() {
        TextConfig textConfig = this.title;
        if (textConfig == null || textConfig.text_size <= 0.0d) {
            return 17.0f;
        }
        return (float) this.title.text_size;
    }

    public boolean titleBoldStyle() {
        TextConfig textConfig = this.title;
        return textConfig != null && textConfig.bold_style;
    }

    public boolean contentBoldStyle() {
        TextConfig textConfig = this.message;
        return textConfig != null && textConfig.bold_style;
    }

    public int getTitleTextColor() {
        TextConfig textConfig = this.title;
        if (textConfig == null) {
            return -16777216;
        }
        try {
            return Color.parseColor(!TextUtils.isEmpty(textConfig.text_color) ? this.title.text_color : "#161823");
        } catch (Exception e) {
            e.printStackTrace();
            return -16777216;
        }
    }

    public CharSequence getTitle() {
        TextConfig textConfig = this.title;
        return (textConfig == null || TextUtils.isEmpty(textConfig.text)) ? "" : this.title.text;
    }

    public float getContentTextSize() {
        TextConfig textConfig = this.message;
        if (textConfig == null || textConfig.text_size <= 0.0d) {
            return 14.0f;
        }
        return (float) this.message.text_size;
    }

    public int getContentTextColor() {
        try {
            if (this.message == null) {
                return Color.parseColor(DEFAULT_MSG_COLOR);
            }
            return -16777216;
        } catch (Exception e) {
            e.printStackTrace();
            return -16777216;
        }
    }

    public CharSequence getContent() {
        TextConfig textConfig = this.message;
        return textConfig != null ? textConfig.text : "";
    }

    public int getDivideColor() {
        try {
            String str = !TextUtils.isEmpty(this.divide_line_color) ? this.divide_line_color : "#1f161823";
            this.divide_line_color = str;
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return -3355444;
        }
    }

    /* loaded from: classes3.dex */
    public static class ButtonConfig {
        public static final int ON_CLICK_TYPE_CANCEL = 0;
        public static final int ON_CLICK_TYPE_CONFIRM = 1;
        public boolean bold_style = false;
        public int on_click = 0;
        public String text;
        public String text_color;
        public double text_size;

        public float getTextSize() {
            double d = this.text_size;
            if (d > 0.0d) {
                return (float) d;
            }
            return 15.0f;
        }

        public int getTextColor() {
            try {
                String str = !TextUtils.isEmpty(this.text_color) ? this.text_color : "#161823";
                this.text_color = str;
                return Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
                return -16777216;
            }
        }

        public String getText() {
            return !TextUtils.isEmpty(this.text) ? this.text : "";
        }
    }
}
