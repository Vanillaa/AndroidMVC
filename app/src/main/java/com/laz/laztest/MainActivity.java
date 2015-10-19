package com.laz.laztest;


        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.ActionBarActivity;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

    private EditText txtusername;
    private EditText txtpassword;
    private Button btnlogin;
    private TextView TVloginLocked;
    private TextView attemptsLeftTV;
    private TextView numberOfRemainingLoginAttemptsTV;
    int nNumberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupVariables();
    }

    public void authenticateLogin(View view) {
        if (txtusername.getText().toString().equals("aidan") &&
                txtpassword.getText().toString().equals("lazmvc")) {
            Toast.makeText(getApplicationContext(), "Hello",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Login wrong",
                    Toast.LENGTH_SHORT).show();
            nNumberOfRemainingLoginAttempts--;
            attemptsLeftTV.setVisibility(View.VISIBLE);
            numberOfRemainingLoginAttemptsTV.setVisibility(View.VISIBLE);
            numberOfRemainingLoginAttemptsTV.setText(Integer.toString(nNumberOfRemainingLoginAttempts));

            if (nNumberOfRemainingLoginAttempts == 0) {
                btnlogin.setEnabled(false);
                TVloginLocked.setVisibility(View.VISIBLE);
                TVloginLocked.setBackgroundColor(Color.RED);
                TVloginLocked.setText("Login locked");
            }
        }
    }

    private void setupVariables() {
        txtusername = (EditText) findViewById(R.id.usernameET);
        txtpassword = (EditText) findViewById(R.id.passwordET);
        btnlogin = (Button) findViewById(R.id.loginBtn);
        TVloginLocked = (TextView) findViewById(R.id.TVloginLocked);
        attemptsLeftTV = (TextView) findViewById(R.id.attemptsLeftTV);
        numberOfRemainingLoginAttemptsTV = (TextView) findViewById(R.id.numberOfRemainingLoginAttemptsTV);
        numberOfRemainingLoginAttemptsTV.setText(Integer.toString(nNumberOfRemainingLoginAttempts));
    }

}