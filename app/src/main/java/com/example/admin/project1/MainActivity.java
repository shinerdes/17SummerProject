package com.example.admin.project1;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.R.attr.button;
import static android.R.attr.value;
import static android.os.SystemClock.sleep;
import static java.lang.Math.abs;


//import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {
    Chronometer mChronometer;


    List<ImageButton> ibt = new ArrayList<ImageButton>();
int counttw=0;
    int flag=0;
    int cheak=100;
    int max=0;
    int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0;
    int han=1;
    String cur_time;
    String cur_time1;
    Button button;
    public static final int MSG_DAY_PASSED = 1;


   public Context thisActivity = (Context)this;
    public DateHandler dateHandler = new DateHandler();
    public class DateHandler extends Handler
    {
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case MSG_DAY_PASSED:han=1;
                    break;

            }
        }
    }
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // button = (Button)findViewById(R.id.ch_btn);
        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        //button = (Button)findViewById(R.id.ch_btn);
        View.OnClickListener mStartListener;
        mChronometer.start();
        setTitle("카드 짝 맞추기");

        //button.setOnClickListener(mStartListener);
        mChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                 cur_time=   mChronometer.getText().toString();
                cur_time1=mChronometer.getText().toString();
                int stringLength = cur_time.length();
               String a=cur_time.substring(8,stringLength);

                String b=cur_time.substring(6,7);
                int min= Integer.parseInt(b );

                int sec= Integer.parseInt(a );
                ProgressBar progress = (ProgressBar) findViewById(R.id.progressBar) ;
                progress.setProgress(120-(min*60+sec)) ;
                if (cur_time.equals("경과시간 02:00")) {



                    mChronometer.stop();
                    setContentView(R.layout.restart);
                    TextView tv=(TextView) findViewById(R.id.textView);



                    Button btn1 = (Button) findViewById(R.id.button1);
                    Button btn2 = (Button) findViewById(R.id.button2);

                    btn1.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });

                    btn2.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View v){
                            finish();
                        }
                    });
                }
            }
        });

     /*   button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                mChronometer.start();
            }
        });*/



        //ibt[]
        ImageButton ib1,ib2,ib3,ib4,ib5,ib6,ib7,ib8,ib9,ib10,ib11,ib12,ib13,ib14,ib15,ib16;

        ib1 = (ImageButton) findViewById(R.id.imageButton1);
        ib2 = (ImageButton) findViewById(R.id.imageButton2);
        ib3 = (ImageButton) findViewById(R.id.imageButton3);
        ib4 = (ImageButton) findViewById(R.id.imageButton4);
        ib5 = (ImageButton) findViewById(R.id.imageButton5);
        ib6 = (ImageButton) findViewById(R.id.imageButton6);
        ib7 = (ImageButton) findViewById(R.id.imageButton7);
        ib8 = (ImageButton) findViewById(R.id.imageButton8);
        ib9 = (ImageButton) findViewById(R.id.imageButton9);
        ib10 = (ImageButton) findViewById(R.id.imageButton10);
        ib11 = (ImageButton) findViewById(R.id.imageButton11);
        ib12 = (ImageButton) findViewById(R.id.imageButton12);
        ib13 = (ImageButton) findViewById(R.id.imageButton13);
        ib14 = (ImageButton) findViewById(R.id.imageButton14);
        ib15 = (ImageButton) findViewById(R.id.imageButton15);
        ib16 = (ImageButton) findViewById(R.id.imageButton16);





        ibt.add(ib1);
        ibt.add(ib2);
        ibt.add(ib3);
        ibt.add(ib4);
        ibt.add(ib5);
        ibt.add(ib6);
        ibt.add(ib7);
        ibt.add(ib8);
        ibt.add(ib9);
        ibt.add(ib10);
        ibt.add(ib11);
        ibt.add(ib12);
        ibt.add(ib13);
        ibt.add(ib14);
        ibt.add(ib15);
        ibt.add(ib16); // 1차적 생성

        int random[] = new int[16];




        addListenerOnButton();
        int Lotto[] = new int[16];//1차원배열 방 10개를 만듭니다.
        int ran=0;    //랜덤값을 받을 변수를 만듭니다.
        boolean cheak;    // 비교하기 위해 boolean형 변수를 만듭니다.
        Random r = new Random();    // Random형 객체를 만듭니다.
        for (int i=0; i<Lotto.length; i++) {    // 배열의 크기만큼 for문을 돌립니다.
            ran = r.nextInt(16);    // nextInt(10)하면 0-9까지 나오므로  +1을 시켜 1-10까지로 만듭니다.
            cheak = true;    // i문이 돌 때마다 cheak를 true로 만듭니다.
            for (int j=0; j<i; j++) {    //if문 때문에 j를 i값만큼 돌립니다.
                if(Lotto[j] == ran) {
                    // arr배열의 방은 다 비어있는 상태이고 위에서 nextInt를 해야 하나씩 들어갑니다.
                    // 그러므로 i의 값만큼 배열에  들어가있는 것입니다.
                    // for문을 돌리면서  방금 받은 random값과 배열에 들어있는 값들을 비교하여 같은게 있으면
                    i--;    // i의 값을 하나 줄여 한 번 더 돌게 합니다.
                    cheak=false;    // 목적과는 다르게 같은 값이 나왔으므로 cheak를 false로 만듭니다.
                }
            }
            if(cheak)    // 위의if문의 조건을 만족하지 않았으면 자동으로 cheak는 true므로 실행이 됩니다.
                Lotto[i] = ran;   // ran에 받은 값을 arr[i]방에 넣습니다.
        }

        //중복없는 난수 생성






        ibt.remove(Lotto[0]);
        ibt.add(Lotto[0], ib1);
        ibt.remove(Lotto[1]);
        ibt.add(Lotto[1], ib2);
        ibt.remove(Lotto[2]);
        ibt.add(Lotto[2], ib3);
        ibt.remove(Lotto[3]);
        ibt.add(Lotto[3], ib4);
        ibt.remove(Lotto[4]);
        ibt.add(Lotto[4], ib5);
        ibt.remove(Lotto[5]);
        ibt.add(Lotto[5], ib6);
        ibt.remove(Lotto[6]);
        ibt.add(Lotto[6], ib7);
        ibt.remove(Lotto[7]);
        ibt.add(Lotto[7], ib8);
        ibt.remove(Lotto[8]);
        ibt.add(Lotto[8], ib9);
        ibt.remove(Lotto[9]);
        ibt.add(Lotto[9], ib10);
        ibt.remove(Lotto[10]);
        ibt.add(Lotto[10], ib11);
        ibt.remove(Lotto[11]);
        ibt.add(Lotto[11], ib12);
        ibt.remove(Lotto[12]);
        ibt.add(Lotto[12], ib13);
        ibt.remove(Lotto[13]);
        ibt.add(Lotto[13], ib14);
        ibt.remove(Lotto[14]);
        ibt.add(Lotto[14], ib15);
        ibt.remove(Lotto[15]);
        ibt.add(Lotto[15], ib16);


        //ARRAYLIST(0~15)

        addListenerOnButton();
    }


