package sg.edu.np.mad.exercise3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                Button followbutton = findViewById(R.id.FollowButton);
                User user1 = initial();
                followstatus(user1, followbutton);
                followbutton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                if(user1.followed == false)
                                {
                                        user1.followed = true;
                                        CharSequence followedtoasttxt = "Followed";
                                        int ftoastduration = Toast.LENGTH_SHORT;
                                        Toast ftoast = Toast.makeText(MainActivity.this,followedtoasttxt,ftoastduration);
                                        ftoast.show();
                                }
                                else
                                {
                                        user1.followed = false;
                                        CharSequence unfollowedtoasttxt = "Unfollowed";
                                        int ftoastduration = Toast.LENGTH_SHORT;
                                        Toast ftoast2 = Toast.makeText(MainActivity.this,unfollowedtoasttxt,ftoastduration);
                                        ftoast2.show();
                                }
                                followstatus(user1,followbutton);
                        }
                });

                Intent randomreceive = getIntent();
                int randonum = randomreceive.getIntExtra("randomnumbers",0);
                TextView randomnumtxt = findViewById(R.id.BigText);
                String numbers = "MAD" + " " + randonum;
                randomnumtxt.setText(numbers);



        }

        public User initial()
        {
                User initialization = new User("name","description",0,false);
                return initialization;
        }

        public void followstatus (User user, Button button)
        {
                TextView txt = button;
                if(user.followed == false)
                {
                        txt.setText("Follow");

                }
                else
                {
                        txt.setText("Unfollow");
                }
        }
}