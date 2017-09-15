package br.com.fernandohenryhruschka.cep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText etCEP;
    private TextView tvtipoDeLogradouro;
    private TextView tvlogradouro;
    private TextView tvbairro;
    private TextView tvcidade;
    private TextView tvestado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etCEP = (EditText)findViewById(R.id.etCEP);
        tvtipoDeLogradouro = (TextView)findViewById(R.id.tvtipoDeLogradouro);
        tvlogradouro = (TextView)findViewById(R.id.tvlogradouro);
        tvbairro = (TextView)findViewById(R.id.tvbairro);
        tvcidade = (TextView)findViewById(R.id.tvcidade);
        tvestado = (TextView)findViewById(R.id.tvestado);
    }

    public void Pesquisar(View v){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http:///correiosapi.apphb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        CorreiosApiService service = retrofit.create(CorreiosApiService.class);

        service.buscarCEP(etCEP.getText().toString())
                .enqueue(new Callback<CEP>() {
                    @Override
                    public void onResponse(Call<CEP> call, Response<CEP> response) {
                        Picasso.with(MainActivity.this)
                                .load(response.body().getTipoDeLogradouro());
                        tvtipoDeLogradouro.setText(response.body().getTipoDeLogradouro());
                        tvlogradouro.setText(response.body().getLogradouro());
                        tvbairro.setText(response.body().getBairro());
                        tvcidade.setText(response.body().getCidade());
                        tvestado.setText(response.body().getEstado());
                    }

                    @Override
                    public void onFailure(Call<CEP> call, Throwable t) {
                        Toast.makeText(MainActivity.this,
                                "Ocorreu um erro na requisicao",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
