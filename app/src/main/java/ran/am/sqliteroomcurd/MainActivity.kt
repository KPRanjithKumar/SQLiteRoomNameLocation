package ran.am.sqliteroomcurd

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var edname: EditText
    lateinit var edname2: EditText
    lateinit var edloc: EditText
    lateinit var tv: TextView
    lateinit var btnsave: Button
    lateinit var btnretrive: Button
    lateinit var lv: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edname = findViewById(R.id.editTextTextPersonName)
        edname2 = findViewById(R.id.editTextTextPersonName4)
        edloc = findViewById(R.id.editTextTextPersonName2)
        tv = findViewById(R.id.textView)
        btnsave = findViewById(R.id.button)
        btnretrive = findViewById(R.id.button2)

        StudentDatabase.getInstance(applicationContext)

        lv = arrayListOf()

        btnsave.setOnClickListener {
            val name = edname.text.toString()
            val location = edloc.text.toString()
            val s = Student(0, name, location)
            CoroutineScope(IO).launch {
                StudentDatabase.getInstance(applicationContext).StudentDao().insertStudent(s)
            }
            Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT)
                .show();
        }

        btnretrive.setOnClickListener {
            var name = edname2.text.toString()

            CoroutineScope(IO).launch {
                var f = StudentDatabase.getInstance(applicationContext).StudentDao()
                    .getAllUserInfo(name)
                tv.text = f.get(0).location

            }
        }
    }

    fun updatebtn(view: android.view.View) {}
}