package cubex.mahesh.asynctask_jan19

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getImage.setOnClickListener {
                var task = MyTask(iview)
                task.execute()
        }
    }

    class MyTask(var iview:ImageView): AsyncTask<Unit,Unit,Unit>()
    {
        var bmp:Bitmap? = null

        override fun doInBackground(vararg p0: Unit?) {
            var u:URL = URL("https://cdn.wccftech.com/wp-content/uploads/2017/08/download-android-8-740x370.jpg")
            var isr:InputStream = u.openStream()
             bmp= BitmapFactory.decodeStream(isr)
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            iview.setImageBitmap(bmp)
        }
    }



} // MainActivity
