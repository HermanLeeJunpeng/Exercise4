package sg.edu.np.mad.exercise3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView imageAlert = findViewById(R.id.imageAlert);
        imageAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder imagePopup = new AlertDialog.Builder(ListActivity.this);
                imagePopup.setTitle("Profile");
                imagePopup.setMessage("MADness");
                //imagePopup.setCancelable(true);
                imagePopup.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                imagePopup.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Random random = new Random();
                        Integer randomnumber = random.nextInt();
                        Intent passrandomIntent = new Intent(ListActivity.this,MainActivity.class);
                        passrandomIntent.putExtra("randomnumbers",randomnumber);
                        startActivity(passrandomIntent);
                    }
                });
                imagePopup.show();
            }
        });
    }
}