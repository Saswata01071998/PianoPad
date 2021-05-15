
package com.example.pianokids;


import android.media.AudioManager;
import android.media.SoundPool;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private final int NR_OF_MAXSTREAM = 12;
    int mBSoundId;
    int mHSoundId;
    int mNSoundId;
    int mJSoundId;
    int mMSoundId;
    int mQSoundId;
    int m2SoundId;
    int mWSoundId;
    int m3SoundId;
    int mESoundId;
    int mRSoundId;
    int m5SoundId;
    int m0SoundId;
    int m6SoundId;
    int m7SoundId;
    int m9SoundId;
    int mCSoundId;
    int mGSoundId;
    int mISoundId;
    int mOSoundId;
    int mPSoundId;
    int mTSoundId;
    int mUSoundId;
    int mVSoundId;
    int mXSoundId;
    int mYSoundId;
    int mZSoundId;


    private EditText editText;
    final float LEFT_VOLUME = 1.0f;
    final float RIGHT_VOLUME = 1.0f;
    SoundPool mSoundPool;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    int i=0,l;
    RealmResults<RData> realmResults;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSoundPool = new SoundPool(NR_OF_MAXSTREAM, AudioManager.STREAM_MUSIC,1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        APIToDatabase apiToDatabase = new APIToDatabase();
        apiToDatabase.retrieveData();
        mBSoundId = mSoundPool.load(this,R.raw.pb,1);
        mHSoundId = mSoundPool.load(this,R.raw.ph,1);
        mNSoundId = mSoundPool.load(this,R.raw.pn,1);
        mJSoundId = mSoundPool.load(this,R.raw.pj,1);
        mMSoundId = mSoundPool.load(this,R.raw.pm,1);
        mQSoundId = mSoundPool.load(this,R.raw.pq,1);
        m2SoundId = mSoundPool.load(this,R.raw.p2,1);
        mWSoundId = mSoundPool.load(this,R.raw.pw,1);
        m3SoundId = mSoundPool.load(this,R.raw.p3,1);
        mESoundId = mSoundPool.load(this,R.raw.pe,1);
        mRSoundId = mSoundPool.load(this,R.raw.pr,1);
        m5SoundId = mSoundPool.load(this,R.raw.p5,1);
        m0SoundId = mSoundPool.load(this,R.raw.p0,1);
        m6SoundId = mSoundPool.load(this,R.raw.p6,1);
        m7SoundId = mSoundPool.load(this,R.raw.p7,1);
        m9SoundId = mSoundPool.load(this,R.raw.p9,1);
        mCSoundId = mSoundPool.load(this,R.raw.pc,1);
        mGSoundId = mSoundPool.load(this,R.raw.pg,1);
        mISoundId = mSoundPool.load(this,R.raw.pi,1);
        mOSoundId = mSoundPool.load(this,R.raw.po,1);
        mPSoundId = mSoundPool.load(this,R.raw.pp,1);
        mTSoundId = mSoundPool.load(this,R.raw.pt,1);
        mUSoundId = mSoundPool.load(this,R.raw.pu,1);
        mVSoundId = mSoundPool.load(this,R.raw.pv,1);
        mXSoundId = mSoundPool.load(this,R.raw.px,1);
        mYSoundId = mSoundPool.load(this,R.raw.py,1);
        mZSoundId = mSoundPool.load(this,R.raw.pz,1);

        Realm realm = Realm.getDefaultInstance();
        realmResults=realm.where(RData.class).findAll();
        realm.close();
        b1= (Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button2);
        b3= (Button) findViewById(R.id.button3);
        b4= (Button) findViewById(R.id.button4);
        b5= (Button) findViewById(R.id.button5);
        b6= (Button) findViewById(R.id.button6);

        b8= (Button) findViewById(R.id.button8);
        b9= (Button) findViewById(R.id.button9);
        b10= (Button) findViewById(R.id.button10);
        b11= (Button) findViewById(R.id.button11);
        l=realmResults.size();
        image=(ImageView) findViewById(R.id.image);
        if(realmResults.size()!=0)
            new ImageLoad(realmResults.get(0).getImglink(),image).execute();

    }
    @Subscribe
    public void imageCall(EventBusPojo eventBusPojo)
    {
        if (eventBusPojo.getFlag()==1) {
            new ImageLoad(realmResults.get(0).getImglink(), image).execute();
            Realm realm = Realm.getDefaultInstance();
            realmResults = realm.where(RData.class).findAll();
            realm.close();
            l=realmResults.size();
        }

    }

    public void playB(View view){mSoundPool.play(mBSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void playH(View view){mSoundPool.play(mHSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void playN(View view){mSoundPool.play(mNSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void playJ(View view){mSoundPool.play(mJSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void playM(View view){mSoundPool.play(mMSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void playQ(View view){mSoundPool.play(mQSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void play2(View view){mSoundPool.play(m2SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void playW(View view){mSoundPool.play(mWSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void play3(View view){mSoundPool.play(m3SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void playE(View view){mSoundPool.play(mESoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void playR(View view){mSoundPool.play(mRSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}
    public void play5(View view){mSoundPool.play(m5SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);}

    public void play(View view)throws Exception{
        String s = String.valueOf(editText.getText());
        int len = s.length();
        for(int i = 0;i < len;i++)
        {
            char c = s.charAt(i);
            switch(c){
                case 'b':
                case 'B':mSoundPool.play(mBSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                          break;
                case 'h':
                case 'H':mSoundPool.play(mHSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                          break;
                case 'n':
                case 'N':mSoundPool.play(mNSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'q':
                case 'Q':mSoundPool.play(mQSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case '2':mSoundPool.play(m2SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'w':
                case 'W':mSoundPool.play(mWSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'j':
                case 'J':mSoundPool.play(mJSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'm':
                case 'M':mSoundPool.play(mMSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case '3':mSoundPool.play(m3SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'e':
                case 'E':mSoundPool.play(mESoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'r':
                case 'R':mSoundPool.play(mRSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case '5':mSoundPool.play(m5SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case '0':mSoundPool.play(m0SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case '6':mSoundPool.play(m6SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case '7':mSoundPool.play(m7SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case '9':mSoundPool.play(m9SoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'c':
                case 'C':mSoundPool.play(mCSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'g':
                case 'G':mSoundPool.play(mGSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'i':
                case 'I':mSoundPool.play(mISoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'o':
                case 'O':mSoundPool.play(mOSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'p':
                case 'P':mSoundPool.play(mPSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 't':
                case 'T':mSoundPool.play(mTSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'u':
                case 'U':mSoundPool.play(mUSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'v':
                case 'V':mSoundPool.play(mVSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'x':
                case 'X':mSoundPool.play(mXSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'y':
                case 'Y':mSoundPool.play(mYSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                case 'z':
                case 'Z':mSoundPool.play(mZSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,0,1);
                    break;
                default:break;
            }
            Thread.sleep(1000);
        }
    }

    public void next(View view) {
        i++;
        if(i<l)
        {
            String s= realmResults.get(i).getJword();
            b2.setText(String.valueOf(s.charAt(0)));
            b1.setText(String.valueOf(s.charAt(1)));
            b4.setText(String.valueOf(s.charAt(2)));
            b3.setText(String.valueOf(s.charAt(3)));
            b5.setText(String.valueOf(s.charAt(4)));
            b6.setText(String.valueOf(s.charAt(5)));
            b8.setText(String.valueOf(s.charAt(7)));
            b9.setText(String.valueOf(s.charAt(8)));
            b10.setText(String.valueOf(s.charAt(9)));
            b11.setText(String.valueOf(s.charAt(10)));
            new ImageLoad(realmResults.get(i).getImglink(),image).execute();

        }
        else {
            i = 0;
            String s= realmResults.get(i).getJword();
            b2.setText(String.valueOf(s.charAt(0)));
            b1.setText(String.valueOf(s.charAt(1)));
            b4.setText(String.valueOf(s.charAt(2)));
            b3.setText(String.valueOf(s.charAt(3)));
            b5.setText(String.valueOf(s.charAt(4)));
            b6.setText(String.valueOf(s.charAt(5)));
            b8.setText(String.valueOf(s.charAt(7)));
            b9.setText(String.valueOf(s.charAt(8)));
            b10.setText(String.valueOf(s.charAt(9)));
            b11.setText(String.valueOf(s.charAt(10)));
            new ImageLoad(realmResults.get(i).getImglink(),image).execute();

        }

    }

    public void previous(View view) {

        i--;
        if(i>=0)
        {
            String s= realmResults.get(i).getJword();
            b2.setText(String.valueOf(s.charAt(0)));
            b1.setText(String.valueOf(s.charAt(1)));
            b4.setText(String.valueOf(s.charAt(2)));
            b3.setText(String.valueOf(s.charAt(3)));
            b5.setText(String.valueOf(s.charAt(4)));
            b6.setText(String.valueOf(s.charAt(5)));
            b8.setText(String.valueOf(s.charAt(7)));
            b9.setText(String.valueOf(s.charAt(8)));
            b10.setText(String.valueOf(s.charAt(9)));
            b11.setText(String.valueOf(s.charAt(10)));
            new ImageLoad(realmResults.get(i).getImglink(),image).execute();

        }
        else {
            i = 0;

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }
}
