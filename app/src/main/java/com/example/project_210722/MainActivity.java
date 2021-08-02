package com.example.project_210722;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoRedPanda, rdoCapybara, rdoQuokka;
    Button btnOK;
    ImageView imgPet;
    Button btnExit;
    Button btnRollBack;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoRedPanda = (RadioButton) findViewById(R.id.RedPanda);
        rdoCapybara = (RadioButton) findViewById(R.id.Capybara);
        rdoQuokka = (RadioButton) findViewById(R.id.Quokka);

        btnOK = (Button) findViewById(R.id.BtnOK);
        imgPet = (ImageView) findViewById(R.id.ImgPet);

        btnExit = (Button) findViewById(R.id.BtnExit);
        btnRollBack = (Button) findViewById(R.id.BtnRollBack);

        chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(chkAgree.isChecked() == true)
                {
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    //imgPet.setVisibility(View.INVISIBLE); //주석처리해도, 그냥 써도 INVISIBLE이라서 무관.    //추가한거.
                }
                else
                {
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    //imgPet.setVisibility(View.INVISIBLE); //주석처리해도, 그냥 써도 INVISIBLE이라서 무관.    //추가한거
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                imgPet.setVisibility(View.VISIBLE); //바람직하지 않은 코딩.. 계획하고 해야하는데 중간에 추가함. 땜빵 ㅎㅎ;  //이런 화면제어는 미리 다 설계해야 함.
                switch (rGroup1.getCheckedRadioButtonId())
                {
                    case R.id.RedPanda:
                        imgPet.setImageResource(R.drawable.redpanda);
                        break;
                    case R.id.Capybara:
                        imgPet.setImageResource(R.drawable.capybara);
                        break;
                    case R.id.Quokka:
                        imgPet.setImageResource(R.drawable.quokka);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
                }
                if(btnOK.isClickable() == true)
                {
                    btnExit.setVisibility(View.VISIBLE);
                    btnRollBack.setVisibility(View.VISIBLE);
                }
                else
                {
                    btnExit.setVisibility(View.INVISIBLE);
                    btnRollBack.setVisibility(View.INVISIBLE);
                }
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnRollBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkAgree.setChecked(false);
                rGroup1.clearCheck();
                btnExit.setVisibility(View.INVISIBLE);
                btnRollBack.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
            }
        });
    }
}