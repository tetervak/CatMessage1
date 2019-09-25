/* Alex Tetervak, Sheridan College, Ontario */
package ca.javateacher.catmessage1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

  public static final String MESSAGE_TEXT_KEY = "message";
  public static final String URGENT_FLAG_KEY = "urgent";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_output);

    // get and display the message data
    Intent intent = getIntent();

    boolean urgent = intent.getBooleanExtra(URGENT_FLAG_KEY, true);
    TextView urgentView = findViewById(R.id.urgent_flag_output);
    urgentView.setText(urgent ? R.string.urgent : R.string.not_urgent);

    String message = intent.getStringExtra(MESSAGE_TEXT_KEY);
    TextView messageView = findViewById(R.id.message_text);
    messageView.setText(message);

    // make the close button work
    Button closeButton = findViewById(R.id.close_button);
    closeButton.setOnClickListener(v -> finish());
  }
}
