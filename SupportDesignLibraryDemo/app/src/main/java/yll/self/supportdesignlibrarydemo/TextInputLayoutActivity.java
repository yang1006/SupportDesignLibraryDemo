package yll.self.supportdesignlibrarydemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by yll on 2016/3/7.
 *  setHint()：设置提示语。
    getEditText()：得到TextInputLayout中的EditView控件。
    setErrorEnabled():设置是否可以显示错误信息。
    setError()：设置当用户输入错误时弹出的错误信息。
 */
public class TextInputLayoutActivity extends Activity implements View.OnClickListener {


    private TextInputLayout text_input1, text_input2;
    private EditText editText1, editText2;
    private Button btn_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        init();
    }

    private void init(){
        text_input1 = (TextInputLayout) findViewById(R.id.button);
        text_input2 = (TextInputLayout) findViewById(R.id.button2);
        editText1 = text_input1.getEditText();
        editText2 = text_input2.getEditText();
        btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (editText1.getText().toString().length()>=15){
            text_input1.setError("长度不得超过15");
            return;
        }else {
            text_input1.setError(null);
        }

        if (editText2.getText().toString().length() <= 8) {
            text_input2.setError("长度不得小于8");
            return;
        }else {
            text_input2.setError(null);
        }

        Toast.makeText(TextInputLayoutActivity.this, "登录成功", Toast.LENGTH_LONG).show();
    }
}
