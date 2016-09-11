package id.sch.smktelkom_mlg.tugas01.xiirpl1025.formregistermediasosial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spNeg, spThn;
    Button btnReg;
    TextView tvHasil;
    RadioButton rbLK, rbPR;
    CheckBox cbM, cbBC, cbOR;
    EditText etNama, etEmail, etPass;
    int umur;
    String jk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spNeg = (Spinner) findViewById(R.id.spinnerNegara);
        spThn = (Spinner) findViewById(R.id.spinnerTahun);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        rbLK = (RadioButton) findViewById(R.id.rbL);
        rbPR = (RadioButton) findViewById(R.id.rbP);
        cbM = (CheckBox) findViewById(R.id.checkBoxMusic);
        cbBC = (CheckBox) findViewById(R.id.checkBoxBC);
        cbOR = (CheckBox) findViewById(R.id.checkBoxOR);
        etNama = (EditText) findViewById(R.id.name);
        etEmail = (EditText) findViewById(R.id.email);
        etPass = (EditText) findViewById(R.id.password);
        umur = 2016 - Integer.parseInt(spThn.getSelectedItem().toString());
        findViewById(R.id.buttonReg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doclick();
            }
        });
    }

    private void doclick() {
        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();
        if (isValid()) {
            if (rbLK.isChecked()) {
                jk = rbLK.getText().toString();
            } else if (rbPR.isChecked()) {
                jk = rbPR.getText().toString();
            }
            String hobi = "Hobi Anda : \n";
            int leng = hobi.length();
            if (cbBC.isChecked()) hobi += cbBC.getText() + "\n";
            if (cbM.isChecked()) hobi += cbM.getText() + "\n";
            if (cbOR.isChecked()) hobi += cbOR.getText() + "\n";

            if (hobi.length() == leng) hobi += "Tidak ada pada pilihan";
            tvHasil.setText("Selamat Pendaftaran Berhasil! \n" + "Nama : " + nama + "\nUmur : " + umur + "\nEmail : " + email +
                    "\nPassword : " + password + "\nJenis Kelamin : " + jk + "\nNegara Asal : " + spNeg.getSelectedItem().toString() +
                    "\n" + hobi + "\nAnda bisa login menggunakan email dan password anda ^_^"
                    + "\n\n\t\tSelamat Begabung di Moklet Media!");
        }

    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPass.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi!");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Huruf!");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (email.isEmpty()) {
            etEmail.setError("Email Belum Diisi!");
            valid = false;
        } else {
            etEmail.setError(null);
        }

        if (password.isEmpty()) {
            etPass.setError("Password Belum Diisi!");
            valid = false;
        } else if (password.length() < 6) {
            etPass.setError("Password Terlalu Pendek!");
            valid = false;
        } else {
            etPass.setError(null);
        }

        if ((!rbPR.isChecked()) && (!rbLK.isChecked())) {
            valid = false;
        }

        return valid;
    }
}
