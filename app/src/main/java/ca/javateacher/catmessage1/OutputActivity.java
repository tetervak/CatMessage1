/* Alex Tetervak, Sheridan College, Ontario */
package ca.javateacher.catmessage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

  public static final String MESSAGE = "message";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_output);

    // get and display the message
    String message = getIntent().getStringExtra(MESSAGE);
    TextView messageView = findViewById(R.id.message_text);
    messageView.setText(message);

    Button closeButton = findViewById(R.id.close_button);
    closeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }
}
