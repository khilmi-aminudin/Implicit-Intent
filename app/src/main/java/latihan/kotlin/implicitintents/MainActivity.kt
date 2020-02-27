package latihan.kotlin.implicitintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnUrl = findViewById<Button>(R.id.open_website_button)
        val btnLoc = findViewById<Button>(R.id.open_location_button)
        val btnText= findViewById<Button>(R.id.share_text_button)

        btnUrl.setOnClickListener {
            Toast.makeText(this,"Open Web Page",Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.javatpoint.com/"))
            startActivity(Intent.createChooser(intent,"Choose The Browser :"))
        }

        btnLoc.setOnClickListener {
            Toast.makeText(this,"Share Location",Toast.LENGTH_SHORT).show()
        }

        btnText.setOnClickListener {
            Toast.makeText(this,"Succes Send Text",Toast.LENGTH_SHORT).show()
            val message = findViewById<EditText>(R.id.share_edittext)
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, message.toString())
            intent.type = "image/jpeg"
            startActivity(Intent.createChooser(intent,"Choose Send To :"))
        }
    }
}
