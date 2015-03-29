package ru.gbax.lighttraining.activity;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import ru.gbax.lighttraining.R;
import ru.gbax.lighttraining.dao.ProgramRepository;
import ru.gbax.lighttraining.model.Program;


public class CreatingProgramActivity extends ActionBarActivity {

    public final static String ADD_RESULT = "ru.gbax.lighttraining.ADD_RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating_program);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_creating_program, menu);
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

    public void saveNewProgram(View view) {
        ProgramRepository db = new ProgramRepository(this);
        EditText name = (EditText) findViewById(R.id.editText);
        EditText decr = (EditText) findViewById(R.id.editText2);
        db.addProgram(new Program(
                name.getText().toString(),
                decr.getText().toString()
        ));
        Intent intent = new Intent();
        intent.putExtra(ADD_RESULT, "OK");
        setResult(RESULT_OK, intent);
        finish();
    }
}
