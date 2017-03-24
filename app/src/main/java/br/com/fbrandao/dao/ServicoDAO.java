package br.com.fbrandao.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import br.com.fbrandao.model.Servico;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago_henrique on 20/03/2017.
 */

public class ServicoDAO extends SQLiteOpenHelper {


    public ServicoDAO(Context context) {
        super(context, "fBrandao", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE servico (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, " +
                     "endereco TEXT, telefone TEXT, site TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS servico";
        db.execSQL(sql);
        onCreate(db);
    }

    public void salvar(Servico servico)  {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("nome", servico.getNome());
        dados.put("endereco", servico.getEndereco());
        dados.put("telefone", servico.getTelefone());
        dados.put("site", servico.getSite());

        db.insert("servico", null, dados);

        //popularTabelaServico(db);
    }

    public void editar(Servico servico){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = getServico(servico);

        String[] params ={servico.getId().toString()};
        db.update("servico", dados, "id = ?", params);
    }

    public void excluir(Servico servico) {
        SQLiteDatabase db = getWritableDatabase();

        String [] params = {servico.getId().toString()};
        db.delete("servico", "id = ?", params);
    }

    @NonNull
    private ContentValues getServico(Servico servico) {
        ContentValues dados = new ContentValues();
        dados.put("nome", servico.getNome());
        dados.put("endereco", servico.getEndereco());
        dados.put("telefone", servico.getTelefone());
        dados.put("site", servico.getSite());
        return dados;
    }

    public List<Servico> getServicos()  {
        String sql = "SELECT * FROM servico;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);
        List<Servico> servicos = new ArrayList<Servico>();
        while (c.moveToNext()) {
            Servico servico = new Servico();
            servico.setId(c.getLong(c.getColumnIndex("id")));
            servico.setNome(c.getString(c.getColumnIndex("nome")));
            servico.setEndereco(c.getString(c.getColumnIndex("endereco")));
            servico.setTelefone(c.getString(c.getColumnIndex("telefone")));
            servico.setSite(c.getString(c.getColumnIndex("site")));

            servicos.add(servico);

        }
        c.close();

        return servicos;
    }

    /* Popular tabela servico no banco de dados */
    public void popularTabelaServico(SQLiteDatabase db){
        String[] listaServicos = {"Sites", "Hospedagem", "Sites Mobile",
                "Logos", "Design Gráfico", "Assessoria Mensal",
                "Fotografias", "Marketing Digital", "Produção de Vídeos",
                "LanSite Fbrandão"};


        for (int i=0; i < listaServicos.length; i++) {
            ContentValues dados = new ContentValues();
            dados.put("nome", listaServicos[i]);

            db.insert("servico", null, dados);
        }
    }
}
