package com.example.android.inputmethod;

import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.android.zxingtestapp.R;

/**
 * Created by Android on 2018/3/30.
 */

public class InputActivity extends ActionBarActivity {
    private KeyboardBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        KeyboardView keyboardView = (KeyboardView) findViewById(R.id.keyboardview);
        builder = new KeyboardBuilder(this, keyboardView, R.xml.keys_layout);
        EditText editText = (EditText) findViewById(R.id.input_password);
        builder.registerEditText(editText);
        EditText editText2 = (EditText) findViewById(R.id.input_password2);
        builder.registerEditText(editText2);
    }

    @Override
    public void onBackPressed() {
        if (builder != null && builder.isCustomKeyboardVisible()) {
            builder.hideCustomKeyboard();
        } else {
            this.finish();
        }
    }


}
