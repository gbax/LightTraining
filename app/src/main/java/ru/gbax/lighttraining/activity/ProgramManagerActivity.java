package ru.gbax.lighttraining.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import ru.gbax.lighttraining.R;
import ru.gbax.lighttraining.adaptor.ProgramAdaptor;
import ru.gbax.lighttraining.dao.ProgramRepository;
import ru.gbax.lighttraining.model.Program;


public class ProgramManagerActivity extends ActionBarActivity {

    private static final int ADD_PROGRAM = 0;

    private ProgramAdaptor programAdaptor;
    List<Program> allPrograms;
    ProgramRepository db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managing_program);

        db = new ProgramRepository(this);
        allPrograms = db.getAllPrograms();

        programAdaptor = new ProgramAdaptor(allPrograms, this);
        ListView lView = (ListView)findViewById(R.id.listView);
        lView.setAdapter(programAdaptor);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_program, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_PROGRAM) {
            if (resultCode == RESULT_OK) {
                allPrograms.clear();
                allPrograms.addAll(db.getAllPrograms());
                programAdaptor.notifyDataSetChanged();
            }
        }
    }

    public void openCreateNewProgramActivity(View view) {
        Intent intent = new Intent(ProgramManagerActivity.this, CreatingProgramActivity.class);
        startActivityForResult(intent, ADD_PROGRAM);
    }
}
