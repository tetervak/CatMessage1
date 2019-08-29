/* Alex Tetervak, Sheridan College, Ontario */
package ca.javateacher.catmessage1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
    closeButton.setOnClickListener(v -> finish());
  }
}
