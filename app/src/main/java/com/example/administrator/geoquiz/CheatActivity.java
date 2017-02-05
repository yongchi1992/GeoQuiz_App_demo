package com.example.administrator.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/11/6.
 */

public class CheatActivity extends Activity {
    private static final String TAG = "CheatActivity";
    private static final String KEY_INDEX = "index";
    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.administrator.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.administrator.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;
    private boolean mIsCheat=false;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data =new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown);
        setResult(RESULT_OK,data);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState != null) {
            mIsCheat = savedInstanceState.getBoolean(KEY_INDEX, false);
        }
        setAnswerShownResult(mIsCheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);
        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mAnswerIsTrue){
                    mAnswerTextView.setText(R.string.true_button);
                }
                else{
                    mAnswerTextView.setText(R.string.false_button);
                }
                mIsCheat = true;
                setAnswerShownResult(mIsCheat);
            }
        });

        if(mIsCheat)
        {
            if(mAnswerIsTrue){
                mAnswerTextView.setText(R.string.true_button);
            }
            else{
                mAnswerTextView.setText(R.string.false_button);
            }
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean(KEY_INDEX, mIsCheat);

    }
}
