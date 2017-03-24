package br.com.fbrandao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.fbrandao.R;
import br.com.fbrandao.helper.ServicoHelper;
import br.com.fbrandao.dao.ServicoDAO;
import br.com.fbrandao.model.Servico;

public class EditarServicoActivity extends AppCompatActivity {

    private ServicoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servico_editar);

        helper = new ServicoHelper(this);

        Intent intent = getIntent();
        Servico servico = (Servico) intent.getSerializableExtra("servico");
        if (servico !=null) {
            helper.preencheFormulario(servico);
        }
    }

    /*
     * cria menu da página Editar Serviço
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editar_servico, menu);

        return super.onCreateOptionsMenu(menu);
    }
    /*
     * dispara o evento de seleção do botão salvar da página Editar Serviço
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_editar_servico:
                Servico servico = helper.getServico();
                ServicoDAO dao = new ServicoDAO(this);

                if (servico.getId() != null)  {
                    dao.editar(servico);
                } else {
                    dao.salvar(servico);
                }

                dao.close();
                Toast.makeText(EditarServicoActivity.this, "Serviço salvo com sucesso!", Toast.LENGTH_SHORT).show();
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
