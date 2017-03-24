package br.com.fbrandao.helper;

import android.widget.EditText;

import com.fbrandao.R;
import br.com.fbrandao.activity.EditarServicoActivity;
import br.com.fbrandao.model.Servico;

/**
 * Created by thiago_henrique on 20/03/2017.
 */

public class ServicoHelper {

    private EditText campoNome;
    private EditText campoEndereco;
    private EditText campoTelefone;
    private EditText campoSite;

    private Servico servico;

    public ServicoHelper(EditarServicoActivity activity)  {
        campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        campoSite = (EditText) activity.findViewById(R.id.formulario_site);
        servico =  new Servico();
    }

    public Servico getServico()  {
        servico.setNome(campoNome.getText().toString());
        servico.setEndereco(campoEndereco.getText().toString());
        servico.setTelefone(campoTelefone.getText().toString());
        servico.setSite(campoSite.getText().toString());
        return servico;
    }

    public void preencheFormulario(Servico servico)  {
        campoNome.setText(servico.getNome());
        campoEndereco.setText(servico.getEndereco());
        campoTelefone.setText(servico.getTelefone());
        campoSite.setText(servico.getSite());
        this.servico = servico;
    }
}
