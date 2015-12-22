package com.example.studio.android.bo.testmoi.customview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by User on 12/18/2015.
 */
public class TextViewCooperLight extends TextView {
        public TextViewCooperLight(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init();
        }

        public TextViewCooperLight(Context context, AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        public TextViewCooperLight(Context context) {
            super(context);
            init();
        }

    public void init() {
        if (!isInEditMode()) {

            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/CooperHewitt-Light.otf");//FontCache.get("fonts/CooperHewitt-Light.otf", getContext());
            setTypeface(tf);
        }
    }

    public void setUnderLine() {
        SpannableString spannableString = new SpannableString(getText());
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        setText(spannableString);
        invalidate();
    }
}
