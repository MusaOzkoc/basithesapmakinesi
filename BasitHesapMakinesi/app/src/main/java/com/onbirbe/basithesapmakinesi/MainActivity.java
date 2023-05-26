package com.onbirbe.basithesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBirinciSayi, editTextIkinciSayi;
    private TextView txtSonuc;
    private String birinciSayi, ikinciSayi;
    private int s1, s2, sonuc;
    private Hesapla hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBirinciSayi = (EditText) findViewById(R.id.editTxtBirinciSayi);
        editTextIkinciSayi = (EditText) findViewById(R.id.editTxtIkinciSayi);
        txtSonuc = (TextView) findViewById(R.id.txtSonuc);
        hesapla = new Hesapla();
    }
    public void btnHesapla(View v){
          birinciSayi = editTextBirinciSayi.getText().toString();
          ikinciSayi = editTextIkinciSayi.getText().toString();

          if (!TextUtils.isEmpty(birinciSayi)&&!TextUtils.isEmpty(ikinciSayi)){
              s1 = Integer.valueOf(birinciSayi);
              s2 = Integer.valueOf(ikinciSayi);

              switch (v.getId()){
                  case R.id.btnTopla:
                      sonuc = hesapla.toplam();
                      break;
                  case R.id.btnFark:
                      sonuc = hesapla.fark();
                      break;
                  case R.id.btnCarp:
                      sonuc = hesapla.carpim();
                      break;
                  case R.id.btnBolme:
                      sonuc = hesapla.bolme();
                      break;
              }
              txtSonuc.setText("Sonuç: " +sonuc);
          }else
              txtSonuc.setText("Girilen Değerler Boş Bıraklamaz.");
    }
}