package com.adiron.myfirstapplication;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;


public class TextRec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_text_rec);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // קבלת ה-Uri מה-Intent
        Intent intent = getIntent();
        Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);

        if (imageUri != null) {
            try {
                InputImage image = InputImage.fromFilePath(this, imageUri);
                TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);


                recognizer.process(image)
                        .addOnSuccessListener(visionText -> {
                            String resultText = visionText.getText();
                            Log.d("TextRecognition", "זיהוי טקסט מוצלח: " + resultText);
                            for (Text.TextBlock block : visionText.getTextBlocks()) {
                                for (Text.Line line : block.getLines()) {
                                    for (Text.Element element : line.getElements()) {
                                        Log.d("TextElement", element.getText());
                                    }
                                }
                            }
                        })
                        .addOnFailureListener(e -> {
                            Log.e("TextRecognition", "שגיאה בזיהוי טקסט", e);
                        });
            } catch (Exception e) {
                Log.e("TextRecognition", "שגיאה בקריאת קובץ תמונה", e);
            }
        } else {
            Log.e("TextRecognition", "לא התקבל Uri מה-Intent");
        }
    }
}
