package ie.cm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import ie.cm.R;

public class Home extends Base {

    Button addcoffee;
    Button searchcoffee;
    Button favouritecoffee;
    TextView recentList; //near the top of the class
//in onCreate


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_launcher1);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Information", Snackbar.LENGTH_LONG)
                        .setAction("More Info...", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                               openInfoDialog(Home.this);
                            }
                        }).show();
            }
        });

        addcoffee=findViewById(R.id.addACoffeeBtn);
        searchcoffee=findViewById(R.id.searchCoffeesBtn);
        favouritecoffee=findViewById(R.id.favouritesCoffeeBtn);
        recentList = (TextView) findViewById(R.id.recentlyAddedListEmpty);

        addcoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),Add.class);
                startActivity(i);
            }
        });



    }
    @Override
    protected void onResume(){
        super.onResume();
        if(!coffeeList.isEmpty()) recentList.setText(coffeeList.toString());
        else
            recentList.setText(getString(R.string.recentlyViewedListEmptyMessage));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_help) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
