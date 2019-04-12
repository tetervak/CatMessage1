/* Alex Tetervak, Sheridan College, Ontario */
package ca.javateacher.catmessage1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

  private RadioGroup mMessageGroup;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mMessageGroup = findViewById(R.id.message_group);

    Button sendButton = findViewById(R.id.send_button);
    sendButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        showOutput();
      }
    });
  }

  private void showOutput() {
    // get the selected message
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
    intent.putExtra(OutputActivity.MESSAGE, message);
    startActivity(intent);
  }
}
