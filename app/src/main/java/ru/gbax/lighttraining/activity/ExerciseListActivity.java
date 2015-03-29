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
import ru.gbax.lighttraining.adaptor.ExerciseAdaptor;
import ru.gbax.lighttraining.dao.ExerciseRepository;
import ru.gbax.lighttraining.model.Exercise;

public class ExerciseListActivity extends ActionBarActivity {

    final static Integer NEW_EXERSISE = 0;

    private ExerciseAdaptor exerciseAdaptor;
    private List<Exercise> exercises;
    private ExerciseRepository exerciseRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        exerciseRepository = new ExerciseRepository(this);
        exercises = exerciseRepository.getAllExercises();

        exerciseAdaptor = new ExerciseAdaptor(exercises, this);
        ListView listView = (ListView)findViewById(R.id.listView2);
        listView.setAdapter(exerciseAdaptor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_exercise_list, menu);
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


    public void openCreateNewExersizeActivity(View view) {
        Intent intent = new Intent(this, CreatingExerciseActivity.class);
        startActivityForResult(intent, NEW_EXERSISE);
    }
}
