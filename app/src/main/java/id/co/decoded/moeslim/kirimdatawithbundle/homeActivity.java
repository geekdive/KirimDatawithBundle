package id.co.decoded.moeslim.kirimdatawithbundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {

    //Step I - Deklarasikan Variable View atau Widget
    Button btCek;
    Button btKirim;
    EditText edEmail;
    EditText edNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Step II - Ambil data dari inputan atau aksi user sehingga variable bernilai sama dengan variable yang ada di XML
        edEmail = (EditText)findViewById(R.id.txtEmail);
        edNama = (EditText)findViewById(R.id.txtNama);

        //Step III - Buat Aksi untuk Button Cek
        btCek = (Button)findViewById(R.id.btnCek);
        btCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Step IV - Buat variable dengan Typedata String untuk konvert data dari masukan EditText menjadi String dan
                //kemudian di tampilkan dengan Toast.
                String email = edEmail.getText().toString();
                String namaLengkap = edNama.getText().toString();

                //Step V - Buat Validasi jika Inputan Nama kosong
                if (edNama.getText().toString().isEmpty()){
                    //Maka akan menampilkan pesan error
                    edNama.setError("Maaf, Nama Lengkap tidak boleh kosong!!");
                    //Mengosongkan text yang sudah diisi
                    edNama.setText("");
                    //Mengatur text hint untuk sample
                    edNama.setHint("sample: Gita Anjani");
                    //Dan memfokuskan kursor ke posisi EditText Nama Lengkap
                    edNama.requestFocus();
                    //jika nama sudah diisi dan posisi tidak kosong
                }
                //Step VI - Buat Validasi jika Inputan Email Kosong dan Inputan Nama Sudah Terisi (Tidak Kosong)
                if (!edNama.getText().toString().isEmpty() && edEmail.getText().toString().isEmpty()){
                    //Maka akan menampilkan pesan error
                    edEmail.setError("Maaf, Email belom diisi!!");
                    //Dan memfokuskan kursor ke posisi EditText Email
                    edEmail.requestFocus();
                    //Jika email sudah diisi dan posisi tidak kosong
                }
                //Step VII - Buat Validasi jika Inputan Email tidak Kosong dan masukan Email tidak Match atau tidak valid
                if (!edEmail.getText().toString().isEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    //Maka akan menampilkan pesan error
                    edEmail.setError("Maaf, Email tidak valid!!!");
                    //Mengosongkan text yang sudah diisi
                    edEmail.setText("");
                    //Mengatur text hint untuk sample
                    edEmail.setHint("sample: sample@company.com");
                    //dan Memfokuskan kursor ke posisi EditText Email
                    edEmail.requestFocus();
                    //Jika email sudah match & valid
                }
                //Step VIII - buat validasi keseluruhan, jika Nama Lengkap sudah terisi serta Email juga terisi  begitu juga dengan validnya masukan email
                if (!edNama.getText().toString().isEmpty() && !edEmail.getText().toString().isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    //Menampilkan masukan nama lengkap & email ke dalam Toast
                    Toast.makeText(getApplicationContext(), "Nama Kamu: "+namaLengkap+" dan Email Anda: "+email , Toast.LENGTH_LONG).show();
                    //Tidak ada error
                    edEmail.setError(null);
                }
            }
        });

        btKirim = (Button)findViewById(R.id.btnKirim);
        btKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
