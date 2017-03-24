package br.com.fbrandao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.fbrandao.R;
import br.com.fbrandao.dao.ServicoDAO;
import br.com.fbrandao.model.Servico;

import java.util.List;

public class ListaServicosActivity extends AppCompatActivity {

    private ListView listViewServicos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servico_lista);

        //carregar serviços
        loadServicos();

        //adiciona evento onItemClick na lista
        listViewServicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Servico servico = (Servico)  listViewServicos.getItemAtPosition(position);
                Intent goToEditarServico = new Intent(ListaServicosActivity.this, EditarServicoActivity.class);
                goToEditarServico.putExtra("servico", servico);
                startActivity(goToEditarServico);
            }
        });

        Button novoServico = (Button) findViewById (R.id.novo_servico);
        novoServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v)  {
                Intent goToEditarServico = new Intent(ListaServicosActivity.this, EditarServicoActivity.class);
                startActivity(goToEditarServico);
            }
        });

        registerForContextMenu(listViewServicos);
    }

    private void loadServicos(){
        ServicoDAO dao = new ServicoDAO(this);
        List<Servico> servicos = dao.getServicos();
        dao.close();

        listViewServicos = (ListView) findViewById(R.id.lista_servicos);

        ArrayAdapter<Servico> adapter = new ArrayAdapter<Servico>(this, android.R.layout.simple_list_item_1, servicos);

        listViewServicos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadServicos();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Servico servico = (Servico) listViewServicos.getItemAtPosition(info.position);

            ServicoDAO dao = new ServicoDAO(ListaServicosActivity.this);
            dao.excluir(servico);
            dao.close();

            loadServicos();
            return false;
            }
        });
    }
}
