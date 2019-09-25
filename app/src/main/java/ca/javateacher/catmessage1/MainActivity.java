/* Alex Tetervak, Sheridan College, Ontario */
package ca.javateacher.catmessage1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

  private CheckBox mUrgentCheckBox;
  private RadioGroup mMessageGroup;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // lookup the views
    mUrgentCheckBox = findViewById(R.id.urgent_check_box);
    mMessageGroup = findViewById(R.id.message_group);

    Button sendButton = findViewById(R.id.send_button);
    sendButton.setOnClickListener(v -> showOutput());
  }

  private void showOutput() {
    // get urgent flag value
    boolean urgent = mUrgentCheckBox.isChecked();
    // get the selected message text
    String message;
    switch (mMessageGroup.getCheckedRadioButtonId()) {
      case R.id.purr_button:
        message = getString(R.string.cat_purr);
        break;
      case R.id.mew_button:
        message = getString(R.string.cat_mew);
        break;
      case R.id.hiss_button:
        message = getString(R.string.cat_hiss);
        break;
      default:
        message = getString(R.string.undefined);
    }
    // open the activity, showing the message
    Intent intent = new Intent(this, OutputActivity.class);
    intent.putExtra(OutputActivity.URGENT_FLAG_KEY, urgent);
    intent.putExtra(OutputActivity.MESSAGE_TEXT_KEY, message);
    startActivity(intent);
  }
}
