package com.example.laowai.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        start_up_show_this();//loads the previously saved shared settings
        //editText.setCursorVisible(false);
    }


    public static final String my_settings_xxx = "MyPrefsFile";
    //button clicks------------------------------------------------------------------
    public void buttonOnClick_2(View view) {
        int the_id = view.getId();
        //Toast.makeText(this, "xxx", Toast.LENGTH_SHORT).show();
        if (the_id == R.id.b_save) {
            //Toast.makeText(this, "shared_b1", Toast.LENGTH_SHORT).show();
//public static final String MY_PREFS_NAME = "MyPrefsFile";
            SharedPreferences.Editor editor = getSharedPreferences(my_settings_xxx, MODE_PRIVATE).edit();
            //String saved_first_name = "first name test";
            //String saved_url = "www.temp.com";

            EditText edit_text_name_v = (EditText)findViewById(R.id.edit_text_name);
            String saved_first_name = String.valueOf(edit_text_name_v.getText());
            editor.putString("key_first_name", saved_first_name);

            EditText edit_text_url_v = (EditText)findViewById(R.id.edit_text_url);
            String saved_url = String.valueOf(edit_text_url_v.getText());
            editor.putString("key_url", saved_url);

            editor.apply();
            Toast.makeText(this, "Data saved to shared preferences successfully", Toast.LENGTH_SHORT).show();
        }
        if (the_id == R.id.b_read) {

            SharedPreferences prefs = getSharedPreferences(my_settings_xxx, MODE_PRIVATE);
            String temp_xxx = prefs.getString("key_first_name","default_default");
            EditText edit_text_name_v = (EditText)findViewById(R.id.edit_text_name);
            edit_text_name_v.setText(temp_xxx);

            //SharedPreferences prefs = getSharedPreferences(my_settings_xxx, MODE_PRIVATE);
            String temp_yyy = prefs.getString("key_url","default_default");
            EditText edit_text_url_v = (EditText)findViewById(R.id.edit_text_url);
            edit_text_url_v.setText(temp_yyy);
        }
        if (the_id == R.id.b_clear) {
            EditText edit_text_name_v = (EditText)findViewById(R.id.edit_text_name);
            edit_text_name_v.setText("");

            EditText edit_text_url_v = (EditText)findViewById(R.id.edit_text_url);
            edit_text_url_v.setText("");
        }
    }
public void start_up_show_this(){
    SharedPreferences prefs = getSharedPreferences(my_settings_xxx, MODE_PRIVATE);
    String temp_xxx = prefs.getString("key_first_name","default_default");
    EditText edit_text_name_v = (EditText)findViewById(R.id.edit_text_name);
    edit_text_name_v.setText(temp_xxx);

    //SharedPreferences prefs = getSharedPreferences(my_settings_xxx, MODE_PRIVATE);
    String temp_yyy = prefs.getString("key_url","default_default");
    EditText edit_text_url_v = (EditText)findViewById(R.id.edit_text_url);
    edit_text_url_v.setText(temp_yyy);
}

}