void restart (){

    mChronometer.stop();
    setContentView(R.layout.restart);
    TextView tv=(TextView) findViewById(R.id.textView);
            tv.setText(cur_time);


    Button btn1 = (Button) findViewById(R.id.button1);
    Button btn2 = (Button) findViewById(R.id.button2);

    btn1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    });

    btn2.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            finish();
        }
    });
}

    private void addListenerOnButton() {



        ibt.get(0).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) { if(han==2)return ;
                if(a==1){
                    return ;}
                if(han==2)
                    return ;
                int me=0;
                if(flag==0)
                {

                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.a));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.a));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){
                       counttw++;a=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)
                        restart();}//ㅅㅈ
                    else{max=3;
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {


                                     //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(0).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                max=0;
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);


                                //마지막 5번째가 실행이 되고 실행되는 메소드
                            }
                        }.start();}
                    flag=0;
                }
            }

        });


        ibt.get(1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(b==1)return ;
                if(han==2)
                    return ;
                int me=1;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.b));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                            ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.b));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;b=1;
                        Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8) restart ();}//ㅅㅈ
                   else{
                            CountDownTimer timer = new CountDownTimer(1000,1000) {
                                public void onTick(long millisUntilFinished) {
                                       //1초에 한번씩 2번 실행되는 메소드
                                }
                                public void onFinish() {
                                    ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                    ibt.get(1).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                    max=0;

                                    Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                    dateHandler.sendMessage(msg);


                                    //마지막 5번째가 실행이 되고 실행되는 메소드
                        }
                    }.start();}
                    flag=0;
                }
            }
        });


        ibt.get(2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(c==1)return ;
                int me=2;
                if(han==2)
                    return ;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.c));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.c));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;c=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8) restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {

                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(2).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ

                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                            }
                        }.start();}
                    flag=0;
                }
            }

        });


        ibt.get(3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(d==1)return ;
                if(han==2)
                    return ;
                int me=3;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.d));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                  else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.d));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;d=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {

                            }
                            public void onFinish() {

                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(3).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                max=0;//1초에 한번씩 2번 실행되는 메소드
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }
            }

        });


        ibt.get(4).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) { if(e==1)return ;
                if(han==2)
                    return ;


                int me=4;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.e));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.e));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;e=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(4).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                max=0;Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                            }
                        }.start();}
                    flag=0;
                }
            }

        });


        ibt.get(5).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) { if(f==1)return ;

                if(han==2)
return ;
                int me=5;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.f));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.f));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;f=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1500,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(5).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }
            }

        });


        ibt.get(6).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) { if(g==1)return ;
                if(han==2)return ;
                int me=6;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.g));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.g));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;g=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(6).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }

            }

        });


        ibt.get(7).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) { if(h==1)return ; if(han==2)return ;
                int me=7;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.h));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.h));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;h=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(7).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }

            }

        });


        ibt.get(8).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {if(a==1)return ; if(han==2)return ;

                int me=8;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.a));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.a));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;a=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(8).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                               Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }

            }

        });


        ibt.get(9).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {if(b==1)return ; if(han==2)return ;
                int me=9;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.b));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.b));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;b=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(9).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }
            }

        });


        ibt.get(10).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {if(c==1)return ; if(han==2)return ;

                int me=10;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.c));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.c));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;c=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(10).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }

            }

        });


        ibt.get(11).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {if(d==1)return ; if(han==2)return ;

                int me=11;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.d));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.d));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;d=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(11).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }

            }

        });


        ibt.get(12).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {if(e==1)return ; if(han==2)return ;

                int me=12;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.e));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.e));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;e=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(12).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }


            }

        });


        ibt.get(13).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {if(f==1)return ; if(han==2)return ;



                int me=13;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.f));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.f));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;f=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(13).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }


            }

        });


        ibt.get(14).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) { if(han==2)return ;
                if(g==1)return ;


                int me=14;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.g));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.g));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;g=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(14).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }
            }

        });


        ibt.get(15).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) { if(han==2)return ;
                if(h==1)return ;



                int me=15;
                if(flag==0)
                {
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.h));//ㅅㅈ
                    flag=1;
                    cheak=me;
                }
                else if(flag==1&&cheak!=me){han=2;
                    ibt.get(me).setImageDrawable(getResources().getDrawable(R.drawable.h));//ㅅㅈ
                    if(me==(cheak-8)||me==(cheak+8)){counttw++;h=1; Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);dateHandler.sendMessage(msg);if(counttw==8)restart ();}//ㅅㅈ
                    else{
                        CountDownTimer timer = new CountDownTimer(1000,1000) {
                            public void onTick(long millisUntilFinished) {
                                //1초에 한번씩 2번 실행되는 메소드
                            }
                            public void onFinish() {
                                ibt.get(cheak).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));
                                ibt.get(15).setImageDrawable(getResources().getDrawable(R.drawable.aaaa));//ㅅㅈ
                                //마지막 5번째가 실행이 되고 실행되는 메소드
                                Message msg = dateHandler.obtainMessage(MSG_DAY_PASSED);
                                dateHandler.sendMessage(msg);
                            }
                        }.start();}
                    flag=0;
                }
            }

        });



    }



}