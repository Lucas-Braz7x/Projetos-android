package com.example.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements ITarefaDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();

    }

    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try{
            escreve.insert(DbHelper.TABELA_TAREFAS, null, cv);
            Log.i("INFO_DB", "Passou direto" );
        }catch (Exception e){
            Log.i("INFO_DB", "Se fudeu, deu errado" + e.getMessage());
            return  false;
        }


        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try{
            String[] args = {tarefa.getId().toString()};
            escreve.update(DbHelper.TABELA_TAREFAS,cv, "id=?", args);
            Log.i("INFO_DB", "ATUALIZOOOUUUUU!!!!!!" );
        }catch (Exception e){
            Log.i("INFO_DB", "DEU MERDAAAAAAAA!" + e.getMessage());
            return  false;
        }

        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {

        try{
            String[] args = {tarefa.getId().toString()};
            escreve.delete(DbHelper.TABELA_TAREFAS, "id=?", args);
            Log.i("INFO_DB", "Excluiu carai!!!!!!" );
        }catch (Exception e){
            Log.i("INFO_DB", "DEU MERDAAAAAAAA!" + e.getMessage());
            return  false;
        }

        return true;
    }

    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
        Cursor c = ler.rawQuery(sql, null);

        while(c.moveToNext()){
            Tarefa tarefa = new Tarefa();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefas = c.getString(c.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefas);

            tarefas.add(tarefa);
        }

        return tarefas;
    }
}
